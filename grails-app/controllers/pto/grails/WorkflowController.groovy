package pto.grails

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured


@Secured(['permitAll'])
class WorkflowController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	
	/** The navigation. */
	static navigation = [
		group:'tabs',
		order:4,
		title:'Workflow',
		action:'list'
	]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [workflowInstanceList: Workflow.list(params), workflowInstanceTotal: Workflow.count()]
    }

    def create() {
        [workflowInstance: new Workflow(params)]
    }

    def save() {
        def workflowInstance = new Workflow(params)
        if (!workflowInstance.save(flush: true)) {
            render(view: "create", model: [workflowInstance: workflowInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'workflow.label', default: 'Workflow'), workflowInstance.id])
        redirect(action: "show", id: workflowInstance.id)
    }

    def show(Long id) {
        def workflowInstance = Workflow.get(id)
        if (!workflowInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'workflow.label', default: 'Workflow'), id])
            redirect(action: "list")
            return
        }

        [workflowInstance: workflowInstance]
    }

    def edit(Long id) {
        def workflowInstance = Workflow.get(id)
        if (!workflowInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'workflow.label', default: 'Workflow'), id])
            redirect(action: "list")
            return
        }

        [workflowInstance: workflowInstance]
    }

    def update(Long id, Long version) {
        def workflowInstance = Workflow.get(id)
        if (!workflowInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'workflow.label', default: 'Workflow'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (workflowInstance.version > version) {
                workflowInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'workflow.label', default: 'Workflow')] as Object[],
                          "Another user has updated this Workflow while you were editing")
                render(view: "edit", model: [workflowInstance: workflowInstance])
                return
            }
        }

        workflowInstance.properties = params

        if (!workflowInstance.save(flush: true)) {
            render(view: "edit", model: [workflowInstance: workflowInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'workflow.label', default: 'Workflow'), workflowInstance.id])
        redirect(action: "show", id: workflowInstance.id)
    }

    def delete(Long id) {
        def workflowInstance = Workflow.get(id)
        if (!workflowInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'workflow.label', default: 'Workflow'), id])
            redirect(action: "list")
            return
        }

        try {
            workflowInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'workflow.label', default: 'Workflow'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'workflow.label', default: 'Workflow'), id])
            redirect(action: "show", id: id)
        }
    }
}
