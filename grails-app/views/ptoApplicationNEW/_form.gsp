<%@ page import="pto.grails.PtoApplication" %>



<div class="fieldcontain ${hasErrors(bean: ptoApplicationInstance, field: 'applicationId', 'error')} required">
	<label for="applicationId">
		<g:message code="ptoApplication.applicationId.label" default="Application Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="applicationId" type="number" value="${ptoApplicationInstance.applicationId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoApplicationInstance, field: 'applicationNameShort', 'error')} ">
	<label for="applicationNameShort">
		<g:message code="ptoApplication.applicationNameShort.label" default="Application Name Short" />
		
	</label>
	<g:textField name="applicationNameShort" value="${ptoApplicationInstance?.applicationNameShort}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoApplicationInstance, field: 'applicationNameLong', 'error')} ">
	<label for="applicationNameLong">
		<g:message code="ptoApplication.applicationNameLong.label" default="Application Name Long" />
		
	</label>
	<g:textField name="applicationNameLong" value="${ptoApplicationInstance?.applicationNameLong}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoApplicationInstance, field: 'businessUnit', 'error')} ">
	<label for="businessUnit">
		<g:message code="ptoApplication.businessUnit.label" default="Business Unit" />
		
	</label>
	<g:select id="businessUnit" name="businessUnit.id" from="${pto.grails.BusinessUnit.list()}" optionKey="id" value="${ptoApplicationInstance?.businessUnit?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoApplicationInstance, field: 'sealApplicationId', 'error')} ">
	<label for="sealApplicationId">
		<g:message code="ptoApplication.sealApplicationId.label" default="Seal Application Id" />
		
	</label>
	<g:field name="sealApplicationId" type="number" value="${ptoApplicationInstance.sealApplicationId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoApplicationInstance, field: 'cbt', 'error')} ">
	<label for="cbt">
		<g:message code="ptoApplication.cbt.label" default="Cbt" />
		
	</label>
	<g:select id="cbt" name="cbt.id" from="${pto.grails.User.list()}" optionKey="id" value="${ptoApplicationInstance?.cbt?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

