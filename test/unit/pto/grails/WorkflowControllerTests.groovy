package pto.grails



import org.junit.*
import grails.test.mixin.*

@TestFor(WorkflowController)
@Mock(Workflow)
class WorkflowControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/workflow/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.workflowInstanceList.size() == 0
        assert model.workflowInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.workflowInstance != null
    }

    void testSave() {
        controller.save()

        assert model.workflowInstance != null
        assert view == '/workflow/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/workflow/show/1'
        assert controller.flash.message != null
        assert Workflow.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/workflow/list'

        populateValidParams(params)
        def workflow = new Workflow(params)

        assert workflow.save() != null

        params.id = workflow.id

        def model = controller.show()

        assert model.workflowInstance == workflow
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/workflow/list'

        populateValidParams(params)
        def workflow = new Workflow(params)

        assert workflow.save() != null

        params.id = workflow.id

        def model = controller.edit()

        assert model.workflowInstance == workflow
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/workflow/list'

        response.reset()

        populateValidParams(params)
        def workflow = new Workflow(params)

        assert workflow.save() != null

        // test invalid parameters in update
        params.id = workflow.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/workflow/edit"
        assert model.workflowInstance != null

        workflow.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/workflow/show/$workflow.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        workflow.clearErrors()

        populateValidParams(params)
        params.id = workflow.id
        params.version = -1
        controller.update()

        assert view == "/workflow/edit"
        assert model.workflowInstance != null
        assert model.workflowInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/workflow/list'

        response.reset()

        populateValidParams(params)
        def workflow = new Workflow(params)

        assert workflow.save() != null
        assert Workflow.count() == 1

        params.id = workflow.id

        controller.delete()

        assert Workflow.count() == 0
        assert Workflow.get(workflow.id) == null
        assert response.redirectedUrl == '/workflow/list'
    }
}
