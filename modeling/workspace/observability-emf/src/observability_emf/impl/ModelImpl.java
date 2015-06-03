/**
 */
package observability_emf.impl;

import java.util.Collection;

import observability_emf.DatabaseCluster;
import observability_emf.DbType;
import observability_emf.Model;
import observability_emf.Observability_emfFactory;
import observability_emf.Observability_emfPackage;

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
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link observability_emf.impl.ModelImpl#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link observability_emf.impl.ModelImpl#getClusters <em>Clusters</em>}</li>
 *   <li>{@link observability_emf.impl.ModelImpl#getAvailableDbTypes <em>Available Db Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model {
	/**
	 * The default value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * The default frequency of the model is 30 seconds. 
	 * <!-- end-user-doc -->
	 * @see #getFrequency()
	 *
	 * @ordered
	 */
	protected static final int FREQUENCY_EDEFAULT = 30;

	/**
	 * The cached value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrequency()
	 * @generated
	 * @ordered
	 */
	protected int frequency = FREQUENCY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getClusters() <em>Clusters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusters()
	 * @generated
	 * @ordered
	 */
	protected EList<DatabaseCluster> clusters;

	/**
	 * The cached value of the '{@link #getAvailableDbTypes() <em>Available Db Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableDbTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DbType> availableDbTypes;

	/**
	 * <!-- begin-user-doc -->
	 * Create an instance of the Model. Get all the Database types defined in the model
	 * and create their instances.
	 * <!-- end-user-doc -->
	 */
	protected ModelImpl() {
		super();
		
		// Check if the instances already exist.
		EList<DbType> availableDb = getAvailableDbTypes();
		if(availableDb.size() > 0){
			return;
		}
		
		
//		ArrayList<DbType> dbTypes = new ArrayList<>();
//		
//		// Create instance of DbType
		DbType dbType = Observability_emfFactory.eINSTANCE.createDbType();
		dbType.setName("Cassandra");
		
		getAvailableDbTypes().add(dbType);
		
		dbType = Observability_emfFactory.eINSTANCE.createDbType();
		dbType.setName("PostGres");
		
		getAvailableDbTypes().add(dbType);
//		// Add the instance to the collection
//		dbTypes.add(dbType);
//		
//		dbType = new DbTypeImpl();
//		dbType.setName("PostGres");
//		dbTypes.add(dbType);
//		
//		// Add the collection of DbTypes to the model
//		eSet(Observability_emfPackage.MODEL__AVAILABLE_DB_TYPES, dbTypes);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Observability_emfPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Set the collection frequency of the model. 
	 * Frequency cannot be less than 30.
	 * <!-- end-user-doc -->
	 */
	public void setFrequency(int newFrequency) {
		if(newFrequency < 30)
			throw new IllegalArgumentException("Frequency should be greater than 30 seconds");
		int oldFrequency = frequency;
		frequency = newFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_emfPackage.MODEL__FREQUENCY, oldFrequency, frequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DatabaseCluster> getClusters() {
		if (clusters == null) {
			clusters = new EObjectContainmentEList<DatabaseCluster>(DatabaseCluster.class, this, Observability_emfPackage.MODEL__CLUSTERS);
		}
		return clusters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DbType> getAvailableDbTypes() {
		if (availableDbTypes == null) {
			availableDbTypes = new EObjectContainmentEList<DbType>(DbType.class, this, Observability_emfPackage.MODEL__AVAILABLE_DB_TYPES);
		}
		return availableDbTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Observability_emfPackage.MODEL__CLUSTERS:
				return ((InternalEList<?>)getClusters()).basicRemove(otherEnd, msgs);
			case Observability_emfPackage.MODEL__AVAILABLE_DB_TYPES:
				return ((InternalEList<?>)getAvailableDbTypes()).basicRemove(otherEnd, msgs);
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
			case Observability_emfPackage.MODEL__FREQUENCY:
				return getFrequency();
			case Observability_emfPackage.MODEL__CLUSTERS:
				return getClusters();
			case Observability_emfPackage.MODEL__AVAILABLE_DB_TYPES:
				return getAvailableDbTypes();
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
			case Observability_emfPackage.MODEL__FREQUENCY:
				setFrequency((Integer)newValue);
				return;
			case Observability_emfPackage.MODEL__CLUSTERS:
				getClusters().clear();
				getClusters().addAll((Collection<? extends DatabaseCluster>)newValue);
				return;
			case Observability_emfPackage.MODEL__AVAILABLE_DB_TYPES:
				getAvailableDbTypes().clear();
				getAvailableDbTypes().addAll((Collection<? extends DbType>)newValue);
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
			case Observability_emfPackage.MODEL__FREQUENCY:
				setFrequency(FREQUENCY_EDEFAULT);
				return;
			case Observability_emfPackage.MODEL__CLUSTERS:
				getClusters().clear();
				return;
			case Observability_emfPackage.MODEL__AVAILABLE_DB_TYPES:
				getAvailableDbTypes().clear();
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
			case Observability_emfPackage.MODEL__FREQUENCY:
				return frequency != FREQUENCY_EDEFAULT;
			case Observability_emfPackage.MODEL__CLUSTERS:
				return clusters != null && !clusters.isEmpty();
			case Observability_emfPackage.MODEL__AVAILABLE_DB_TYPES:
				return availableDbTypes != null && !availableDbTypes.isEmpty();
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
		result.append(" (frequency: ");
		result.append(frequency);
		result.append(')');
		return result.toString();
	}

} //ModelImpl
