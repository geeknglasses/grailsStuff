package pto.grails.application



import org.junit.*
import grails.test.mixin.*

@TestFor(ApplicationWorkFlowController)
@Mock(ApplicationWorkFlow)
class ApplicationWorkFlowControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/applicationWorkFlow/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.applicationWorkFlowInstanceList.size() == 0
        assert model.applicationWorkFlowInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.applicationWorkFlowInstance != null
    }

    void testSave() {
        controller.save()

        assert model.applicationWorkFlowInstance != null
        assert view == '/applicationWorkFlow/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/applicationWorkFlow/show/1'
        assert controller.flash.message != null
        assert ApplicationWorkFlow.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/applicationWorkFlow/list'

        populateValidParams(params)
        def applicationWorkFlow = new ApplicationWorkFlow(params)

        assert applicationWorkFlow.save() != null

        params.id = applicationWorkFlow.id

        def model = controller.show()

        assert model.applicationWorkFlowInstance == applicationWorkFlow
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/applicationWorkFlow/list'

        populateValidParams(params)
        def applicationWorkFlow = new ApplicationWorkFlow(params)

        assert applicationWorkFlow.save() != null

        params.id = applicationWorkFlow.id

        def model = controller.edit()

        assert model.applicationWorkFlowInstance == applicationWorkFlow
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/applicationWorkFlow/list'

        response.reset()

        populateValidParams(params)
        def applicationWorkFlow = new ApplicationWorkFlow(params)

        assert applicationWorkFlow.save() != null

        // test invalid parameters in update
        params.id = applicationWorkFlow.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/applicationWorkFlow/edit"
        assert model.applicationWorkFlowInstance != null

        applicationWorkFlow.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/applicationWorkFlow/show/$applicationWorkFlow.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        applicationWorkFlow.clearErrors()

        populateValidParams(params)
        params.id = applicationWorkFlow.id
        params.version = -1
        controller.update()

        assert view == "/applicationWorkFlow/edit"
        assert model.applicationWorkFlowInstance != null
        assert model.applicationWorkFlowInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/applicationWorkFlow/list'

        response.reset()

        populateValidParams(params)
        def applicationWorkFlow = new ApplicationWorkFlow(params)

        assert applicationWorkFlow.save() != null
        assert ApplicationWorkFlow.count() == 1

        params.id = applicationWorkFlow.id

        controller.delete()

        assert ApplicationWorkFlow.count() == 0
        assert ApplicationWorkFlow.get(applicationWorkFlow.id) == null
        assert response.redirectedUrl == '/applicationWorkFlow/list'
    }
}
