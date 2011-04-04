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
				if(ActiveHendelse.exists(avtale.getAvtaleId())){
					ActiveHendelse.updateAvtale(avtale);
				}else{
					ActiveHendelse.createAvtale(avtale);
				}
				break;
			case DESTROY:
				ActiveHendelse.deleteAvtale(avtale.getAvtaleId());
				break;
			case SELECT:
				ActiveHendelse.selectAvtale(avtale.getAvtaleId());
				break;
			}
		}
		else if( o instanceof Notis){
			//kode for håndtering av sending av notis til db-lagres ikke i databasen
			//deltaker har status
			System.out.println("notisok");
			return null;
		}
		else if( o instanceof Mote){
			Mote mote =(Mote)content;
			switch(action){
			case UPDATE:
				if(ActiveHendelse.exists(mote.getAvtaleId())){
					ActiveHendelse.updateAvtale(mote);
				}else{
					ActiveHendelse.createAvtale(mote);
				}
				break;
			case DESTROY:
				ActiveHendelse.deleteAvtale(mote.getAvtaleId());
				break;
			case SELECT:
				ActiveHendelse.selectAvtale(mote.getAvtaleId());
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

