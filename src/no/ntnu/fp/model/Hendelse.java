package no.ntnu.fp.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Hendelse implements Serializable{

	private int starttid, sluttid;
	
	private Date dato;
	
	private String tittel;
	private String beskrivelse;
	
	private Person initiativtaker;
}
