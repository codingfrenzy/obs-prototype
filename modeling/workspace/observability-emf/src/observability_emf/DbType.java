/**
 */
package observability_emf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Db Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link observability_emf.DbType#getName <em>Name</em>}</li>
 *   <li>{@link observability_emf.DbType#getProbeLocation <em>Probe Location</em>}</li>
 *   <li>{@link observability_emf.DbType#getCollectionFrequency <em>Collection Frequency</em>}</li>
 * </ul>
 * </p>
 *
 * @see observability_emf.Observability_emfPackage#getDbType()
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
	 * @see observability_emf.Observability_emfPackage#getDbType_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link observability_emf.DbType#getName <em>Name</em>}' attribute.
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
	 * @see observability_emf.Observability_emfPackage#getDbType_ProbeLocation()
	 * @model
	 * @generated
	 */
	String getProbeLocation();

	/**
	 * Sets the value of the '{@link observability_emf.DbType#getProbeLocation <em>Probe Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probe Location</em>' attribute.
	 * @see #getProbeLocation()
	 * @generated
	 */
	void setProbeLocation(String value);

	/**
	 * Returns the value of the '<em><b>Collection Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Frequency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Frequency</em>' attribute.
	 * @see #setCollectionFrequency(int)
	 * @see observability_emf.Observability_emfPackage#getDbType_CollectionFrequency()
	 * @model
	 * @generated
	 */
	int getCollectionFrequency();

	/**
	 * Sets the value of the '{@link observability_emf.DbType#getCollectionFrequency <em>Collection Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Frequency</em>' attribute.
	 * @see #getCollectionFrequency()
	 * @generated
	 */
	void setCollectionFrequency(int value);

} // DbType
