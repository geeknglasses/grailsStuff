
<%@ page import="pto.grails.Pto"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'pto.label', default: 'Pto')}" />
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


					<g:sortableColumn property="businessUnitName"
						title="${message(code: 'pto.businessUnitName.label', default: 'Business Unit')}" />

					<g:sortableColumn property="applDesc"
						title="${message(code: 'pto.applDesc.label', default: 'Application')}" />

					<g:sortableColumn property="pto_release"
						title="${message(code: 'pto.pto_release.label', default: 'Release')}" />

					<g:sortableColumn property="operate.firstName"
						title="${message(code: 'pto.operate.label', default: 'Operate Name')}" />

					<g:sortableColumn property="adOperate.firstName"
						title="${message(code: 'pto.adOPerate.label', default: 'AD Name')}" />

					<g:sortableColumn property="owner.firstName"
						title="${message(code: 'pto.owner.label', default: 'Owner')}" />


					<g:sortableColumn property="goLiveDate"
						title="${message(code: 'pto.goLiveDate.label', default: 'Go Live Date')}" />

					<g:sortableColumn property="status.display"
						title="${message(code: 'pto.status.label', default: 'Status')}" />

					<g:sortableColumn property="lob.lobName"
						title="${message(code: 'pto.lob.label', default: 'LOB')}" />




				</tr>
			</thead>
			<tbody>
				<g:each in="${ptoInstanceList}" status="i" var="ptoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">


						<td>
							${fieldValue(bean: ptoInstance, field: "businessUnit.businessUnitName")}
						</td>


						<td><g:link action="sealAppList" id="${ptoInstance.id}">${fieldValue(bean: ptoInstance, field: "applId")}</g:link></td>

						<td>
							${fieldValue(bean: ptoInstance, field: "pto_release")}
						</td>

						<td>
							${fieldValue(bean: ptoInstance, field: "operate.firstName")}
						</td>

						<td>
							${fieldValue(bean: ptoInstance, field: "adOperate.firstName")}
						</td>

						<td>
							${fieldValue(bean: ptoInstance, field: "owner.firstName")}
						</td>



						<td><g:formatDate date="${ptoInstance?.goLiveDate}"
								format="yyyy-MM-dd" style="SHORT" /></td>

						<td>
							${fieldValue(bean: ptoInstance, field: "status.display")}
						</td>
						<td>
							${fieldValue(bean: ptoInstance, field: "lob.lobName")}
						</td>

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
