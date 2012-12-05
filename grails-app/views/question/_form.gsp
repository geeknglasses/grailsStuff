<%@ page import="pto.grails.Question" %>



<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="question.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${questionInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'answerType', 'error')} ">
	<label for="answerType">
		<g:message code="question.answerType.label" default="Answer Type" />
		
	</label>
	<g:textField name="answerType" value="${questionInstance?.answerType}"/>
</div>

