package pto.grails.release



import org.junit.*
import grails.test.mixin.*

@TestFor(ReleaseWorkFlowController)
@Mock(ReleaseWorkFlow)
class ReleaseWorkFlowControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/releaseWorkFlow/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.releaseWorkFlowInstanceList.size() == 0
        assert model.releaseWorkFlowInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.releaseWorkFlowInstance != null
    }

    void testSave() {
        controller.save()

        assert model.releaseWorkFlowInstance != null
        assert view == '/releaseWorkFlow/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/releaseWorkFlow/show/1'
        assert controller.flash.message != null
        assert ReleaseWorkFlow.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/releaseWorkFlow/list'

        populateValidParams(params)
        def releaseWorkFlow = new ReleaseWorkFlow(params)

        assert releaseWorkFlow.save() != null

        params.id = releaseWorkFlow.id

        def model = controller.show()

        assert model.releaseWorkFlowInstance == releaseWorkFlow
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/releaseWorkFlow/list'

        populateValidParams(params)
        def releaseWorkFlow = new ReleaseWorkFlow(params)

        assert releaseWorkFlow.save() != null

        params.id = releaseWorkFlow.id

        def model = controller.edit()

        assert model.releaseWorkFlowInstance == releaseWorkFlow
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/releaseWorkFlow/list'

        response.reset()

        populateValidParams(params)
        def releaseWorkFlow = new ReleaseWorkFlow(params)

        assert releaseWorkFlow.save() != null

        // test invalid parameters in update
        params.id = releaseWorkFlow.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/releaseWorkFlow/edit"
        assert model.releaseWorkFlowInstance != null

        releaseWorkFlow.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/releaseWorkFlow/show/$releaseWorkFlow.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        releaseWorkFlow.clearErrors()

        populateValidParams(params)
        params.id = releaseWorkFlow.id
        params.version = -1
        controller.update()

        assert view == "/releaseWorkFlow/edit"
        assert model.releaseWorkFlowInstance != null
        assert model.releaseWorkFlowInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/releaseWorkFlow/list'

        response.reset()

        populateValidParams(params)
        def releaseWorkFlow = new ReleaseWorkFlow(params)

        assert releaseWorkFlow.save() != null
        assert ReleaseWorkFlow.count() == 1

        params.id = releaseWorkFlow.id

        controller.delete()

        assert ReleaseWorkFlow.count() == 0
        assert ReleaseWorkFlow.get(releaseWorkFlow.id) == null
        assert response.redirectedUrl == '/releaseWorkFlow/list'
    }
}
