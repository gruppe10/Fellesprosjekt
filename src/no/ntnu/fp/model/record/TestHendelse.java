package no.ntnu.fp.model.record;

import java.util.Date;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.record.*;

public class TestHendelse {
	public static void main(String args[]){
		//testCeateDeltagereMedStatus();
		//testCrudForAvtale();
		testCrudForMote();
	}
	
	
/******************************
*  			Tester			  *
******************************/
	
//	private void testCreatePerson(){
//		Avtale avtale = mockAvtaleWithId(10001);
//
//		createAvtale(avtale);
//	}	
	
	private static Avtale mockAvtaleWithId(int id){
		Avtale avtale = new Avtale();
		Person sjef = new Person("Sjef", "sjef@mail.com", new Date(100, 15, 12)) ;
		sjef.setBrukerNavn("sjef");
		sjef.setPassord("passord");
		
		ActivePerson.createPerson(sjef);
		System.out.println("Id:" + sjef.getAnsattNummer());
		
		avtale.setAvtaleId(id);
		avtale.setNavn("Annet navn!");
		avtale.setDato(01, 22, 2011);
		avtale.setStarttid(12);
		avtale.setSluttid(12);
		avtale.setBeskrivelse("Dette er en avtale");
		avtale.setInitiativtaker(sjef);
		return avtale;
	}
	
	private static Avtale mockAvtale(){
		Person sjef = new Person("Sjef", "sjef@mail.com", new Date(100, 15, 12)) ;
		sjef.setBrukerNavn("sjef");
		sjef.setPassord("passord");
		ActivePerson.createPerson(sjef);
		System.out.println("Id:" + sjef.getAnsattNummer());
		
		Avtale avtale = new Avtale();
		avtale.setInitiativtaker(sjef);
		avtale.setNavn("Annet navn!");
		avtale.setDato(01, 22, 2011);
		avtale.setStarttid(12);
		avtale.setSluttid(12);
		avtale.setBeskrivelse("Dette er en avtale");
		return avtale;
	}
	
	private static Mote mockMote(){
		Person sjef = new Person("Sjef", "sjef@mail.com", new Date(100, 15, 12)) ;
		sjef.setBrukerNavn("sjef");
		sjef.setPassord("passord");
		ActivePerson.createPerson(sjef);
		System.out.println("Id:" + sjef.getAnsattNummer());
		
		Mote mote = new Mote();
		mote.setInitiativtaker(sjef);
		mote.setNavn("Annet navn!");
		mote.setDato(01, 22, 2011);
		mote.setStarttid(12);
		mote.setSluttid(12);
		mote.setBeskrivelse("Dette er en avtale");
		
		Person deltaker = new Person("name","email", new Date(12,12,12));	
		deltaker.setBrukerNavn("ble");
		deltaker.setPassord("bla");
		ActivePerson.createPerson(deltaker);
		mote.leggtilDeltaker(deltaker);
		return mote;
	}
	
	private static void testUpdateAvtale(){
		Avtale avtale = mockAvtaleWithId(10003);
		avtale.setNavn("Avtale nr 1");
		ActiveHendelse.createAvtale(avtale);
		System.out.println("Avtale 1 er lagret med navn:" + avtale.getNavn());
		
		avtale.setNavn("Avtale nr 2");
		ActiveHendelse.updateAvtale(avtale);
		System.out.println("Avtale 2 er lagret med navn:" + avtale.getNavn());
	}

	private static void testSelectAvtale(){
		int ansattnr = 10002;
		Avtale avtale = ActiveHendelse.selectAvtale(ansattnr);

		System.out.println("Avtalen har navnet:" + avtale.getNavn() + ".");
	}
	
	private static void testCrudForAvtale(){
		Avtale avtale = mockAvtale();
		avtale.setNavn("Avtale 1");
		ActiveHendelse.createAvtale(avtale);
		System.out.println("Lagret avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() + "og id:" + avtale.getAvtaleId());
		
		ActiveHendelse.deleteHendelse(avtale.getAvtaleId());
		System.out.println("Slette avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() +  "og id:" + avtale.getAvtaleId());
		
		ActiveHendelse.createAvtale(avtale);
		System.out.println("Lagret på nytt avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() +  "og id:" + avtale.getAvtaleId());
		
		avtale = ActiveHendelse.selectAvtale(avtale.getAvtaleId());
		System.out.println("Hentet ut avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() +  "og id:" + avtale.getAvtaleId());
		
		avtale.setNavn("Avtale 2");
		ActiveHendelse.updateAvtale(avtale);
		System.out.println("Oppdaterte avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() +  "og id:" + avtale.getAvtaleId());
		
		avtale = ActiveHendelse.selectAvtale(avtale.getAvtaleId());
		System.out.println("Hentet ut avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() +  "og id:" + avtale.getAvtaleId());
	}
	
	private static void testCrudForMote(){
		Mote mote = mockMote();
		ActiveHendelse.createMote(mote);
		System.out.println("Lagret avtale med navn: " + mote.getNavn() + ", beskrivelse lik: " + mote.getBeskrivelse() + "og id:" + mote.getAvtaleId());
		
//		ActiveHendelse.deleteHendelse(mote.getAvtaleId());
//		System.out.println("Slette avtale med navn: " + mote.getNavn() + ", beskrivelse lik: " + mote.getBeskrivelse() +  "og id:" + mote.getAvtaleId());
//		
//		ActiveHendelse.createMote(mote);
//		System.out.println("Lagret på nytt avtale med navn: " + mote.getNavn() + ", beskrivelse lik: " + mote.getBeskrivelse() +  "og id:" + mote.getAvtaleId());
		
		mote = ActiveHendelse.selectMote(mote.getAvtaleId());
		System.out.println("Hentet ut avtale med navn: " + mote.getNavn() + ", beskrivelse lik: " + mote.getBeskrivelse() +  "og id:" + mote.getAvtaleId());
		
//		mote.setNavn("Avtale 2");
//		ActiveHendelse.updateMote(mote);
//		System.out.println("Oppdaterte avtale med navn: " + mote.getNavn() + ", beskrivelse lik: " + mote.getBeskrivelse() +  "og id:" + mote.getAvtaleId());
//		
//		mote = ActiveHendelse.selectMote(mote.getAvtaleId());
//		System.out.println("Hentet ut avtale med navn: " + mote.getNavn() + ", beskrivelse lik: " + mote.getBeskrivelse() +  "og id:" + mote.getAvtaleId());
	}
	
	private static void testCeateDeltagereMedStatus(){
		Mote mote = mockMote();		
		ActiveHendelse.createMote(mote);
		System.out.println("testUtført");
	}
}

