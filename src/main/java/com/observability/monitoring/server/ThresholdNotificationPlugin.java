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
package com.observability.monitoring.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.collectd.api.Collectd;
import org.collectd.api.CollectdConfigInterface;
import org.collectd.api.CollectdInitInterface;
import org.collectd.api.CollectdNotificationInterface;
import org.collectd.api.CollectdShutdownInterface;
import org.collectd.api.Notification;
import org.collectd.api.OConfigItem;
import org.collectd.api.OConfigValue;

/**
 * ThresholdNotificationPlugin is a Java plugin for Collectd. It needs to be installed on collectd server.<br>
 * It performs the following functions:<br>
 * 1. Receive alert notifications from Collectd server as a plugin<br>
 * 2. Send notifications to predefined email addresses<br>
 * 3. Write log to collect log file<br>
 *
 * <p>
 * Build jar file: jar cvf thresholdnotification.jar com/observability/monitoring/server/*Notification*.class
 * <p>
 * @author Ying (Joel) Gao
 * <p>
 * History:<br>
 * 1. Created					Jun 09 2015<br>
 * 2. Modified					Jun 14 2015<br>
 * 3. Modified 					Jly 04 2015<br>
 * 4. Modified 					Jly 10 2015<br>
 * 5. Modified 					Jly 11 2015<br>
 * 6. Modified 					Jly 14 2015<br>
 */

