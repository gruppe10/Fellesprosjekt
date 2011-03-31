/*
 * Created on Oct 27, 2004
 *
 */
package no.ntnu.fp.net.co;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import no.ntnu.fp.net.admin.Log;
import no.ntnu.fp.net.cl.ClException;
import no.ntnu.fp.net.co.Connection;

/**
 * Simplest possible test application, client part.
 *
 * @author seb, steinjak
 */
public class TestCoClient {

  /**
   * Empty.
   */
  public TestCoClient() {
  }

  /**
   * Program Entry Point.
 * @throws ClException 
   */
  public static void main (String args[]) throws ClException{

    // Set up log
    Log log = new Log();
    log.setLogName("Client");

    // Connection object listening on 4001
    Connection conn = new ConnectionImpl(4001);
    InetAddress addr;  // will hold address of host to connect to
    try {
      // get address of local host and connect
      addr = InetAddress.getLocalHost();
      conn.connect(addr, 5555);
      // send two messages to server
      conn.send("Packet1");
      conn.send("Packet2");
      conn.send("Packet3");
      conn.send("Packet4");
      // write a message in the log and close the connection
      Log.writeToLog("Client is now closing the connection!",
		     "TestApplication");
      conn.close();
    }

    catch (ConnectException e){
      Log.writeToLog(e.getMessage(),"TestApplication");
      e.printStackTrace();
    }
    catch (UnknownHostException e){
      Log.writeToLog(e.getMessage(),"TestApplication2");
      e.printStackTrace();
    }
    catch (IOException e){
      Log.writeToLog(e.getMessage(),"TestApplication3");
      e.printStackTrace();
    }

    System.out.println("CLIENT TEST FINISHED");
    Log.writeToLog("CLIENT TEST FINISHED","TestApplication");
  }

}
