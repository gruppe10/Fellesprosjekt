package no.ntnu.fp.model.record;

/*
 *   Methods:


 *   
 * 	 create(Object object)
 * 	 select(int id)
 * 	 update(Object object)
 * 	 delete(int id)	
 * 
 */

import java.sql.*;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;
import no.ntnu.fp.model.Person;
import org.apache.derby.tools.sysinfo;


import no.ntnu.fp.model.record.*;

public class ActiveModel {
	private static String db_url = "Kal";
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