package pto.grails

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured



/**
 * The Class PtoCheckAreaController.
 * 
 * @author W039080 Aug 17, 2012 10:44:03 PM
 */
@Secured(['permitAll'])
class PtoCheckAreaController {
	
	/** The navigation. */
	static navigation = [
		group:'tabs',
		order:50,
		title:'Pto Checks',
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
        [ptoCheckAreaInstanceList: PtoCheckArea.list(params), ptoCheckAreaInstanceTotal: PtoCheckArea.count()]
    }

    /**
	 * Creates the.
	 * 
	 * @return the java.lang. object
	 */
    def create() {
        [ptoCheckAreaInstance: new PtoCheckArea(params)]
    }

    /**
	 * Save.
	 * 
	 * @return the java.lang. object
	 */
    def save() {
        def ptoCheckAreaInstance = new PtoCheckArea(params)
        if (!ptoCheckAreaInstance.save(flush: true)) {
            render(view: "create", model: [ptoCheckAreaInstance: ptoCheckAreaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'ptoCheckArea.label', default: 'PtoCheckArea'), ptoCheckAreaInstance.id])
        redirect(action: "show", id: ptoCheckAreaInstance.id)
    }

    /**
	 * Show.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def show(Long id) {
        def ptoCheckAreaInstance = PtoCheckArea.get(id)
        if (!ptoCheckAreaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ptoCheckArea.label', default: 'PtoCheckArea'), id])
            redirect(action: "list")
            return
        }

        [ptoCheckAreaInstance: ptoCheckAreaInstance]
    }

    /**
	 * Edits the.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def edit(Long id) {
        def ptoCheckAreaInstance = PtoCheckArea.get(id)
        if (!ptoCheckAreaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ptoCheckArea.label', default: 'PtoCheckArea'), id])
            redirect(action: "list")
            return
        }

        [ptoCheckAreaInstance: ptoCheckAreaInstance]
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
        def ptoCheckAreaInstance = PtoCheckArea.get(id)
        if (!ptoCheckAreaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ptoCheckArea.label', default: 'PtoCheckArea'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (ptoCheckAreaInstance.version > version) {
                ptoCheckAreaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'ptoCheckArea.label', default: 'PtoCheckArea')] as Object[],
                          "Another user has updated this PtoCheckArea while you were editing")
                render(view: "edit", model: [ptoCheckAreaInstance: ptoCheckAreaInstance])
                return
            }
        }

        ptoCheckAreaInstance.properties = params

        if (!ptoCheckAreaInstance.save(flush: true)) {
            render(view: "edit", model: [ptoCheckAreaInstance: ptoCheckAreaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'ptoCheckArea.label', default: 'PtoCheckArea'), ptoCheckAreaInstance.id])
        redirect(action: "show", id: ptoCheckAreaInstance.id)
    }

    /**
	 * Delete.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def delete(Long id) {
        def ptoCheckAreaInstance = PtoCheckArea.get(id)
        if (!ptoCheckAreaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ptoCheckArea.label', default: 'PtoCheckArea'), id])
            redirect(action: "list")
            return
        }

        try {
            ptoCheckAreaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'ptoCheckArea.label', default: 'PtoCheckArea'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ptoCheckArea.label', default: 'PtoCheckArea'), id])
            redirect(action: "show", id: id)
        }
    }
}
