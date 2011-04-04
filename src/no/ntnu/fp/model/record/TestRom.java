package no.ntnu.fp.model.record;

import java.sql.Date;

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Rom;

public class TestRom {
	
	
	
	public static void main(String args[]){
		
		Date testDate = new Date(2011, 2, 31);
		ActiveRom.selectLedigeTider(7,testDate);
		testCrud();
		testCreateReservasjon();
	}

	/******************************
	*  			Tester			  *
	******************************/
	
	private static void testCreateReservasjon(){
		ActiveRom.createReservasjon(1,2);
		ActiveRom.deleteReservasjon(1,2);
		
	}
	
	private static void testCrud(){
		Rom rom = mockRom();
		
//		deleteRom(rom.getRomId());
//		System.out.println("Slettet rom med navn " +rom.getNavn() + " som og har id: " + rom.getRomId());
		
		ActiveRom.createRom(rom);
		System.out.println("Laget rom med navn: " + rom.getNavn() + " som og har id: " + rom.getRomId());
		
		rom.setNavn("Arne");
		ActiveRom.updateRom(rom);
		System.out.println("Oppdaterte rommets navn til:" + rom.getNavn() + " og id: " + rom.getRomId());
		
		rom = ActiveRom.selectRom(rom.getRomId());
		System.out.println("Hentet ut rom med navn: " + rom.getNavn() + " som og har id: " + rom.getRomId());
		
		System.out.println("Test Utført!");
	}
	
	private static Rom mockRomWithId(int romId) {
		Rom rom = new Rom("Kaare");
		rom.setRomId(romId);
		return rom;
	}
	
	private static Rom mockRom() {
		Rom rom = new Rom("Kaare");
		return rom;
	}

	private static void testUpdateRom(){
		int ansattnr = 10001;
		String navn = "Martin";
		String nyttNavn = "Per-Donald";
		Person person = new Person();
		person.setAnsattNummer(ansattnr);
		
		//Hente ut person 10001 som allerede ligger inne
		Rom orginalRom = ActiveRom.selectRom(person.getAnsattNummer());
		System.out.println("Orginalt navn: " + orginalRom.getNavn());
		
		//oppdatere ny person
		orginalRom.setNavn(nyttNavn);
		ActiveRom.updateRom(orginalRom);
		Rom oppdatertPerson = ActiveRom.selectRom(orginalRom.getRomId());
		System.out.println("Nytt navn:" + oppdatertPerson.getNavn());
	}

}
