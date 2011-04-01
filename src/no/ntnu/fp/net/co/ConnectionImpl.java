/*
 * Skrevet av  gruppe 10, mars 2011
 */
package no.ntnu.fp.net.co;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
		//    	Opprett en Connection vha Abstract Connection, sett riktig port og adresse
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

		//    	Angir korrekte detaljer om server
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
		}

		this.state = State.SYN_SENT;
		KtnDatagram recieved = receiveAck();

		//    	Dersom den mottatte ACK er den vi venter på, har vi tilkobling
		if (isValid(recieved)){
			System.out.println("C");
			this.remotePort = recieved.getSrc_port();
			lastValidPacketReceived = recieved;

			sendAck(recieved, false);
			state = State.ESTABLISHED;

			//		Dersom den mottatte ACK ikke er den vi venter på, har vi ingen tilkobling og går til tilstand CLOSED
		}
		else{
			System.out.println("D");
			state = State.CLOSED;			
		}


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
		int synackTries = 5;
		//       Lytte etter innkommende syn-pakke
		this.state = State.LISTEN;

		KtnDatagram syn = null;
		while(!isValid(syn)){
			syn = receivePacket(true);	
		}

		//      Opprett ny Connection for tilkobling til denne klienten
		ConnectionImpl connection = new ConnectionImpl(myPort);
		connection.remoteAddress = syn.getSrc_addr();
		connection.remotePort = syn.getSrc_port();
		connection.state = State.SYN_RCVD;        


		//      Send synack tilbake til klient. sendAck(true) angir at flagget skal være SYN_ACK. Motta ACK.       
		KtnDatagram ack = null;

		while(!connection.isValid(ack) && synackTries-- > 0){
			connection.sendAck(syn, true);
			ack = connection.receiveAck();

		}
		connection.lastValidPacketReceived = ack;
		this.state = State.CLOSED;

		//		Hvis ack'en vi fikk var bekreftelse på sent synack, har vi en tilkobling.
		if(connection.isValid(ack)){
			connection.state = State.ESTABLISHED;
			return connection;
		}
		else{
			throw new IOException("No valid connection: Didn't receive ACK on SYN_ACK");
		}


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

		//      Fortsetter å sende pakken til vi får bekreftelse på at den er mottatt.
		while (!isValid(ack)){
			ack = sendDataPacketWithRetransmit(toSend); 
			lastDataPacketSent = toSend; 
		}

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

		received = receivePacket(false);

		//		Sjekker om pakken vi mottok var den vi ventet på, og returnerer i såfall denne
		if (isValid(received)){
			lastValidPacketReceived = received;
			sendAck(lastValidPacketReceived, false);
			return (String)lastValidPacketReceived.getPayload();
		}

		//      Dersom det ikke var pakken vi ventet på, sender vi ack på den forrige gyldige mottatte pakken, og fortsette å prøve å motta neste pakke.
		sendAck(lastValidPacketReceived, false);
		return receive();

	}

	/**
	 * Close the connection.
	 * 
	 * @see Connection#close()
	 */

	public void close() throws IOException {
		int finTries = 3;
		if(this.state != State.ESTABLISHED){
			throw new IllegalStateException("Cannot close a connection if not in ESTABLISHED state");
		}
		//      initialisere disconnect (i vårt tilfelle: klient)
		if(disconnectRequest == null){
			KtnDatagram closeRequest = constructInternalPacket(Flag.FIN);
			KtnDatagram ack = null;
			KtnDatagram fin = null;

			//        	  Fortsette å sende FIN til vi får bekreftelse på at det er mottatt
			while(!isValid(ack)) {
				try {
					simplySendPacket(closeRequest);
					this.state = State.FIN_WAIT_1;
					ack = receiveAck();
				} catch (ClException e) {
					e.printStackTrace();
				}
			}

			lastValidPacketReceived = ack;

			this.state = State.FIN_WAIT_2;

			//        	  Vente på FIN fra klient
			while(!isValid(fin)){
				try{
					fin = receivePacket(true);
				}catch (Exception e) {
				}
			}

			lastValidPacketReceived = fin;

			//        	  Send bekreftelse på at vi har mottatt FIN, og lukk tilkoblingen.
			sendAck(fin, false);
			this.state = State.TIME_WAIT;
			this.state = State.CLOSED;
		}

		//      svare på disconnect-request (i vårt tilfelle: Server)
		else{
			sendAck(disconnectRequest, false);
			state = State.CLOSE_WAIT;

			KtnDatagram fin = constructInternalPacket(Flag.FIN);
			KtnDatagram finack=null;

			//        	Send FIN til server og vent på bekreftelse
			while(!isValid(finack) && finTries-->0){
				try {
					simplySendPacket(fin);
					state = State.LAST_ACK;
				} catch (ClException e) {
					e.printStackTrace();
				}
				finack = receiveAck();
			}

			//        	Lukk tilkoblingen
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

		//    	Kontroller evt bitfeil
		if (packet.calculateChecksum() != packet.getChecksum()) return false;


		//    	Kontroller om pakken har gyldig flagg ift tilstand. Pakker med ulik avsender-adresse eller -port enn forventet blir forkastet.
		switch (state) {
		case CLOSED: break;
		case SYN_SENT: return (packet.getFlag() == Flag.SYN_ACK 
				&& packet.getSrc_addr().equals(remoteAddress) && packet.getSrc_port() == remotePort);
		case LISTEN: return (packet.getFlag() == Flag.SYN);
		case SYN_RCVD: return (packet.getFlag() == Flag.ACK 
				&& packet.getSrc_addr().equals(remoteAddress) && packet.getSrc_port() == remotePort);
		case ESTABLISHED: return ((packet.getFlag()==Flag.NONE || packet.getFlag()==Flag.ACK || packet.getFlag()==Flag.FIN)
				&& (packet.getFlag() == Flag.NONE || packet.getAck() == lastDataPacketSent.getSeq_nr())
				&& (packet.getFlag() == Flag.ACK || packet.getSeq_nr() > lastValidPacketReceived.getSeq_nr()) &&
				packet.getSrc_addr().equals(remoteAddress) && packet.getSrc_port() == remotePort);
		case FIN_WAIT_1: return (packet.getFlag() == Flag.ACK
				&& packet.getSrc_addr().equals(remoteAddress) && packet.getSrc_port() == remotePort);
		case FIN_WAIT_2: return (packet.getFlag() == Flag.FIN
				&& packet.getSrc_addr().equals(remoteAddress) && packet.getSrc_port() == remotePort);
		case TIME_WAIT: break;
		case CLOSE_WAIT: break;
		case LAST_ACK: return (packet.getFlag() == Flag.ACK 
				&& packet.getSrc_addr().equals(remoteAddress) && packet.getSrc_port() == remotePort);
		}
		return false;

	}
}
