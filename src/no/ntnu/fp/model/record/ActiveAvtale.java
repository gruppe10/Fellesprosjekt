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
	
	public static void createAvtale(Avtale avtale){
		PreparedStatement ps = null;
		try{
			connect();
			
			ps = connection.prepareStatement(
				"INSERT INTO Person(avtaleid, tittel, beskrivelse, dato, starttid, sluttid)" +
				"VALUES ( ?, ?, ? ,? ,? ,? )" 
			);
			ps.setInt(1, avtale.getAvtaleId());
			ps.setString(2, avtale.getTittel());
			ps.setString(3, avtale.getBeskrivelse());
			ps.setDate(4, formatDateFrom(avtale));
			ps.setInt(5, avtale.getStarttid());
			ps.setInt(6, avtale.getSluttid());
			
			
			
			boolean success = ps.execute();
			if (success){
				System.out.println("Det gikk bra!");
			}
		}
		catch(SQLException e){
			System.out.println("Kan ikke lage person. Feilmelding:" + e.getMessage());
		}
		finally{
			//if(ps != null) ps.close();
		}
	}
	

	public static void updatePerson(Person person){
		PreparedStatement ps = null;
		
		String navn = person.getName();
		String brukernavn = person.getBrukerNavn();
		String passord = person.getPassord();
		int ansattnr = person.getAnsattNummer();
		
		try {
        	connect();
        	if( connection != null){
	            ps = connection.prepareStatement(
	            		"UPDATE Person " + 
	            		"SET navn= ? , brukernavn = ?, passord = ?" +
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
            //if (ps != null) ps.close();
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
		
		person.setAnsattNummer(ansattnr);
		person.setName(navn);
		person.setBrukerNavn(brukernavn);
		person.setPassord(passord);
		
		return person;
	}
		
	private static void deletePerson(int ansattNr) {
		try {
			connect();
			PreparedStatement ps = connection.prepareStatement(
					"DELETE FROM Person WHERE ansattNR = ?"
			);
			ps.setInt(1, ansattNr);
			ps.execute();	
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
		int ansattnr = 10001;
		Person person = new Person();
		person.setAnsattNummer(ansattnr);
		
		deletePerson(person.getAnsattNummer());
		
		selectPerson(person.getAnsattNummer());

	}
	
	
	


	private void testUpdatePerson(){
		int ansattnr = 10001;
		String navn = "Martin";
		String nyttNavn = "Per-Donald";
		Person person = new Person();
		person.setAnsattNummer(ansattnr);
		
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
		int ansattnr = 10001;
		Person testPerson  = selectPerson(ansattnr);
		System.out.println(testPerson.getName());
	}
}