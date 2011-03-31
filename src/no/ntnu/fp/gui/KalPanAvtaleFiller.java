package no.ntnu.fp.gui;

import no.ntnu.fp.model.Avtale;

public class KalPanAvtaleFiller extends Avtale{


	private Avtale avtale;
	
	public KalPanAvtaleFiller(Avtale a) {
		setStarttid(a.getStarttid());
		setSluttid(a.getSluttid());
		setDato(a.getDatoDag(), a.getDatoMnd(), a.getDatoAar());
		setBeskrivelse(a.getBeskrivelse());
		setNavn(a.getNavn());
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
