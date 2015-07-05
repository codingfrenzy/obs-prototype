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

import java.util.ArrayList;
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
 * Build jar file: jar cvf thresholdnotification.jar com/observability/monitoring/server/ThresholdNotificationPlugin.class
 * <p>
 * @author Ying (Joel) Gao
 * <p>
 * History:<br>
 * 1. Created					Jun 09 2015<br>
 * 2. Modified					Jun 14 2015<br>
 * 3. Modified 					Jly 04 2015<br>
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
	NotificationEMail emailSender = new NotificationEMail();

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
		
		// email body
		final String body = arg0.toString();
		// email header
		final String header = "Observability Notification: " + arg0.getSeverityString() + " From node: " + arg0.getHost();
		// for debug purpose
		Collectd.logInfo("ThresholdNotificationPlugin sending notification: " + body);
		//sendEMail(emailRecipients, header, body, false);
		// send out email in plain text
		boolean ret = emailSender.sendEMail(emailRecipients, header, body, false);
		if(!ret){
			Collectd.logInfo("ThresholdNotificationPlugin sending notification failed.");
		}
		
		return 0;
	}
	
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
