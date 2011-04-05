package Klient;

import no.ntnu.fp.model.Notis;

public class TestKlientOS {
	public static void main(String[] args){
		KlientOS c = KlientOS.getInstance();
		Notis n = new Notis(null, null, "ldfh");
		Envelope toSend = new Envelope(Action.SELECT, n);
		c.sendObjectAndGetResponse(toSend);
	}

}
