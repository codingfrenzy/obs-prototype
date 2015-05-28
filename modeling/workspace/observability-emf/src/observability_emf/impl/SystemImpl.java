/**
 */
package observability_emf.impl;

import observability_emf.Model;
import observability_emf.Observability_emfPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link observability_emf.impl.SystemImpl#getHasModel <em>Has Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends MinimalEObjectImpl.Container implements observability_emf.System {
	/**
	 * The cached value of the '{@link #getHasModel() <em>Has Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasModel()
	 * @generated
	 * @ordered
	 */
	protected Model hasModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Observability_emfPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getHasModel() {
		return hasModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHasModel(Model newHasModel, NotificationChain msgs) {
		Model oldHasModel = hasModel;
		hasModel = newHasModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Observability_emfPackage.SYSTEM__HAS_MODEL, oldHasModel, newHasModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasModel(Model newHasModel) {
		if (newHasModel != hasModel) {
			NotificationChain msgs = null;
			if (hasModel != null)
				msgs = ((InternalEObject)hasModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Observability_emfPackage.SYSTEM__HAS_MODEL, null, msgs);
			if (newHasModel != null)
				msgs = ((InternalEObject)newHasModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Observability_emfPackage.SYSTEM__HAS_MODEL, null, msgs);
			msgs = basicSetHasModel(newHasModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_emfPackage.SYSTEM__HAS_MODEL, newHasModel, newHasModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Observability_emfPackage.SYSTEM__HAS_MODEL:
				return basicSetHasModel(null, msgs);
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
			case Observability_emfPackage.SYSTEM__HAS_MODEL:
				return getHasModel();
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
			case Observability_emfPackage.SYSTEM__HAS_MODEL:
				setHasModel((Model)newValue);
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
			case Observability_emfPackage.SYSTEM__HAS_MODEL:
				setHasModel((Model)null);
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
			case Observability_emfPackage.SYSTEM__HAS_MODEL:
				return hasModel != null;
		}
		return super.eIsSet(featureID);
	}

} //SystemImpl
