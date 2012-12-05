
<%@ page import="pto.grails.PtoApplication" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ptoApplication.label', default: 'PtoApplication')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-ptoApplication" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-ptoApplication" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list ptoApplication">
			
				<g:if test="${ptoApplicationInstance?.applicationId}">
				<li class="fieldcontain">
					<span id="applicationId-label" class="property-label"><g:message code="ptoApplication.applicationId.label" default="Application Id" /></span>
					
						<span class="property-value" aria-labelledby="applicationId-label"><g:fieldValue bean="${ptoApplicationInstance}" field="applicationId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoApplicationInstance?.applicationNameShort}">
				<li class="fieldcontain">
					<span id="applicationNameShort-label" class="property-label"><g:message code="ptoApplication.applicationNameShort.label" default="Application Name Short" /></span>
					
						<span class="property-value" aria-labelledby="applicationNameShort-label"><g:fieldValue bean="${ptoApplicationInstance}" field="applicationNameShort"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoApplicationInstance?.applicationNameLong}">
				<li class="fieldcontain">
					<span id="applicationNameLong-label" class="property-label"><g:message code="ptoApplication.applicationNameLong.label" default="Application Name Long" /></span>
					
						<span class="property-value" aria-labelledby="applicationNameLong-label"><g:fieldValue bean="${ptoApplicationInstance}" field="applicationNameLong"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoApplicationInstance?.businessUnit}">
				<li class="fieldcontain">
					<span id="businessUnit-label" class="property-label"><g:message code="ptoApplication.businessUnit.label" default="Business Unit" /></span>
					
						<span class="property-value" aria-labelledby="businessUnit-label"><g:link controller="businessUnit" action="show" id="${ptoApplicationInstance?.businessUnit?.id}">${ptoApplicationInstance?.businessUnit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoApplicationInstance?.sealApplicationId}">
				<li class="fieldcontain">
					<span id="sealApplicationId-label" class="property-label"><g:message code="ptoApplication.sealApplicationId.label" default="Seal Application Id" /></span>
					
						<span class="property-value" aria-labelledby="sealApplicationId-label"><g:fieldValue bean="${ptoApplicationInstance}" field="sealApplicationId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoApplicationInstance?.cbt}">
				<li class="fieldcontain">
					<span id="cbt-label" class="property-label"><g:message code="ptoApplication.cbt.label" default="Cbt" /></span>
					
						<span class="property-value" aria-labelledby="cbt-label"><g:link controller="user" action="show" id="${ptoApplicationInstance?.cbt?.id}">${ptoApplicationInstance?.cbt?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${ptoApplicationInstance?.id}" />
					<g:link class="edit" action="edit" id="${ptoApplicationInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
