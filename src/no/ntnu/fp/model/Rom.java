package no.ntnu.fp.model;


import java.io.Serializable;

import no.ntnu.fp.model.record.ActiveRom;

public class Rom implements Serializable{
	
	private int romId;
	private String navn;
	private int str;
	
	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public Rom(String navn){
		//this.romId= ActiveRom.getMaxId()+1;
		this.navn = navn;
	
		
//		Hent den nye id'en fra databasen (autogenereres der)
	}

	public int getRomId() {
		return romId;
	}

	public void setRomId(int romId) {
		this.romId = romId;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public boolean checkLedig(String tid){
	/*SELECT starttid,sluttid FROM Mote AS m,ReserverteRom AS rr,Rom AS r
	 * WHERE m.avtaleID=rr.avtaleId AND r.romID=rr.RomID
	 * 
	 */
		return true; //spørring mot database om et annet møte bruker rommet) ? false : true ;
	
	}
	
	
}
