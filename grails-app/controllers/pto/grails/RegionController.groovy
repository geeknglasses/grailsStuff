package pto.grails

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured


/**
 * The Class RegionController.
 * 
 * @author W039080 Aug 16, 2012 09:44:14 PM
 */
@Secured(['permitAll'])
class RegionController {
	
	/** The navigation. */
	static navigation = [
		group:'tabs',
		order:40,
		title:'Regions',
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
        [regionInstanceList: Region.list(params), regionInstanceTotal: Region.count()]
    }

    /**
	 * Creates the.
	 * 
	 * @return the java.lang. object
	 */
    def create() {
        [regionInstance: new Region(params)]
    }

    /**
	 * Save.
	 * 
	 * @return the java.lang. object
	 */
    def save() {
        def regionInstance = new Region(params)
        if (!regionInstance.save(flush: true)) {
            render(view: "create", model: [regionInstance: regionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'region.label', default: 'Region'), regionInstance.id])
        redirect(action: "show", id: regionInstance.id)
    }

    /**
	 * Show.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def show(Long id) {
        def regionInstance = Region.get(id)
        if (!regionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'region.label', default: 'Region'), id])
            redirect(action: "list")
            return
        }

        [regionInstance: regionInstance]
    }

    /**
	 * Edits the.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def edit(Long id) {
        def regionInstance = Region.get(id)
        if (!regionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'region.label', default: 'Region'), id])
            redirect(action: "list")
            return
        }

        [regionInstance: regionInstance]
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
        def regionInstance = Region.get(id)
        if (!regionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'region.label', default: 'Region'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (regionInstance.version > version) {
                regionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'region.label', default: 'Region')] as Object[],
                          "Another user has updated this Region while you were editing")
                render(view: "edit", model: [regionInstance: regionInstance])
                return
            }
        }

        regionInstance.properties = params

        if (!regionInstance.save(flush: true)) {
            render(view: "edit", model: [regionInstance: regionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'region.label', default: 'Region'), regionInstance.id])
        redirect(action: "show", id: regionInstance.id)
    }

    /**
	 * Delete.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def delete(Long id) {
        def regionInstance = Region.get(id)
        if (!regionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'region.label', default: 'Region'), id])
            redirect(action: "list")
            return
        }

        try {
            regionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'region.label', default: 'Region'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'region.label', default: 'Region'), id])
            redirect(action: "show", id: id)
        }
    }
}
