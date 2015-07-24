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

import org.eclipse.emf.ecore.EObject;

import com.observability.modeling.emf.DatabaseCluster;
import com.observability.modeling.emf.Metric;

/**
 * @author gemici
 * 
 * https://www.eclipse.org/sirius/doc/specifier/general/Writing_Queries.html#service_method
 * This class encapsulates the constraints that Sirius services bring, so that
 * we are more relaxed in our actual service.
 */
public class SiriusServicesDelegate {

	private static SiriusServices services = SiriusServices.getInstance();
	
	public SiriusServicesDelegate(){}
	
	/**
	 * See {@link SiriusServices#initializeMachine(EObject)}.
	 */
	public boolean initializeMachine(EObject containerCluster){
		return services.initializeMachine(containerCluster);
	}
	/**
	 * See {@link SiriusServices#addMetricSpecificParamsToMachinesInCluster(DatabaseCluster, Metric)}.
	 */
	public boolean addMetricSpecificParamsToMachinesInCluster(DatabaseCluster containerCluster , Metric associatedMetric){
		return services.addMetricSpecificParamsToMachinesInCluster(containerCluster, associatedMetric);
	}
	/**
	 * Show a native jface dialog indicating the reason for a machine add failure
	 * @param object not uses. we need to have this to conform to a sirius service
	 */
	public void eclipseCantAddMachineShowError(EObject objects){
		services.eclipseShowError("Error", "Cannot add machine. Cluster needs to be associated with a database type first!");

	}
	
	/**
	 * Show a native jface dialog indicating the reason for a metric association failure
	 * @param object not uses. we need to have this to conform to a sirius service
	 */
	public void eclipseCantConnectMetricError(EObject objects){
		services.eclipseShowError("Error", "Cannot associate with metric. Cluster needs to be associated with a database type first!");

	}
}
