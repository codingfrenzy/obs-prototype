/**
 */
package com.observability.modeling.emf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.observability.modeling.emf.Notification#getType <em>Type</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#getFailureMax <em>Failure Max</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#getFailureMin <em>Failure Min</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#getWarningMax <em>Warning Max</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#getWarningMin <em>Warning Min</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#isInvert <em>Invert</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#isPersist <em>Persist</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#isPercentage <em>Percentage</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#getHits <em>Hits</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#getHysteresis <em>Hysteresis</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#isPersistOk <em>Persist Ok</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#isInteresting <em>Interesting</em>}</li>
 *   <li>{@link com.observability.modeling.emf.Notification#getInstance <em>Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.observability.modeling.emf.EmfPackage#getNotification()
 * @model
 * @generated
 */
public interface Notification extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_Type()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Failure Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Max</em>' attribute.
	 * @see #setFailureMax(double)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_FailureMax()
	 * @model
	 * @generated
	 */
	double getFailureMax();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#getFailureMax <em>Failure Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Max</em>' attribute.
	 * @see #getFailureMax()
	 * @generated
	 */
	void setFailureMax(double value);

	/**
	 * Returns the value of the '<em><b>Failure Min</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Min</em>' attribute.
	 * @see #setFailureMin(double)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_FailureMin()
	 * @model default="0.0"
	 * @generated
	 */
	double getFailureMin();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#getFailureMin <em>Failure Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Min</em>' attribute.
	 * @see #getFailureMin()
	 * @generated
	 */
	void setFailureMin(double value);

	/**
	 * Returns the value of the '<em><b>Warning Max</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warning Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warning Max</em>' attribute.
	 * @see #setWarningMax(double)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_WarningMax()
	 * @model default="0.0"
	 * @generated
	 */
	double getWarningMax();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#getWarningMax <em>Warning Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warning Max</em>' attribute.
	 * @see #getWarningMax()
	 * @generated
	 */
	void setWarningMax(double value);

	/**
	 * Returns the value of the '<em><b>Warning Min</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warning Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warning Min</em>' attribute.
	 * @see #setWarningMin(double)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_WarningMin()
	 * @model default="0.0"
	 * @generated
	 */
	double getWarningMin();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#getWarningMin <em>Warning Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warning Min</em>' attribute.
	 * @see #getWarningMin()
	 * @generated
	 */
	void setWarningMin(double value);

	/**
	 * Returns the value of the '<em><b>Data Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source</em>' attribute.
	 * @see #setDataSource(String)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_DataSource()
	 * @model
	 * @generated
	 */
	String getDataSource();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#getDataSource <em>Data Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source</em>' attribute.
	 * @see #getDataSource()
	 * @generated
	 */
	void setDataSource(String value);

	/**
	 * Returns the value of the '<em><b>Invert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invert</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invert</em>' attribute.
	 * @see #setInvert(boolean)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_Invert()
	 * @model
	 * @generated
	 */
	boolean isInvert();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#isInvert <em>Invert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invert</em>' attribute.
	 * @see #isInvert()
	 * @generated
	 */
	void setInvert(boolean value);

	/**
	 * Returns the value of the '<em><b>Persist</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persist</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persist</em>' attribute.
	 * @see #setPersist(boolean)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_Persist()
	 * @model
	 * @generated
	 */
	boolean isPersist();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#isPersist <em>Persist</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persist</em>' attribute.
	 * @see #isPersist()
	 * @generated
	 */
	void setPersist(boolean value);

	/**
	 * Returns the value of the '<em><b>Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percentage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percentage</em>' attribute.
	 * @see #setPercentage(boolean)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_Percentage()
	 * @model
	 * @generated
	 */
	boolean isPercentage();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#isPercentage <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percentage</em>' attribute.
	 * @see #isPercentage()
	 * @generated
	 */
	void setPercentage(boolean value);

	/**
	 * Returns the value of the '<em><b>Hits</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hits</em>' attribute.
	 * @see #setHits(int)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_Hits()
	 * @model default="1"
	 * @generated
	 */
	int getHits();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#getHits <em>Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hits</em>' attribute.
	 * @see #getHits()
	 * @generated
	 */
	void setHits(int value);

	/**
	 * Returns the value of the '<em><b>Hysteresis</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hysteresis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hysteresis</em>' attribute.
	 * @see #setHysteresis(int)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_Hysteresis()
	 * @model default="0"
	 * @generated
	 */
	int getHysteresis();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#getHysteresis <em>Hysteresis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hysteresis</em>' attribute.
	 * @see #getHysteresis()
	 * @generated
	 */
	void setHysteresis(int value);

	/**
	 * Returns the value of the '<em><b>Persist Ok</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persist Ok</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persist Ok</em>' attribute.
	 * @see #setPersistOk(boolean)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_PersistOk()
	 * @model default="false"
	 * @generated
	 */
	boolean isPersistOk();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#isPersistOk <em>Persist Ok</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persist Ok</em>' attribute.
	 * @see #isPersistOk()
	 * @generated
	 */
	void setPersistOk(boolean value);

	/**
	 * Returns the value of the '<em><b>Interesting</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interesting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interesting</em>' attribute.
	 * @see #setInteresting(boolean)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_Interesting()
	 * @model default="true"
	 * @generated
	 */
	boolean isInteresting();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#isInteresting <em>Interesting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interesting</em>' attribute.
	 * @see #isInteresting()
	 * @generated
	 */
	void setInteresting(boolean value);

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' attribute.
	 * @see #setInstance(String)
	 * @see com.observability.modeling.emf.EmfPackage#getNotification_Instance()
	 * @model
	 * @generated
	 */
	String getInstance();

	/**
	 * Sets the value of the '{@link com.observability.modeling.emf.Notification#getInstance <em>Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' attribute.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(String value);

} // Notification
