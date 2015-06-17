package observability_new.design;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import observability_new.DbType;
import observability_new.Model;
import observability_new.Observability_newFactory;
import observability_new.Observability_newPackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


public class LevelTwoService {
	
	public LevelTwoService(){
		
		System.out.print("Level 2 Service ready!");
		//createModel();
		
	}
	private void createModel() {
		// Initialize the model
	    Observability_newPackage.eINSTANCE.eClass();
	    
	    Observability_newFactory factory = Observability_newFactory.eINSTANCE;

	    // Register the XMI resource factory for the .0bservability_new extension

	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("observability_new", new XMIResourceFactoryImpl());

	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();

	    // Get the resource
	    Resource resource = resSet.getResource(URI
	        .createURI("platform:/resource/observability_new.design/My.observability_new"), true);
	    // Get the first model element and cast it to the right type, in my
	    // example everything is hierarchical included in this first node
	    Model model = (Model) resource.getContents().get(0);
	    
	    DbType cassandraDb = factory.createDbType();
	    cassandraDb.setName("Cass");
	    model.getAvailableDbTypes().add(cassandraDb);
	    try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	public boolean getName(EObject obj){
		return observability_new.extension.CustomServices.initializeMachine(obj);
		
	}
	
	
	

}
