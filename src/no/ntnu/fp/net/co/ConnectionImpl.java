/*
 * Created on Oct 27, 2004
 */
package no.ntnu.fp.net.co;

import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


import no.ntnu.fp.net.admin.Log;
import no.ntnu.fp.net.cl.ClException;
import no.ntnu.fp.net.cl.ClSocket;
import no.ntnu.fp.net.cl.KtnDatagram;
import no.ntnu.fp.net.cl.KtnDatagram.Flag;

/**
 * Implementation of the Connection-interface. <br>
 * <br>
 * This class implements the behaviour in the methods specified in the interface
 * {@link Connection} over the unreliable, connectionless network realised in
 * {@link ClSocket}. The base class, {@link AbstractConnection} implements some
 * of the functionality, leaving message passing and error handling to this
 * implementation.
 * 
 * @author Sebjørn Birkeland and Stein Jakob Nordbø
 * @see no.ntnu.fp.net.co.Connection
 * @see no.ntnu.fp.net.cl.ClSocket
 */
public class ConnectionImpl extends AbstractConnection {

    /** Keeps track of the used ports for each server port. */
    private static Map<Integer, Boolean> usedPorts = Collections.synchronizedMap(new HashMap<Integer, Boolean>());

    /**
     * Initialize initial sequence number and setup state machine.
     * 
     * @param myPort
     *            - the local port to associate with this connection
     */
    public ConnectionImpl(int myPort) {
        super();
        this.myPort = myPort;
        usedPorts.put(myPort, true);
        this.myAddress = getIPv4Address();
        
    }

