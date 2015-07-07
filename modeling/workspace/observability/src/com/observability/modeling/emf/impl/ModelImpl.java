/**
 */
package com.observability.modeling.emf.impl;

import com.observability.modeling.emf.DatabaseCluster;
import com.observability.modeling.emf.DbType;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.Model;

import java.util.Collection;

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
 *   <li>{@link com.observability.modeling.emf.impl.ModelImpl#getInterval <em>Interval</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.ModelImpl#getClusters <em>Clusters</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.ModelImpl#getAvailableDbTypes <em>Available Db Types</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.ModelImpl#getServerIP <em>Server IP</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.ModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.ModelImpl#getNotifications <em>Notifications</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model {
	/**
	 * The default value of the '{@link #getInterval() <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterval()
	 * @generated
	 * @ordered
	 */
	protected static final int INTERVAL_EDEFAULT = 30;

	/**
	 * The cached value of the '{@link #getInterval() <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterval()
	 * @generated
	 * @ordered
	 */
	protected int interval = INTERVAL_EDEFAULT;

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
	 * The default value of the '{@link #getServerIP() <em>Server IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerIP()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_IP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerIP() <em>Server IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerIP()
	 * @generated
	 * @ordered
	 */
	protected String serverIP = SERVER_IP_EDEFAULT;

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
	 * The cached value of the '{@link #getNotifications() <em>Notifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotifications()
	 * @generated
	 * @ordered
	 */
	protected EList<com.observability.modeling.emf.Notification> notifications;

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
		return EmfPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterval(int newInterval) {
		int oldInterval = interval;
		interval = newInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.MODEL__INTERVAL, oldInterval, interval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DatabaseCluster> getClusters() {
		if (clusters == null) {
			clusters = new EObjectContainmentEList<DatabaseCluster>(DatabaseCluster.class, this, EmfPackage.MODEL__CLUSTERS);
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
			availableDbTypes = new EObjectContainmentEList<DbType>(DbType.class, this, EmfPackage.MODEL__AVAILABLE_DB_TYPES);
		}
		return availableDbTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerIP() {
		return serverIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerIP(String newServerIP) {
		String oldServerIP = serverIP;
		serverIP = newServerIP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.MODEL__SERVER_IP, oldServerIP, serverIP));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<com.observability.modeling.emf.Notification> getNotifications() {
		if (notifications == null) {
			notifications = new EObjectContainmentEList<com.observability.modeling.emf.Notification>(com.observability.modeling.emf.Notification.class, this, EmfPackage.MODEL__NOTIFICATIONS);
		}
		return notifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfPackage.MODEL__CLUSTERS:
				return ((InternalEList<?>)getClusters()).basicRemove(otherEnd, msgs);
			case EmfPackage.MODEL__AVAILABLE_DB_TYPES:
				return ((InternalEList<?>)getAvailableDbTypes()).basicRemove(otherEnd, msgs);
			case EmfPackage.MODEL__NOTIFICATIONS:
				return ((InternalEList<?>)getNotifications()).basicRemove(otherEnd, msgs);
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
			case EmfPackage.MODEL__INTERVAL:
				return getInterval();
			case EmfPackage.MODEL__CLUSTERS:
				return getClusters();
			case EmfPackage.MODEL__AVAILABLE_DB_TYPES:
				return getAvailableDbTypes();
			case EmfPackage.MODEL__SERVER_IP:
				return getServerIP();
			case EmfPackage.MODEL__NAME:
				return getName();
			case EmfPackage.MODEL__NOTIFICATIONS:
				return getNotifications();
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
			case EmfPackage.MODEL__INTERVAL:
				setInterval((Integer)newValue);
				return;
			case EmfPackage.MODEL__CLUSTERS:
				getClusters().clear();
				getClusters().addAll((Collection<? extends DatabaseCluster>)newValue);
				return;
			case EmfPackage.MODEL__AVAILABLE_DB_TYPES:
				getAvailableDbTypes().clear();
				getAvailableDbTypes().addAll((Collection<? extends DbType>)newValue);
				return;
			case EmfPackage.MODEL__SERVER_IP:
				setServerIP((String)newValue);
				return;
			case EmfPackage.MODEL__NAME:
				setName((String)newValue);
				return;
			case EmfPackage.MODEL__NOTIFICATIONS:
				getNotifications().clear();
				getNotifications().addAll((Collection<? extends com.observability.modeling.emf.Notification>)newValue);
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
			case EmfPackage.MODEL__INTERVAL:
				setInterval(INTERVAL_EDEFAULT);
				return;
			case EmfPackage.MODEL__CLUSTERS:
				getClusters().clear();
				return;
			case EmfPackage.MODEL__AVAILABLE_DB_TYPES:
				getAvailableDbTypes().clear();
				return;
			case EmfPackage.MODEL__SERVER_IP:
				setServerIP(SERVER_IP_EDEFAULT);
				return;
			case EmfPackage.MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmfPackage.MODEL__NOTIFICATIONS:
				getNotifications().clear();
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
			case EmfPackage.MODEL__INTERVAL:
				return interval != INTERVAL_EDEFAULT;
			case EmfPackage.MODEL__CLUSTERS:
				return clusters != null && !clusters.isEmpty();
			case EmfPackage.MODEL__AVAILABLE_DB_TYPES:
				return availableDbTypes != null && !availableDbTypes.isEmpty();
			case EmfPackage.MODEL__SERVER_IP:
				return SERVER_IP_EDEFAULT == null ? serverIP != null : !SERVER_IP_EDEFAULT.equals(serverIP);
			case EmfPackage.MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmfPackage.MODEL__NOTIFICATIONS:
				return notifications != null && !notifications.isEmpty();
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
		result.append(" (interval: ");
		result.append(interval);
		result.append(", serverIP: ");
		result.append(serverIP);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ModelImpl
