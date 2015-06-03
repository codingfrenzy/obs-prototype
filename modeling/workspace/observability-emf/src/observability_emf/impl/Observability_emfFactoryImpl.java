/**
 */
package observability_emf.impl;

import observability_emf.*;

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
public class Observability_emfFactoryImpl extends EFactoryImpl implements Observability_emfFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Observability_emfFactory init() {
		try {
			Observability_emfFactory theObservability_emfFactory = (Observability_emfFactory)EPackage.Registry.INSTANCE.getEFactory(Observability_emfPackage.eNS_URI);
			if (theObservability_emfFactory != null) {
				return theObservability_emfFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Observability_emfFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Observability_emfFactoryImpl() {
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
			case Observability_emfPackage.MODEL: return createModel();
			case Observability_emfPackage.DATABASE_CLUSTER: return createDatabaseCluster();
			case Observability_emfPackage.NODE_MACHINE: return createNodeMachine();
			case Observability_emfPackage.DERIVED_METRIC: return createDerivedMetric();
			case Observability_emfPackage.BASE_METRIC: return createBaseMetric();
			case Observability_emfPackage.DB_TYPE: return createDbType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
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
	public DatabaseCluster createDatabaseCluster() {
		DatabaseClusterImpl databaseCluster = new DatabaseClusterImpl();
		return databaseCluster;
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
	public DerivedMetric createDerivedMetric() {
		DerivedMetricImpl derivedMetric = new DerivedMetricImpl();
		return derivedMetric;
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
	public DbType createDbType() {
		DbTypeImpl dbType = new DbTypeImpl();
		return dbType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Observability_emfPackage getObservability_emfPackage() {
		return (Observability_emfPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Observability_emfPackage getPackage() {
		return Observability_emfPackage.eINSTANCE;
	}

} //Observability_emfFactoryImpl
