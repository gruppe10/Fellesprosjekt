package no.ntnu.fp.model;

import java.net.URL;
import java.sql.*;
import org.apache.derby.tools.sysinfo;

public class ActiveModel {
	private static String db_url = "Kal";
	private static String admin_name = "";
	private static String admin_pwd = "";
	protected static Connection connection ;


	
	public static void createPerson(int ansattnr, String navn, String brukernavn, String passord) throws SQLException{
		PreparedStatement ps = null;
		try{
			connect();
			
			ps = connection.prepareStatement(
				"INSERT INTO Person(ansattnr, navn, brukernavn, passord)" +
				"VALUES ( ?, ?, ? ,?)" 
			);
			ps.setInt(1, ansattnr);
			ps.setString(2, navn);
			ps.setString(3, brukernavn);
			ps.setString(4, passord);
			
			boolean det_gikk_bra = ps.execute();
			if (det_gikk_bra){
				System.out.println("Det gikk bra!");
			}
		}
		catch(SQLException e){
			System.out.println("Kan ikke lage person. Feilmelding:" + e.getMessage());
		}
		finally{
			if(ps != null) ps.close();
		}
	}
	
	
	
	public static void updatePerson(Person person) throws SQLException{
		PreparedStatement ps = null;
		
		String navn = person.getName();
		String brukernavn = person.getBrukernavn();
		String passord = person.getPassord();
		int ansattnr = person.getAnsattNummer();
		
		try {
        	connect();
        	if( connection != null){
	            ps = connection.prepareStatement(
	            		"UPDATE Person " + 
	            		"SET navn = ? , brukernavn = ?, passord = ?" +
	                    "WHERE ansattnr = ? "
	            );
	            ps.setString(1, navn);
	            ps.setString(2, brukernavn);
	            ps.setString(3, passord);
	            ps.setInt(4, ansattnr);
        	}
            ps.executeUpdate();    
        }
		catch (SQLException e){
        	System.out.println("Kan ikke oppdatere!");
        	System.out.println("Detaljer:" + e.getMessage());
        }
        finally {
            if (ps != null) ps.close();
        }
	}
	
	
	
	private static Person selectPerson(int ansattnr){
		Person person = new Person();
		String navn  = "";
		String brukernavn = "";
		String passord = "";
		
		try{
			connect();
			
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM Person WHERE ansattnr = ? "
			);
			ps.setInt(1, ansattnr);
			
			ResultSet rs = ps.executeQuery(); 
			if (rs != null){
				while(rs.next()){
					navn = rs.getString("navn");
					brukernavn = rs.getString("brukernavn");
					passord = rs.getString("passord");
				}
			}
		}
		catch( SQLException e){
			System.out.println("Kan ikke finner person med id = " + ansattnr);
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		
		person.setName(navn);
		// person.setUsername(brukernavn);
		// person.setPassword(passord);
		
		return person;
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

		int ansattnr = 10001;
		String navn = "Martin";
		String brukernavn = "martin";
		String passord = "passordfaen";
		String nyttNavn = "Bob-Kåre";
		
		Person person = new Person();
		person.setName(nyttNavn);
		
		updatePerson(person);
		
		
	}
	
	
	private void testCreatePerson(){
		int ansattnr = 10001;
		String navn = "Martin";
		String brukernavn = "martin";
		String passord = "passordfaen";
		
		try{
			createPerson(ansattnr, navn, brukernavn, passord);
		}
		catch(SQLException e ){
			System.out.println("Det har skjedd en feil!");
		}    
	}
	
	private void testSelectPerson(){
		int ansattnr = 10001;
		Person testPerson  = selectPerson(ansattnr);
		System.out.println(testPerson.getName());
	}
}