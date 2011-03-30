package no.ntnu.fp.model.record;

/*
 *   Methods:
 *   
 * 	 CreateAvtale(Avtale avtale)
 * 	 SelectPerson(int ansattnummer)
 * 	 UpdatePerson(Avtale Avtale)
 * 	 DeletePerson(int ansattnummer)	
 * 
 */

import java.sql.*;


import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Rom;

import org.apache.derby.tools.sysinfo;

public class ActiveAvtale extends ActiveModel{
	
	
	public static void createAvtale(Avtale avtale){
		PreparedStatement ps = null;
		try{
			connect();
			if( connection != null){
				ps = connection.prepareStatement(
					"INSERT INTO Avtale(avtaleID, navn, beskrivelse, dato, starttid, sluttid)" +
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
			System.out.println("Kan ikke lagre avtalen. Feilmelding:" + e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
	

	public static void updateAvtale(Avtale avtale){		
		try {
        	connect();
        	if( connection != null ){
	            PreparedStatement ps = connection.prepareStatement(
	            		"UPDATE Avtale " + 
	            		"SET navn = ?, beskrivelse = ?, dato = ?, starttid = ?, sluttid = ? " +
	                    "WHERE avtaleID = ? "
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
			System.out.println("Kan ikke oppdatere avtalen. Feilmelding:" + e.getMessage());
			System.out.println(e.getStackTrace());
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
						"SELECT * FROM Avtale WHERE avtaleID = ? "
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
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		
		avtale.setAvtaleId(avtaleId);
		avtale.setNavn(navn);
		avtale.setBeskrivelse(beskrivelse);
		avtale.setDato(dd, mm, yyyy);
		avtale.setSluttid(sluttid);
		avtale.setStarttid(starttid);
		
		return avtale;
	}
		
	private static void deleteAvtale(int avtaleId) {
		try {
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"DELETE FROM Avtale WHERE avtaleID = ?"
				);
				ps.setInt(1, avtaleId);
				ps.execute();
				connection.close();
			}
		} 
		catch (SQLException e) {
			System.out.println("Failed to delete Avtale \n Details:" + e.getMessage());
		}
	}
	
	public static void main(String args[]){
		testAll();
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
	
	private static void testAll(){
		Avtale avtale = mockAvtaleWithId(4);
		avtale.setNavn("Avtale 1");
		createAvtale(avtale);
		System.out.println("Lagret avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() + ".");
		
		deleteAvtale(avtale.getAvtaleId());
		System.out.println("Slette avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() + ".");
		
		createAvtale(avtale);
		System.out.println("Lagret på nytt avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() + ".");
		
		avtale = selectAvtale(avtale.getAvtaleId());
		System.out.println("Hentet ut avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() + ".");
		
		avtale.setNavn("Avtale 2");
		updateAvtale(avtale);
		System.out.println("Oppdaterte avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() + ".");
		
		avtale = selectAvtale(avtale.getAvtaleId());
		System.out.println("Hentet ut avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() + ".");
	}
}