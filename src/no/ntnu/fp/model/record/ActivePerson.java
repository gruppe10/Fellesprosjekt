package no.ntnu.fp.model.record;

/*
 *   Methods:


 *   
 * 	 createPerson(Person person)
 * 	 selectPerson(int ansattnummer)
 * 	 updatePerson(Person person)
 * 	 deletePerson(int ansattnummer)	
 *
 *	 getMaxId()
 *
 *	 selectMoter(Int id)
 *	 selectAvtaler(Int id)
 *   
 */

import java.sql.*;
import java.util.ArrayList;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Person;

import org.apache.derby.impl.sql.compile.CreateAliasNode;
import org.apache.derby.tools.sysinfo;

public class ActivePerson extends ActiveModel{
	
	public static Person createPerson(Person person){
		if(person.getAnsattNummer() == null){
			int nextAvailableId = nextAvailableIdFor("Person");
			person.setAnsattNummer(nextAvailableId);
		}
		try{
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO Person(ansattId, navn, brukernavn, passord)" +
					"VALUES ( ?, ?, ? ,? )" 
				);
				ps.setInt(1, person.getAnsattNummer());
				ps.setString(2, person.getName());
				ps.setString(3, person.getBrukerNavn());
				ps.setString(4, person.getPassord());
				ps.execute();
				connection.close();
			}
			
			ArrayList<Avtale> avtaler = person.getAvtaler();
			if(avtaler != null){
				for (Avtale avtale : avtaler) {
					ActiveHendelse.createAvtale(avtale);
				}
			}
			
