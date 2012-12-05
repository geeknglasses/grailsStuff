<%@ page import="pto.grails.BusinessUnit" %>



<div class="fieldcontain ${hasErrors(bean: businessUnitInstance, field: 'businessUnitAbbr', 'error')} ">
	<label for="businessUnitAbbr">
		<g:message code="businessUnit.businessUnitAbbr.label" default="Business Unit Abbr" />
		
	</label>
	<g:textField name="businessUnitAbbr" value="${businessUnitInstance?.businessUnitAbbr}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: businessUnitInstance, field: 'businessUnitName', 'error')} ">
	<label for="businessUnitName">
		<g:message code="businessUnit.businessUnitName.label" default="Business Unit Name" />
		
	</label>
	<g:textField name="businessUnitName" value="${businessUnitInstance?.businessUnitName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: businessUnitInstance, field: 'coreChecksActive', 'error')} ">
	<label for="coreChecksActive">
		<g:message code="businessUnit.coreChecksActive.label" default="Core Checks Active" />
		
	</label>
	<g:textField name="coreChecksActive" value="${businessUnitInstance?.coreChecksActive}"/>
</div>

