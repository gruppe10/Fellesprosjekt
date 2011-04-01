package no.ntnu.fp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import no.ntnu.fp.model.record.ActiveAvtale;

public class Avtale implements Serializable{

	private int avtaleId;
	private String navn;
	private String beskrivelse;
	private Person initiativtaker;
	private int starttid, sluttid;
	private int datoDag;
	private int datoMnd;
	private int datoAar;
	private Integer lederId;
	private ArrayList<Person> deltakere;

	public Avtale(){
		starttid = sluttid = 0;
		
		navn = beskrivelse = null;
		initiativtaker = null;
		lederId=null;
		//Oppdater database!
	}
	
	public int getAvtaleId(){
		return avtaleId;
	}
	
	public void setAvtaleId(int nyId){
		this.avtaleId = nyId;
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

	public int getDatoDag() {
		return datoDag;
	}
	public int getDatoMnd() {
		return datoMnd;
	}
	public int getDatoAar() {
		return datoAar;
	}
	
	public void setDato(int dag, int mnd, int aar) {
		datoDag=dag;
		datoMnd=mnd;
		datoAar=aar;
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
	
	public String toString() {
		return navn;
	}


	public Calendar getDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getLederId() {
		return lederId;

	}
	public void setLederId(Integer lederId) {
		this.lederId = lederId;
	}
	
	public void selectDeltagere(){
		deltakere = ActiveAvtale.selectDeltagere(avtaleId);
	}
}
