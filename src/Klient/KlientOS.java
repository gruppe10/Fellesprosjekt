package Klient;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class KlientOS {
	private int port;
	private String serverAddress;
	private Socket socket = null;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public KlientOS(int port, String serverAdress){
		this.port = port;
		this.serverAddress = serverAdress;
	}
	
	public Object sendObjectAndGetResponse(Object obj){
		while(true){
			try{
				socket = new Socket(serverAddress, port);
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
				
				oos.writeObject(obj);
				Object tmpObject = ois.readObject();
				return tmpObject;
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
	}

}
