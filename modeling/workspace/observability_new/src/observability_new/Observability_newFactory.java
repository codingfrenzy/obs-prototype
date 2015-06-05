/**
 */
package observability_new;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see observability_new.Observability_newPackage
 * @generated
 */
public interface Observability_newFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Observability_newFactory eINSTANCE = observability_new.impl.Observability_newFactoryImpl.init();

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
	 * Returns a new object of class '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element</em>'.
	 * @generated
	 */
	Element createElement();

	/**
	 * Returns a new object of class '<em>Key Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Key Value</em>'.
	 * @generated
	 */
	KeyValue createKeyValue();

	/**
	 * Returns a new object of class '<em>Node Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Machine</em>'.
	 * @generated
	 */
	NodeMachine createNodeMachine();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	Model createModel();

	/**
	 * Returns a new object of class '<em>Base Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Metric</em>'.
	 * @generated
	 */
	BaseMetric createBaseMetric();

	/**
	 * Returns a new object of class '<em>Derived Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Derived Metric</em>'.
	 * @generated
	 */
	DerivedMetric createDerivedMetric();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Observability_newPackage getObservability_newPackage();

} //Observability_newFactory
