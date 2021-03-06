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

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.observability.monitoring.daemon.IDaemonManagerServer;

/**
 * This is the RMI client for DaemonHandler.<br>
 * Client code can use this class to get IDaemonManagerServer instance.<br>
 * 
 * @author Ying (Joel) Gao
 * 
 * History: 
 * 1. Created					Jun 03 2015
 * 2. Modified 					Jly 23 2015
 *
 */

public class DaemonManagerClient {
	/**
     * Default constructor.<br>
     * This constructor is added only for test coverage.
     *
     */
	DaemonManagerClient(){
	}
	
	/**
     * Get the RMI server interface.
     * @param ip IP address of the RMI server
     * @param port Port number of the RMI server
     *
     * @return server interface
     */
	public static IDaemonManagerServer getServerInstance(String ip, String port) {
	    String url = String.format("//%s:%s/DaemonManager", ip, port);
	    try {
	      return (IDaemonManagerServer) Naming.lookup (url);
	    } catch (MalformedURLException e) {
	      //you probably want to do logging more properly
	      System.err.println("Bad URL" + e);
	    } catch (RemoteException e) {
	      System.err.println("Remote connection refused to url "+ url + " " + e);
	    } catch (NotBoundException e) {
	      System.err.println("Not bound " + e);
	    }
	    return null;
  	}
}
