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


package com.observability.modeling.generation.services;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;




/**
 * The class has methods to check for the descriptor template files 
 * and zip them together into a single file.
 * 
 * @author vsaravag
 *
 */
public class DescriptorFiles {

	private static final int BUFFER = 2048;
	private static String FILES = 
			"/home/vsaravag/git/obs-prototype/modeling/editor_new/observability.generator/src/com/observability/modeling/generation/files";
	private static String CONF_DIR = "/home/vsaravag/git/obs-prototype/modeling/third/ModelingFinal";
	private static final String TEMPLATE_EXTENSION = ".mtl";
	private static final String CONF_EXTENSION = ".conf";
	private static String ZIPPATH = "";//"/home/vsaravag/git/obs-prototype/modeling/third/ModelingFinal/conf.zip";
	private static ArrayList<String> fileNames = new ArrayList<String>();
	
	public static void main(String[] args){
		zipAll();
	}
	
	public static void setParameters(String templateFiles, String confDir, String zipPath){
		String os = System.getProperty("os.name").toLowerCase();
    	   	
    	if(os.indexOf("win") >= 0)
    		templateFiles = "D:/observability modeling/modeling/editor_new/observability.generator/src/com/observability/modeling/generation/files";
    	
		
		FILES = templateFiles;
		CONF_DIR = confDir;
		ZIPPATH = zipPath;
	}
	/**
	 * Get all the generator files in the files resource directory.
	 * Generator files have extension *.mtl 
	 */
	public static void getAllFiles(){
		// Get the File object of the directory containing the template files
		File dir;
		dir = new File(FILES);
		
		// Get only the *.mtl files
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(TEMPLATE_EXTENSION);
			}
		});
		
		// Store the file name of all the files without the extension
		for(File file : files){
			String fileName = file.getName();
			fileNames.add(fileName.split("\\.")[0].toLowerCase());
		}
	}
	
	
	
	/**
	 * @param dbName the name of the DbType
	 * @return true if the template file for the dbName exists,
	 * false otherwise
	 */
	public static boolean hasFile(String dbName){
		getAllFiles();
		if(fileNames.contains(dbName.toLowerCase())){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Zip all the generated configuration files.
	 * Configuration files are of the format *_collectd.conf
	 */
	public static void zipAll(){
		// Get all the configuration files in the directory
		File dir = new File(CONF_DIR);
		
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(CONF_EXTENSION);
			}
		});
		
		try{
			
			BufferedInputStream origin = null;
			
			// Create an output stream at the destination where zip is to be created
			// overwrite if the zip already exists
			FileOutputStream dest = new FileOutputStream(ZIPPATH+"/conf.zip", false);
			
			// Create the zip output stream
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
			out.setMethod(ZipOutputStream.DEFLATED);
			
			byte[] data = new byte[BUFFER];
			
			// Add each file to the zip
			for(int i=0; i< files.length;i++){
				// read the file
				FileInputStream fi = new FileInputStream(files[i]);
				origin = new BufferedInputStream(fi, BUFFER);
				
				// create a zip entry and put it in the zip output stream
				ZipEntry entry = new ZipEntry(files[i].getName());
				out.putNextEntry(entry);
				
				// read the file and add it to the zip output stream
				int count;
				while((count = origin.read(data, 0, 
						BUFFER)) != -1) {
					out.write(data, 0, count);
				}
				origin.close();
				files[i].delete();
			}
			out.close();
			dest.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
