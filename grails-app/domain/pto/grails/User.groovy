package pto.grails

/**
 * The Class User.
 * 
 * @author W039080 Aug 22, 2012 10:46:30 AM
 */
class User {
	
	/** The user id. */
	String userId;
	
	/** The first name. */
	String firstName;
	
	/** The last name. */
	String lastName;
	
	/** The email id. */
	String emailId;
	
	/** The constraints. */
	static constraints = {
		userId(nullable:false, blank:false, unique:true)
	}
	
	/** The searchable. */
	static searchable = true
}
