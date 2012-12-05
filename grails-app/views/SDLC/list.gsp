
<%@ page import="pto.grails.SDLC" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'SDLC.label', default: 'SDLC')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-SDLC" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div class="content-body">
		<div id="list-SDLC" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="releaseName" title="${message(code: 'SDLC.releaseName.label', default: 'Release Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'SDLC.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="sdlcType" title="${message(code: 'SDLC.sdlcType.label', default: 'Sdlc Type')}" />
					
						<g:sortableColumn property="createDate" title="${message(code: 'SDLC.createDate.label', default: 'Create Date')}" />
					
						<g:sortableColumn property="goLiveDate" title="${message(code: 'SDLC.goLiveDate.label', default: 'Go Live Date')}" />
					
						<g:sortableColumn property="plannedCompletionDate" title="${message(code: 'SDLC.plannedCompletionDate.label', default: 'Planned Completion Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${SDLCInstanceList}" status="i" var="SDLCInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${SDLCInstance.id}">${fieldValue(bean: SDLCInstance, field: "releaseName")}</g:link></td>
					
						<td>${fieldValue(bean: SDLCInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: SDLCInstance, field: "sdlcType")}</td>
					
						<td><g:formatDate date="${SDLCInstance.createDate}" format="yyyy-MM-dd" style="SHORT" /></td>
					
						<td><g:formatDate date="${SDLCInstance.goLiveDate}" format="yyyy-MM-dd" style="SHORT" /></td>
					
						<td><g:formatDate date="${SDLCInstance.plannedCompletionDate}" format="yyyy-MM-dd" style="SHORT" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${SDLCInstanceTotal}" />
			</div>
		</div>
		</div>
	</body>
</html>
