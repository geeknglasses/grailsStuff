package pto.grails

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured

import com.jpmc.ib.pto.java.adapter.PTOAdapter;
import com.jpmc.ib.pto.java.adapter.impl.PTOAdapterImpl
import com.jpmc.ib.pto.java.bean.PTOApplication;


/**
 * The Class PtoApplicationController.
 * 
 * @author W039080 Aug 17, 2012 10:43:54 PM
 */
@Secured(['permitAll'])
class PtoApplicationController {

	/** The navigation. */
	static navigation = [
		group:'tabs',
		order:20,
		title:'Applications',
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
        params.max = Math.min(max ?: 15, 100)
        [ptoApplicationInstanceList: PtoApplication.list(params), ptoApplicationInstanceTotal: PtoApplication.count()]
    }

    /**
	 * Creates the.
	 * 
	 * @return the java.lang. object
	 */
    def create() {
        [ptoApplicationInstance: new PtoApplication(params)]
    }

    /**
	 * Save.
	 * 
	 * @return the java.lang. object
	 */
    def save() {
        def ptoApplicationInstance = new PtoApplication(params)
        if (!ptoApplicationInstance.save(flush: true)) {
            render(view: "create", model: [ptoApplicationInstance: ptoApplicationInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'ptoApplication.label', default: 'PtoApplication'), ptoApplicationInstance.id])
        redirect(action: "show", id: ptoApplicationInstance.id)
    }

    /**
	 * Show.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def show(Long id) {
        def ptoApplicationInstance = PtoApplication.get(id)
        if (!ptoApplicationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ptoApplication.label', default: 'PtoApplication'), id])
            redirect(action: "list")
            return
        }

        [ptoApplicationInstance: ptoApplicationInstance]
    }

    /**
	 * Edits the.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def edit(Long id) {
        def ptoApplicationInstance = PtoApplication.get(id)
        if (!ptoApplicationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ptoApplication.label', default: 'PtoApplication'), id])
            redirect(action: "list")
            return
        }

        [ptoApplicationInstance: ptoApplicationInstance]
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
        def ptoApplicationInstance = PtoApplication.get(id)
        if (!ptoApplicationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ptoApplication.label', default: 'PtoApplication'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (ptoApplicationInstance.version > version) {
                ptoApplicationInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'ptoApplication.label', default: 'PtoApplication')] as Object[],
                          "Another user has updated this PtoApplication while you were editing")
                render(view: "edit", model: [ptoApplicationInstance: ptoApplicationInstance])
                return
            }
        }

        ptoApplicationInstance.properties = params

        if (!ptoApplicationInstance.save(flush: true)) {
            render(view: "edit", model: [ptoApplicationInstance: ptoApplicationInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'ptoApplication.label', default: 'PtoApplication'), ptoApplicationInstance.id])
        redirect(action: "show", id: ptoApplicationInstance.id)
    }

    /**
	 * Delete.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def delete(Long id) {
        def ptoApplicationInstance = PtoApplication.get(id)
        if (!ptoApplicationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ptoApplication.label', default: 'PtoApplication'), id])
            redirect(action: "list")
            return
        }

        try {
            ptoApplicationInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'ptoApplication.label', default: 'PtoApplication'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ptoApplication.label', default: 'PtoApplication'), id])
            redirect(action: "show", id: id)
        }
    }
	
	
	/**
	 * Seal app risk rating.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
	def sealAppRiskRating(Long id)
	
		{
			def ptoApplicationInstance = PtoApplication.get(id)
			PTOAdapterImpl ptoAdapter = new PTOAdapterImpl()
			System.out.println("ptoApplicationInstance " + ptoApplicationInstance)
			def  riskRating = (String) ptoAdapter.transformSEALtoPTO(ptoApplicationInstance.applId);
			System.out.println("PTO Application " + riskRating )
			
			[ptoApplication: ptoApplicationInstance]
			
		}
}
