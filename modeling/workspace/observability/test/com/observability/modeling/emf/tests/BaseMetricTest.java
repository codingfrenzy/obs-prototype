/**
 */
package com.observability.modeling.emf.tests;

import java.util.ArrayList;
import java.util.Collection;

import com.observability.modeling.emf.BaseMetric;
import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfFactory;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.KeyValue;
import com.observability.modeling.emf.impl.BaseMetricImpl;
import com.observability.modeling.emf.impl.ElementImpl;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Base Metric</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BaseMetricTest extends MetricTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(BaseMetricTest.class);
	}

	/**
	 * Constructs a new Base Metric test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseMetricTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Base Metric test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected BaseMetric getFixture() {
		return (BaseMetric)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmfFactory.eINSTANCE.createBaseMetric());
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
	
	public void testBaseMetric() throws Exception {
		BaseMetricImpl bm = (BaseMetricImpl) getFixture();
		
		Throwable e = null;
		Element el = EmfFactory.eINSTANCE.createElement();
		KeyValue kv = EmfFactory.eINSTANCE.createKeyValue();
		ArrayList<Element> list = new ArrayList<Element>();
		ArrayList<KeyValue> kvList = new ArrayList<KeyValue>();
		
		assertFalse(bm.eIsSet(EmfPackage.BASE_METRIC__NAME));
		assertFalse(bm.eIsSet(EmfPackage.BASE_METRIC__TYPE));
		assertFalse(bm.eIsSet(EmfPackage.BASE_METRIC__DESCRIPTION));
		assertFalse(bm.eIsSet(EmfPackage.BASE_METRIC__KEY_VALUES));
		assertFalse(bm.eIsSet(EmfPackage.BASE_METRIC__ELEMENTS));
		
		try{
			bm.eIsSet(6);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		bm.eSet(EmfPackage.BASE_METRIC__NAME, "name");
		bm.eSet(EmfPackage.BASE_METRIC__DESCRIPTION, "desc");
		bm.eSet(EmfPackage.BASE_METRIC__TYPE, "type");
		
		list.add(el);
		bm.eSet(EmfPackage.BASE_METRIC__ELEMENTS, list);
		kvList.add(kv);
		bm.eSet(EmfPackage.BASE_METRIC__KEY_VALUES, kvList);
		
		try{
			bm.eSet(6, "value");
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertTrue(bm.eIsSet(EmfPackage.BASE_METRIC__NAME));
		assertTrue(bm.eIsSet(EmfPackage.BASE_METRIC__DESCRIPTION));
		assertTrue(bm.eIsSet(EmfPackage.BASE_METRIC__TYPE));
		assertTrue(bm.eIsSet(EmfPackage.BASE_METRIC__KEY_VALUES));
		assertTrue(bm.eIsSet(EmfPackage.BASE_METRIC__ELEMENTS));
		
		assertEquals(bm.eGet(EmfPackage.BASE_METRIC__NAME, true, true), "name");
		assertEquals(bm.eGet(EmfPackage.BASE_METRIC__DESCRIPTION, true, true), "desc");
		assertEquals(bm.eGet(EmfPackage.BASE_METRIC__TYPE, true, true), "type");
		assertEquals(((Collection<? extends Element>)bm.eGet(EmfPackage.BASE_METRIC__ELEMENTS, true, true)).size(), 1);
		assertEquals(((Collection<? extends KeyValue>)bm.eGet(EmfPackage.BASE_METRIC__KEY_VALUES, true, true)).size(), 1);
		
		try{
			bm.eGet(6, true, true);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		bm.eUnset(EmfPackage.BASE_METRIC__NAME);
		bm.eUnset(EmfPackage.BASE_METRIC__DESCRIPTION);
		bm.eUnset(EmfPackage.BASE_METRIC__TYPE);
		bm.eUnset(EmfPackage.BASE_METRIC__ELEMENTS);
		bm.eUnset(EmfPackage.BASE_METRIC__KEY_VALUES);
		
		try{
			bm.eUnset(6);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertNull(bm.eGet(EmfPackage.BASE_METRIC__NAME, true, true));
		assertNull(bm.eGet(EmfPackage.BASE_METRIC__DESCRIPTION, true, true));
		assertNull(bm.eGet(EmfPackage.BASE_METRIC__TYPE, true, true));
		assertEquals(((Collection<? extends Element>)bm.eGet(EmfPackage.BASE_METRIC__ELEMENTS, true, true)).size(), 0);
		assertEquals(((Collection<? extends KeyValue>)bm.eGet(EmfPackage.BASE_METRIC__KEY_VALUES, true, true)).size(), 0);
		
		System.out.println(bm.toString());

	}
} //BaseMetricTest
