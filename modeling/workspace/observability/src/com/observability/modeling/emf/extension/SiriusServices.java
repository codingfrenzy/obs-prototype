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
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.observability.modeling.common.Messages;
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
	 * In memory representation of the descriptor files. One dbType is created
	 * per descriptor file
	 */
	private List<com.observability.modeling.probe.descriptor.entities.DbType> dbTypes = null;
	
	/*
	 * Factory class to manipulate the EMF model instance.
	 */
	private EmfFactory factory = EmfFactory.eINSTANCE;
    
	/*
	 * This data structure stores the external elements in the machine scope in a easy
	 * accessible structure. We can do quick lookups instead of crawling through the 
	 * data structures the parser gives.
	 */
	private Map<String, HashMap<String,Element>> externalElements = new HashMap<String,HashMap<String,Element>>();

	/*
	 * The configuration of features that this model have.
	 * For now features are missing deamon and thresholds notifications
	 */
	private List<Feature> features = null;
   
	/*
	 *  Singleton instance. Needs to be volatile for the double checked singleton method to work.
	 */
	private static volatile SiriusServices instance = null;

	/*
	 * The eclipse IDE dependency encapsulated as a an object.
	 */
	private EclipseResourceDelegate eclipse = null;
	  
	
	
	/**
	 *  Private constructor to ensure instantiation by method.
	 */
	private SiriusServices() {}
	
	/**
	 *  Double checked locking singleton method
	 * see http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
	 * @param eclipse This parameter is added to facilitate mocking of the eclipse IDE dependency on unit tests
	 * @return the singleton instance of this service
	 */
	  
	public static SiriusServices getInstance(EclipseResourceDelegate eclipse) {
		if(eclipse == null)
			throw new RuntimeException(Messages.SiriusServices_MSG_ERROR_ECLIPSE_CANNOTBENULL );
		if (instance != null) {
			instance.eclipse = eclipse;
		}else{
			synchronized(SiriusServices.class){
				if(instance == null){
					SiriusServices services = new SiriusServices();
					services.eclipse = eclipse;
					instance = services;
				}
			}
		}
		return instance;
		
	}
	
	/**
	 * Default singleton method.
	 * @return singleton instance of this service
	 */
	public static SiriusServices getInstance() {
		return getInstance(new EclipseResourceDelegate());
	}
	
	 /**
     * Parse the descriptors and bring the info into entities,
     * This will search through all the projects in the current project for the descriptors dir.
     */
	public void parseDescriptors(){
	
		File descriptorDir = eclipse.getDescriptorPath();
		if(descriptorDir != null)	{
			File[] descriptorFiles = descriptorDir.listFiles(new DescriptorFilter());
			if(descriptorFiles==null || descriptorFiles.length ==0){
				throw new RuntimeException(Messages.SiriusServices_MSG_ERROR_NO_DESCRIPTOR_FILES);
			}
			parseDescriptors(descriptorDir.toPath());

		}
		else{
			
			throw new RuntimeException(Messages.SiriusServices_MSG_ERROR_NO_DESCRIPTOR_DIR);
		}
			 
			
    }
	
	 /**
     * Parse the descriptors and bring the info into entities.
     * @param descriptorsPath the path to the dir where the descriptor files are located inside the project
     */
	public void parseDescriptors(Path descriptorsPath){
		if(Files.exists(descriptorsPath , LinkOption.NOFOLLOW_LINKS)){
			// if descriptors exist, get the parsed descriptors
			File[] descriptorFiles = descriptorsPath.toFile().listFiles();
			if(descriptorFiles==null || descriptorFiles.length ==0){
				throw new RuntimeException(Messages.SiriusServices_MSG_ERROR_NO_DESCRIPTOR_FILES);
			}
			DescriptorParserImpl parser = new DescriptorParserImpl(descriptorsPath);
			parser.parseDescriptors();
			dbTypes = parser.getPlugins();
			features = parser.getFeatures();
		}
		else {				
			throw new RuntimeException(Messages.SiriusServices_MSG_ERROR_NO_DESCRIPTOR_DIR);
		}
		
		fillExternalElements();
	}
	
	/**
	 * Fills the external elements into the convenient hashmap structure for further lookup.
	 */
	private void fillExternalElements() {
		for (com.observability.modeling.probe.descriptor.entities.DbType dbType : dbTypes) {
			externalElements.put(dbType.getName(), new HashMap<String, Element>());
			Machine machine = dbType.getMachine();

			List<ElementTag> elementTags = machine.getElements();

			for (ElementTag element : elementTags) {

				if (element.getScope().equals(Scope.EXTERNAL)) {
					// Fill external elements
					Element newElement = factory.createElement();

					
					//We are setting the id instead of name to 
					// display a more descriptive text to the user.
					// We should come up with a better design
					// Also we are assuming a metric can have at most one Element as the child
					// 
					if(element.getId().contains(Messages.SiriusServices_NULL)){
						newElement.setName(element.getName());
					}else{
						newElement.setName(element.getId());
					}
					newElement.setValue(element.getValue());

					// fill sub elements and key values
					fillElements(element, newElement);
					
					// Add this to the convenient hashmap storage.
					// These elements will be added to the machines inside a
					// cluster only when a cluster is associated with a metric or a
					// machine is added to an already associated cluster
					externalElements.get(dbType.getName()).put(element.getId(), newElement);
				}

			}

		}

	}

	/**
	 * Initialize the EMF model with dbTypes read from the descriptors and the metrics
	 * inside the dbTypes
	 *  
	 * @param model Emf model instance to be populated
	 * @param dirPath the location of the descriptor folder
	 */
	private void initializeDbTypes( Model model, Path dirPath) {
		
		//Parse the descriptors
		parseDescriptors(dirPath.resolve(EclipseResourceDelegate.PROBE_DESCRIPTOR_DIR_PATH));
		
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
	 * @param dirPath the location of the descriptor dir
	 */
	public void initializeModel (Model model, Path dirPath){
		initializeDbTypes(model, dirPath);
		initializeFeatures(model);
	}
	
	/**
	 * Initialize the model with features read from the descriptors.
	 * @param model EMF model instance to be populated
	 */
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
			//Copy the keys and values
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
				if(element.getId().contains("null")){
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
		DatabaseCluster cluster = null;
		if(containerCluster instanceof DatabaseCluster)
			 cluster = (DatabaseCluster) containerCluster;
		else
			throw new RuntimeException(Messages.SiriusServices_MSG_ERROR_MUST_BE_DB_CLUSTER);
		
		//If the cluster is not associated with a dbType do nothing
		DbType associatedDbType = cluster.getAssociatedDbType();
		if(associatedDbType == null){
			return false;
		}
		
		NodeMachine machine = factory.createNodeMachine();
		
		//Copy elements from the entities filled from descriptor to EMF semantic instance
		for (com.observability.modeling.probe.descriptor.entities.DbType dbType : dbTypes) {
			if(dbType.getName().equals(associatedDbType.getName())){
				Machine machineParam = dbType.getMachine();
				
				fillElements( machineParam, machine,associatedDbType);
				break;
			}
			//throw new RuntimeException("Unknown database type: " + dbType.getName());
		}
		machine.setName(Messages.SiriusServices_MACHINE + (cluster.getMachines().size() + 1) + ""); //$NON-NLS-2$
		machine.setWarning("Please go to the Tree View to modify additional attributes.");
		//We need to fill external elements here
		for(Metric collectedMetric:cluster.getCollectedMetrics()){
			addMetricSpecificParamsToMachine(machine,collectedMetric,associatedDbType);
		}
		
		cluster.getMachines().add(machine);
		return true;
		
		
	}
	
	/**
	 * Add corresponding external elements to the machine entity on the EMF instance
	 * @param machine the instance to which the external elements will be added
	 * @param collectedMetric the metric whose external element declarations will be added to the machine
	 * @param associatedDbType the dbType which the machine's cluster is associated with
	 */
	private void addMetricSpecificParamsToMachine(NodeMachine machine, Metric collectedMetric,DbType associatedDbType) {
		for (Element element : getMatchingElements(collectedMetric, associatedDbType)) {
				machine.getElements().add(element);
			}
	}

	/**
	 * Copy internal elements to the EMF machine instance from the descriptor machine entity.
	 * @param machineParam the parser entity that holds internal elements regarding the machine
	 * @param semanticMachine the EMF machine entity to which the internal element will be copied to
	 * @param associatedDbType the DbType which the machine's cluster is associated with.
	 */
	private void fillElements(Machine machineParam, NodeMachine semanticMachine, DbType associatedDbType) {
		List<ElementTag> elementTags = machineParam.getElements();
		List<com.observability.modeling.probe.descriptor.entities.KeyValue> keyValues = machineParam.getKeyValues();
		
		for (ElementTag element : elementTags) {
			
			
			//Only add local scope elements when a new model instance is created
			//External scope elements will be added when a cluster is associated with a metric
			Element newElement = factory.createElement();
				
			//We are setting the id instead of name to 
			// display a more descriptive text to the user.
			// We should come up with a better design
			// Also we are assuming a metric can have at most one Element as the child
			// 
			if(element.getId().contains("null")){
				newElement.setName(element.getName());
			}else{
				newElement
				.setName(element.getId());
			}
			newElement.setValue(element.getValue());
							
			//fill sub elements and key values
			fillElements(element, newElement);
			if(element.getScope().equals(Scope.LOCAL)){
				
				
				semanticMachine.getElements().add(newElement);
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
	/**
	 * Method that adds external elements from  metric to all machines inside a cluster
	 * @param containerCluster the cluster which needs to be processed 
	 * @param associatedMetric the metric which the external attributes are taken from.
	 * @return true on successfull add. 
	 */
	public boolean addMetricSpecificParamsToMachinesInCluster(DatabaseCluster containerCluster , Metric associatedMetric){
		if(dbTypes == null)
			parseDescriptors();
		
		DatabaseCluster cluster =  containerCluster;
		
		//If the cluster is not associated with a dbType do nothing
		DbType associatedDbType = cluster.getAssociatedDbType();
		if(associatedDbType == null)
			return false;
	
		List<NodeMachine> machinesInCluster = cluster.getMachines();
		for (NodeMachine nodeMachine : machinesInCluster) {
			
			//TODO speed optimization: check for the matchingElements only for the first machine
			// 
			for (Element element : getMatchingElements(associatedMetric, associatedDbType)) {
				nodeMachine.getElements().add(element);
			}
		}
		
		return true;
	}
	
	/**
	 * Lookup the external elements from that belong to the metric
	 * @param metric The metric the external elements belong to
	 * @param associatedDbType The dbType that provides the metric
	 * @return list of external elements that belong to the metric
	 */
	private List<Element> getMatchingElements(Metric metric, DbType associatedDbType){
		List<Element> elementsToAddToMachine = new ArrayList<Element>();
		
		//We assume the metric id is on the first element
		if(metric.getElements().size()> 0){
			//We assume the id is <key>_<value>
			
			String id = ""; //$NON-NLS-1$
			if (metric.getElements().get(0).getName().indexOf(Messages.SiriusServices_ID_SEPERATOR) == -1)
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

	/**
	 * Show a native jface dialog indicating the reason for a machine add failure
	 * @param title The caption of the popup
	 * @param message The message
	 */
	public void eclipseShowError(String title, String message) {
		eclipse.eclipseShowError(title, message);
		
	}

}

	
	
	