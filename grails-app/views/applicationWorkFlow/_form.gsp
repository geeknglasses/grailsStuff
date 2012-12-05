<%@ page import="pto.grails.application.ApplicationWorkFlow" %>



<div class="fieldcontain ${hasErrors(bean: applicationWorkFlowInstance, field: 'applicationWorkflowName', 'error')} ">
	<label for="applicationWorkflowName">
		<g:message code="applicationWorkFlow.applicationWorkflowName.label" default="Application Workflow Name" />
		
	</label>
	<g:textField name="applicationWorkflowName" value="${applicationWorkFlowInstance?.applicationWorkflowName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: applicationWorkFlowInstance, field: 'questions', 'error')} ">
	<label for="questions">
		<g:message code="applicationWorkFlow.questions.label" default="Questions" />
		
	</label>
	<g:select name="questions" from="${pto.grails.Question.list()}" multiple="multiple" optionKey="id" size="5" optionValue="description" value="${applicationWorkFlowInstance?.questions*.id}" class="many-to-many"/>
</div>

