
<%@ page import="pto.grails.PtoCheckArea" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ptoCheckArea.label', default: 'PtoCheckArea')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-ptoCheckArea" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div class="content-body">
		<div id="list-ptoCheckArea" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="areaName" title="${message(code: 'ptoCheckArea.areaName.label', default: 'Area Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ptoCheckAreaInstanceList}" status="i" var="ptoCheckAreaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ptoCheckAreaInstance.id}">${fieldValue(bean: ptoCheckAreaInstance, field: "areaName")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ptoCheckAreaInstanceTotal}" />
			</div>
		</div>
		</div>
	</body>
</html>
