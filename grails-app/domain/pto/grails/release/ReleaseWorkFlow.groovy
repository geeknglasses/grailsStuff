package pto.grails.release

import java.util.List;

import pto.grails.Question;

/**
 * The Class Region.
 *
 * @author W039080 Aug 22, 2012 10:45:57 AM
 */
class ReleaseWorkFlow {

	/** The region id. */
	String releaseWorkflowName;
	
	/** The questions. */
	static hasMany = [questions: Question] 
	
	/** The constraints. */
	static constraints = {
	}
}
