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

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * IDaemonManagerServer is RMI server interface of DaemonManager. Client should follow the sequence below to change configurations.
 * 1. Call startConfigurationModification, get true return to continue;
 * 2. Change individual section of configuration by calling changeConfiguration;
 * 3. Call stopConfigurationModification to finish the process. 
 * 	  If conf file is saved successfully, collectd process will be restarted to apply changes.
 * 
 * @author Ying (Joel) Gao
 * 
 * History: 
 * 1. Created					May 29 2015
 * 2. Modified					May 30 2015
 * 3. Modified 					Jun 02 2015
 */

public interface IDaemonManagerServer extends Remote {

	/**
	 * Start configuration modification process.
	 * @return true/false client gets true to continue
	 * @throws RemoteException connection error
	 */
	public boolean startConfigurationModification() throws RemoteException;
	
	/**
	 * Change configuration of a section. There are two kinds of configurations:<br>
	 * 1. Single line that outside any sections;<br>
	 * 2. Sections (inside &lt; and &gt;);<p>
	 * For example:
	 * <p>
	 * &lt;LoadPlugin perl&gt;<br>
	 * 		Interval 60<br>
	 * &lt;/LoadPlugin&gt;<br>
	 * <p>
	 * If the oldconfig is null, newconfig will be appended to the end of 
	 * configuration file as a new section. 
	 * <p>
	 * This function can be called multiple times to change multiple sections.
	 * 
	 * @param oldconfig the old configuration value, for a section, it includes everything.
	 * @param newconfig the new configuration value, for a section, it includes everything.
	 * @return true/false
	 * @throws RemoteException connection error
	 */
	public boolean changeConfiguration(String oldconfig, String newconfig) throws RemoteException;
	
	/**
	 * Replace the whole configuration file content with string config.
	 * @param config the string for new configuration as a whole
	 * @return true/false
	 * @throws RemoteException connection error
	 */
	public boolean replaceWholeConfiguration(String config) throws RemoteException;
	
	/**
	 * Stop configuration modification process.
	 * @return true/false client gets true to confirm the success of changing configuration
	 * @throws RemoteException connection error
	 */
	public boolean stopConfigurationModification() throws RemoteException;
}
