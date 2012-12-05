package pto.grails

import java.util.Date;

/**
 * The Class Q.
 *
 * @author W039080 Aug 22, 2012 10:45:33 AM
 */
class Workflow {
	
	/** The description. */
	String description;
	
	static hasMany = [questions: Question] 
	
		/** The constraints. */
		static constraints = {
		description(nullable:false)
	}
}
