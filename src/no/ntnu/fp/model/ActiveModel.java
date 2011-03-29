package no.ntnu.fp.model;

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
import no.ntnu.fp.model.Person;
import org.apache.derby.tools.sysinfo;


import no.ntnu.fp.model.record.*;

public class ActiveModel {
	private static String db_url = "Kal";
	private static String admin_name = "";
	private static String admin_pwd = "";
	protected static Connection connection ;
	
	public static void create(Object object){
		if( object.getClass()!= Person.class){
			ActivePerson.createPerson((Person)object);
		}
		else if( object.getClass()!= Mote.class){
			//Do something else
		}
	}
}