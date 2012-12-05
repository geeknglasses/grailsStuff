package pto.grails

/**
 * The Class Methodology.
 * 
 * @author W039080 Aug 22, 2012 10:45:28 AM
 */
class Methodology {

	/** The methodology name. */
	String methodologyName;
	
	/** The constraints. */
	static constraints = {
		
		methodologyName(nullable: false)
		
	}
}
