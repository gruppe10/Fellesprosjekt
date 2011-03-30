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

public class ActiveAvtale {
	private static String db_url = "Kal";
	private static String admin_name = "";
	private static String admin_pwd = "";
	protected static Connection connection ;
	
	@SuppressWarnings("deprecation")
	private static Date formatDateFrom(Avtale avtale){
		int dd = avtale.getDatoDag();
		int mm = avtale.getDatoMnd();
		int yyyy = avtale.getDatoAar();
		
		Date date = new Date(dd, mm, yyyy);
		return date;
	}
	
	@SuppressWarnings("deprecation")
	public static Time formatTimeFrom(int tid){ 
		Time time = new Time(tid, 00, 00);
		return time;
	}
	
	public static void createAvtale(Avtale avtale){
		PreparedStatement ps = null;
		try{
			connect();
			
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
			
			boolean success = ps.execute();
			if (success){
				System.out.println("Created Avtale!\n");
			}
		}
		catch(SQLException e){
			System.out.println("Kan ikke lagre avtalen. Feilmelding:" + e.getMessage());
			System.out.println(e.getStackTrace());
		}
		finally{
			//if(ps != null) ps.close();
		}
	}
	

	public static void updateAvtale(Avtale avtale){
		PreparedStatement ps = null;		
		try {
        	connect();
        	if( connection != null ){
	            ps = connection.prepareStatement(
	            		"UPDATE Avtale " + 
	            		"SET avtaleID= ? , navn = ?, beskrivelse = ?, " +
	            		"dato = ?, starttid = ?, sluttid = ? " +
	                    "WHERE ansattnr = ? "
	            );
	            ps.setInt(1, avtale.getAvtaleId());
				ps.setString(2, avtale.getNavn());
				ps.setString(3, avtale.getBeskrivelse());
				ps.setDate(4, formatDateFrom(avtale));
				ps.setInt(5, avtale.getStarttid());
				ps.setInt(6, avtale.getSluttid());
        	}
        	boolean success = ps.execute();
			if (success){
				System.out.println("Updated Avtale!\n");
			}
		}
		catch(SQLException e){
			System.out.println("Kan ikke oppdatere avtalen. Feilmelding:" + e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
	
	
	
	private static Avtale selectAvtale(int avtaleID){
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
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM Avtale WHERE avtaleID = ? "
			);
			ps.setInt(1, avtaleID);
			
			ResultSet rs = ps.executeQuery(); 
			if (rs != null){
				while(rs.next()){
					navn = rs.getString("navn");
					beskrivelse = rs.getString("beskrivelse");
					
					dd = 00;
					mm = 00;
					yyyy = 00;
					
					starttid = rs.getInt("starttid");
					sluttid = rs.getInt("Sluttid");
				}
			}
		}
		catch( SQLException e){
			System.out.println("Kan ikke finner person med id = " + avtaleID);
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		
		avtale.setBeskrivelse(beskrivelse);
		avtale.setDato(dd, mm, yyyy);
		avtale.setSluttid(sluttid);
		avtale.setStarttid(starttid);
		
		return avtale;
	}
		
	private static void deleteAvtale(int avtaleId) {
		try {
			connect();
			PreparedStatement ps = connection.prepareStatement(
					"DELETE FROM Avtale WHERE avtaleID = ?"
			);
			ps.setInt(1, avtaleId);
			
			boolean success = ps.execute();
			if (success){
				System.out.println("Slettet Avtale!");
			}	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void connect() throws SQLException{
		try{
			connection =  DriverManager.getConnection("jdbc:derby:" + db_url, admin_name, admin_pwd );
		}
		catch(SQLException e){
			connection = null;
			System.out.println("Kan ikke koble til database");
		}
		finally{ 
		}		
	}
	
	public static void main(String args[]){
		
	}
	
	private void testCreatePerson(){
		Avtale avtale = new Avtale();
		avtale.setAvtaleId(10002);
		avtale.setNavn("Julaften mothafokka!");
		avtale.setDato(01, 22, 2011);
		avtale.setStarttid(12);
		avtale.setSluttid(12);

		createAvtale(avtale);
	}	
	
	
//  Uncompleted test
//
//	private void testUpdatePerson(){
//		int ansattnr = 10001;
//		String navn = "Martin";
//		String nyttNavn = "Per-Donald";
//		Person person = new Person();
//		person.setAnsattNummer(ansattnr);
//		
//		//Hente ut person 10001 som allerede ligger inne
//		Person orginalPerson = selectPerson(person.getAnsattNummer());
//		System.out.println("Orginalt navn: " + orginalPerson.getName());
//		
//		//oppdatere ny person
//		orginalPerson.setName(nyttNavn);
//		updatePerson(orginalPerson);
//		Person oppdatertPerson = selectPerson(orginalPerson.getAnsattNummer());
//		System.out.println("Nytt navn:" + oppdatertPerson.getName());
//	}
//	
//	

//	
//	
//	private void testSelectPerson(){
//		int ansattnr = 10001;
//		Person testPerson  = selectPerson(ansattnr);
//		System.out.println(testPerson.getName());
//	}
}