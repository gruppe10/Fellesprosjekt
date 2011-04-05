package Klient;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Person;

public class KlientOS extends TimerTask{
	
	public static int port = 6789;
	public static String serverAddress = "78.91.2.252";
	
	
	public Person updatedPerson = null;
	private Person loginPerson = null;
	private Socket socket = null;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Timer intervalUpdate = new Timer(true);
    private static final KlientOS INSTANCE = new KlientOS();

	
	private KlientOS(){
		intervalUpdate.schedule(this, 100, 100000);
	}
	public static KlientOS getInstance(){
		return INSTANCE;
	}
	public Person getUpdatedPerson(){
		return updatedPerson;
	}
	public void setLoginPerson(Person originalPerson){
		loginPerson = originalPerson;
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

	@Override
	public void run() {
		if(loginPerson != null){
			Envelope toSend = new Envelope(Action.SELECT, loginPerson);
			updatedPerson = (Person)sendObjectAndGetResponse(toSend);
		}
	}

}
