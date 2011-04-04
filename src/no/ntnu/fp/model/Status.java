package no.ntnu.fp.model;

public enum Status {
	GODTATT, AVSLATT, IKKE_MOTTATT;
	
	public String toString(){		
		String str = "";
		if(this == GODTATT){
			str = "GODTATT";
		}
		else if(this == AVSLATT){
			str = "AVSLATT";
		}
		else if(this == IKKE_MOTTATT){
			str = "IKKE_MOTTATT";
		}
		return str;
	}
}

