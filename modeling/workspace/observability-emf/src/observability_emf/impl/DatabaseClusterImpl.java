/**
 */
package observability_emf.impl;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.naming.directory.InvalidAttributeValueException;

import observability_emf.BaseMetric;
import observability_emf.DatabaseCluster;
import observability_emf.DbType;
import observability_emf.NodeMachine;
import observability_emf.Observability_emfPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Database Cluster</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link observability_emf.impl.DatabaseClusterImpl#getMachines <em>Machines</em>}</li>
 *   <li>{@link observability_emf.impl.DatabaseClusterImpl#getCollectedBaseMetric <em>Collected Base Metric</em>}</li>
 *   <li>{@link observability_emf.impl.DatabaseClusterImpl#getAssociatedDbType <em>Associated Db Type</em>}</li>
 *   <li>{@link observability_emf.impl.DatabaseClusterImpl#getName <em>Name</em>}</li>
 *   <li>{@link observability_emf.impl.DatabaseClusterImpl#getNoOfMachines <em>No Of Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DatabaseClusterImpl extends MinimalEObjectImpl.Container implements DatabaseCluster {
	/**
	 * The cached value of the '{@link #getMachines() <em>Machines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachines()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeMachine> machines;

	/**
	 * The cached value of the '{@link #getCollectedBaseMetric() <em>Collected Base Metric</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectedBaseMetric()
	 * @generated
	 * @ordered
	 */
	protected EList<BaseMetric> collectedBaseMetric;

	/**
	 * The cached value of the '{@link #getAssociatedDbType() <em>Associated Db Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedDbType()
	 * @generated
	 * @ordered
	 */
	protected DbType associatedDbType;

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
	 * The default value of the '{@link #getNoOfMachines() <em>No Of Machines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoOfMachines()
	 * @generated
	 * @ordered
	 */
	protected static final int NO_OF_MACHINES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNoOfMachines() <em>No Of Machines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoOfMachines()
	 * @generated
	 * @ordered
	 */
	protected int noOfMachines = NO_OF_MACHINES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseClusterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Observability_emfPackage.Literals.DATABASE_CLUSTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeMachine> getMachines() {
		if (machines == null) {
			machines = new EObjectContainmentEList<NodeMachine>(NodeMachine.class, this, Observability_emfPackage.DATABASE_CLUSTER__MACHINES);
		}
		return machines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BaseMetric> getCollectedBaseMetric() {
		if (collectedBaseMetric == null) {
			collectedBaseMetric = new EObjectWithInverseResolvingEList.ManyInverse<BaseMetric>(BaseMetric.class, this, Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC, Observability_emfPackage.BASE_METRIC__DATABASE_CLUSTER);
		}
		return collectedBaseMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DbType getAssociatedDbType() {
		if (associatedDbType != null && associatedDbType.eIsProxy()) {
			InternalEObject oldAssociatedDbType = (InternalEObject)associatedDbType;
			associatedDbType = (DbType)eResolveProxy(oldAssociatedDbType);
			if (associatedDbType != oldAssociatedDbType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Observability_emfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE, oldAssociatedDbType, associatedDbType));
			}
		}
		return associatedDbType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DbType basicGetAssociatedDbType() {
		return associatedDbType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociatedDbType(DbType newAssociatedDbType) {
		DbType oldAssociatedDbType = associatedDbType;
		associatedDbType = newAssociatedDbType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_emfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE, oldAssociatedDbType, associatedDbType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_emfPackage.DATABASE_CLUSTER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNoOfMachines() {
		return noOfMachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Set the number of machines in the cluster and create that many machines in the cluster
	 * <!-- end-user-doc -->
	 */
	public void setNoOfMachines(int newNoOfMachines) {
		
		if(newNoOfMachines < 0){
			String err = "Number of machines cannot be less than 0";
			throw new InvalidParameterException(err);
		}
		
		int oldNoOfMachines = noOfMachines;
		
		// NoOfMachines cannot be decreased via parameter change.
		if(oldNoOfMachines > newNoOfMachines){
			String err = "Please delete the machine instances from the model diagram in order to decrease"
					+ " the number of machines.";
			throw new IllegalArgumentException(err);
		}
		
		// return if there is no change in value
		if(oldNoOfMachines == newNoOfMachines)
			return;
		
		NodeMachineImpl machine;
		
		// Get all the existing machines in the cluster
		EList<NodeMachine> existingMachines = getMachines();
		
		// Get the number of machines to create
		int size = existingMachines.size();
		int requiredMachines = newNoOfMachines - size; 
		
		// Create the required number of machines and add to cluster
		if(requiredMachines > 0){
			for(int i=size+1;i<=newNoOfMachines;i++){
				machine = new NodeMachineImpl();
				String name = "machine" + Integer.toString(i);
				machine.setName(name);
				existingMachines.add(machine);
			}
		eSet(Observability_emfPackage.DATABASE_CLUSTER__MACHINES, existingMachines);
		}		
		
		// set the number of machines at class level
		noOfMachines = newNoOfMachines;
		
		// notify all the registered listeners
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Observability_emfPackage.DATABASE_CLUSTER__NO_OF_MACHINES, oldNoOfMachines, noOfMachines));
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
			case Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCollectedBaseMetric()).basicAdd(otherEnd, msgs);
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
			case Observability_emfPackage.DATABASE_CLUSTER__MACHINES:
				return ((InternalEList<?>)getMachines()).basicRemove(otherEnd, msgs);
			case Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC:
				return ((InternalEList<?>)getCollectedBaseMetric()).basicRemove(otherEnd, msgs);
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
			case Observability_emfPackage.DATABASE_CLUSTER__MACHINES:
				return getMachines();
			case Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC:
				return getCollectedBaseMetric();
			case Observability_emfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE:
				if (resolve) return getAssociatedDbType();
				return basicGetAssociatedDbType();
			case Observability_emfPackage.DATABASE_CLUSTER__NAME:
				return getName();
			case Observability_emfPackage.DATABASE_CLUSTER__NO_OF_MACHINES:
				return getNoOfMachines();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method sets the attributes and relations in the Cluster.
	 * @param featureId
	 * 			takes the id of the feature which needs to be added.
	 * @param newValue
	 * 			value which needs to be set in the feature
	 * <!-- end-user-doc --> 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			// set the machines in the cluster
			case Observability_emfPackage.DATABASE_CLUSTER__MACHINES:
				
				getMachines().clear();
				Collection<? extends NodeMachine> machines = 
						(Collection<? extends NodeMachine>)newValue;
				getMachines().addAll(machines);
				
				// set the no of machines 
				if(getNoOfMachines()!=machines.size())
					setNoOfMachines(machines.size());
				return;
				
			case Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC:
				getCollectedBaseMetric().clear();
				getCollectedBaseMetric().addAll((Collection<? extends BaseMetric>)newValue);
				return;
			
			case Observability_emfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE:
				// non-generated code
				
				// Since the associatedDbType relation is 1..1, only a DbType object can be added in the cluster.
				// The input is a HashSet, get the only entry in the HashSet and set that as DbType
				HashSet<Object> value = (HashSet<Object>)newValue;
				Object[] objects = value.toArray();
				Object obj = objects[0];
				
				setAssociatedDbType((DbType)obj);
				return;
			
			case Observability_emfPackage.DATABASE_CLUSTER__NAME:
				setName((String)newValue);
				return;
				
			case Observability_emfPackage.DATABASE_CLUSTER__NO_OF_MACHINES:
				setNoOfMachines((Integer)newValue);
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
			case Observability_emfPackage.DATABASE_CLUSTER__MACHINES:
				getMachines().clear();
				return;
			case Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC:
				getCollectedBaseMetric().clear();
				return;
			case Observability_emfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE:
				setAssociatedDbType((DbType)null);
				return;
			case Observability_emfPackage.DATABASE_CLUSTER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Observability_emfPackage.DATABASE_CLUSTER__NO_OF_MACHINES:
				setNoOfMachines(NO_OF_MACHINES_EDEFAULT);
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
			case Observability_emfPackage.DATABASE_CLUSTER__MACHINES:
				return machines != null && !machines.isEmpty();
			case Observability_emfPackage.DATABASE_CLUSTER__COLLECTED_BASE_METRIC:
				return collectedBaseMetric != null && !collectedBaseMetric.isEmpty();
			case Observability_emfPackage.DATABASE_CLUSTER__ASSOCIATED_DB_TYPE:
				return associatedDbType != null;
			case Observability_emfPackage.DATABASE_CLUSTER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Observability_emfPackage.DATABASE_CLUSTER__NO_OF_MACHINES:
				return noOfMachines != NO_OF_MACHINES_EDEFAULT;
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
		result.append(", noOfMachines: ");
		result.append(noOfMachines);
		result.append(')');
		return result.toString();
	}

} //DatabaseClusterImpl
