/**
 */
package observability_new.impl;

import java.util.Collection;

import observability_new.BaseMetric;
import observability_new.DatabaseCluster;
import observability_new.Element;
import observability_new.Observability_newPackage;

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
 *   <li>{@link observability_new.impl.BaseMetricImpl#getDatabaseCluster <em>Database Cluster</em>}</li>
 *   <li>{@link observability_new.impl.BaseMetricImpl#getHasParentElement <em>Has Parent Element</em>}</li>
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
		return Observability_newPackage.Literals.BASE_METRIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DatabaseCluster> getDatabaseCluster() {
		if (databaseCluster == null) {
			databaseCluster = new EObjectWithInverseResolvingEList.ManyInverse<DatabaseCluster>(DatabaseCluster.class, this, Observability_newPackage.BASE_METRIC__DATABASE_CLUSTER, Observability_newPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC);
		}
		return databaseCluster;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Observability_newPackage.BASE_METRIC__HAS_PARENT_ELEMENT, oldHasParentElement, hasParentElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_newPackage.BASE_METRIC__HAS_PARENT_ELEMENT, oldHasParentElement, hasParentElement));
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
			case Observability_newPackage.BASE_METRIC__DATABASE_CLUSTER:
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
			case Observability_newPackage.BASE_METRIC__DATABASE_CLUSTER:
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
			case Observability_newPackage.BASE_METRIC__DATABASE_CLUSTER:
				return getDatabaseCluster();
			case Observability_newPackage.BASE_METRIC__HAS_PARENT_ELEMENT:
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
			case Observability_newPackage.BASE_METRIC__DATABASE_CLUSTER:
				getDatabaseCluster().clear();
				getDatabaseCluster().addAll((Collection<? extends DatabaseCluster>)newValue);
				return;
			case Observability_newPackage.BASE_METRIC__HAS_PARENT_ELEMENT:
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
			case Observability_newPackage.BASE_METRIC__DATABASE_CLUSTER:
				getDatabaseCluster().clear();
				return;
			case Observability_newPackage.BASE_METRIC__HAS_PARENT_ELEMENT:
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
			case Observability_newPackage.BASE_METRIC__DATABASE_CLUSTER:
				return databaseCluster != null && !databaseCluster.isEmpty();
			case Observability_newPackage.BASE_METRIC__HAS_PARENT_ELEMENT:
				return hasParentElement != null;
		}
		return super.eIsSet(featureID);
	}

} //BaseMetricImpl
