/**
 */
package observability_new;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derived Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link observability_new.DerivedMetric#getHasParentElement <em>Has Parent Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see observability_new.Observability_newPackage#getDerivedMetric()
 * @model
 * @generated
 */
public interface DerivedMetric extends Metric {
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
	 * @see observability_new.Observability_newPackage#getDerivedMetric_HasParentElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Element getHasParentElement();

	/**
	 * Sets the value of the '{@link observability_new.DerivedMetric#getHasParentElement <em>Has Parent Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Parent Element</em>' containment reference.
	 * @see #getHasParentElement()
	 * @generated
	 */
	void setHasParentElement(Element value);

} // DerivedMetric
