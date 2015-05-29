/**
 */
package observability_emf.impl;

import java.util.Collection;

import observability_emf.DatabaseCluster;
import observability_emf.DbType;
import observability_emf.Metric;
import observability_emf.NodeMachine;
import observability_emf.Observability_emfPackage;

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
 * <ul>
 *   <li>{@link observability_emf.impl.DatabaseClusterImpl#getMachines <em>Machines</em>}</li>
 *   <li>{@link observability_emf.impl.DatabaseClusterImpl#getDbType <em>Db Type</em>}</li>
 *   <li>{@link observability_emf.impl.DatabaseClusterImpl#getCollectedMetrics <em>Collected Metrics</em>}</li>
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
	 * The cached value of the '{@link #getDbType() <em>Db Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbType()
	 * @generated
	 * @ordered
	 */
	protected DbType dbType;

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
		return Observability_emfPackage.Literals.DATABASE_CLUSTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeMachine> getMachines() {
		if (machines == null) {
			machines = new EObjectContainmentEList<NodeMachine>(NodeMachine.class, this, Observability_emfPackage.DATABASE_CLUSTER__MACHINES);
		}
		return machines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DbType getDbType() {
		return dbType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDbType(DbType newDbType, NotificationChain msgs) {
		DbType oldDbType = dbType;
		dbType = newDbType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Observability_emfPackage.DATABASE_CLUSTER__DB_TYPE, oldDbType, newDbType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbType(DbType newDbType) {
		if (newDbType != dbType) {
			NotificationChain msgs = null;
			if (dbType != null)
				msgs = ((InternalEObject)dbType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Observability_emfPackage.DATABASE_CLUSTER__DB_TYPE, null, msgs);
			if (newDbType != null)
				msgs = ((InternalEObject)newDbType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Observability_emfPackage.DATABASE_CLUSTER__DB_TYPE, null, msgs);
			msgs = basicSetDbType(newDbType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_emfPackage.DATABASE_CLUSTER__DB_TYPE, newDbType, newDbType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getCollectedMetrics() {
		if (collectedMetrics == null) {
			collectedMetrics = new EObjectResolvingEList<Metric>(Metric.class, this, Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_METRICS);
		}
		return collectedMetrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Observability_emfPackage.DATABASE_CLUSTER__MACHINES:
				return ((InternalEList<?>)getMachines()).basicRemove(otherEnd, msgs);
			case Observability_emfPackage.DATABASE_CLUSTER__DB_TYPE:
				return basicSetDbType(null, msgs);
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
			case Observability_emfPackage.DATABASE_CLUSTER__MACHINES:
				return getMachines();
			case Observability_emfPackage.DATABASE_CLUSTER__DB_TYPE:
				return getDbType();
			case Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_METRICS:
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
			case Observability_emfPackage.DATABASE_CLUSTER__MACHINES:
				getMachines().clear();
				getMachines().addAll((Collection<? extends NodeMachine>)newValue);
				return;
			case Observability_emfPackage.DATABASE_CLUSTER__DB_TYPE:
				setDbType((DbType)newValue);
				return;
			case Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_METRICS:
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
			case Observability_emfPackage.DATABASE_CLUSTER__MACHINES:
				getMachines().clear();
				return;
			case Observability_emfPackage.DATABASE_CLUSTER__DB_TYPE:
				setDbType((DbType)null);
				return;
			case Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_METRICS:
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
			case Observability_emfPackage.DATABASE_CLUSTER__MACHINES:
				return machines != null && !machines.isEmpty();
			case Observability_emfPackage.DATABASE_CLUSTER__DB_TYPE:
				return dbType != null;
			case Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_METRICS:
				return collectedMetrics != null && !collectedMetrics.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DatabaseClusterImpl
