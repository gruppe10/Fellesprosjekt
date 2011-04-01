package Klient;

import no.ntnu.fp.model.Notis;

public class TestKlientOS {
	public static void main(String[] args){
		KlientOS c = new KlientOS(6789 ,"78.91.59.96");
		Notis n = new Notis(null, null, "ldfh");
		c.sendObjectAndGetResponse(n);
	}

}
