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
 *   <li>{@link com.observability.modeling.emf.Model#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Model#getClusters <em>Clusters</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Model#getAvailableDbTypes <em>Available Db Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.observability.modeling.emf.EmfPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frequency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frequency</em>' attribute.
	 * @see #setFrequency(int)
	 * @see com.observability.modeling.emf.EmfPackage#getModel_Frequency()
	 * @model
	 * @generated
	 */
	int getFrequency();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Model#getFrequency <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frequency</em>' attribute.
	 * @see #getFrequency()
	 * @generated
	 */
	void setFrequency(int value);

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

} // Model
