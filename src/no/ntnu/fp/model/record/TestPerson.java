package no.ntnu.fp.model.record;

import java.util.ArrayList;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Person;

public class TestPerson {
	public static void main(String args[]){
		//Person person = mockPerson();
		//person.setAnsattNummer(138);
		//ActivePerson.createPerson(person);
        
		testCrud();
		//testSelectAvtaler();
	}
	
	/******************************
	 *              TESTER        *
	 ******************************/
	
	
	private static void testSelectAvtaler(){
		int ansattId = 10;
		ArrayList<Avtale> avtaler = ActivePerson.selectAvtaler(ansattId);
		for (Avtale avtale : avtaler) {
			System.out.println(avtale.getNavn());
		}
		System.out.println("test fullført");
	}
	
	private static void testCrud(){
		Person person = mockPerson();
		
		ActivePerson.createPerson(person);
		System.out.println("Lagrer personen " + person.getName() + " med id=" + person.getAnsattNummer());
	
		ActivePerson.deletePerson(person.getAnsattNummer());
		System.out.println("Sletter personen: "  + person.getName() + " med id=" + person.getAnsattNummer());

		person.setName("Dole");
		ActivePerson.createPerson(person);
		System.out.println("Lagrer personen " + person.getName() + " med id=" + person.getAnsattNummer());
		
		Person nyPerson = ActivePerson.selectPerson(person.getAnsattNummer());
		System.out.println("Henter ut ny person: " + nyPerson.getName() + " med id=" + nyPerson.getAnsattNummer());
		
		nyPerson.setName("Doffen");
		ActivePerson.updatePerson(nyPerson);
		System.out.println("Oppdaterte ny person til: " + nyPerson.getName() + " med id=" + nyPerson.getAnsattNummer());
	}
	
	
	private static Person mockPersonWithId(int ansattId) {
		Person person = new Person();
		person.setAnsattNummer(ansattId);
		person.setBrukerNavn("ole");
		person.setName("Ole");
		person.setPassord("laila");
		
		return person;
	}
	
	private static Person mockPerson() {
		Person person = new Person();
		person.setBrukerNavn("ole");
		person.setName("Ole");
		person.setPassord("laila");
		
		return person;
	}

	private void testUpdatePerson(){
		int ansattId = 10001;
		String navn = "Martin";
		String nyttNavn = "Per-Donald";
		Person person = new Person();
		person.setAnsattNummer(ansattId);
		
		//Hente ut person 10001 som allerede ligger inne
		Person orginalPerson = ActivePerson.selectPerson(person.getAnsattNummer());
		System.out.println("Orginalt navn: " + orginalPerson.getName());
		
		//oppdatere ny person
		orginalPerson.setName(nyttNavn);
		ActivePerson.updatePerson(orginalPerson);
		Person oppdatertPerson = ActivePerson.selectPerson(orginalPerson.getAnsattNummer());
		System.out.println("Nytt navn:" + oppdatertPerson.getName());
	}
	
	
	private void testCreatePerson(){
		Person person = new Person();
		person.setAnsattNummer(10004);
		person.setName("Martin");
		person.setBrukerNavn("martin");
		person.setPassord("1234");
		
		ActivePerson.createPerson(person);
		
		Person nyeperson = ActivePerson.selectPerson(person.getAnsattNummer());
		System.out.println(nyeperson.getName());
	}
	
	
	private void testSelectPerson(){
		int ansattId = 10001;
		Person testPerson  = ActivePerson.selectPerson(ansattId);
		System.out.println(testPerson.getName());
	}

}
