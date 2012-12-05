package sample.contact

import org.codehaus.groovy.grails.commons.ApplicationHolder as AH
import static org.springframework.security.acls.domain.BasePermission.ADMINISTRATION
import static org.springframework.security.acls.domain.BasePermission.DELETE
import static org.springframework.security.acls.domain.BasePermission.READ
import static org.springframework.security.acls.domain.BasePermission.WRITE
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.context.SecurityContextHolder as SCH

import pto.grails.SecRole
import pto.grails.SecUser
import pto.grails.SecUserSecRole


class DataSourcePopulator {

	private static Random _random = new Random()

	private aclService
	private aclUtilService
	private objectIdentityRetrievalStrategy
	private sessionFactory
	private springSecurityService

	void populate() {

		def ctx = AH.application.mainContext
		aclService = ctx.aclService
		objectIdentityRetrievalStrategy = ctx.objectIdentityRetrievalStrategy
		sessionFactory = ctx.sessionFactory
		springSecurityService = ctx.springSecurityService
		aclUtilService = ctx.aclUtilService

		

		int createEntities = 50

		// Set a user account that will initially own all the created data
		SCH.context.authentication = new UsernamePasswordAuthenticationToken('rod', 'koala',
				AuthorityUtils.createAuthorityList('ROLE_IGNORED'))

		def secUserRole = new SecRole(authority: 'ROLE_USER').save()
		def supervisorRole = new SecRole(authority: 'ROLE_SUPERVISOR').save()

		createSecUser 'rod',    'koala',  true,  secUserRole, supervisorRole
		createSecUser 'dianne', 'emu',    true,  secUserRole
		createSecUser 'scott',  'wombat', true,  secUserRole
		createSecUser 'peter',  'opal',   false, secUserRole
		createSecUser 'bill',   'wombat', true,  secUserRole
		createSecUser 'bob',    'wombat', true,  secUserRole
		createSecUser 'jane',   'wombat', true,  secUserRole

		

//		// Now grant some permissions
//		aclUtilService.addPermission  'rod',    ADMINISTRATION
//		aclUtilService.addPermission  'rod',    READ
//		aclUtilService.addPermission 'rod',    READ
//		aclUtilService.addPermission 'rod',    WRITE
//		aclUtilService.addPermission  'rod',    DELETE
//		aclUtilService.addPermission  'rod',    ADMINISTRATION
//		aclUtilService.addPermission  'dianne', ADMINISTRATION
//		aclUtilService.addPermission  'scott',  READ
//		aclUtilService.addPermission 'dianne', ADMINISTRATION
//		aclUtilService.addPermission 'dianne', READ
//		aclUtilService.addPermission 'dianne', READ
//		aclUtilService.addPermission  'dianne', WRITE
//		aclUtilService.addPermission  'dianne', DELETE
//		aclUtilService.addPermission  'scott',  READ
//		aclUtilService.addPermission 'scott',  ADMINISTRATION
//		aclUtilService.addPermission 'dianne', ADMINISTRATION
//		aclUtilService.addPermission 'dianne', READ
//		aclUtilService.addPermission  'scott',  READ
//		aclUtilService.addPermission  'scott',  ADMINISTRATION
//		aclUtilService.addPermission  'scott',  READ
//		aclUtilService.addPermission  'scott',  WRITE
//		aclUtilService.addPermission  'scott',  DELETE

		// Now expressly change the owner of the first ten contacts
		// We have to do this last, because 'rod' owns all of them (doing it sooner would prevent ACL updates)
		// Note that ownership has no impact on permissions - they're separate (ownership only allows ACl editing)
//		aclUtilService.changeOwner contacts[4], 'dianne'
//		aclUtilService.changeOwner contacts[5], 'dianne'
//		aclUtilService.changeOwner contacts[6], 'scott'
//		aclUtilService.changeOwner contacts[7], 'dianne'
//		aclUtilService.changeOwner contacts[8], 'scott'

		def secUsers = ['bill', 'bob', 'jane'] // don't want to mess around with consistent sample data
		def permissions = [ADMINISTRATION, READ, DELETE]

		

		sessionFactory.currentSession.flush()

		// logout
		SCH.clearContext()
	}

	private void createSecUser(String username, String password, boolean enabled, SecRole... roles) {
		def secUser = new SecUser(username: username, enabled: enabled,
				password: springSecurityService.encodePassword(password)).save()
		System.out.println("SecUser " + secUser + ":: " +  username )
		
		for (role in roles) {
			def secUserSecRole =  SecUserSecRole.create secUser, role
			System.out.println("Created SecUSerSecRole " + secUserSecRole)
		}
	}


}
