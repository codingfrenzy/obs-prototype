/**
 */
package observability_emf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link observability_emf.BaseMetric#getDatabaseCluster <em>Database Cluster</em>}</li>
 * </ul>
 * </p>
 *
 * @see observability_emf.Observability_emfPackage#getBaseMetric()
 * @model
 * @generated
 */
public interface BaseMetric extends Metric {
	/**
	 * Returns the value of the '<em><b>Database Cluster</b></em>' reference list.
	 * The list contents are of type {@link observability_emf.DatabaseCluster}.
	 * It is bidirectional and its opposite is '{@link observability_emf.DatabaseCluster#getCollectedBaseMetric <em>Collected Base Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database Cluster</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database Cluster</em>' reference list.
	 * @see observability_emf.Observability_emfPackage#getBaseMetric_DatabaseCluster()
	 * @see observability_emf.DatabaseCluster#getCollectedBaseMetric
	 * @model opposite="collectedBaseMetric"
	 * @generated
	 */
	EList<DatabaseCluster> getDatabaseCluster();

} // BaseMetric
