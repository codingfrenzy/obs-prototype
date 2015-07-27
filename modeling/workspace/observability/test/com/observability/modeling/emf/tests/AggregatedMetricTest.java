/**
 */
package com.observability.modeling.emf.tests;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;

import com.observability.modeling.emf.AggregatedMetric;
import com.observability.modeling.emf.DatabaseCluster;
import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfFactory;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.KeyValue;
import com.observability.modeling.emf.Metric;
import com.observability.modeling.emf.impl.AggregatedMetricImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Aggregated Metric</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AggregatedMetricTest extends MetricTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	public static void main(String[] args) {
//		TestRunner.run(AggregatedMetricTest.class);
//	}

	/**
	 * Constructs a new Aggregated Metric test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatedMetricTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Aggregated Metric test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AggregatedMetric getFixture() {
		return (AggregatedMetric)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		EClass eClass = (EClass)EmfPackage.eINSTANCE.getEClassifier("AggregatedMetric");
		setFixture((Metric)EmfFactory.eINSTANCE.create(eClass));
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
	
	
	public void testGetName(){
		 System.out.println(getFixture().getName());
		
	}
	
	public void testAggregatedMetric() throws Exception {
		AggregatedMetricImpl am = (AggregatedMetricImpl) getFixture();
		
		Throwable e = null;
		Element el = EmfFactory.eINSTANCE.createElement();
		KeyValue kv = EmfFactory.eINSTANCE.createKeyValue();
		ArrayList<Element> list = new ArrayList<Element>();
		ArrayList<KeyValue> kvList = new ArrayList<KeyValue>();
		
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__NAME));
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__TYPE));
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__DESCRIPTION));
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__KEY_VALUES));
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__ELEMENTS));
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_AVG));
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_MAX));
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_MIN));
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_NUM));
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_STDDEV));
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_SUM));
		
		try{
			am.eIsSet(12);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		am.eSet(EmfPackage.AGGREGATED_METRIC__NAME, "name");
		am.eSet(EmfPackage.AGGREGATED_METRIC__DESCRIPTION, "desc");
		am.eSet(EmfPackage.AGGREGATED_METRIC__TYPE, "type");
		
		list.add(el);
		am.eSet(EmfPackage.AGGREGATED_METRIC__ELEMENTS, list);
		kvList.add(kv);
		am.eSet(EmfPackage.AGGREGATED_METRIC__KEY_VALUES, kvList);
		am.eSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_AVG, true);
		am.eSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_MAX, true);
		am.eSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_MIN, true);
		am.eSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_NUM, true);
		am.eSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_STDDEV, true);
		am.eSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_SUM, true);
		
		try{
			am.eSet(12, "value");
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertTrue(am.eIsSet(EmfPackage.AGGREGATED_METRIC__NAME));
		assertTrue(am.eIsSet(EmfPackage.AGGREGATED_METRIC__DESCRIPTION));
		assertTrue(am.eIsSet(EmfPackage.AGGREGATED_METRIC__TYPE));
		assertTrue(am.eIsSet(EmfPackage.AGGREGATED_METRIC__KEY_VALUES));
		assertTrue(am.eIsSet(EmfPackage.AGGREGATED_METRIC__ELEMENTS));
		assertTrue(am.eIsSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_AVG));
		assertTrue(am.eIsSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_MAX));
		assertTrue(am.eIsSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_MIN));
		assertTrue(am.eIsSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_NUM));
		assertTrue(am.eIsSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_STDDEV));
		assertTrue(am.eIsSet(EmfPackage.AGGREGATED_METRIC__CALCULATE_SUM));
		
		
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__NAME, true, true), "name");
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__DESCRIPTION, true, true), "desc");
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__TYPE, true, true), "type");
		assertEquals(((Collection<? extends Element>)am.eGet(EmfPackage.AGGREGATED_METRIC__ELEMENTS, true, true)).size(), 1);
		assertEquals(((Collection<? extends KeyValue>)am.eGet(EmfPackage.AGGREGATED_METRIC__KEY_VALUES, true, true)).size(), 1);
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__CALCULATE_AVG,true,true), true);
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__CALCULATE_MAX,true,true), true);
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__CALCULATE_MIN,true,true), true);
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__CALCULATE_NUM,true,true), true);
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__CALCULATE_STDDEV,true,true), true);
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__CALCULATE_SUM,true,true), true);
		
		
		
		
		try{
			am.eGet(12, true, true);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		am.eUnset(EmfPackage.AGGREGATED_METRIC__NAME);
		am.eUnset(EmfPackage.AGGREGATED_METRIC__DESCRIPTION);
		am.eUnset(EmfPackage.AGGREGATED_METRIC__TYPE);
		am.eUnset(EmfPackage.AGGREGATED_METRIC__ELEMENTS);
		am.eUnset(EmfPackage.AGGREGATED_METRIC__KEY_VALUES);
		am.eUnset(EmfPackage.AGGREGATED_METRIC__CALCULATE_AVG);
		am.eUnset(EmfPackage.AGGREGATED_METRIC__CALCULATE_MAX);
		am.eUnset(EmfPackage.AGGREGATED_METRIC__CALCULATE_MIN);
		am.eUnset(EmfPackage.AGGREGATED_METRIC__CALCULATE_NUM);
		am.eUnset(EmfPackage.AGGREGATED_METRIC__CALCULATE_STDDEV);
		am.eUnset(EmfPackage.AGGREGATED_METRIC__CALCULATE_SUM);
		
		try{
			am.eUnset(12);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
		e = null;
		
		assertNull(am.eGet(EmfPackage.AGGREGATED_METRIC__NAME, true, true));
		assertNull(am.eGet(EmfPackage.AGGREGATED_METRIC__DESCRIPTION, true, true));
		assertNull(am.eGet(EmfPackage.AGGREGATED_METRIC__TYPE, true, true));
		assertEquals(((Collection<? extends Element>)am.eGet(EmfPackage.AGGREGATED_METRIC__ELEMENTS, true, true)).size(), 0);
		assertEquals(((Collection<? extends KeyValue>)am.eGet(EmfPackage.AGGREGATED_METRIC__KEY_VALUES, true, true)).size(), 0);
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__KEY_VALUES));
		assertFalse(am.eIsSet(EmfPackage.AGGREGATED_METRIC__ELEMENTS));
		
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__CALCULATE_AVG,true,true), false);
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__CALCULATE_MAX,true,true), false);
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__CALCULATE_MIN,true,true), false);
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__CALCULATE_NUM,true,true), false);
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__CALCULATE_STDDEV,true,true), false);
		assertEquals(am.eGet(EmfPackage.AGGREGATED_METRIC__CALCULATE_SUM,true,true), false);			
		
		System.out.println(am.toString());

	}

} //AggregatedMetricTest
