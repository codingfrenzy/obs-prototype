//**************************************************************************************************//
/* Observability Project
 * Copyright 2015 Master of Software Engineering team: Laila Alhmound, Ying (Joel) Gao, Caglayan (Gem) Gemici, Rajat Kapoor, Prasanth Nair, Varun Saravagi
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

package com.observability.modeling.emf.extension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;

import com.observability.modeling.emf.DatabaseCluster;
import com.observability.modeling.emf.DbType;
import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfFactory;
import com.observability.modeling.emf.KeyValue;
import com.observability.modeling.emf.Metric;
import com.observability.modeling.emf.Model;
import com.observability.modeling.emf.NodeMachine;
import com.observability.modeling.probe.descriptor.DescriptorFilter;
import com.observability.modeling.probe.descriptor.DescriptorParserImpl;
import com.observability.modeling.probe.descriptor.entities.ElementTag;
import com.observability.modeling.probe.descriptor.entities.Feature;
import com.observability.modeling.probe.descriptor.entities.Machine;
import com.observability.modeling.probe.descriptor.entities.Parameter;
import com.observability.modeling.probe.descriptor.entities.Scope;

/**
 * @author gemici
 * This class is a service class that reads the probe descriptors and 
 * changes the EMF model instance according to the information on the descriptors
 */



public class SiriusServices {
	
	/*
	 * The relative path to where the probe descriptors are stored
	 */
	public  static String PROBE_DESCRIPTOR_DIR_PATH = "descriptors";
	
	/*
	 * In memory representation of the descriptor files. One dbType is created
	 * per descriptor file
	 */
	private List<com.observability.modeling.probe.descriptor.entities.DbType> dbTypes = null;
	
	/*
	 * Factory class to manipulate the EMF model instance.
	 */
	private EmfFactory factory = EmfFactory.eINSTANCE;
    
	
	private Map<String, HashMap<String,Element>> externalElements = new HashMap<String,HashMap<String,Element>>();

	/*
	 * The configuration of features that this model have.
	 * For now features are missing deamon and thresholds notifications
	 */
	private List<Feature> features = null;
    /**
     * Parse the descriptors and bring the info into entities at class loading
     * This will search through all the projects in the current workspace for the descriptors dir.
     */
	
	private static SiriusServices instance = null;

	private EclipseResourceDelegate eclipse = null;
	  
	private SiriusServices() {
	      // Exists only to defeat instantiation.
	}

	public static SiriusServices getInstance(EclipseResourceDelegate eclipse) {
		if (instance == null) {
			instance = new SiriusServices();
			instance.eclipse = eclipse;
		}
		return instance;
	}
	
	public static SiriusServices getInstance() {
		return getInstance(new EclipseResourceDelegate());
	}
	
	
	public void parseDescriptors(){
	
		File descriptorDir = eclipse.getDescriptorPath();
		if(descriptorDir != null)	{
			File[] descriptorFiles = descriptorDir.listFiles(new DescriptorFilter());
			if(descriptorFiles==null || descriptorFiles.length ==0){
				throw new RuntimeException("No descriptor files found. Please add the descriptor files and do the operation again.");
			}
			parseDescriptors(descriptorDir.toPath());
		}
		else{
			
			throw new RuntimeException("Cannot find descriptor directory \"<project_dir>/descriptors\"");
		}
			 
			
    }
	
