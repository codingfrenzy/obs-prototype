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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;


/**
 * ProcessManager is an experiment to start/stop collectd process on Ubuntu.
 * This program needs to be started with sudo.
 * @author Ying (Joel) Gao
 * 
 * History: 
 * 1. Created					May 21 2015
 * 2. Modified					May 22 2015
 *
 */
public class ProcessManager
{
	/**
	 * Kill process by the process name
	 * 
	 * @param process name of the process
	 */
	public static void killProcess(String process) {
	    try {
	        Vector<String> commands = new Vector<String>();
	        commands.add("pidof");
	        commands.add(process);
	        ProcessBuilder pb = new ProcessBuilder(commands);
	        Process pr = pb.start();
	        pr.waitFor();
	        if (pr.exitValue() != 0)
	        	return;
	        BufferedReader outReader = new BufferedReader(new InputStreamReader(pr.getInputStream(),"UTF-8"));
	        String pros = outReader.readLine();
	        if(pros != null && pros.length() > 0) {
		        String [] strs = pros.trim().split(" ");
		        for (String pid : strs) {
		            //log.info("Killing pid: "+pid);
		            Runtime.getRuntime().exec("sudo kill " + pid).waitFor();
		            System.out.println("Killing pid: " + pid);
		        }
	        }
	        outReader.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Start the process by name, this class file should be in the same folder as the target program
	 * @param process name of the process
	 */
	public static void startProcess(String process) {
		try {
			Runtime.getRuntime().exec("sudo " + process);
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main ( String args[] ) throws Exception {
		
		Scanner keyboard = new Scanner(System.in);
		
		while (true){
			System.out.println("Enter an integer, 1 - stop collectd, 2 - start collectd, 0 - exit");
			int myint = keyboard.nextInt();
			if(myint == 0)
				break;
			switch(myint) {
			case 1:
				killProcess("collectd");
				break;
			case 2:
				startProcess("collectd");
				break;
			default:
				break;
			}
			System.out.println("");
			// 
			Thread.sleep(1000);
		}
		keyboard.close();
	}
}
