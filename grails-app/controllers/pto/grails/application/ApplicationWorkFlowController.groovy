package pto.grails.application

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured


@Secured(['permitAll'])
class ApplicationWorkFlowController {
	
	/** The navigation. */
	static navigation = [
		group:'tabs',
		order:94,
		title:'Workflow',
		action:'list'
	]

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [applicationWorkFlowInstanceList: ApplicationWorkFlow.list(params), applicationWorkFlowInstanceTotal: ApplicationWorkFlow.count()]
    }

    def create() {
        [applicationWorkFlowInstance: new ApplicationWorkFlow(params)]
    }

    def save() {
        def applicationWorkFlowInstance = new ApplicationWorkFlow(params)
        if (!applicationWorkFlowInstance.save(flush: true)) {
            render(view: "create", model: [applicationWorkFlowInstance: applicationWorkFlowInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'applicationWorkFlow.label', default: 'ApplicationWorkFlow'), applicationWorkFlowInstance.id])
        redirect(action: "show", id: applicationWorkFlowInstance.id)
    }

    def show(Long id) {
        def applicationWorkFlowInstance = ApplicationWorkFlow.get(id)
        if (!applicationWorkFlowInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'applicationWorkFlow.label', default: 'ApplicationWorkFlow'), id])
            redirect(action: "list")
            return
        }

        [applicationWorkFlowInstance: applicationWorkFlowInstance]
    }

    def edit(Long id) {
        def applicationWorkFlowInstance = ApplicationWorkFlow.get(id)
        if (!applicationWorkFlowInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'applicationWorkFlow.label', default: 'ApplicationWorkFlow'), id])
            redirect(action: "list")
            return
        }

        [applicationWorkFlowInstance: applicationWorkFlowInstance]
    }

    def update(Long id, Long version) {
        def applicationWorkFlowInstance = ApplicationWorkFlow.get(id)
        if (!applicationWorkFlowInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'applicationWorkFlow.label', default: 'ApplicationWorkFlow'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (applicationWorkFlowInstance.version > version) {
                applicationWorkFlowInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'applicationWorkFlow.label', default: 'ApplicationWorkFlow')] as Object[],
                          "Another user has updated this ApplicationWorkFlow while you were editing")
                render(view: "edit", model: [applicationWorkFlowInstance: applicationWorkFlowInstance])
                return
            }
        }

        applicationWorkFlowInstance.properties = params

        if (!applicationWorkFlowInstance.save(flush: true)) {
            render(view: "edit", model: [applicationWorkFlowInstance: applicationWorkFlowInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'applicationWorkFlow.label', default: 'ApplicationWorkFlow'), applicationWorkFlowInstance.id])
        redirect(action: "show", id: applicationWorkFlowInstance.id)
    }

    def delete(Long id) {
        def applicationWorkFlowInstance = ApplicationWorkFlow.get(id)
        if (!applicationWorkFlowInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'applicationWorkFlow.label', default: 'ApplicationWorkFlow'), id])
            redirect(action: "list")
            return
        }

        try {
            applicationWorkFlowInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'applicationWorkFlow.label', default: 'ApplicationWorkFlow'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'applicationWorkFlow.label', default: 'ApplicationWorkFlow'), id])
            redirect(action: "show", id: id)
        }
    }
}
