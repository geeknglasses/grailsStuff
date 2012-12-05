
<%@ page import="pto.grails.LOB" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'LOB.label', default: 'LOB')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-LOB" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="report" action="allLOBSummary">LOB Summary	</g:link></li>
			</ul>
		</div>
		<div class="content-body">
		<div id="list-LOB" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="lobShort" title="${message(code: 'LOB.lobShort.label', default: 'Lob Short')}" />
					
						<g:sortableColumn property="markForEdit" title="${message(code: 'LOB.markForEdit.label', default: 'Mark For Edit')}" />
					
						<th><g:message code="LOB.businessUnit.label" default="Business Unit" /></th>
					
						<g:sortableColumn property="lobName" title="${message(code: 'LOB.lobName.label', default: 'Lob Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${LOBInstanceList}" status="i" var="LOBInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${LOBInstance.id}">${fieldValue(bean: LOBInstance, field: "lobShort")}</g:link></td>
					
						<td><g:formatBoolean boolean="${LOBInstance.markForEdit}" /></td>
					
						<td>${fieldValue(bean: LOBInstance, field: "businessUnit.businessUnitName")}</td>
					
						<td>${fieldValue(bean: LOBInstance, field: "lobName")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${LOBInstanceTotal}" />
			</div>
		</div>
		</div>
		
	</body>
</html>
