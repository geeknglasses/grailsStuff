package pto.grails

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured

/**
 * The Class UserController.
 * 
 * @author W039080 Aug 14, 2012 10:44:23 AM
 */
@Secured(['permitAll'])
class UserController {

	/** The navigation. */
	static navigation = [
		group:'tabs', 
		order:30, 
		title:'Users', 
		action:'list'		
	]


    /** The allowed methods. */
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	/** The searchable service. */
	def searchableService
		
		/** The search. */
		def search = {
			def query = params.q + '*'
			
			println (params)
			if(query) {
	
				def searchResults = searchableService.search(query)
	
				render(view: "list",
						model: [userInstanceList: searchResults.results,
							userInstanceTotal:searchResults.total])
			}
			else {
				return [:];
			}
		}
		
		/** The filter pane service. */
		def filterPaneService
		
		/** The filter. */
		def filter = {
			if(!params.max) params.max = 10
			render( view:'list',
				model:[ userInstanceList: filterPaneService.filter( params, User ),
				userInstanceTotal: filterPaneService.count( params, User ),
				filterParams: org.grails.plugin.filterpane.FilterPaneUtils.extractFilterParams(params),
				params:params ] )
		}

    /**
	 * Index.
	 * 
	 * @return the java.lang. object
	 */
    def index() {
        redirect(action: "list", params: params)
    }

    /**
	 * List.
	 * 
	 * @param max
	 *            the max
	 * @return the java.lang. object
	 */
    def list(Integer max) {
        params.max = Math.min(max ?: 20, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]
    }

    /**
	 * Creates the.
	 * 
	 * @return the java.lang. object
	 */
    def create() {
        [userInstance: new User(params)]
    }

    /**
	 * Save.
	 * 
	 * @return the java.lang. object
	 */
    def save() {
        def userInstance = new User(params)
        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    /**
	 * Show.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def show(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    /**
	 * Edits the.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def edit(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    /**
	 * Update.
	 * 
	 * @param id
	 *            the id
	 * @param version
	 *            the version
	 * @return the java.lang. object
	 */
    def update(Long id, Long version) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'user.label', default: 'User')] as Object[],
                          "Another user has updated this User while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }

        userInstance.properties = params

        if (!userInstance.save(flush: true)) {
            render(view: "edit", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.userId])
        redirect(action: "show", id: userInstance.id)
    }

    /**
	 * Delete.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def delete(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        try {
            userInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "show", id: id)
        }
    }
}
