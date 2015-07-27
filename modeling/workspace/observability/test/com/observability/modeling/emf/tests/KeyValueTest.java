/**
 */
package com.observability.modeling.emf.tests;

import org.eclipse.emf.ecore.EClass;
import org.hamcrest.core.IsInstanceOf;

import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfFactory;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.KeyValue;
import com.observability.modeling.emf.impl.KeyValueImpl;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Key Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class KeyValueTest extends TestCase {

	/**
	 * The fixture for this Key Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyValue fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(KeyValueTest.class);
	}

	/**
	 * Constructs a new Key Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyValueTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Key Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(KeyValue fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Key Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyValue getFixture() {
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
		EClass eClass = (EClass)EmfPackage.eINSTANCE.getEClassifier("KeyValue");
		setFixture((KeyValue)EmfFactory.eINSTANCE.create(eClass));
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
	
	public void testKeyValue() throws Exception {
		Throwable e = null;
		KeyValueImpl kv = (KeyValueImpl) getFixture();
	
		assertFalse(kv.eIsSet(EmfPackage.KEY_VALUE__KEY));
		assertFalse(kv.eIsSet(EmfPackage.KEY_VALUE__VALUE));
		
		try{
			kv.eIsSet(3);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		kv.eSet(EmfPackage.KEY_VALUE__KEY, "key");
		kv.eSet(EmfPackage.KEY_VALUE__VALUE, "value");
		
		try{
			kv.eSet(3, "value");
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertTrue(kv.eIsSet(EmfPackage.KEY_VALUE__KEY));
		assertTrue(kv.eIsSet(EmfPackage.KEY_VALUE__VALUE));
		
		assertEquals(kv.eGet(EmfPackage.KEY_VALUE__KEY, true, true), "key");
		assertEquals(kv.eGet(EmfPackage.KEY_VALUE__VALUE, true, true), "value");
		
		try{
			kv.eGet(3, true, true);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		kv.eUnset(EmfPackage.KEY_VALUE__KEY);
		kv.eUnset(EmfPackage.KEY_VALUE__VALUE);
		
		try{
			kv.eUnset(3);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertNull(kv.eGet(EmfPackage.KEY_VALUE__KEY, true, true));
		assertNull(kv.eGet(EmfPackage.KEY_VALUE__VALUE, true, true));
		
		System.out.println(kv.toString());
	}
} //KeyValueTest
