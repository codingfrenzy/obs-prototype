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
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

import com.observability.modeling.probe.descriptor.entities.AggregatedMetric;
import com.observability.modeling.probe.descriptor.entities.DbMetric;
import com.observability.modeling.probe.descriptor.entities.DbType;
import com.observability.modeling.probe.descriptor.entities.ElementTag;
import com.observability.modeling.probe.descriptor.entities.Feature;
import com.observability.modeling.probe.descriptor.entities.KeyValue;
import com.observability.modeling.probe.descriptor.entities.MetricType;
import com.observability.modeling.probe.descriptor.entities.Scope;
import com.observability.modeling.probe.descriptor.entities.SystemMetric;


/**
 * {@inheritDoc}
 */

/**
 * This class implements the functionality to parse the 
 * probe descriptor files.
 * 
 * @author vsaravag (Varun Saravagi) , gemici
 * 
 *
 */
public class DescriptorParserImpl implements DescriptorParser {

	/**
	 * Tags that correspond to the tags of a collectd.conf plugin description. @see
	 * "cassandra.descriptor"
	 * */

	private static final String FEATUREFILENAME = "central";
	private static final String ELEMENT_ID_SEPARATOR = "_";
	
	/**
	 * Anotations that represent on which entity in the semantic model the
	 * parsed elements need to be appended. For the metamodel @see
	 * "modeling/workspace/observability_new/model/observability_new.aird"
	 */

	private static final String MACHINE = "@Machine";
	private static final String SYSTEM_METRIC = "@MetricSystem";
	private static final String DB_METRIC = "@MetricDB";
	private static final String AGGREGATED_METRIC = "@MetricAggregated";
	private static final String ATTRIBUTE = "@Attribute";
	
	/**
	 * The path where the descriptor files are stored
	 */
	private Path descriptorDirectory;
	
	private List<DbType> plugins = new ArrayList<DbType>();
	private List<Feature> features = new ArrayList<Feature>();
	/**
	 * Constructor
	 * 
	 * @param descriptorDirPath
	 *            the path in which the descriptors are located.
	 */
	public DescriptorParserImpl(Path descriptorDirPath) {
		this.descriptorDirectory = descriptorDirPath;
	}
	
	public List<DbType> getPlugins(){
		return plugins;
	}
	
