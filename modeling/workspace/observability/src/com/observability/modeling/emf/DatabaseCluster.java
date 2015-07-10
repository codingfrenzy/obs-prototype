/**
 */
package com.observability.modeling.emf;

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
 *   <li>{@link com.observability.modeling.emf.DatabaseCluster#getMachines <em>Machines</em>}</li>
 *   <li>{@link com.observability.modeling.emf.DatabaseCluster#getCollectedMetrics <em>Collected Metrics</em>}</li>
 *   <li>{@link com.observability.modeling.emf.DatabaseCluster#getAssociatedDbType <em>Associated Db Type</em>}</li>
 *   <li>{@link com.observability.modeling.emf.DatabaseCluster#getName <em>Name</em>}</li>
 *   <li>{@link com.observability.modeling.emf.DatabaseCluster#getNoOfMachines <em>No Of Machines</em>}</li>
 *   <li>{@link com.observability.modeling.emf.DatabaseCluster#getAssociatedNotifications <em>Associated Notifications</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.observability.modeling.emf.EmfPackage#getDatabaseCluster()
 * @model
 * @generated
 */
public interface DatabaseCluster extends EObject {
	/**
	 * Returns the value of the '<em><b>Machines</b></em>' containment reference list.
	 * The list contents are of type {@link com.observability.modeling.emf.NodeMachine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machines</em>' containment reference list.
	 * @see com.observability.modeling.emf.EmfPackage#getDatabaseCluster_Machines()
	 * @model containment="true"
	 * @generated
	 */
	EList<NodeMachine> getMachines();

	/**
	 * Returns the value of the '<em><b>Collected Metrics</b></em>' reference list.
	 * The list contents are of type {@link com.observability.modeling.emf.Metric}.
	 * It is bidirectional and its opposite is '{@link com.observability.modeling.emf.Metric#getDatabaseCluster <em>Database Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collected Metrics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collected Metrics</em>' reference list.
	 * @see com.observability.modeling.emf.EmfPackage#getDatabaseCluster_CollectedMetrics()
	 * @see com.observability.modeling.emf.Metric#getDatabaseCluster
	 * @model opposite="databaseCluster"
	 * @generated
	 */
	EList<Metric> getCollectedMetrics();

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
	 * @see com.observability.modeling.emf.EmfPackage#getDatabaseCluster_AssociatedDbType()
	 * @model required="true"
	 * @generated
	 */
	DbType getAssociatedDbType();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.DatabaseCluster#getAssociatedDbType <em>Associated Db Type</em>}' reference.
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
	 * @see com.observability.modeling.emf.EmfPackage#getDatabaseCluster_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.DatabaseCluster#getName <em>Name</em>}' attribute.
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
	 * @see com.observability.modeling.emf.EmfPackage#getDatabaseCluster_NoOfMachines()
	 * @model
	 * @generated
	 */
	int getNoOfMachines();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.DatabaseCluster#getNoOfMachines <em>No Of Machines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Of Machines</em>' attribute.
	 * @see #getNoOfMachines()
	 * @generated
	 */
	void setNoOfMachines(int value);

	/**
	 * Returns the value of the '<em><b>Associated Notifications</b></em>' reference list.
	 * The list contents are of type {@link com.observability.modeling.emf.Notification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Notifications</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Notifications</em>' reference list.
	 * @see com.observability.modeling.emf.EmfPackage#getDatabaseCluster_AssociatedNotifications()
	 * @model
	 * @generated
	 */
	EList<Notification> getAssociatedNotifications();

} // DatabaseCluster
