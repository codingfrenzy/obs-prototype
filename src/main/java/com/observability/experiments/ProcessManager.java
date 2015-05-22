package com.observability.experiments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;


public class ProcessManager
{
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
	        BufferedReader outReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
	        for (String pid : outReader.readLine().trim().split(" ")) {
	            //log.info("Killing pid: "+pid);
	            Runtime.getRuntime().exec("sudo kill " + pid).waitFor();
	            System.out.println("Killing pid: " + pid);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void startProcess(String process) {
		try {
			Runtime.getRuntime().exec("sudo " + process);
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main ( String args[] ) throws Exception {
		
		// First time, start the collectD daemon
		// 
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
			}
			System.out.println("");
			// 
			Thread.sleep(1000);
		}
		keyboard.close();
	}
}
