package Server;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Hendelse;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Notis;
import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Project;
import no.ntnu.fp.model.Rom;

public class ObjectManager {

	public Object manageObject(Object o) {
		// TODO Auto-generated method stub
		if( o instanceof Notis){
			//kode for håndtering av sending av notis til db
			System.out.println("notisok");
			return null;
		}
		else if( o instanceof Avtale){
			System.out.println("avtale");
			return null;
		}
		else if( o instanceof Hendelse){
			System.out.println("hendelse");
			return null;
		}
		else if( o instanceof Mote){
			System.out.println("moete");
			return null;
		}
		else if( o instanceof Person){
			System.out.println("person");
			return null;
		}
		else if( o instanceof Project){
			System.out.println("prosjekt");
			return null;
		}
		else if( o instanceof Rom){
			System.out.println("rom");
			return null;
		}
		
		return null;
	}

}
