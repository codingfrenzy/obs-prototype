/**
 */
package com.observability.modeling.emf.tests;

import java.util.ArrayList;
import java.util.Collection;

import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfFactory;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.KeyValue;
import com.observability.modeling.emf.Notification;
import com.observability.modeling.emf.impl.ElementImpl;
import com.observability.modeling.emf.impl.NotificationImpl;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Notification</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NotificationTest extends TestCase {

	/**
	 * The fixture for this Notification test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Notification fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NotificationTest.class);
	}

	/**
	 * Constructs a new Notification test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Notification test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Notification fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Notification test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Notification getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmfFactory.eINSTANCE.createNotification());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	public void testNotification() throws Exception {
		NotificationImpl n = (NotificationImpl) getFixture();
		
		Throwable e = null;
		
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__DATA_SOURCE));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__FAILURE_MAX));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__FAILURE_MIN));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__HITS));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__HYSTERESIS));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__INSTANCE));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__INTERESTING));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__INVERT));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__PERCENTAGE));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__PERSIST));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__PERSIST_OK));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__TYPE));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__WARNING_MAX));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__WARNING_MIN));
		
		
		
		try{
			n.eIsSet(15);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		n.eSet(EmfPackage.NOTIFICATION__DATA_SOURCE, "source");
		n.eSet(EmfPackage.NOTIFICATION__FAILURE_MAX, 10.0);
		n.eSet(EmfPackage.NOTIFICATION__FAILURE_MIN, 1.0);
		n.eSet(EmfPackage.NOTIFICATION__HITS, 5);
		n.eSet(EmfPackage.NOTIFICATION__HYSTERESIS, 5);
		n.eSet(EmfPackage.NOTIFICATION__INSTANCE, "instance");
		n.eSet(EmfPackage.NOTIFICATION__INTERESTING, true);
		n.eSet(EmfPackage.NOTIFICATION__INVERT, true);
		n.eSet(EmfPackage.NOTIFICATION__PERCENTAGE, true);
		n.eSet(EmfPackage.NOTIFICATION__PERSIST, true);
		n.eSet(EmfPackage.NOTIFICATION__PERSIST_OK, true);		
		n.eSet(EmfPackage.NOTIFICATION__TYPE, "type");
		n.eSet(EmfPackage.NOTIFICATION__WARNING_MAX, 15.0);
		n.eSet(EmfPackage.NOTIFICATION__WARNING_MIN, 1.0);

		try{
			n.eSet(15, "value");
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__DATA_SOURCE));
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__FAILURE_MAX));
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__FAILURE_MIN));
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__HITS));
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__HYSTERESIS));
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__INSTANCE));
		assertFalse(n.eIsSet(EmfPackage.NOTIFICATION__INTERESTING));
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__INVERT));
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__PERCENTAGE));
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__PERSIST));
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__PERSIST_OK));
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__TYPE));
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__WARNING_MAX));
		assertTrue(n.eIsSet(EmfPackage.NOTIFICATION__WARNING_MIN));
		
		
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__DATA_SOURCE, true, true), "source");
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__FAILURE_MAX, true, true), 10.0);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__FAILURE_MIN, true, true), 1.0);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__HITS, true, true), 5);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__HYSTERESIS, true, true), 5);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__INSTANCE, true, true), "instance");
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__INTERESTING, true, true), true);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__INVERT, true, true), true);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__PERCENTAGE, true, true), true);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__PERSIST, true, true), true);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__PERSIST_OK, true, true), true);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__TYPE, true, true), "type");
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__WARNING_MAX, true, true), 15.0);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__WARNING_MIN, true, true), 1.0);
				
		try{
			n.eGet(15, true, true);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		n.eUnset(EmfPackage.NOTIFICATION__DATA_SOURCE);
		n.eUnset(EmfPackage.NOTIFICATION__FAILURE_MAX);
		n.eUnset(EmfPackage.NOTIFICATION__FAILURE_MIN);
		n.eUnset(EmfPackage.NOTIFICATION__HITS);
		n.eUnset(EmfPackage.NOTIFICATION__HYSTERESIS);
		n.eUnset(EmfPackage.NOTIFICATION__INSTANCE);
		n.eUnset(EmfPackage.NOTIFICATION__INTERESTING);
		n.eUnset(EmfPackage.NOTIFICATION__INVERT);
		n.eUnset(EmfPackage.NOTIFICATION__PERCENTAGE);
		n.eUnset(EmfPackage.NOTIFICATION__PERSIST);
		n.eUnset(EmfPackage.NOTIFICATION__PERSIST_OK);
		n.eUnset(EmfPackage.NOTIFICATION__TYPE);
		n.eUnset(EmfPackage.NOTIFICATION__WARNING_MAX);
		n.eUnset(EmfPackage.NOTIFICATION__WARNING_MIN);
		
		
		try{
			n.eUnset(15);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertNull(n.eGet(EmfPackage.NOTIFICATION__DATA_SOURCE, true, true));
		assertNull(n.eGet(EmfPackage.NOTIFICATION__TYPE, true, true));
		assertNull(n.eGet(EmfPackage.NOTIFICATION__INSTANCE, true, true));
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__FAILURE_MAX, true, true), 0.0);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__FAILURE_MIN, true, true), 0.0);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__HITS, true, true), 1);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__HYSTERESIS, true, true), 0);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__INTERESTING, true, true),true);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__INVERT, true, true), false);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__PERCENTAGE, true, true), false);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__PERSIST, true, true), false);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__PERSIST_OK, true, true), false);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__WARNING_MAX, true, true), 0.0);
		assertEquals(n.eGet(EmfPackage.NOTIFICATION__WARNING_MIN, true, true), 0.0);
		
		
		System.out.println(n.toString());
	}

} //NotificationTest
