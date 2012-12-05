<%@ page import="pto.grails.Workflow" %>



<div class="fieldcontain ${hasErrors(bean: workflowInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="workflow.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${workflowInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workflowInstance, field: 'questions', 'error')} ">
	<label for="questions">
		<g:message code="workflow.questions.label" default="Questions" />
		
	</label>
	<g:select name="questions" from="${pto.grails.Question.list()}" multiple="multiple" optionKey="id" size="5" value="${workflowInstance?.questions*.id}" class="many-to-many"/>
</div>

