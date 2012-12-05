
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName"
	value="${message(code: 'user.label', default: 'User')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<div class="nav" role="navigation">
		<ul>
		<li>
		<a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label" /></a>
		</li>
		<li>
		<g:link	class="create" action="create">	<g:message code="default.new.label" args="[entityName]" /> </g:link>
		</li>
		</ul>		
	</div>
	<g:form action="search">
    <div class="search">
        Search Users
        <input type="text" name="q" value="${params.q}" />
        <input type="submit" value="Search" />
    </div>
</g:form>
	<div class="body">
		<h1>
			<g:message code="default.list.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<div class="list">
			<table>
				<thead>
					<tr>

						<g:sortableColumn property="userId"
							title="${message(code: 'user.userId.label', default: 'User ID')}" />
						<g:sortableColumn property="firstName"
							title="${message(code: 'user.firstName.label', default: 'First Name')}" />
						<g:sortableColumn property="lastName"
							title="${message(code: 'user.lastName.label', default: 'Last Name')}" />
						<g:sortableColumn property="emailID"
							title="${message(code: 'user.emailId.label', default: 'Email')}" />


					</tr>
				</thead>
				<tbody>
					<g:each in="${userInstanceList}" status="i" var="userInstance">
						<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

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
								${fieldValue(bean:userInstance, field:"emailId")}
							</td>
							
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
		<div class="paginateButtons">
			<g:paginate total="${userInstanceTotal}" />
		</div>
	</div>
</body>
</html>