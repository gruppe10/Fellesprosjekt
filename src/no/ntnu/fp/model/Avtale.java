package no.ntnu.fp.model;

import java.util.Date;

public abstract class Avtale {

	private int starttid, sluttid;
	
	private Date dato;
	
	private String tittel;
	private String beskrivelse;
	
	private Person initiativtaker;

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public Person getInitiativtaker() {
		return initiativtaker;
	}

	public void setInitiativtaker(Person initiativtaker) {
		this.initiativtaker = initiativtaker;
	}
	
	
}
