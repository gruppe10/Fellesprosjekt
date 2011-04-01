package Server;

import java.net.ServerSocket;

public class ServerOS {
	private ServerSocket welcomeSocket;
	private int port;
	
	public ServerOS(int port){
		this.port = port;
	}
	
	public void listen(){
		try{
			welcomeSocket = new ServerSocket(port);
			System.out.println("startet server");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		while(true){
			KlientManagerOS klientManagerOS;
			try{
				klientManagerOS = new KlientManagerOS(welcomeSocket.accept());
				Thread t = new Thread(klientManagerOS);
				t.start();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	protected void finalize(){
		try{
			welcomeSocket.close();
		}
		catch(Exception e){
			System.out.println("kunne ikke lukke socket");
			System.exit(-1);
		}
	}

}