public class ThresholdNotificationPlugin implements CollectdConfigInterface,
													CollectdInitInterface,
													//CollectdReadInterface,
													//CollectdWriteInterface,
													CollectdNotificationInterface,
													CollectdShutdownInterface 
{
	/**
     * Email recipients list
     */
	private List<String> emailRecipients = new ArrayList<String>();
	
	/**
     * Email sending class
     */
	private NotificationEMail emailSender = new NotificationEMail();
	
	/**
	 * URL for dashboard alert notification
	 */
	private String urlDashboardNotification = null;
	
	/**
	 * URL user agent
	 */
	//private final static String USER_AGENT = "Mozilla/5.0";

    /**
     * Constructor
     */
	public ThresholdNotificationPlugin() {
		// read configuration
		Collectd.registerConfig   ("ThresholdNotificationPlugin", this);
		// init
	    Collectd.registerInit     ("ThresholdNotificationPlugin", this);
	    // read
	    //Collectd.registerRead     ("ThresholdNotificationPlugin", this);
	    // write
	    //Collectd.registerWrite    ("ThresholdNotificationPlugin", this);
	    // notification
	    Collectd.registerNotification("ThresholdNotificationPlugin", this);
	    // shutdown
	    Collectd.registerShutdown ("ThresholdNotificationPlugin", this);
	}
	
	
	/**
     * Plugin init
     * @return result
     */
	public int init() {
		// nothing to do now
		return 0;
	}
	
	/**
     * Plugin shutdown
     * @return result
     */
	public int shutdown() {
		// nothing to do now
		return 0;
	}
	
	/**
     * Notification message from collectd
     * @param arg0 the notification structure
     * @return result
     */
	public int notification(Notification arg0) {
		
		int recipientNum = emailRecipients.size();
		if(recipientNum == 0) // no recipients defined
			return 0;
		
		// 1. send email
		// email body
		final String body = arg0.toString();
		// email header
		final String header = "Observability Notification: " + arg0.getSeverityString() + " From node: " + arg0.getHost();
		// for debug purpose
		//Collectd.logInfo("ThresholdNotificationPlugin sending notification: " + body);
		//sendEMail(emailRecipients, header, body, false);
		// send out email in plain text
		boolean ret = emailSender.sendEMail(emailRecipients, header, body, false);
		if(!ret){
			Collectd.logInfo("ThresholdNotificationPlugin sending notification failed.");
		}
		
		// 2. send to dashboard
		sendNotificationToDashboard(arg0);
		
		return 0;
	}
	
	/**
     * Send notification message to grafana dashboard
     * @param arg0 the notification structure
     * 
     */
	private void sendNotificationToDashboard(Notification arg0) {
		// prepare for connection
		//Collectd.logInfo("ThresholdNotificationPlugin - sendNotificationToDashboard: 1 - " + urlDashboardNotification);
 
		// prepare the parameters
		// sample:
		//timestamp=Sat Jul 04 23:34:35 EDT 2015&metricpath=joel-ThinkPad-T440s/cpu/3/cpu/system&type=FAILURE&host=joel-ThinkPad-T440s
		//&plugin=cpu (instance 3)&pluginInstance=cpu (instance system)&message=Data source "value" is currently 1.100000. That is above the failure threshold of 0.900000.
		 
		// 1. get time string
		Date date = new Date(arg0.getTime());
		//Date date = new Date();
		DateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");
		//format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String timeFormatted = format.format(date);
		// 2. get metric path
		String metricPath = arg0.getHost() + "/" + 
							arg0.getPlugin() + "/" +
							arg0.getPluginInstance() + "/" +
							arg0.getType() + "/" +
							arg0.getTypeInstance();
		// 3. get message
		String message = arg0.getMessage();
		// rip off everything before :
		int ndx = message.indexOf(":");
		if(ndx != -1) {
			message = message.substring(ndx + 1, message.length() - 1);
		}
		
		// the full parameter
		String urlParameters = "timestamp=" + timeFormatted +
							   "&metricpath=" + metricPath +
							   "&type=" + arg0.getSeverityString() +
							   "&host=" + arg0.getHost() +
							   "&plugin=" + arg0.getPlugin() + " (instance " + arg0.getPluginInstance() + ")" +
							   "&pluginInstance=" + arg0.getType() + " (instance " + arg0.getTypeInstance() + ")" +
							   "&message=" + message;
 
		//Collectd.logInfo("ThresholdNotificationPlugin - sendNotificationToDashboard: 4 " + urlParameters);
		
		String encodedParameter = null;
		try {
			encodedParameter = URLEncoder.encode(urlParameters, "UTF-8");
			String s1 = encodedParameter.replace("%3D", "=");
			encodedParameter = s1.replace("%26", "&");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Collectd.logError("sendNotificationToDashboard - Encode url failed");
			return;
		}
		
		// Send post request - using curl
		try {
			// start process with sudo (required by collectd)
			//String commandString = "curl -X POST --data \"" + encodedParameter + "\" " + urlDashboardNotification;
			String commandString = "curl -X POST --data " + encodedParameter + " " + urlDashboardNotification;
			//Collectd.logInfo(commandString);
			//Process p;			// initialize a process class
			//BufferedReader outReader = null;
			Runtime.getRuntime().exec(commandString);
			//p.waitFor();		// wait for it to finish execution
		    //if (p.exitValue() != 0){		// if there is an error
		    //	p.getErrorStream()
		    // fetch the result:
			/*
		    outReader = new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
		    String serr = "";
		    while((serr = outReader.readLine()) != null){
		    	Collectd.logInfo("Error executing curl:" + serr);
		    }
		    //String output = outReader.readLine();
		    */
		    
		} catch (Exception e) {
	        e.printStackTrace();
	        Collectd.logError("Cannot run curl to dispatch notification");
	    }
	}
	/*
	private void sendNotificationToDashboard(Notification arg0) {
		// prepare for connection
		Collectd.logInfo("ThresholdNotificationPlugin - sendNotificationToDashboard: 1 - " + urlDashboardNotification);
		URL obj = null;
		HttpsURLConnection con = null;
		try {
			obj = new URL(urlDashboardNotification);
			
			Collectd.logInfo("ThresholdNotificationPlugin - sendNotificationToDashboard: 2");
			System.setProperty("http.keepAlive", "false");
			con = (HttpsURLConnection) obj.openConnection();
			
			Collectd.logInfo("ThresholdNotificationPlugin - sendNotificationToDashboard: 3");
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Collectd.logError("sendNotificationToDashboard - Create url failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Collectd.logError("sendNotificationToDashboard - Create connection failed");
		}
		
		
 
		// prepare the parameters
		// sample:
		//timestamp=Sat Jul 04 23:34:35 EDT 2015&metricpath=joel-ThinkPad-T440s/cpu/3/cpu/system&type=FAILURE&host=joel-ThinkPad-T440s
		//&plugin=cpu (instance 3)&pluginInstance=cpu (instance system)&message=Data source "value" is currently 1.100000. That is above the failure threshold of 0.900000.
		 
		// 1. get time string
		Date date = new Date(arg0.getTime() * 1000L);
		DateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:MM:ss.SSS");
		//format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String timeFormatted = format.format(date);
		// 2. get metric path
		String metricPath = arg0.getHost() + "/" + 
							arg0.getPlugin() + "/" +
							arg0.getPluginInstance() + "/" +
							arg0.getType() + "/" +
							arg0.getTypeInstance();
		// 3. get the value and threshold
		//String message = arg0.getMessage();
		
		// the full parameter
		String urlParameters = "timestamp=" + timeFormatted +
							   "&metricpath=" + metricPath +
							   "&type=" + arg0.getSeverityString() +
							   "&host=" + arg0.getHost() +
							   "&plugin=" + arg0.getPlugin() + " (instance " + arg0.getPluginInstance() + ")" +
							   "&pluginInstance=" + arg0.getType() + " (instance " + arg0.getTypeInstance() + ")" +
							   "&message=" + arg0.getMessage();
 
		Collectd.logInfo("ThresholdNotificationPlugin - sendNotificationToDashboard: 4 " + urlParameters);
		
		String encodedParameter = null;
		try {
			encodedParameter = URLEncoder.encode(urlParameters, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Collectd.logError("sendNotificationToDashboard - Encode url failed");
			return;
		}
		Collectd.logInfo(urlDashboardNotification + encodedParameter);
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr;
		try {
			wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(encodedParameter);
			wr.flush();
			wr.close();
			// get response in case it is reuqired by server
			//int responseCode = con.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Collectd.logError("sendNotificationToDashboard - POST request failed");
		}
	}*/
	
	/**
     * Add email recipient from configuration file
     * @param ci configuration item
     */
	private void addEMailRecipient(OConfigItem ci) {
		//Collectd.logInfo("ObsAggregationPlugin plugin: config: ci = " + ci.toString() + ";");
		// Get values of the configuration item
		List<OConfigValue> values = ci.getValues();
  	  	if(values != null && values.size() > 0) {
  	  		OConfigValue cv = values.get(0);
  	  		//Collectd.logInfo("ObsAggregationPlugin plugin: config: cv = " + cv.toString() + ";");
  	  		if (cv.getType () == OConfigValue.OCONFIG_TYPE_STRING) {
  	  			emailRecipients.add(cv.toString());
  	  		}
  	  	}
	}
	
	private void getNotificationURL(OConfigItem ci) {
		// Get values of the configuration item
		List<OConfigValue> values = ci.getValues();
		if(values != null && values.size() > 0) {
			OConfigValue cv = values.get(0);
		  	//Collectd.logInfo("ObsAggregationPlugin plugin: config: cv = " + cv.toString() + ";");
		  	if (cv.getType () == OConfigValue.OCONFIG_TYPE_STRING) {
		  		urlDashboardNotification = cv.toString();
		  	}
		}
	}

	/**
     * Get configuration from collectd
     * @param ci configuration item
     * @return result
     */
	public int config(OConfigItem ci) {
		List<OConfigItem> children;
	    int i;

	    //Collectd.logInfo("ObsAggregationPlugin plugin: config: ci = " + ci.toString() + ";");
	    // Children of the configuration item
	    children = ci.getChildren ();
	    for (i = 0; i < children.size (); i++)
	    {
	      OConfigItem child;
	      String key;

	      child = children.get (i);
	      key = child.getKey ();
	      // recipient 1 
	      if (key.equalsIgnoreCase ("recpt1"))
	      {
	    	  addEMailRecipient(child);
	      }// recipient 2
	      else if (key.equalsIgnoreCase ("recpt2"))
	      {
	    	  addEMailRecipient(child);
	      }// recipient 3
	      else if (key.equalsIgnoreCase ("recpt3"))
	      {
	    	  addEMailRecipient(child);
	      }// httpip - url for dashboard
	      else if (key.equalsIgnoreCase ("httpip"))
	      {
	    	  getNotificationURL(child);
	      }
	    }
	    // write to collectd.log
	    Collectd.logInfo("ThresholdNotificationPlugin started..." + emailRecipients.size() + " email recipient(s) added");
	    for(int j = 0 ; j < emailRecipients.size() ; j++) {
	    	Collectd.logInfo("ThresholdNotificationPlugin alert notification recipient: " + emailRecipients.get(j));
	    }
		return 0;
	}
}
