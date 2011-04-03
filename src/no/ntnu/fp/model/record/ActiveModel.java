package no.ntnu.fp.model.record;

/*
 *   Methods:
 *   
 *   connect()
 *   formatDateFrom(Avtale avtale)
 *   formatTimeFrom(Int int)
 *   formatIntFrom(Date date)
 */

import java.sql.*;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Person;
import org.apache.derby.tools.sysinfo;


import no.ntnu.fp.model.record.*;

public class ActiveModel {
	private static String db_url = "Kalender";
	private static String admin_name = "";
	private static String admin_pwd = "";
	protected static Connection connection ;
	
	
	protected static void connect() throws SQLException{
		try{
			connection =  DriverManager.getConnection("jdbc:derby:" + db_url, admin_name, admin_pwd );
		}
		catch(SQLException e){
			connection = null;
			System.out.println("Kan ikke koble til database");
		}	
	}
	
	public static int getMaxIdForTabel(String tabelName){
		int maxId = 0;
		try{
			connect(); 
			if( connection != null){
				PreparedStatement ps = connection.prepareStatement(
	            "SELECT MAX ansattId as maxId" +
	            "FROM ?"		    
	            );
				ps.setString(1,tabelName);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
					maxId = rs.getInt("maxId");
				}
			}
			connection.close();
		}
	    catch( SQLException e){
	    	System.out.println("Kan ikke finne max id for Person");
	    	System.out.println("ErrorMessage:" + e.getMessage());
	    }
	   return maxId;         
	}
	
	@SuppressWarnings("deprecation")
	protected static Date formatDateFrom(Avtale avtale){
		int dd = avtale.getDatoDag();
		int mm = avtale.getDatoMnd();
		int yyyy = avtale.getDatoAar();
		
		Date date = new Date(dd, mm, yyyy);
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
}