    private String getIPv4Address() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e) {
            return "127.0.0.1";
        }
    }

    /**
     * Establish a connection to a remote location.
     * 
     * @param remoteAddress
     *            - the remote IP-address to connect to
     * @param remotePort
     *            - the remote port-number to connect to
     * @throws IOException
     *             If there's an I/O error.
     * @throws java.net.SocketTimeoutException
     *             If timeout expires before connection is completed.
     * @see Connection#connect(InetAddress, int)
     */
    public void connect(InetAddress remoteAddress, int remotePort) throws IOException,
            SocketTimeoutException{
        
    	this.remoteAddress = remoteAddress.getHostAddress();
    	this.remotePort = remotePort;
    	
    	if(this.state != State.CLOSED){
    		throw new IllegalStateException("Object cannot initialize contact with another when not in CLOSED state");
    	}
    	
    	KtnDatagram synRequest = null;
    	synRequest = constructInternalPacket(Flag.SYN);
    	
    	try {
			simplySendPacket(synRequest);
		} catch (ClException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.state = State.SYN_SENT;
		
    	KtnDatagram recieved = receiveAck();
    	
    	this.remotePort = receiveAck().getSrc_port();
    	
		if (recieved.getFlag() == Flag.SYN_ACK){
			sendAck(recieved, false);
			state = State.ESTABLISHED;
			return;
		}
			
		
		this.state = State.CLOSED;
    }

    /**
     * Listen for, and accept, incoming connections.
     * 
     * @return A new ConnectionImpl-object representing the new connection.
     * @see Connection#accept()
     */
    public Connection accept() throws IOException, SocketTimeoutException {
        if (this.state != State.CLOSED){
        	throw new IllegalStateException("Cannot accept SYN without being in state CLOSED");
        }
        
//       Lytte etter innkommende syn-pakke, og opprett port for denne tilkoblingen
        this.state = State.LISTEN;
        
        KtnDatagram syn = null;
        System.out.println("22ergergergerge");

        while(syn == null || syn.getFlag()!=Flag.SYN || !isValid(syn)){
        	System.out.println("fewfew");

        	syn = receivePacket(false);
        	
        }
        System.out.println("1ergergergerge");
        ConnectionImpl connection = new ConnectionImpl(myPort);
        usedPorts.put(myPort, true);
        connection.remoteAddress = syn.getSrc_addr();
        connection.remotePort = syn.getSrc_port();
        connection.state = State.SYN_RCVD;
        
//      Send synack tilbake til klient. sendAck(true) angir at flagget skal være SYN_ACK
        
        sendAck(syn, true);
      
        
        KtnDatagram ack = null;
        
        while(ack == null || ack.getFlag() != Flag.ACK){
        	ack = receiveAck();
        }
        connection.state = State.ESTABLISHED;
		return connection;
        
    }

    /**
     * Send a message from the application.
     * 
     * @param msg
     *            - the String to be sent.
     * @throws ConnectException
     *             If no connection exists.
     * @throws IOException
     *             If no ACK was received.
     * @see AbstractConnection#sendDataPacketWithRetransmit(KtnDatagram)
     * @see no.ntnu.fp.net.co.Connection#send(String)
     */
    public void send(String msg) throws ConnectException, IOException {
        if(msg==null) return; 
        
    	KtnDatagram toSend = constructDataPacket(msg);
        KtnDatagram ack = null;
        
        while (ack == null || !isValid(ack)){
        	ack = sendDataPacketWithRetransmit(toSend);
        }
        lastDataPacketSent = toSend;
        lastValidPacketReceived = ack;
    }

    /**
     * Wait for incoming data.
     * 
     * @return The received data's payload as a String.
     * @see Connection#receive()
     * @see AbstractConnection#receivePacket(boolean)
     * @see AbstractConnection#sendAck(KtnDatagram, boolean)
     */
    public String receive() throws ConnectException, IOException {
        if (this.state != State.ESTABLISHED){
        	throw new IllegalStateException("Cannot recieve data when not in state Established");
        }
        
        KtnDatagram received = null;
        while (received == null || !isValid(received)){
        	try {
        		received = receivePacket(false);
        	}catch (Exception e) {
			// TODO: handle exception
        	}
        }
        
        lastValidPacketReceived = received;
        return ( (received.getPayload() != null) ? (String)received.getPayload() : null);
       
    }

    /**
     * Close the connection.
     * 
     * @see Connection#close()
     */
    
    public void close() throws IOException {
        if(this.state != State.ESTABLISHED){
        	throw new IllegalStateException("Cannot close a connection if not in ESTABLISHED state");
        }
//        initialisere disconnect
        if(disconnectRequest == null){
        	  KtnDatagram closeRequest = constructInternalPacket(Flag.FIN), ack = null, fin = null;
        	  while(ack==null || !isValid(ack)) {
        		  ack = sendDataPacketWithRetransmit(closeRequest);
        		  this.state = State.FIN_WAIT_1;
        	  }
        	  
        	  lastValidPacketReceived = ack;
        	  
        	  this.state = State.FIN_WAIT_2;
        	  
        	  while(fin == null || !isValid(fin)){
        		  try{
        			  fin = receivePacket(true);
        		  }catch (Exception e) {
				}
        	  }
        	  
        	  lastValidPacketReceived = fin;
        	  
        	  sendAck(fin, false);
        	  this.state = State.TIME_WAIT;
        	  this.state = State.CLOSED;
        }
//        svare på disconnect-request
        else{
        	sendAck(disconnectRequest, false);
        	state = State.CLOSE_WAIT;
        	
        	KtnDatagram fin = constructInternalPacket(Flag.FIN), finack=null;
        	
        	while(finack==null || !isValid(finack)){
        		finack = sendDataPacketWithRetransmit(fin);
        		state = State.LAST_ACK;
        	}
        	
        	lastValidPacketReceived = finack;
        	state = State.CLOSED;
        	disconnectRequest = null;        	
        }
        
      
        
        
    }

    /**
     * Test a packet for transmission errors. This function should only called
     * with data or ACK packets in the ESTABLISHED state.
     * 
     * @param packet
     *            Packet to test.
     * @return true if packet is free of errors, false otherwise.
     */
    protected boolean isValid(KtnDatagram packet) {
    	if (packet==null) return false;
    	if (packet.calculateChecksum() != packet.getChecksum()) return false;
    	
    	switch (state) {
    	case CLOSED: break;
    	case SYN_SENT: return (packet.getFlag() == Flag.SYN_ACK 
    			&& packet.getSrc_addr() == remoteAddress && packet.getSrc_port() == remotePort);
    	case LISTEN: return (packet.getFlag() == Flag.SYN);
    	case SYN_RCVD: return (packet.getFlag() == Flag.ACK 
    			&& packet.getSrc_addr() == remoteAddress && packet.getSrc_port() == remotePort);
    	case ESTABLISHED: return ((packet.getFlag()==Flag.NONE || packet.getFlag()==Flag.ACK || packet.getFlag()==Flag.FIN) &&
    			packet.getSeq_nr() == this.nextSequenceNo && packet.getSrc_addr() == remoteAddress 
    			&& packet.getSrc_port() == remotePort);
    	case FIN_WAIT_1: return (packet.getFlag() == Flag.ACK
    			&& packet.getSrc_addr() == remoteAddress && packet.getSrc_port() == remotePort);
    	case FIN_WAIT_2: return (packet.getFlag() == Flag.FIN
    			&& packet.getSrc_addr() == remoteAddress && packet.getSrc_port() == remotePort);
    	case TIME_WAIT: break;
    	case CLOSE_WAIT: break;
    	case LAST_ACK: return (packet.getFlag() == Flag.ACK 
    			&& packet.getSrc_addr() == remoteAddress && packet.getSrc_port() == remotePort);
    	}
    	return false;
	
    }
}
