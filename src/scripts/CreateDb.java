package scripts;

import java.sql.Statement;

import no.ntnu.fp.model.record.ActiveModel;

public class CreateDb extends ActiveModel{
	public static void main(String[] args){
		createDB();
		System.out.println("doom, doom, doom, done!");
	}

	protected static void createDB(){
		try{
			connect();
			Statement s = connection.createStatement();
//			s.execute("Drop table Deltakere");
//			s.execute("Drop table ReserverteRom");
//
//			s.execute("Drop table Hendelse");
//			s.execute("Drop table Rom");
//			s.execute("Drop table Person");
			
			s.execute(
					"CREATE TABLE Person( " +
					"ansattId INT PRIMARY KEY NOT NULL," +
					"navn VARCHAR(50) NOT NULL," +
					"brukernavn VARCHAR(50) NOT NULL," +
					"passord VARCHAR(50) NOT NULL" +
					")"
			);
			s.execute(
					"CREATE TABLE Hendelse("+
					"hendelseId INT PRIMARY KEY NOT NULL ,"+
					"starttid TIME NOT NULL,"+
					"sluttid TIME NOT NULL,"+
					"dato DATE NOT NULL,"+
					"navn VARCHAR(50) NOT NULL,"+
					"beskrivelse VARCHAR(300),"+
					"lederId INT," +
					"FOREIGN KEY (lederId) REFERENCES Person(ansattId)" +
					")"
			);
			s.execute(
					"CREATE TABLE Deltakere ( "+
					"ansattId INT,"+
					"hendelseId INT,"+
					"status VARCHAR(15) NOT NULL DEFAULT 'IKKE_MOTTATT',"+
					"PRIMARY KEY (ansattId, hendelseId),"+
					"FOREIGN KEY (ansattId) REFERENCES Person(ansattId),"+
					"FOREIGN KEY (hendelseId) REFERENCES Hendelse(hendelseId) ON DELETE CASCADE" +
					")"
			);
			s.execute(
					"CREATE TABLE Rom ("+
					"romId INT PRIMARY KEY NOT NULL ,"+
					"navn VARCHAR(50) NOT NULL" +
					")"
			);
			s.execute(
					"CREATE TABLE ReserverteRom ("+
					"romId INT,"+
					"hendelseId INT,"+
					"PRIMARY KEY (romId, hendelseId),"+
					"FOREIGN KEY(romId) REFERENCES Rom(romId),"+
					"FOREIGN KEY(hendelseId) REFERENCES Hendelse(hendelseId) ON DELETE CASCADE" +
					")"
			);
			connection.close();
		}catch(Exception e ){
			System.out.println("Fikk ikke laget db.");
			System.out.println("Fordi " + e.getMessage());
		}
	}
}
