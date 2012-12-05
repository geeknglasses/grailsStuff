<%@ page import="pto.grails.Pto" %>



<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'releaseTitle', 'error')} ">
	<label for="releaseTitle">
		<g:message code="pto.releaseTitle.label" default="Release Title" />
		
	</label>
	<g:textField name="releaseTitle" value="${ptoInstance?.releaseTitle}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="pto.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${ptoInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'ptoType', 'error')} ">
	<label for="ptoType">
		<g:message code="pto.ptoType.label" default="Pto Type" />
		
	</label>
	<g:select name="ptoType" from="${pto.grails.PtoType?.values()}" keys="${pto.grails.PtoType.values()*.name()}" value="${ptoInstance?.ptoType?.name()}" optionValue="desc" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="pto.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${pto.grails.User.list()}" optionKey="id" required="" value="${ptoInstance?.owner?.id}" optionValue="firstName" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'createDate', 'error')} ">
	<label for="createDate">
		<g:message code="pto.createDate.label" default="Create Date" />	</label>
	<calendar:datePicker name="createDate" defaultValue="${new Date()}" value="${ptoInstance?.createDate}" theme="aqua" dateFormat="%d/%m/%Y" showTime="false"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'goLiveDate', 'error')} ">
	<label for="goLiveDate">
		<g:message code="pto.goLiveDate.label" default="Go Live Date" />
		
	</label>
	<calendar:datePicker name="goLiveDate" defaultValue="${new Date()}" value="${ptoInstance?.goLiveDate}" theme="aqua" dateFormat="%d/%m/%Y" showTime="false"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'targetCompletionDate', 'error')} ">
	<label for="targetCompletionDate">
		<g:message code="pto.targetCompletionDate.label" default="Target Completion Date" />
		
	</label>
	<calendar:datePicker name="targetCompletionDate" defaultValue="${new Date()}" value="${ptoInstance?.targetCompletionDate}" theme="aqua" dateFormat="%d/%m/%Y" showTime="false"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'ptoApplication', 'error')} ">
	<label for="ptoApplication">
		<g:message code="pto.ptoApplication.label" default="Pto Application" />
		
	</label>
	<g:select id="ptoApplication" name="ptoApplication.id" from="${pto.grails.PtoApplication.list()}" optionValue="applicationNameLong" optionKey="id" value="${ptoInstance?.ptoApplication?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="pto.status.label" default="Status" />
		
	</label>
	<g:select name="status" from="${pto.grails.Status?.values()}" keys="${pto.grails.Status.values()*.name()}" value="${ptoInstance?.status?.name()}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'adManager', 'error')} required">
	<label for="adManager">
		<g:message code="pto.adManager.label" default="Ad Manager" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="adManager" name="adManager.id" from="${pto.grails.User.list()}" optionKey="id" required="" optionValue="firstName" value="${ptoInstance?.adManager?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'operateManager', 'error')} ">
	<label for="operateManager">
		<g:message code="pto.operateManager.label" default="Operate Manager" />
		
	</label>
	<g:select id="operateManager" name="operateManager.id" from="${pto.grails.User.list()}" optionKey="id" optionValue="firstName" value="${ptoInstance?.operateManager?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'databaseManager', 'error')} ">
	<label for="databaseManager">
		<g:message code="pto.databaseManager.label" default="Database Manager" />
		
	</label>
	<g:select id="databaseManager" name="databaseManager.id" from="${pto.grails.User.list()}" optionKey="id" optionValue="firstName"value="${ptoInstance?.databaseManager?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'region', 'error')} ">
	<label for="region">
		<g:message code="pto.region.label" default="Region" />
		
	</label>
	<g:select id="region" name="region.id" from="${pto.grails.Region.list()}" optionKey="id" value="${ptoInstance?.region?.id}"  optionValue="regionId" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'subRegion', 'error')} ">
	<label for="subRegion">
		<g:message code="pto.subRegion.label" default="Sub Region" />
	</label>
	<g:select id="subRegion" name="subRegion.id" from="${pto.grails.Region.list()}" optionKey="id"  value="${ptoInstance?.subRegion?.id}" optionValue="regionId"  class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'lob', 'error')} ">
	<label for="lob">
		<g:message code="pto.lob.label" default="Lob" />
	</label>
	<g:select id="lob" name="lob.id" from="${pto.grails.LOB.list()}" optionKey="id" value="${ptoInstance?.lob?.id}"  optionValue="lobShort"  class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'releaseType', 'error')} ">
	<label for="releaseType">
		<g:message code="pto.releaseType.label" default="Release Type" />
	</label>
	<g:select name="releaseType" from="${pto.grails.ReleaseType?.values()}" keys="${pto.grails.ReleaseType.values()*.name()}"  optionValue="desc" value="${ptoInstance?.releaseType?.name()}"/>
</div>

