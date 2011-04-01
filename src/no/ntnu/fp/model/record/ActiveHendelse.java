package no.ntnu.fp.model.record;

/*	About:
 * 	
 * 	Hendelse er en generell databasetabell som inneholder BÅDE Avtaler og Moter
 * 	Forskjellen er at Moter også "snakker" med Deltager tabellen
 * 
 * 	Metodene er Objekt spesifikk, mens delete og select finner ut selv om det
 *  er Avtale eller Mote som hentes ut
 * 
 * 	
 *   Methods:
 *   
 * 	 CreateAvtale(Avtale avtale)
 * 	 CreateMote(Mote mote)
 *   UpdateAvtale(Avtale Avtale)
 * 	 UpdateMote(Mote mote)
 * 	 SelectHendelse(int hendelseID)
 *	 DeleteHendelse(int ansattnummer)	
 * 
 */

import java.sql.*;
import java.util.ArrayList;
import no.ntnu.fp.model.*;

import org.apache.derby.tools.sysinfo;

public class ActiveHendelse extends ActiveModel{
	
	public static void createAvtale(Avtale avtale){
		PreparedStatement ps = null;
		try{
			connect();
			if( connection != null){
				ps = connection.prepareStatement(
					"INSERT INTO Hendelse(hendelseId, navn, beskrivelse, dato, starttid, sluttid)" +
					"VALUES ( ?, ?, ? ,? ,? ,? )" 
				);
				ps.setInt(1, avtale.getAvtaleId());
				ps.setString(2, avtale.getNavn());
				ps.setString(3, avtale.getBeskrivelse());
				ps.setDate(4, formatDateFrom(avtale));
				ps.setTime(5, formatTimeFrom(avtale.getStarttid()));
				ps.setTime(6, formatTimeFrom(avtale.getSluttid()));
				ps.execute();
				
				connection.close();
				}
		}
		catch(SQLException e){
			System.out.println("Kan ikke lagre avtalen");
			System.out.println("Details:" + e.getMessage());
		}
	}
	
	public static void createMote(Mote mote){
		PreparedStatement ps = null;
		try{
			connect();
			if( connection != null){
				ps = connection.prepareStatement(
					"INSERT INTO Hendelse(hendelseId, navn, beskrivelse, dato, starttid, sluttid)" +
					"VALUES ( ?, ?, ? ,? ,? ,? )" 
				);
				ps.setInt(1, mote.getAvtaleId());
				ps.setString(2, mote.getNavn());
				ps.setString(3, mote.getBeskrivelse());
				ps.setDate(4, formatDateFrom(mote));
				ps.setTime(5, formatTimeFrom(mote.getStarttid()));
				ps.setTime(6, formatTimeFrom(mote.getSluttid()));
				ps.execute();
				
				if(mote.getInitiativtaker()!= null){
					PreparedStatement ps2 = connection.prepareStatement(
						"UPDATE Avtale(initiativTakerId)" +
						"SET initiativtakerId = ?" +
						"WHERE avtaleId = ?" 
					);
					ps2.setInt(1, mote.getInitiativtaker().getAnsattNummer());
					ps2.setInt(2, mote.getAvtaleId());
				    ps2.execute();
				}
				connection.close();
				}
		}
		catch(SQLException e){
			System.out.println("Kan ikke lagre avtalen");
			System.out.println("Details:" + e.getMessage());
		}
	}
	

	public static void updateAvtale(Avtale avtale){		
		try {
        	connect();
        	if( connection != null ){
	            PreparedStatement ps = connection.prepareStatement(
	            		"UPDATE Hendelse " + 
	            		"SET navn = ?, beskrivelse = ?, dato = ?, starttid = ?, sluttid = ? " +
	                    "WHERE hendelseId = ? "
	            );
				ps.setString(1, avtale.getNavn());
				ps.setString(2, avtale.getBeskrivelse());
				ps.setDate(3, formatDateFrom(avtale));
				ps.setTime(4, formatTimeFrom(avtale.getStarttid()));
				ps.setTime(5, formatTimeFrom(avtale.getSluttid()));
				ps.setInt(6, avtale.getAvtaleId());
				ps.executeUpdate();
				connection.close();
			}
		}
		catch(SQLException e){
			System.out.println("Kan ikke oppdatere avtalen");
			System.out.println("Details:" + e.getMessage());
		}
	}
	
