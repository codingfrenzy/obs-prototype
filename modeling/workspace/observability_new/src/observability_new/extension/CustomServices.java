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

package observability_new.extension;

import java.nio.file.Paths;
import java.util.List;

import observability_new.DatabaseCluster;
import observability_new.DbType;
import observability_new.Element;
import observability_new.KeyValue;
import observability_new.Metric;
import observability_new.Model;
import observability_new.NodeMachine;
import observability_new.Observability_newFactory;
import observability_new.Observability_newPackage;

import org.eclipse.emf.ecore.EObject;

import com.observability.modeling.probe.descriptor.DescriptorParserImpl;
import com.observability.modeling.probe.descriptor.entities.ElementTag;
import com.observability.modeling.probe.descriptor.entities.Machine;

/**
 * @author gemici
 * This class is a service class that reads the probe descriptors and 
 * changes the EMF model instance according to the information on the descriptors
 */

public class CustomServices {
	
	/*
	 * The relative path to where the probe descriptors are stored
	 */
	private static String PROBE_DESCRIPTOR_DIR_PATH = "descriptors";
	
	/*
	 * In memory representation of the descriptor files. One dbType is created
	 * per descriptor file
	 */
	private static List<com.observability.modeling.probe.descriptor.entities.DbType> dbTypes;
	
	/*
	 * Factory class to manipulate the EMF model instance.
	 */
	private static Observability_newFactory factory = Observability_newFactory.eINSTANCE;
    
	
    /*
     * Parse the descriptors and bring the info into entitites at class loading
     * 
     * TODO Change the absolute path to relative path. Ideally use resource locator
     * TODO We are probably parsing 2 times. One per method call. Ideally this should not be happening.But it seems the 
     * 		class gets destroyed between the calls to initializeDbTypes and initializeMachine
     */
	
	static {
    	Observability_newPackage.eINSTANCE.eClass();
	    //DescriptorParserImpl parser = new DescriptorParserImpl( Paths.get("D:/observability modeling/modeling/workspace/observability_new/src/resources"));
	    DescriptorParserImpl parser = new DescriptorParserImpl( Paths.get("/home/vsaravag/git/obs-prototype/modeling/workspace/observability_new/src/resources"));
		dbTypes = parser.parseDescriptors();
    }
	
	
	/**
	 * This method is called from the model creation wizard code which is 
	 * generated by EMF. It creates the dbTypes and metrics inside them on 
	 * the EMF instance (aka semantic model) by looking at the information loaded 
	 * from the descriptors.
	 * 
	 * @param model the root element to fill in the new entities
	 */
	public static void initializeDbTypes( Model model){
		
				
		//Read descriptor files
		//ClassLoader classLoader = DescriptorParserImpl.class.getClassLoader();
		//URL path = classLoader.getResource("basicTest2.descriptor");
	    //DescriptorParserImpl parser = new DescriptorParserImpl( new File (path.getFile()).toPath().getParent());

		
		//Create dbTypes for each descriptor file
		for (com.observability.modeling.probe.descriptor.entities.DbType dbType : dbTypes) {
			DbType newDbType = factory.createDbType();
			newDbType.setName(dbType.getName());
			
			//Create Metrics for each @metric annotation
			com.observability.modeling.probe.descriptor.entities.Metric metrics =  dbType.getMetricParams();
			for (ElementTag elementTag : metrics.getElements()) {
				Metric newMetric = factory.createBaseMetric();
				
				//Assuming the name is taken from the value of the tag.
				newMetric.setName(elementTag.getValue());
				newDbType.getAvailableMetrics().add(newMetric);
			}
			model.getAvailableDbTypes().add(newDbType);
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
	public static boolean initializeMachine(EObject containerCluster){
		
		DatabaseCluster cluster = (DatabaseCluster) containerCluster;
		
		//If the cluster is not associated with a dbType do nothing
		DbType associatedDbType = cluster.getAssociatedDbType();
		if(associatedDbType == null)
			return false;
		
		
		NodeMachine machine = factory.createNodeMachine();
		
		//Copy elements from the entities filled from descriptor to EMF semantic instance
		for (com.observability.modeling.probe.descriptor.entities.DbType dbType : dbTypes) {
			if(dbType.getName().equals(associatedDbType.getName())){
				Machine machineParam = dbType.getMachineParams();
				
				//create placeholder root element 
				Element rootElement = factory.createElement();
				rootElement.setName("root");
				
				fillElements( machineParam, rootElement);
				machine.setHasParentElement(rootElement);
				break;
			}
		}
		cluster.getMachines().add(machine);
		return true;
		
		
	}
	
	/**
	 * 
	 * @param machineParam 
	 * @param rootElement
	 */
	private static void fillElements(Machine machineParam, Element rootElement) {
		List<ElementTag> elementTags = machineParam.getElements();
		
		for (ElementTag element : elementTags) {
			Element newElement = factory.createElement();
			
			//copy name and value
			newElement.setName(element.getName());
			newElement.setValue(element.getValue());
			
			//fill sub elements and key values
			fillElements(element, newElement);
			
			rootElement.getHasElements().add(newElement);
		}
		
	}
	
	/**
	 * Recursive method to copy the elements and keyValues
	 * given the starting node of the descriptor entities and EMF semantic model
	 * @param element  point to start copying from the descriptor entities 
	 * @param newElement point to start copying to the EMF semantic model
	 */
	private static void fillElements(ElementTag element, Element newElement) {
		
		//For each sub element copy them as well
		List<ElementTag> elements = element.getElements();
		if(elements.size() != 0){
			for (ElementTag elementTag : elements) {
				Element newSubElement = factory.createElement();
				fillElements(elementTag, newSubElement);
				newElement.getHasElements().add(newSubElement);
			}
		}
		
		//For each keyValue element copy them as well
		List<ElementTag.KeyValue> keyValues =  element.getKeyValues();
		if(keyValues.size() != 0){
			for (ElementTag.KeyValue keyValue : keyValues) {
				KeyValue newKey = factory.createKeyValue();
				newKey.setKey(keyValue.getName());
				newKey.setValue(keyValue.getValue());
				newElement.getHasKeyValues().add(newKey);
			} 
		}
	}

	
	
	public static void main(String[] args) {
		Observability_newPackage.eINSTANCE.eClass();
	    Observability_newFactory factory = Observability_newFactory.eINSTANCE;
	    
	    Model m = factory.createModel();
	    initializeDbTypes(m);
	}


}
