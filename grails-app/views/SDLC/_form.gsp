<%@ page import="pto.grails.SDLC" %>



<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'releaseName', 'error')} ">
	<label for="releaseName">
		<g:message code="SDLC.releaseName.label" default="Release Name" />
		
	</label>
	<g:textField name="releaseName" value="${SDLCInstance?.releaseName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="SDLC.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${SDLCInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'sdlcType', 'error')} ">
	<label for="sdlcType">
		<g:message code="SDLC.sdlcType.label" default="Sdlc Type" />
		
	</label>
	<g:textField name="sdlcType" value="${SDLCInstance?.sdlcType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'createDate', 'error')} ">
	<label for="createDate">
		<g:message code="SDLC.createDate.label" default="Create Date" />
		
	</label>
		<calendar:datePicker name="createDate" defaultValue="${new Date()}" value="${SDLCInstance?.createDate}" theme="aqua" dateFormat="%d/%m/%Y" showTime="false"/>
	
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'goLiveDate', 'error')} ">
	<label for="goLiveDate">
		<g:message code="SDLC.goLiveDate.label" default="Go Live Date" />
		
	</label>
		<calendar:datePicker name="goLiveDate" defaultValue="${new Date()}" value="${SDLCInstance?.goLiveDate}" theme="aqua" dateFormat="%d/%m/%Y" showTime="false"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'plannedCompletionDate', 'error')} ">
	<label for="plannedCompletionDate">
		<g:message code="SDLC.plannedCompletionDate.label" default="Planned Completion Date" />
		
	</label>
		<calendar:datePicker name="plannedCompletionDate" defaultValue="${new Date()}" value="${SDLCInstance?.plannedCompletionDate}" theme="aqua" dateFormat="%d/%m/%Y" showTime="false"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'actualCompletionDate', 'error')} ">
	<label for="actualCompletionDate">
		<g:message code="SDLC.actualCompletionDate.label" default="Actual Completion Date" />
		
	</label>
			<calendar:datePicker name="actualCompletionDate" defaultValue="${new Date()}" value="${SDLCInstance?.actualCompletionDate}" theme="aqua" dateFormat="%d/%m/%Y" showTime="false"/>
	
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'application', 'error')} ">
	<label for="application">
		<g:message code="SDLC.application.label" default="Application" />
		
	</label>
	<g:select id="application" name="application.id" from="${pto.grails.PtoApplication.list()}" optionKey="id" value="${SDLCInstance?.application?.id}" optionValue="applicationNameShort" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'owner', 'error')} ">
	<label for="owner">
		<g:message code="SDLC.owner.label" default="Owner" />
		
	</label>
	<g:select id="owner" name="owner.id" from="${pto.grails.User.list()}" optionKey="id" value="${SDLCInstance?.owner?.id}" optionValue="firstName" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'region', 'error')} ">
	<label for="region">
		<g:message code="SDLC.region.label" default="Region" />
		
	</label>
	<g:select id="region" name="region.id" from="${pto.grails.Region.list()}" optionKey="id" value="${SDLCInstance?.region?.id}" optionValue="regionName" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'lob', 'error')} ">
	<label for="lob">
		<g:message code="SDLC.lob.label" default="Lob" />
		
	</label>
	<g:select id="lob" name="lob.id" from="${pto.grails.LOB.list()}" optionKey="id" value="${SDLCInstance?.lob?.id}" optionValue="lobShort" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="SDLC.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${SDLCInstance?.status}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'subRegion', 'error')} ">
	<label for="subRegion">
		<g:message code="SDLC.subRegion.label" default="Sub Region" />
		
	</label>
	<g:select id="subRegion" name="subRegion.id" from="${pto.grails.Region.list()}" optionKey="id" value="${SDLCInstance?.subRegion?.id}" optionValue="regionName" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'releaseType', 'error')} ">
	<label for="releaseType">
		<g:message code="SDLC.releaseType.label" default="Release Type" />
		
	</label>
	<g:select name="releaseType" from="${pto.grails.ReleaseType?.values()}" keys="${pto.grails.ReleaseType.values()*.name()}" value="${SDLCInstance?.releaseType?.name()}" optionValue="desc"  noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'lastUpdatedBy', 'error')} ">
	<label for="lastUpdatedBy">
		<g:message code="SDLC.lastUpdatedBy.label" default="Last Updated By" />
		
	</label>
	<g:select id="lastUpdatedBy" name="lastUpdatedBy.id" from="${pto.grails.User.list()}" optionKey="id" value="${SDLCInstance?.lastUpdatedBy?.id}" optionValue="firstName" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'methodology', 'error')} ">
	<label for="methodology">
		<g:message code="SDLC.methodology.label" default="Methodology" />
		
	</label>
	<g:select id="methodology" name="methodology.id" from="${pto.grails.Methodology.list()}" optionKey="id" value="${SDLCInstance?.methodology?.id}" optionValue="methodologyName" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: SDLCInstance, field: 'businessUnit', 'error')} required">
	<label for="businessUnit">
		<g:message code="SDLC.businessUnit.label" default="Business Unit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="businessUnit" name="businessUnit.id" from="${pto.grails.BusinessUnit.list()}" optionKey="id" required="" value="${SDLCInstance?.businessUnit?.id}" optionValue="businessUnitName"class="many-to-one"/>
</div>

