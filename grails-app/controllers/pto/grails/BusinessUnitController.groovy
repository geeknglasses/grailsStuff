package pto.grails

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured


/**
 * The Class BusinessUnitController.
 * 
 * @author W039080 Aug 18 , 2012 7:50:03 PM
 */
@Secured(['permitAll'])
class BusinessUnitController {
	
	/** The navigation. */
	static navigation = [
		group:'tabs',
		order:10,
		title:'Business Units',
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
        [businessUnitInstanceList: BusinessUnit.list(params), businessUnitInstanceTotal: BusinessUnit.count()]
    }

    /**
	 * Creates the.
	 * 
	 * @return the java.lang. object
	 */
    def create() {
        [businessUnitInstance: new BusinessUnit(params)]
    }

    /**
	 * Save.
	 * 
	 * @return the java.lang. object
	 */
    def save() {
        def businessUnitInstance = new BusinessUnit(params)
        if (!businessUnitInstance.save(flush: true)) {
            render(view: "create", model: [businessUnitInstance: businessUnitInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'businessUnit.label', default: 'BusinessUnit'), businessUnitInstance.id])
        redirect(action: "show", id: businessUnitInstance.id)
    }

    /**
	 * Show.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def show(Long id) {
        def businessUnitInstance = BusinessUnit.get(id)
        if (!businessUnitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'businessUnit.label', default: 'BusinessUnit'), id])
            redirect(action: "list")
            return
        }

        [businessUnitInstance: businessUnitInstance]
    }
	
	/**
	 * Show summary.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
	def showSummary(Long id) {
		def businessUnitInstance = BusinessUnit.get(id)
		if (!businessUnitInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'businessUnit.label', default: 'BusinessUnit'), id])
			redirect(action: "list")
			return
		}

		[businessUnitInstance: businessUnitInstance]
	}

    /**
	 * Edits the.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def edit(Long id) {
        def businessUnitInstance = BusinessUnit.get(id)
        if (!businessUnitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'businessUnit.label', default: 'BusinessUnit'), id])
            redirect(action: "list")
            return
        }

        [businessUnitInstance: businessUnitInstance]
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
        def businessUnitInstance = BusinessUnit.get(id)
        if (!businessUnitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'businessUnit.label', default: 'BusinessUnit'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (businessUnitInstance.version > version) {
                businessUnitInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'businessUnit.label', default: 'BusinessUnit')] as Object[],
                          "Another user has updated this BusinessUnit while you were editing")
                render(view: "edit", model: [businessUnitInstance: businessUnitInstance])
                return
            }
        }

        businessUnitInstance.properties = params

        if (!businessUnitInstance.save(flush: true)) {
            render(view: "edit", model: [businessUnitInstance: businessUnitInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'businessUnit.label', default: 'BusinessUnit'), businessUnitInstance.id])
        redirect(action: "show", id: businessUnitInstance.id)
    }

    /**
	 * Delete.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def delete(Long id) {
        def businessUnitInstance = BusinessUnit.get(id)
        if (!businessUnitInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'businessUnit.label', default: 'BusinessUnit'), id])
            redirect(action: "list")
            return
        }

        try {
            businessUnitInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'businessUnit.label', default: 'BusinessUnit'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'businessUnit.label', default: 'BusinessUnit'), id])
            redirect(action: "show", id: id)
        }
    }
}
