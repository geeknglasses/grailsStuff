
<%@ page import="pto.grails.Pto" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pto.label', default: 'Pto')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<filterpane:includes />
		
	</head>
	<body>
		<a href="#list-pto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:form action="search">
					<div class="search">
						<input type="text" name="q" value="${params.q}" /> <input
							type="submit" value="Search" />
					</div>
				</g:form></li>
			</ul>
		</div>
		<div class="content-body">
		<div id="list-pto" class="content scaffold-list heading-font" role="main">
			<h1>PtOs</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
		</div>
		<div id="list-pto" class="content scaffold-list" role="main">
			<table>
				<thead>
					<tr>				
					
						<g:sortableColumn property="ptoApplication" title="${message(code: 'pto.ptoApplication.label', default: 'Application')}" />
						<g:sortableColumn property="releaseTitle" title="${message(code: 'pto.releaseTitle.label', default: 'Release')}" />
						
					
						<g:sortableColumn property="operateManager" title="${message(code: 'pto.operateManager.label', default: 'Operate Name')}" />
					
						<g:sortableColumn property="adManager" title="${message(code: 'pto.adManager.label', default: 'AD Name')}" />
						
						<g:sortableColumn property="goLiveDate" title="${message(code: 'pto.goLiveDate.label', default: 'Go Live Date')}" />
											
						<g:sortableColumn property="region" title="${message(code: 'pto.region.label', default: 'Region')}" />
						
						<g:sortableColumn property="lob" title="${message(code: 'pto.lob.label', default: 'LOB')}" />
						
						<g:sortableColumn property="status" title="${message(code: 'pto.status.label', default: 'Status')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${ptoInstanceList}" status="i" var="ptoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ptoInstance.id}">${fieldValue(bean: ptoInstance, field: "ptoApplication.applicationNameLong")}</g:link></td>
						
						<td>${fieldValue(bean: ptoInstance, field: "releaseTitle")}</td>
						
						<td>${fieldValue(bean: ptoInstance, field: "operateManager.firstName")}</td>
						
						<td>${fieldValue(bean: ptoInstance, field: "adManager.firstName")}</td>
						
						<td><g:formatDate date="${ptoInstance?.goLiveDate}"	format="yyyy-MM-dd" style="SHORT" /></td>
						
						<td>${fieldValue(bean: ptoInstance, field: "region.regionName")}</td>
						
						<td>${fieldValue(bean: ptoInstance, field: "lob.lobName")}</td>
						
						<td>${fieldValue(bean: ptoInstance, field: "status.display")}</td>					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ptoInstanceTotal}" />
				<filterpane:filterButton textKey="Filter"
				appliedTextKey="fp.tag.filterButton.appliedText" text="Filter Me"
				appliedText="Change Filter" />
			</div>
					<filterpane:filterPane domain="pto.grails.Pto" 
					filterPropertyValues="${[releaseType:[displayProperty:'desc'], ptoType:[displayProperty:'desc']]}"
					/>
			
		</div>
		</div>
	</body>
</html>
