package no.ntnu.fp.model.record;

/*	About:
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
 *	 getStatusFor(int id, int id)
 *	 exists(int avtaleId)
 *	
 *	 createDeltakereMedStatus(Mote mote);
 *	 selectDeltakereMedStatus(int hendelseId);
 * 
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import no.ntnu.fp.model.*;

//import org.apache.derby.tools.sysinfo;

public class ActiveHendelse extends ActiveModel{
	
	public static Avtale createAvtale(Avtale avtale){
		if(avtale.getAvtaleId() == null){
			int nextAvailableId = nextAvailableIdFor("Hendelse");
			avtale.setAvtaleId((nextAvailableId));
		}
		PreparedStatement ps = null;
		try{
			connect();
			if( connection != null){
				ps = connection.prepareStatement(
					"INSERT INTO Hendelse(hendelseId, navn, beskrivelse, dato, starttid, sluttid, lederId)" +
					"VALUES ( ?, ?, ? ,? ,? ,? , ? )" 
				);
				ps.setInt(1, avtale.getAvtaleId());
				ps.setString(2, avtale.getNavn());
				ps.setString(3, avtale.getBeskrivelse());
				ps.setDate(4, formatDateFrom(avtale));
				ps.setTime(5, formatTimeFrom(avtale.getStarttid()));
				ps.setTime(6, formatTimeFrom(avtale.getSluttid()));
				ps.setInt(7, avtale.getInitiativtaker().getAnsattNummer());
				ps.execute();
				
				connection.close();
				}
		}
		catch(SQLException e){
			System.out.println("Kan ikke lagre avtalen");
			System.out.println("Details:" + e.getMessage());
		}
		return avtale;
	}
	
	public static Mote createMote(Mote mote){
		PreparedStatement ps = null;
		if(mote.getAvtaleId() == null){
			int nyId = nextAvailableIdFor("Hendelse");
			mote.setAvtaleId(nyId);
		}
		try{
			connect();
			if( connection != null){
				ps = connection.prepareStatement(
					"INSERT INTO Hendelse(hendelseId, navn, beskrivelse, dato, starttid, sluttid, LederId)" +
					"VALUES ( ?, ?, ? ,? ,? ,?, ? )" 
				);
				ps.setInt(1, mote.getAvtaleId());
				ps.setString(2, mote.getNavn());
				ps.setString(3, mote.getBeskrivelse());
				ps.setDate(4, formatDateFrom(mote));
				ps.setTime(5, formatTimeFrom(mote.getStarttid()));
				ps.setTime(6, formatTimeFrom(mote.getSluttid()));
				ps.setInt(7, mote.getInitiativtaker().getAnsattNummer());
				ps.execute();
		
				connection.close();
				
				createDeltakereMedStatus(mote);
				}
		}
		catch(SQLException e){
			System.out.println("Kan ikke lagre avtalen");
			System.out.println("Details:" + e.getMessage());
		}
		return mote;
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
	
	public static void updateMote(Mote mote){		
		try {
        	connect();
        	if( connection != null ){
	            PreparedStatement ps = connection.prepareStatement(
	            		"UPDATE Hendelse " + 
	            		"SET navn = ?, beskrivelse = ?, dato = ?, starttid = ?, sluttid = ? " +
	                    "WHERE hendelseId = ? "
	            );
				ps.setString(1, mote.getNavn());
				ps.setString(2, mote.getBeskrivelse());
				ps.setDate(3, formatDateFrom(mote));
				ps.setTime(4, formatTimeFrom(mote.getStarttid()));
				ps.setTime(5, formatTimeFrom(mote.getSluttid()));
				ps.setInt(6, mote.getAvtaleId());
				ps.executeUpdate();
				connection.close();
				
				//TODO Update Deltakere
				Map<Person,Status> gamleDeltagere = selectDeltakereMedStatus(mote.getAvtaleId());
				
//				for(OppdatereDeltager as nyDeltager){
//					if (nyDeltager != deltaker){
//						deleteDeltaker(gammelDeltaker);
//						createDeltaker(nyDeltaker);
//					}
//        		}
			}
		}
		catch(SQLException e){
			System.out.println("Kan ikke oppdatere avtalen");
			System.out.println("Details:" + e.getMessage());
		}
	}
	
	public static Avtale selectHendelse(int avtaleId){
		Avtale avtale = new Avtale();
		String navn = "";
		String beskrivelse = "";
		int dd = 00;
		int mm = 00;
		int yyyy = 0000;
		int starttid = 0;
		int sluttid = 0;
		//TODO Add Check for "has Deltakere" and cast Object to Mote
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
		
	public static void deleteHendelse(int avtaleId) {
		try {
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"DELETE FROM Hendelse WHERE hendelseId = ?"
				);
				ps.setInt(1, avtaleId);
				ps.execute();
				connection.close();
				//TODO Slett relaterte rader i Deltagere!
			}
		} 
		catch (SQLException e) {
			System.out.println("Failed to delete Avtale \n");
			System.out.println("Details:" + e.getMessage());
		}
	}
	
	public static Map<Person, Status> selectDeltakereMedStatus(int avtaleId) {
		ArrayList<Person> deltakere = new ArrayList<Person>();
		
		Map<Person, Status> deltakereMedStatus = new HashMap<Person, Status>();
		Iterator it = deltakereMedStatus.entrySet().iterator();
		try{
			connect();
			if(connection != null){
				//Hente ut alle deltakere og legge de til i deltakere arraylist-en
				PreparedStatement ps = connection.prepareStatement(
						"SELECT ansattId, status FROM Deltakere WHERE hendelseId = ?"
				);
				ps.setInt(1, avtaleId);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					int deltagerNr = rs.getInt("ansattnr");
					Person nyDeltager = ActivePerson.selectPerson(deltagerNr);
					deltakere.add(nyDeltager);
				};
				connection.close();	
				
				//Lage hashmap med person og status
				for (Person person : deltakere) {
					//Hente ut status for hver person
					Status status = getStatusFor(person.getAnsattNummer(), avtaleId);
					
					//legge til person og status til Mappet deltakereMedStatus
					deltakereMedStatus.put(person, status);
				}
			}
		}
		catch(SQLException e){
			System.out.println("Could not find any Participants for Meeting with id:" + avtaleId);
			System.out.println("Details:" + e.getMessage());
		}
		return deltakereMedStatus;
	}
	
	private static Status getStatusFor(int ansattId, int avtaleId) {
		Status status = Status.IKKE_MOTTATT;
		try{
			connect();
			if(connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT status FROM Deltakere Where avtaleId = ? and ansattId = ?"
				);
				ps.setInt(1, avtaleId);
				ps.setInt(2, ansattId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					String s = rs.getString("status");
					if (s == "AVSLATT"){
						status = Status.AVSLATT;
					}else if(s == "GODTATT"){
						status = Status.GODTATT;
					}
				}
				connection.close();
			}
		}
		catch(SQLException e){
			System.out.println("Could not find Status for Deltager:" +ansattId + "for mote nr:" + avtaleId );
			System.out.println("Details:" + e.getMessage());
		}					
		return status;
	}
	
	private static void setStatusFor(int ansattId, int avtaleId){
		try {
			connect();
			PreparedStatement ps = connection.prepareStatement(
					"SELECT status FROM Deltakere WHERE hendelseId = ? and ansattId = ?"
			);
			ps.setInt(1, avtaleId);
			ps.setInt(2, ansattId);
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Could not set status for deltager:" +ansattId + "for mote nr:" + avtaleId );
			System.out.println("Details:" + e.getMessage());
		}
	}
	
	public static void createDeltakereMedStatus(Mote mote){
		Map<Person, Status> deltakere = mote.getDeltakere();
		Iterator it = deltakere.entrySet().iterator();
		try{
			connect();
			if(connection != null){
				
				while(it.hasNext()){
					Map.Entry pairs = (Map.Entry)it.next();
					Person person = (Person) pairs.getValue();
					
					PreparedStatement ps = connection.prepareStatement(
							"INSERT ansattId,avtaleId INTO Deltakere values(?, ?)"
					);
					ps.setInt(1, person.getAnsattNummer());
					ps.setInt(2, mote.getAvtaleId());
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
}