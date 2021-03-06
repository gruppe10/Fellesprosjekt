package no.ntnu.fp.model.record;

/*
 *   Methods:    
 *   connect()
 *   formatDateFrom(Avtale avtale)
 *   formatTimeFrom(Int int)
 *   formatIntFrom(Date date)
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Scanner;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Person;
//import org.apache.derby.tools.sysinfo;


import no.ntnu.fp.model.record.*;

public class ActiveModel {
	private static String db_url = "Kalender4";
	private static String admin_name = "";
	private static String admin_pwd = "";
	protected static Connection connection ;


	protected static void connect() throws SQLException{
		try{
			//Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			connection =  DriverManager.getConnection("jdbc:derby:"+ db_url +";create=true");

		}
		catch(Exception e){
			connection = null;
			System.out.println("Kan ikke koble til database");
			System.out.println("Details:" + e.getMessage());
		}	
	}


	//Returnerer siste id i tabellen + 1 
	public static int nextAvailableIdFor(String tabelName){
		int maxId = 0;
		String idName = getIdNameFor(tabelName);
		try{
			connect(); 
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT MAX(" + idName + ") " +
						"as maxId FROM " + tabelName 		    
				);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					maxId = rs.getInt("maxId");
				}
				ps.close();
				rs.close();   
				connection.close();
			}
		}
		catch( SQLException e){
			System.out.println("Kan ikke finne max id for " + tabelName);
			System.out.println("ErrorMessage:" + e.getMessage());
		}
		return maxId + 1;         
	}

	public static boolean exists(String tableName, int id) {
		boolean exists = false;
		String idName = getIdNameFor(tableName);
		try{
			connect();
			if(connection != null){
				PreparedStatement ps = connection.prepareStatement(
						"SELECT * FROM " + tableName + " WHERE " + idName + " = " + id
				);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					exists = true;
				}
				connection.close();
			}
		}
		catch(SQLException e){
			System.out.println("Exists could not find "+ tableName + "with id: " + id);
			System.out.println("Details:" + e.getMessage());
		}
		return exists;
	}

	@SuppressWarnings("deprecation")
	protected static Date formatDateFrom(Avtale avtale){
		int dd = avtale.getDatoDag();
		int mm = avtale.getDatoMnd();
		int yyyy = avtale.getDatoAar();

		Date date = new Date(yyyy, mm, dd);
		return date;
	}

	@SuppressWarnings("deprecation")
	protected static Time formatTimeFrom(int tid){ 
		Time time = new Time(tid, 00, 00);
		return time;
	}

	@SuppressWarnings("deprecation")
	protected static int formatIntFrom(Time time){
		int i = time.getHours();
		return i;
	}

	private static String getIdNameFor(String tabelName){
		if(tabelName == "Person"){
			return "ansattId";
		}
		if (tabelName == "Hendelse"){
			return "hendelseId";
		}
		if(tabelName == "Rom"){
			return "romId";
		}
		else {
			return "Tabel Har feil Navn";
		}
	}	

}