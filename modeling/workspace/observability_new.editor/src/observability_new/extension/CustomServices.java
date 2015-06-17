/**
 * 
 */
package observability_new.extension;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.internal.registry.KeywordRegistry;

import observability_new.DatabaseCluster;
import observability_new.DbType;
import observability_new.Element;
import observability_new.KeyValue;
import observability_new.Metric;
import observability_new.Model;
import observability_new.NodeMachine;
import observability_new.Observability_newFactory;
import observability_new.Observability_newPackage;

import com.observability.modeling.probe.descriptor.DescriptorParserImpl;
import com.observability.modeling.probe.descriptor.entities.ElementTag;
import com.observability.modeling.probe.descriptor.entities.Machine;

/**
 * @author cem
 *
 */
public class CustomServices {
	
	private static String PROBE_DESCRIPTOR_DIR_PATH = "descriptors";
	private static List<com.observability.modeling.probe.descriptor.entities.DbType> dbTypes;
	private static Observability_newFactory factory = Observability_newFactory.eINSTANCE;
    
	
	//We are parsing 2 times. One per method call. Ideally this should not be happening but it seems the
	//class gets destroyed between the calls to initializeDbTypes and initializeMachine
    static {
    	Observability_newPackage.eINSTANCE.eClass();
	    DescriptorParserImpl parser = new DescriptorParserImpl( Paths.get("D:/observability modeling/modeling/workspace/observability_new/src/resources"));		
	    
		dbTypes = parser.parseDescriptors();
    }
	
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
				newMetric.setName(elementTag.getValue());
				newDbType.getAvailableMetrics().add(newMetric);
			}
			model.getAvailableDbTypes().add(newDbType);
		}
				    
		
	}
	
	public static boolean initializeMachine(EObject containerCluster){
		
		DatabaseCluster cluster = (DatabaseCluster) containerCluster;
		DbType associatedDbType = cluster.getAssociatedDbType();
		if(associatedDbType == null)
			return false;
		NodeMachine machine = factory.createNodeMachine();

		
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
	//Recursive
	private static void fillElements(ElementTag element, Element newElement) {
		
		List<ElementTag> elements = element.getElements();
		if(elements.size() != 0){
			for (ElementTag elementTag : elements) {
				Element newSubElement = factory.createElement();
				fillElements(elementTag, newSubElement);
				newElement.getHasElements().add(newSubElement);
			}
		}
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
