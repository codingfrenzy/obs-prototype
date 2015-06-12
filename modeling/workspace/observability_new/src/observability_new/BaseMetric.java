/**
 */
package observability_new;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link observability_new.BaseMetric#getDatabaseCluster <em>Database Cluster</em>}</li>
 *   <li>{@link observability_new.BaseMetric#getHasParentElement <em>Has Parent Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see observability_new.Observability_newPackage#getBaseMetric()
 * @model
 * @generated
 */
public interface BaseMetric extends Metric {
	/**
	 * Returns the value of the '<em><b>Database Cluster</b></em>' reference list.
	 * The list contents are of type {@link observability_new.DatabaseCluster}.
	 * It is bidirectional and its opposite is '{@link observability_new.DatabaseCluster#getCollectedBaseMetric <em>Collected Base Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database Cluster</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database Cluster</em>' reference list.
	 * @see observability_new.Observability_newPackage#getBaseMetric_DatabaseCluster()
	 * @see observability_new.DatabaseCluster#getCollectedBaseMetric
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
	 * @see observability_new.Observability_newPackage#getBaseMetric_HasParentElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Element getHasParentElement();

	/**
	 * Sets the value of the '{@link observability_new.BaseMetric#getHasParentElement <em>Has Parent Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Parent Element</em>' containment reference.
	 * @see #getHasParentElement()
	 * @generated
	 */
	void setHasParentElement(Element value);

} // BaseMetric
