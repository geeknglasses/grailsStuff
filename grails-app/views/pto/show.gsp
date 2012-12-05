
<%@ page import="pto.grails.Pto" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pto.label', default: 'Pto')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="showscreen" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pto">
			
				<g:if test="${ptoInstance?.releaseTitle}">
				<li class="fieldcontain">
					<span id="releaseTitle-label" class="property-label"><g:message code="pto.releaseTitle.label" default="Release Title" /></span>
					
						<span class="property-value" aria-labelledby="releaseTitle-label"><g:fieldValue bean="${ptoInstance}" field="releaseTitle"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="pto.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${ptoInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.ptoType}">
				<li class="fieldcontain">
					<span id="ptoType-label" class="property-label"><g:message code="pto.ptoType.label" default="Pto Type" /></span>
					
						<span class="property-value" aria-labelledby="ptoType-label"><g:fieldValue bean="${ptoInstance}" field="ptoType.desc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="pto.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:link controller="user" action="show" id="${ptoInstance?.owner?.id}">${ptoInstance?.owner?.firstName}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.createDate}">
				<li class="fieldcontain">
					<span id="createDate-label" class="property-label"><g:message code="pto.createDate.label" default="Create Date" /></span>
					
						<span class="property-value" aria-labelledby="createDate-label"><g:formatDate date="${ptoInstance?.createDate}"	format="yyyy-MM-dd" style="SHORT" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.goLiveDate}">
				<li class="fieldcontain">
					<span id="goLiveDate-label" class="property-label"><g:message code="pto.goLiveDate.label" default="Go Live Date" /></span>
					
						<span class="property-value" aria-labelledby="goLiveDate-label"><g:formatDate date="${ptoInstance?.goLiveDate}"	format="yyyy-MM-dd" style="SHORT" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.targetCompletionDate}">
				<li class="fieldcontain">
					<span id="targetCompletionDate-label" class="property-label"><g:message code="pto.targetCompletionDate.label" default="Target Completion Date" /></span>
					
						<span class="property-value" aria-labelledby="targetCompletionDate-label"><g:formatDate date="${ptoInstance?.targetCompletionDate}"	format="yyyy-MM-dd" style="SHORT" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.ptoApplication}">
				<li class="fieldcontain">
					<span id="ptoApplication-label" class="property-label"><g:message code="pto.ptoApplication.label" default="Pto Application" /></span>
					
						<span class="property-value" aria-labelledby="ptoApplication-label"><g:link controller="ptoApplication" action="show" id="${ptoInstance?.ptoApplication?.id}">${ptoInstance?.ptoApplication?.applicationNameLong}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="pto.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${ptoInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.adManager}">
				<li class="fieldcontain">
					<span id="adManager-label" class="property-label"><g:message code="pto.adManager.label" default="Ad Manager" /></span>
					
						<span class="property-value" aria-labelledby="adManager-label"><g:link controller="user" action="show" id="${ptoInstance?.adManager?.id}">${ptoInstance?.adManager?.firstName}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.operateManager}">
				<li class="fieldcontain">
					<span id="operateManager-label" class="property-label"><g:message code="pto.operateManager.label" default="Operate Manager" /></span>
					
						<span class="property-value" aria-labelledby="operateManager-label"><g:link controller="user" action="show" id="${ptoInstance?.operateManager?.id}">${ptoInstance?.operateManager?.firstName}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.databaseManager}">
				<li class="fieldcontain">
					<span id="databaseManager-label" class="property-label"><g:message code="pto.databaseManager.label" default="Database Manager" /></span>
					
						<span class="property-value" aria-labelledby="databaseManager-label"><g:link controller="user" action="show" id="${ptoInstance?.databaseManager?.id}">${ptoInstance?.databaseManager?.firstName}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.region}">
				<li class="fieldcontain">
					<span id="region-label" class="property-label"><g:message code="pto.region.label" default="Region" /></span>
					
						<span class="property-value" aria-labelledby="region-label"><g:link controller="region" action="show" id="${ptoInstance?.region?.id}">${ptoInstance?.region?.regionName}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.subRegion}">
				<li class="fieldcontain">
					<span id="subRegion-label" class="property-label"><g:message code="pto.subRegion.label" default="Sub Region" /></span>
					
						<span class="property-value" aria-labelledby="subRegion-label"><g:link controller="region" action="show" id="${ptoInstance?.subRegion?.id}">${ptoInstance?.subRegion?.regionName}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.lob}">
				<li class="fieldcontain">
					<span id="lob-label" class="property-label"><g:message code="pto.lob.label" default="Lob" /></span>
					
						<span class="property-value" aria-labelledby="lob-label"><g:link controller="LOB" action="show" id="${ptoInstance?.lob?.id}">${ptoInstance?.lob?.lobShort}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.releaseType}">
				<li class="fieldcontain">
					<span id="releaseType-label" class="property-label"><g:message code="pto.releaseType.label" default="Release Type" /></span>
					
						<span class="property-value" aria-labelledby="releaseType-label"><g:fieldValue bean="${ptoInstance}" field="releaseType.desc"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<form align="center">
				<fieldset class="buttons" align="center">
					<g:hiddenField name="id" value="${ptoInstance?.id}" />
					<g:link class="edit" action="edit" id="${ptoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</form>
		</div>
	</body>
</html>
