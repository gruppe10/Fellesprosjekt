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
			
			ps.execute();
			connection.close();
		}
		catch(SQLException e){
			System.out.println("Kan ikke lagre avtalen. Feilmelding:" + e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
	

	public static void updateAvtale(Avtale avtale){
		PreparedStatement ps = null;		
		try {
        	connect();
        	if( connection != null ){
	            ps = connection.prepareStatement(
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
        	}
        	ps.executeUpdate();
			connection.close();
		}
		catch(SQLException e){
			System.out.println("Kan ikke oppdatere avtalen. Feilmelding:" + e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
	
	@SuppressWarnings("deprecation")
	public static int formatIntFrom(Time time){
		int i = time.getHours();
		return i;
	}
	
	
	private static Avtale selectAvtale(int avtaleId){
		PreparedStatement ps ;
		
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
			ps = connection.prepareStatement(
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
			PreparedStatement ps = connection.prepareStatement(
					"DELETE FROM Avtale WHERE avtaleID = ?"
			);
			ps.setInt(1, avtaleId);
			ps.execute();
			connection.close();
		} 
		catch (SQLException e) {
			System.out.println("Failed to delete Avtale \n Details:" + e.getMessage());
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
		
		avtale = selectAvtale(avtale.getAvtaleId());
		System.out.println("Hentet ut avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() + ".");
		
		avtale.setNavn("Avtale 2");
		updateAvtale(avtale);
		System.out.println("Oppdaterte avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() + ".");
		
		avtale = selectAvtale(avtale.getAvtaleId());
		System.out.println("Hentet ut avtale med navn: " + avtale.getNavn() + ", beskrivelse lik: " + avtale.getBeskrivelse() + ".");
	}
}