	 /**
     * Parse the descriptors and bring the info into entities at class loading
     * 
     * @param descriptorsPath the path to the dir where the descriptor files are located inside the project
     * TODO remove duplicate code.
     */
	public void parseDescriptors(Path descriptorsPath){
		if(Files.exists(descriptorsPath , LinkOption.NOFOLLOW_LINKS)){
			// if descriptors exist, get the parsed descriptors
			File[] descriptorFiles = descriptorsPath.toFile().listFiles();
			if(descriptorFiles==null || descriptorFiles.length ==0){
				throw new RuntimeException("No descriptor files found. Please add the descriptor files and do the operation again.");
			}
			DescriptorParserImpl parser = new DescriptorParserImpl(descriptorsPath);
			parser.parseDescriptors();
			dbTypes = parser.getPlugins();
			features = parser.getFeatures();
		}
		else {
			
			throw new RuntimeException("Cannot find descriptor directory \"<project_dir>/descriptors\"");
		}
		
		fillExternalElements();
	}
	
	
	private void fillExternalElements() {
		for (com.observability.modeling.probe.descriptor.entities.DbType dbType : dbTypes) {
			externalElements.put(dbType.getName(), new HashMap<String,Element>());
			
		}
		
	}

	
	private void initializeDbTypes( Model model, Path dirPath) {
		
		//Get the parsers
		parseDescriptors(dirPath.resolve(PROBE_DESCRIPTOR_DIR_PATH));
		
		//Create dbTypes for each descriptor file
		for (com.observability.modeling.probe.descriptor.entities.DbType dbType : dbTypes) {
			DbType newDbType = factory.createDbType();
			newDbType.setName(dbType.getName());
		
			createMetrics(newDbType, dbType);
			
			model.getAvailableDbTypes().add(newDbType);
		}
	
	}
	/**
	 * This method is called from the model creation wizard code which is 
	 * generated by EMF. It creates the dbTypes and metrics inside them on 
	 * the EMF instance (aka semantic model) by looking at the information loaded 
	 * from the descriptors. Also creates features.
	 * 
	 * @param model the root element to fill in the new entities
	 * @param dirPath 
	 */
	public void initializeModel (Model model, Path dirPath){
		initializeDbTypes(model, dirPath);
		initializeFeatures(model);
	}
	
	
	private void initializeFeatures(Model model) {
		for(Feature feature: features){
			com.observability.modeling.emf.Feature semanticFeature = factory.createFeature();
			
			semanticFeature.setName(feature.getName());
			//Copy the element and sub elements and keyValues
			for(ElementTag element :feature.getElements()){
				Element semanticElement = factory.createElement();
				semanticElement.setName(element.getName());
				semanticElement.setValue(element.getValue());
				fillElements(element, semanticElement);
				semanticFeature.getElements().add(semanticElement);

			}
			for (com.observability.modeling.probe.descriptor.entities.KeyValue keyValue: feature.getKeyValues()){
				KeyValue semanticKeyValue = factory.createKeyValue();
				semanticKeyValue.setKey(keyValue.getName());
				semanticKeyValue.setValue(keyValue.getValue());
				semanticFeature.getKeyValues().add(semanticKeyValue);
			}
			model.getFeatures().add(semanticFeature);
		}
		
	}

	/**
	 * Create EMF semantic Metric entities and children corresponding to those on the parser entities.
	 * @param newDbType the newly created database type to be populated
	 * @param dbType the dbType entity read from the parser
	 */
	private void createMetrics(DbType newDbType,
			com.observability.modeling.probe.descriptor.entities.DbType dbType) {
		
		List<Parameter> allMetrics  = new ArrayList<>();
		
		Collections.addAll(allMetrics, dbType.getAggregatedMetrics().toArray( new Parameter[0]));
		Collections.addAll(allMetrics, dbType.getSystemMetrics().toArray(new Parameter[0]));
		Collections.addAll(allMetrics, dbType.getDbMetrics().toArray(new Parameter[0]));
		
		for (com.observability.modeling.probe.descriptor.entities.Parameter metric : allMetrics) {
			
			//Create a db metric entry in semantic model
			Metric semanticMetric = null;
			
			//System and db Metrics are represented as base metrics in EMF model 
			if(metric instanceof com.observability.modeling.probe.descriptor.entities.AggregatedMetric){
				 semanticMetric = factory.createAggregatedMetric();
			}
			else{
				semanticMetric = factory.createBaseMetric();
				if( metric instanceof com.observability.modeling.probe.descriptor.entities.SystemMetric)
					semanticMetric.setType(((com.observability.modeling.probe.descriptor.entities.SystemMetric)metric).getType().toString());
				else
					semanticMetric.setType(((com.observability.modeling.probe.descriptor.entities.DbMetric)metric).getType().toString());
			}
			semanticMetric.setName(metric.getName());
			
			//Will be used when parser supports adding descriptions to metrics
			//semanticMetric.setDescription()
			
			//Copy the element and sub elements and keyValues
			for(ElementTag element :metric.getElements()){
				Element semanticElement = factory.createElement();
				
				//We are setting the id instead of name to 
				// display a more descriptive text to the user.
				// We should come up with a better design
				// Also we are assuming a metric can have at most one Element as the child
				// 
				if(element.getId().endsWith("null")){
					semanticElement.setName(element.getName());
				}else{
					semanticElement.setName(element.getId());
				}
				semanticElement.setValue(element.getValue());
				fillElements(element, semanticElement);
				semanticMetric.getElements().add(semanticElement);

			}
			for (com.observability.modeling.probe.descriptor.entities.KeyValue keyValue: metric.getKeyValues()){
				KeyValue semanticKeyValue = factory.createKeyValue();
				semanticKeyValue.setKey(keyValue.getName());
				semanticKeyValue.setValue(keyValue.getValue());
				semanticMetric.getKeyValues().add(semanticKeyValue);
			}
			newDbType.getAvailableMetrics().add(semanticMetric);
			

		}
		
	}

	

