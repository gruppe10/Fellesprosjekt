package no.ntnu.fp.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Klient.KlientOS;

public class Mote extends Avtale implements Serializable{
	
	
	private static Map<Person, Boolean> deltakere = new HashMap<Person, Boolean>();
	
	public Mote(String navn, String beskrivelse, Person initiativtaker, int starttid, 
			int sluttid, int datoDag, int datoMnd, int datoAar, Rom rom, Map<Person, Boolean> deltakere){
		super(navn, beskrivelse, initiativtaker, starttid, sluttid, datoDag, datoMnd, datoAar, rom);
		
		this.deltakere = deltakere;
	}
	
	public Mote (){
		super();
		
	}

	
	public static Map<Person, Boolean> getDeltakere() {
		return deltakere;
	}

	public void leggtilDeltaker(Person deltaker){
		deltakere.put(deltaker, true);
	}
	
	public void slettDeltaker(Person deltaker){
		deltakere.remove(deltaker);
	}
	
	public boolean getStatus(Person deltaker){
		return deltakere.get(deltaker);
	}
	
	public void setStatus(Person deltaker, Boolean status){
		deltakere.put(deltaker, status);
	}
}
