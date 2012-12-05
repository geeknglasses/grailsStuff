package pto.grails

/**
 * The Class LOB.
 * 
 * @author W039080 Aug 22, 2012 10:45:22 AM
 */
class LOB {

	/** The lob short. */
	String lobShort;
	
	/** The lob name. */
	String lobName;
	
	/** The mark for edit. */
	boolean markForEdit;
	
	/** The business unit. */
	BusinessUnit businessUnit
	
    /** The constraints. */
    static constraints = {
		
		lobShort(nullable: true)
		markForEdit(nullable: true)
		
    }
}
