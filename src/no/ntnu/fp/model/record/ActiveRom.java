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
					"INSERT INTO Rom(romId, navn) VALUES ( ?, ? )" 
				);
				ps.setInt(1,rom.getRomId());
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
	            "SELECT MAX romId" +
	            "FROM Rom"		    
	            );
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
					romId = rs.getInt("romId");
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
		int romId = rom.getRomId();
		
		try {
        	connect();
        	if( connection != null){
	            PreparedStatement ps = connection.prepareStatement(
	            		"UPDATE Rom SET navn = ? WHERE romId = ? "
	            );
	            ps.setString(1, navn);
	            ps.setInt(2, romId);
	            ps.executeUpdate();
        	}
        	connection.close();
        }
		catch (SQLException e){
        	System.out.println("Kan ikke oppdatere!");
        	System.out.println("Detaljer:" + e.getMessage());
        }
	}
	
	
	
	public static Rom selectRom(int romId){
		Rom rom = new Rom("");
		String navn  = "";
		
		try{
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT * FROM Rom WHERE romId = ? "
				);
				ps.setInt(1, romId);
				
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
			System.out.println("Kan ikke finner rom med id = " + romId);
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		
		rom.setRomId(romId);
		rom.setNavn(navn);
		
		return rom;
	}
		
	public static void deleteRom(int romId) {
		try {
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"DELETE FROM Rom WHERE romId = ?"
				);
				ps.setInt(1, romId);
				ps.execute();
			}	
			connection.close();
		} 
		catch (SQLException e) {
			System.out.println("Failed to delete rom with id" + romId);
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
	
	
	public static void createReservasjon(int romId, int avtaleId){
		try{
			connect();
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO ReserverteRom(romId ,avtaleId) VALUES(?,?) "
			);
			ps.setInt(1, romId);
			ps.setInt(2,avtaleId);
		}catch(SQLException e){
			System.out.println("Kan ikke reservere rom med id: " + romId + " for avtale: " + avtaleId);
			System.out.println("Detaljer:" + e.getMessage());
		}
	}
	
	public static void deleteReservasjon(int romId,int avtaleId){
		try{
			connect();
			PreparedStatement ps = connection.prepareStatement(
					"DELETE FROM ReserverteRom " +
					"WHERE romId = ? AND avtaleId = ? " 
			);
			ps.setInt(1, romId);
			ps.setInt(2,avtaleId);
		}catch(SQLException e){
			System.out.println("Kan ikke reservere rom med id: " + romId + " for avtale: " + avtaleId);
			System.out.println("Detaljer:" + e.getMessage());
		}
	}
	
	public static void main(String args[]){
		testCreateReservasjon();
		System.out.println("TestUtført");
	}

	/******************************
	*  			Tester			  *
	******************************/
	
	private static void testCreateReservasjon(){
		createReservasjon(1,2);
		deleteReservasjon(1,2);
		
	}
	
	private static void testCrud(){
		Rom rom = mockRomWith(1);
		
		deleteRom(rom.getRomId());
		System.out.println("Slettet rom med navn " +rom.getNavn() + " som og har id: " + rom.getRomId());
		
		createRom(rom);
		System.out.println("Laget rom med navn: " + rom.getNavn() + " som og har id: " + rom.getRomId());
		
		rom.setNavn("Arne");
		updateRom(rom);
		System.out.println("Oppdaterte rommets navn til:" + rom.getNavn() + " og id: " + rom.getRomId());
		
		rom = selectRom(rom.getRomId());
		System.out.println("Hentet ut rom med navn: " + rom.getNavn() + " som og har id: " + rom.getRomId());
		
		System.out.println("Test Utført!");
	}
	
	private static Rom mockRomWith(int romId) {
		Rom rom = new Rom("Kaare");
		rom.setRomId(romId);
		return rom;
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
//		int romId = 113;
//		Rom testRom  = selectRom(romId);
//		System.out.println(testRom.getNavn());
//	}
}