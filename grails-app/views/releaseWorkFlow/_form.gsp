<%@ page import="pto.grails.release.ReleaseWorkFlow" %>



<div class="fieldcontain ${hasErrors(bean: releaseWorkFlowInstance, field: 'questions', 'error')} ">
	<label for="questions">
		<g:message code="releaseWorkFlow.questions.label" default="Questions" />
		
	</label>
	<g:select name="questions" from="${pto.grails.Question.list()}" multiple="multiple" optionKey="id" size="5"  optionValue="description"  value="${releaseWorkFlowInstance?.questions*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: releaseWorkFlowInstance, field: 'releaseWorkflowName', 'error')} ">
	<label for="releaseWorkflowName">
		<g:message code="releaseWorkFlow.releaseWorkflowName.label" default="Release Workflow Name" />
		
	</label>
	<g:textField name="releaseWorkflowName" value="${releaseWorkFlowInstance?.releaseWorkflowName}"/>
</div>

