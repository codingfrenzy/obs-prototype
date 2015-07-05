/**
 */
package com.observability.modeling.emf.impl;

import com.observability.modeling.emf.*;

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
public class EmfFactoryImpl extends EFactoryImpl implements EmfFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmfFactory init() {
		try {
			EmfFactory theEmfFactory = (EmfFactory)EPackage.Registry.INSTANCE.getEFactory(EmfPackage.eNS_URI);
			if (theEmfFactory != null) {
				return theEmfFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EmfFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfFactoryImpl() {
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
			case EmfPackage.DATABASE_CLUSTER: return createDatabaseCluster();
			case EmfPackage.DB_TYPE: return createDbType();
			case EmfPackage.ELEMENT: return createElement();
			case EmfPackage.KEY_VALUE: return createKeyValue();
			case EmfPackage.NODE_MACHINE: return createNodeMachine();
			case EmfPackage.MODEL: return createModel();
			case EmfPackage.BASE_METRIC: return createBaseMetric();
			case EmfPackage.DERIVED_METRIC: return createDerivedMetric();
			case EmfPackage.NOTIFICATION: return createNotification();
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
	public Notification createNotification() {
		NotificationImpl notification = new NotificationImpl();
		return notification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfPackage getEmfPackage() {
		return (EmfPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EmfPackage getPackage() {
		return EmfPackage.eINSTANCE;
	}

} //EmfFactoryImpl
