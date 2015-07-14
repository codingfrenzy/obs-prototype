/**
 */
package com.observability.modeling.emf.impl;

import com.observability.modeling.emf.EmfPackage;
import com.observability.modeling.emf.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#getFailureMax <em>Failure Max</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#getFailureMin <em>Failure Min</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#getWarningMax <em>Warning Max</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#getWarningMin <em>Warning Min</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#isInvert <em>Invert</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#isPersist <em>Persist</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#isPercentage <em>Percentage</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#getHits <em>Hits</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#getHysteresis <em>Hysteresis</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#isPersistOk <em>Persist Ok</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#isInteresting <em>Interesting</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.NotificationImpl#getInstance <em>Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotificationImpl extends MinimalEObjectImpl.Container implements Notification {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFailureMax() <em>Failure Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureMax()
	 * @generated
	 * @ordered
	 */
	protected static final double FAILURE_MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFailureMax() <em>Failure Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureMax()
	 * @generated
	 * @ordered
	 */
	protected double failureMax = FAILURE_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getFailureMin() <em>Failure Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureMin()
	 * @generated
	 * @ordered
	 */
	protected static final double FAILURE_MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFailureMin() <em>Failure Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureMin()
	 * @generated
	 * @ordered
	 */
	protected double failureMin = FAILURE_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getWarningMax() <em>Warning Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarningMax()
	 * @generated
	 * @ordered
	 */
	protected static final double WARNING_MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWarningMax() <em>Warning Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarningMax()
	 * @generated
	 * @ordered
	 */
	protected double warningMax = WARNING_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getWarningMin() <em>Warning Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarningMin()
	 * @generated
	 * @ordered
	 */
	protected static final double WARNING_MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWarningMin() <em>Warning Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarningMin()
	 * @generated
	 * @ordered
	 */
	protected double warningMin = WARNING_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataSource() <em>Data Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSource()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataSource() <em>Data Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSource()
	 * @generated
	 * @ordered
	 */
	protected String dataSource = DATA_SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isInvert() <em>Invert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInvert()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INVERT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInvert() <em>Invert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInvert()
	 * @generated
	 * @ordered
	 */
	protected boolean invert = INVERT_EDEFAULT;

	/**
	 * The default value of the '{@link #isPersist() <em>Persist</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPersist()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PERSIST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPersist() <em>Persist</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPersist()
	 * @generated
	 * @ordered
	 */
	protected boolean persist = PERSIST_EDEFAULT;

	/**
	 * The default value of the '{@link #isPercentage() <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PERCENTAGE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPercentage() <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPercentage()
	 * @generated
	 * @ordered
	 */
	protected boolean percentage = PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHits() <em>Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHits()
	 * @generated
	 * @ordered
	 */
	protected static final int HITS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getHits() <em>Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHits()
	 * @generated
	 * @ordered
	 */
	protected int hits = HITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getHysteresis() <em>Hysteresis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHysteresis()
	 * @generated
	 * @ordered
	 */
	protected static final int HYSTERESIS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHysteresis() <em>Hysteresis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHysteresis()
	 * @generated
	 * @ordered
	 */
	protected int hysteresis = HYSTERESIS_EDEFAULT;

	/**
	 * The default value of the '{@link #isPersistOk() <em>Persist Ok</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPersistOk()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PERSIST_OK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPersistOk() <em>Persist Ok</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPersistOk()
	 * @generated
	 * @ordered
	 */
	protected boolean persistOk = PERSIST_OK_EDEFAULT;

	/**
	 * The default value of the '{@link #isInteresting() <em>Interesting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInteresting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INTERESTING_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isInteresting() <em>Interesting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInteresting()
	 * @generated
	 * @ordered
	 */
	protected boolean interesting = INTERESTING_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstance() <em>Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected String instance = INSTANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfPackage.Literals.NOTIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFailureMax() {
		return failureMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureMax(double newFailureMax) {
		double oldFailureMax = failureMax;
		failureMax = newFailureMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__FAILURE_MAX, oldFailureMax, failureMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFailureMin() {
		return failureMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureMin(double newFailureMin) {
		double oldFailureMin = failureMin;
		failureMin = newFailureMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__FAILURE_MIN, oldFailureMin, failureMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWarningMax() {
		return warningMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarningMax(double newWarningMax) {
		double oldWarningMax = warningMax;
		warningMax = newWarningMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__WARNING_MAX, oldWarningMax, warningMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWarningMin() {
		return warningMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarningMin(double newWarningMin) {
		double oldWarningMin = warningMin;
		warningMin = newWarningMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__WARNING_MIN, oldWarningMin, warningMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataSource() {
		return dataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataSource(String newDataSource) {
		String oldDataSource = dataSource;
		dataSource = newDataSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__DATA_SOURCE, oldDataSource, dataSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInvert() {
		return invert;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvert(boolean newInvert) {
		boolean oldInvert = invert;
		invert = newInvert;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__INVERT, oldInvert, invert));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPersist() {
		return persist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersist(boolean newPersist) {
		boolean oldPersist = persist;
		persist = newPersist;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__PERSIST, oldPersist, persist));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPercentage() {
		return percentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPercentage(boolean newPercentage) {
		boolean oldPercentage = percentage;
		percentage = newPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__PERCENTAGE, oldPercentage, percentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHits(int newHits) {
		int oldHits = hits;
		hits = newHits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__HITS, oldHits, hits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHysteresis() {
		return hysteresis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHysteresis(int newHysteresis) {
		int oldHysteresis = hysteresis;
		hysteresis = newHysteresis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__HYSTERESIS, oldHysteresis, hysteresis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPersistOk() {
		return persistOk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistOk(boolean newPersistOk) {
		boolean oldPersistOk = persistOk;
		persistOk = newPersistOk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__PERSIST_OK, oldPersistOk, persistOk));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInteresting() {
		return interesting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteresting(boolean newInteresting) {
		boolean oldInteresting = interesting;
		interesting = newInteresting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__INTERESTING, oldInteresting, interesting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstance() {
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstance(String newInstance) {
		String oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, EmfPackage.NOTIFICATION__INSTANCE, oldInstance, instance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfPackage.NOTIFICATION__TYPE:
				return getType();
			case EmfPackage.NOTIFICATION__FAILURE_MAX:
				return getFailureMax();
			case EmfPackage.NOTIFICATION__FAILURE_MIN:
				return getFailureMin();
			case EmfPackage.NOTIFICATION__WARNING_MAX:
				return getWarningMax();
			case EmfPackage.NOTIFICATION__WARNING_MIN:
				return getWarningMin();
			case EmfPackage.NOTIFICATION__DATA_SOURCE:
				return getDataSource();
			case EmfPackage.NOTIFICATION__INVERT:
				return isInvert();
			case EmfPackage.NOTIFICATION__PERSIST:
				return isPersist();
			case EmfPackage.NOTIFICATION__PERCENTAGE:
				return isPercentage();
			case EmfPackage.NOTIFICATION__HITS:
				return getHits();
			case EmfPackage.NOTIFICATION__HYSTERESIS:
				return getHysteresis();
			case EmfPackage.NOTIFICATION__PERSIST_OK:
				return isPersistOk();
			case EmfPackage.NOTIFICATION__INTERESTING:
				return isInteresting();
			case EmfPackage.NOTIFICATION__INSTANCE:
				return getInstance();
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
			case EmfPackage.NOTIFICATION__TYPE:
				setType((String)newValue);
				return;
			case EmfPackage.NOTIFICATION__FAILURE_MAX:
				setFailureMax((Double)newValue);
				return;
			case EmfPackage.NOTIFICATION__FAILURE_MIN:
				setFailureMin((Double)newValue);
				return;
			case EmfPackage.NOTIFICATION__WARNING_MAX:
				setWarningMax((Double)newValue);
				return;
			case EmfPackage.NOTIFICATION__WARNING_MIN:
				setWarningMin((Double)newValue);
				return;
			case EmfPackage.NOTIFICATION__DATA_SOURCE:
				setDataSource((String)newValue);
				return;
			case EmfPackage.NOTIFICATION__INVERT:
				setInvert((Boolean)newValue);
				return;
			case EmfPackage.NOTIFICATION__PERSIST:
				setPersist((Boolean)newValue);
				return;
			case EmfPackage.NOTIFICATION__PERCENTAGE:
				setPercentage((Boolean)newValue);
				return;
			case EmfPackage.NOTIFICATION__HITS:
				setHits((Integer)newValue);
				return;
			case EmfPackage.NOTIFICATION__HYSTERESIS:
				setHysteresis((Integer)newValue);
				return;
			case EmfPackage.NOTIFICATION__PERSIST_OK:
				setPersistOk((Boolean)newValue);
				return;
			case EmfPackage.NOTIFICATION__INTERESTING:
				setInteresting((Boolean)newValue);
				return;
			case EmfPackage.NOTIFICATION__INSTANCE:
				setInstance((String)newValue);
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
			case EmfPackage.NOTIFICATION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__FAILURE_MAX:
				setFailureMax(FAILURE_MAX_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__FAILURE_MIN:
				setFailureMin(FAILURE_MIN_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__WARNING_MAX:
				setWarningMax(WARNING_MAX_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__WARNING_MIN:
				setWarningMin(WARNING_MIN_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__DATA_SOURCE:
				setDataSource(DATA_SOURCE_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__INVERT:
				setInvert(INVERT_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__PERSIST:
				setPersist(PERSIST_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__PERCENTAGE:
				setPercentage(PERCENTAGE_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__HITS:
				setHits(HITS_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__HYSTERESIS:
				setHysteresis(HYSTERESIS_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__PERSIST_OK:
				setPersistOk(PERSIST_OK_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__INTERESTING:
				setInteresting(INTERESTING_EDEFAULT);
				return;
			case EmfPackage.NOTIFICATION__INSTANCE:
				setInstance(INSTANCE_EDEFAULT);
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
			case EmfPackage.NOTIFICATION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case EmfPackage.NOTIFICATION__FAILURE_MAX:
				return failureMax != FAILURE_MAX_EDEFAULT;
			case EmfPackage.NOTIFICATION__FAILURE_MIN:
				return failureMin != FAILURE_MIN_EDEFAULT;
			case EmfPackage.NOTIFICATION__WARNING_MAX:
				return warningMax != WARNING_MAX_EDEFAULT;
			case EmfPackage.NOTIFICATION__WARNING_MIN:
				return warningMin != WARNING_MIN_EDEFAULT;
			case EmfPackage.NOTIFICATION__DATA_SOURCE:
				return DATA_SOURCE_EDEFAULT == null ? dataSource != null : !DATA_SOURCE_EDEFAULT.equals(dataSource);
			case EmfPackage.NOTIFICATION__INVERT:
				return invert != INVERT_EDEFAULT;
			case EmfPackage.NOTIFICATION__PERSIST:
				return persist != PERSIST_EDEFAULT;
			case EmfPackage.NOTIFICATION__PERCENTAGE:
				return percentage != PERCENTAGE_EDEFAULT;
			case EmfPackage.NOTIFICATION__HITS:
				return hits != HITS_EDEFAULT;
			case EmfPackage.NOTIFICATION__HYSTERESIS:
				return hysteresis != HYSTERESIS_EDEFAULT;
			case EmfPackage.NOTIFICATION__PERSIST_OK:
				return persistOk != PERSIST_OK_EDEFAULT;
			case EmfPackage.NOTIFICATION__INTERESTING:
				return interesting != INTERESTING_EDEFAULT;
			case EmfPackage.NOTIFICATION__INSTANCE:
				return INSTANCE_EDEFAULT == null ? instance != null : !INSTANCE_EDEFAULT.equals(instance);
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
		result.append(" (type: ");
		result.append(type);
		result.append(", failureMax: ");
		result.append(failureMax);
		result.append(", failureMin: ");
		result.append(failureMin);
		result.append(", warningMax: ");
		result.append(warningMax);
		result.append(", warningMin: ");
		result.append(warningMin);
		result.append(", dataSource: ");
		result.append(dataSource);
		result.append(", invert: ");
		result.append(invert);
		result.append(", persist: ");
		result.append(persist);
		result.append(", percentage: ");
		result.append(percentage);
		result.append(", hits: ");
		result.append(hits);
		result.append(", hysteresis: ");
		result.append(hysteresis);
		result.append(", persistOk: ");
		result.append(persistOk);
		result.append(", interesting: ");
		result.append(interesting);
		result.append(", instance: ");
		result.append(instance);
		result.append(')');
		return result.toString();
	}

} //NotificationImpl
