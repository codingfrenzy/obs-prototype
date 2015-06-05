/**
 */
package observability_new.impl;

import java.util.Collection;

import observability_new.DatabaseCluster;
import observability_new.DbType;
import observability_new.Model;
import observability_new.Observability_newPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link observability_new.impl.ModelImpl#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link observability_new.impl.ModelImpl#getClusters <em>Clusters</em>}</li>
 *   <li>{@link observability_new.impl.ModelImpl#getAvailableDbTypes <em>Available Db Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model {
	/**
	 * The default value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrequency()
	 * @generated
	 * @ordered
	 */
	protected static final int FREQUENCY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrequency()
	 * @generated
	 * @ordered
	 */
	protected int frequency = FREQUENCY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getClusters() <em>Clusters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusters()
	 * @generated
	 * @ordered
	 */
	protected EList<DatabaseCluster> clusters;

	/**
	 * The cached value of the '{@link #getAvailableDbTypes() <em>Available Db Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableDbTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DbType> availableDbTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Observability_newPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrequency(int newFrequency) {
		int oldFrequency = frequency;
		frequency = newFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.MODEL__FREQUENCY, oldFrequency, frequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DatabaseCluster> getClusters() {
		if (clusters == null) {
			clusters = new EObjectContainmentEList<DatabaseCluster>(DatabaseCluster.class, this, Observability_newPackage.MODEL__CLUSTERS);
		}
		return clusters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DbType> getAvailableDbTypes() {
		if (availableDbTypes == null) {
			availableDbTypes = new EObjectContainmentEList<DbType>(DbType.class, this, Observability_newPackage.MODEL__AVAILABLE_DB_TYPES);
		}
		return availableDbTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Observability_newPackage.MODEL__CLUSTERS:
				return ((InternalEList<?>)getClusters()).basicRemove(otherEnd, msgs);
			case Observability_newPackage.MODEL__AVAILABLE_DB_TYPES:
				return ((InternalEList<?>)getAvailableDbTypes()).basicRemove(otherEnd, msgs);
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
			case Observability_newPackage.MODEL__FREQUENCY:
				return getFrequency();
			case Observability_newPackage.MODEL__CLUSTERS:
				return getClusters();
			case Observability_newPackage.MODEL__AVAILABLE_DB_TYPES:
				return getAvailableDbTypes();
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
			case Observability_newPackage.MODEL__FREQUENCY:
				setFrequency((Integer)newValue);
				return;
			case Observability_newPackage.MODEL__CLUSTERS:
				getClusters().clear();
				getClusters().addAll((Collection<? extends DatabaseCluster>)newValue);
				return;
			case Observability_newPackage.MODEL__AVAILABLE_DB_TYPES:
				getAvailableDbTypes().clear();
				getAvailableDbTypes().addAll((Collection<? extends DbType>)newValue);
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
			case Observability_newPackage.MODEL__FREQUENCY:
				setFrequency(FREQUENCY_EDEFAULT);
				return;
			case Observability_newPackage.MODEL__CLUSTERS:
				getClusters().clear();
				return;
			case Observability_newPackage.MODEL__AVAILABLE_DB_TYPES:
				getAvailableDbTypes().clear();
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
			case Observability_newPackage.MODEL__FREQUENCY:
				return frequency != FREQUENCY_EDEFAULT;
			case Observability_newPackage.MODEL__CLUSTERS:
				return clusters != null && !clusters.isEmpty();
			case Observability_newPackage.MODEL__AVAILABLE_DB_TYPES:
				return availableDbTypes != null && !availableDbTypes.isEmpty();
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
		result.append(" (frequency: ");
		result.append(frequency);
		result.append(')');
		return result.toString();
	}

} //ModelImpl
