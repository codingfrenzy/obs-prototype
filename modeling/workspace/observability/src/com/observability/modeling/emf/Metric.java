/**
 */
package com.observability.modeling.emf;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.observability.modeling.emf.Metric#getName <em>Name</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Metric#getDescription <em>Description</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Metric#getKeyValues <em>Key Values</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Metric#getElements <em>Elements</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Metric#getDatabaseCluster <em>Database Cluster</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Metric#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.observability.modeling.emf.EmfPackage#getMetric()
 * @model abstract="true"
 * @generated
 */
public interface Metric extends EObject {
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
	 * @see com.observability.modeling.emf.EmfPackage#getMetric_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Metric#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.observability.modeling.emf.EmfPackage#getMetric_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Metric#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Key Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.observability.modeling.emf.KeyValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Values</em>' containment reference list.
	 * @see com.observability.modeling.emf.EmfPackage#getMetric_KeyValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<KeyValue> getKeyValues();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link com.observability.modeling.emf.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see com.observability.modeling.emf.EmfPackage#getMetric_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getElements();

	/**
	 * Returns the value of the '<em><b>Database Cluster</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.observability.modeling.emf.DatabaseCluster#getCollectedMetrics <em>Collected Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database Cluster</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database Cluster</em>' reference.
	 * @see #setDatabaseCluster(DatabaseCluster)
	 * @see com.observability.modeling.emf.EmfPackage#getMetric_DatabaseCluster()
	 * @see com.observability.modeling.emf.DatabaseCluster#getCollectedMetrics
	 * @model opposite="collectedMetrics"
	 * @generated
	 */
	DatabaseCluster getDatabaseCluster();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Metric#getDatabaseCluster <em>Database Cluster</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database Cluster</em>' reference.
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	void setDatabaseCluster(DatabaseCluster value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.observability.modeling.emf.EmfPackage#getMetric_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Metric#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // Metric
