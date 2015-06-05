/**
 */
package observability_new.impl;

import observability_new.DerivedMetric;
import observability_new.Element;
import observability_new.Observability_newPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Derived Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link observability_new.impl.DerivedMetricImpl#getHasParentElement <em>Has Parent Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DerivedMetricImpl extends MetricImpl implements DerivedMetric {
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
	protected DerivedMetricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Observability_newPackage.Literals.DERIVED_METRIC;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Observability_newPackage.DERIVED_METRIC__HAS_PARENT_ELEMENT, oldHasParentElement, hasParentElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.DERIVED_METRIC__HAS_PARENT_ELEMENT, oldHasParentElement, hasParentElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Observability_newPackage.DERIVED_METRIC__HAS_PARENT_ELEMENT:
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
			case Observability_newPackage.DERIVED_METRIC__HAS_PARENT_ELEMENT:
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
			case Observability_newPackage.DERIVED_METRIC__HAS_PARENT_ELEMENT:
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
			case Observability_newPackage.DERIVED_METRIC__HAS_PARENT_ELEMENT:
				return hasParentElement != null;
		}
		return super.eIsSet(featureID);
	}

} //DerivedMetricImpl
