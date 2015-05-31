/**
 */
package observability_emf.impl;

import java.util.Collection;

import observability_emf.BaseMetric;
import observability_emf.DatabaseCluster;
import observability_emf.Observability_emfPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link observability_emf.impl.BaseMetricImpl#getDatabaseCluster <em>Database Cluster</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BaseMetricImpl extends MetricImpl implements BaseMetric {
	/**
	 * The cached value of the '{@link #getDatabaseCluster() <em>Database Cluster</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabaseCluster()
	 * @generated
	 * @ordered
	 */
	protected EList<DatabaseCluster> databaseCluster;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseMetricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Observability_emfPackage.Literals.BASE_METRIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DatabaseCluster> getDatabaseCluster() {
		if (databaseCluster == null) {
			databaseCluster = new EObjectWithInverseResolvingEList.ManyInverse<DatabaseCluster>(DatabaseCluster.class, this, Observability_emfPackage.BASE_METRIC__DATABASE_CLUSTER, Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC);
		}
		return databaseCluster;
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
			case Observability_emfPackage.BASE_METRIC__DATABASE_CLUSTER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDatabaseCluster()).basicAdd(otherEnd, msgs);
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
			case Observability_emfPackage.BASE_METRIC__DATABASE_CLUSTER:
				return ((InternalEList<?>)getDatabaseCluster()).basicRemove(otherEnd, msgs);
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
			case Observability_emfPackage.BASE_METRIC__DATABASE_CLUSTER:
				return getDatabaseCluster();
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
			case Observability_emfPackage.BASE_METRIC__DATABASE_CLUSTER:
				getDatabaseCluster().clear();
				getDatabaseCluster().addAll((Collection<? extends DatabaseCluster>)newValue);
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
			case Observability_emfPackage.BASE_METRIC__DATABASE_CLUSTER:
				getDatabaseCluster().clear();
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
			case Observability_emfPackage.BASE_METRIC__DATABASE_CLUSTER:
				return databaseCluster != null && !databaseCluster.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BaseMetricImpl
