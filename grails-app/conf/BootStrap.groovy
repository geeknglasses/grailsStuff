import sample.contact.DataSourcePopulator
import pto.grails.*
import pto.grails.SecUserSecRole



class BootStrap {
    def springSecurityService

    def init = { servletContext ->
    new DataSourcePopulator().populate()
    def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)
    def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)


     def adminUser = SecUser.findByUsername('admin') ?: new SecUser(
                username: 'admin',
                password: springSecurityService.encodePassword('admin'),
                enabled: true).save(failOnError: true)
 
        if (!adminUser.authorities.contains(adminRole)) {
            SecUserSecRole.create adminUser, adminRole
        }

    }
    def destroy = {
    }
}
