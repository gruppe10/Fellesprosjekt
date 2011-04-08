package scripts;
import java.rmi.server.ServerCloneException;


public class StartServerAndClient {
	public static void main(String[] args){
		no.ntnu.fp.gui.innlogging.main(null);
		Server.StartServerOS.main(null);
	}
}