	public static Avtale selectAvtale(int avtaleId){
		Avtale avtale = new Avtale();
		String navn = "";
		String beskrivelse = "";
		int dd = 00;
		int mm = 00;
		int yyyy = 0000;
		int starttid = 0;
		int sluttid = 0;
		
		try{
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT * FROM Hendelse WHERE hendelseId = ? "
				);
				ps.setInt(1, avtaleId);
				
				ResultSet rs = ps.executeQuery(); 
				if (rs != null){
					while(rs.next()){
						navn = rs.getString("navn");
						beskrivelse = rs.getString("beskrivelse");
						
						dd = 00;
						mm = 00;
						yyyy = 00;
						
						starttid = formatIntFrom(rs.getTime("starttid"));
						sluttid = formatIntFrom(rs.getTime("sluttid"));
					}
				}
				connection.close();
			}
		}
		catch( SQLException e){
			System.out.println("Kan ikke finner person med id = " + avtaleId);
			System.out.println("Details:" + e.getMessage());
		}
		
		avtale.setAvtaleId(avtaleId);
		avtale.setNavn(navn);
		avtale.setBeskrivelse(beskrivelse);
		avtale.setDato(dd, mm, yyyy);
		avtale.setSluttid(sluttid);
		avtale.setStarttid(starttid);
		
		return avtale;
	}
		
	public static void deleteAvtale(int avtaleId) {
		try {
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"DELETE FROM Hendelse WHERE hendelseId = ?"
				);
				ps.setInt(1, avtaleId);
				ps.execute();
				connection.close();
			}
		} 
		catch (SQLException e) {
			System.out.println("Failed to delete Avtale \n");
			System.out.println("Details:" + e.getMessage());
		}
	}
	
	public static ArrayList<Person> selectDeltagere(int avtaleId) {
		ArrayList<Person> deltagere = new ArrayList<Person>();
		try{
			connect();
			if(connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT ansattId FROM Deltakere WHERE hendelseId = ?"
				);
				ps.setInt(1, avtaleId);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					int deltagerNr = rs.getInt("ansattnr");
					Person nyDeltager = ActivePerson.selectPerson(deltagerNr);
					deltagere.add(nyDeltager);
				};
			}
			connection.close();	
		}
		catch(SQLException e){
			System.out.println("Could not find any Participants for Meeting with id:" + avtaleId);
			System.out.println("Details:" + e.getMessage());
		}
		return deltagere;
	}
	
	public static void updateDeltagere(ArrayList<Person> deltagere, int avtaleId){
		try{
			connect();
			if(connection != null){
				for (Person person : deltagere){
							PreparedStatement ps = connection.prepareStatement(
							"UPDATE Deltakere" +
							"SET ansattId = ? " +
							"WHERE Deltakere.hendelseId = ? "
							);
							ps.setInt(1, person.getAnsattNummer());
							ps.setInt(2, avtaleId);
						ps.executeUpdate();
				}
				connection.close();
			}
		}
		catch(SQLException e){
			System.out.println("Could not find any Participants for Meeting with id:");
			System.out.println("Details:" + e.getMessage());
		}					
	}
	
	public static boolean exists(int avtaleId) {
		boolean exists = false;
		try{
			connect();
			if(connection != null){

				PreparedStatement ps = connection.prepareStatement(
						"SELECT * FROM Hendelse " +
						"WHERE hendelseId = ? "
				);
				ps.setInt(1, avtaleId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					exists = true;
				}
				connection.close();
			}
		}
		catch(SQLException e){
			System.out.println("Could not find any Participants for Meeting with id:");
			System.out.println("Details:" + e.getMessage());
		}
		return exists;
	}
	
	public static void main(String args[]){
		testCrud();
		if(exists(4)){
			System.out.println("Den finnes!");
		}else{
			System.out.println("Finner den ikke!");
		}
		System.out.println("Test utført");
	}
	
	
/******************************
*  			Tester			  *
******************************/
	
	private void testCreatePerson(){
		Avtale avtale = mockAvtaleWithId(10001);

		createAvtale(avtale);
	}	
	
	private static Avtale mockAvtaleWithId(int id){
		Avtale avtale = new Avtale();
			
		avtale.setAvtaleId(id);
		avtale.setNavn("Annet navn!");
		avtale.setDato(01, 22, 2011);
		avtale.setStarttid(12);
		avtale.setSluttid(12);
		avtale.setBeskrivelse("Dette er en avtale");
		
		return avtale;
	}
	
	private static void testUpdateAvtale(){
		Avtale avtale = mockAvtaleWithId(10003);
		avtale.setNavn("Avtale nr 1");
		createAvtale(avtale);
		System.out.println("Avtale 1 er lagret med navn:" + avtale.getNavn());
		
		avtale.setNavn("Avtale nr 2");
		updateAvtale(avtale);
		System.out.println("Avtale 2 er lagret med navn:" + avtale.getNavn());
	}

	private static void testSelectAvtale(){
		int ansattnr = 10002;
		Avtale avtale = selectAvtale(ansattnr);
		System.out.println("Avtalen har navnet:" + avtale.getNavn() + ".");
	}
	
	private static void testCrud(){
		Avtale avtale = mockAvtaleWithId(4);
		avtale.setNavn("Avtale 1");
		deleteAvtale(avtale.getAvtaleId());
		createAvtale(avtale);
		System.out.println("Lagret avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() + "og id:" + avtale.getAvtaleId());
		
		deleteAvtale(avtale.getAvtaleId());
		System.out.println("Slette avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() +  "og id:" + avtale.getAvtaleId());
		
		createAvtale(avtale);
		System.out.println("Lagret på nytt avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() +  "og id:" + avtale.getAvtaleId());
		
		avtale = selectAvtale(avtale.getAvtaleId());
		System.out.println("Hentet ut avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() +  "og id:" + avtale.getAvtaleId());
		
		avtale.setNavn("Avtale 2");
		updateAvtale(avtale);
		System.out.println("Oppdaterte avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() +  "og id:" + avtale.getAvtaleId());
		
		avtale = selectAvtale(avtale.getAvtaleId());
		System.out.println("Hentet ut avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() +  "og id:" + avtale.getAvtaleId());
	}


	
}