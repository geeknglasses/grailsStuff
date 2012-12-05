<%@ page import="pto.grails.Pto" %>



<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'applId', 'error')} ">
	<label for="applId">
		<g:message code="pto.applId.label" default="Appl Id" />
		
	</label>
	<g:field name="applId" type="number" value="${ptoInstance.applId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'ptoHdrId', 'error')} ">
	<label for="ptoHdrId">
		<g:message code="pto.ptoHdrId.label" default="Pto Hdr Id" />
		
	</label>
	<g:field name="ptoHdrId" type="number" value="${ptoInstance.ptoHdrId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'applDesc', 'error')} ">
	<label for="applDesc">
		<g:message code="pto.applDesc.label" default="Appl Desc" />
		
	</label>
	<g:textField name="applDesc" value="${ptoInstance?.applDesc}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'pto_release', 'error')} ">
	<label for="pto_release">
		<g:message code="pto.pto_release.label" default="Ptorelease" />
		
	</label>
	<g:textField name="pto_release" value="${ptoInstance?.pto_release}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="pto.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${ptoInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="pto.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${pto.grails.User.list()}" optionKey="id" required="" optionValue="firstName" class="many-to-one"/>
</div>

