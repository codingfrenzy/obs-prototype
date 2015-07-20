/**
 */
package com.observability.modeling.emf.tests;

import java.util.ArrayList;
import java.util.Collection;

import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfFactory;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.KeyValue;
import com.observability.modeling.emf.impl.ElementImpl;
import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ElementTest extends TestCase {

	/**
	 * The fixture for this Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Element fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ElementTest.class);
	}

	/**
	 * Constructs a new Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Element fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Element getFixture() {
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
		setFixture(EmfFactory.eINSTANCE.createElement());
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
	
	public void testElement() throws Exception {
		Throwable e = null;
		ElementImpl el = (ElementImpl) getFixture();
		KeyValue kv = EmfFactory.eINSTANCE.createKeyValue();
		ArrayList<Element> list = new ArrayList<Element>();
		ArrayList<KeyValue> kvList = new ArrayList<KeyValue>();
		
		assertFalse(el.eIsSet(EmfPackage.ELEMENT__NAME));
		assertFalse(el.eIsSet(EmfPackage.ELEMENT__VALUE));
		assertFalse(el.eIsSet(EmfPackage.ELEMENT__KEY_VALUES));
		assertFalse(el.eIsSet(EmfPackage.ELEMENT__ELEMENTS));
		
		try{
			el.eIsSet(5);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		el.eSet(EmfPackage.ELEMENT__NAME, "name");
		el.eSet(EmfPackage.ELEMENT__VALUE, "value");
		list.add(el);
		el.eSet(EmfPackage.ELEMENT__ELEMENTS, list);
		kvList.add(kv);
		el.eSet(EmfPackage.ELEMENT__KEY_VALUES, kvList);
		
		try{
			el.eSet(5, "value");
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertTrue(el.eIsSet(EmfPackage.ELEMENT__NAME));
		assertTrue(el.eIsSet(EmfPackage.ELEMENT__VALUE));
		assertTrue(el.eIsSet(EmfPackage.ELEMENT__KEY_VALUES));
		assertTrue(el.eIsSet(EmfPackage.ELEMENT__ELEMENTS));
		
		assertEquals(el.eGet(EmfPackage.ELEMENT__NAME, true, true), "name");
		assertEquals(el.eGet(EmfPackage.ELEMENT__VALUE, true, true), "value");
		assertEquals(((Collection<? extends Element>)el.eGet(EmfPackage.ELEMENT__ELEMENTS, true, true)).size(), 1);
		assertEquals(((Collection<? extends KeyValue>)el.eGet(EmfPackage.ELEMENT__KEY_VALUES, true, true)).size(), 1);
		
		try{
			el.eGet(5, true, true);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		el.eUnset(EmfPackage.ELEMENT__NAME);
		el.eUnset(EmfPackage.ELEMENT__VALUE);
		el.eUnset(EmfPackage.ELEMENT__ELEMENTS);
		el.eUnset(EmfPackage.ELEMENT__KEY_VALUES);
		
		try{
			el.eUnset(5);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertNull(el.eGet(EmfPackage.ELEMENT__NAME, true, true));
		assertNull(el.eGet(EmfPackage.ELEMENT__VALUE, true, true));
		assertEquals(((Collection<? extends Element>)el.eGet(EmfPackage.ELEMENT__ELEMENTS, true, true)).size(), 0);
		assertEquals(((Collection<? extends KeyValue>)el.eGet(EmfPackage.ELEMENT__KEY_VALUES, true, true)).size(), 0);
		
		System.out.println(el.toString());
	}	

} //ElementTest
