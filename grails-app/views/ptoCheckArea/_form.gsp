<%@ page import="pto.grails.PtoCheckArea" %>



<div class="fieldcontain ${hasErrors(bean: ptoCheckAreaInstance, field: 'areaName', 'error')} ">
	<label for="areaName">
		<g:message code="ptoCheckArea.areaName.label" default="Area Name" />
		
	</label>
	<g:textField name="areaName" value="${ptoCheckAreaInstance?.areaName}"/>
</div>

