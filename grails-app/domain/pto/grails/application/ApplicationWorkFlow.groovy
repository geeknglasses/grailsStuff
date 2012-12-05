package pto.grails.application

import java.util.List;

import pto.grails.Question;

/**
 * The Class Region.
 *
 * @author W039080 Aug 22, 2012 10:45:57 AM
 */
class ApplicationWorkFlow {

	/** The region id. */
	String applicationWorkflowName;
	
	/** The questions. */
	static hasMany = [questions: Question] 
	
	/** The constraints. */
	static constraints = {
	}
}
