package no.ntnu.fp.model;

public class Rom {
	
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
		return (//sp�rring mot database om et annet m�te bruker rommet) ? false : true ;
	}
	
	
}
