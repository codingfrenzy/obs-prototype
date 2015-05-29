import java.io.*;
import java.net.*;
import java.util.*;

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

     
     public DumpCollectDWriteHttp(Socket client) {
         connectedClient = client;
     }    
     
     public void sendResponse (String responseString) throws Exception {
    	 String statusLine = null;    	 
    	 statusLine = "HTTP/1.1 OK" + "\r\n";

    	      
    	 outToClient.writeBytes(statusLine);
    	 outToClient.writeBytes("Connection: close\r\n");
    	 outToClient.writeBytes("\r\n");
    	 outToClient.writeBytes(responseString);
    	 outToClient.close();
   }
    
    	 
     public void run() {
 
       String currentLine = "", contentLength = "";
       try {
 
         System.out.println( "The Client "+
         connectedClient.getInetAddress() + ":" + connectedClient.getPort() + " is connected");
     
         inFromClient = new BufferedReader(new InputStreamReader (connectedClient.getInputStream()));          
         outToClient = new DataOutputStream(connectedClient.getOutputStream());
 
         currentLine = inFromClient.readLine();
         String headerLine = currentLine;        
         StringTokenizer tokenizer = new StringTokenizer(headerLine);
         String httpMethod = tokenizer.nextToken();
         String httpQueryString = tokenizer.nextToken();
 
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
