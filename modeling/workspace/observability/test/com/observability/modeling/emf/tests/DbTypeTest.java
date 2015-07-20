/**
 */
package com.observability.modeling.emf.tests;

import java.util.ArrayList;
import java.util.Collection;

import com.observability.modeling.emf.DbType;
import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfFactory;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.KeyValue;
import com.observability.modeling.emf.Metric;
import com.observability.modeling.emf.impl.DbTypeImpl;
import com.observability.modeling.emf.impl.ElementImpl;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Db Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DbTypeTest extends TestCase {

	/**
	 * The fixture for this Db Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DbType fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DbTypeTest.class);
	}

	/**
	 * Constructs a new Db Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DbTypeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Db Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(DbType fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Db Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DbType getFixture() {
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
		setFixture(EmfFactory.eINSTANCE.createDbType());
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
	
	public void testDbType() throws Exception {
		DbTypeImpl db = (DbTypeImpl) getFixture();
		Throwable e = null;
		Element el = EmfFactory.eINSTANCE.createElement();
		Metric m = EmfFactory.eINSTANCE.createBaseMetric();
		
		ArrayList<Metric> list = new ArrayList<Metric>();
		ArrayList<Element> elist = new ArrayList<Element>();
		
		assertFalse(db.eIsSet(EmfPackage.DB_TYPE__NAME));
		assertFalse(db.eIsSet(EmfPackage.DB_TYPE__COLLECTION_FREQUENCY));
		assertFalse(db.eIsSet(EmfPackage.DB_TYPE__AVAILABLE_METRICS));
		assertFalse(db.eIsSet(EmfPackage.DB_TYPE__ELEMENTS));
		
		try{
			db.eIsSet(7);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		db.eSet(EmfPackage.DB_TYPE__NAME, "name");
		db.eSet(EmfPackage.DB_TYPE__COLLECTION_FREQUENCY, 30);
		elist.add(el);
		db.eSet(EmfPackage.DB_TYPE__ELEMENTS, elist);
		list.add(m);
		db.eSet(EmfPackage.DB_TYPE__AVAILABLE_METRICS, list);
		
		
		try{
			db.eSet(5, "value");
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertTrue(db.eIsSet(EmfPackage.DB_TYPE__AVAILABLE_METRICS));
		assertTrue(db.eIsSet(EmfPackage.DB_TYPE__COLLECTION_FREQUENCY));
		assertTrue(db.eIsSet(EmfPackage.DB_TYPE__ELEMENTS));
		assertTrue(db.eIsSet(EmfPackage.DB_TYPE__NAME));
		
		assertEquals(db.eGet(EmfPackage.DB_TYPE__NAME, true, true), "name");
		assertEquals(db.eGet(EmfPackage.DB_TYPE__COLLECTION_FREQUENCY, true, true), 30);
		assertEquals(((Collection<? extends Element>)db.eGet(EmfPackage.DB_TYPE__ELEMENTS, true, true)).size(), 1);
		assertEquals(((Collection<? extends KeyValue>)db.eGet(EmfPackage.DB_TYPE__AVAILABLE_METRICS, true, true)).size(), 1);
		
		try{
			db.eGet(5, true, true);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		db.eUnset(EmfPackage.DB_TYPE__NAME);
		db.eUnset(EmfPackage.DB_TYPE__COLLECTION_FREQUENCY);
		db.eUnset(EmfPackage.DB_TYPE__ELEMENTS);
		db.eUnset(EmfPackage.DB_TYPE__AVAILABLE_METRICS);
		
		try{
			db.eUnset(5);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertNull(db.eGet(EmfPackage.DB_TYPE__NAME, true, true));
		assertEquals(db.eGet(EmfPackage.DB_TYPE__COLLECTION_FREQUENCY, true, true), 0);
		assertEquals(((Collection<? extends Element>)db.eGet(EmfPackage.DB_TYPE__ELEMENTS, true, true)).size(), 0);
		assertEquals(((Collection<? extends KeyValue>)db.eGet(EmfPackage.DB_TYPE__AVAILABLE_METRICS, true, true)).size(), 0);
		
		System.out.println(db.toString());
	}

} //DbTypeTest
