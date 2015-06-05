/**
 */
package observability_new.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import observability_new.DbType;
import observability_new.Observability_newFactory;

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
		setFixture(Observability_newFactory.eINSTANCE.createDbType());
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

} //DbTypeTest
