package no.ntnu.fp.model.record;

/*
 *   Methods:  
 * 	 CRUD-Rom;
 * 	 selectLedigeTider()
 * 	 Create, delete Reservasjon
 */

import java.sql.*;
import java.util.ArrayList;

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Rom;

//import org.apache.derby.tools.sysinfo;

public class ActiveRom extends ActiveModel{
	public static void createRom(Rom rom){
		if(rom.getRomId() == null){
			int nextAvailableId = nextAvailableIdFor("Rom");
			rom.setRomId(nextAvailableId);
		}
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

	// Lager en boolean array med 24 ruter
	// rute nr 12 er true dersom den er ledig fra kl 12 til 13
	public static boolean[] selectLedigeTider(int romId, Date date){
		boolean[] ledigeTider = new boolean[23];
		try{
			connect();
			if(connection != null){
				PreparedStatement ps = connection.prepareStatement(			
						" SELECT starttid, sluttid " +
						" FROM  Hendelse, ReserverteRom, Rom   " +
						" WHERE Hendelse.dato = ? " +
						" AND Rom.romId = ? " +
						" And reserverteRom.romId = ?" + 
						" AND ReserverteRom.hendelseId = Hendelse.hendelseId " 
				);
				ps.setDate(1, date);
				ps.setInt(2, romId);
				ps.setInt(3, romId);
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
					"INSERT INTO ReserverteRom(romId ,hendelseId) VALUES(?,?) "
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
					"WHERE romId = ? AND hendelseId = ? " 
			);
			ps.setInt(1, romId);
			ps.setInt(2,avtaleId);
		}catch(SQLException e){
			System.out.println("Kan ikke reservere rom med id: " + romId + " for avtale: " + avtaleId);
			System.out.println("Detaljer:" + e.getMessage());
		}
	}
}