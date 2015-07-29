/**
 */
package com.observability.modeling.emf.impl;

import com.observability.modeling.emf.DbType;
import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.Metric;

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
 * An implementation of the model object '<em><b>Db Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.observability.modeling.emf.impl.DbTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.DbTypeImpl#getCollectionFrequency <em>Collection Frequency</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.DbTypeImpl#getAvailableMetrics <em>Available Metrics</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.DbTypeImpl#getElements <em>Elements</em>}</li>
 * </ul>
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
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> elements;

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
		return EmfPackage.Literals.DB_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.DB_TYPE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.DB_TYPE__COLLECTION_FREQUENCY, oldCollectionFrequency, collectionFrequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getAvailableMetrics() {
		if (availableMetrics == null) {
			availableMetrics = new EObjectContainmentEList<Metric>(Metric.class, this, EmfPackage.DB_TYPE__AVAILABLE_METRICS);
		}
		return availableMetrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<Element>(Element.class, this, EmfPackage.DB_TYPE__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfPackage.DB_TYPE__AVAILABLE_METRICS:
				return ((InternalEList<?>)getAvailableMetrics()).basicRemove(otherEnd, msgs);
			case EmfPackage.DB_TYPE__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case EmfPackage.DB_TYPE__NAME:
				return getName();
			case EmfPackage.DB_TYPE__COLLECTION_FREQUENCY:
				return getCollectionFrequency();
			case EmfPackage.DB_TYPE__AVAILABLE_METRICS:
				return getAvailableMetrics();
			case EmfPackage.DB_TYPE__ELEMENTS:
				return getElements();
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
			case EmfPackage.DB_TYPE__NAME:
				setName((String)newValue);
				return;
			case EmfPackage.DB_TYPE__COLLECTION_FREQUENCY:
				setCollectionFrequency((Integer)newValue);
				return;
			case EmfPackage.DB_TYPE__AVAILABLE_METRICS:
				getAvailableMetrics().clear();
				getAvailableMetrics().addAll((Collection<? extends Metric>)newValue);
				return;
			case EmfPackage.DB_TYPE__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends Element>)newValue);
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
			case EmfPackage.DB_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmfPackage.DB_TYPE__COLLECTION_FREQUENCY:
				setCollectionFrequency(COLLECTION_FREQUENCY_EDEFAULT);
				return;
			case EmfPackage.DB_TYPE__AVAILABLE_METRICS:
				getAvailableMetrics().clear();
				return;
			case EmfPackage.DB_TYPE__ELEMENTS:
				getElements().clear();
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
			case EmfPackage.DB_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmfPackage.DB_TYPE__COLLECTION_FREQUENCY:
				return collectionFrequency != COLLECTION_FREQUENCY_EDEFAULT;
			case EmfPackage.DB_TYPE__AVAILABLE_METRICS:
				return availableMetrics != null && !availableMetrics.isEmpty();
			case EmfPackage.DB_TYPE__ELEMENTS:
				return elements != null && !elements.isEmpty();
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
		result.append(", collectionFrequency: ");
		result.append(collectionFrequency);
		result.append(')');
		return result.toString();
	}

} //DbTypeImpl
