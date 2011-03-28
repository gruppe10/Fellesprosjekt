package no.ntnu.fp.model;

public class Rom {

	private String navn;
	
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getRomId() {
		return romId;
	}

	public void setRomId(int romId) {
		this.romId = romId;
	}

	public int getRomStr() {
		return romStr;
	}

	public void setRomStr(int romStr) {
		this.romStr = romStr;
	}

	private int romId, romStr;
}
