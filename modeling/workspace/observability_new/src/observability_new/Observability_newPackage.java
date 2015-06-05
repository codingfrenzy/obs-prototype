/**
 */
package observability_new;

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
 * @see observability_new.Observability_newFactory
 * @model kind="package"
 * @generated
 */
public interface Observability_newPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "observability_new";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/observability_new";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "observability_new";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Observability_newPackage eINSTANCE = observability_new.impl.Observability_newPackageImpl.init();

	/**
	 * The meta object id for the '{@link observability_new.impl.DatabaseClusterImpl <em>Database Cluster</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_new.impl.DatabaseClusterImpl
	 * @see observability_new.impl.Observability_newPackageImpl#getDatabaseCluster()
	 * @generated
	 */
	int DATABASE_CLUSTER = 0;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CLUSTER__NAME = 3;

	/**
	 * The feature id for the '<em><b>No Of Machines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CLUSTER__NO_OF_MACHINES = 4;

	/**
	 * The feature id for the '<em><b>Collected Derived Metrics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CLUSTER__COLLECTED_DERIVED_METRICS = 5;

	/**
	 * The number of structural features of the '<em>Database Cluster</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CLUSTER_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Database Cluster</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CLUSTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link observability_new.impl.DbTypeImpl <em>Db Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_new.impl.DbTypeImpl
	 * @see observability_new.impl.Observability_newPackageImpl#getDbType()
	 * @generated
	 */
	int DB_TYPE = 1;

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
	 * The feature id for the '<em><b>Available Metrics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE__AVAILABLE_METRICS = 3;

	/**
	 * The feature id for the '<em><b>Has Parent Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE__HAS_PARENT_ELEMENT = 4;

	/**
	 * The number of structural features of the '<em>Db Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Db Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link observability_new.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_new.impl.ElementImpl
	 * @see observability_new.impl.Observability_newPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Has Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__HAS_ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Has Key Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__HAS_KEY_VALUES = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__VALUE = 3;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link observability_new.impl.KeyValueImpl <em>Key Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_new.impl.KeyValueImpl
	 * @see observability_new.impl.Observability_newPackageImpl#getKeyValue()
	 * @generated
	 */
	int KEY_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Key Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Key Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link observability_new.impl.NodeMachineImpl <em>Node Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_new.impl.NodeMachineImpl
	 * @see observability_new.impl.Observability_newPackageImpl#getNodeMachine()
	 * @generated
	 */
	int NODE_MACHINE = 4;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MACHINE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Has Parent Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MACHINE__HAS_PARENT_ELEMENT = 3;

	/**
	 * The number of structural features of the '<em>Node Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MACHINE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Node Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MACHINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link observability_new.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_new.impl.ModelImpl
	 * @see observability_new.impl.Observability_newPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 5;

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
	 * The feature id for the '<em><b>Available Db Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__AVAILABLE_DB_TYPES = 2;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link observability_new.impl.MetricImpl <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_new.impl.MetricImpl
	 * @see observability_new.impl.Observability_newPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 8;

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
	 * The meta object id for the '{@link observability_new.impl.BaseMetricImpl <em>Base Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_new.impl.BaseMetricImpl
	 * @see observability_new.impl.Observability_newPackageImpl#getBaseMetric()
	 * @generated
	 */
	int BASE_METRIC = 6;

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
	 * The feature id for the '<em><b>Has Parent Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC__HAS_PARENT_ELEMENT = METRIC_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Base Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_FEATURE_COUNT = METRIC_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Base Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_OPERATION_COUNT = METRIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link observability_new.impl.DerivedMetricImpl <em>Derived Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see observability_new.impl.DerivedMetricImpl
	 * @see observability_new.impl.Observability_newPackageImpl#getDerivedMetric()
	 * @generated
	 */
	int DERIVED_METRIC = 7;

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
	 * The feature id for the '<em><b>Has Parent Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_METRIC__HAS_PARENT_ELEMENT = METRIC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Derived Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_METRIC_FEATURE_COUNT = METRIC_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Derived Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_METRIC_OPERATION_COUNT = METRIC_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link observability_new.DatabaseCluster <em>Database Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Cluster</em>'.
	 * @see observability_new.DatabaseCluster
	 * @generated
	 */
	EClass getDatabaseCluster();

	/**
	 * Returns the meta object for the containment reference list '{@link observability_new.DatabaseCluster#getMachines <em>Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machines</em>'.
	 * @see observability_new.DatabaseCluster#getMachines()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EReference getDatabaseCluster_Machines();

	/**
	 * Returns the meta object for the reference list '{@link observability_new.DatabaseCluster#getCollectedBaseMetric <em>Collected Base Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Collected Base Metric</em>'.
	 * @see observability_new.DatabaseCluster#getCollectedBaseMetric()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EReference getDatabaseCluster_CollectedBaseMetric();

	/**
	 * Returns the meta object for the reference '{@link observability_new.DatabaseCluster#getAssociatedDbType <em>Associated Db Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Db Type</em>'.
	 * @see observability_new.DatabaseCluster#getAssociatedDbType()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EReference getDatabaseCluster_AssociatedDbType();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.DatabaseCluster#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see observability_new.DatabaseCluster#getName()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EAttribute getDatabaseCluster_Name();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.DatabaseCluster#getNoOfMachines <em>No Of Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>No Of Machines</em>'.
	 * @see observability_new.DatabaseCluster#getNoOfMachines()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EAttribute getDatabaseCluster_NoOfMachines();

	/**
	 * Returns the meta object for the reference list '{@link observability_new.DatabaseCluster#getCollectedDerivedMetrics <em>Collected Derived Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Collected Derived Metrics</em>'.
	 * @see observability_new.DatabaseCluster#getCollectedDerivedMetrics()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EReference getDatabaseCluster_CollectedDerivedMetrics();

	/**
	 * Returns the meta object for class '{@link observability_new.DbType <em>Db Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Db Type</em>'.
	 * @see observability_new.DbType
	 * @generated
	 */
	EClass getDbType();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.DbType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see observability_new.DbType#getName()
	 * @see #getDbType()
	 * @generated
	 */
	EAttribute getDbType_Name();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.DbType#getProbeLocation <em>Probe Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probe Location</em>'.
	 * @see observability_new.DbType#getProbeLocation()
	 * @see #getDbType()
	 * @generated
	 */
	EAttribute getDbType_ProbeLocation();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.DbType#getCollectionFrequency <em>Collection Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collection Frequency</em>'.
	 * @see observability_new.DbType#getCollectionFrequency()
	 * @see #getDbType()
	 * @generated
	 */
	EAttribute getDbType_CollectionFrequency();

	/**
	 * Returns the meta object for the containment reference list '{@link observability_new.DbType#getAvailableMetrics <em>Available Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Metrics</em>'.
	 * @see observability_new.DbType#getAvailableMetrics()
	 * @see #getDbType()
	 * @generated
	 */
	EReference getDbType_AvailableMetrics();

	/**
	 * Returns the meta object for the reference '{@link observability_new.DbType#getHasParentElement <em>Has Parent Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Has Parent Element</em>'.
	 * @see observability_new.DbType#getHasParentElement()
	 * @see #getDbType()
	 * @generated
	 */
	EReference getDbType_HasParentElement();

	/**
	 * Returns the meta object for class '{@link observability_new.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see observability_new.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the reference list '{@link observability_new.Element#getHasElements <em>Has Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Has Elements</em>'.
	 * @see observability_new.Element#getHasElements()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_HasElements();

	/**
	 * Returns the meta object for the reference list '{@link observability_new.Element#getHasKeyValues <em>Has Key Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Has Key Values</em>'.
	 * @see observability_new.Element#getHasKeyValues()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_HasKeyValues();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see observability_new.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.Element#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see observability_new.Element#getValue()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Value();

	/**
	 * Returns the meta object for class '{@link observability_new.KeyValue <em>Key Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Value</em>'.
	 * @see observability_new.KeyValue
	 * @generated
	 */
	EClass getKeyValue();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.KeyValue#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see observability_new.KeyValue#getKey()
	 * @see #getKeyValue()
	 * @generated
	 */
	EAttribute getKeyValue_Key();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.KeyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see observability_new.KeyValue#getValue()
	 * @see #getKeyValue()
	 * @generated
	 */
	EAttribute getKeyValue_Value();

	/**
	 * Returns the meta object for class '{@link observability_new.NodeMachine <em>Node Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Machine</em>'.
	 * @see observability_new.NodeMachine
	 * @generated
	 */
	EClass getNodeMachine();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.NodeMachine#getIP <em>IP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IP</em>'.
	 * @see observability_new.NodeMachine#getIP()
	 * @see #getNodeMachine()
	 * @generated
	 */
	EAttribute getNodeMachine_IP();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.NodeMachine#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see observability_new.NodeMachine#getPort()
	 * @see #getNodeMachine()
	 * @generated
	 */
	EAttribute getNodeMachine_Port();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.NodeMachine#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see observability_new.NodeMachine#getName()
	 * @see #getNodeMachine()
	 * @generated
	 */
	EAttribute getNodeMachine_Name();

	/**
	 * Returns the meta object for the reference '{@link observability_new.NodeMachine#getHasParentElement <em>Has Parent Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Has Parent Element</em>'.
	 * @see observability_new.NodeMachine#getHasParentElement()
	 * @see #getNodeMachine()
	 * @generated
	 */
	EReference getNodeMachine_HasParentElement();

	/**
	 * Returns the meta object for class '{@link observability_new.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see observability_new.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.Model#getFrequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frequency</em>'.
	 * @see observability_new.Model#getFrequency()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Frequency();

	/**
	 * Returns the meta object for the containment reference list '{@link observability_new.Model#getClusters <em>Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clusters</em>'.
	 * @see observability_new.Model#getClusters()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Clusters();

	/**
	 * Returns the meta object for the containment reference list '{@link observability_new.Model#getAvailableDbTypes <em>Available Db Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Db Types</em>'.
	 * @see observability_new.Model#getAvailableDbTypes()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AvailableDbTypes();

	/**
	 * Returns the meta object for class '{@link observability_new.BaseMetric <em>Base Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Metric</em>'.
	 * @see observability_new.BaseMetric
	 * @generated
	 */
	EClass getBaseMetric();

	/**
	 * Returns the meta object for the reference list '{@link observability_new.BaseMetric#getDatabaseCluster <em>Database Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Database Cluster</em>'.
	 * @see observability_new.BaseMetric#getDatabaseCluster()
	 * @see #getBaseMetric()
	 * @generated
	 */
	EReference getBaseMetric_DatabaseCluster();

	/**
	 * Returns the meta object for the reference '{@link observability_new.BaseMetric#getHasParentElement <em>Has Parent Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Has Parent Element</em>'.
	 * @see observability_new.BaseMetric#getHasParentElement()
	 * @see #getBaseMetric()
	 * @generated
	 */
	EReference getBaseMetric_HasParentElement();

	/**
	 * Returns the meta object for class '{@link observability_new.DerivedMetric <em>Derived Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derived Metric</em>'.
	 * @see observability_new.DerivedMetric
	 * @generated
	 */
	EClass getDerivedMetric();

	/**
	 * Returns the meta object for the reference '{@link observability_new.DerivedMetric#getHasParentElement <em>Has Parent Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Has Parent Element</em>'.
	 * @see observability_new.DerivedMetric#getHasParentElement()
	 * @see #getDerivedMetric()
	 * @generated
	 */
	EReference getDerivedMetric_HasParentElement();

	/**
	 * Returns the meta object for class '{@link observability_new.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see observability_new.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.Metric#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see observability_new.Metric#getUnit()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Unit();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.Metric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see observability_new.Metric#getName()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Name();

	/**
	 * Returns the meta object for the attribute '{@link observability_new.Metric#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see observability_new.Metric#getDescription()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Description();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Observability_newFactory getObservability_newFactory();

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
		 * The meta object literal for the '{@link observability_new.impl.DatabaseClusterImpl <em>Database Cluster</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_new.impl.DatabaseClusterImpl
		 * @see observability_new.impl.Observability_newPackageImpl#getDatabaseCluster()
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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_CLUSTER__NAME = eINSTANCE.getDatabaseCluster_Name();

		/**
		 * The meta object literal for the '<em><b>No Of Machines</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_CLUSTER__NO_OF_MACHINES = eINSTANCE.getDatabaseCluster_NoOfMachines();

		/**
		 * The meta object literal for the '<em><b>Collected Derived Metrics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_CLUSTER__COLLECTED_DERIVED_METRICS = eINSTANCE.getDatabaseCluster_CollectedDerivedMetrics();

		/**
		 * The meta object literal for the '{@link observability_new.impl.DbTypeImpl <em>Db Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_new.impl.DbTypeImpl
		 * @see observability_new.impl.Observability_newPackageImpl#getDbType()
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

		/**
		 * The meta object literal for the '<em><b>Available Metrics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB_TYPE__AVAILABLE_METRICS = eINSTANCE.getDbType_AvailableMetrics();

		/**
		 * The meta object literal for the '<em><b>Has Parent Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB_TYPE__HAS_PARENT_ELEMENT = eINSTANCE.getDbType_HasParentElement();

		/**
		 * The meta object literal for the '{@link observability_new.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_new.impl.ElementImpl
		 * @see observability_new.impl.Observability_newPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Has Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__HAS_ELEMENTS = eINSTANCE.getElement_HasElements();

		/**
		 * The meta object literal for the '<em><b>Has Key Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__HAS_KEY_VALUES = eINSTANCE.getElement_HasKeyValues();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__VALUE = eINSTANCE.getElement_Value();

		/**
		 * The meta object literal for the '{@link observability_new.impl.KeyValueImpl <em>Key Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_new.impl.KeyValueImpl
		 * @see observability_new.impl.Observability_newPackageImpl#getKeyValue()
		 * @generated
		 */
		EClass KEY_VALUE = eINSTANCE.getKeyValue();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_VALUE__KEY = eINSTANCE.getKeyValue_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_VALUE__VALUE = eINSTANCE.getKeyValue_Value();

		/**
		 * The meta object literal for the '{@link observability_new.impl.NodeMachineImpl <em>Node Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_new.impl.NodeMachineImpl
		 * @see observability_new.impl.Observability_newPackageImpl#getNodeMachine()
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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_MACHINE__NAME = eINSTANCE.getNodeMachine_Name();

		/**
		 * The meta object literal for the '<em><b>Has Parent Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_MACHINE__HAS_PARENT_ELEMENT = eINSTANCE.getNodeMachine_HasParentElement();

		/**
		 * The meta object literal for the '{@link observability_new.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_new.impl.ModelImpl
		 * @see observability_new.impl.Observability_newPackageImpl#getModel()
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
		 * The meta object literal for the '<em><b>Available Db Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__AVAILABLE_DB_TYPES = eINSTANCE.getModel_AvailableDbTypes();

		/**
		 * The meta object literal for the '{@link observability_new.impl.BaseMetricImpl <em>Base Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_new.impl.BaseMetricImpl
		 * @see observability_new.impl.Observability_newPackageImpl#getBaseMetric()
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
		 * The meta object literal for the '<em><b>Has Parent Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_METRIC__HAS_PARENT_ELEMENT = eINSTANCE.getBaseMetric_HasParentElement();

		/**
		 * The meta object literal for the '{@link observability_new.impl.DerivedMetricImpl <em>Derived Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_new.impl.DerivedMetricImpl
		 * @see observability_new.impl.Observability_newPackageImpl#getDerivedMetric()
		 * @generated
		 */
		EClass DERIVED_METRIC = eINSTANCE.getDerivedMetric();

		/**
		 * The meta object literal for the '<em><b>Has Parent Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVED_METRIC__HAS_PARENT_ELEMENT = eINSTANCE.getDerivedMetric_HasParentElement();

		/**
		 * The meta object literal for the '{@link observability_new.impl.MetricImpl <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see observability_new.impl.MetricImpl
		 * @see observability_new.impl.Observability_newPackageImpl#getMetric()
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

	}

} //Observability_newPackage
