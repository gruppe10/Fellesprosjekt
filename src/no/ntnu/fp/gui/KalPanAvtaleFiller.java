package no.ntnu.fp.gui;

import no.ntnu.fp.model.Avtale;

public class KalPanAvtaleFiller {


	private Avtale avtale;
	
	public KalPanAvtaleFiller(Avtale a) {
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
