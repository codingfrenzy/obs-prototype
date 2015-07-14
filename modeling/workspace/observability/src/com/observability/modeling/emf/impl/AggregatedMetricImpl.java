/**
 */
package com.observability.modeling.emf.impl;

import com.observability.modeling.emf.AggregatedMetric;
import com.observability.modeling.emf.EmfPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregated Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.observability.modeling.emf.impl.AggregatedMetricImpl#isCalculateSum <em>Calculate Sum</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.AggregatedMetricImpl#isCalculateNum <em>Calculate Num</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.AggregatedMetricImpl#isCalculateAvg <em>Calculate Avg</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.AggregatedMetricImpl#isCalculateMin <em>Calculate Min</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.AggregatedMetricImpl#isCalculateMax <em>Calculate Max</em>}</li>
 *   <li>{@link com.observability.modeling.emf.impl.AggregatedMetricImpl#isCalculateStddev <em>Calculate Stddev</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AggregatedMetricImpl extends MetricImpl implements AggregatedMetric {
	/**
	 * The default value of the '{@link #isCalculateSum() <em>Calculate Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalculateSum()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CALCULATE_SUM_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCalculateSum() <em>Calculate Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalculateSum()
	 * @generated
	 * @ordered
	 */
	protected boolean calculateSum = CALCULATE_SUM_EDEFAULT;

	/**
	 * The default value of the '{@link #isCalculateNum() <em>Calculate Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalculateNum()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CALCULATE_NUM_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCalculateNum() <em>Calculate Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalculateNum()
	 * @generated
	 * @ordered
	 */
	protected boolean calculateNum = CALCULATE_NUM_EDEFAULT;

	/**
	 * The default value of the '{@link #isCalculateAvg() <em>Calculate Avg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalculateAvg()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CALCULATE_AVG_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCalculateAvg() <em>Calculate Avg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalculateAvg()
	 * @generated
	 * @ordered
	 */
	protected boolean calculateAvg = CALCULATE_AVG_EDEFAULT;

	/**
	 * The default value of the '{@link #isCalculateMin() <em>Calculate Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalculateMin()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CALCULATE_MIN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCalculateMin() <em>Calculate Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalculateMin()
	 * @generated
	 * @ordered
	 */
	protected boolean calculateMin = CALCULATE_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #isCalculateMax() <em>Calculate Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalculateMax()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CALCULATE_MAX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCalculateMax() <em>Calculate Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalculateMax()
	 * @generated
	 * @ordered
	 */
	protected boolean calculateMax = CALCULATE_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #isCalculateStddev() <em>Calculate Stddev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalculateStddev()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CALCULATE_STDDEV_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCalculateStddev() <em>Calculate Stddev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCalculateStddev()
	 * @generated
	 * @ordered
	 */
	protected boolean calculateStddev = CALCULATE_STDDEV_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatedMetricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfPackage.Literals.AGGREGATED_METRIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCalculateSum() {
		return calculateSum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalculateSum(boolean newCalculateSum) {
		boolean oldCalculateSum = calculateSum;
		calculateSum = newCalculateSum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.AGGREGATED_METRIC__CALCULATE_SUM, oldCalculateSum, calculateSum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCalculateNum() {
		return calculateNum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalculateNum(boolean newCalculateNum) {
		boolean oldCalculateNum = calculateNum;
		calculateNum = newCalculateNum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.AGGREGATED_METRIC__CALCULATE_NUM, oldCalculateNum, calculateNum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCalculateAvg() {
		return calculateAvg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalculateAvg(boolean newCalculateAvg) {
		boolean oldCalculateAvg = calculateAvg;
		calculateAvg = newCalculateAvg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.AGGREGATED_METRIC__CALCULATE_AVG, oldCalculateAvg, calculateAvg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCalculateMin() {
		return calculateMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalculateMin(boolean newCalculateMin) {
		boolean oldCalculateMin = calculateMin;
		calculateMin = newCalculateMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.AGGREGATED_METRIC__CALCULATE_MIN, oldCalculateMin, calculateMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCalculateMax() {
		return calculateMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalculateMax(boolean newCalculateMax) {
		boolean oldCalculateMax = calculateMax;
		calculateMax = newCalculateMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.AGGREGATED_METRIC__CALCULATE_MAX, oldCalculateMax, calculateMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCalculateStddev() {
		return calculateStddev;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalculateStddev(boolean newCalculateStddev) {
		boolean oldCalculateStddev = calculateStddev;
		calculateStddev = newCalculateStddev;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfPackage.AGGREGATED_METRIC__CALCULATE_STDDEV, oldCalculateStddev, calculateStddev));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_SUM:
				return isCalculateSum();
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_NUM:
				return isCalculateNum();
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_AVG:
				return isCalculateAvg();
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_MIN:
				return isCalculateMin();
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_MAX:
				return isCalculateMax();
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_STDDEV:
				return isCalculateStddev();
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
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_SUM:
				setCalculateSum((Boolean)newValue);
				return;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_NUM:
				setCalculateNum((Boolean)newValue);
				return;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_AVG:
				setCalculateAvg((Boolean)newValue);
				return;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_MIN:
				setCalculateMin((Boolean)newValue);
				return;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_MAX:
				setCalculateMax((Boolean)newValue);
				return;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_STDDEV:
				setCalculateStddev((Boolean)newValue);
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
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_SUM:
				setCalculateSum(CALCULATE_SUM_EDEFAULT);
				return;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_NUM:
				setCalculateNum(CALCULATE_NUM_EDEFAULT);
				return;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_AVG:
				setCalculateAvg(CALCULATE_AVG_EDEFAULT);
				return;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_MIN:
				setCalculateMin(CALCULATE_MIN_EDEFAULT);
				return;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_MAX:
				setCalculateMax(CALCULATE_MAX_EDEFAULT);
				return;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_STDDEV:
				setCalculateStddev(CALCULATE_STDDEV_EDEFAULT);
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
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_SUM:
				return calculateSum != CALCULATE_SUM_EDEFAULT;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_NUM:
				return calculateNum != CALCULATE_NUM_EDEFAULT;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_AVG:
				return calculateAvg != CALCULATE_AVG_EDEFAULT;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_MIN:
				return calculateMin != CALCULATE_MIN_EDEFAULT;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_MAX:
				return calculateMax != CALCULATE_MAX_EDEFAULT;
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_STDDEV:
				return calculateStddev != CALCULATE_STDDEV_EDEFAULT;
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
		result.append(" (calculateSum: ");
		result.append(calculateSum);
		result.append(", calculateNum: ");
		result.append(calculateNum);
		result.append(", calculateAvg: ");
		result.append(calculateAvg);
		result.append(", calculateMin: ");
		result.append(calculateMin);
		result.append(", calculateMax: ");
		result.append(calculateMax);
		result.append(", calculateStddev: ");
		result.append(calculateStddev);
		result.append(')');
		return result.toString();
	}

} //AggregatedMetricImpl
