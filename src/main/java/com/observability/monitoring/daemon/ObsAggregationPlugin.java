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

package com.observability.monitoring.daemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;

import org.collectd.api.Collectd;
import org.collectd.api.CollectdWriteInterface;
import org.collectd.api.DataSet;
import org.collectd.api.ValueList;
import org.collectd.api.Notification;
import org.collectd.api.OConfigItem;
import org.collectd.api.CollectdConfigInterface;
import org.collectd.api.CollectdInitInterface;
import org.collectd.api.CollectdReadInterface;
import org.collectd.api.CollectdShutdownInterface;
import org.collectd.api.OConfigValue;
import org.collectd.api.OConfigItem;

import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * ObsAggregationPlugin is a Java plugin for Collectd. It performs the following functions:<br>
 * 1. Receive performance data from Collectd server as a plugin<br>
 * 2. Aggregate performance data according to predefined formula<br>
 * 3. Send aggregated data out to be saved<br>
 * <p>
 * Build jar file: jar cvf obsaggregation.jar com/observability/monitoring/daemon/ObsAggregationPlugin.class
 * <p>
 * @author Ying (Joel) Gao
 * <p>
 * History:<br>
 * 1. Created					Jun 09 2015<br>
 */

public class ObsAggregationPlugin implements CollectdConfigInterface,
											 CollectdInitInterface,
											 CollectdReadInterface,
											 CollectdWriteInterface,
											 CollectdShutdownInterface
{
	private HashMap<String, Number> valueMap = new HashMap<String, Number>();
	
	private static final Logger LOGGER = Logger.getLogger(ObsAggregationPlugin.class.getName());
	 
	public ObsAggregationPlugin() {
		Collectd.registerConfig   ("ObsAggregationPlugin", this);
	    Collectd.registerInit     ("ObsAggregationPlugin", this);
	    Collectd.registerRead     ("ObsAggregationPlugin", this);
	    Collectd.registerWrite    ("ObsAggregationPlugin", this);
	    Collectd.registerShutdown ("ObsAggregationPlugin", this);
	    
	    //initLogger();
	}

	private void initLogger() {
		Handler fileHandler = null;
		Formatter simpleFormatter = null;
		try {
			// Creating FileHandler
			fileHandler = new FileHandler("/opt/collectd/sbin/obsaggr.formatter.log");
			// Creating SimpleFormatter
			simpleFormatter = new SimpleFormatter();
			// Assigning handler to logger
			LOGGER.addHandler(fileHandler);
			// Logging message of Level info (this should be publish in the default format i.e. XMLFormat)
			//LOGGER.info("Finnest message: Logger with DEFAULT FORMATTER");
			fileHandler.setFormatter(simpleFormatter);
			// Setting Level to ALL
			fileHandler.setLevel(Level.ALL);
			LOGGER.setLevel(Level.ALL);
			// Logging message of Level finest (this should be publish in the simple format)
			//LOGGER.finest("Finnest message: Logger with SIMPLE FORMATTER");
			LOGGER.info("Logging started");
		} catch(IOException exception) {
			LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
		}
	}
	
	private void submit (String plugin_type, String plugin_type_instance, Number aggregated_val) {
	    ValueList vl;

	    Collectd.logDebug ("ObsAggregationPlugin: plugin_type = " + plugin_type + "; "
	        + "aggregated_val = " + aggregated_val);

	    vl = new ValueList ();

	    vl.setHost ("global");
	    vl.setPlugin ("ObsAggregationPlugin");
	    //vl.setPluginInstance (plugin_instance);
	    vl.setType (plugin_type);
	    vl.setTypeInstance(plugin_type_instance);

	    if (aggregated_val.doubleValue() >= 0) {
	    	vl.addValue (aggregated_val);
	    	vl.setTypeInstance (plugin_type_instance);
	    	Collectd.dispatchValues (vl);
	    	vl.clearValues ();
	    }
	}
	
	public int shutdown() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int write(ValueList vl) {
		//! should use lock here
		// just aggregate cpu system for testing
		// key format: - host "/" plugin ["-" plugin instance] "/" type ["-" type instance]
		String type = vl.getType();
		if(type.indexOf("cpu") == -1)
			return 0;// not cpu data
		String typeInstance = vl.getTypeInstance();
		if(typeInstance!= null && typeInstance.indexOf("system") == -1)
			return 0;// not cpu-system data
		String host = vl.getHost();
		if(host != null && host.indexOf("global") != -1)
			return 0;// value from here
		String plugin = vl.getPlugin();
		String pluginInstance = vl.getPluginInstance();
		
		String key = host + "/" + plugin;
		if(pluginInstance != null && !pluginInstance.isEmpty()) {
			key +="-";
			key += pluginInstance;
		}
		key += "/";
		key += type;
		if(typeInstance != null && !typeInstance.isEmpty()) {
			key +="-";
			key += typeInstance;
		}
		List<Number> vals = vl.getValues();
		// just get the last value
		int sz = vals.size();
		if(sz <= 0)
			return 0;
		
		valueMap.put(key, vals.get(sz - 1));
		//for(int i = 0 ; i < sz ; i++) {
		//	String log = "Key: " + key + "     Values: " + vl.toString(); 
		//	LOGGER.info(log);
		//}
			vl.clearValues();
		return 0;
	}

	public int read() {
		//! should use lock here
		// retrieve all values in map and aggregate
		double finald = 0.0;
		int sz = valueMap.size();
		if(sz == 0)// no value collected
			return 0;
		for (Number value : valueMap.values()) {
			finald += value.doubleValue();
		}
		//double avg = finald / sz;
		
		// submit the value - average
		//submit("cpu", "system", new Double(avg));
		// submit the value - sum
		submit("cpu", "system", new Double(finald));
		//String log = "Map size: " + sz + "     Sum: " + finald + "    Average: " + avg; 
		//LOGGER.info(log);
		// clear the map
		valueMap.clear();
		return 0;
	}

	public int init() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int config(OConfigItem ci) {
		List<OConfigItem> children;
	    int i;

	    Collectd.logDebug ("ObsAggregationPlugin plugin: config: ci = " + ci + ";");

	    children = ci.getChildren ();
	    for (i = 0; i < children.size (); i++)
	    {
	      OConfigItem child;
	      String key;

	      child = children.get (i);
	      key = child.getKey ();
	      /*
	      if (key.equalsIgnoreCase ("JMXServiceURL"))
	      {
	        configServiceURL (child);
	      }
	      else
	      {
	        Collectd.logError ("JMXMemory plugin: Unknown config option: " + key);
	      }*/
	    }
		return 0;
	}

}
