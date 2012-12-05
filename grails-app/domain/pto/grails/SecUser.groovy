package pto.grails

/**
 * The Class SecUser.
 * 
 * @author W039080 Aug 22, 2012 10:46:14 AM
 */
class SecUser {

	/** The spring security service. */
	transient springSecurityService

	/** The username. */
	String username
	
	/** The password. */
	String password
	
	/** The enabled. */
	boolean enabled
	
	/** The account expired. */
	boolean accountExpired
	
	/** The account locked. */
	boolean accountLocked
	
	/** The password expired. */
	boolean passwordExpired

	/** The constraints. */
	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	/** The mapping. */
	static mapping = {
		password column: '`password`'
	}

	/**
	 * Gets the authorities.
	 * 
	 * @return the authorities
	 */
	Set<SecRole> getAuthorities() {
		SecUserSecRole.findAllBySecUser(this).collect { it.secRole } as Set
	}

	/**
	 * Before insert.
	 * 
	 * @return the java.lang. object
	 */
	def beforeInsert() {
		encodePassword()
	}

	/**
	 * Before update.
	 * 
	 * @return the java.lang. object
	 */
	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	/**
	 * Encode password.
	 */
	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
