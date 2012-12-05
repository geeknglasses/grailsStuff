
<%@ page import="pto.grails.BusinessUnit" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'businessUnit.label', default: 'BusinessUnit')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Month', 'Total PtOs', 'Compliant PtOs'],
          ['Apr',  30,      10],
          ['May',  35,      11],
          ['Jun',  40,       11],
          ['Jul',  50,      12]
        ]);

        var options = {
          title: 'PtO Summary',
          vAxis: {title: 'Month',  titleTextStyle: {color: '#54301A'}},
          chartArea:{left:300,top:20,width:"45%",height:"90%"}
        
        };
        options['colors'] = ['#88ABD5', '#509920'];
        
        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
     <script language="javascript"> 
function toggle() {
	var ele = document.getElementById("chart_div");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
			text.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		text.innerHTML = "hide";
	}
}
</script>
	</head>
	<body onLoad="toggle()">
		<a href="#show-businessUnit" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="report" action="showSummary" id="${businessUnitInstance.id}">Status</g:link></li>				
			</ul>
			
		</div>
	
		<div id="showscreen"  class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list businessUnit">
			
				<g:if test="${businessUnitInstance?.businessUnitAbbr}">
				<li class="fieldcontain">
					<span id="businessUnitAbbr-label" class="property-label"><g:message code="businessUnit.businessUnitAbbr.label" default="Business Unit Abbr" /></span>
					
						<span class="property-value" aria-labelledby="businessUnitAbbr-label"><g:fieldValue bean="${businessUnitInstance}" field="businessUnitAbbr"/></span>
					
				</li>
				</g:if>
			
				
				<g:if test="${businessUnitInstance?.businessUnitName}">
				<li class="fieldcontain">
					<span id="businessUnitName-label" class="property-label"><g:message code="businessUnit.businessUnitName.label" default="Business Unit Name" /></span>
					
						<span class="property-value" aria-labelledby="businessUnitName-label"><g:fieldValue bean="${businessUnitInstance}" field="businessUnitName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${businessUnitInstance?.coreChecksActive}">
				<li class="fieldcontain">
					<span id="coreChecksActive-label" class="property-label"><g:message code="businessUnit.coreChecksActive.label" default="Core Checks Active" /></span>
					
						<span class="property-value" aria-labelledby="coreChecksActive-label"><g:fieldValue bean="${businessUnitInstance}" field="coreChecksActive"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${businessUnitInstance?.id}" />
					<g:link class="edit" action="edit" id="${businessUnitInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>		
		<div id="chart_div"  style="width: 800px; height: 300px; display: none;"></div>
		
	</body>
</html>
