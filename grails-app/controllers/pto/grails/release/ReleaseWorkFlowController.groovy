package pto.grails.release

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured


@Secured(['permitAll'])
class ReleaseWorkFlowController {
	
	/** The navigation. */
	static navigation = [
		group:'tabs',
		order:99,
		title:'Workflow',
		action:'list'
	]

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [releaseWorkFlowInstanceList: ReleaseWorkFlow.list(params), releaseWorkFlowInstanceTotal: ReleaseWorkFlow.count()]
    }

    def create() {
        [releaseWorkFlowInstance: new ReleaseWorkFlow(params)]
    }

    def save() {
        def releaseWorkFlowInstance = new ReleaseWorkFlow(params)
        if (!releaseWorkFlowInstance.save(flush: true)) {
            render(view: "create", model: [releaseWorkFlowInstance: releaseWorkFlowInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'releaseWorkFlow.label', default: 'ReleaseWorkFlow'), releaseWorkFlowInstance.id])
        redirect(action: "show", id: releaseWorkFlowInstance.id)
    }

    def show(Long id) {
        def releaseWorkFlowInstance = ReleaseWorkFlow.get(id)
        if (!releaseWorkFlowInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'releaseWorkFlow.label', default: 'ReleaseWorkFlow'), id])
            redirect(action: "list")
            return
        }

        [releaseWorkFlowInstance: releaseWorkFlowInstance]
    }

    def edit(Long id) {
        def releaseWorkFlowInstance = ReleaseWorkFlow.get(id)
        if (!releaseWorkFlowInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'releaseWorkFlow.label', default: 'ReleaseWorkFlow'), id])
            redirect(action: "list")
            return
        }

        [releaseWorkFlowInstance: releaseWorkFlowInstance]
    }

    def update(Long id, Long version) {
        def releaseWorkFlowInstance = ReleaseWorkFlow.get(id)
        if (!releaseWorkFlowInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'releaseWorkFlow.label', default: 'ReleaseWorkFlow'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (releaseWorkFlowInstance.version > version) {
                releaseWorkFlowInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'releaseWorkFlow.label', default: 'ReleaseWorkFlow')] as Object[],
                          "Another user has updated this ReleaseWorkFlow while you were editing")
                render(view: "edit", model: [releaseWorkFlowInstance: releaseWorkFlowInstance])
                return
            }
        }

        releaseWorkFlowInstance.properties = params

        if (!releaseWorkFlowInstance.save(flush: true)) {
            render(view: "edit", model: [releaseWorkFlowInstance: releaseWorkFlowInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'releaseWorkFlow.label', default: 'ReleaseWorkFlow'), releaseWorkFlowInstance.id])
        redirect(action: "show", id: releaseWorkFlowInstance.id)
    }

    def delete(Long id) {
        def releaseWorkFlowInstance = ReleaseWorkFlow.get(id)
        if (!releaseWorkFlowInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'releaseWorkFlow.label', default: 'ReleaseWorkFlow'), id])
            redirect(action: "list")
            return
        }

        try {
            releaseWorkFlowInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'releaseWorkFlow.label', default: 'ReleaseWorkFlow'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'releaseWorkFlow.label', default: 'ReleaseWorkFlow'), id])
            redirect(action: "show", id: id)
        }
    }
}
