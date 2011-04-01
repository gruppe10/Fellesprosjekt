package Server;

public class TestServerOS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerOS serverOS = new ServerOS(6789);
		serverOS.listen();

	}

}
