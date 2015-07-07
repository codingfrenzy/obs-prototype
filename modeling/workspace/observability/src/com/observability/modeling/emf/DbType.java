/**
 */
package com.observability.modeling.emf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Db Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.observability.modeling.emf.DbType#getName <em>Name</em>}</li>
 *   <li>{@link com.observability.modeling.emf.DbType#getCollectionFrequency <em>Collection Frequency</em>}</li>
 *   <li>{@link com.observability.modeling.emf.DbType#getAvailableMetrics <em>Available Metrics</em>}</li>
 *   <li>{@link com.observability.modeling.emf.DbType#getHasParentElement <em>Has Parent Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.observability.modeling.emf.EmfPackage#getDbType()
 * @model
 * @generated
 */
public interface DbType extends EObject {
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
	 * @see com.observability.modeling.emf.EmfPackage#getDbType_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.DbType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Collection Frequency</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Frequency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Frequency</em>' attribute.
	 * @see #setCollectionFrequency(int)
	 * @see com.observability.modeling.emf.EmfPackage#getDbType_CollectionFrequency()
	 * @model default="0"
	 * @generated
	 */
	int getCollectionFrequency();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.DbType#getCollectionFrequency <em>Collection Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Frequency</em>' attribute.
	 * @see #getCollectionFrequency()
	 * @generated
	 */
	void setCollectionFrequency(int value);

	/**
	 * Returns the value of the '<em><b>Available Metrics</b></em>' containment reference list.
	 * The list contents are of type {@link com.observability.modeling.emf.Metric}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Metrics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Metrics</em>' containment reference list.
	 * @see com.observability.modeling.emf.EmfPackage#getDbType_AvailableMetrics()
	 * @model containment="true"
	 * @generated
	 */
	EList<Metric> getAvailableMetrics();

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
	 * @see com.observability.modeling.emf.EmfPackage#getDbType_HasParentElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Element getHasParentElement();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.DbType#getHasParentElement <em>Has Parent Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Parent Element</em>' containment reference.
	 * @see #getHasParentElement()
	 * @generated
	 */
	void setHasParentElement(Element value);

} // DbType
