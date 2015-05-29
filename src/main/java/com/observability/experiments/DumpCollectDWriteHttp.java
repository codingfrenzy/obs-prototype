//**************************************************************************************************//
/* Observability Project
 * Copyright 2015 Master of Software Engineering team: Laila Alhmound, Ying (Joel) Gao, Caglayan Gem, Rajat Kapoor, Prasanth Nair, Varun Saravagi
 * Copyright 2015 Institute for Software Research | School of Computer Science | Carnegie Mellon University
 * Copyright 2015 Software Engineering Institute
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses/>.
 */
//**************************************************************************************************//

package com.observability.experiments;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * DumpCollectDWriteHttp is an experiment to dump the content of collectd's write_HTTP plugin.
 * It is a HTTP server that handles the POST requests of write_HTTP plugin.
 * @author Ying (Joel) Gao
 * 
 * History: 
 * 1. Created					May 28 2015
 * 2. Modified					May 29 2015
 *
 */

public class DumpCollectDWriteHttp extends Thread {

     static final String HTML_START =
             "<html>" +
             "<title>HTTP POST Server in java</title>" +
             "<body>";
     
     static final String HTML_END =
             "</body>" +
             "</html>";
     
     Socket connectedClient = null;
     BufferedReader inFromClient = null;
     DataOutputStream outToClient = null;

     
     /**
 	 * Constructor
 	 * 
 	 * @param client the connected socket
 	 */
     
     public DumpCollectDWriteHttp(Socket client) {
         connectedClient = client;
     }    
     
     /**
  	 * Send response back to write_HTTP plugin. The plugin will have a warning without reply.
  	 * 
  	 * @param responseString the response string
  	 */
     public void sendResponse (String responseString) throws Exception {
    	 String statusLine = null;    	 
    	 statusLine = "HTTP/1.1 OK" + "\r\n";

    	      
    	 outToClient.writeBytes(statusLine);
    	 outToClient.writeBytes("Connection: close\r\n");
    	 outToClient.writeBytes("\r\n");
    	 outToClient.writeBytes(responseString);
    	 outToClient.close();
     }
    
     /**
   	 * Run the thread to receive all POST contents.
   	 * 
   	 * 
   	 */
     public void run() {
 
       String currentLine = "";
       try {
 
         System.out.println( "The Client "+
         connectedClient.getInetAddress() + ":" + connectedClient.getPort() + " is connected");
     
         inFromClient = new BufferedReader(new InputStreamReader (connectedClient.getInputStream()));          
         outToClient = new DataOutputStream(connectedClient.getOutputStream());
 
         currentLine = inFromClient.readLine();
         if(currentLine == null)
        	 return;
         String headerLine = currentLine;        
         StringTokenizer tokenizer = new StringTokenizer(headerLine);
         String httpMethod = tokenizer.nextToken();
         
         System.out.println(currentLine);
         
         //while(true){
        	 Thread.sleep(20);
         
	         if (httpMethod.equals("GET")) {
	             System.out.println("GET request");
	             
	         } else { //POST request
	             System.out.println("POST request");
	             do {
	                 currentLine = inFromClient.readLine();
	                 System.out.println(currentLine);
	                 /*                    
	                 if (currentLine.indexOf("Content-Type: multipart/form-data") != -1) {
	                   String boundary = currentLine.split("boundary=")[1];
	                   // The POST boundary                           
	           
	                   while (true) {
	                       currentLine = inFromClient.readLine();
	                       System.out.println("Content Length = " + contentLength);
	                   }*/                                        
	             }while (inFromClient.ready()); //End of do-while
	           }//else
	       //}
	         sendResponse("OK");
	         inFromClient.close();
	         outToClient.close();
	         connectedClient.close();
       }catch (Exception e) {
	       e.printStackTrace();
	   }
   }

     
     public static void main (String args[]) throws Exception {
 
         ServerSocket Server = new ServerSocket (8080, 100, InetAddress.getByName("127.0.0.1")); 
         System.out.println ("HTTP Server Waiting for client on port 8080");
                         
         while(true) {                                 
                 Socket connected = Server.accept();
                 (new DumpCollectDWriteHttp(connected)).start();
         }
     }
}
