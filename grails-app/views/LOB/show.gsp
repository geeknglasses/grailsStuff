
<%@ page import="pto.grails.LOB" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'LOB.label', default: 'LOB')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-LOB" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="report" action="showSummary" id="${LOBInstance.id}">Status</g:link></li>
			</ul>
		</div>
		<div id="showscreen" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list LOB">
			
				<g:if test="${LOBInstance?.lobShort}">
				<li class="fieldcontain">
					<span id="lobShort-label" class="property-label"><g:message code="LOB.lobShort.label" default="Lob Short" /></span>
					
						<span class="property-value" aria-labelledby="lobShort-label"><g:fieldValue bean="${LOBInstance}" field="lobShort"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${LOBInstance?.lobName}">
				<li class="fieldcontain">
					<span id="lobName-label" class="property-label"><g:message code="LOB.lobName.label" default="Lob Name" /></span>
					
						<span class="property-value" aria-labelledby="lobName-label"><g:fieldValue bean="${LOBInstance}" field="lobName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${LOBInstance?.markForEdit}">
				<li class="fieldcontain">
					<span id="markForEdit-label" class="property-label"><g:message code="LOB.markForEdit.label" default="Marked For Edit" /></span>
					
						<span class="property-value" aria-labelledby="markForEdit-label"><g:formatBoolean boolean="${LOBInstance?.markForEdit}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${LOBInstance?.businessUnit}">
				<li class="fieldcontain">
					<span id="businessUnit-label" class="property-label"><g:message code="LOB.businessUnit.label" default="Business Unit" /></span>
					
						<span class="property-value" aria-labelledby="businessUnit-label"><g:link controller="businessUnit" action="show" id="${LOBInstance?.businessUnit?.id}">${LOBInstance?.businessUnit?.businessUnitName}</g:link></span>
					
				</li>
				</g:if>
			
				
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${LOBInstance?.id}" />
					<g:link class="edit" action="edit" id="${LOBInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>		
	</body>
</html>