			ArrayList<Mote> moter = person.getMoter();
			if(moter != null){
				for (Mote mote : moter) {
					ActiveHendelse.createMote(mote);
				}
			}
		}
		catch(SQLException e){
			System.out.println("Kan ikke lage person. Feilmelding:");
			System.out.println(e.getMessage());
		}
		return person;
	}
	
	public static void updatePerson(Person person){
		String navn = person.getName();
		String brukernavn = person.getBrukerNavn();
		String passord = person.getPassord();
		int ansattId = person.getAnsattNummer();
		
		try {
        	connect();
        	if( connection != null){
        		PreparedStatement ps = connection.prepareStatement(
	            		"UPDATE Person " + 
	            		"SET navn= ? , brukernavn = ?, passord = ?" +
	                    "WHERE ansattId = ? "
	            );
	            ps.setString(1, navn);
	            ps.setString(2, brukernavn);
	            ps.setString(3, passord);
	            ps.setInt(4, ansattId);
	            ps.executeUpdate();
	            connection.close();
	            
	            ArrayList<Avtale> avtaler = person.getAvtaler();
	            if(!avtaler.isEmpty()){
					for (Avtale avtale : avtaler) {
						ActiveHendelse.updateAvtale(avtale);
					}
				}
	            
	            ArrayList<Mote> moter = person.getMoter();
	            if(!moter.isEmpty()){
					for (Mote mote : moter) {
						ActiveHendelse.updateMote(mote);
					}
				}
        	}  
        }
		catch (SQLException e){
        	System.out.println("Kan ikke oppdatere!");
        	System.out.println("Detaljer:" + e.getMessage());
        }
	}
	
	public static Person selectPerson(int ansattId){
		Person person = new Person();
		String navn  = "";
		String brukernavn = "";
		String passord = "";
		ArrayList<Avtale> avtaler = selectAvtaler(ansattId);
		ArrayList<Mote> moter = selectMoter(ansattId);

		
		try{
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT * FROM Person WHERE ansattId = ? "
				);
				ps.setInt(1, ansattId);
				
				ResultSet rs = ps.executeQuery(); 
				if (rs != null){
					while(rs.next()){
						navn = rs.getString("navn");
						brukernavn = rs.getString("brukernavn");
						passord = rs.getString("passord");
					}
				}
				connection.close();
			}
		}
		catch( SQLException e){
			System.out.println("Kan ikke finner person med id = " + ansattId);
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		person.setAnsattNummer(ansattId);
		person.setName(navn);
		person.setBrukerNavn(brukernavn);
		person.setPassord(passord);
		person.setAvtaler(avtaler);
		person.setMoter(moter);
		
		return person;
	}
	
	public static Person selectPersonByUsername(String brukernavn){
		Person person = new Person();
		String navn  = "";
		String passord = "";
		Integer ansattId = null;
		
		try{
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT * FROM Person WHERE brukernavn = ? "
				);
				ps.setString(1, brukernavn);
				
				ResultSet rs = ps.executeQuery(); 
				if (rs != null){
					while(rs.next()){
						navn = rs.getString("navn");
						brukernavn = rs.getString("brukernavn");
						passord = rs.getString("passord");
						ansattId = rs.getInt("ansattId");
					}
				}
				connection.close();
			}
		}
		catch( SQLException e){
			System.out.println("Kan ikke finner person med id = " + ansattId);
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		
		person.setAnsattNummer(ansattId);
		person.setName(navn);
		person.setBrukerNavn(brukernavn);
		person.setPassord(passord);
		person.setAvtaler(selectAvtaler(ansattId));
		person.setMoter(selectMoter(ansattId));
		
		System.out.println(person.getAvtaler().size());
		System.out.println(person.getMoter().size());

		
		return person;
	}
		
	public static void deletePerson(int ansattId) {
		// Slette alle avtaler som bare hører til denne personen
		// Dersom personen ikkje finnes eller ikke har avtaler, skjer det ingenting. 
		Person person = selectPerson(ansattId);
		for (Avtale avtale : person.getAvtaler()) {
			int avtaleId = avtale.getAvtaleId(); 
			ActiveHendelse.deleteHendelse(avtaleId);
		}
		for (Mote mote : person.getMoter()){
			int avtaleId = mote.getAvtaleId(); 
			ActiveHendelse.deleteHendelse(avtaleId);
		}
		//sletter personen
		try {
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"DELETE FROM Person WHERE ansattId = ?"
				);
				ps.setInt(1, ansattId);
				ps.execute();	
				connection.close();			
			}
		} 
		catch (SQLException e) {
			System.out.println("Kan ikke slette person med id:" + ansattId);
			System.out.println("Detaljer:" + e.getMessage());
		}
	}
	
	public static ArrayList<Mote> selectMoter(int ansattId) {
		ArrayList<Mote> hendelser = new ArrayList<Mote>();
		ArrayList<Mote> hendelserMedDeltakere = new ArrayList<Mote>();
		try{
			connect();
			if(connection != null){
				//Finne alle hendelser
				PreparedStatement ps = connection.prepareStatement(
						"SELECT hendelseId FROM Hendelse WHERE lederId = ? "
				);
				ps.setInt(1, ansattId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					int hendelseId = rs.getInt("hendelseId");
					Mote nyHendelse = ActiveHendelse.selectMote(hendelseId);
					hendelser.add(nyHendelse);
				};
				ps.close();
				connection.close();
				
				//Finn alle møter
				for (Avtale hendelse : hendelser){
					connect();
					PreparedStatement ps2 = connection.prepareStatement(
							"SELECT Hendelse.hendelseId FROM Hendelse,Deltakere " +
							"WHERE Hendelse.hendelseId = Deltakere.hendelseId " +
							"AND Hendelse.hendelseId = " + hendelse.getAvtaleId()
					);
					
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next()){
						int avtaleId = rs2.getInt("hendelseId");
						Mote mote = ActiveHendelse.selectMote(avtaleId);
						hendelserMedDeltakere.add(mote);
					}
					connection.close();	
				}
				if(connection != null) connection.close();	
			}	
		}
		catch(SQLException e){
			System.out.println("Could not find any Meetings for Person with id:" + ansattId);
			System.out.println("Details:" + e.getMessage());
		}
		return hendelserMedDeltakere;
	}
	
	public static ArrayList<Avtale> selectAvtaler(int ansattId) {
		ArrayList<Avtale> hendelser = new ArrayList<Avtale>();
		ArrayList<Avtale> hendelserMedDeltakere = new ArrayList<Avtale>();
		ArrayList<Avtale> hendelserUtenDeltakere = new ArrayList<Avtale>();
		try{
			connect();
			if(connection != null){
				//Finne alle hendelser
				PreparedStatement ps = connection.prepareStatement(
						"SELECT hendelseId FROM Hendelse WHERE lederId = ? "
				);
				ps.setInt(1, ansattId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					int hendelseId = rs.getInt("hendelseId");
					Avtale nyHendelse = ActiveHendelse.selectAvtale(hendelseId);
					hendelser.add(nyHendelse);
				};
				ps.close();
				connection.close();
				
				//Finn alle møter
				for (Avtale hendelse : hendelser){
					connect();
					PreparedStatement ps2 = connection.prepareStatement(
							"SELECT Hendelse.hendelseId FROM Hendelse,Deltakere " +
							"WHERE Hendelse.hendelseId = Deltakere.hendelseId " +
							"AND Hendelse.hendelseId = " + hendelse.getAvtaleId()
					);
					
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next()){
						int avtaleId = rs2.getInt("hendelseId");
						Avtale avtale = ActiveHendelse.selectAvtale(avtaleId);
						hendelserMedDeltakere.add(avtale);
					}
					connection.close();	
				}
				//Lag ny liste medavtaler som ikke inneholder avtaler som egentlig er Møter
				for(Avtale hendelse: hendelser){
					if(!hendelserMedDeltakere.contains(hendelse)){
						hendelserUtenDeltakere.add(hendelse);
					}
				}
				if(connection != null) connection.close();	
			}	
		}
		catch(SQLException e){
			System.out.println("Could not find any Avtaler for Person with id:" + ansattId);
			System.out.println("Details:" + e.getMessage());
		}
		return hendelserUtenDeltakere;
	}
	
	public static boolean checkPassord(String innloggingsInfo){
		String[] info = innloggingsInfo.split(",");
		String brukernavn = info[0].trim();
		String passord = info[1].trim();
		
		boolean godkjent = false;

		try{
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT distinct passord FROM Person WHERE brukernavn = ? "
						);
				ps.setString(1, brukernavn);
				ResultSet rs = ps.executeQuery(); 
				
				if (rs != null){
					while(rs.next()){
						if(passord.equals(rs.getString("passord"))){
							godkjent = true;
						}
					}
				}
				connection.close();
			}
		}
		catch( SQLException e){
			System.out.println("Kan ikke finne person med id = " );
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		return godkjent;
	}
	
	public static ArrayList<Person> selectAllPersons(){
		ArrayList<Integer> ansattIder = new ArrayList<Integer>();
		ArrayList<Person> allePersoner = new ArrayList<Person>();
		try{
			connect();
			if(connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"Select ansattId from Person"
				);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					ansattIder.add(rs.getInt("ansattId"));
				}
				connection.close();
			}
			for(Integer ansattId: ansattIder){
				allePersoner.add(selectPerson(ansattId));
			}
		}catch(SQLException e){
			System.out.println("Feil oppstod under selectAllPersons");
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		return allePersoner;
	}
	
	public static Person selectPersonWithoutFukkingShitUp(int ansattId){
		Person person = new Person();
		String navn  = "";
		String brukernavn = "";
		String passord = "";
		ArrayList<Avtale> avtaler = new ArrayList<Avtale>();
		ArrayList<Mote> moter = new ArrayList<Mote>();

		
		try{
			connect();
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT * FROM Person WHERE ansattId = ? "
				);
				ps.setInt(1, ansattId);
				
				ResultSet rs = ps.executeQuery(); 
				if (rs != null){
					while(rs.next()){
						navn = rs.getString("navn");
						brukernavn = rs.getString("brukernavn");
						passord = rs.getString("passord");
					}
				}
				connection.close();
			}
		}
		catch( SQLException e){
			System.out.println("Kan ikke finner person med id = " + ansattId);
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		person.setAnsattNummer(ansattId);
		person.setName(navn);
		person.setBrukerNavn(brukernavn);
		person.setPassord(passord);
		person.setAvtaler(avtaler);
		person.setMoter(moter);
		
		return person;
	}
	
}