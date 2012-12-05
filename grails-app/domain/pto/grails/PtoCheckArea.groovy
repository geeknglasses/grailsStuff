package pto.grails


/**
 * The Class PtoCheckArea.
 * 
 * @author W039080 Aug 22, 2012 10:45:40 AM
 */
class PtoCheckArea {

	/** The area name. */
	String areaName;
	
	
	/** The constraints. */
	static constraints = {		
		areaName(nullable: false)		
	}
}
