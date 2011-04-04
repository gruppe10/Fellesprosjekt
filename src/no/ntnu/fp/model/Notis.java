package no.ntnu.fp.model;

import java.io.Serializable;

public class Notis implements Serializable{
	
	private Person mottaker;
	public Person getMottaker() {
		return mottaker;
	}

	public Mote getMote() {
		return mote;
	}

	public String getBeskjed() {
		return beskjed;
	}

	private Mote mote;
	private String beskjed;	
	
	final String ENDRET = "Møtet: " +getMote() +", er endret";
	final String SLETTET = "Møtet: " + getMote() +", er slettet";
	final String MELDTAVBUD = " har meldt avbud til møte: " + getMote();
	final String INVITASJON = "Du er lagt til som deltaker i møte: " + getMote();
	
//	Konstruktør som brukes dersom et møte er endret, slettet eller det er et nytt møte
	public Notis(Person mottaker, Mote mote, String beskjed){
		
		if(beskjed.equalsIgnoreCase("endret")){
			this.beskjed = ENDRET;
		}else if(beskjed.equalsIgnoreCase("slettet")){
			this.beskjed = SLETTET;
		}else if(beskjed.equalsIgnoreCase("invitasjon")){
			this.beskjed = INVITASJON;
		}else {
			this.beskjed = beskjed;
			}
		
		this.mottaker = mottaker;
		this.mote = mote;
	}
	
//	Konstruktør som brukes dersom en deltaker har meldt avbud
	public Notis(Person mottaker, Mote mote, String beskjed, Person deltaker){
		this.mottaker = mottaker;
		this.mote = mote;
		
		if(beskjed.equalsIgnoreCase("meldtavbud")){
			this.beskjed = deltaker+ MELDTAVBUD;
		}else{
			this.beskjed = beskjed;
		}
	}
	
}
