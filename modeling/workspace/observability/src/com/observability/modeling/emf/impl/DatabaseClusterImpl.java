/**
 */
package com.observability.modeling.emf.impl;

import com.observability.modeling.emf.DatabaseCluster;
import com.observability.modeling.emf.DbType;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.Metric;
import com.observability.modeling.emf.NodeMachine;
import com.observability.modeling.emf.extension.CustomServices;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Database Cluster</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.observability.modeling.emf.impl.DatabaseClusterImpl#getMachines <em>Machines</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.DatabaseClusterImpl#getAssociatedDbType <em>Associated Db Type</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.DatabaseClusterImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.DatabaseClusterImpl#getNoOfMachines <em>No Of Machines</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.DatabaseClusterImpl#getAssociatedNotifications <em>Associated Notifications</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.DatabaseClusterImpl#getCollectedMetrics <em>Collected Metrics</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DatabaseClusterImpl extends MinimalEObjectImpl.Container implements DatabaseCluster {
	/**
	 * The cached value of the '{@link #getMachines() <em>Machines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachines()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeMachine> machines;

	/**
	 * The cached value of the '{@link #getAssociatedDbType() <em>Associated Db Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedDbType()
	 * @generated
	 * @ordered
	 */
	protected DbType associatedDbType;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNoOfMachines() <em>No Of Machines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoOfMachines()
	 * @generated
	 * @ordered
	 */
	protected static final int NO_OF_MACHINES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNoOfMachines() <em>No Of Machines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoOfMachines()
	 * @generated
	 * @ordered
	 */
	protected int noOfMachines = NO_OF_MACHINES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAssociatedNotifications() <em>Associated Notifications</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedNotifications()
	 * @generated
	 * @ordered
	 */
	protected EList<com.observability.modeling.emf.Notification> associatedNotifications;

	/**
	 * The cached value of the '{@link #getCollectedMetrics() <em>Collected Metrics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectedMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> collectedMetrics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseClusterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfPackage.Literals.DATABASE_CLUSTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	public EList<NodeMachine> getMachines() {
		if (machines == null) {
			machines = new EObjectContainmentEList<NodeMachine>(NodeMachine.class, this, EmfPackage.DATABASE_CLUSTER__MACHINES);
		}
		/**
		* Syncronize the cluster noOfMachines attribute 
		* with the actual machines inside it.
		*/
		noOfMachines = machines.size();
		return machines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getCollectedMetrics() {
		if (collectedMetrics == null) {
			collectedMetrics = new EObjectResolvingEList<Metric>(Metric.class, this, EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS);
		}
		return collectedMetrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DbType getAssociatedDbType() {
		if (associatedDbType != null && associatedDbType.eIsProxy()) {
			InternalEObject oldAssociatedDbType = (InternalEObject)associatedDbType;
			associatedDbType = (DbType)eResolveProxy(oldAssociatedDbType);
			if (associatedDbType != oldAssociatedDbType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE, oldAssociatedDbType, associatedDbType));
			}
		}
		return associatedDbType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DbType basicGetAssociatedDbType() {
		return associatedDbType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociatedDbType(DbType newAssociatedDbType) {
		DbType oldAssociatedDbType = associatedDbType;
		associatedDbType = newAssociatedDbType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE, oldAssociatedDbType, associatedDbType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.DATABASE_CLUSTER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNoOfMachines() {
		return noOfMachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public void setNoOfMachines(int newNoOfMachines) {
		int oldNoOfMachines = noOfMachines;
		noOfMachines = newNoOfMachines;
		/**
		 * Custom code to create the actual instances when this
		 * attribute changes
		 */
		CustomServices.createNodes(this,noOfMachines);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.DATABASE_CLUSTER__NO_OF_MACHINES, oldNoOfMachines, noOfMachines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<com.observability.modeling.emf.Notification> getAssociatedNotifications() {
		if (associatedNotifications == null) {
			associatedNotifications = new EObjectResolvingEList<com.observability.modeling.emf.Notification>(com.observability.modeling.emf.Notification.class, this, EmfPackage.DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS);
		}
		return associatedNotifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfPackage.DATABASE_CLUSTER__MACHINES:
				return ((InternalEList<?>)getMachines()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfPackage.DATABASE_CLUSTER__MACHINES:
				return getMachines();
			case EmfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE:
				if (resolve) return getAssociatedDbType();
				return basicGetAssociatedDbType();
			case EmfPackage.DATABASE_CLUSTER__NAME:
				return getName();
			case EmfPackage.DATABASE_CLUSTER__NO_OF_MACHINES:
				return getNoOfMachines();
			case EmfPackage.DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS:
				return getAssociatedNotifications();
			case EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS:
				return getCollectedMetrics();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfPackage.DATABASE_CLUSTER__MACHINES:
				getMachines().clear();
				getMachines().addAll((Collection<? extends NodeMachine>)newValue);
				return;
			case EmfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE:
				setAssociatedDbType((DbType)newValue);
				return;
			case EmfPackage.DATABASE_CLUSTER__NAME:
				setName((String)newValue);
				return;
			case EmfPackage.DATABASE_CLUSTER__NO_OF_MACHINES:
				setNoOfMachines((Integer)newValue);
				return;
			case EmfPackage.DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS:
				getAssociatedNotifications().clear();
				getAssociatedNotifications().addAll((Collection<? extends com.observability.modeling.emf.Notification>)newValue);
				return;
			case EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS:
				getCollectedMetrics().clear();
				getCollectedMetrics().addAll((Collection<? extends Metric>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfPackage.DATABASE_CLUSTER__MACHINES:
				getMachines().clear();
				return;
			case EmfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE:
				setAssociatedDbType((DbType)null);
				return;
			case EmfPackage.DATABASE_CLUSTER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmfPackage.DATABASE_CLUSTER__NO_OF_MACHINES:
				setNoOfMachines(NO_OF_MACHINES_EDEFAULT);
				return;
			case EmfPackage.DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS:
				getAssociatedNotifications().clear();
				return;
			case EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS:
				getCollectedMetrics().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfPackage.DATABASE_CLUSTER__MACHINES:
				return machines != null && !machines.isEmpty();
			case EmfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE:
				return associatedDbType != null;
			case EmfPackage.DATABASE_CLUSTER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmfPackage.DATABASE_CLUSTER__NO_OF_MACHINES:
				return noOfMachines != NO_OF_MACHINES_EDEFAULT;
			case EmfPackage.DATABASE_CLUSTER__ASSOCIATED_NOTIFICATIONS:
				return associatedNotifications != null && !associatedNotifications.isEmpty();
			case EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS:
				return collectedMetrics != null && !collectedMetrics.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", noOfMachines: ");
		result.append(noOfMachines);
		result.append(')');
		return result.toString();
	}

} //DatabaseClusterImpl
