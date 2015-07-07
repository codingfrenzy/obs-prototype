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

package com.observability.modeling.probe.descriptor.entities;

import java.util.ArrayList;

/**
 * The class defines the metrics which the user wants to collect
 * from the list of available metrics.
 * @author vsaravag
 *
 */
public class Collect extends Parameter {
	
	public Collect(){
		this.elements = new ArrayList<ElementTag>();
	}
	public Collect(String name, String value){
		if(name!=null){
			this.name = name;
			this.value = value;
			this.elements = new ArrayList<ElementTag>();
		}
	}
}
