
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
		<div id="show-pto" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pto">
			
				<g:if test="${ptoInstance?.applId}">
				<li class="fieldcontain">
					<span id="applId-label" class="property-label"><g:message code="pto.applId.label" default="Appl Id" /></span>
					
						<span class="property-value" aria-labelledby="applId-label"><g:fieldValue bean="${ptoInstance}" field="applId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.ptoHdrId}">
				<li class="fieldcontain">
					<span id="ptoHdrId-label" class="property-label"><g:message code="pto.ptoHdrId.label" default="Pto Hdr Id" /></span>
					
						<span class="property-value" aria-labelledby="ptoHdrId-label"><g:fieldValue bean="${ptoInstance}" field="ptoHdrId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.applDesc}">
				<li class="fieldcontain">
					<span id="applDesc-label" class="property-label"><g:message code="pto.applDesc.label" default="Appl Desc" /></span>
					
						<span class="property-value" aria-labelledby="applDesc-label"><g:fieldValue bean="${ptoInstance}" field="applDesc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.pto_release}">
				<li class="fieldcontain">
					<span id="pto_release-label" class="property-label"><g:message code="pto.pto_release.label" default="Ptorelease" /></span>
					
						<span class="property-value" aria-labelledby="pto_release-label"><g:fieldValue bean="${ptoInstance}" field="pto_release"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="pto.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${ptoInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.operate}">
				<li class="fieldcontain">
					<span id="operate-label" class="property-label"><g:message code="pto.operate.label" default="Operate" /></span>
					
						<span class="property-value" aria-labelledby="operate-label"><g:link controller="user" action="show" id="${ptoInstance?.operate?.id}">${ptoInstance?.operate?.firstName.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.adOperate}">
				<li class="fieldcontain">
					<span id="adOperate-label" class="property-label"><g:message code="pto.adOperate.label" default="Ad Operate" /></span>
					
						<span class="property-value" aria-labelledby="adOperate-label"><g:link controller="user" action="show" id="${ptoInstance?.adOperate?.id}">${ptoInstance?.adOperate?.firstName.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.goLiveDate}">
				<li class="fieldcontain">
					<span id="goLiveDate-label" class="property-label"><g:message code="pto.goLiveDate.label" default="Go Live Date" /></span>
					
						<span class="property-value" aria-labelledby="goLiveDate-label"><g:formatDate date="${ptoInstance?.goLiveDate}" format="yyyy-MM-dd" style="SHORT" /> </span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.businessUnit}">
				<li class="fieldcontain">
					<span id="businessUnit-label" class="property-label"><g:message code="pto.businessUnit.label" default="Business Unit" /></span>
					
						<span class="property-value" aria-labelledby="businessUnit-label"><g:link controller="businessUnit" action="show" id="${ptoInstance?.businessUnit?.id}">${ptoInstance?.businessUnit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.lob}">
				<li class="fieldcontain">
					<span id="lob-label" class="property-label"><g:message code="pto.lob.label" default="Lob" /></span>
					
						<span class="property-value" aria-labelledby="lob-label"><g:link controller="LOB" action="show" id="${ptoInstance?.lob?.id}">${ptoInstance?.lob?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="pto.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${ptoInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.CBT}">
				<li class="fieldcontain">
					<span id="CBT-label" class="property-label"><g:message code="pto.CBT.label" default="CBT" /></span>
					
						<span class="property-value" aria-labelledby="CBT-label"><g:link controller="user" action="show" id="${ptoInstance?.CBT?.id}">${ptoInstance?.CBT?.firstName.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ptoInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="pto.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:link controller="user" action="show" id="${ptoInstance?.owner?.id}">${ptoInstance?.owner?.firstName.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${ptoInstance?.id}" />
					<g:link class="edit" action="edit" id="${ptoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
