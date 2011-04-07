package scripts;

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Rom;
import no.ntnu.fp.model.record.ActiveModel;
import no.ntnu.fp.model.record.ActivePerson;
import no.ntnu.fp.model.record.ActiveRom;

public class Seeds {
	public static void populateDb(){
		if (!(ActivePerson.selectPersonByUsername("bruker").getAnsattNummer() == null)){
			Person person = new Person();
			person.setBrukerNavn("bruker");
			person.setPassord("passord");
			ActivePerson.createPerson(person);


			Person person2 = new  Person();
			person.setBrukerNavn("Ole");
			person.setPassord("passord");
			ActivePerson.createPerson(person2);

			Person person3 = new  Person();
			person.setBrukerNavn("Dole");
			person.setPassord("passord");
			ActivePerson.createPerson(person3);

			Person person4 = new  Person();
			person.setBrukerNavn("Doffen");
			person.setPassord("passord");
			ActivePerson.createPerson(person4);

			System.out.println("4 person er lagret i databasen");

			Rom rom = new Rom("Drivhuset");
			ActiveRom.createRom(rom);
			Rom rom2 = new Rom("Glassgarden");
			ActiveRom.createRom(rom2);
			Rom rom3 = new Rom("Fasaden");
			ActiveRom.createRom(rom3);
			Rom rom4 = new Rom("P15");
			ActiveRom.createRom(rom4);
			System.out.println("4 rom er lagret i databasen");
		}
		else {
			System.out.println("Database er allerede populert");
		}
	}

	public static void main(String[] args){
		populateDb();
	}
}
