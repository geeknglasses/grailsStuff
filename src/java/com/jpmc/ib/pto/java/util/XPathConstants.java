/**
 * W039080 Aug 16, 2012 12:27:49 PM
 */
package com.jpmc.ib.pto.java.util;

/**
 * @author W039080 Aug 16, 2012 12:27:49 PM
 * 
 */
public enum XPathConstants {

	APPLICATION_ID("//applications/application/id"), 
	APPLICATION_NAME("//applications/application/name");

	String xPath;

	private XPathConstants(String xPath) {
		this.xPath = xPath;
	}

	public String getxPath() {
		return xPath;
	}

	
}
