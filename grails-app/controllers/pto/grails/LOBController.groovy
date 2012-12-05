package pto.grails

import org.springframework.dao.DataIntegrityViolationException

import grails.plugins.springsecurity.Secured


/**
 * The Class LOBController.
 * 
 * @author W039080 Aug 18, 2012 7:52:26 PM
 */
@Secured(['permitAll'])
class LOBController {
	
	/** The navigation. */
	static navigation = [
		group:'tabs',
		order:4,
		title:'LOBs',
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
        [LOBInstanceList: LOB.list(params), LOBInstanceTotal: LOB.count()]
    }
	
	
	def allLOBSummary(Integer max) {
		System.out.println("In LOB Summary")
		params.max = Math.min(max ?: 15, 100)
		render(view: "allLOBSummary")
	}


    /**
	 * Creates the.
	 * 
	 * @return the java.lang. object
	 */
    def create() {
        [LOBInstance: new LOB(params)]
    }

    /**
	 * Save.
	 * 
	 * @return the java.lang. object
	 */
    def save() {
        def LOBInstance = new LOB(params)
        if (!LOBInstance.save(flush: true)) {
            render(view: "create", model: [LOBInstance: LOBInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'LOB.label', default: 'LOB'), LOBInstance.id])
        redirect(action: "show", id: LOBInstance.id)
    }

    /**
	 * Show.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def show(Long id) {
        def LOBInstance = LOB.get(id)
        if (!LOBInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'LOB.label', default: 'LOB'), id])
            redirect(action: "list")
            return
        }

        [LOBInstance: LOBInstance]
    }
	
	/**
	 * Show summary.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
	def showSummary(Long id) {
		def LOBInstance = LOB.get(id)
		if (!LOBInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'LOB.label', default: 'LOB'), id])
			redirect(action: "list")
			return
		}

		[LOBInstance: LOBInstance]
	}

    /**
	 * Edits the.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def edit(Long id) {
        def LOBInstance = LOB.get(id)
        if (!LOBInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'LOB.label', default: 'LOB'), id])
            redirect(action: "list")
            return
        }

        [LOBInstance: LOBInstance]
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
        def LOBInstance = LOB.get(id)
        if (!LOBInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'LOB.label', default: 'LOB'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (LOBInstance.version > version) {
                LOBInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'LOB.label', default: 'LOB')] as Object[],
                          "Another user has updated this LOB while you were editing")
                render(view: "edit", model: [LOBInstance: LOBInstance])
                return
            }
        }

        LOBInstance.properties = params

        if (!LOBInstance.save(flush: true)) {
            render(view: "edit", model: [LOBInstance: LOBInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'LOB.label', default: 'LOB'), LOBInstance.id])
        redirect(action: "show", id: LOBInstance.id)
    }

    /**
	 * Delete.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def delete(Long id) {
        def LOBInstance = LOB.get(id)
        if (!LOBInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'LOB.label', default: 'LOB'), id])
            redirect(action: "list")
            return
        }

        try {
            LOBInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'LOB.label', default: 'LOB'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'LOB.label', default: 'LOB'), id])
            redirect(action: "show", id: id)
        }
    }
}
