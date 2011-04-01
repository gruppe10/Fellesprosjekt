package no.ntnu.fp.model.record;

/*
 *   Methods:

 *   
 * 	 CreatePerson(Person person)
 * 	 SelectPerson(int ansattnummer)
 * 	 UpdatePerson(Person person)
 * 	 DeletePerson(int ansattnummer)	
 * 
 */

import java.sql.*;
import java.util.ArrayList;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Person;

import org.apache.derby.tools.sysinfo;

public class ActivePerson extends ActiveModel{
	
	public static void createPerson(Person person){
		try{
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO Person(ansattId, navn, brukernavn, passord)" +
					"VALUES ( ?, ?, ? ,? )" 
				);
				ps.setInt(1, person.getAnsattNummer());
				ps.setString(2, person.getName());
				ps.setString(3, person.getBrukerNavn());
				ps.setString(4, person.getPassord());
				
				ps.execute();
				connection.close();
			}
		}
		catch(SQLException e){
			System.out.println("Kan ikke lage person. Feilmelding:" + e.getMessage());
		}
	}
	
	public static int getMaxId(){
		int ansattNummer=0;
		try{
			connect(); 
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
	            "SELECT MAX ansattId" +
	            "FROM Person"		    
	            );
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
					ansattNummer = rs.getInt("ansattId");
				}
			}
		}
	    catch( SQLException e){
	    	System.out.println("Kan ikke finne rom med id = " + ansattNummer);
	    	System.out.println("ErrorMessage:" + e.getMessage());
	    }
	   return ansattNummer;         
	}

	public static void updatePerson(Person person){
		String navn = person.getName();
		String brukernavn = person.getBrukerNavn();
		String passord = person.getPassord();
		int ansattId = person.getAnsattNummer();
		
		try {
        	connect();
        	if( connection != null){
        		PreparedStatement ps = connection.prepareStatement(
	            		"UPDATE Person " + 
	            		"SET navn= ? , brukernavn = ?, passord = ?" +
	                    "WHERE ansattId = ? "
	            );
	            ps.setString(1, navn);
	            ps.setString(2, brukernavn);
	            ps.setString(3, passord);
	            ps.setInt(4, ansattId);
	            ps.executeUpdate();
	            connection.close();
        	}  
        }
		catch (SQLException e){
        	System.out.println("Kan ikke oppdatere!");
        	System.out.println("Detaljer:" + e.getMessage());
        }
	}
	
	public static Person selectPerson(int ansattId){
		Person person = new Person();
		String navn  = "";
		String brukernavn = "";
		String passord = "";
		
		try{
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT * FROM Person WHERE ansattId = ? "
				);
				ps.setInt(1, ansattId);
				
				ResultSet rs = ps.executeQuery(); 
				if (rs != null){
					while(rs.next()){
						navn = rs.getString("navn");
						brukernavn = rs.getString("brukernavn");
						passord = rs.getString("passord");
					}
				}
				connection.close();
			}
		}
		catch( SQLException e){
			System.out.println("Kan ikke finner person med id = " + ansattId);
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		
		person.setAnsattNummer(ansattId);
		person.setName(navn);
		person.setBrukerNavn(brukernavn);
		person.setPassord(passord);
		
		return person;
	}
		
	public static void deletePerson(int ansattId) {
		try {
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"DELETE FROM Person WHERE ansattId = ?"
				);
				ps.setInt(1, ansattId);
				ps.execute();	
				connection.close();
			}
		} 
		catch (SQLException e) {
			System.out.println("Kan ikke slette person med id:" + ansattId);
			System.out.println("Detaljer:" + e.getMessage());
		}
	}
	
	public static ArrayList<Avtale> selectMoter(int ansattId) {
		ArrayList<Avtale> moter = new ArrayList<Avtale>();
		try{
			connect();
			if(connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT avtaleID FROM Deltakere WHERE ansattId = ?"
				);
				ps.setInt(1, ansattId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					int moteId = rs.getInt("avtaleID");
					Avtale nyttMote = ActiveAvtale.selectAvtale(moteId);
					moter.add(nyttMote);
				};
			}
			connection.close();	
		}
		catch(SQLException e){
			System.out.println("Could not find any Meetings for Person with id:" + ansattId);
			System.out.println("Details:" + e.getMessage());
		}
		return moter;
	}
	
	public static ArrayList<Avtale> selectAvtaler(int ansattId) {
		ArrayList<Avtale> hendelser = new ArrayList<Avtale>();
		ArrayList<Avtale> hendelserUtenDeltagere = new ArrayList<Avtale>();
		try{
			connect();
			if(connection != null){
				PreparedStatement ps = connection.prepareStatement(
						" SELECT avtaleId FROM Avtale WHERE LederID = ? "
				);
				ps.setInt(1, ansattId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					int hendelseId = rs.getInt("avtaleId");
					Avtale nyHendelse = ActiveAvtale.selectAvtale(hendelseId);
					hendelser.add(nyHendelse);
				};
				ps.close();
				for (Avtale hendelse : hendelser){
					PreparedStatement ps2 = connection.prepareStatement("" +
							"Select Avtale.avtaleId from Avtale,Deltagere" +
							"WHERE NOT Avtale.avtaleId = Deltagere.avtaleId" +
							"AND Avtale.avtaleId = ?");
					ps2.setInt(1,hendelse.getAvtaleId());
					
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next()){
						int avtaleId = rs2.getInt("avtaleId");
						Avtale avtale = ActiveAvtale.selectAvtale(avtaleId);
						hendelserUtenDeltagere.add(avtale);
					}
				}
			}
			connection.close();	
		}
		catch(SQLException e){
			System.out.println("Could not find any Meetings for Person with id:" + ansattId);
			System.out.println("Details:" + e.getMessage());
		}
		return hendelserUtenDeltagere;
	}
	
	public static void main(String args[]){
		testSelectAvtaler();
	}
	
	/******************************
	 *              TESTER        *
	 ******************************/
	
	
	private static void testSelectAvtaler(){
		int ansattId = 10;
		ArrayList<Avtale> avtaler = selectAvtaler(ansattId);
		for (Avtale avtale : avtaler) {
			System.out.println(avtale.getNavn());
		}
		System.out.println("test fullført");
	}
	
	private static void testCrud(){
		int ansattId = 15;
		Person person = mockPersonWithId(ansattId);
		
		createPerson(person);
		System.out.println("Lagrer personen " + person.getName() + " med id=" + person.getAnsattNummer());
		
		deletePerson(person.getAnsattNummer());
		System.out.println("Sletter personen: "  + person.getName() + " med id=" + person.getAnsattNummer());
		
		person.setName("Dole");
		createPerson(person);
		System.out.println("Lagrer personen " + person.getName() + " med id=" + person.getAnsattNummer());
		
		Person nyPerson = selectPerson(ansattId);
		System.out.println("Henter ut ny person: " + nyPerson.getName() + " med id=" + nyPerson.getAnsattNummer());
		
		nyPerson.setName("Doffen");
		updatePerson(nyPerson);
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

	private void testUpdatePerson(){
		int ansattId = 10001;
		String navn = "Martin";
		String nyttNavn = "Per-Donald";
		Person person = new Person();
		person.setAnsattNummer(ansattId);
		
		//Hente ut person 10001 som allerede ligger inne
		Person orginalPerson = selectPerson(person.getAnsattNummer());
		System.out.println("Orginalt navn: " + orginalPerson.getName());
		
		//oppdatere ny person
		orginalPerson.setName(nyttNavn);
		updatePerson(orginalPerson);
		Person oppdatertPerson = selectPerson(orginalPerson.getAnsattNummer());
		System.out.println("Nytt navn:" + oppdatertPerson.getName());
	}
	
	
	private void testCreatePerson(){
		Person person = new Person();
		person.setAnsattNummer(10004);
		person.setName("Martin");
		person.setBrukerNavn("martin");
		person.setPassord("1234");
		
		createPerson(person);
		
		Person nyeperson = selectPerson(person.getAnsattNummer());
		System.out.println(nyeperson.getName());
	}
	
	
	private void testSelectPerson(){
		int ansattId = 10001;
		Person testPerson  = selectPerson(ansattId);
		System.out.println(testPerson.getName());
	}
}