	/**
	 * This method creates a new machine instance in the given cluster.
	 * It will populate the correct dynamic elements and key values according
	 * to the which dbType the cluster is associated with.
	 * 
	 * @param containerCluster the cluster the new machine is to be added
	 * @return false if operation fails,true otherwise
	 */
	public boolean initializeMachine(EObject containerCluster){
		
		//parse only one time
		if(dbTypes == null)
			parseDescriptors();
		DatabaseCluster cluster = (DatabaseCluster) containerCluster;
		
		//If the cluster is not associated with a dbType do nothing
		DbType associatedDbType = cluster.getAssociatedDbType();
		if(associatedDbType == null)
			return false;
		
		NodeMachine machine = factory.createNodeMachine();
		
		//Copy elements from the entities filled from descriptor to EMF semantic instance
		for (com.observability.modeling.probe.descriptor.entities.DbType dbType : dbTypes) {
			if(dbType.getName().equals(associatedDbType.getName())){
				Machine machineParam = dbType.getMachine();
				
				fillElements( machineParam, machine,associatedDbType);
				break;
			}
		}
		machine.setName("Machine " + (cluster.getMachines().size() + 1) + "");
		
		//We need to fill external elements here
		for(Metric collectedMetric:cluster.getCollectedMetrics()){
			addMetricSpecificParamsToMachine(machine,collectedMetric,associatedDbType);
		}
		
		cluster.getMachines().add(machine);
		return true;
		
		
	}
	
	private void addMetricSpecificParamsToMachine(NodeMachine machine, Metric collectedMetric,DbType associatedDbType) {
		for (Element element : getMatchingElements(collectedMetric, associatedDbType)) {
				machine.getElements().add(element);
			}
	}

	/**
	 * 
	 * @param machineParam 
	 * @param associatedDbType 
	 * @param rootElement
	 */
	private void fillElements(Machine machineParam, NodeMachine semanticMachine, DbType associatedDbType) {
		List<ElementTag> elementTags = machineParam.getElements();
		List<com.observability.modeling.probe.descriptor.entities.KeyValue> keyValues = machineParam.getKeyValues();
		
		for (ElementTag element : elementTags) {
			
			
			//Only add local scope elements when a new model instance is created
			//External scope elements will be added when a cluster is associated with a metric
			Element newElement = factory.createElement();
				
			//copy name and value
			newElement.setName(element.getName());
			newElement.setValue(element.getValue());
							
			//fill sub elements and key values
			fillElements(element, newElement);
			if(element.getScope().equals(Scope.LOCAL)){
				
				
				semanticMachine.getElements().add(newElement);
			}else if(element.getScope().equals(Scope.EXTERNAL)){
							
				//Add this to the temporary storage. 
				//These elements will be added to the machines inside a cluster
				//only when a cluster is associated with a metric or a machine is 
				// added to an already associated cluster
				externalElements.get(associatedDbType.getName()).put(element.getId() ,newElement);
			}
			
		}
		
		// We assume key values at root level are local
		for (com.observability.modeling.probe.descriptor.entities.KeyValue keyValue: keyValues){
			KeyValue kV = factory.createKeyValue();
			kV.setKey(keyValue.getName());
			kV.setValue(keyValue.getValue());
			semanticMachine.getKeyValues().add(kV);
		}
		
	}
	
