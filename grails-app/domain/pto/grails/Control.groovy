package pto.grails

import java.util.Date;

/**
 * The Class Q.
 *
 * @author W039080 Aug 22, 2012 10:45:33 AM
 */
class Control {
	
	String controlName;
	/** The description. */
	String description;
	
	String area;
	
	String section;
	
	static hasMany = [questions: Question]
	
		/** The constraints. */
		static constraints = {
		description(nullable:false)
		area(nullable:true)
		section(nullable:true)
	}
}
