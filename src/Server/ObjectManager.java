package Server;

import no.ntnu.fp.model.Notis;

public class ObjectManager {

	public Object manageObject(Object o) {
		// TODO Auto-generated method stub
		if( o instanceof Notis){
			//kode for håndtering av sending av notis til db
			System.out.println("notisok");
			return null;
		}
		
		return null;
	}

}
