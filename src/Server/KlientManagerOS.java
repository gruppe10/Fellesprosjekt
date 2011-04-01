package Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class KlientManagerOS implements Runnable {
	private Socket klient;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ObjectManager objektManager;

	public KlientManagerOS(Socket klient) {
		//db connection her spør Eirik ;)
		this.klient = klient;
		objektManager = new ObjectManager();
	}

	@Override
	public void run() {
		try{
			ois = new ObjectInputStream(klient.getInputStream());
			oos = new ObjectOutputStream(klient.getOutputStream());
			Object objectIn = ois.readObject();
			Object objectOut = objektManager.manageObject(objectIn);
			oos.writeObject(objectOut);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
