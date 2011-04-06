package Klient;

import no.ntnu.fp.model.Notis;

public class TestKlientOS {
	public static void main(String[] args){
<<<<<<< HEAD
		KlientOS c = new KlientOS(6789 ,"78.91.56.199");
=======
		KlientOS c = KlientOS.getInstance();
>>>>>>> 06cf7382d0d40b5a6ca732d537a6ecd6949441f9
		Notis n = new Notis(null, null, "ldfh");
		Envelope toSend = new Envelope(Action.SELECT, n);
		c.sendObjectAndGetResponse(toSend);
	}

}
