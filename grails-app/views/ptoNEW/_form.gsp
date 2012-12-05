<%@ page import="pto.grails.Pto" %>



<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'applId', 'error')} ">
	<label for="applId">
		<g:message code="pto.applId.label" default="Appl Id" />
		
	</label>
	<g:field name="applId" type="number" value="${ptoInstance.applId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'ptoHdrId', 'error')} ">
	<label for="ptoHdrId">
		<g:message code="pto.ptoHdrId.label" default="Pto Hdr Id" />
		
	</label>
	<g:field name="ptoHdrId" type="number" value="${ptoInstance.ptoHdrId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'applDesc', 'error')} ">
	<label for="applDesc">
		<g:message code="pto.applDesc.label" default="Appl Desc" />
		
	</label>
	<g:textField name="applDesc" value="${ptoInstance?.applDesc}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'pto_release', 'error')} ">
	<label for="pto_release">
		<g:message code="pto.pto_release.label" default="Ptorelease" />
		
	</label>
	<g:textField name="pto_release" value="${ptoInstance?.pto_release}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="pto.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${ptoInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'operate', 'error')} ">
	<label for="operate">
		<g:message code="pto.operate.label" default="Operate" />
		
	</label>
	<g:select id="operate" name="operate.id" from="${pto.grails.User.list()}" optionKey="id" value="${ptoInstance?.operate?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'adOperate', 'error')} ">
	<label for="adOperate">
		<g:message code="pto.adOperate.label" default="Ad Operate" />
		
	</label>
	<g:select id="adOperate" name="adOperate.id" from="${pto.grails.User.list()}" optionKey="id" value="${ptoInstance?.adOperate?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'goLiveDate', 'error')} ">
	<label for="goLiveDate">
		<g:message code="pto.goLiveDate.label" default="Go Live Date" />
		
	</label>

	<calendar:datePicker name="goLiveDate" defaultValue="${new Date()}" value="${ptoInstance?.goLiveDate}" theme="aqua" dateFormat="%d/%m/%Y" showTime="false"/>

	
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'businessUnit', 'error')} ">
	<label for="businessUnit">
		<g:message code="pto.businessUnit.label" default="Business Unit" />
		
	</label>
	<g:select id="businessUnit" name="businessUnit.id" from="${pto.grails.BusinessUnit.list()}" optionKey="id" value="${ptoInstance?.businessUnit?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'lob', 'error')} ">
	<label for="lob">
		<g:message code="pto.lob.label" default="Lob" />
		
	</label>
	<g:select id="lob" name="lob.id" from="${pto.grails.LOB.list()}" optionKey="id" value="${ptoInstance?.lob?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="pto.status.label" default="Status" />
		
	</label>
	<g:select name="status" from="${pto.grails.Status?.values()}" keys="${pto.grails.Status.values()*.name()}" value="${ptoInstance?.status?.name()}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'CBT', 'error')} required">
	<label for="CBT">
		<g:message code="pto.CBT.label" default="CBT" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="CBT" name="CBT.id" from="${pto.grails.User.list()}" optionKey="id" required="" value="${ptoInstance?.CBT?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ptoInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="pto.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${pto.grails.User.list()}" optionKey="id" required="" value="${ptoInstance?.owner?.id}" class="many-to-one"/>
</div>

