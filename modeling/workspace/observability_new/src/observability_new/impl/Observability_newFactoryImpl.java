/**
 */
package observability_new.impl;

import observability_new.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Observability_newFactoryImpl extends EFactoryImpl implements Observability_newFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Observability_newFactory init() {
		try {
			Observability_newFactory theObservability_newFactory = (Observability_newFactory)EPackage.Registry.INSTANCE.getEFactory(Observability_newPackage.eNS_URI);
			if (theObservability_newFactory != null) {
				return theObservability_newFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Observability_newFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Observability_newFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Observability_newPackage.DATABASE_CLUSTER: return createDatabaseCluster();
			case Observability_newPackage.DB_TYPE: return createDbType();
			case Observability_newPackage.ELEMENT: return createElement();
			case Observability_newPackage.KEY_VALUE: return createKeyValue();
			case Observability_newPackage.NODE_MACHINE: return createNodeMachine();
			case Observability_newPackage.MODEL: return createModel();
			case Observability_newPackage.BASE_METRIC: return createBaseMetric();
			case Observability_newPackage.DERIVED_METRIC: return createDerivedMetric();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseCluster createDatabaseCluster() {
		DatabaseClusterImpl databaseCluster = new DatabaseClusterImpl();
		return databaseCluster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DbType createDbType() {
		DbTypeImpl dbType = new DbTypeImpl();
		return dbType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element createElement() {
		ElementImpl element = new ElementImpl();
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyValue createKeyValue() {
		KeyValueImpl keyValue = new KeyValueImpl();
		return keyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeMachine createNodeMachine() {
		NodeMachineImpl nodeMachine = new NodeMachineImpl();
		return nodeMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseMetric createBaseMetric() {
		BaseMetricImpl baseMetric = new BaseMetricImpl();
		return baseMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerivedMetric createDerivedMetric() {
		DerivedMetricImpl derivedMetric = new DerivedMetricImpl();
		return derivedMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Observability_newPackage getObservability_newPackage() {
		return (Observability_newPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Observability_newPackage getPackage() {
		return Observability_newPackage.eINSTANCE;
	}

} //Observability_newFactoryImpl
