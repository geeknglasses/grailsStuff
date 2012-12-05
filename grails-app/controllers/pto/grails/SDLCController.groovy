package pto.grails

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured



/**
 * The Class SDLCController.
 * 
 * @author W039080 Aug 17, 2012 09:44:18 PM
 */
@Secured(['permitAll'])
class SDLCController {

	/** The navigation. */
	static navigation = [
		group:'tabs',
		order:2,
		title:'SDLC',
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
        [SDLCInstanceList: SDLC.list(params), SDLCInstanceTotal: SDLC.count()]
    }

    /**
	 * Creates the.
	 * 
	 * @return the java.lang. object
	 */
    def create() {
        [SDLCInstance: new SDLC(params)]
    }

    /**
	 * Save.
	 * 
	 * @return the java.lang. object
	 */
    def save() {
        def SDLCInstance = new SDLC(params)
        if (!SDLCInstance.save(flush: true)) {
            render(view: "create", model: [SDLCInstance: SDLCInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'SDLC.label', default: 'SDLC'), SDLCInstance.id])
        redirect(action: "show", id: SDLCInstance.id)
    }

    /**
	 * Show.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def show(Long id) {
        def SDLCInstance = SDLC.get(id)
        if (!SDLCInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'SDLC.label', default: 'SDLC'), id])
            redirect(action: "list")
            return
        }

        [SDLCInstance: SDLCInstance]
    }
	
	/**
	 * Show summary.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
	def showSummary(Long id) {
		def SDLCInstance = SDLC.get(id)
		if (!SDLCInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'SDLC.label', default: 'SDLC'), id])
			redirect(action: "list")
			return
		}

		[SDLCInstance: SDLCInstance]
	}

    /**
	 * Edits the.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def edit(Long id) {
        def SDLCInstance = SDLC.get(id)
        if (!SDLCInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'SDLC.label', default: 'SDLC'), id])
            redirect(action: "list")
            return
        }

        [SDLCInstance: SDLCInstance]
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
        def SDLCInstance = SDLC.get(id)
        if (!SDLCInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'SDLC.label', default: 'SDLC'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (SDLCInstance.version > version) {
                SDLCInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'SDLC.label', default: 'SDLC')] as Object[],
                          "Another user has updated this SDLC while you were editing")
                render(view: "edit", model: [SDLCInstance: SDLCInstance])
                return
            }
        }

        SDLCInstance.properties = params

        if (!SDLCInstance.save(flush: true)) {
            render(view: "edit", model: [SDLCInstance: SDLCInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'SDLC.label', default: 'SDLC'), SDLCInstance.id])
        redirect(action: "show", id: SDLCInstance.id)
    }

    /**
	 * Delete.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def delete(Long id) {
        def SDLCInstance = SDLC.get(id)
        if (!SDLCInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'SDLC.label', default: 'SDLC'), id])
            redirect(action: "list")
            return
        }

        try {
            SDLCInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'SDLC.label', default: 'SDLC'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'SDLC.label', default: 'SDLC'), id])
            redirect(action: "show", id: id)
        }
    }
}
