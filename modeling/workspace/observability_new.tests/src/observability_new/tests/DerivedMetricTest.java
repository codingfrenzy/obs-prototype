/**
 */
package observability_new.tests;

import junit.textui.TestRunner;

import observability_new.DerivedMetric;
import observability_new.Observability_newFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Derived Metric</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DerivedMetricTest extends MetricTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DerivedMetricTest.class);
	}

	/**
	 * Constructs a new Derived Metric test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerivedMetricTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Derived Metric test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DerivedMetric getFixture() {
		return (DerivedMetric)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(Observability_newFactory.eINSTANCE.createDerivedMetric());
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

} //DerivedMetricTest
