package no.ntnu.fp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import Klient.Action;
import Klient.Envelope;
import Klient.KlientOS;

import no.ntnu.fp.model.record.ActiveHendelse;

public class Avtale implements Serializable{

	private Integer avtaleId;
	private String navn;
	private String beskrivelse;
	private Person initiativtaker;
	private int starttid, sluttid;
	private int datoDag;
	private int datoMnd;
	private int datoAar;
	private Rom rom;
	private Map<Person,Status> deltakereMedStatus;
	
	public Avtale(String navn, String beskrivelse, Person initiativtaker, int starttid, int sluttid, int datoDag, int datoMnd, int datoAar, Rom rom){
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.initiativtaker = initiativtaker;
		this.starttid = starttid;
		this.sluttid = sluttid;
		this.datoDag = datoDag;
		this.datoMnd = datoMnd;
		this.datoAar = datoAar;
		this.rom = rom;
		if (!(this instanceof Mote)) {
			KlientOS klient = KlientOS.getInstance();
			Envelope e = new Envelope(Action.UPDATE, this);
			this.avtaleId = ((Avtale)klient.sendObjectAndGetResponse(e)).getAvtaleId();
		}
		
	}
	public Avtale(int id, String navn, String beskrivelse, Person initiativtaker, int starttid, int sluttid, int datoDag, int datoMnd, int datoAar, Object rom){
		this.avtaleId = id;
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.initiativtaker = initiativtaker;
		this.starttid = starttid;
		this.sluttid = sluttid;
		this.datoDag = datoDag;
		this.datoMnd = datoMnd;
		this.datoAar = datoAar;
		if (!(this instanceof Mote)) {
			KlientOS klient = KlientOS.getInstance();
			klient.sendObjectAndGetResponse(this);
		}
	}
	public Avtale(){
		starttid = sluttid = 0;
		
		navn = beskrivelse = null;
		initiativtaker = null;
		//Oppdater database!
	}
	
	public Integer getAvtaleId(){
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
	
	
	public void selectDeltagereMedStatus(){
		deltakereMedStatus = ActiveHendelse.selectDeltakereMedStatus(avtaleId);
	}
	
	public Rom getMoterom() {
		return rom;
	}

	public void setMoterom(Rom moterom) {
		this.rom = moterom;
	}
	
	public void update(int starttid,int sluttid, int dag, int mnd, int aar, String navn, String beskrivelse, Rom moterom) {
		this.starttid = starttid;
		this.sluttid = sluttid;
		datoDag=dag;
		datoMnd=mnd;
		datoAar=aar;
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.rom = moterom;
		if (!(this instanceof Mote)) {
			KlientOS klient = KlientOS.getInstance();
			Envelope e = new Envelope(Action.UPDATE, this);
			klient.sendObjectAndGetResponse(e);
		}
		
	}

}
