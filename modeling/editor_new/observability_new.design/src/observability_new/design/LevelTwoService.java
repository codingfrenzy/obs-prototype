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
package observability_new.design;

import observability_new.extension.CustomServices;

import org.eclipse.emf.ecore.EObject;

/**
 * This is a service that can be called from odesign file. All it does is to
 * forward it to the actual service
 * 
 * @author gemici 
 * 
 * TODO For now we cannot refer to the service defined in the
 *         level 1 (first obeo editor). Ideally we should not need this service
 *         and directly call the service on the first level
 */
public class LevelTwoService {

	public LevelTwoService() {
		System.out.print("Level 2 Service ready!");
	}

	/**
	 * This is called when a new machine is dragged and dropped
	 * onto a dbCluster
	 * @param obj this is expected to be the DatabaseCluster in 
	 *  	which to create the new machine
	 * @return true when machine is created,false otherwise
	 */
	public boolean createMachine(EObject obj) {
		return CustomServices.initializeMachine(obj);

	}

}
