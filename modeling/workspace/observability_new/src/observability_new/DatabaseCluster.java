/**
 */
package observability_new;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database Cluster</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link observability_new.DatabaseCluster#getMachines <em>Machines</em>}</li>
 *   <li>{@link observability_new.DatabaseCluster#getCollectedBaseMetric <em>Collected Base Metric</em>}</li>
 *   <li>{@link observability_new.DatabaseCluster#getAssociatedDbType <em>Associated Db Type</em>}</li>
 *   <li>{@link observability_new.DatabaseCluster#getName <em>Name</em>}</li>
 *   <li>{@link observability_new.DatabaseCluster#getNoOfMachines <em>No Of Machines</em>}</li>
 *   <li>{@link observability_new.DatabaseCluster#getCollectedDerivedMetrics <em>Collected Derived Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @see observability_new.Observability_newPackage#getDatabaseCluster()
 * @model
 * @generated
 */
public interface DatabaseCluster extends EObject {
	/**
	 * Returns the value of the '<em><b>Machines</b></em>' containment reference list.
	 * The list contents are of type {@link observability_new.NodeMachine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machines</em>' containment reference list.
	 * @see observability_new.Observability_newPackage#getDatabaseCluster_Machines()
	 * @model containment="true"
	 * @generated
	 */
	EList<NodeMachine> getMachines();

	/**
	 * Returns the value of the '<em><b>Collected Base Metric</b></em>' reference list.
	 * The list contents are of type {@link observability_new.BaseMetric}.
	 * It is bidirectional and its opposite is '{@link observability_new.BaseMetric#getDatabaseCluster <em>Database Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collected Base Metric</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collected Base Metric</em>' reference list.
	 * @see observability_new.Observability_newPackage#getDatabaseCluster_CollectedBaseMetric()
	 * @see observability_new.BaseMetric#getDatabaseCluster
	 * @model opposite="databaseCluster"
	 * @generated
	 */
	EList<BaseMetric> getCollectedBaseMetric();

	/**
	 * Returns the value of the '<em><b>Associated Db Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Db Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Db Type</em>' reference.
	 * @see #setAssociatedDbType(DbType)
	 * @see observability_new.Observability_newPackage#getDatabaseCluster_AssociatedDbType()
	 * @model required="true"
	 * @generated
	 */
	DbType getAssociatedDbType();

	/**
	 * Sets the value of the '{@link observability_new.DatabaseCluster#getAssociatedDbType <em>Associated Db Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Db Type</em>' reference.
	 * @see #getAssociatedDbType()
	 * @generated
	 */
	void setAssociatedDbType(DbType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see observability_new.Observability_newPackage#getDatabaseCluster_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link observability_new.DatabaseCluster#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>No Of Machines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Of Machines</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Of Machines</em>' attribute.
	 * @see #setNoOfMachines(int)
	 * @see observability_new.Observability_newPackage#getDatabaseCluster_NoOfMachines()
	 * @model
	 * @generated
	 */
	int getNoOfMachines();

	/**
	 * Sets the value of the '{@link observability_new.DatabaseCluster#getNoOfMachines <em>No Of Machines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Of Machines</em>' attribute.
	 * @see #getNoOfMachines()
	 * @generated
	 */
	void setNoOfMachines(int value);

	/**
	 * Returns the value of the '<em><b>Collected Derived Metrics</b></em>' reference list.
	 * The list contents are of type {@link observability_new.DerivedMetric}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collected Derived Metrics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collected Derived Metrics</em>' reference list.
	 * @see observability_new.Observability_newPackage#getDatabaseCluster_CollectedDerivedMetrics()
	 * @model
	 * @generated
	 */
	EList<DerivedMetric> getCollectedDerivedMetrics();

} // DatabaseCluster
