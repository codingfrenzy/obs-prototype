/**
 */
package observability_new.tests;

import junit.textui.TestRunner;

import observability_new.BaseMetric;
import observability_new.Observability_newFactory;

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
		setFixture(Observability_newFactory.eINSTANCE.createBaseMetric());
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

} //BaseMetricTest
