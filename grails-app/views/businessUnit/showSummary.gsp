
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
   
	</head>
	<body onLoad="toggle()">
		<a href="#show-businessUnit" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="report" action="show" id="${businessUnitInstance.id}">Details</g:link></li>
				
			</ul>
			
		</div>
		<div id="list-businessUnit" class="content scaffold-list" role="main">
			<h1>${businessUnitInstance.businessUnitName} Summary</h1>
		</div>
		<div id="chart_div"  style="width: 800px; height: 300px;"></div>
		
	</body>
</html>
