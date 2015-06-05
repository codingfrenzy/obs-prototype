/**
 */
package observability_new;

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
 *   <li>{@link observability_new.DbType#getName <em>Name</em>}</li>
 *   <li>{@link observability_new.DbType#getProbeLocation <em>Probe Location</em>}</li>
 *   <li>{@link observability_new.DbType#getCollectionFrequency <em>Collection Frequency</em>}</li>
 *   <li>{@link observability_new.DbType#getAvailableMetrics <em>Available Metrics</em>}</li>
 *   <li>{@link observability_new.DbType#getHasParentElement <em>Has Parent Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see observability_new.Observability_newPackage#getDbType()
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
	 * @see observability_new.Observability_newPackage#getDbType_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link observability_new.DbType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Probe Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probe Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probe Location</em>' attribute.
	 * @see #setProbeLocation(String)
	 * @see observability_new.Observability_newPackage#getDbType_ProbeLocation()
	 * @model
	 * @generated
	 */
	String getProbeLocation();

	/**
	 * Sets the value of the '{@link observability_new.DbType#getProbeLocation <em>Probe Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probe Location</em>' attribute.
	 * @see #getProbeLocation()
	 * @generated
	 */
	void setProbeLocation(String value);

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
	 * @see observability_new.Observability_newPackage#getDbType_CollectionFrequency()
	 * @model default="0"
	 * @generated
	 */
	int getCollectionFrequency();

	/**
	 * Sets the value of the '{@link observability_new.DbType#getCollectionFrequency <em>Collection Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Frequency</em>' attribute.
	 * @see #getCollectionFrequency()
	 * @generated
	 */
	void setCollectionFrequency(int value);

	/**
	 * Returns the value of the '<em><b>Available Metrics</b></em>' containment reference list.
	 * The list contents are of type {@link observability_new.Metric}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Metrics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Metrics</em>' containment reference list.
	 * @see observability_new.Observability_newPackage#getDbType_AvailableMetrics()
	 * @model containment="true"
	 * @generated
	 */
	EList<Metric> getAvailableMetrics();

	/**
	 * Returns the value of the '<em><b>Has Parent Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Parent Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Parent Element</em>' reference.
	 * @see #setHasParentElement(Element)
	 * @see observability_new.Observability_newPackage#getDbType_HasParentElement()
	 * @model required="true"
	 * @generated
	 */
	Element getHasParentElement();

	/**
	 * Sets the value of the '{@link observability_new.DbType#getHasParentElement <em>Has Parent Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Parent Element</em>' reference.
	 * @see #getHasParentElement()
	 * @generated
	 */
	void setHasParentElement(Element value);

} // DbType
