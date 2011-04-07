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
		System.out.println("Leave me alone!");

		Envelope e = (Envelope)o;

		Object content = e.getContent();
		Action action = e.getAction();
		if(content instanceof Mote){
			System.out.println("Recieved Mote");
			Mote mote = (Mote)content;
			switch(action){
			case CREATE:
				return ActiveHendelse.createMote(mote);
			case UPDATE:
				ActiveHendelse.updateMote(mote);
				break;
			case DESTROY:
				ActiveHendelse.deleteHendelse(mote.getAvtaleId());
				break;
			case SELECT:
				return ActiveHendelse.selectMote(mote.getAvtaleId());
			}
			System.out.println("Handled Mote");
			return mote;
		}
		else if( content instanceof Avtale){
			System.out.println("Recieved Avtale");
			Avtale avtale =(Avtale)content;
			switch(action){
			case CREATE:
				return  ActiveHendelse.createAvtale(avtale);
			case UPDATE:
				ActiveHendelse.updateAvtale(avtale);
				break;
			case DESTROY:
				ActiveHendelse.deleteHendelse(avtale.getAvtaleId());
				break;
			case SELECT:
				return ActiveHendelse.selectAvtale(avtale.getAvtaleId());
			}
			System.out.println("Handled Avtale");
		}
		else if( content instanceof Person){	
			System.out.println("Recieved Person");
			Person person = (Person)content;
			switch(action){
			case CREATE:
				return ActivePerson.createPerson(person);
			case UPDATE:
				ActivePerson.updatePerson(person);
				break;
			case SELECT:
				if(person.getAnsattNummer() != null)
					return person = ActivePerson.selectPerson(person.getAnsattNummer());
				else if(person.getBrukerNavn() != null)
					return person = ActivePerson.selectPersonByUsername(person.getBrukerNavn());
				break;
			case DESTROY:
				ActivePerson.deletePerson(person.getAnsattNummer());
				break;
			}
			System.out.println("Handled Person");
			return person;
		}
		else if( content instanceof Rom){
			System.out.println("rom");
			return null;
		}
		else if( content instanceof String){
			System.out.println("Recieved String");
			switch(action){
			case SELECT:
				if (((String)content).equals("getallpersons")) {
					return ActivePerson.selectAllPersons();
				}
				else if (((String)content).equals("getallrooms")) {
					System.out.println("Prover aa hente ut alle personer");
					return ActiveRom.selectAlleRom();
				}
				break;
			case LOGIN:
				String string = (String)content;
				boolean approved = ActivePerson.checkPassord(string);

				System.out.println("Handled String");
				return approved;			
			}
		}
		return null;
	}
}