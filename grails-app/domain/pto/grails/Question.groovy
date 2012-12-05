package pto.grails

import java.util.Date;

/**
 * The Class Pto.
 *
 * @author W039080 Aug 22, 2012 10:45:33 AM
 */
class Question {
	
	/** The description. */
	String description;
	
	String answerType;
	
		/** The constraints. */
		static constraints = {
		description(nullable:false)
		answerType(nullable:true)		
	}
}
