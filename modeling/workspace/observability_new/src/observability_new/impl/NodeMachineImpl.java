/**
 */
package observability_new.impl;

import observability_new.Element;
import observability_new.NodeMachine;
import observability_new.Observability_newPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link observability_new.impl.NodeMachineImpl#getIP <em>IP</em>}</li>
 *   <li>{@link observability_new.impl.NodeMachineImpl#getPort <em>Port</em>}</li>
 *   <li>{@link observability_new.impl.NodeMachineImpl#getName <em>Name</em>}</li>
 *   <li>{@link observability_new.impl.NodeMachineImpl#getHasParentElement <em>Has Parent Element</em>}</li>
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
	 * The cached value of the '{@link #getHasParentElement() <em>Has Parent Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasParentElement()
	 * @generated
	 * @ordered
	 */
	protected Element hasParentElement;

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
		return Observability_newPackage.Literals.NODE_MACHINE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.NODE_MACHINE__IP, oldIP, ip));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.NODE_MACHINE__PORT, oldPort, port));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.NODE_MACHINE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getHasParentElement() {
		if (hasParentElement != null && hasParentElement.eIsProxy()) {
			InternalEObject oldHasParentElement = (InternalEObject)hasParentElement;
			hasParentElement = (Element)eResolveProxy(oldHasParentElement);
			if (hasParentElement != oldHasParentElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Observability_newPackage.NODE_MACHINE__HAS_PARENT_ELEMENT, oldHasParentElement, hasParentElement));
			}
		}
		return hasParentElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetHasParentElement() {
		return hasParentElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasParentElement(Element newHasParentElement) {
		Element oldHasParentElement = hasParentElement;
		hasParentElement = newHasParentElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.NODE_MACHINE__HAS_PARENT_ELEMENT, oldHasParentElement, hasParentElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Observability_newPackage.NODE_MACHINE__IP:
				return getIP();
			case Observability_newPackage.NODE_MACHINE__PORT:
				return getPort();
			case Observability_newPackage.NODE_MACHINE__NAME:
				return getName();
			case Observability_newPackage.NODE_MACHINE__HAS_PARENT_ELEMENT:
				if (resolve) return getHasParentElement();
				return basicGetHasParentElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Observability_newPackage.NODE_MACHINE__IP:
				setIP((String)newValue);
				return;
			case Observability_newPackage.NODE_MACHINE__PORT:
				setPort((Integer)newValue);
				return;
			case Observability_newPackage.NODE_MACHINE__NAME:
				setName((String)newValue);
				return;
			case Observability_newPackage.NODE_MACHINE__HAS_PARENT_ELEMENT:
				setHasParentElement((Element)newValue);
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
			case Observability_newPackage.NODE_MACHINE__IP:
				setIP(IP_EDEFAULT);
				return;
			case Observability_newPackage.NODE_MACHINE__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case Observability_newPackage.NODE_MACHINE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Observability_newPackage.NODE_MACHINE__HAS_PARENT_ELEMENT:
				setHasParentElement((Element)null);
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
			case Observability_newPackage.NODE_MACHINE__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case Observability_newPackage.NODE_MACHINE__PORT:
				return port != PORT_EDEFAULT;
			case Observability_newPackage.NODE_MACHINE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Observability_newPackage.NODE_MACHINE__HAS_PARENT_ELEMENT:
				return hasParentElement != null;
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
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //NodeMachineImpl
