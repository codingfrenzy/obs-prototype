/**
 */
package com.observability.modeling.emf.tests;

import java.util.ArrayList;
import java.util.Collection;

import com.observability.modeling.emf.DatabaseCluster;
import com.observability.modeling.emf.DbType;
import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfFactory;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.KeyValue;
import com.observability.modeling.emf.Metric;
import com.observability.modeling.emf.NodeMachine;
import com.observability.modeling.emf.Notification;
import com.observability.modeling.emf.impl.DatabaseClusterImpl;
import com.observability.modeling.emf.impl.DbTypeImpl;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Database Cluster</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatabaseClusterTest extends TestCase {

	/**
	 * The fixture for this Database Cluster test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseCluster fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DatabaseClusterTest.class);
	}

	/**
	 * Constructs a new Database Cluster test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseClusterTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Database Cluster test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(DatabaseCluster fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Database Cluster test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseCluster getFixture() {
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
		setFixture(EmfFactory.eINSTANCE.createDatabaseCluster());
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
	
	public void testDatabaseCluster() throws Exception{
		DatabaseClusterImpl dc = (DatabaseClusterImpl) getFixture();
		
		Throwable e = null;
		Metric m = EmfFactory.eINSTANCE.createBaseMetric();
		DbType db = EmfFactory.eINSTANCE.createDbType();
		NodeMachine n = EmfFactory.eINSTANCE.createNodeMachine();
		Notification not = EmfFactory.eINSTANCE.createNotification();
		
		ArrayList<Metric> list = new ArrayList<Metric>();
		ArrayList<NodeMachine> mlist = new ArrayList<NodeMachine>();
		ArrayList<Notification> notlist = new ArrayList<Notification>();
		
		assertFalse(dc.eIsSet(EmfPackage.DATABASE_CLUSTER__NAME));
		assertFalse(dc.eIsSet(EmfPackage.DATABASE_CLUSTER__NO_OF_MACHINES));
		assertFalse(dc.eIsSet(EmfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE));
		assertFalse(dc.eIsSet(EmfPackage.DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS));
		assertFalse(dc.eIsSet(EmfPackage.DATABASE_CLUSTER__MACHINES));
		assertFalse(dc.eIsSet(EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS));
		
		try{
			dc.eIsSet(8);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		dc.eSet(EmfPackage.DATABASE_CLUSTER__NAME, "name");
		//dc.eSet(EmfPackage.DATABASE_CLUSTER__NO_OF_MACHINES, 30);
		list.add(m);
		dc.eSet(EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS, list);
		mlist.add(n);
		dc.eSet(EmfPackage.DATABASE_CLUSTER__MACHINES, mlist);
		dc.eSet(EmfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE, db);
		notlist.add(not);
		dc.eSet(EmfPackage.DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS, notlist);
		
		try{
			dc.eSet(8, "value");
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertTrue(dc.eIsSet(EmfPackage.DATABASE_CLUSTER__NAME));
		//assertTrue(dc.eIsSet(EmfPackage.DATABASE_CLUSTER__NO_OF_MACHINES));
		assertTrue(dc.eIsSet(EmfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE));
		assertTrue(dc.eIsSet(EmfPackage.DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS));
		assertTrue(dc.eIsSet(EmfPackage.DATABASE_CLUSTER__MACHINES));
		assertTrue(dc.eIsSet(EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS));
		
		assertEquals(dc.eGet(EmfPackage.DATABASE_CLUSTER__NAME, true, true), "name");
		//assertEquals(dc.eGet(EmfPackage.DATABASE_CLUSTER__NO_OF_MACHINES, true, true), 0);
		assertEquals(dc.eGet(EmfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE, true, true), db);
		assertEquals(((Collection<? extends KeyValue>)dc.eGet(EmfPackage.DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS, true, true)).size(), 1);
		assertEquals(((Collection<? extends KeyValue>)dc.eGet(EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS, true, true)).size(), 1);
		assertEquals(((Collection<? extends KeyValue>)dc.eGet(EmfPackage.DATABASE_CLUSTER__MACHINES, true, true)).size(), 1);
		
		try{
			dc.eGet(8, true, true);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		dc.eUnset(EmfPackage.DATABASE_CLUSTER__NAME);
		dc.eUnset(EmfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE);
		dc.eUnset(EmfPackage.DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS);
		dc.eUnset(EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS);
		dc.eUnset(EmfPackage.DATABASE_CLUSTER__MACHINES);
		dc.eUnset(EmfPackage.DATABASE_CLUSTER__NO_OF_MACHINES);
		
		try{
			dc.eUnset(8);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertNull(dc.eGet(EmfPackage.DATABASE_CLUSTER__NAME, true, true));
		assertEquals(dc.eGet(EmfPackage.DATABASE_CLUSTER__NO_OF_MACHINES, true, true), 0);
		assertNull(dc.eGet(EmfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE, true, true));
		assertEquals(((Collection<? extends KeyValue>)dc.eGet(EmfPackage.DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS, true, true)).size(), 0);
		assertEquals(((Collection<? extends KeyValue>)dc.eGet(EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS, true, true)).size(), 0);
		assertEquals(((Collection<? extends KeyValue>)dc.eGet(EmfPackage.DATABASE_CLUSTER__MACHINES, true, true)).size(), 0);
		
		System.out.println(dc.toString());
		
	}

} //DatabaseClusterTest
