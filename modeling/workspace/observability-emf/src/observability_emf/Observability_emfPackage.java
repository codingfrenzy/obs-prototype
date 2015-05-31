/**
 */
package observability_emf;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see observability_emf.Observability_emfFactory
 * @model kind="package"
 * @generated
 */
public interface Observability_emfPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "observability_emf";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/observability_emf";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "observability_emf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Observability_emfPackage eINSTANCE = observability_emf.impl.Observability_emfPackageImpl.init();

	/**
	 * The meta object id for the '{@link observability_emf.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_emf.impl.ModelImpl
	 * @see observability_emf.impl.Observability_emfPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__FREQUENCY = 0;

	/**
	 * The feature id for the '<em><b>Clusters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CLUSTERS = 1;

	/**
	 * The feature id for the '<em><b>Available Metrics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__AVAILABLE_METRICS = 2;

	/**
	 * The feature id for the '<em><b>Available Db Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__AVAILABLE_DB_TYPES = 3;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link observability_emf.impl.DatabaseClusterImpl <em>Database Cluster</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_emf.impl.DatabaseClusterImpl
	 * @see observability_emf.impl.Observability_emfPackageImpl#getDatabaseCluster()
	 * @generated
	 */
	int DATABASE_CLUSTER = 1;

	/**
	 * The feature id for the '<em><b>Machines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CLUSTER__MACHINES = 0;

	/**
	 * The feature id for the '<em><b>Collected Base Metric</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CLUSTER__COLLECTED_BASE_METRIC = 1;

	/**
	 * The feature id for the '<em><b>Associated Db Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CLUSTER__ASSOCIATED_DB_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Database Cluster</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CLUSTER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Database Cluster</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CLUSTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link observability_emf.impl.NodeMachineImpl <em>Node Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_emf.impl.NodeMachineImpl
	 * @see observability_emf.impl.Observability_emfPackageImpl#getNodeMachine()
	 * @generated
	 */
	int NODE_MACHINE = 2;

	/**
	 * The feature id for the '<em><b>IP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MACHINE__IP = 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MACHINE__PORT = 1;

	/**
	 * The number of structural features of the '<em>Node Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MACHINE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Node Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MACHINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link observability_emf.impl.MetricImpl <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_emf.impl.MetricImpl
	 * @see observability_emf.impl.Observability_emfPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 3;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__UNIT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link observability_emf.impl.DerivedMetricImpl <em>Derived Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_emf.impl.DerivedMetricImpl
	 * @see observability_emf.impl.Observability_emfPackageImpl#getDerivedMetric()
	 * @generated
	 */
	int DERIVED_METRIC = 4;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_METRIC__UNIT = METRIC__UNIT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_METRIC__NAME = METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_METRIC__DESCRIPTION = METRIC__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Derived Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_METRIC_FEATURE_COUNT = METRIC_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Derived Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_METRIC_OPERATION_COUNT = METRIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link observability_emf.impl.BaseMetricImpl <em>Base Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_emf.impl.BaseMetricImpl
	 * @see observability_emf.impl.Observability_emfPackageImpl#getBaseMetric()
	 * @generated
	 */
	int BASE_METRIC = 5;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC__UNIT = METRIC__UNIT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC__NAME = METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC__DESCRIPTION = METRIC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Database Cluster</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC__DATABASE_CLUSTER = METRIC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Base Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_FEATURE_COUNT = METRIC_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Base Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_OPERATION_COUNT = METRIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link observability_emf.impl.DbTypeImpl <em>Db Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_emf.impl.DbTypeImpl
	 * @see observability_emf.impl.Observability_emfPackageImpl#getDbType()
	 * @generated
	 */
	int DB_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Probe Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE__PROBE_LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Collection Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE__COLLECTION_FREQUENCY = 2;

	/**
	 * The number of structural features of the '<em>Db Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Db Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link observability_emf.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see observability_emf.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link observability_emf.Model#getFrequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frequency</em>'.
	 * @see observability_emf.Model#getFrequency()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Frequency();

	/**
	 * Returns the meta object for the containment reference list '{@link observability_emf.Model#getClusters <em>Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clusters</em>'.
	 * @see observability_emf.Model#getClusters()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Clusters();

	/**
	 * Returns the meta object for the containment reference list '{@link observability_emf.Model#getAvailableMetrics <em>Available Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Metrics</em>'.
	 * @see observability_emf.Model#getAvailableMetrics()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AvailableMetrics();

	/**
	 * Returns the meta object for the containment reference list '{@link observability_emf.Model#getAvailableDbTypes <em>Available Db Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Db Types</em>'.
	 * @see observability_emf.Model#getAvailableDbTypes()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AvailableDbTypes();

	/**
	 * Returns the meta object for class '{@link observability_emf.DatabaseCluster <em>Database Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Cluster</em>'.
	 * @see observability_emf.DatabaseCluster
	 * @generated
	 */
	EClass getDatabaseCluster();

	/**
	 * Returns the meta object for the containment reference list '{@link observability_emf.DatabaseCluster#getMachines <em>Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machines</em>'.
	 * @see observability_emf.DatabaseCluster#getMachines()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EReference getDatabaseCluster_Machines();

	/**
	 * Returns the meta object for the reference list '{@link observability_emf.DatabaseCluster#getCollectedBaseMetric <em>Collected Base Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Collected Base Metric</em>'.
	 * @see observability_emf.DatabaseCluster#getCollectedBaseMetric()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EReference getDatabaseCluster_CollectedBaseMetric();

	/**
	 * Returns the meta object for the reference '{@link observability_emf.DatabaseCluster#getAssociatedDbType <em>Associated Db Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Db Type</em>'.
	 * @see observability_emf.DatabaseCluster#getAssociatedDbType()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EReference getDatabaseCluster_AssociatedDbType();

	/**
	 * Returns the meta object for class '{@link observability_emf.NodeMachine <em>Node Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Machine</em>'.
	 * @see observability_emf.NodeMachine
	 * @generated
	 */
	EClass getNodeMachine();

	/**
	 * Returns the meta object for the attribute '{@link observability_emf.NodeMachine#getIP <em>IP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IP</em>'.
	 * @see observability_emf.NodeMachine#getIP()
	 * @see #getNodeMachine()
	 * @generated
	 */
	EAttribute getNodeMachine_IP();

	/**
	 * Returns the meta object for the attribute '{@link observability_emf.NodeMachine#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see observability_emf.NodeMachine#getPort()
	 * @see #getNodeMachine()
	 * @generated
	 */
	EAttribute getNodeMachine_Port();

	/**
	 * Returns the meta object for class '{@link observability_emf.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see observability_emf.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the attribute '{@link observability_emf.Metric#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see observability_emf.Metric#getUnit()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Unit();

	/**
	 * Returns the meta object for the attribute '{@link observability_emf.Metric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see observability_emf.Metric#getName()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Name();

	/**
	 * Returns the meta object for the attribute '{@link observability_emf.Metric#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see observability_emf.Metric#getDescription()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Description();

	/**
	 * Returns the meta object for class '{@link observability_emf.DerivedMetric <em>Derived Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derived Metric</em>'.
	 * @see observability_emf.DerivedMetric
	 * @generated
	 */
	EClass getDerivedMetric();

	/**
	 * Returns the meta object for class '{@link observability_emf.BaseMetric <em>Base Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Metric</em>'.
	 * @see observability_emf.BaseMetric
	 * @generated
	 */
	EClass getBaseMetric();

	/**
	 * Returns the meta object for the reference list '{@link observability_emf.BaseMetric#getDatabaseCluster <em>Database Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Database Cluster</em>'.
	 * @see observability_emf.BaseMetric#getDatabaseCluster()
	 * @see #getBaseMetric()
	 * @generated
	 */
	EReference getBaseMetric_DatabaseCluster();

	/**
	 * Returns the meta object for class '{@link observability_emf.DbType <em>Db Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Db Type</em>'.
	 * @see observability_emf.DbType
	 * @generated
	 */
	EClass getDbType();

	/**
	 * Returns the meta object for the attribute '{@link observability_emf.DbType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see observability_emf.DbType#getName()
	 * @see #getDbType()
	 * @generated
	 */
	EAttribute getDbType_Name();

	/**
	 * Returns the meta object for the attribute '{@link observability_emf.DbType#getProbeLocation <em>Probe Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probe Location</em>'.
	 * @see observability_emf.DbType#getProbeLocation()
	 * @see #getDbType()
	 * @generated
	 */
	EAttribute getDbType_ProbeLocation();

	/**
	 * Returns the meta object for the attribute '{@link observability_emf.DbType#getCollectionFrequency <em>Collection Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collection Frequency</em>'.
	 * @see observability_emf.DbType#getCollectionFrequency()
	 * @see #getDbType()
	 * @generated
	 */
	EAttribute getDbType_CollectionFrequency();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Observability_emfFactory getObservability_emfFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link observability_emf.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_emf.impl.ModelImpl
		 * @see observability_emf.impl.Observability_emfPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Frequency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__FREQUENCY = eINSTANCE.getModel_Frequency();

		/**
		 * The meta object literal for the '<em><b>Clusters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__CLUSTERS = eINSTANCE.getModel_Clusters();

		/**
		 * The meta object literal for the '<em><b>Available Metrics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__AVAILABLE_METRICS = eINSTANCE.getModel_AvailableMetrics();

		/**
		 * The meta object literal for the '<em><b>Available Db Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__AVAILABLE_DB_TYPES = eINSTANCE.getModel_AvailableDbTypes();

		/**
		 * The meta object literal for the '{@link observability_emf.impl.DatabaseClusterImpl <em>Database Cluster</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_emf.impl.DatabaseClusterImpl
		 * @see observability_emf.impl.Observability_emfPackageImpl#getDatabaseCluster()
		 * @generated
		 */
		EClass DATABASE_CLUSTER = eINSTANCE.getDatabaseCluster();

		/**
		 * The meta object literal for the '<em><b>Machines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_CLUSTER__MACHINES = eINSTANCE.getDatabaseCluster_Machines();

		/**
		 * The meta object literal for the '<em><b>Collected Base Metric</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_CLUSTER__COLLECTED_BASE_METRIC = eINSTANCE.getDatabaseCluster_CollectedBaseMetric();

		/**
		 * The meta object literal for the '<em><b>Associated Db Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_CLUSTER__ASSOCIATED_DB_TYPE = eINSTANCE.getDatabaseCluster_AssociatedDbType();

		/**
		 * The meta object literal for the '{@link observability_emf.impl.NodeMachineImpl <em>Node Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_emf.impl.NodeMachineImpl
		 * @see observability_emf.impl.Observability_emfPackageImpl#getNodeMachine()
		 * @generated
		 */
		EClass NODE_MACHINE = eINSTANCE.getNodeMachine();

		/**
		 * The meta object literal for the '<em><b>IP</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_MACHINE__IP = eINSTANCE.getNodeMachine_IP();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_MACHINE__PORT = eINSTANCE.getNodeMachine_Port();

		/**
		 * The meta object literal for the '{@link observability_emf.impl.MetricImpl <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_emf.impl.MetricImpl
		 * @see observability_emf.impl.Observability_emfPackageImpl#getMetric()
		 * @generated
		 */
		EClass METRIC = eINSTANCE.getMetric();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__UNIT = eINSTANCE.getMetric_Unit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__NAME = eINSTANCE.getMetric_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__DESCRIPTION = eINSTANCE.getMetric_Description();

		/**
		 * The meta object literal for the '{@link observability_emf.impl.DerivedMetricImpl <em>Derived Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_emf.impl.DerivedMetricImpl
		 * @see observability_emf.impl.Observability_emfPackageImpl#getDerivedMetric()
		 * @generated
		 */
		EClass DERIVED_METRIC = eINSTANCE.getDerivedMetric();

		/**
		 * The meta object literal for the '{@link observability_emf.impl.BaseMetricImpl <em>Base Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_emf.impl.BaseMetricImpl
		 * @see observability_emf.impl.Observability_emfPackageImpl#getBaseMetric()
		 * @generated
		 */
		EClass BASE_METRIC = eINSTANCE.getBaseMetric();

		/**
		 * The meta object literal for the '<em><b>Database Cluster</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_METRIC__DATABASE_CLUSTER = eINSTANCE.getBaseMetric_DatabaseCluster();

		/**
		 * The meta object literal for the '{@link observability_emf.impl.DbTypeImpl <em>Db Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_emf.impl.DbTypeImpl
		 * @see observability_emf.impl.Observability_emfPackageImpl#getDbType()
		 * @generated
		 */
		EClass DB_TYPE = eINSTANCE.getDbType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB_TYPE__NAME = eINSTANCE.getDbType_Name();

		/**
		 * The meta object literal for the '<em><b>Probe Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB_TYPE__PROBE_LOCATION = eINSTANCE.getDbType_ProbeLocation();

		/**
		 * The meta object literal for the '<em><b>Collection Frequency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB_TYPE__COLLECTION_FREQUENCY = eINSTANCE.getDbType_CollectionFrequency();

	}

} //Observability_emfPackage
