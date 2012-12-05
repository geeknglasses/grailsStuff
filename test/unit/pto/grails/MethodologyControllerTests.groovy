package pto.grails



import org.junit.*
import grails.test.mixin.*

@TestFor(MethodologyController)
@Mock(Methodology)
class MethodologyControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/methodology/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.methodologyInstanceList.size() == 0
        assert model.methodologyInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.methodologyInstance != null
    }

    void testSave() {
        controller.save()

        assert model.methodologyInstance != null
        assert view == '/methodology/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/methodology/show/1'
        assert controller.flash.message != null
        assert Methodology.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/methodology/list'

        populateValidParams(params)
        def methodology = new Methodology(params)

        assert methodology.save() != null

        params.id = methodology.id

        def model = controller.show()

        assert model.methodologyInstance == methodology
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/methodology/list'

        populateValidParams(params)
        def methodology = new Methodology(params)

        assert methodology.save() != null

        params.id = methodology.id

        def model = controller.edit()

        assert model.methodologyInstance == methodology
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/methodology/list'

        response.reset()

        populateValidParams(params)
        def methodology = new Methodology(params)

        assert methodology.save() != null

        // test invalid parameters in update
        params.id = methodology.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/methodology/edit"
        assert model.methodologyInstance != null

        methodology.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/methodology/show/$methodology.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        methodology.clearErrors()

        populateValidParams(params)
        params.id = methodology.id
        params.version = -1
        controller.update()

        assert view == "/methodology/edit"
        assert model.methodologyInstance != null
        assert model.methodologyInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/methodology/list'

        response.reset()

        populateValidParams(params)
        def methodology = new Methodology(params)

        assert methodology.save() != null
        assert Methodology.count() == 1

        params.id = methodology.id

        controller.delete()

        assert Methodology.count() == 0
        assert Methodology.get(methodology.id) == null
        assert response.redirectedUrl == '/methodology/list'
    }
}
