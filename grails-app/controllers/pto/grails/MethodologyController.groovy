package pto.grails

import org.springframework.dao.DataIntegrityViolationException

import grails.plugins.springsecurity.Secured



/**
 * The Class MethodologyController.
 * 
 * @author W039080 Aug 17, 2012 10:43:45 PM
 */
@Secured(['permitAll'])
class MethodologyController {
	
	/** The navigation. */
	static navigation = [
		group:'tabs',
		order:20,
		title:'Methodologies',
		action:'list'
	]
    
    /** The allowed methods. */
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

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
        params.max = Math.min(max ?: 10, 100)
        [methodologyInstanceList: Methodology.list(params), methodologyInstanceTotal: Methodology.count()]
    }

    /**
	 * Creates the.
	 * 
	 * @return the java.lang. object
	 */
    def create() {
        [methodologyInstance: new Methodology(params)]
    }

    /**
	 * Save.
	 * 
	 * @return the java.lang. object
	 */
    def save() {
        def methodologyInstance = new Methodology(params)
        if (!methodologyInstance.save(flush: true)) {
            render(view: "create", model: [methodologyInstance: methodologyInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'methodology.label', default: 'Methodology'), methodologyInstance.id])
        redirect(action: "show", id: methodologyInstance.id)
    }

    /**
	 * Show.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def show(Long id) {
        def methodologyInstance = Methodology.get(id)
        if (!methodologyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'methodology.label', default: 'Methodology'), id])
            redirect(action: "list")
            return
        }

        [methodologyInstance: methodologyInstance]
    }

    /**
	 * Edits the.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def edit(Long id) {
        def methodologyInstance = Methodology.get(id)
        if (!methodologyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'methodology.label', default: 'Methodology'), id])
            redirect(action: "list")
            return
        }

        [methodologyInstance: methodologyInstance]
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
        def methodologyInstance = Methodology.get(id)
        if (!methodologyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'methodology.label', default: 'Methodology'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (methodologyInstance.version > version) {
                methodologyInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'methodology.label', default: 'Methodology')] as Object[],
                          "Another user has updated this Methodology while you were editing")
                render(view: "edit", model: [methodologyInstance: methodologyInstance])
                return
            }
        }

        methodologyInstance.properties = params

        if (!methodologyInstance.save(flush: true)) {
            render(view: "edit", model: [methodologyInstance: methodologyInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'methodology.label', default: 'Methodology'), methodologyInstance.id])
        redirect(action: "show", id: methodologyInstance.id)
    }

    /**
	 * Delete.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def delete(Long id) {
        def methodologyInstance = Methodology.get(id)
        if (!methodologyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'methodology.label', default: 'Methodology'), id])
            redirect(action: "list")
            return
        }

        try {
            methodologyInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'methodology.label', default: 'Methodology'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'methodology.label', default: 'Methodology'), id])
            redirect(action: "show", id: id)
        }
    }
}
