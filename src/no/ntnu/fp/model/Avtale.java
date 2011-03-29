package no.ntnu.fp.model;

import java.util.Date;

public  class Avtale {

	private int starttid, sluttid;
	private Date dato;
	private String tittel;
	private String beskrivelse;
	private Person initiativtaker;
	private String navn;

	public Avtale(){
		starttid = sluttid = 0;
		dato = null;
		tittel = beskrivelse = null;
		initiativtaker = null;
		//Oppdater database!
	}

	public int getStarttid() {
		return starttid;
	}

	public void setStarttid(int starttid) {
		this.starttid = starttid;
		//Oppdater database!
	}

	public int getSluttid() {
		return sluttid;
	}

	public void setSluttid(int sluttid) {
		this.sluttid = sluttid;
		//Oppdater database!
	}

	public Date getDato() {
		return dato;
	}

	public void setDato(Date dato) {
		this.dato = dato;
		//Oppdater database!
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
		//Oppdater database!
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
		//Oppdater database!
	}

	public Person getInitiativtaker() {
		return initiativtaker;
	}

	public void setInitiativtaker(Person initiativtaker) {
		this.initiativtaker = initiativtaker;
		//Oppdater database!
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	
	
	
	
}
