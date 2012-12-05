package pto.grails



import org.junit.*
import grails.test.mixin.*

@TestFor(LOBController)
@Mock(LOB)
class LOBControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/LOB/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.LOBInstanceList.size() == 0
        assert model.LOBInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.LOBInstance != null
    }

    void testSave() {
        controller.save()

        assert model.LOBInstance != null
        assert view == '/LOB/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/LOB/show/1'
        assert controller.flash.message != null
        assert LOB.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/LOB/list'

        populateValidParams(params)
        def LOB = new LOB(params)

        assert LOB.save() != null

        params.id = LOB.id

        def model = controller.show()

        assert model.LOBInstance == LOB
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/LOB/list'

        populateValidParams(params)
        def LOB = new LOB(params)

        assert LOB.save() != null

        params.id = LOB.id

        def model = controller.edit()

        assert model.LOBInstance == LOB
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/LOB/list'

        response.reset()

        populateValidParams(params)
        def LOB = new LOB(params)

        assert LOB.save() != null

        // test invalid parameters in update
        params.id = LOB.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/LOB/edit"
        assert model.LOBInstance != null

        LOB.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/LOB/show/$LOB.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        LOB.clearErrors()

        populateValidParams(params)
        params.id = LOB.id
        params.version = -1
        controller.update()

        assert view == "/LOB/edit"
        assert model.LOBInstance != null
        assert model.LOBInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/LOB/list'

        response.reset()

        populateValidParams(params)
        def LOB = new LOB(params)

        assert LOB.save() != null
        assert LOB.count() == 1

        params.id = LOB.id

        controller.delete()

        assert LOB.count() == 0
        assert LOB.get(LOB.id) == null
        assert response.redirectedUrl == '/LOB/list'
    }
}
