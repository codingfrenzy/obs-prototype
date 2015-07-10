/**
 */
package com.observability.modeling.emf.provider;


import com.observability.modeling.emf.AggregatedMetric;
import com.observability.modeling.emf.EmfPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.observability.modeling.emf.AggregatedMetric} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AggregatedMetricItemProvider extends MetricItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatedMetricItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addCalculateSumPropertyDescriptor(object);
			addCalculateNumPropertyDescriptor(object);
			addCalculateAvgPropertyDescriptor(object);
			addCalculateMinPropertyDescriptor(object);
			addCalculateMaxPropertyDescriptor(object);
			addCalculateStddevPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Calculate Sum feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCalculateSumPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AggregatedMetric_calculateSum_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AggregatedMetric_calculateSum_feature", "_UI_AggregatedMetric_type"),
				 EmfPackage.Literals.AGGREGATED_METRIC__CALCULATE_SUM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Calculate Num feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCalculateNumPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AggregatedMetric_calculateNum_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AggregatedMetric_calculateNum_feature", "_UI_AggregatedMetric_type"),
				 EmfPackage.Literals.AGGREGATED_METRIC__CALCULATE_NUM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Calculate Avg feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCalculateAvgPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AggregatedMetric_calculateAvg_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AggregatedMetric_calculateAvg_feature", "_UI_AggregatedMetric_type"),
				 EmfPackage.Literals.AGGREGATED_METRIC__CALCULATE_AVG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Calculate Min feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCalculateMinPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AggregatedMetric_calculateMin_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AggregatedMetric_calculateMin_feature", "_UI_AggregatedMetric_type"),
				 EmfPackage.Literals.AGGREGATED_METRIC__CALCULATE_MIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Calculate Max feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCalculateMaxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AggregatedMetric_calculateMax_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AggregatedMetric_calculateMax_feature", "_UI_AggregatedMetric_type"),
				 EmfPackage.Literals.AGGREGATED_METRIC__CALCULATE_MAX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Calculate Stddev feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCalculateStddevPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AggregatedMetric_calculateStddev_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AggregatedMetric_calculateStddev_feature", "_UI_AggregatedMetric_type"),
				 EmfPackage.Literals.AGGREGATED_METRIC__CALCULATE_STDDEV,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns AggregatedMetric.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AggregatedMetric"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AggregatedMetric)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AggregatedMetric_type") :
			getString("_UI_AggregatedMetric_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AggregatedMetric.class)) {
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_SUM:
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_NUM:
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_AVG:
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_MIN:
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_MAX:
			case EmfPackage.AGGREGATED_METRIC__CALCULATE_STDDEV:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
