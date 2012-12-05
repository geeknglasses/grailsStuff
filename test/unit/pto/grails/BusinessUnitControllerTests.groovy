package pto.grails



import org.junit.*
import grails.test.mixin.*

@TestFor(BusinessUnitController)
@Mock(BusinessUnit)
class BusinessUnitControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/businessUnit/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.businessUnitInstanceList.size() == 0
        assert model.businessUnitInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.businessUnitInstance != null
    }

    void testSave() {
        controller.save()

        assert model.businessUnitInstance != null
        assert view == '/businessUnit/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/businessUnit/show/1'
        assert controller.flash.message != null
        assert BusinessUnit.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/businessUnit/list'

        populateValidParams(params)
        def businessUnit = new BusinessUnit(params)

        assert businessUnit.save() != null

        params.id = businessUnit.id

        def model = controller.show()

        assert model.businessUnitInstance == businessUnit
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/businessUnit/list'

        populateValidParams(params)
        def businessUnit = new BusinessUnit(params)

        assert businessUnit.save() != null

        params.id = businessUnit.id

        def model = controller.edit()

        assert model.businessUnitInstance == businessUnit
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/businessUnit/list'

        response.reset()

        populateValidParams(params)
        def businessUnit = new BusinessUnit(params)

        assert businessUnit.save() != null

        // test invalid parameters in update
        params.id = businessUnit.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/businessUnit/edit"
        assert model.businessUnitInstance != null

        businessUnit.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/businessUnit/show/$businessUnit.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        businessUnit.clearErrors()

        populateValidParams(params)
        params.id = businessUnit.id
        params.version = -1
        controller.update()

        assert view == "/businessUnit/edit"
        assert model.businessUnitInstance != null
        assert model.businessUnitInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/businessUnit/list'

        response.reset()

        populateValidParams(params)
        def businessUnit = new BusinessUnit(params)

        assert businessUnit.save() != null
        assert BusinessUnit.count() == 1

        params.id = businessUnit.id

        controller.delete()

        assert BusinessUnit.count() == 0
        assert BusinessUnit.get(businessUnit.id) == null
        assert response.redirectedUrl == '/businessUnit/list'
    }
}
