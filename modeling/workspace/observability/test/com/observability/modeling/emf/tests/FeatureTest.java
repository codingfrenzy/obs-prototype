/**
 */
package com.observability.modeling.emf.tests;

import java.util.ArrayList;
import java.util.Collection;

import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfFactory;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.Feature;
import com.observability.modeling.emf.KeyValue;
import com.observability.modeling.emf.impl.FeatureImpl;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureTest extends TestCase {

	/**
	 * The fixture for this Feature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Feature fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FeatureTest.class);
	}

	/**
	 * Constructs a new Feature test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Feature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Feature fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Feature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Feature getFixture() {
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
		setFixture(EmfFactory.eINSTANCE.createFeature());
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
	
	public void testFeature() throws Exception {
		Throwable e = null;
		FeatureImpl f = (FeatureImpl) getFixture();
		Element el = EmfFactory.eINSTANCE.createElement();
		KeyValue kv = EmfFactory.eINSTANCE.createKeyValue();
		ArrayList<Element> list = new ArrayList<Element>();
		ArrayList<KeyValue> kvList = new ArrayList<KeyValue>();
		
		assertFalse(f.eIsSet(EmfPackage.FEATURE__NAME));
		assertFalse(f.eIsSet(EmfPackage.FEATURE__KEY_VALUES));
		assertFalse(f.eIsSet(EmfPackage.FEATURE__ELEMENTS));
		
		try{
			f.eIsSet(5);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		f.eSet(EmfPackage.FEATURE__NAME, "name");
		list.add(el);
		f.eSet(EmfPackage.FEATURE__ELEMENTS, list);
		kvList.add(kv);
		f.eSet(EmfPackage.FEATURE__KEY_VALUES, kvList);
		
		try{
			f.eSet(5, "value");
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertTrue(f.eIsSet(EmfPackage.FEATURE__NAME));
		assertTrue(f.eIsSet(EmfPackage.FEATURE__KEY_VALUES));
		assertTrue(f.eIsSet(EmfPackage.FEATURE__ELEMENTS));
		
		assertEquals(f.eGet(EmfPackage.FEATURE__NAME, true, true), "name");
		assertEquals(((Collection<? extends Element>)f.eGet(EmfPackage.FEATURE__ELEMENTS, true, true)).size(), 1);
		assertEquals(((Collection<? extends KeyValue>)f.eGet(EmfPackage.FEATURE__KEY_VALUES, true, true)).size(), 1);
		
		try{
			f.eGet(5, true, true);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		f.eUnset(EmfPackage.FEATURE__NAME);
		f.eUnset(EmfPackage.FEATURE__ELEMENTS);
		f.eUnset(EmfPackage.FEATURE__KEY_VALUES);
		
		try{
			f.eUnset(5);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertNull(f.eGet(EmfPackage.FEATURE__NAME, true, true));
		assertEquals(((Collection<? extends Element>)f.eGet(EmfPackage.FEATURE__ELEMENTS, true, true)).size(), 0);
		assertEquals(((Collection<? extends KeyValue>)f.eGet(EmfPackage.FEATURE__KEY_VALUES, true, true)).size(), 0);
		
		System.out.println(f.toString());
	}
} //FeatureTest
