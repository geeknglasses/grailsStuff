
<%@ page import="pto.grails.Pto"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'pto.label', default: 'PTOApplication')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-pto" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
			<li><g:link class="create" action="sealAppList">
					<g:message code="SEAL" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>
	<div id="list-pto" class="content scaffold-list" role="main">
		<h1>
			<g:message code="default.list.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>s
		</g:if>
		<table>
			<thead>
				<tr>
					<g:sortableColumn property="name"
						title="${message(code: 'pto.ptoApplication.label', default: 'PTO Application')}" />				</tr>
			</thead>
			<tbody>
			
					<tr class="even">
						<td>
							${ptoApplication.getName()}
						</td>

						
					</tr>
			
			</tbody>
		</table>
		
	</div>
</body>
</html>
