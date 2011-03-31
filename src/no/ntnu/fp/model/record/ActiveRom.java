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

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Rom;

import org.apache.derby.tools.sysinfo;

public class ActiveRom extends ActiveModel{
	public static void createRom(Rom rom){
		try{
			connect();
			if(connection != null){
				PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO Rom(romID, navn)" +
					"VALUES ( ?, ? )" 
				);
				ps.setInt(1, rom.getRomId());
				ps.setString(2, rom.getNavn());
				ps.execute();
			}
			connection.close();
		}
		catch(SQLException e){
			System.out.println("Kan ikke lage person."); 
			System.out.println("Feilmelding:" + e.getMessage());
		}
	}
	
	public static int getMaxId(){
		int romId = 0;
		try{
			connect(); 
			if( connection != null){
	            PreparedStatement ps = connection.prepareStatement(
	            "SELECT MAX romID" +
	            "FROM Rom"		    
	            );
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
					romId = rs.getInt("romID");
				}
			}
			connection.close();
		}
	    catch( SQLException e){
	    	System.out.println("Kan ikke finne rom med id = " + romId);
	    	System.out.println("ErrorMessage:" + e.getMessage());
	    }
	    return romId;         
	}
	

	public static void updateRom(Rom rom){
		String navn = rom.getNavn();
		int romID = rom.getRomId();
		
		try {
        	connect();
        	if( connection != null){
	            PreparedStatement ps = connection.prepareStatement(
	            		"UPDATE Rom SET navn= ? WHERE romID = ? "
	            );
	            ps.setString(1, navn);
	            ps.setInt(2, romID);
	            ps.executeUpdate();
        	}
        	connection.close();
        }
		catch (SQLException e){
        	System.out.println("Kan ikke oppdatere!");
        	System.out.println("Detaljer:" + e.getMessage());
        }
	}
	
	
	
	public static Rom selectRom(int romID){
		Rom rom = new Rom("");
		String navn  = "";
		
		try{
			connect();
			if( connection != null){
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
			connection.close();
		}
		catch( SQLException e){
			System.out.println("Kan ikke finner rom med id = " + romID);
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		
		rom.setRomId(romID);
		rom.setNavn(navn);
		
		return rom;
	}
		
	public static void deleteRom(int romID) {
		try {
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"DELETE FROM Rom WHERE romID = ?"
				);
				ps.setInt(1, romID);
				ps.execute();
			}	
			connection.close();
		} 
		catch (SQLException e) {
			System.out.println("Failed to delete rom with id" + romID);
			System.out.println("Details:" + e.getMessage());
		}
	}

	
	public boolean[] selectLedigeTider(int romId, Date date){
		boolean[] ledigeTider = new boolean[24];
		
		try{
			connect();
			if(connection != null){
				PreparedStatement ps = connection.prepareStatement(
						" WITH reserverteTider as(" +
						"	SELECT * from ReservertRom,Mote " +
						"	WHERE ReservertRom.avtaleId = ? " +
						"	AND Mote.avtaleId = ? 			" +
						"	AND Mote.date = ?  			    " +
						" )" +
						" SELECT starttid,sluttid from reserverteTider" 
				);
				ps.setInt(1,romId);
				ps.setInt(2, romId);
				ps.setDate(3,date);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					int starttid = formatIntFrom(rs.getTime(""));
					int sluttid = formatIntFrom(rs.getTime(""));
					
					for(int i = starttid ; i <= sluttid; i++ ){
						ledigeTider[i] = false;
					}
				}
				connection.close();
			}
		}catch(SQLException e){
			System.out.println("Kan ikke finne tider for rom med id:" + romId + "på datoen:" + date);
			System.out.println("Detaljer:" + e.getMessage());
		}
		return ledigeTider;
		
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
	
	
	
	/******************************
	*  			Tester			  *
	******************************/
	
	private static void testCreateRom(){
	testCrud();
	}
	
	private static void testCrud(){
		Rom rom = new Rom("");
		rom.setRomId(115);
		rom.setNavn("Martin");
		
		//createRom(rom);
		deleteRom(rom.getRomId());
		createRom(rom);
		System.out.println("Rom nr 115 heter:" + rom.getNavn());
		
		rom.setNavn("KaareKonraadi");
		updateRom(rom);
		Rom nyttRom = selectRom(115);
		
		System.out.println("Rom nr 115 heter:" + nyttRom.getNavn());
		System.out.println("Test Utført!");
	}
	
	private static void testUpdateRom(){
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
	


		
//	private void testSelectPerson(){
//		int romID = 113;
//		Rom testRom  = selectRom(romID);
//		System.out.println(testRom.getNavn());
//	}
}