/**
 */
package observability_emf;

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
 *   <li>{@link observability_emf.DatabaseCluster#getMachines <em>Machines</em>}</li>
 *   <li>{@link observability_emf.DatabaseCluster#getDbType <em>Db Type</em>}</li>
 *   <li>{@link observability_emf.DatabaseCluster#getCollectedMetrics <em>Collected Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @see observability_emf.Observability_emfPackage#getDatabaseCluster()
 * @model
 * @generated
 */
public interface DatabaseCluster extends EObject {
	/**
	 * Returns the value of the '<em><b>Machines</b></em>' containment reference list.
	 * The list contents are of type {@link observability_emf.NodeMachine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machines</em>' containment reference list.
	 * @see observability_emf.Observability_emfPackage#getDatabaseCluster_Machines()
	 * @model containment="true"
	 * @generated
	 */
	EList<NodeMachine> getMachines();

	/**
	 * Returns the value of the '<em><b>Db Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Db Type</em>' containment reference.
	 * @see #setDbType(DbType)
	 * @see observability_emf.Observability_emfPackage#getDatabaseCluster_DbType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DbType getDbType();

	/**
	 * Sets the value of the '{@link observability_emf.DatabaseCluster#getDbType <em>Db Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db Type</em>' containment reference.
	 * @see #getDbType()
	 * @generated
	 */
	void setDbType(DbType value);

	/**
	 * Returns the value of the '<em><b>Collected Metrics</b></em>' reference list.
	 * The list contents are of type {@link observability_emf.Metric}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collected Metrics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collected Metrics</em>' reference list.
	 * @see observability_emf.Observability_emfPackage#getDatabaseCluster_CollectedMetrics()
	 * @model
	 * @generated
	 */
	EList<Metric> getCollectedMetrics();

} // DatabaseCluster
