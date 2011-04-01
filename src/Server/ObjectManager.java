package Server;

import java.sql.SQLException;

import Klient.Action;
import Klient.Envelope;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Hendelse;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Notis;
import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Project;
import no.ntnu.fp.model.Rom;
import no.ntnu.fp.model.record.*;

public class ObjectManager {

	public Object manageObject(Object o) {
		Envelope e = (Envelope)o;
		
		Object content = e.getContent();
		Action action = e.getAction();
	
		if( content instanceof Avtale){
			Avtale avtale =(Avtale)content;
			switch(action){
				case UPDATE:
					
					break;
				case DESTROY:
					ActiveAvtale.deleteAvtale(avtale.getAvtaleId());
					break;
			}
			System.out.println("avtale");
			return null;
		}
		else if( content instanceof Mote){
			System.out.println("moete");
			return null;
		}
		else if( content instanceof Person){

			ActivePerson.createPerson((Person)o);
			
			System.out.println("person");
			return null;
		}
		else if( content instanceof Rom){
			System.out.println("rom");
			return null;
		}
		
		return null;
	}

}
