package no.ntnu.fp.gui;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;
public class KalPanMoteFiller extends Mote{


	private Avtale avtale;
	
	public KalPanMoteFiller(Avtale a) {
		avtale=a;
	}

	public Avtale getAvtale() {
		return avtale;
	}

	public void setAvtale(Avtale avtale) {
		this.avtale = avtale;
	}

	public String toString() {
		return "";
	}
}
