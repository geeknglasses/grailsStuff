<%@ page import="pto.grails.LOB" %>



<div class="fieldcontain ${hasErrors(bean: LOBInstance, field: 'lobShort', 'error')} ">
	<label for="lobShort">
		<g:message code="LOB.lobShort.label" default="Lob Short" />
		
	</label>
	<g:textField name="lobShort" value="${LOBInstance?.lobShort}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: LOBInstance, field: 'markForEdit', 'error')} ">
	<label for="markForEdit">
		<g:message code="LOB.markForEdit.label" default="Mark For Edit" />
		
	</label>
	<g:checkBox name="markForEdit" value="${LOBInstance?.markForEdit}" />
</div>

<div class="fieldcontain ${hasErrors(bean: LOBInstance, field: 'businessUnit', 'error')} required">
	<label for="businessUnit">
		<g:message code="LOB.businessUnit.label" default="Business Unit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="businessUnit" name="businessUnit.id" from="${pto.grails.BusinessUnit.list()}" optionValue="businessUnitName"  optionKey="id" required="" value="${LOBInstance?.businessUnit?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: LOBInstance, field: 'lobName', 'error')} ">
	<label for="lobName">
		<g:message code="LOB.lobName.label" default="Lob Name" />
		
	</label>
	<g:textField name="lobName" value="${LOBInstance?.lobName}"/>
</div>

