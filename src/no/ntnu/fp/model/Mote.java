package no.ntnu.fp.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mote extends Avtale implements Serializable{
	
	
	private static Map<Person, Status> deltakere = new HashMap<Person, Status>();
	
	public Mote(String navn, String beskrivelse, Person initiativtaker, int starttid, 
			int sluttid, int datoDag, int datoMnd, int datoAar, Rom rom, Map<Person, Status> deltakere){
		super(navn, beskrivelse, initiativtaker, starttid, sluttid, datoDag, datoMnd, datoAar, rom);
		this.deltakere = deltakere;
		
		for (Person deltaker : deltakere.keySet()){
			sendInnkallelse(deltaker, this, "invitasjon");
		}
		
	}
	
	public Mote (){
		super();
		
	}

	
	public static Map<Person, Status> getDeltakere() {
		return deltakere;
	}
	
	public Notis sendInnkallelse(Person mottaker, Mote mote, String beskjed){
		return new Notis(mottaker, mote, beskjed);
	}

	public void leggtilDeltaker(Person deltaker){
		deltakere.put(deltaker, Status.IKKE_MOTTATT);
	}
	
	public void slettDeltaker(Person deltaker){
		deltakere.remove(deltaker);
	}
	
	public Status getStatus(Person deltaker){
		return deltakere.get(deltaker);
	}
	
	public void setStatus(Person deltaker, Status status){
		deltakere.put(deltaker, status);
	}
}
