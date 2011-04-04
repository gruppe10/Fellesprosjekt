package no.ntnu.fp.model;

public enum Status {
	GODTATT, AVSLATT, IKKEMOTATT;
	
	public String toString(){		
		String str = "";
		if(this == GODTATT){
			str = "GODTATT";
		}
		else if(this == AVSLATT){
			str = "AVSLATT";
		}
		else if(this == IKKEMOTATT){
			str = "IKKEMOTATT";
		}
		return str;
	}
}

