package no.ntnu.fp.model;

import java.io.Serializable;

public class Notis implements Serializable{
	
	private Person mottaker;
	private Mote mote;
	private String beskjed;	
	
	final String ENDRET = "Møtet er endret";
	final String SLETTET = "Møtet er slettet";
	final String MELDTAVBUD ="Deltaker har meldt avbud";
	
	public Notis(Person mottaker, Mote mote, String beskjed){
		this.mottaker = mottaker;
		this.mote = mote;
		this.beskjed = beskjed;
	}

}
