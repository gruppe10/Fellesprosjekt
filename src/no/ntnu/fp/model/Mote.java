package no.ntnu.fp.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mote extends Avtale implements Serializable{
	
	private Rom moterom;
	private static Map<Person, Boolean> deltakere = new HashMap<Person, Boolean>();
	
	public Mote(){
		moterom = null;
		deltakere = null;
	}

	public Rom getMoterom() {
		return moterom;
	}

	public void setMoterom(Rom moterom) {
		this.moterom = moterom;
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
