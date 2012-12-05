
<%@ page import="pto.grails.PtoApplication" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ptoApplication.label', default: 'PtoApplication')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-ptoApplication" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-ptoApplication" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="applicationId" title="${message(code: 'ptoApplication.applicationId.label', default: 'Application Id')}" />
					
						<g:sortableColumn property="applicationNameShort" title="${message(code: 'ptoApplication.applicationNameShort.label', default: 'Application Name Short')}" />
					
						<g:sortableColumn property="applicationNameLong" title="${message(code: 'ptoApplication.applicationNameLong.label', default: 'Application Name Long')}" />
					
						<th><g:message code="ptoApplication.businessUnit.label" default="Business Unit" /></th>
					
						<g:sortableColumn property="sealApplicationId" title="${message(code: 'ptoApplication.sealApplicationId.label', default: 'Seal Application Id')}" />
					
						<th><g:message code="ptoApplication.cbt.label" default="Cbt" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ptoApplicationInstanceList}" status="i" var="ptoApplicationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ptoApplicationInstance.id}">${fieldValue(bean: ptoApplicationInstance, field: "applicationId")}</g:link></td>
					
						<td>${fieldValue(bean: ptoApplicationInstance, field: "applicationNameShort")}</td>
					
						<td>${fieldValue(bean: ptoApplicationInstance, field: "applicationNameLong")}</td>
					
						<td>${fieldValue(bean: ptoApplicationInstance, field: "businessUnit")}</td>
					
						<td>${fieldValue(bean: ptoApplicationInstance, field: "sealApplicationId")}</td>
					
						<td>${fieldValue(bean: ptoApplicationInstance, field: "cbt")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ptoApplicationInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
