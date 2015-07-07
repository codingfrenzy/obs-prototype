/**
 */
package com.observability.modeling.emf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.observability.modeling.emf.BaseMetric#getDatabaseCluster <em>Database Cluster</em>}</li>
 *   <li>{@link com.observability.modeling.emf.BaseMetric#getHasParentElement <em>Has Parent Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.observability.modeling.emf.EmfPackage#getBaseMetric()
 * @model
 * @generated
 */
public interface BaseMetric extends Metric {
	/**
	 * Returns the value of the '<em><b>Database Cluster</b></em>' reference list.
	 * The list contents are of type {@link com.observability.modeling.emf.DatabaseCluster}.
	 * It is bidirectional and its opposite is '{@link com.observability.modeling.emf.DatabaseCluster#getCollectedBaseMetric <em>Collected Base Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database Cluster</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database Cluster</em>' reference list.
	 * @see com.observability.modeling.emf.EmfPackage#getBaseMetric_DatabaseCluster()
	 * @see com.observability.modeling.emf.DatabaseCluster#getCollectedBaseMetric
	 * @model opposite="collectedBaseMetric"
	 * @generated
	 */
	EList<DatabaseCluster> getDatabaseCluster();

	/**
	 * Returns the value of the '<em><b>Has Parent Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Parent Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Parent Element</em>' containment reference.
	 * @see #setHasParentElement(Element)
	 * @see com.observability.modeling.emf.EmfPackage#getBaseMetric_HasParentElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Element getHasParentElement();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.BaseMetric#getHasParentElement <em>Has Parent Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Parent Element</em>' containment reference.
	 * @see #getHasParentElement()
	 * @generated
	 */
	void setHasParentElement(Element value);

} // BaseMetric