	public List<Feature> getFeatures(){
		return features;
	}
	/**
	 * {@inheritDoc}
	 */
	public void parseDescriptors() {

		// Filter the files with correct extension
		File dir = descriptorDirectory.toFile();
		File[] files = dir.listFiles(new DescriptorFilter());

		// For each file generate a PluginDefinition
		if (files != null) {
			try {
				for (File file : files) {
					//get the file name and create a DbType instance with the name
					String name = file.getName().toLowerCase(Locale.ENGLISH).split("\\.")[0];
					
					DbType dbType = new DbType(name);
					boolean isFeatureFile = name.equals(FEATUREFILENAME);
					//parse the file and populate the dbType
					parseFile(file, dbType, isFeatureFile);
					//add the parsed structure to the plugins list
					if(!isFeatureFile)
						plugins.add(dbType);

				}
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException();
			}
		}

	}

	
	/**
	 * This method parses the input file descriptor.<br>
	 * The file should be in the defined template.
	 * @param file the file to be parsed
	 * @param dbType the parsed contents of the file as an instance
	 * 	of {@link DbType} class.
	 */
	public void parseFile(File file, DbType dbType, boolean isFeatureFile) throws FileNotFoundException{
		
		
		ElementTag parentElement = null;
		Feature feature = null;
		Stack<ElementTag> parentElementStack = new Stack<ElementTag>();
		Stack<ElementTag> secondaryElementStack = new Stack<ElementTag>();
		Stack<String> elementNameStack = new Stack<String>();
		String parentAnnotation = null,
			   secondaryAnnotation = null;
		
		
		 Scanner scanner = new Scanner(file, "UTF-8");
			while(scanner.hasNextLine()){
				
				// remove the leading and trailing spaces from the line
				String line = scanner.nextLine().trim();
				
				// the line has an annotation
				if(ParserUtility.isAnnotated(line)){
								
					// get the annotation string
					String annotatedString = ParserUtility.getAnnotation(line);					
					String annotation = ParserUtility.getAnnotationFromAnnotated(annotatedString);
					
					// The line is an element start
					// As per the collectd configuration files, an element would not have other elements
					// with external scope. If elements are stacked, those all belong to parent scope.
					if (ParserUtility.isElementStart(line)){	
						String name = ParserUtility.getNameFromAnnotated(annotatedString);
						String[] elementDetails = ParserUtility.getElementDetails(line);
						String id = elementDetails[0] + ELEMENT_ID_SEPARATOR + elementDetails[1];
						
						// create an element with local scope
						ElementTag element = new ElementTag(elementDetails[0], elementDetails[1],
												id, Scope.LOCAL);
						// get any name along with the annotation, if given
						if(name == null){
							name = element.getValue();
						}
						elementNameStack.push(name);
						
						// if the parent stack is empty, this is a new parent element.
						// Make this parent and push to stack.
						if(parentElementStack.isEmpty()){
							
							parentAnnotation = annotation;
							parentElement = element;
							if(isFeatureFile){
								feature = new Feature(name);	
							}

						}
						parentElementStack.push(element);						
					}
					else {
						// the line is a key-value pair
						String name = ParserUtility.getNameFromAnnotated(annotatedString);
						String[] keyValueDetails = ParserUtility.getKeyValueDetails(line);
						String keyName = keyValueDetails[0];
						String keyValue = keyValueDetails[1];
						if(name == null){
							name =  keyValue;
						}
						// the annotation is Attribute. Add it as a key-value in the parent element
						// An @Attribute notation cannot exist independent i.e. it would be inside an 
						// annotated element
						if(annotation.equals(ATTRIBUTE)){
							parentElementStack.peek().addKeyValue(keyName, keyValue);
						}
						else {
							// it's a different annotation
							
							// if the parent stack is empty, then this key-value is independent
							// and can be implements FilenameFilter added as a key-value to the annotated parameter class 
							if(parentElementStack.isEmpty()){
								if(isFeatureFile){
									feature = new Feature(name);
									addKeyValueToFeature(feature, new KeyValue(keyName, keyValue));
								}
								else{
									addKeyValueToDb(annotation, new KeyValue(keyName, keyValue), dbType, name);
								}
									
							}
							else {
								// the parent stack is not empty and the annotation differs from the parent
								// annotation

								// this is the first time this has been encountered. 
								// Create a copy of the parent element and add it to the secondary stack
								if(secondaryElementStack.isEmpty()){
									secondaryAnnotation = annotation;
									ElementTag secondaryElement = new ElementTag(parentElement.getName(), 
											parentElement.getValue(), parentElement.getId(), 
											Scope.EXTERNAL);
									secondaryElementStack.push(secondaryElement);
									elementNameStack.push(secondaryElement.getValue());
								}
								
								// push the key-value to the secondary element
								secondaryElementStack.peek().addKeyValue(keyName, keyValue);
							}
						}// end if annotation	
					}
				} // end isAnnotated
				
				// the line is not annotated and has an end tag
				else if(ParserUtility.isElementEnd(line)){
					String elementName = ParserUtility.getElementDetails(line)[0];
					// as of now, the secondary element would end at the same time the parent element ends.					
					
					// Pop the top element from the stack and add it to the element at its bottom.
					if(!parentElementStack.isEmpty()){
						ElementTag element = parentElementStack.pop();
						if(!element.getName().equals(elementName)){
							// Element being ended is different than the one on parent stack.
							// Push the element back to stack and continue
							parentElementStack.push(element);
							continue;
						}
						else if(!parentElementStack.isEmpty()){
							// the element being ended is same as one on stack
							// add the element to the element below it
							parentElementStack.peek().addElement(element);
							elementNameStack.pop();
						}
						else {
							if(isFeatureFile){
								// add element to feature class. A feature would not have secondary elements
								addElementToFeature(feature, element);
								// add the feature to the features list
								features.add(feature);
								feature = null;
							}
							else{
								// the stack is empty. Add the element to the DbType parameter as per 
								// the current annotation 
								addElementToDb(parentAnnotation, element, dbType, elementNameStack.pop());
								if(!secondaryElementStack.isEmpty()){
									addElementToDb(secondaryAnnotation, secondaryElementStack.pop(), 
											dbType, elementNameStack.pop());
								}	
							}							
							parentAnnotation = null;
							secondaryAnnotation = null;
						}
						
					} // end if (!elementStack.isEmpty())
				} // end else if(ParserUtility)
				
			} // end while
			scanner.close();
		
	}

	
	/**
	 * This method adds the given element to the DbType instance.<br>
	 * The element is added as per the annotation which is currently active
	 * @param currentAnnotation the annotation being currently processed
	 * @param element the element to be added
	 * @param dbType instance of the DB to which the element is to be added
	 */
	private void addElementToDb(String annotation, ElementTag element,
			DbType dbType, String name) {
		
		if(annotation.equals(MACHINE)){
			dbType.getMachine().addElement(element);
		}
		if(annotation.equals(SYSTEM_METRIC)){
			SystemMetric systemMetric = new SystemMetric(name, MetricType.SYSTEM);
			systemMetric.addElement(element);
			dbType.getSystemMetrics().add(systemMetric);
		}
		if(annotation.equals(DB_METRIC)){
			DbMetric dbMetric = new DbMetric(name, MetricType.DATABASE);
			dbMetric.addElement(element);
			dbType.getDbMetrics().add(dbMetric);
		}
		if(annotation.equals(AGGREGATED_METRIC)){
			AggregatedMetric aggMetric = new AggregatedMetric(name, null);
			aggMetric.addElement(element);
			dbType.getAggregatedMetrics().add(aggMetric);
		}
		
	}
	
	private void addKeyValueToDb(String annotation, KeyValue keyValue, DbType dbType, String name){
		if(annotation.equals(MACHINE)){
			dbType.getMachine().addKeyValue(keyValue);
		}
		if(annotation.equals(DB_METRIC)){
			DbMetric dbMetric = new DbMetric(name, MetricType.DATABASE);
			dbMetric.addKeyValue(keyValue);
			dbType.getDbMetrics().add(dbMetric);			
		}
	}
	
	private void addKeyValueToFeature(Feature feature, KeyValue keyValue){
		feature.getKeyValues().add(keyValue);
	}
	
	/**
	 * This method adds the given element to the Feature instance.<br>
	 * @param element the element to be added
	 */
	private void addElementToFeature(Feature feature, ElementTag element) {

		feature.getElements().add(element);
	}
	
	
}
