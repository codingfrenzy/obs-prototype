/**
 * 
 */
package com.observability.modeling.probe.descriptor.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author vsaravag
 *
 */
public class DbTypeTest {
	
	DbType db = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		db = new DbType("name");
	}
	
	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.DbType#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		db.setName("changedName");
		assertEquals(db.getName(), "changedName");
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.DbType#setMachine(com.observability.modeling.probe.descriptor.entities.Machine)}.
	 */
	@Test
	public void testSetMachine() {
		Machine m = new Machine();
		db.setMachine(m);
		assertEquals(db.getMachine(), m);
	}

}
