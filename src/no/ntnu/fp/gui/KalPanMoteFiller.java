package no.ntnu.fp.gui;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Person;
public class KalPanMoteFiller extends Mote{


	private Avtale avtale;
	
	public KalPanMoteFiller(Avtale m) {
		avtale=m;
		setStarttid(m.getStarttid());
		setSluttid(m.getSluttid());
		setDato(m.getDatoDag(), m.getDatoMnd(), m.getDatoAar());
		setBeskrivelse(m.getBeskrivelse());
		setNavn(m.getNavn());
		
	}

	public Mote getAvtale() {
		return (Mote)avtale;
	}

	public void setAvtale(Avtale avtale) {
		this.avtale = avtale;
	}

	public String toString() {
		return "";
	}
}
