/**
 */
package com.observability.modeling.emf.tests;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;

import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfFactory;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.KeyValue;
import com.observability.modeling.emf.NodeMachine;
import com.observability.modeling.emf.impl.ElementImpl;
import com.observability.modeling.emf.impl.NodeMachineImpl;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Node Machine</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NodeMachineTest extends TestCase {

	/**
	 * The fixture for this Node Machine test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeMachine fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NodeMachineTest.class);
	}

	/**
	 * Constructs a new Node Machine test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeMachineTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Node Machine test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(NodeMachine fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Node Machine test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeMachine getFixture() {
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
		EClass eClass = (EClass)EmfPackage.eINSTANCE.getEClassifier("NodeMachine");
		setFixture((NodeMachine)EmfFactory.eINSTANCE.create(eClass));
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
	
	public void testNodeMachine() throws Exception {
		
		NodeMachineImpl nm = (NodeMachineImpl) getFixture();
		Throwable e = null;
		Element el = EmfFactory.eINSTANCE.createElement();
		KeyValue kv = EmfFactory.eINSTANCE.createKeyValue();
		ArrayList<Element> list = new ArrayList<Element>();
		ArrayList<KeyValue> kvList = new ArrayList<KeyValue>();
		
		assertFalse(nm.eIsSet(EmfPackage.NODE_MACHINE__NAME));
		assertFalse(nm.eIsSet(EmfPackage.NODE_MACHINE__IP));
		assertFalse(nm.eIsSet(EmfPackage.NODE_MACHINE__PORT));
		assertFalse(nm.eIsSet(EmfPackage.NODE_MACHINE__KEY_VALUES));
		assertFalse(nm.eIsSet(EmfPackage.NODE_MACHINE__ELEMENTS));
		
		try{
			nm.eIsSet(6);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		nm.eSet(EmfPackage.NODE_MACHINE__NAME, "name");
		nm.eSet(EmfPackage.NODE_MACHINE__IP, "127.0.0.1");
		nm.eSet(EmfPackage.NODE_MACHINE__PORT, 1111);
		list.add(el);
		nm.eSet(EmfPackage.NODE_MACHINE__ELEMENTS, list);
		kvList.add(kv);
		nm.eSet(EmfPackage.NODE_MACHINE__KEY_VALUES, kvList);
		
		try{
			nm.eSet(6, "value");
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertTrue(nm.eIsSet(EmfPackage.NODE_MACHINE__NAME));
		assertTrue(nm.eIsSet(EmfPackage.NODE_MACHINE__IP));
		assertTrue(nm.eIsSet(EmfPackage.NODE_MACHINE__PORT));
		assertTrue(nm.eIsSet(EmfPackage.NODE_MACHINE__KEY_VALUES));
		assertTrue(nm.eIsSet(EmfPackage.NODE_MACHINE__ELEMENTS));
		
		assertEquals(nm.eGet(EmfPackage.NODE_MACHINE__NAME, true, true), "name");
		assertEquals(nm.eGet(EmfPackage.NODE_MACHINE__IP, true, true), "127.0.0.1");
		assertEquals(nm.eGet(EmfPackage.NODE_MACHINE__PORT, true, true), 1111);
		assertEquals(((Collection<? extends Element>)nm.eGet(EmfPackage.NODE_MACHINE__ELEMENTS, true, true)).size(), 1);
		assertEquals(((Collection<? extends KeyValue>)nm.eGet(EmfPackage.NODE_MACHINE__KEY_VALUES, true, true)).size(), 1);
		
		try{
			nm.eGet(6, true, true);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		nm.eUnset(EmfPackage.NODE_MACHINE__NAME);
		nm.eUnset(EmfPackage.NODE_MACHINE__IP);
		nm.eUnset(EmfPackage.NODE_MACHINE__PORT);
		nm.eUnset(EmfPackage.NODE_MACHINE__ELEMENTS);
		nm.eUnset(EmfPackage.NODE_MACHINE__KEY_VALUES);
		
		try{
			nm.eUnset(5);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertNull(nm.eGet(EmfPackage.NODE_MACHINE__NAME, true, true));
		assertNull(nm.eGet(EmfPackage.NODE_MACHINE__IP, true, true));
		assertEquals(nm.eGet(EmfPackage.NODE_MACHINE__PORT, true, true),0);
		assertEquals(((Collection<? extends Element>)nm.eGet(EmfPackage.NODE_MACHINE__ELEMENTS, true, true)).size(), 0);
		assertEquals(((Collection<? extends KeyValue>)nm.eGet(EmfPackage.NODE_MACHINE__KEY_VALUES, true, true)).size(), 0);
		assertFalse(nm.eIsSet(EmfPackage.NODE_MACHINE__KEY_VALUES));
		assertFalse(nm.eIsSet(EmfPackage.NODE_MACHINE__ELEMENTS));		
		System.out.println(nm.toString());
		
		
	}
} //NodeMachineTest
