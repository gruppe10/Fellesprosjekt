package no.ntnu.fp.model.record;

/*
 *   Methods:


 *   
 * 	 createPerson(Person person)
 * 	 selectPerson(int ansattnummer)
 * 	 updatePerson(Person person)
 * 	 deletePerson(int ansattnummer)	
 *
 *	 getMaxId()
 *
 *	 selectMoter(Int id)
 *	 selectAvtaler(Int id)
 *   
 */

import java.sql.*;
import java.util.ArrayList;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Person;

import org.apache.derby.impl.sql.compile.CreateAliasNode;
import org.apache.derby.tools.sysinfo;

public class ActivePerson extends ActiveModel{
	
	public static void createPerson(Person person){
		if(person.getAnsattNummer() == null){
			int nextAvailableId = nextAvailableIdFor("Person");
			person.setAnsattNummer(nextAvailableId);
		}
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
			//Needs handeler for BOTH avtale and mote
			ArrayList<Avtale> avtaler = person.getAvtaler();
			if(avtaler != null){
				for (Avtale avtale : avtaler) {
					ActiveHendelse.createAvtale(avtale);
				}
			}
			ArrayList<Mote> moter = person.getMoter();
			if(moter != null){
				for (Mote mote : moter) {
					ActiveHendelse.createMote(mote);
				}
			}
		}
		catch(SQLException e){
			System.out.println("Kan ikke lage person. Feilmelding:");
			System.out.println(e.getMessage());
		}
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
	            
	            ArrayList<Avtale> avtaler = person.getAvtaler();
				if(!avtaler.isEmpty()){
					for (Avtale avtale : avtaler) {
						ActiveHendelse.updateAvtale(avtale);
					}
				}
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
		ArrayList<Avtale> avtaler = selectAvtaler(ansattId);
		
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
		person.setAvtaler(avtaler);
		
		return person;
	}
	public static Person selectPersonByUsername(String brukernavn){
		Person person = new Person();
		String navn  = "";
		String passord = "";
		int ansattId = nextAvailableIdFor("Person");
		
		try{
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT Distinct FROM Person WHERE brukernavn = ? "
				);
				ps.setString(1, brukernavn);
				
				ResultSet rs = ps.executeQuery(); 
				if (rs != null){
					while(rs.next()){
						navn = rs.getString("navn");
						brukernavn = rs.getString("brukernavn");
						passord = rs.getString("passord");
						ansattId = rs.getInt("ansattId");
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
		person.setAvtaler(selectAvtaler(ansattId));
		
		return person;
	}
		
	public static void deletePerson(int ansattId) {
		// Slette alle avtaler som bare hører til denne personen
		// Dersom personen ikkje finnes eller ikke har avtaler, skjer det ingenting. 
		Person person = selectPerson(ansattId);
		for (Avtale avtale : person.getAvtaler()) {
			int avtaleId = avtale.getAvtaleId(); 
			ActiveHendelse.deleteAvtale(avtaleId);
		}
		for (Mote mote : person.getMoter()){
			int avtaleId = mote.getAvtaleId(); 
			ActiveHendelse.deleteAvtale(avtaleId);
		}
		//sletter personen
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
						"SELECT hendelseId FROM Deltakere WHERE ansattId = ?"
				);
				ps.setInt(1, ansattId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					int moteId = rs.getInt("avtaleId");
					Avtale nyttMote = ActiveHendelse.selectAvtale(moteId);
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
						"SELECT hendelseId FROM Hendelse WHERE lederId = ? "
				);
				ps.setInt(1, ansattId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					int hendelseId = rs.getInt("avtaleId");
					Avtale nyHendelse = ActiveHendelse.selectAvtale(hendelseId);
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
						Avtale avtale = ActiveHendelse.selectAvtale(avtaleId);
						hendelserUtenDeltagere.add(avtale);
					}
				}
				connection.close();	
			}	
		}
		catch(SQLException e){
			System.out.println("Could not find any Meetings for Person with id:" + ansattId);
			System.out.println("Details:" + e.getMessage());
		}
		return hendelserUtenDeltagere;
	}
	
}