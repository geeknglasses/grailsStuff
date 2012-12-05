package pto.grails



import org.junit.*
import grails.test.mixin.*

@TestFor(PtoApplicationController)
@Mock(PtoApplication)
class PtoApplicationControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/ptoApplication/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.ptoApplicationInstanceList.size() == 0
        assert model.ptoApplicationInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.ptoApplicationInstance != null
    }

    void testSave() {
        controller.save()

        assert model.ptoApplicationInstance != null
        assert view == '/ptoApplication/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/ptoApplication/show/1'
        assert controller.flash.message != null
        assert PtoApplication.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/ptoApplication/list'

        populateValidParams(params)
        def ptoApplication = new PtoApplication(params)

        assert ptoApplication.save() != null

        params.id = ptoApplication.id

        def model = controller.show()

        assert model.ptoApplicationInstance == ptoApplication
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/ptoApplication/list'

        populateValidParams(params)
        def ptoApplication = new PtoApplication(params)

        assert ptoApplication.save() != null

        params.id = ptoApplication.id

        def model = controller.edit()

        assert model.ptoApplicationInstance == ptoApplication
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/ptoApplication/list'

        response.reset()

        populateValidParams(params)
        def ptoApplication = new PtoApplication(params)

        assert ptoApplication.save() != null

        // test invalid parameters in update
        params.id = ptoApplication.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/ptoApplication/edit"
        assert model.ptoApplicationInstance != null

        ptoApplication.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/ptoApplication/show/$ptoApplication.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        ptoApplication.clearErrors()

        populateValidParams(params)
        params.id = ptoApplication.id
        params.version = -1
        controller.update()

        assert view == "/ptoApplication/edit"
        assert model.ptoApplicationInstance != null
        assert model.ptoApplicationInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/ptoApplication/list'

        response.reset()

        populateValidParams(params)
        def ptoApplication = new PtoApplication(params)

        assert ptoApplication.save() != null
        assert PtoApplication.count() == 1

        params.id = ptoApplication.id

        controller.delete()

        assert PtoApplication.count() == 0
        assert PtoApplication.get(ptoApplication.id) == null
        assert response.redirectedUrl == '/ptoApplication/list'
    }
}
