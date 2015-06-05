/**
 */
package observability_new.impl;

import java.util.Collection;

import observability_new.BaseMetric;
import observability_new.DatabaseCluster;
import observability_new.DbType;
import observability_new.DerivedMetric;
import observability_new.NodeMachine;
import observability_new.Observability_newPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Database Cluster</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link observability_new.impl.DatabaseClusterImpl#getMachines <em>Machines</em>}</li>
 *   <li>{@link observability_new.impl.DatabaseClusterImpl#getCollectedBaseMetric <em>Collected Base Metric</em>}</li>
 *   <li>{@link observability_new.impl.DatabaseClusterImpl#getAssociatedDbType <em>Associated Db Type</em>}</li>
 *   <li>{@link observability_new.impl.DatabaseClusterImpl#getName <em>Name</em>}</li>
 *   <li>{@link observability_new.impl.DatabaseClusterImpl#getNoOfMachines <em>No Of Machines</em>}</li>
 *   <li>{@link observability_new.impl.DatabaseClusterImpl#getCollectedDerivedMetrics <em>Collected Derived Metrics</em>}</li>
 * </ul>
 * </p>
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
	 * The cached value of the '{@link #getCollectedBaseMetric() <em>Collected Base Metric</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectedBaseMetric()
	 * @generated
	 * @ordered
	 */
	protected EList<BaseMetric> collectedBaseMetric;

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
	 * The cached value of the '{@link #getCollectedDerivedMetrics() <em>Collected Derived Metrics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectedDerivedMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<DerivedMetric> collectedDerivedMetrics;

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
		return Observability_newPackage.Literals.DATABASE_CLUSTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeMachine> getMachines() {
		if (machines == null) {
			machines = new EObjectContainmentEList<NodeMachine>(NodeMachine.class, this, Observability_newPackage.DATABASE_CLUSTER__MACHINES);
		}
		return machines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BaseMetric> getCollectedBaseMetric() {
		if (collectedBaseMetric == null) {
			collectedBaseMetric = new EObjectWithInverseResolvingEList.ManyInverse<BaseMetric>(BaseMetric.class, this, Observability_newPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC, Observability_newPackage.BASE_METRIC__DATABASE_CLUSTER);
		}
		return collectedBaseMetric;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Observability_newPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE, oldAssociatedDbType, associatedDbType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE, oldAssociatedDbType, associatedDbType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.DATABASE_CLUSTER__NAME, oldName, name));
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
	 * @generated
	 */
	public void setNoOfMachines(int newNoOfMachines) {
		int oldNoOfMachines = noOfMachines;
		noOfMachines = newNoOfMachines;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.DATABASE_CLUSTER__NO_OF_MACHINES, oldNoOfMachines, noOfMachines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DerivedMetric> getCollectedDerivedMetrics() {
		if (collectedDerivedMetrics == null) {
			collectedDerivedMetrics = new EObjectResolvingEList<DerivedMetric>(DerivedMetric.class, this, Observability_newPackage.DATABASE_CLUSTER__COLLECTED_DERIVED_METRICS);
		}
		return collectedDerivedMetrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Observability_newPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCollectedBaseMetric()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Observability_newPackage.DATABASE_CLUSTER__MACHINES:
				return ((InternalEList<?>)getMachines()).basicRemove(otherEnd, msgs);
			case Observability_newPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC:
				return ((InternalEList<?>)getCollectedBaseMetric()).basicRemove(otherEnd, msgs);
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
			case Observability_newPackage.DATABASE_CLUSTER__MACHINES:
				return getMachines();
			case Observability_newPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC:
				return getCollectedBaseMetric();
			case Observability_newPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE:
				if (resolve) return getAssociatedDbType();
				return basicGetAssociatedDbType();
			case Observability_newPackage.DATABASE_CLUSTER__NAME:
				return getName();
			case Observability_newPackage.DATABASE_CLUSTER__NO_OF_MACHINES:
				return getNoOfMachines();
			case Observability_newPackage.DATABASE_CLUSTER__COLLECTED_DERIVED_METRICS:
				return getCollectedDerivedMetrics();
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
			case Observability_newPackage.DATABASE_CLUSTER__MACHINES:
				getMachines().clear();
				getMachines().addAll((Collection<? extends NodeMachine>)newValue);
				return;
			case Observability_newPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC:
				getCollectedBaseMetric().clear();
				getCollectedBaseMetric().addAll((Collection<? extends BaseMetric>)newValue);
				return;
			case Observability_newPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE:
				setAssociatedDbType((DbType)newValue);
				return;
			case Observability_newPackage.DATABASE_CLUSTER__NAME:
				setName((String)newValue);
				return;
			case Observability_newPackage.DATABASE_CLUSTER__NO_OF_MACHINES:
				setNoOfMachines((Integer)newValue);
				return;
			case Observability_newPackage.DATABASE_CLUSTER__COLLECTED_DERIVED_METRICS:
				getCollectedDerivedMetrics().clear();
				getCollectedDerivedMetrics().addAll((Collection<? extends DerivedMetric>)newValue);
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
			case Observability_newPackage.DATABASE_CLUSTER__MACHINES:
				getMachines().clear();
				return;
			case Observability_newPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC:
				getCollectedBaseMetric().clear();
				return;
			case Observability_newPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE:
				setAssociatedDbType((DbType)null);
				return;
			case Observability_newPackage.DATABASE_CLUSTER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Observability_newPackage.DATABASE_CLUSTER__NO_OF_MACHINES:
				setNoOfMachines(NO_OF_MACHINES_EDEFAULT);
				return;
			case Observability_newPackage.DATABASE_CLUSTER__COLLECTED_DERIVED_METRICS:
				getCollectedDerivedMetrics().clear();
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
			case Observability_newPackage.DATABASE_CLUSTER__MACHINES:
				return machines != null && !machines.isEmpty();
			case Observability_newPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC:
				return collectedBaseMetric != null && !collectedBaseMetric.isEmpty();
			case Observability_newPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE:
				return associatedDbType != null;
			case Observability_newPackage.DATABASE_CLUSTER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Observability_newPackage.DATABASE_CLUSTER__NO_OF_MACHINES:
				return noOfMachines != NO_OF_MACHINES_EDEFAULT;
			case Observability_newPackage.DATABASE_CLUSTER__COLLECTED_DERIVED_METRICS:
				return collectedDerivedMetrics != null && !collectedDerivedMetrics.isEmpty();
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
