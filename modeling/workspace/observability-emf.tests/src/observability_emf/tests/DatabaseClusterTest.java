/**
 */
package observability_emf.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import observability_emf.DatabaseCluster;
import observability_emf.Observability_emfFactory;

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
		setFixture(Observability_emfFactory.eINSTANCE.createDatabaseCluster());
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

} //DatabaseClusterTest
