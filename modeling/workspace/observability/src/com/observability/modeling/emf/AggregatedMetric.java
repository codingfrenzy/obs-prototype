/**
 */
package com.observability.modeling.emf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregated Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.observability.modeling.emf.AggregatedMetric#isCalculateSum <em>Calculate Sum</em>}</li>
 *   <li>{@link com.observability.modeling.emf.AggregatedMetric#isCalculateNum <em>Calculate Num</em>}</li>
 *   <li>{@link com.observability.modeling.emf.AggregatedMetric#isCalculateAvg <em>Calculate Avg</em>}</li>
 *   <li>{@link com.observability.modeling.emf.AggregatedMetric#isCalculateMin <em>Calculate Min</em>}</li>
 *   <li>{@link com.observability.modeling.emf.AggregatedMetric#isCalculateMax <em>Calculate Max</em>}</li>
 *   <li>{@link com.observability.modeling.emf.AggregatedMetric#isCalculateStddev <em>Calculate Stddev</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.observability.modeling.emf.EmfPackage#getAggregatedMetric()
 * @model
 * @generated
 */
public interface AggregatedMetric extends Metric {
	/**
	 * Returns the value of the '<em><b>Calculate Sum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calculate Sum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calculate Sum</em>' attribute.
	 * @see #setCalculateSum(boolean)
	 * @see com.observability.modeling.emf.EmfPackage#getAggregatedMetric_CalculateSum()
	 * @model
	 * @generated
	 */
	boolean isCalculateSum();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.AggregatedMetric#isCalculateSum <em>Calculate Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calculate Sum</em>' attribute.
	 * @see #isCalculateSum()
	 * @generated
	 */
	void setCalculateSum(boolean value);

	/**
	 * Returns the value of the '<em><b>Calculate Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calculate Num</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calculate Num</em>' attribute.
	 * @see #setCalculateNum(boolean)
	 * @see com.observability.modeling.emf.EmfPackage#getAggregatedMetric_CalculateNum()
	 * @model
	 * @generated
	 */
	boolean isCalculateNum();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.AggregatedMetric#isCalculateNum <em>Calculate Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calculate Num</em>' attribute.
	 * @see #isCalculateNum()
	 * @generated
	 */
	void setCalculateNum(boolean value);

	/**
	 * Returns the value of the '<em><b>Calculate Avg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calculate Avg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calculate Avg</em>' attribute.
	 * @see #setCalculateAvg(boolean)
	 * @see com.observability.modeling.emf.EmfPackage#getAggregatedMetric_CalculateAvg()
	 * @model
	 * @generated
	 */
	boolean isCalculateAvg();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.AggregatedMetric#isCalculateAvg <em>Calculate Avg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calculate Avg</em>' attribute.
	 * @see #isCalculateAvg()
	 * @generated
	 */
	void setCalculateAvg(boolean value);

	/**
	 * Returns the value of the '<em><b>Calculate Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calculate Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calculate Min</em>' attribute.
	 * @see #setCalculateMin(boolean)
	 * @see com.observability.modeling.emf.EmfPackage#getAggregatedMetric_CalculateMin()
	 * @model
	 * @generated
	 */
	boolean isCalculateMin();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.AggregatedMetric#isCalculateMin <em>Calculate Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calculate Min</em>' attribute.
	 * @see #isCalculateMin()
	 * @generated
	 */
	void setCalculateMin(boolean value);

	/**
	 * Returns the value of the '<em><b>Calculate Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calculate Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calculate Max</em>' attribute.
	 * @see #setCalculateMax(boolean)
	 * @see com.observability.modeling.emf.EmfPackage#getAggregatedMetric_CalculateMax()
	 * @model
	 * @generated
	 */
	boolean isCalculateMax();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.AggregatedMetric#isCalculateMax <em>Calculate Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calculate Max</em>' attribute.
	 * @see #isCalculateMax()
	 * @generated
	 */
	void setCalculateMax(boolean value);

	/**
	 * Returns the value of the '<em><b>Calculate Stddev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calculate Stddev</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calculate Stddev</em>' attribute.
	 * @see #setCalculateStddev(boolean)
	 * @see com.observability.modeling.emf.EmfPackage#getAggregatedMetric_CalculateStddev()
	 * @model
	 * @generated
	 */
	boolean isCalculateStddev();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.AggregatedMetric#isCalculateStddev <em>Calculate Stddev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calculate Stddev</em>' attribute.
	 * @see #isCalculateStddev()
	 * @generated
	 */
	void setCalculateStddev(boolean value);

} // AggregatedMetric
