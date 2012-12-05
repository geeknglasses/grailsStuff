package pto.grails

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured

import com.jpmc.ib.pto.java.adapter.PTOAdapter;
import com.jpmc.ib.pto.java.adapter.impl.PTOAdapterImpl
import com.jpmc.ib.pto.java.bean.PTOApplication;

/**
 * The Class PtoController.
 * 
 * @author W039080 Aug 15, 2012 7:49:39 PM
 */
@Secured(['permitAll'])
class PtoController {
	
	/** The navigation. */
	static navigation = [
		group:'tabs', 
		order:1, 
		title:'PtOs', 
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
	
	/** The searchable service. */
	def searchableService	
	
	/** The search. */
	def search = {
		def query = params.q + '*'
		println (query)
		if(query) {

			def searchResults = Pto.search(query, [reload: true, result: 'every'])

			render(view: "list",
					model: [ptoInstanceList: searchResults.results,
						ptoInstanceTotal:searchResults.total])
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
			model:[ ptoInstanceList: filterPaneService.filter( params, Pto ),
			ptoInstanceTotal: filterPaneService.count( params, Pto ),
			filterParams: org.grails.plugin.filterpane.FilterPaneUtils.extractFilterParams(params),
			params:params ] )
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
		System.out.println("Params " + params)
        [ptoInstanceList: Pto.list(params), ptoInstanceTotal: Pto.count()]
    }
	
	
	
    /**
	 * Creates the.
	 * 
	 * @return the java.lang. object
	 */
    def create() {
		System.out.println("Params " + params)
		[ptoInstance: new Pto(params)]
    }

    /**
	 * Save.
	 * 
	 * @return the java.lang. object
	 */
    def save() {
		System.out.println("Params " + params)
		def ptoInstance = new Pto(params)
		System.out.println("ptoInstance " + ptoInstance.goLiveDate)
		
        if (!ptoInstance.save(flush: true)) {
            render(view: "create", model: [ptoInstance: ptoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'pto.label', default: 'Pto'), ptoInstance.id])
        redirect(action: "show", id: ptoInstance.id)
    }

    /**
	 * Show.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def show(Long id) {
        def ptoInstance = Pto.get(id)
        if (!ptoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pto.label', default: 'Pto'), id])
            redirect(action: "list")
            return
        }

        [ptoInstance: ptoInstance]
    }

    /**
	 * Edits the.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def edit(Long id) {
        def ptoInstance = Pto.get(id)
        if (!ptoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pto.label', default: 'Pto'), id])
            redirect(action: "list")
            return
        }

        [ptoInstance: ptoInstance]
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
        def ptoInstance = Pto.get(id)
        if (!ptoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pto.label', default: 'Pto'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (ptoInstance.version > version) {
                ptoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'pto.label', default: 'Pto')] as Object[],
                          "Another user has updated this Pto while you were editing")
                render(view: "edit", model: [ptoInstance: ptoInstance])
                return
            }
        }

        ptoInstance.properties = params

        if (!ptoInstance.save(flush: true)) {
            render(view: "edit", model: [ptoInstance: ptoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'pto.label', default: 'Pto'), ptoInstance.id])
        redirect(action: "show", id: ptoInstance.id)
    }

    /**
	 * Delete.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
    def delete(Long id) {
        def ptoInstance = Pto.get(id)
        if (!ptoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pto.label', default: 'Pto'), id])
            redirect(action: "list")
            return
        }

        try {
            ptoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'pto.label', default: 'Pto'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pto.label', default: 'Pto'), id])
            redirect(action: "show", id: id)
        }
    }
	
	/**
	 * Seal app list.
	 * 
	 * @param id
	 *            the id
	 * @return the java.lang. object
	 */
	def sealAppList(Long id)

	{
		def ptoInstance = Pto.get(id)
		PTOAdapterImpl ptoAdapter = new PTOAdapterImpl()
		System.out.println("ptoInstance " + ptoInstance)
		def  ptoApplication = (PTOApplication) ptoAdapter.transformSEALtoPTO(ptoInstance.applId);
		System.out.println("PTO Application " + ptoApplication.getName())
		
		[ptoApplication: ptoApplication]
		
	}
	

	
}
