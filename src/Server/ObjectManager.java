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
		if( content instanceof Avtale){
			Avtale avtale =(Avtale)content;
			switch(action){
			case UPDATE:
				if(ActiveHendelse.exists("Hendelse",avtale.getAvtaleId())){
					ActiveHendelse.updateAvtale(avtale);
				}else{
					Avtale avtaleWithNewId = ActiveHendelse.createAvtale(avtale);
					return avtaleWithNewId;
				}
				break;
			case DESTROY:
				ActiveHendelse.deleteHendelse(avtale.getAvtaleId());
				break;
			case SELECT:
				ActiveHendelse.selectAvtale(avtale.getAvtaleId());
				break;
			}
			System.out.println("Recieved and handled Avtale");
		}
		else if(content instanceof Notis){
			//TODO kode for håndtering av sending av notis til db-lagres ikke i databasen
			//deltaker har status
			System.out.println("notisok");
			return "notis mottatt";
		}
		else if(content instanceof Mote){
			Mote mote = (Mote)content;
			switch(action){
			case UPDATE:
				if(ActiveHendelse.exists("Hendelse", mote.getAvtaleId())){
					ActiveHendelse.updateMote(mote);
				}else{
					mote = ActiveHendelse.createMote(mote);
				}
				break;
			case DESTROY:
				ActiveHendelse.deleteHendelse(mote.getAvtaleId());
				break;
			case SELECT:
				mote = (Mote) ActiveHendelse.selectMote(mote.getAvtaleId());
				break;
			}
			System.out.println("Recieved and handled Møte");
			return mote;
		}
		else if( content instanceof Person){	
			Person person = (Person)content;
			switch(action){
			case UPDATE:
				if(ActivePerson.exists("Person", person.getAnsattNummer())){
					ActivePerson.createPerson(person);
				}else{
					ActivePerson.updatePerson(person);
				}
				break;
			case SELECT:
				if(person.getAnsattNummer() != null)
					person = ActivePerson.selectPerson(person.getAnsattNummer());
				else if(person.getBrukerNavn() != null)
					person = ActivePerson.selectPersonByUsername(person.getBrukerNavn());
				break;
			case DESTROY:
				ActivePerson.deletePerson(person.getAnsattNummer());
				break;
			}
			System.out.println("Recieved and handled person");
			return person;
		}
		else if( content instanceof Rom){
			System.out.println("rom");
			return null;
		}
		else if( content instanceof String){
			System.out.println("EG FIKK EN StREng : OMg!");
			String string = (String)content;
			boolean approved = ActivePerson.checkPassord(string);
			return approved;
		}
		return null;
	}
}