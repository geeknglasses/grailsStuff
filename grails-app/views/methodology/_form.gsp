<%@ page import="pto.grails.Methodology" %>



<div class="fieldcontain ${hasErrors(bean: methodologyInstance, field: 'methodologyName', 'error')} ">
	<label for="methodologyName">
		<g:message code="methodology.methodologyName.label" default="Methodology Name" />
		
	</label>
	<g:textField name="methodologyName" value="${methodologyInstance?.methodologyName}"/>
</div>

