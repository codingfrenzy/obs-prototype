package com.observability.modeling.emf.extension;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.observability.modeling.emf.extension.messages"; //$NON-NLS-1$
	public static String SiriusServices_ID_SEPERATOR;
	public static String SiriusServices_MACHINE;
	public static String SiriusServices_MSG_ERROR_ECLIPSE_CANNOTBENULL;
	public static String SiriusServices_MSG_ERROR_MUST_BE_DB_CLUSTER;
	public static String SiriusServices_MSG_ERROR_NO_DESCRIPTOR_DIR;
	public static String SiriusServices_MSG_ERROR_NO_DESCRIPTOR_FILES;
	public static String SiriusServices_NULL;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
