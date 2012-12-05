
<%@ page import="pto.grails.application.ApplicationWorkFlow" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'applicationWorkFlow.label', default: 'ApplicationWorkFlow')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-applicationWorkFlow" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-applicationWorkFlow" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list applicationWorkFlow">
			
				<g:if test="${applicationWorkFlowInstance?.applicationWorkflowName}">
				<li class="fieldcontain">
					<span id="applicationWorkflowName-label" class="property-label"><g:message code="applicationWorkFlow.applicationWorkflowName.label" default="Application Workflow Name" /></span>
					
						<span class="property-value" aria-labelledby="applicationWorkflowName-label"><g:fieldValue bean="${applicationWorkFlowInstance}" field="applicationWorkflowName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${applicationWorkFlowInstance?.questions}">
				<li class="fieldcontain">
					<span id="questions-label" class="property-label"><g:message code="applicationWorkFlow.questions.label" default="Questions" /></span>
					
						<g:each in="${applicationWorkFlowInstance.questions}" var="q">
						<span class="property-value" aria-labelledby="questions-label"><g:link controller="question" action="show" id="${q.id}">${q?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${applicationWorkFlowInstance?.id}" />
					<g:link class="edit" action="edit" id="${applicationWorkFlowInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
