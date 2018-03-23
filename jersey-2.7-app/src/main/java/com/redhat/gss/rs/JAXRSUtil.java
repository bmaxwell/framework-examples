/**
 * 
 */
package com.redhat.gss.rs;

import java.lang.reflect.Method;

import javax.ws.rs.core.Application;
import javax.ws.rs.ext.RuntimeDelegate;

/**
 * @author bmaxwell
 *
 */
public class JAXRSUtil {

	/**
	 * 
	 */
	public JAXRSUtil() {
	}

	public static String clName(Object obj) {
		return obj == null ? "Null" : obj.getClass().getCanonicalName();
	}

	public static String getJAXRSVersion() {
		// to get the JAX-RS version, we need to check if the
		// javax.ws.rs.core.Application class has the method getProperties
		// which is only present in JAX-RS 2.0
		Method[] methods = Application.class.getMethods();

		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().equals("getProperties"))
				return "JAX-RS 2.0";
		}
		return "JAX-RS 1.x";
	}

	public static boolean isJersey() {
		if("Jersey".equals(getImpl()))
			return true;
		return false;
	}
	
	public static String getImpl() {
		// TODO: Add cxf
		String clName = clName(RuntimeDelegate.getInstance());
		if (clName.contains("resteasy")) {
			return "RESTEasy";
		} else if (clName.contains("jersey")) {
			return "Jersey";
		} else {
			return "Unknown: " + clName;
		}
	}
}