package pto.grails



import org.junit.*
import grails.test.mixin.*

@TestFor(SDLCController)
@Mock(SDLC)
class SDLCControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/SDLC/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.SDLCInstanceList.size() == 0
        assert model.SDLCInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.SDLCInstance != null
    }

    void testSave() {
        controller.save()

        assert model.SDLCInstance != null
        assert view == '/SDLC/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/SDLC/show/1'
        assert controller.flash.message != null
        assert SDLC.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/SDLC/list'

        populateValidParams(params)
        def SDLC = new SDLC(params)

        assert SDLC.save() != null

        params.id = SDLC.id

        def model = controller.show()

        assert model.SDLCInstance == SDLC
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/SDLC/list'

        populateValidParams(params)
        def SDLC = new SDLC(params)

        assert SDLC.save() != null

        params.id = SDLC.id

        def model = controller.edit()

        assert model.SDLCInstance == SDLC
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/SDLC/list'

        response.reset()

        populateValidParams(params)
        def SDLC = new SDLC(params)

        assert SDLC.save() != null

        // test invalid parameters in update
        params.id = SDLC.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/SDLC/edit"
        assert model.SDLCInstance != null

        SDLC.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/SDLC/show/$SDLC.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        SDLC.clearErrors()

        populateValidParams(params)
        params.id = SDLC.id
        params.version = -1
        controller.update()

        assert view == "/SDLC/edit"
        assert model.SDLCInstance != null
        assert model.SDLCInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/SDLC/list'

        response.reset()

        populateValidParams(params)
        def SDLC = new SDLC(params)

        assert SDLC.save() != null
        assert SDLC.count() == 1

        params.id = SDLC.id

        controller.delete()

        assert SDLC.count() == 0
        assert SDLC.get(SDLC.id) == null
        assert response.redirectedUrl == '/SDLC/list'
    }
}
