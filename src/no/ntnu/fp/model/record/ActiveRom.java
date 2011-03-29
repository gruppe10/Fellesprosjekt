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

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Rom;

import org.apache.derby.tools.sysinfo;

public class ActiveRom {
	private static String db_url = "Kal";
	private static String admin_name = "";
	private static String admin_pwd = "";
	protected static Connection connection ;
	
	public static void createRom(Rom rom){
		PreparedStatement ps = null;
		
		try{
			connect();
			
			ps = connection.prepareStatement(
				"INSERT INTO Rom(romID, navn)" +
				"VALUES ( ?, ? )" 
			);
			ps.setInt(1, rom.getRomId());
			ps.setString(2, rom.getNavn());
						
			boolean det_gikk_bra = ps.execute();
			if (det_gikk_bra){
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
	

	public static void updateRom(Rom rom){
		PreparedStatement ps = null;
		
		String navn = rom.getNavn();
		int romID = rom.getRomId();
		
		try {
        	connect();
        	if( connection != null){
	            ps = connection.prepareStatement(
	            		"UPDATE Rom " + 
	            		"SET navn= ? " +
	                    "WHERE romID = ? "
	            );
	            ps.setString(1, navn);
	            ps.setInt(4, romID);
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
	
	
	
	private static Rom selectRom(int romID){
		Rom rom = new Rom("");
		String navn  = "";
		
		try{
			connect();
			
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM Rom WHERE romID = ? "
			);
			ps.setInt(1, romID);
			
			ResultSet rs = ps.executeQuery(); 
			if (rs != null){
				while(rs.next()){
					navn = rs.getString("navn");
				}
			}
		}
		catch( SQLException e){
			System.out.println("Kan ikke finner rom med id = " + romID);
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		
		rom.setRomId(romID);
		rom.setNavn(navn);
		
		return rom;
	}
		
	private static void deleteRom(int romID) {
		try {
			connect();
			PreparedStatement ps = connection.prepareStatement(
					"DELETE FROM Rom WHERE romID = ?"
			);
			ps.setInt(1, romID);
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
//		int romID = 112;
//		Rom rom = new Rom("");
//		rom.setRomId(romID);
//		
//		//deleteRom(rom.getRomId());
//		
//		selectRom(rom.getRomId());
		testCreateRom();
	}
	
	
	


	private void testUpdateRom(){
		int ansattnr = 10001;
		String navn = "Martin";
		String nyttNavn = "Per-Donald";
		Person person = new Person();
		person.setAnsattNummer(ansattnr);
		
		//Hente ut person 10001 som allerede ligger inne
		Rom orginalRom = selectRom(person.getAnsattNummer());
		System.out.println("Orginalt navn: " + orginalRom.getNavn());
		
		//oppdatere ny person
		orginalRom.setNavn(nyttNavn);
		updateRom(orginalRom);
		Rom oppdatertPerson = selectRom(orginalRom.getRomId());
		System.out.println("Nytt navn:" + oppdatertPerson.getNavn());
	}
	
	
	private static void testCreateRom(){
		Rom rom = new Rom("");
		rom.setRomId(113);
		rom.setNavn("Martin");
		
		createRom(rom);
		
//		Rom nyeRom = selectRom(rom.getRomId());
//		System.out.println(nyeRom.getNavn());
	}
	
	
	private void testSelectPerson(){
		int romID = 113;
		Rom testRom  = selectRom(romID);
		System.out.println(testRom.getNavn());
	}
}