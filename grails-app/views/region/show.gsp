
<%@ page import="pto.grails.Region"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'region.label', default: 'Region')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>


</head>
<body>




	<a href="#show-region" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="list" action="list">
					<g:message code="default.list.label" args="[entityName]" />
				</g:link></li>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>
	<div id="showscreen"  class="content scaffold-show" role="main">
		<h1>
			<g:message code="default.show.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<ol class="property-list region">

			<g:if test="${regionInstance?.regionId}">
				<li class="fieldcontain"><span id="regionId-label"
					class="property-label"><g:message
							code="region.regionId.label" default="Region Id" /></span> <span
					class="property-value" aria-labelledby="regionId-label"><g:fieldValue
							bean="${regionInstance}" field="regionId" /></span></li>
			</g:if>

			<g:if test="${regionInstance?.regionName}">
				<li class="fieldcontain"><span id="regionName-label"
					class="property-label"><g:message
							code="region.regionName.label" default="Region Name" /></span> <span
					class="property-value" aria-labelledby="regionName-label"><g:fieldValue
							bean="${regionInstance}" field="regionName" /></span></li>
			</g:if>

		</ol>
		<g:form>
			<fieldset class="buttons">
				<g:hiddenField name="id" value="${regionInstance?.id}" />
				<g:link class="edit" action="edit" id="${regionInstance?.id}">
					<g:message code="default.button.edit.label" default="Edit" />
				</g:link>
				<g:actionSubmit class="delete" action="delete"
					value="${message(code: 'default.button.delete.label', default: 'Delete')}"
					onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
