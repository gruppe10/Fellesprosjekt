package no.ntnu.fp.gui;

import no.ntnu.fp.model.Avtale;

public class KalPanMoteFiller {


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
