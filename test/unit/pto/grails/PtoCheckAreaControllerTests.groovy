package pto.grails



import org.junit.*
import grails.test.mixin.*

@TestFor(PtoCheckAreaController)
@Mock(PtoCheckArea)
class PtoCheckAreaControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/ptoCheckArea/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.ptoCheckAreaInstanceList.size() == 0
        assert model.ptoCheckAreaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.ptoCheckAreaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.ptoCheckAreaInstance != null
        assert view == '/ptoCheckArea/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/ptoCheckArea/show/1'
        assert controller.flash.message != null
        assert PtoCheckArea.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/ptoCheckArea/list'

        populateValidParams(params)
        def ptoCheckArea = new PtoCheckArea(params)

        assert ptoCheckArea.save() != null

        params.id = ptoCheckArea.id

        def model = controller.show()

        assert model.ptoCheckAreaInstance == ptoCheckArea
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/ptoCheckArea/list'

        populateValidParams(params)
        def ptoCheckArea = new PtoCheckArea(params)

        assert ptoCheckArea.save() != null

        params.id = ptoCheckArea.id

        def model = controller.edit()

        assert model.ptoCheckAreaInstance == ptoCheckArea
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/ptoCheckArea/list'

        response.reset()

        populateValidParams(params)
        def ptoCheckArea = new PtoCheckArea(params)

        assert ptoCheckArea.save() != null

        // test invalid parameters in update
        params.id = ptoCheckArea.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/ptoCheckArea/edit"
        assert model.ptoCheckAreaInstance != null

        ptoCheckArea.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/ptoCheckArea/show/$ptoCheckArea.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        ptoCheckArea.clearErrors()

        populateValidParams(params)
        params.id = ptoCheckArea.id
        params.version = -1
        controller.update()

        assert view == "/ptoCheckArea/edit"
        assert model.ptoCheckAreaInstance != null
        assert model.ptoCheckAreaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/ptoCheckArea/list'

        response.reset()

        populateValidParams(params)
        def ptoCheckArea = new PtoCheckArea(params)

        assert ptoCheckArea.save() != null
        assert PtoCheckArea.count() == 1

        params.id = ptoCheckArea.id

        controller.delete()

        assert PtoCheckArea.count() == 0
        assert PtoCheckArea.get(ptoCheckArea.id) == null
        assert response.redirectedUrl == '/ptoCheckArea/list'
    }
}
