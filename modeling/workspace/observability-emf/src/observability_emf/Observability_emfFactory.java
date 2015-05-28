/**
 */
package observability_emf;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see observability_emf.Observability_emfPackage
 * @generated
 */
public interface Observability_emfFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Observability_emfFactory eINSTANCE = observability_emf.impl.Observability_emfFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	Model createModel();

	/**
	 * Returns a new object of class '<em>Database Cluster</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Database Cluster</em>'.
	 * @generated
	 */
	DatabaseCluster createDatabaseCluster();

	/**
	 * Returns a new object of class '<em>Db Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Db Type</em>'.
	 * @generated
	 */
	DbType createDbType();

	/**
	 * Returns a new object of class '<em>Node Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Machine</em>'.
	 * @generated
	 */
	NodeMachine createNodeMachine();

	/**
	 * Returns a new object of class '<em>Derived Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Derived Metric</em>'.
	 * @generated
	 */
	DerivedMetric createDerivedMetric();

	/**
	 * Returns a new object of class '<em>Base Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Metric</em>'.
	 * @generated
	 */
	BaseMetric createBaseMetric();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	System createSystem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Observability_emfPackage getObservability_emfPackage();

} //Observability_emfFactory
