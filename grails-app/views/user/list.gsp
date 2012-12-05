
<%@ page import="pto.grails.User"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'user.label', default: 'User')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
<r:require modules="home"/>
<r:layoutResources />
<g:javascript library="prototype" />
<g:javascript library="scriptaculous" />
<filterpane:includes />
</head>
<body>
	<a href="#list-user" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
			<li><g:form action="search">
					<div class="search">
						<input type="text" name="q" value="${params.q}" /> <input
							type="submit" value="Search" />
					</div>
				</g:form></li>
			<li></li>
		</ul>
	</div>
		<div class="content-body">
	<div id="list-user" class="content scaffold-list" role="main">
		<h1>
			Users
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>

		<table>
			<thead>
				<tr>

					<g:sortableColumn property="userId"
						title="${message(code: 'user.userId.label', default: 'User Id')}" />

					

					<g:sortableColumn property="firstName"
						title="${message(code: 'user.firstName.label', default: 'First Name')}" />

					<g:sortableColumn property="lastName"
						title="${message(code: 'user.lastName.label', default: 'Last Name')}" />
						
						<g:sortableColumn property="emailId"
						title="${message(code: 'user.emailId.label', default: 'Email Id')}" />

				</tr>
			</thead>
			<tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${userInstance.id}">
								${fieldValue(bean: userInstance, field: "userId")}
							</g:link></td>

						

						<td>
							${fieldValue(bean: userInstance, field: "firstName")}
						</td>

						<td>
							${fieldValue(bean: userInstance, field: "lastName")}
						</td>
						
						<td>
							${fieldValue(bean: userInstance, field: "emailId")}
						</td>

					</tr>
				</g:each>
			</tbody>
		</table>

		<div class="pagination">
			<!-- <form id="user-form" name="user-form" method="post">
			<filterpane:filterPane id="user-filter-pane"
					domainBean="pto.grails.User"
					customForm="true"
					formName="user-form" />
				<g:actionSubmit value="Apply Filter From Outside Filter Pane"
					action="filterCustomForm" />
			</form> -->
			<g:paginate total="${userInstanceTotal}" />
			<filterpane:filterButton textKey="Filter"
				appliedTextKey="fp.tag.filterButton.appliedText" text="Filter Me"
				appliedText="Change Filter" />
		</div>

		<filterpane:filterPane domain="pto.grails.User" />

	</div>
	</div>

</body>
</html>
