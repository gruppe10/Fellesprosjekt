package no.ntnu.fp.model.record;

import no.ntnu.fp.model.Person;

public class Seed {
	
	public static void populateDb(){
		for(int i = 0; i<10; i++){
			Person person = new Person();
			person.setBrukerNavn("navn");
			person.setPassord("passord");
			ActivePerson.createPerson(person);
		}
		System.out.println("10 person er lagret i databasen");
	}
	
	public static void main(String[] args){
		populateDb();
	}
}
