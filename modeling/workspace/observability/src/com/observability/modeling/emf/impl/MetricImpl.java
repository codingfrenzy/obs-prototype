/**
 */
package com.observability.modeling.emf.impl;

import com.observability.modeling.emf.DatabaseCluster;
import com.observability.modeling.emf.Element;
import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.KeyValue;
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
 * An implementation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.observability.modeling.emf.impl.MetricImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.MetricImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.MetricImpl#getKeyValues <em>Key Values</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.MetricImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.MetricImpl#getDatabaseCluster <em>Database Cluster</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MetricImpl extends MinimalEObjectImpl.Container implements Metric {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getKeyValues() <em>Key Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyValues()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyValue> keyValues;

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
	 * The cached value of the '{@link #getDatabaseCluster() <em>Database Cluster</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabaseCluster()
	 * @generated
	 * @ordered
	 */
	protected DatabaseCluster databaseCluster;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfPackage.Literals.METRIC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.METRIC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.METRIC__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KeyValue> getKeyValues() {
		if (keyValues == null) {
			keyValues = new EObjectContainmentEList<KeyValue>(KeyValue.class, this, EmfPackage.METRIC__KEY_VALUES);
		}
		return keyValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<Element>(Element.class, this, EmfPackage.METRIC__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseCluster getDatabaseCluster() {
		if (databaseCluster != null && databaseCluster.eIsProxy()) {
			InternalEObject oldDatabaseCluster = (InternalEObject)databaseCluster;
			databaseCluster = (DatabaseCluster)eResolveProxy(oldDatabaseCluster);
			if (databaseCluster != oldDatabaseCluster) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfPackage.METRIC__DATABASE_CLUSTER, oldDatabaseCluster, databaseCluster));
			}
		}
		return databaseCluster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseCluster basicGetDatabaseCluster() {
		return databaseCluster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDatabaseCluster(DatabaseCluster newDatabaseCluster, NotificationChain msgs) {
		DatabaseCluster oldDatabaseCluster = databaseCluster;
		databaseCluster = newDatabaseCluster;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfPackage.METRIC__DATABASE_CLUSTER, oldDatabaseCluster, newDatabaseCluster);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatabaseCluster(DatabaseCluster newDatabaseCluster) {
		if (newDatabaseCluster != databaseCluster) {
			NotificationChain msgs = null;
			if (databaseCluster != null)
				msgs = ((InternalEObject)databaseCluster).eInverseRemove(this, EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS, DatabaseCluster.class, msgs);
			if (newDatabaseCluster != null)
				msgs = ((InternalEObject)newDatabaseCluster).eInverseAdd(this, EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS, DatabaseCluster.class, msgs);
			msgs = basicSetDatabaseCluster(newDatabaseCluster, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.METRIC__DATABASE_CLUSTER, newDatabaseCluster, newDatabaseCluster));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfPackage.METRIC__DATABASE_CLUSTER:
				if (databaseCluster != null)
					msgs = ((InternalEObject)databaseCluster).eInverseRemove(this, EmfPackage.DATABASE_CLUSTER__COLLECTED_METRICS, DatabaseCluster.class, msgs);
				return basicSetDatabaseCluster((DatabaseCluster)otherEnd, msgs);
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
			case EmfPackage.METRIC__KEY_VALUES:
				return ((InternalEList<?>)getKeyValues()).basicRemove(otherEnd, msgs);
			case EmfPackage.METRIC__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case EmfPackage.METRIC__DATABASE_CLUSTER:
				return basicSetDatabaseCluster(null, msgs);
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
			case EmfPackage.METRIC__NAME:
				return getName();
			case EmfPackage.METRIC__DESCRIPTION:
				return getDescription();
			case EmfPackage.METRIC__KEY_VALUES:
				return getKeyValues();
			case EmfPackage.METRIC__ELEMENTS:
				return getElements();
			case EmfPackage.METRIC__DATABASE_CLUSTER:
				if (resolve) return getDatabaseCluster();
				return basicGetDatabaseCluster();
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
			case EmfPackage.METRIC__NAME:
				setName((String)newValue);
				return;
			case EmfPackage.METRIC__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case EmfPackage.METRIC__KEY_VALUES:
				getKeyValues().clear();
				getKeyValues().addAll((Collection<? extends KeyValue>)newValue);
				return;
			case EmfPackage.METRIC__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends Element>)newValue);
				return;
			case EmfPackage.METRIC__DATABASE_CLUSTER:
				setDatabaseCluster((DatabaseCluster)newValue);
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
			case EmfPackage.METRIC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmfPackage.METRIC__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case EmfPackage.METRIC__KEY_VALUES:
				getKeyValues().clear();
				return;
			case EmfPackage.METRIC__ELEMENTS:
				getElements().clear();
				return;
			case EmfPackage.METRIC__DATABASE_CLUSTER:
				setDatabaseCluster((DatabaseCluster)null);
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
			case EmfPackage.METRIC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmfPackage.METRIC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case EmfPackage.METRIC__KEY_VALUES:
				return keyValues != null && !keyValues.isEmpty();
			case EmfPackage.METRIC__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case EmfPackage.METRIC__DATABASE_CLUSTER:
				return databaseCluster != null;
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
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //MetricImpl
