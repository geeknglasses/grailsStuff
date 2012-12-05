<%@ page import="pto.grails.Region" %>



<div class="fieldcontain ${hasErrors(bean: regionInstance, field: 'regionId', 'error')} required">
	<label for="regionId">
		<g:message code="region.regionId.label" default="Region Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField  name="regionId" value="${regionInstance.regionId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: regionInstance, field: 'regionName', 'error')} ">
	<label for="regionName">
		<g:message code="region.regionName.label" default="Region Name" />
		
	</label>
	<g:textField name="regionName" value="${regionInstance?.regionName}"/>
</div>

