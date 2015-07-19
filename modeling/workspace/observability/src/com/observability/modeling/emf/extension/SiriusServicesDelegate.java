/**
 * 
 */
package com.observability.modeling.emf.extension;

import org.eclipse.emf.ecore.EObject;

import com.observability.modeling.emf.DatabaseCluster;
import com.observability.modeling.emf.Metric;

/**
 * @author gemici
 *
 */
public class SiriusServicesDelegate {

	/**
	 * https://www.eclipse.org/sirius/doc/specifier/general/Writing_Queries.html#service_methods
	 * 
	 */
	private static SiriusServices services = SiriusServices.getInstance();
	
	public SiriusServicesDelegate(){
		
	}
	
	public boolean initializeMachine(EObject containerCluster){
		return services.initializeMachine(containerCluster);
	}
	
	public boolean addMetricSpecificParamsToMachinesInCluster(DatabaseCluster containerCluster , Metric associatedMetric){
		return services.addMetricSpecificParamsToMachinesInCluster(containerCluster, associatedMetric);
	}
}
