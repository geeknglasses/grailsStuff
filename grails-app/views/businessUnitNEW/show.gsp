
<%@ page import="pto.grails.BusinessUnit" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'businessUnit.label', default: 'BusinessUnit')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-businessUnit" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-businessUnit" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list businessUnit">
			
				<g:if test="${businessUnitInstance?.businessUnitAbbr}">
				<li class="fieldcontain">
					<span id="businessUnitAbbr-label" class="property-label"><g:message code="businessUnit.businessUnitAbbr.label" default="Business Unit Abbr" /></span>
					
						<span class="property-value" aria-labelledby="businessUnitAbbr-label"><g:fieldValue bean="${businessUnitInstance}" field="businessUnitAbbr"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${businessUnitInstance?.businessUnitId}">
				<li class="fieldcontain">
					<span id="businessUnitId-label" class="property-label"><g:message code="businessUnit.businessUnitId.label" default="Business Unit Id" /></span>
					
						<span class="property-value" aria-labelledby="businessUnitId-label"><g:fieldValue bean="${businessUnitInstance}" field="businessUnitId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${businessUnitInstance?.businessUnitName}">
				<li class="fieldcontain">
					<span id="businessUnitName-label" class="property-label"><g:message code="businessUnit.businessUnitName.label" default="Business Unit Name" /></span>
					
						<span class="property-value" aria-labelledby="businessUnitName-label"><g:fieldValue bean="${businessUnitInstance}" field="businessUnitName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${businessUnitInstance?.coreChecksActive}">
				<li class="fieldcontain">
					<span id="coreChecksActive-label" class="property-label"><g:message code="businessUnit.coreChecksActive.label" default="Core Checks Active" /></span>
					
						<span class="property-value" aria-labelledby="coreChecksActive-label"><g:fieldValue bean="${businessUnitInstance}" field="coreChecksActive"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${businessUnitInstance?.id}" />
					<g:link class="edit" action="edit" id="${businessUnitInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
