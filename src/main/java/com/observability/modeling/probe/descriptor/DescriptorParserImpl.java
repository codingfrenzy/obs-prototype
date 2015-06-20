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
package com.observability.modeling.probe.descriptor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import com.observability.modeling.probe.descriptor.entities.DbType;
import com.observability.modeling.probe.descriptor.entities.ElementTag;


/**
 * {@inheritDoc}
 */

/**
 * This class implements the functionality to parse the 
 * probe descriptor files.
 * 
 * @author vsaravag (Varun Saravagi)
 * 
 *
 */
public class DescriptorParserImpl implements DescriptorParser {

	/**
	 * Tags that correspond to the tags of a collectd.conf plugin description. @see
	 * "cassandra.descriptor"
	 * */

	private static final String DESCRIPTOR_EXTENSION = "descriptor";

	/**
	 * Anotations that represent on which entity in the semantic model the
	 * parsed elements need to be appended. For the metamodel @see
	 * "modeling/workspace/observability_new/model/observability_new.aird"
	 */

	private static final String MACHINE_SCOPE = "@Machine";
	private static final String METRIC_SCOPE = "@Metric";
	private static final String COLLECT = "@Collect";

	/**
	 * The path where the descriptor files are stored
	 */
	private Path descriptorDirectory;

	/**
	 * Constructor
	 * 
	 * @param descriptorDirPath
	 *            the path in which the descriptors are located.
	 */
	public DescriptorParserImpl(Path descriptorDirPath) {
		this.descriptorDirectory = descriptorDirPath;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<DbType> parseDescriptors() {

		// Filter the files with correct extension
		File dir = descriptorDirectory.toFile();
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith("." + DESCRIPTOR_EXTENSION);
			}
		});

		List<DbType> plugins = new ArrayList<DbType>();

		// For each file generate a PluginDefinition
		if (files != null) {
			try {
				for (File file : files) {
					//get the file name and create a DbType instance with the name
					String dbName = file.getName().toLowerCase().split("\\.")[0];
					DbType dbType = new DbType(dbName);
					
					//parse the file and populate the dbType
					parseFile(file, dbType);
					//add the parsed structure to the plugins list
					plugins.add(dbType);

				}
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException();
			}
		}
		// Test code to print out the DbTypes
		for (DbType dbType : plugins) {
			System.out.println(dbType.toString());
			System.out.println();
		}
		
		return plugins;

	}

	
	/**
	 * This method parses the input file descriptor.<br>
	 * The file should be in the defined template.
	 * @param file the file to be parsed
	 * @param dbType the parsed contents of the file as an instance
	 * 	of {@link DbType} class.
	 */
	public void parseFile(File file, DbType dbType) {
		
		ElementTag element;
		Stack<ElementTag> elementStack = new Stack<ElementTag>();
		String currentAnnotation = null;
		
		try (Scanner scanner = new Scanner(file, "UTF-8")){
			while(scanner.hasNextLine()){
				
				String line = scanner.nextLine().trim();
				
				// the line has an annotation
				if(ParserUtility.isAnnotated(line)){
								
					// get the annotation string
					String annotation = ParserUtility.getAnnotation(line);
					
					
					// if it is a collect annotation, add it to DbType and continue to the next line
					if(annotation.equals(COLLECT)){
						// It is assumed that a collect annotation cannot be an element tag and would
						// exist as a key-value pair only.
						
						// get the name and value of the annotation
						String[] keyDetails = ParserUtility.getKeyValueDetails(line);
						// create an empty element to store the key-value
						element = new ElementTag(null, null);
						element.addKeyValue(keyDetails[0], keyDetails[1]);
						
						// add the collect annotation to the DbType
						addElementToDb(COLLECT, element, dbType);
						continue;
					}
					else {
						// if it is an annotation other than COLLECT,
						// check if it is the same one as the current going on.
						// At a time, only one annotation can be active
						if(currentAnnotation == null || currentAnnotation.equals(annotation)){
							currentAnnotation = annotation;
						}
						else {
							throw new RuntimeException();
						}
					}
					
					// The annotation is decided. Create the element 
					
					// The line is an element start
					if (ParserUtility.isElementStart(line)){
					
						String[] elementDetails = ParserUtility.getElementDetails(line);
						element = new ElementTag(elementDetails[0], elementDetails[1]);
						elementStack.push(element);
						
					}
					else {
						// the line is a key-value pair
						String[] keyValueDetails = ParserUtility.getKeyValueDetails(line);
						String keyName = keyValueDetails[0];
						String keyValue = keyValueDetails[1];
						
						if(!elementStack.isEmpty()){
							// add the key-value to the opened element
							elementStack.peek().addKeyValue(keyName, keyValue);
						}
						else {
							// create an empty element tag
							element = new ElementTag(null, null);
							element.addKeyValue(keyName, keyValue);
							addElementToDb(currentAnnotation, element, dbType);
							currentAnnotation = null;
						}	
					}
				} // end if annotation
				
				// the line has an end tag
				else if(ParserUtility.isElementEnd(line)){					
					// Pop the top element from the stack and add it to the element at its bottom.
					if(!elementStack.isEmpty()){
						String elementName = ParserUtility.getElementDetails(line)[0];
						element = elementStack.pop();
						if(!element.getName().equals(elementName)){
							// Element being ended is different than the one on stack.
							// Push the element back to stack and continue
							elementStack.push(element);
							continue;
						}
						else if(!elementStack.isEmpty()){
							// the element being ended is same as one on stack
							// add the element to the element below it
							elementStack.peek().addElement(element);	
						}
						else {
							// the stack is empty. Add the element to the DbType parameter as per 
							// the current annotation 
							addElementToDb(currentAnnotation, element, dbType);
							currentAnnotation = null;
						}
						
					} // end if (!elementStack.isEmpty())
				} // end else if(ParserUtility)
				
			} // end while
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * This method adds the given element to the DbType instance.<br>
	 * The element is added as per the annotation which is currently active
	 * @param currentAnnotation the annotation being currently processed
	 * @param element the element to be added
	 * @param dbType instance of the DB to which the element is to be added
	 */
	private void addElementToDb(String currentAnnotation, ElementTag element,
			DbType dbType) {
		
		if(currentAnnotation.equals(MACHINE_SCOPE)){
			dbType.getMachineParams().addElement(element);
		}
		else if(currentAnnotation.equals(METRIC_SCOPE)){
			dbType.getMetricParams().addElement(element);
		}
		else if(currentAnnotation.equals(COLLECT)){
			dbType.getCollectParams().addElement(element);
		}
		
	}

}
