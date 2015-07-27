/**
 */
package com.observability.modeling.emf.tests;

import com.observability.modeling.emf.EmfFactory;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.Feature;
import com.observability.modeling.emf.KeyValue;
import com.observability.modeling.emf.Model;
import com.observability.modeling.emf.Notification;
import com.observability.modeling.emf.impl.ModelImpl;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;

import com.observability.modeling.emf.DatabaseCluster;
import com.observability.modeling.emf.DbType;
import com.observability.modeling.emf.Element;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelTest extends TestCase {

	/**
	 * The fixture for this Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Model fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ModelTest.class);
	}

	/**
	 * Constructs a new Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Model fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Model getFixture() {
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
		EClass eClass = (EClass)EmfPackage.eINSTANCE.getEClassifier("Model");
		setFixture((Model)EmfFactory.eINSTANCE.create(eClass));
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
	
	
	public void testModel() throws Exception {
		
		ModelImpl m = (ModelImpl) getFixture();
		Throwable e = null;
		Notification n = EmfFactory.eINSTANCE.createNotification();
		DbType db = EmfFactory.eINSTANCE.createDbType();
		Feature f = EmfFactory.eINSTANCE.createFeature();
		DatabaseCluster c = EmfFactory.eINSTANCE.createDatabaseCluster();
		
		ArrayList<Notification> nList = new ArrayList<Notification>();
		ArrayList<DbType> dbList = new ArrayList<DbType>();
		ArrayList<Feature> fList = new ArrayList<Feature>();
		ArrayList<DatabaseCluster> cList = new ArrayList<DatabaseCluster>();
		
		assertFalse(m.eIsSet(EmfPackage.MODEL__NAME));
		assertFalse(m.eIsSet(EmfPackage.MODEL__AVAILABLE_DB_TYPES));
		assertFalse(m.eIsSet(EmfPackage.MODEL__CLUSTERS));
		assertFalse(m.eIsSet(EmfPackage.MODEL__FEATURES));
		assertFalse(m.eIsSet(EmfPackage.MODEL__INTERVAL));
		assertFalse(m.eIsSet(EmfPackage.MODEL__NOTIFICATIONS));
		assertFalse(m.eIsSet(EmfPackage.MODEL__SERVER_IP));
		
		
		try{
			m.eIsSet(8);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		m.eSet(EmfPackage.MODEL__NAME, "name");
		m.eSet(EmfPackage.MODEL__SERVER_IP, "127.0.0.1");
		m.eSet(EmfPackage.MODEL__INTERVAL, 60);
		dbList.add(db);
		m.eSet(EmfPackage.MODEL__AVAILABLE_DB_TYPES , dbList);
		nList.add(n);
		m.eSet(EmfPackage.MODEL__NOTIFICATIONS, nList);
		fList.add(f);
		m.eSet(EmfPackage.MODEL__FEATURES, fList);
		cList.add(c);
		m.eSet(EmfPackage.MODEL__CLUSTERS, cList);
		
		try{
			m.eSet(8, "value");
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertTrue(m.eIsSet(EmfPackage.MODEL__NAME));
		assertTrue(m.eIsSet(EmfPackage.MODEL__AVAILABLE_DB_TYPES));
		assertTrue(m.eIsSet(EmfPackage.MODEL__CLUSTERS));
		assertTrue(m.eIsSet(EmfPackage.MODEL__INTERVAL));
		assertTrue(m.eIsSet(EmfPackage.MODEL__FEATURES));
		assertTrue(m.eIsSet(EmfPackage.MODEL__NOTIFICATIONS));
		assertTrue(m.eIsSet(EmfPackage.MODEL__SERVER_IP));
		
		assertEquals(m.eGet(EmfPackage.MODEL__NAME, true, true), "name");
		assertEquals(m.eGet(EmfPackage.MODEL__SERVER_IP, true, true), "127.0.0.1");
		assertEquals(m.eGet(EmfPackage.MODEL__INTERVAL, true, true), 60);
		assertEquals(((Collection<? extends Element>)m.eGet(EmfPackage.MODEL__AVAILABLE_DB_TYPES, true, true)).size(), 1);
		assertEquals(((Collection<? extends KeyValue>)m.eGet(EmfPackage.MODEL__CLUSTERS, true, true)).size(), 1);
		assertEquals(((Collection<? extends KeyValue>)m.eGet(EmfPackage.MODEL__FEATURES, true, true)).size(), 1);
		assertEquals(((Collection<? extends KeyValue>)m.eGet(EmfPackage.MODEL__NOTIFICATIONS, true, true)).size(), 1);
		
		try{
			m.eGet(8, true, true);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		m.eUnset(EmfPackage.MODEL__NAME);
		m.eUnset(EmfPackage.MODEL__AVAILABLE_DB_TYPES);
		m.eUnset(EmfPackage.MODEL__CLUSTERS);
		m.eUnset(EmfPackage.MODEL__FEATURES);
		m.eUnset(EmfPackage.MODEL__INTERVAL);
		m.eUnset(EmfPackage.MODEL__NOTIFICATIONS);
		m.eUnset(EmfPackage.MODEL__SERVER_IP);
		
		
		try{
			m.eUnset(8);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertNull(m.eGet(EmfPackage.MODEL__NAME, true, true));
		assertNull(m.eGet(EmfPackage.MODEL__SERVER_IP, true, true));
		assertEquals(m.eGet(EmfPackage.MODEL__INTERVAL, true, true), 30);
		assertEquals(((Collection<? extends Element>)m.eGet(EmfPackage.MODEL__AVAILABLE_DB_TYPES, true, true)).size(), 0);
		assertEquals(((Collection<? extends KeyValue>)m.eGet(EmfPackage.MODEL__CLUSTERS, true, true)).size(), 0);
		assertEquals(((Collection<? extends KeyValue>)m.eGet(EmfPackage.MODEL__FEATURES, true, true)).size(), 0);
		assertEquals(((Collection<? extends KeyValue>)m.eGet(EmfPackage.MODEL__NOTIFICATIONS, true, true)).size(), 0);
		assertFalse(m.eIsSet(EmfPackage.MODEL__AVAILABLE_DB_TYPES));
		assertFalse(m.eIsSet(EmfPackage.MODEL__CLUSTERS));
		assertFalse(m.eIsSet(EmfPackage.MODEL__FEATURES));
		assertFalse(m.eIsSet(EmfPackage.MODEL__NOTIFICATIONS));
				
		System.out.println(m.toString());
	}

} //ModelTest