	/**
	 * Recursive method to copy the elements and keyValues
	 * given the starting node of the descriptor entities and EMF semantic model
	 * @param element  point to start copying from the descriptor entities 
	 * @param newElement point to start copying to the EMF semantic model
	 */
	private void fillElements(ElementTag element, Element newElement) {
		
		//For each sub element copy them as well
		List<ElementTag> elements = element.getElements();
		if(elements.size() != 0){
			for (ElementTag elementTag : elements) {
				Element newSubElement = factory.createElement();
				newSubElement.setName(elementTag.getName());
				newSubElement.setValue(elementTag.getValue());
				fillElements(elementTag, newSubElement);
				newElement.getElements().add(newSubElement);
			}
		}
		
		//For each keyValue element copy them as well
		List<com.observability.modeling.probe.descriptor.entities.KeyValue> keyValues =  element.getKeyValues();
		if(keyValues.size() != 0){
			for (com.observability.modeling.probe.descriptor.entities.KeyValue keyValue : keyValues) {
				KeyValue newKey = factory.createKeyValue();
				newKey.setKey(keyValue.getName());
				newKey.setValue(keyValue.getValue());
				newElement.getKeyValues().add(newKey);
			} 
		}
	}
	/**
	 * Clear all nodes of a cluster and create noOfMachines
	 * number of new nodes with appropriate sub elements
	 * 
	 * TODO For now existing nodes are cleared. We should think
	 * about what to do to them
	 * @param databaseCluster cluster that new node machines will be added to
	 * @param noOfMachines number of machines to be created
	 */
	public void createNodes(DatabaseCluster databaseCluster,
			int noOfMachines) {
		databaseCluster.getMachines().clear();
		for (int i = 0; i < noOfMachines; i++) {
			initializeMachine(databaseCluster);
			
		}
		
	}
	
	public boolean addMetricSpecificParamsToMachinesInCluster(DatabaseCluster containerCluster , Metric associatedMetric){
		if(dbTypes == null)
			parseDescriptors();
		
		DatabaseCluster cluster =  containerCluster;
		
		//If the cluster is not associated with a dbType do nothing
		DbType associatedDbType = cluster.getAssociatedDbType();
		if(associatedDbType == null)
			return false;
	
		List<NodeMachine> machinesInClustes = cluster.getMachines();
		for (NodeMachine nodeMachine : machinesInClustes) {
			
			//TODO speed optimization: check for the matchingElements only for the first machine
			// 
			for (Element element : getMatchingElements(associatedMetric, associatedDbType)) {
				nodeMachine.getElements().add(element);
			}
		}
		
		return true;
	}
	
	
	public List<Element> getMatchingElements(Metric metric, DbType associatedDbType){
		List<Element> elementsToAddToMachine = new ArrayList<Element>();
		
		//We assume the metric id is on the first element
		if(metric.getElements().size()> 0){
			//We assume the id is <key>_<value>
			
			String id = "";
			if (metric.getElements().get(0).getName().indexOf("_") == -1)
				id = metric.getElements().get(0).getName() + "_" + metric.getElements().get(0).getValue();
			else
				id = metric.getElements().get(0).getName();
			Element elementToBeAdded = externalElements.get(associatedDbType.getName()).get(id);
			if(elementToBeAdded != null){
				//There are externalElements, so add.
				elementsToAddToMachine.add(elementToBeAdded);
			}
		}
		return elementsToAddToMachine;
	}
	public void setEclipseResource(EclipseResourceDelegate eclipseResource) {
		eclipse = eclipseResource;
	}

	
	
	

}

	
	
	