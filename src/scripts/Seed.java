package scripts;

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.record.ActivePerson;

public class Seed {

	public static void populateDb(){
		Person person = new Person();
		person.setBrukerNavn("navn");
		person.setPassord("passord");
		ActivePerson.createPerson(person);

		System.out.println("1 person er lagret i databasen");
	}

	public static void main(String[] args){
		populateDb();
	}
}
