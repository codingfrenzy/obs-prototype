/**
 */
package observability_emf.impl;

import java.util.Collection;

import observability_emf.Metric;
import observability_emf.NodeMachine;
import observability_emf.Observability_emfPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link observability_emf.impl.NodeMachineImpl#getIP <em>IP</em>}</li>
 *   <li>{@link observability_emf.impl.NodeMachineImpl#getPort <em>Port</em>}</li>
 *   <li>{@link observability_emf.impl.NodeMachineImpl#getCollectedMetrics <em>Collected Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeMachineImpl extends MinimalEObjectImpl.Container implements NodeMachine {
	/**
	 * The default value of the '{@link #getIP() <em>IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIP()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIP() <em>IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIP()
	 * @generated
	 * @ordered
	 */
	protected String ip = IP_EDEFAULT;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final int PORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected int port = PORT_EDEFAULT;

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
	protected NodeMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Observability_emfPackage.Literals.NODE_MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIP() {
		return ip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIP(String newIP) {
		String oldIP = ip;
		ip = newIP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_emfPackage.NODE_MACHINE__IP, oldIP, ip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(int newPort) {
		int oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_emfPackage.NODE_MACHINE__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getCollectedMetrics() {
		if (collectedMetrics == null) {
			collectedMetrics = new EObjectResolvingEList<Metric>(Metric.class, this, Observability_emfPackage.NODE_MACHINE__COLLECTED_METRICS);
		}
		return collectedMetrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Observability_emfPackage.NODE_MACHINE__IP:
				return getIP();
			case Observability_emfPackage.NODE_MACHINE__PORT:
				return getPort();
			case Observability_emfPackage.NODE_MACHINE__COLLECTED_METRICS:
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
			case Observability_emfPackage.NODE_MACHINE__IP:
				setIP((String)newValue);
				return;
			case Observability_emfPackage.NODE_MACHINE__PORT:
				setPort((Integer)newValue);
				return;
			case Observability_emfPackage.NODE_MACHINE__COLLECTED_METRICS:
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
			case Observability_emfPackage.NODE_MACHINE__IP:
				setIP(IP_EDEFAULT);
				return;
			case Observability_emfPackage.NODE_MACHINE__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case Observability_emfPackage.NODE_MACHINE__COLLECTED_METRICS:
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
			case Observability_emfPackage.NODE_MACHINE__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case Observability_emfPackage.NODE_MACHINE__PORT:
				return port != PORT_EDEFAULT;
			case Observability_emfPackage.NODE_MACHINE__COLLECTED_METRICS:
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
		result.append(" (IP: ");
		result.append(ip);
		result.append(", Port: ");
		result.append(port);
		result.append(')');
		return result.toString();
	}

} //NodeMachineImpl
