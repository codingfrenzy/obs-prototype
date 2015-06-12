/**
 */
package observability_new.impl;

import java.util.Collection;

import observability_new.Element;
import observability_new.KeyValue;
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
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link observability_new.impl.ElementImpl#getHasElements <em>Has Elements</em>}</li>
 *   <li>{@link observability_new.impl.ElementImpl#getHasKeyValues <em>Has Key Values</em>}</li>
 *   <li>{@link observability_new.impl.ElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link observability_new.impl.ElementImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementImpl extends MinimalEObjectImpl.Container implements Element {
	/**
	 * The cached value of the '{@link #getHasElements() <em>Has Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> hasElements;

	/**
	 * The cached value of the '{@link #getHasKeyValues() <em>Has Key Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasKeyValues()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyValue> hasKeyValues;

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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Observability_newPackage.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getHasElements() {
		if (hasElements == null) {
			hasElements = new EObjectContainmentEList<Element>(Element.class, this, Observability_newPackage.ELEMENT__HAS_ELEMENTS);
		}
		return hasElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KeyValue> getHasKeyValues() {
		if (hasKeyValues == null) {
			hasKeyValues = new EObjectContainmentEList<KeyValue>(KeyValue.class, this, Observability_newPackage.ELEMENT__HAS_KEY_VALUES);
		}
		return hasKeyValues;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.ELEMENT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Observability_newPackage.ELEMENT__HAS_ELEMENTS:
				return ((InternalEList<?>)getHasElements()).basicRemove(otherEnd, msgs);
			case Observability_newPackage.ELEMENT__HAS_KEY_VALUES:
				return ((InternalEList<?>)getHasKeyValues()).basicRemove(otherEnd, msgs);
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
			case Observability_newPackage.ELEMENT__HAS_ELEMENTS:
				return getHasElements();
			case Observability_newPackage.ELEMENT__HAS_KEY_VALUES:
				return getHasKeyValues();
			case Observability_newPackage.ELEMENT__NAME:
				return getName();
			case Observability_newPackage.ELEMENT__VALUE:
				return getValue();
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
			case Observability_newPackage.ELEMENT__HAS_ELEMENTS:
				getHasElements().clear();
				getHasElements().addAll((Collection<? extends Element>)newValue);
				return;
			case Observability_newPackage.ELEMENT__HAS_KEY_VALUES:
				getHasKeyValues().clear();
				getHasKeyValues().addAll((Collection<? extends KeyValue>)newValue);
				return;
			case Observability_newPackage.ELEMENT__NAME:
				setName((String)newValue);
				return;
			case Observability_newPackage.ELEMENT__VALUE:
				setValue((String)newValue);
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
			case Observability_newPackage.ELEMENT__HAS_ELEMENTS:
				getHasElements().clear();
				return;
			case Observability_newPackage.ELEMENT__HAS_KEY_VALUES:
				getHasKeyValues().clear();
				return;
			case Observability_newPackage.ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Observability_newPackage.ELEMENT__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case Observability_newPackage.ELEMENT__HAS_ELEMENTS:
				return hasElements != null && !hasElements.isEmpty();
			case Observability_newPackage.ELEMENT__HAS_KEY_VALUES:
				return hasKeyValues != null && !hasKeyValues.isEmpty();
			case Observability_newPackage.ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Observability_newPackage.ELEMENT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ElementImpl
