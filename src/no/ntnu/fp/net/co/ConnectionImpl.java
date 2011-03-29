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

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
 * @author Sebj¿rn Birkeland and Stein Jakob Nordb¿
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
     * @throws ClException 
     * @see Connection#connect(InetAddress, int)
     */
    public void connect(InetAddress remoteAddress, int remotePort) throws IOException,
            SocketTimeoutException, ClException {
        
    	this.remoteAddress = remoteAddress.getHostAddress();
    	this.remotePort = remotePort;
    	
    	if(this.state != State.CLOSED){
    		throw new IllegalStateException("Object cannot initialize contact with another when not in CLOSED state");
    	}
    	
    	KtnDatagram synRequest = constructInternalPacket(Flag.SYN);
    	
    	simplySendPacket(synRequest);
    	this.state = State.SYN_SENT;
		KtnDatagram recieved = receiveAck();
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
        this.state = State.LISTEN;
        
        KtnDatagram syn = null;
        try{
        	syn = receivePacket(true);
        	
        }catch (Exception e) {
			// TODO: handle exception
		}
       
        int newPort = (int)(Math.random() * 10000 + 1);
        ConnectionImpl connection = new ConnectionImpl(newPort);
        usedPorts.put(newPort, true);
        connection.remoteAddress = syn.getSrc_addr();
        connection.remotePort = syn.getSrc_port();
        
        
//      Send synack tilbake
        if (syn.getFlag() != null && syn.getFlag() == Flag.SYN){
        	connection.state = State.SYN_RCVD;
        	sendAck(syn, true);
        }
        
        KtnDatagram ack = receiveAck();
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
           
    	KtnDatagram toSend = constructDataPacket(msg);
        KtnDatagram ack = null;
        
        while (!isValid(ack)){
        	ack = sendDataPacketWithRetransmit(toSend);
        }    
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
        try {
        	received = receivePacket(true);
        }catch (Exception e) {
			// TODO: handle exception
		}
        if (received.getPayload() != null){
        	return (String) received.getPayload();
        }
        return null;
    }

    /**
     * Close the connection.
     * 
     * @see Connection#close()
     */
    public void close() throws IOException {
        if(this.state != State.ESTABLISHED){
        	throw new IllegalStateException("Cannot close a connection withouth being connected");
        }
//        initialisere disconnect
        if(disconnectRequest == null){
        	  KtnDatagram closeRequest = constructInternalPacket(Flag.FIN), ack = null, fin = null;
        	  while(ack==null) {
        		  ack = sendDataPacketWithRetransmit(closeRequest);
        	  }
        	  
        	  this.state = State.FIN_WAIT_2;
        	  
        	  while(fin == null){
        		  try{
        			  fin = receivePacket(true);
        		  }catch (Exception e) {
					// TODO: handle exception
				}
        	  }
        	  
        	  sendAck(fin, false);
        	  this.state = State.TIME_WAIT;
        	  this.state = State.CLOSED;
        }
//        svare på disconnect
        else{
        	sendAck(disconnectRequest, false);
        	this.state = State.CLOSE_WAIT;
        	
        	KtnDatagram fin = constructInternalPacket(Flag.FIN), finack=null;
        	
        	while(finack==null){
        		finack = sendDataPacketWithRetransmit(fin);
        	}
        	
        	this.state = State.CLOSED;
        	
        	
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
//        Sjekk checksum
    	
    }
}
