
<%@ page import="pto.grails.SDLC" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'SDLC.label', default: 'SDLC')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-SDLC" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link action="showSummary" id="${SDLCInstance.id}">Status</g:link></li>				
				
			</ul>
		</div>
		<div id="showscreen" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list SDLC">
			
				<g:if test="${SDLCInstance?.releaseName}">
				<li class="fieldcontain">
					<span id="releaseName-label" class="property-label"><g:message code="SDLC.releaseName.label" default="Release Name" /></span>
					
						<span class="property-value" aria-labelledby="releaseName-label"><g:fieldValue bean="${SDLCInstance}" field="releaseName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="SDLC.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${SDLCInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.sdlcType}">
				<li class="fieldcontain">
					<span id="sdlcType-label" class="property-label"><g:message code="SDLC.sdlcType.label" default="Sdlc Type" /></span>
					
						<span class="property-value" aria-labelledby="sdlcType-label"><g:fieldValue bean="${SDLCInstance}" field="sdlcType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.createDate}">
				<li class="fieldcontain">
					<span id="createDate-label" class="property-label"><g:message code="SDLC.createDate.label" default="Create Date" /></span>
					
						<span class="property-value" aria-labelledby="createDate-label"><g:formatDate date="${SDLCInstance?.createDate}" format="yyyy-MM-dd" style="SHORT"  /></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.goLiveDate}">
				<li class="fieldcontain">
					<span id="goLiveDate-label" class="property-label"><g:message code="SDLC.goLiveDate.label" default="Go Live Date" /></span>
					
						<span class="property-value" aria-labelledby="goLiveDate-label"><g:formatDate date="${SDLCInstance?.goLiveDate}" format="yyyy-MM-dd" style="SHORT"  /></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.plannedCompletionDate}">
				<li class="fieldcontain">
					<span id="plannedCompletionDate-label" class="property-label"><g:message code="SDLC.plannedCompletionDate.label" default="Planned Completion Date" /></span>
					
						<span class="property-value" aria-labelledby="plannedCompletionDate-label"><g:formatDate date="${SDLCInstance?.plannedCompletionDate}" format="yyyy-MM-dd" style="SHORT"  /></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.actualCompletionDate}">
				<li class="fieldcontain">
					<span id="actualCompletionDate-label" class="property-label"><g:message code="SDLC.actualCompletionDate.label" default="Actual Completion Date" /></span>
					
						<span class="property-value" aria-labelledby="actualCompletionDate-label"><g:formatDate date="${SDLCInstance?.actualCompletionDate}" format="yyyy-MM-dd" style="SHORT" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.application}">
				<li class="fieldcontain">
					<span id="application-label" class="property-label"><g:message code="SDLC.application.label" default="Application" /></span>
					
						<span class="property-value" aria-labelledby="application-label"><g:link controller="ptoApplication" action="show" id="${SDLCInstance?.application?.id}">${SDLCInstance?.application?.applicationNameShort}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="SDLC.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:link controller="user" action="show" id="${SDLCInstance?.owner?.id}">${SDLCInstance?.owner?.firstName}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.region}">
				<li class="fieldcontain">
					<span id="region-label" class="property-label"><g:message code="SDLC.region.label" default="Region" /></span>
					
						<span class="property-value" aria-labelledby="region-label"><g:link controller="region" action="show" id="${SDLCInstance?.region?.id}">${SDLCInstance?.region?.regionName}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.lob}">
				<li class="fieldcontain">
					<span id="lob-label" class="property-label"><g:message code="SDLC.lob.label" default="Lob" /></span>
					
						<span class="property-value" aria-labelledby="lob-label"><g:link controller="LOB" action="show" id="${SDLCInstance?.lob?.id}">${SDLCInstance?.lob?.lobShort}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="SDLC.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${SDLCInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.subRegion}">
				<li class="fieldcontain">
					<span id="subRegion-label" class="property-label"><g:message code="SDLC.subRegion.label" default="Sub Region" /></span>
					
						<span class="property-value" aria-labelledby="subRegion-label"><g:link controller="region" action="show" id="${SDLCInstance?.subRegion?.id}">${SDLCInstance?.subRegion?.regionName}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.releaseType}">
				<li class="fieldcontain">
					<span id="releaseType-label" class="property-label"><g:message code="SDLC.releaseType.label" default="Release Type" /></span>
					
						<span class="property-value" aria-labelledby="releaseType-label"><g:fieldValue bean="${SDLCInstance}" field="releaseType.desc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.lastUpdatedBy}">
				<li class="fieldcontain">
					<span id="lastUpdatedBy-label" class="property-label"><g:message code="SDLC.lastUpdatedBy.label" default="Last Updated By" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdatedBy-label"><g:link controller="user" action="show" id="${SDLCInstance?.lastUpdatedBy?.id}">${SDLCInstance?.lastUpdatedBy?.firstName}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.methodology}">
				<li class="fieldcontain">
					<span id="methodology-label" class="property-label"><g:message code="SDLC.methodology.label" default="Methodology" /></span>
					
						<span class="property-value" aria-labelledby="methodology-label"><g:link controller="methodology" action="show" id="${SDLCInstance?.methodology?.id}">${SDLCInstance?.methodology?.methodologyName}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${SDLCInstance?.businessUnit}">
				<li class="fieldcontain">
					<span id="businessUnit-label" class="property-label"><g:message code="SDLC.businessUnit.label" default="Business Unit" /></span>
					
						<span class="property-value" aria-labelledby="businessUnit-label"><g:link controller="businessUnit" action="show" id="${SDLCInstance?.businessUnit?.id}">${SDLCInstance?.businessUnit?.businessUnitName}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${SDLCInstance?.id}" />
					<g:link class="edit" action="edit" id="${SDLCInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
