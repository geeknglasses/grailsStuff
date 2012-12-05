package pto.grails

import org.apache.commons.lang.builder.HashCodeBuilder

/**
 * The Class SecUserSecRole.
 * 
 * @author W039080 Aug 22, 2012 10:46:20 AM
 */
class SecUserSecRole implements Serializable {

	/** The sec user. */
	SecUser secUser
	
	/** The sec role. */
	SecRole secRole

	/**
	 * Equals.
	 * 
	 * @param other
	 *            the other
	 * @return true, if successful
	 */
	boolean equals(other) {
		if (!(other instanceof SecUserSecRole)) {
			return false
		}

		other.secUser?.id == secUser?.id &&
			other.secRole?.id == secRole?.id
	}

	/**
	 * Hash code.
	 * 
	 * @return the int
	 */
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (secUser) builder.append(secUser.id)
		if (secRole) builder.append(secRole.id)
		builder.toHashCode()
	}

	/**
	 * Gets the.
	 * 
	 * @param secUserId
	 *            the sec user id
	 * @param secRoleId
	 *            the sec role id
	 * @return the sec user sec role
	 */
	static SecUserSecRole get(long secUserId, long secRoleId) {
		find 'from SecUserSecRole where secUser.id=:secUserId and secRole.id=:secRoleId',
			[secUserId: secUserId, secRoleId: secRoleId]
	}

	/**
	 * Creates the.
	 * 
	 * @param secUser
	 *            the sec user
	 * @param secRole
	 *            the sec role
	 * @return the sec user sec role
	 */
	static SecUserSecRole create(SecUser secUser, SecRole secRole, boolean flush = false) {
		new SecUserSecRole(secUser: secUser, secRole: secRole).save(flush: flush, insert: true)
	}

	/**
	 * Removes the.
	 * 
	 * @param secUser
	 *            the sec user
	 * @param secRole
	 *            the sec role
	 * @return true, if successful
	 */
	static boolean remove(SecUser secUser, SecRole secRole, boolean flush = false) {
		SecUserSecRole instance = SecUserSecRole.findBySecUserAndSecRole(secUser, secRole)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	/**
	 * Removes the all.
	 * 
	 * @param secUser
	 *            the sec user
	 */
	static void removeAll(SecUser secUser) {
		executeUpdate 'DELETE FROM SecUserSecRole WHERE secUser=:secUser', [secUser: secUser]
	}

	/**
	 * Removes the all.
	 * 
	 * @param secRole
	 *            the sec role
	 */
	static void removeAll(SecRole secRole) {
		executeUpdate 'DELETE FROM SecUserSecRole WHERE secRole=:secRole', [secRole: secRole]
	}

	/** The mapping. */
	static mapping = {
		id composite: ['secRole', 'secUser']
		version false
	}
}
