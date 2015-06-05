/**
 */
package observability_new.impl;

import java.util.Collection;

import observability_new.DbType;
import observability_new.Element;
import observability_new.Metric;
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
 * An implementation of the model object '<em><b>Db Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link observability_new.impl.DbTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link observability_new.impl.DbTypeImpl#getProbeLocation <em>Probe Location</em>}</li>
 *   <li>{@link observability_new.impl.DbTypeImpl#getCollectionFrequency <em>Collection Frequency</em>}</li>
 *   <li>{@link observability_new.impl.DbTypeImpl#getAvailableMetrics <em>Available Metrics</em>}</li>
 *   <li>{@link observability_new.impl.DbTypeImpl#getHasParentElement <em>Has Parent Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DbTypeImpl extends MinimalEObjectImpl.Container implements DbType {
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
	 * The default value of the '{@link #getProbeLocation() <em>Probe Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbeLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String PROBE_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProbeLocation() <em>Probe Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbeLocation()
	 * @generated
	 * @ordered
	 */
	protected String probeLocation = PROBE_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCollectionFrequency() <em>Collection Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionFrequency()
	 * @generated
	 * @ordered
	 */
	protected static final int COLLECTION_FREQUENCY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCollectionFrequency() <em>Collection Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionFrequency()
	 * @generated
	 * @ordered
	 */
	protected int collectionFrequency = COLLECTION_FREQUENCY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAvailableMetrics() <em>Available Metrics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> availableMetrics;

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
	protected DbTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Observability_newPackage.Literals.DB_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.DB_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProbeLocation() {
		return probeLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbeLocation(String newProbeLocation) {
		String oldProbeLocation = probeLocation;
		probeLocation = newProbeLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.DB_TYPE__PROBE_LOCATION, oldProbeLocation, probeLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCollectionFrequency() {
		return collectionFrequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectionFrequency(int newCollectionFrequency) {
		int oldCollectionFrequency = collectionFrequency;
		collectionFrequency = newCollectionFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.DB_TYPE__COLLECTION_FREQUENCY, oldCollectionFrequency, collectionFrequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getAvailableMetrics() {
		if (availableMetrics == null) {
			availableMetrics = new EObjectContainmentEList<Metric>(Metric.class, this, Observability_newPackage.DB_TYPE__AVAILABLE_METRICS);
		}
		return availableMetrics;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Observability_newPackage.DB_TYPE__HAS_PARENT_ELEMENT, oldHasParentElement, hasParentElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.DB_TYPE__HAS_PARENT_ELEMENT, oldHasParentElement, hasParentElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Observability_newPackage.DB_TYPE__AVAILABLE_METRICS:
				return ((InternalEList<?>)getAvailableMetrics()).basicRemove(otherEnd, msgs);
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
			case Observability_newPackage.DB_TYPE__NAME:
				return getName();
			case Observability_newPackage.DB_TYPE__PROBE_LOCATION:
				return getProbeLocation();
			case Observability_newPackage.DB_TYPE__COLLECTION_FREQUENCY:
				return getCollectionFrequency();
			case Observability_newPackage.DB_TYPE__AVAILABLE_METRICS:
				return getAvailableMetrics();
			case Observability_newPackage.DB_TYPE__HAS_PARENT_ELEMENT:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Observability_newPackage.DB_TYPE__NAME:
				setName((String)newValue);
				return;
			case Observability_newPackage.DB_TYPE__PROBE_LOCATION:
				setProbeLocation((String)newValue);
				return;
			case Observability_newPackage.DB_TYPE__COLLECTION_FREQUENCY:
				setCollectionFrequency((Integer)newValue);
				return;
			case Observability_newPackage.DB_TYPE__AVAILABLE_METRICS:
				getAvailableMetrics().clear();
				getAvailableMetrics().addAll((Collection<? extends Metric>)newValue);
				return;
			case Observability_newPackage.DB_TYPE__HAS_PARENT_ELEMENT:
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
			case Observability_newPackage.DB_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Observability_newPackage.DB_TYPE__PROBE_LOCATION:
				setProbeLocation(PROBE_LOCATION_EDEFAULT);
				return;
			case Observability_newPackage.DB_TYPE__COLLECTION_FREQUENCY:
				setCollectionFrequency(COLLECTION_FREQUENCY_EDEFAULT);
				return;
			case Observability_newPackage.DB_TYPE__AVAILABLE_METRICS:
				getAvailableMetrics().clear();
				return;
			case Observability_newPackage.DB_TYPE__HAS_PARENT_ELEMENT:
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
			case Observability_newPackage.DB_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Observability_newPackage.DB_TYPE__PROBE_LOCATION:
				return PROBE_LOCATION_EDEFAULT == null ? probeLocation != null : !PROBE_LOCATION_EDEFAULT.equals(probeLocation);
			case Observability_newPackage.DB_TYPE__COLLECTION_FREQUENCY:
				return collectionFrequency != COLLECTION_FREQUENCY_EDEFAULT;
			case Observability_newPackage.DB_TYPE__AVAILABLE_METRICS:
				return availableMetrics != null && !availableMetrics.isEmpty();
			case Observability_newPackage.DB_TYPE__HAS_PARENT_ELEMENT:
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
		result.append(" (name: ");
		result.append(name);
		result.append(", probeLocation: ");
		result.append(probeLocation);
		result.append(", collectionFrequency: ");
		result.append(collectionFrequency);
		result.append(')');
		return result.toString();
	}

} //DbTypeImpl
