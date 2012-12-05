
<%@ page import="pto.grails.Pto" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pto.label', default: 'Pto')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pto" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="applId" title="${message(code: 'pto.applId.label', default: 'Appl Id')}" />
					
						<g:sortableColumn property="ptoHdrId" title="${message(code: 'pto.ptoHdrId.label', default: 'Pto Hdr Id')}" />
					
						<g:sortableColumn property="applDesc" title="${message(code: 'pto.applDesc.label', default: 'Appl Desc')}" />
					
						<g:sortableColumn property="pto_release" title="${message(code: 'pto.pto_release.label', default: 'Ptorelease')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'pto.description.label', default: 'Description')}" />
					
						<th><g:message code="pto.owner.label" default="Owner" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ptoInstanceList}" status="i" var="ptoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ptoInstance.id}">${fieldValue(bean: ptoInstance, field: "applId")}</g:link></td>
					
						<td>${fieldValue(bean: ptoInstance, field: "ptoHdrId")}</td>
					
						<td>${fieldValue(bean: ptoInstance, field: "applDesc")}</td>
					
						<td>${fieldValue(bean: ptoInstance, field: "pto_release")}</td>
					
						<td>${fieldValue(bean: ptoInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: ptoInstance, field: "owner.firstName")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ptoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
