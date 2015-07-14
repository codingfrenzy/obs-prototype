/**
 */
package com.observability.modeling.emf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.observability.modeling.emf.Model#getInterval <em>Interval</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Model#getClusters <em>Clusters</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Model#getAvailableDbTypes <em>Available Db Types</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Model#getServerIP <em>Server IP</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Model#getName <em>Name</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Model#getNotifications <em>Notifications</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Model#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.observability.modeling.emf.EmfPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Interval</b></em>' attribute.
	 * The default value is <code>"30"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interval</em>' attribute.
	 * @see #setInterval(int)
	 * @see com.observability.modeling.emf.EmfPackage#getModel_Interval()
	 * @model default="30"
	 * @generated
	 */
	int getInterval();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Model#getInterval <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interval</em>' attribute.
	 * @see #getInterval()
	 * @generated
	 */
	void setInterval(int value);

	/**
	 * Returns the value of the '<em><b>Clusters</b></em>' containment reference list.
	 * The list contents are of type {@link com.observability.modeling.emf.DatabaseCluster}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clusters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clusters</em>' containment reference list.
	 * @see com.observability.modeling.emf.EmfPackage#getModel_Clusters()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<DatabaseCluster> getClusters();

	/**
	 * Returns the value of the '<em><b>Available Db Types</b></em>' containment reference list.
	 * The list contents are of type {@link com.observability.modeling.emf.DbType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Db Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Db Types</em>' containment reference list.
	 * @see com.observability.modeling.emf.EmfPackage#getModel_AvailableDbTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DbType> getAvailableDbTypes();

	/**
	 * Returns the value of the '<em><b>Server IP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server IP</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server IP</em>' attribute.
	 * @see #setServerIP(String)
	 * @see com.observability.modeling.emf.EmfPackage#getModel_ServerIP()
	 * @model required="true"
	 * @generated
	 */
	String getServerIP();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Model#getServerIP <em>Server IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server IP</em>' attribute.
	 * @see #getServerIP()
	 * @generated
	 */
	void setServerIP(String value);

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
	 * @see com.observability.modeling.emf.EmfPackage#getModel_Name()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Model#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Notifications</b></em>' containment reference list.
	 * The list contents are of type {@link com.observability.modeling.emf.Notification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notifications</em>' containment reference list.
	 * @see com.observability.modeling.emf.EmfPackage#getModel_Notifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<Notification> getNotifications();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link com.observability.modeling.emf.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see com.observability.modeling.emf.EmfPackage#getModel_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

} // Model
