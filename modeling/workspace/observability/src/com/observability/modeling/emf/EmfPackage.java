/**
 */
package com.observability.modeling.emf;

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
 * @see com.observability.modeling.emf.EmfFactory
 * @model kind="package"
 * @generated
 */
public interface EmfPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "emf";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.observability.com/emf";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "emf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmfPackage eINSTANCE = com.observability.modeling.emf.impl.EmfPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.observability.modeling.emf.impl.DatabaseClusterImpl <em>Database Cluster</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.observability.modeling.emf.impl.DatabaseClusterImpl
	 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getDatabaseCluster()
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
	 * The feature id for the '<em><b>Collected Metrics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CLUSTER__COLLECTED_METRICS = 1;

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
	 * The feature id for the '<em><b>Associated Notifications</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS = 5;

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
	 * The meta object id for the '{@link com.observability.modeling.emf.impl.DbTypeImpl <em>Db Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.observability.modeling.emf.impl.DbTypeImpl
	 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getDbType()
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
	 * The feature id for the '<em><b>Collection Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE__COLLECTION_FREQUENCY = 1;

	/**
	 * The feature id for the '<em><b>Available Metrics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE__AVAILABLE_METRICS = 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE__ELEMENTS = 3;

	/**
	 * The number of structural features of the '<em>Db Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Db Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.observability.modeling.emf.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.observability.modeling.emf.impl.ElementImpl
	 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Key Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__KEY_VALUES = 1;

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
	 * The meta object id for the '{@link com.observability.modeling.emf.impl.KeyValueImpl <em>Key Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.observability.modeling.emf.impl.KeyValueImpl
	 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getKeyValue()
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
	 * The meta object id for the '{@link com.observability.modeling.emf.impl.NodeMachineImpl <em>Node Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.observability.modeling.emf.impl.NodeMachineImpl
	 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getNodeMachine()
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
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MACHINE__ELEMENTS = 3;

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
	 * The meta object id for the '{@link com.observability.modeling.emf.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.observability.modeling.emf.impl.ModelImpl
	 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 5;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__INTERVAL = 0;

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
	 * The feature id for the '<em><b>Server IP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__SERVER_IP = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = 4;

	/**
	 * The feature id for the '<em><b>Notifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NOTIFICATIONS = 5;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.observability.modeling.emf.impl.MetricImpl <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.observability.modeling.emf.impl.MetricImpl
	 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Key Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__KEY_VALUES = 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__ELEMENTS = 3;

	/**
	 * The feature id for the '<em><b>Database Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__DATABASE_CLUSTER = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__TYPE = 5;

	/**
	 * The number of structural features of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.observability.modeling.emf.impl.BaseMetricImpl <em>Base Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.observability.modeling.emf.impl.BaseMetricImpl
	 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getBaseMetric()
	 * @generated
	 */
	int BASE_METRIC = 6;

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
	 * The feature id for the '<em><b>Key Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC__KEY_VALUES = METRIC__KEY_VALUES;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC__ELEMENTS = METRIC__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Database Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC__DATABASE_CLUSTER = METRIC__DATABASE_CLUSTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC__TYPE = METRIC__TYPE;

	/**
	 * The number of structural features of the '<em>Base Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_FEATURE_COUNT = METRIC_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Base Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_OPERATION_COUNT = METRIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.observability.modeling.emf.impl.AggregatedMetricImpl <em>Aggregated Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.observability.modeling.emf.impl.AggregatedMetricImpl
	 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getAggregatedMetric()
	 * @generated
	 */
	int AGGREGATED_METRIC = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC__NAME = METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC__DESCRIPTION = METRIC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Key Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC__KEY_VALUES = METRIC__KEY_VALUES;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC__ELEMENTS = METRIC__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Database Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC__DATABASE_CLUSTER = METRIC__DATABASE_CLUSTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC__TYPE = METRIC__TYPE;

	/**
	 * The feature id for the '<em><b>Calculate Sum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC__CALCULATE_SUM = METRIC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Calculate Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC__CALCULATE_NUM = METRIC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Calculate Avg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC__CALCULATE_AVG = METRIC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Calculate Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC__CALCULATE_MIN = METRIC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Calculate Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC__CALCULATE_MAX = METRIC_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Calculate Stddev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC__CALCULATE_STDDEV = METRIC_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Aggregated Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC_FEATURE_COUNT = METRIC_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Aggregated Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_METRIC_OPERATION_COUNT = METRIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.observability.modeling.emf.impl.NotificationImpl <em>Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.observability.modeling.emf.impl.NotificationImpl
	 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getNotification()
	 * @generated
	 */
	int NOTIFICATION = 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Failure Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__FAILURE_MAX = 1;

	/**
	 * The feature id for the '<em><b>Failure Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__FAILURE_MIN = 2;

	/**
	 * The feature id for the '<em><b>Warning Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__WARNING_MAX = 3;

	/**
	 * The feature id for the '<em><b>Warning Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__WARNING_MIN = 4;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__DATA_SOURCE = 5;

	/**
	 * The feature id for the '<em><b>Invert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__INVERT = 6;

	/**
	 * The feature id for the '<em><b>Persist</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__PERSIST = 7;

	/**
	 * The feature id for the '<em><b>Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__PERCENTAGE = 8;

	/**
	 * The feature id for the '<em><b>Hits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__HITS = 9;

	/**
	 * The feature id for the '<em><b>Hysteresis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__HYSTERESIS = 10;

	/**
	 * The feature id for the '<em><b>Persist Ok</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__PERSIST_OK = 11;

	/**
	 * The feature id for the '<em><b>Interesting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__INTERESTING = 12;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION__INSTANCE = 13;

	/**
	 * The number of structural features of the '<em>Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_FEATURE_COUNT = 14;

	/**
	 * The number of operations of the '<em>Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link com.observability.modeling.emf.DatabaseCluster <em>Database Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Cluster</em>'.
	 * @see com.observability.modeling.emf.DatabaseCluster
	 * @generated
	 */
	EClass getDatabaseCluster();

	/**
	 * Returns the meta object for the containment reference list '{@link com.observability.modeling.emf.DatabaseCluster#getMachines <em>Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machines</em>'.
	 * @see com.observability.modeling.emf.DatabaseCluster#getMachines()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EReference getDatabaseCluster_Machines();

	/**
	 * Returns the meta object for the reference list '{@link com.observability.modeling.emf.DatabaseCluster#getCollectedMetrics <em>Collected Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Collected Metrics</em>'.
	 * @see com.observability.modeling.emf.DatabaseCluster#getCollectedMetrics()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EReference getDatabaseCluster_CollectedMetrics();

	/**
	 * Returns the meta object for the reference '{@link com.observability.modeling.emf.DatabaseCluster#getAssociatedDbType <em>Associated Db Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Db Type</em>'.
	 * @see com.observability.modeling.emf.DatabaseCluster#getAssociatedDbType()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EReference getDatabaseCluster_AssociatedDbType();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.DatabaseCluster#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.observability.modeling.emf.DatabaseCluster#getName()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EAttribute getDatabaseCluster_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.DatabaseCluster#getNoOfMachines <em>No Of Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>No Of Machines</em>'.
	 * @see com.observability.modeling.emf.DatabaseCluster#getNoOfMachines()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EAttribute getDatabaseCluster_NoOfMachines();

	/**
	 * Returns the meta object for the reference list '{@link com.observability.modeling.emf.DatabaseCluster#getAssociatedNotifications <em>Associated Notifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Associated Notifications</em>'.
	 * @see com.observability.modeling.emf.DatabaseCluster#getAssociatedNotifications()
	 * @see #getDatabaseCluster()
	 * @generated
	 */
	EReference getDatabaseCluster_AssociatedNotifications();

	/**
	 * Returns the meta object for class '{@link com.observability.modeling.emf.DbType <em>Db Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Db Type</em>'.
	 * @see com.observability.modeling.emf.DbType
	 * @generated
	 */
	EClass getDbType();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.DbType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.observability.modeling.emf.DbType#getName()
	 * @see #getDbType()
	 * @generated
	 */
	EAttribute getDbType_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.DbType#getCollectionFrequency <em>Collection Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collection Frequency</em>'.
	 * @see com.observability.modeling.emf.DbType#getCollectionFrequency()
	 * @see #getDbType()
	 * @generated
	 */
	EAttribute getDbType_CollectionFrequency();

	/**
	 * Returns the meta object for the containment reference list '{@link com.observability.modeling.emf.DbType#getAvailableMetrics <em>Available Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Metrics</em>'.
	 * @see com.observability.modeling.emf.DbType#getAvailableMetrics()
	 * @see #getDbType()
	 * @generated
	 */
	EReference getDbType_AvailableMetrics();

	/**
	 * Returns the meta object for the containment reference list '{@link com.observability.modeling.emf.DbType#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see com.observability.modeling.emf.DbType#getElements()
	 * @see #getDbType()
	 * @generated
	 */
	EReference getDbType_Elements();

	/**
	 * Returns the meta object for class '{@link com.observability.modeling.emf.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see com.observability.modeling.emf.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the containment reference list '{@link com.observability.modeling.emf.Element#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see com.observability.modeling.emf.Element#getElements()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Elements();

	/**
	 * Returns the meta object for the containment reference list '{@link com.observability.modeling.emf.Element#getKeyValues <em>Key Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Key Values</em>'.
	 * @see com.observability.modeling.emf.Element#getKeyValues()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_KeyValues();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.observability.modeling.emf.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Element#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.observability.modeling.emf.Element#getValue()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Value();

	/**
	 * Returns the meta object for class '{@link com.observability.modeling.emf.KeyValue <em>Key Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Value</em>'.
	 * @see com.observability.modeling.emf.KeyValue
	 * @generated
	 */
	EClass getKeyValue();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.KeyValue#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see com.observability.modeling.emf.KeyValue#getKey()
	 * @see #getKeyValue()
	 * @generated
	 */
	EAttribute getKeyValue_Key();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.KeyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.observability.modeling.emf.KeyValue#getValue()
	 * @see #getKeyValue()
	 * @generated
	 */
	EAttribute getKeyValue_Value();

	/**
	 * Returns the meta object for class '{@link com.observability.modeling.emf.NodeMachine <em>Node Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Machine</em>'.
	 * @see com.observability.modeling.emf.NodeMachine
	 * @generated
	 */
	EClass getNodeMachine();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.NodeMachine#getIP <em>IP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IP</em>'.
	 * @see com.observability.modeling.emf.NodeMachine#getIP()
	 * @see #getNodeMachine()
	 * @generated
	 */
	EAttribute getNodeMachine_IP();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.NodeMachine#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.observability.modeling.emf.NodeMachine#getPort()
	 * @see #getNodeMachine()
	 * @generated
	 */
	EAttribute getNodeMachine_Port();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.NodeMachine#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.observability.modeling.emf.NodeMachine#getName()
	 * @see #getNodeMachine()
	 * @generated
	 */
	EAttribute getNodeMachine_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.observability.modeling.emf.NodeMachine#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see com.observability.modeling.emf.NodeMachine#getElements()
	 * @see #getNodeMachine()
	 * @generated
	 */
	EReference getNodeMachine_Elements();

	/**
	 * Returns the meta object for class '{@link com.observability.modeling.emf.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see com.observability.modeling.emf.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Model#getInterval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interval</em>'.
	 * @see com.observability.modeling.emf.Model#getInterval()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Interval();

	/**
	 * Returns the meta object for the containment reference list '{@link com.observability.modeling.emf.Model#getClusters <em>Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clusters</em>'.
	 * @see com.observability.modeling.emf.Model#getClusters()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Clusters();

	/**
	 * Returns the meta object for the containment reference list '{@link com.observability.modeling.emf.Model#getAvailableDbTypes <em>Available Db Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Db Types</em>'.
	 * @see com.observability.modeling.emf.Model#getAvailableDbTypes()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AvailableDbTypes();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Model#getServerIP <em>Server IP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server IP</em>'.
	 * @see com.observability.modeling.emf.Model#getServerIP()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_ServerIP();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Model#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.observability.modeling.emf.Model#getName()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.observability.modeling.emf.Model#getNotifications <em>Notifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Notifications</em>'.
	 * @see com.observability.modeling.emf.Model#getNotifications()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Notifications();

	/**
	 * Returns the meta object for class '{@link com.observability.modeling.emf.BaseMetric <em>Base Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Metric</em>'.
	 * @see com.observability.modeling.emf.BaseMetric
	 * @generated
	 */
	EClass getBaseMetric();

	/**
	 * Returns the meta object for class '{@link com.observability.modeling.emf.AggregatedMetric <em>Aggregated Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregated Metric</em>'.
	 * @see com.observability.modeling.emf.AggregatedMetric
	 * @generated
	 */
	EClass getAggregatedMetric();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.AggregatedMetric#isCalculateSum <em>Calculate Sum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Calculate Sum</em>'.
	 * @see com.observability.modeling.emf.AggregatedMetric#isCalculateSum()
	 * @see #getAggregatedMetric()
	 * @generated
	 */
	EAttribute getAggregatedMetric_CalculateSum();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.AggregatedMetric#isCalculateNum <em>Calculate Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Calculate Num</em>'.
	 * @see com.observability.modeling.emf.AggregatedMetric#isCalculateNum()
	 * @see #getAggregatedMetric()
	 * @generated
	 */
	EAttribute getAggregatedMetric_CalculateNum();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.AggregatedMetric#isCalculateAvg <em>Calculate Avg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Calculate Avg</em>'.
	 * @see com.observability.modeling.emf.AggregatedMetric#isCalculateAvg()
	 * @see #getAggregatedMetric()
	 * @generated
	 */
	EAttribute getAggregatedMetric_CalculateAvg();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.AggregatedMetric#isCalculateMin <em>Calculate Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Calculate Min</em>'.
	 * @see com.observability.modeling.emf.AggregatedMetric#isCalculateMin()
	 * @see #getAggregatedMetric()
	 * @generated
	 */
	EAttribute getAggregatedMetric_CalculateMin();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.AggregatedMetric#isCalculateMax <em>Calculate Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Calculate Max</em>'.
	 * @see com.observability.modeling.emf.AggregatedMetric#isCalculateMax()
	 * @see #getAggregatedMetric()
	 * @generated
	 */
	EAttribute getAggregatedMetric_CalculateMax();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.AggregatedMetric#isCalculateStddev <em>Calculate Stddev</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Calculate Stddev</em>'.
	 * @see com.observability.modeling.emf.AggregatedMetric#isCalculateStddev()
	 * @see #getAggregatedMetric()
	 * @generated
	 */
	EAttribute getAggregatedMetric_CalculateStddev();

	/**
	 * Returns the meta object for class '{@link com.observability.modeling.emf.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see com.observability.modeling.emf.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Metric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.observability.modeling.emf.Metric#getName()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Metric#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.observability.modeling.emf.Metric#getDescription()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link com.observability.modeling.emf.Metric#getKeyValues <em>Key Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Key Values</em>'.
	 * @see com.observability.modeling.emf.Metric#getKeyValues()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_KeyValues();

	/**
	 * Returns the meta object for the containment reference list '{@link com.observability.modeling.emf.Metric#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see com.observability.modeling.emf.Metric#getElements()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_Elements();

	/**
	 * Returns the meta object for the reference '{@link com.observability.modeling.emf.Metric#getDatabaseCluster <em>Database Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Database Cluster</em>'.
	 * @see com.observability.modeling.emf.Metric#getDatabaseCluster()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_DatabaseCluster();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Metric#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.observability.modeling.emf.Metric#getType()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Type();

	/**
	 * Returns the meta object for class '{@link com.observability.modeling.emf.Notification <em>Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notification</em>'.
	 * @see com.observability.modeling.emf.Notification
	 * @generated
	 */
	EClass getNotification();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.observability.modeling.emf.Notification#getType()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#getFailureMax <em>Failure Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failure Max</em>'.
	 * @see com.observability.modeling.emf.Notification#getFailureMax()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_FailureMax();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#getFailureMin <em>Failure Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failure Min</em>'.
	 * @see com.observability.modeling.emf.Notification#getFailureMin()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_FailureMin();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#getWarningMax <em>Warning Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Warning Max</em>'.
	 * @see com.observability.modeling.emf.Notification#getWarningMax()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_WarningMax();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#getWarningMin <em>Warning Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Warning Min</em>'.
	 * @see com.observability.modeling.emf.Notification#getWarningMin()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_WarningMin();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#getDataSource <em>Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Source</em>'.
	 * @see com.observability.modeling.emf.Notification#getDataSource()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_DataSource();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#isInvert <em>Invert</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invert</em>'.
	 * @see com.observability.modeling.emf.Notification#isInvert()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_Invert();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#isPersist <em>Persist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persist</em>'.
	 * @see com.observability.modeling.emf.Notification#isPersist()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_Persist();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#isPercentage <em>Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percentage</em>'.
	 * @see com.observability.modeling.emf.Notification#isPercentage()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_Percentage();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#getHits <em>Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hits</em>'.
	 * @see com.observability.modeling.emf.Notification#getHits()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_Hits();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#getHysteresis <em>Hysteresis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hysteresis</em>'.
	 * @see com.observability.modeling.emf.Notification#getHysteresis()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_Hysteresis();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#isPersistOk <em>Persist Ok</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persist Ok</em>'.
	 * @see com.observability.modeling.emf.Notification#isPersistOk()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_PersistOk();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#isInteresting <em>Interesting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interesting</em>'.
	 * @see com.observability.modeling.emf.Notification#isInteresting()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_Interesting();

	/**
	 * Returns the meta object for the attribute '{@link com.observability.modeling.emf.Notification#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance</em>'.
	 * @see com.observability.modeling.emf.Notification#getInstance()
	 * @see #getNotification()
	 * @generated
	 */
	EAttribute getNotification_Instance();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EmfFactory getEmfFactory();

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
		 * The meta object literal for the '{@link com.observability.modeling.emf.impl.DatabaseClusterImpl <em>Database Cluster</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.observability.modeling.emf.impl.DatabaseClusterImpl
		 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getDatabaseCluster()
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
		 * The meta object literal for the '<em><b>Collected Metrics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_CLUSTER__COLLECTED_METRICS = eINSTANCE.getDatabaseCluster_CollectedMetrics();

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
		 * The meta object literal for the '<em><b>Associated Notifications</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS = eINSTANCE.getDatabaseCluster_AssociatedNotifications();

		/**
		 * The meta object literal for the '{@link com.observability.modeling.emf.impl.DbTypeImpl <em>Db Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.observability.modeling.emf.impl.DbTypeImpl
		 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getDbType()
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
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB_TYPE__ELEMENTS = eINSTANCE.getDbType_Elements();

		/**
		 * The meta object literal for the '{@link com.observability.modeling.emf.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.observability.modeling.emf.impl.ElementImpl
		 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__ELEMENTS = eINSTANCE.getElement_Elements();

		/**
		 * The meta object literal for the '<em><b>Key Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__KEY_VALUES = eINSTANCE.getElement_KeyValues();

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
		 * The meta object literal for the '{@link com.observability.modeling.emf.impl.KeyValueImpl <em>Key Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.observability.modeling.emf.impl.KeyValueImpl
		 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getKeyValue()
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
		 * The meta object literal for the '{@link com.observability.modeling.emf.impl.NodeMachineImpl <em>Node Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.observability.modeling.emf.impl.NodeMachineImpl
		 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getNodeMachine()
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
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_MACHINE__ELEMENTS = eINSTANCE.getNodeMachine_Elements();

		/**
		 * The meta object literal for the '{@link com.observability.modeling.emf.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.observability.modeling.emf.impl.ModelImpl
		 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__INTERVAL = eINSTANCE.getModel_Interval();

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
		 * The meta object literal for the '<em><b>Server IP</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__SERVER_IP = eINSTANCE.getModel_ServerIP();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

		/**
		 * The meta object literal for the '<em><b>Notifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__NOTIFICATIONS = eINSTANCE.getModel_Notifications();

		/**
		 * The meta object literal for the '{@link com.observability.modeling.emf.impl.BaseMetricImpl <em>Base Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.observability.modeling.emf.impl.BaseMetricImpl
		 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getBaseMetric()
		 * @generated
		 */
		EClass BASE_METRIC = eINSTANCE.getBaseMetric();

		/**
		 * The meta object literal for the '{@link com.observability.modeling.emf.impl.AggregatedMetricImpl <em>Aggregated Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.observability.modeling.emf.impl.AggregatedMetricImpl
		 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getAggregatedMetric()
		 * @generated
		 */
		EClass AGGREGATED_METRIC = eINSTANCE.getAggregatedMetric();

		/**
		 * The meta object literal for the '<em><b>Calculate Sum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_METRIC__CALCULATE_SUM = eINSTANCE.getAggregatedMetric_CalculateSum();

		/**
		 * The meta object literal for the '<em><b>Calculate Num</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_METRIC__CALCULATE_NUM = eINSTANCE.getAggregatedMetric_CalculateNum();

		/**
		 * The meta object literal for the '<em><b>Calculate Avg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_METRIC__CALCULATE_AVG = eINSTANCE.getAggregatedMetric_CalculateAvg();

		/**
		 * The meta object literal for the '<em><b>Calculate Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_METRIC__CALCULATE_MIN = eINSTANCE.getAggregatedMetric_CalculateMin();

		/**
		 * The meta object literal for the '<em><b>Calculate Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_METRIC__CALCULATE_MAX = eINSTANCE.getAggregatedMetric_CalculateMax();

		/**
		 * The meta object literal for the '<em><b>Calculate Stddev</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_METRIC__CALCULATE_STDDEV = eINSTANCE.getAggregatedMetric_CalculateStddev();

		/**
		 * The meta object literal for the '{@link com.observability.modeling.emf.impl.MetricImpl <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.observability.modeling.emf.impl.MetricImpl
		 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getMetric()
		 * @generated
		 */
		EClass METRIC = eINSTANCE.getMetric();

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
		 * The meta object literal for the '<em><b>Key Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__KEY_VALUES = eINSTANCE.getMetric_KeyValues();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__ELEMENTS = eINSTANCE.getMetric_Elements();

		/**
		 * The meta object literal for the '<em><b>Database Cluster</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__DATABASE_CLUSTER = eINSTANCE.getMetric_DatabaseCluster();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__TYPE = eINSTANCE.getMetric_Type();

		/**
		 * The meta object literal for the '{@link com.observability.modeling.emf.impl.NotificationImpl <em>Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.observability.modeling.emf.impl.NotificationImpl
		 * @see com.observability.modeling.emf.impl.EmfPackageImpl#getNotification()
		 * @generated
		 */
		EClass NOTIFICATION = eINSTANCE.getNotification();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__TYPE = eINSTANCE.getNotification_Type();

		/**
		 * The meta object literal for the '<em><b>Failure Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__FAILURE_MAX = eINSTANCE.getNotification_FailureMax();

		/**
		 * The meta object literal for the '<em><b>Failure Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__FAILURE_MIN = eINSTANCE.getNotification_FailureMin();

		/**
		 * The meta object literal for the '<em><b>Warning Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__WARNING_MAX = eINSTANCE.getNotification_WarningMax();

		/**
		 * The meta object literal for the '<em><b>Warning Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__WARNING_MIN = eINSTANCE.getNotification_WarningMin();

		/**
		 * The meta object literal for the '<em><b>Data Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__DATA_SOURCE = eINSTANCE.getNotification_DataSource();

		/**
		 * The meta object literal for the '<em><b>Invert</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__INVERT = eINSTANCE.getNotification_Invert();

		/**
		 * The meta object literal for the '<em><b>Persist</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__PERSIST = eINSTANCE.getNotification_Persist();

		/**
		 * The meta object literal for the '<em><b>Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__PERCENTAGE = eINSTANCE.getNotification_Percentage();

		/**
		 * The meta object literal for the '<em><b>Hits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__HITS = eINSTANCE.getNotification_Hits();

		/**
		 * The meta object literal for the '<em><b>Hysteresis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__HYSTERESIS = eINSTANCE.getNotification_Hysteresis();

		/**
		 * The meta object literal for the '<em><b>Persist Ok</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__PERSIST_OK = eINSTANCE.getNotification_PersistOk();

		/**
		 * The meta object literal for the '<em><b>Interesting</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__INTERESTING = eINSTANCE.getNotification_Interesting();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION__INSTANCE = eINSTANCE.getNotification_Instance();

	}

} //EmfPackage
