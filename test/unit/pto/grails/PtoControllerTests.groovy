package pto.grails



import org.junit.*
import grails.test.mixin.*

@TestFor(PtoController)
@Mock(Pto)
class PtoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/pto/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.ptoInstanceList.size() == 0
        assert model.ptoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.ptoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.ptoInstance != null
        assert view == '/pto/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/pto/show/1'
        assert controller.flash.message != null
        assert Pto.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/pto/list'

        populateValidParams(params)
        def pto = new Pto(params)

        assert pto.save() != null

        params.id = pto.id

        def model = controller.show()

        assert model.ptoInstance == pto
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/pto/list'

        populateValidParams(params)
        def pto = new Pto(params)

        assert pto.save() != null

        params.id = pto.id

        def model = controller.edit()

        assert model.ptoInstance == pto
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/pto/list'

        response.reset()

        populateValidParams(params)
        def pto = new Pto(params)

        assert pto.save() != null

        // test invalid parameters in update
        params.id = pto.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/pto/edit"
        assert model.ptoInstance != null

        pto.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/pto/show/$pto.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        pto.clearErrors()

        populateValidParams(params)
        params.id = pto.id
        params.version = -1
        controller.update()

        assert view == "/pto/edit"
        assert model.ptoInstance != null
        assert model.ptoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/pto/list'

        response.reset()

        populateValidParams(params)
        def pto = new Pto(params)

        assert pto.save() != null
        assert Pto.count() == 1

        params.id = pto.id

        controller.delete()

        assert Pto.count() == 0
        assert Pto.get(pto.id) == null
        assert response.redirectedUrl == '/pto/list'
    }
}
