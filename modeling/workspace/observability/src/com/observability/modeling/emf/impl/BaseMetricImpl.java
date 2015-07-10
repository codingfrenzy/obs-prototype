/**
 */
package com.observability.modeling.emf.impl;

import com.observability.modeling.emf.BaseMetric;
import com.observability.modeling.emf.DatabaseCluster;
import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.observability.modeling.emf.impl.BaseMetricImpl#getDatabaseCluster <em>Database Cluster</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.BaseMetricImpl#getHasParentElement <em>Has Parent Element</em>}</li>
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
	 * The cached value of the '{@link #getHasParentElement() <em>Has Parent Element</em>}' containment reference.
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
		return EmfPackage.Literals.BASE_METRIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DatabaseCluster> getDatabaseCluster() {
		if (databaseCluster == null) {
			databaseCluster = new EObjectWithInverseResolvingEList.ManyInverse<DatabaseCluster>(DatabaseCluster.class, this, EmfPackage.BASE_METRIC__DATABASE_CLUSTER, EmfPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC);
		}
		return databaseCluster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getHasParentElement() {
		return hasParentElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHasParentElement(Element newHasParentElement, NotificationChain msgs) {
		Element oldHasParentElement = hasParentElement;
		hasParentElement = newHasParentElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfPackage.BASE_METRIC__HAS_PARENT_ELEMENT, oldHasParentElement, newHasParentElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasParentElement(Element newHasParentElement) {
		if (newHasParentElement != hasParentElement) {
			NotificationChain msgs = null;
			if (hasParentElement != null)
				msgs = ((InternalEObject)hasParentElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfPackage.BASE_METRIC__HAS_PARENT_ELEMENT, null, msgs);
			if (newHasParentElement != null)
				msgs = ((InternalEObject)newHasParentElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfPackage.BASE_METRIC__HAS_PARENT_ELEMENT, null, msgs);
			msgs = basicSetHasParentElement(newHasParentElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.BASE_METRIC__HAS_PARENT_ELEMENT, newHasParentElement, newHasParentElement));
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
			case EmfPackage.BASE_METRIC__DATABASE_CLUSTER:
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
			case EmfPackage.BASE_METRIC__DATABASE_CLUSTER:
				return ((InternalEList<?>)getDatabaseCluster()).basicRemove(otherEnd, msgs);
			case EmfPackage.BASE_METRIC__HAS_PARENT_ELEMENT:
				return basicSetHasParentElement(null, msgs);
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
			case EmfPackage.BASE_METRIC__DATABASE_CLUSTER:
				return getDatabaseCluster();
			case EmfPackage.BASE_METRIC__HAS_PARENT_ELEMENT:
				return getHasParentElement();
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
			case EmfPackage.BASE_METRIC__DATABASE_CLUSTER:
				getDatabaseCluster().clear();
				getDatabaseCluster().addAll((Collection<? extends DatabaseCluster>)newValue);
				return;
			case EmfPackage.BASE_METRIC__HAS_PARENT_ELEMENT:
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
			case EmfPackage.BASE_METRIC__DATABASE_CLUSTER:
				getDatabaseCluster().clear();
				return;
			case EmfPackage.BASE_METRIC__HAS_PARENT_ELEMENT:
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
			case EmfPackage.BASE_METRIC__DATABASE_CLUSTER:
				return databaseCluster != null && !databaseCluster.isEmpty();
			case EmfPackage.BASE_METRIC__HAS_PARENT_ELEMENT:
				return hasParentElement != null;
		}
		return super.eIsSet(featureID);
	}

} //BaseMetricImpl