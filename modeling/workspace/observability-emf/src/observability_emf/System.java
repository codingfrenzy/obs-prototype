/**
 */
package observability_emf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link observability_emf.System#getHasModel <em>Has Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see observability_emf.Observability_emfPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends EObject {
	/**
	 * Returns the value of the '<em><b>Has Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Model</em>' containment reference.
	 * @see #setHasModel(Model)
	 * @see observability_emf.Observability_emfPackage#getSystem_HasModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Model getHasModel();

	/**
	 * Sets the value of the '{@link observability_emf.System#getHasModel <em>Has Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Model</em>' containment reference.
	 * @see #getHasModel()
	 * @generated
	 */
	void setHasModel(Model value);

} // System
