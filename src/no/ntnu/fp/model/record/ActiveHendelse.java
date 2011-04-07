package no.ntnu.fp.model.record;

/* ******** ABOUT *********	
 *   Methods:
 *   
 * 	 CreateAvtale(Avtale avtale)
 *   UpdateAvtale(Avtale avtale)
 * 	 CreateMote(Mote mote)
 * 	 UpdateMote(Mote mote)
 * 	 SelectHendelse(int hendelseID)
 *	 DeleteHendelse(int ansattnummer)	
 *
 *	 getStatusFor(int id, int id)
 *	
 *	 createDeltakereMedStatus(Mote mote)
 *	 selectDeltakereMedStatus(int hendelseId)
 *   deleteDeltakereForMote(int hendelseId)
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
			avtale.setAvtaleId(nextAvailableId);
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
				
				Person initiativtaker = avtale.getInitiativtaker();
				initiativtaker.addAvtale(avtale);
				ActivePerson.updatePerson(initiativtaker);
				
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
	
	public static Avtale selectAvtale(int avtaleId){
		Avtale hendelse = new Avtale();
		String navn = "";
		String beskrivelse = "";
		int dd = 00;
		int mm = 00;
		int yyyy = 0000;
		int starttid = 0;
		int sluttid = 0;
		Date dato = new Date();

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
						starttid = formatIntFrom(rs.getTime("starttid"));
						sluttid = formatIntFrom(rs.getTime("sluttid"));
						dato = rs.getDate("dato");
					}
				}
				connection.close();
			}
		}
		catch( SQLException e){
			System.out.println("Kan ikke finner person med id = " + avtaleId);
			System.out.println("Details:" + e.getMessage());
		}
		hendelse.setAvtaleId(avtaleId);
		hendelse.setNavn(navn);
		hendelse.setBeskrivelse(beskrivelse);
		hendelse.setDato(dato.getDate(),dato.getMonth(), dato.getYear());
		hendelse.setSluttid(sluttid);
		hendelse.setStarttid(starttid);
		return hendelse;
	}

	public static void updateAvtale(Avtale avtale){		
		try {
			connect();
			if( connection != null ){
				PreparedStatement ps = connection.prepareStatement(
						"UPDATE Hendelse SET navn = ?, beskrivelse = ?, dato = ?, starttid = ?, sluttid = ? WHERE hendelseId = ? "
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

	public static void updateMote(Mote mote){		
		try {
			connect();
			if( connection != null ){
				PreparedStatement ps = connection.prepareStatement(
						"UPDATE Hendelse SET navn = ?, beskrivelse = ?, dato = ?, starttid = ?, sluttid = ? WHERE hendelseId = ? "
				);
				ps.setString(1, mote.getNavn());
				ps.setString(2, mote.getBeskrivelse());
				ps.setDate(3, formatDateFrom(mote));
				ps.setTime(4, formatTimeFrom(mote.getStarttid()));
				ps.setTime(5, formatTimeFrom(mote.getSluttid()));
				ps.setInt(6, mote.getAvtaleId());
				ps.executeUpdate();
				connection.close();

				deleteDeltakereForMote(mote.getAvtaleId());
				createDeltakereMedStatus(mote);
			}
		}
		catch(SQLException e){
			System.out.println("Kan ikke oppdatere avtalen");
			System.out.println("Details:" + e.getMessage());
		}
	}

	public static Mote selectMote(int avtaleId){
		Mote hendelse = new Mote();
		String navn = "";
		String beskrivelse = "";
		int dd = 00;
		int mm = 00;
		int yyyy = 0000;
		int starttid = 0;
		int sluttid = 0;

		Map<Person,Status> deltakere = selectDeltakereMedStatus(avtaleId);
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
		hendelse.setAvtaleId(avtaleId);
		hendelse.setNavn(navn);
		hendelse.setBeskrivelse(beskrivelse);
		hendelse.setDato(dd, mm, yyyy);
		hendelse.setSluttid(sluttid);
		hendelse.setStarttid(starttid);
		hendelse.leggtilDeltakere(deltakere);
		
		return hendelse;
	}
	
	public static boolean isMote(int avtaleId){
		Map<Person,Status> deltakere = selectDeltakereMedStatus(avtaleId);
		boolean isMote = false;
		if(!deltakere.isEmpty()){
			isMote = true;
		}
		return isMote;
	}

	public static void deleteHendelse(int avtaleId) {
		try {
			if(hendelseIsAMote(avtaleId)){
				deleteDeltakereForMote(avtaleId);
			}
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"DELETE FROM Hendelse WHERE hendelseId = ? "
				);
				ps.setInt(1, avtaleId);
				ps.execute();
				connection.close();	
			}
		} 
		catch (SQLException e) {
			System.out.println("Failed to delete Avtale");
			System.out.println("Details:" + e.getMessage());
		}
	}


	private static Status getStatusFor(int ansattId, int avtaleId) {
		Status status = Status.IKKE_MOTTATT;
		try{
			connect();
			if(connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT status FROM Deltakere Where hendelseId = ? and ansattId = ?"
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

	private static void setStatusFor(String status, int ansattId, int avtaleId){
		try {
			connect();
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE Deltakere SET status = ? WHERE hendelseId = ? and ansattId = ?"
			);
			ps.setString(1, status);
			ps.setInt(2, avtaleId);
			ps.setInt(3, ansattId);
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
					Person person = (Person) pairs.getKey();
					Status status = (Status) pairs.getValue();

					PreparedStatement ps = connection.prepareStatement(
							"INSERT INTO Deltakere(ansattId, hendelseId, status) VALUES(?, ?, ?)"
					);
					ps.setInt(1, person.getAnsattNummer());
					ps.setInt(2, mote.getAvtaleId());
					ps.setString(3, status.toString());
					
					ps.executeUpdate();
				}
				connection.close();
			}
		}
		catch(SQLException e){
			System.out.println("Could not create Participants for Meeting with id:" + mote.getAvtaleId());
			System.out.println("Details:" + e.getMessage());
			System.out.println(e.getStackTrace().toString());
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
					int deltagerNr = rs.getInt("ansattId");
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

	private static void deleteDeltakereForMote(int hendelseId) {
		try{
			connect();
			if(connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"Delete * FROM Deltakere WHERE hendelseId = ?"
				);
				ps.setInt(1, hendelseId);
				ps.execute();
				connection.close();				
			}
		}
		catch(SQLException e){
			System.out.println("Could not delete any Participants for Meeting with id:" + hendelseId);
			System.out.println("Details:" + e.getMessage());
		}
	}
	
	public static boolean hendelseIsAMote(int hendelseId){
		boolean isMote = false;
		try{
			connect();
			if(connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT * FROM Deltakere" +
						"WHERE hendelseId = ? "
				);
				ps.setInt(1, hendelseId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					isMote = true;
				}
				connection.close();
			}
		}
		catch(SQLException e){
			//
		}
		return isMote;
	}
}