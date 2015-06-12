/**
 */
package observability_new;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link observability_new.Element#getHasElements <em>Has Elements</em>}</li>
 *   <li>{@link observability_new.Element#getHasKeyValues <em>Has Key Values</em>}</li>
 *   <li>{@link observability_new.Element#getName <em>Name</em>}</li>
 *   <li>{@link observability_new.Element#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see observability_new.Observability_newPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Has Elements</b></em>' containment reference list.
	 * The list contents are of type {@link observability_new.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Elements</em>' containment reference list.
	 * @see observability_new.Observability_newPackage#getElement_HasElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getHasElements();

	/**
	 * Returns the value of the '<em><b>Has Key Values</b></em>' containment reference list.
	 * The list contents are of type {@link observability_new.KeyValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Key Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Key Values</em>' containment reference list.
	 * @see observability_new.Observability_newPackage#getElement_HasKeyValues()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<KeyValue> getHasKeyValues();

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
	 * @see observability_new.Observability_newPackage#getElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link observability_new.Element#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see observability_new.Observability_newPackage#getElement_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link observability_new.Element#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // Element
