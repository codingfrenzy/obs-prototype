/**
 */
package observability_new.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import observability_new.NodeMachine;
import observability_new.Observability_newFactory;

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
		setFixture(Observability_newFactory.eINSTANCE.createNodeMachine());
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

} //NodeMachineTest
