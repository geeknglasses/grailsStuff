
<%@ page import="pto.grails.BusinessUnit"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'businessUnit.label', default: 'LOB')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	    google.load("visualization", "1", {packages:["treemap"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
    	  var data = google.visualization.arrayToDataTable([
    	                                                    ['LOB', 'Parent', 'Days to Complete', 'Days Past Target'],
    	                                                    ['Global',    null,                 0,                               0],
    	                                                    ['IB',   'Global',             12,                              -100],
    	                                                    ['FAST',    'Global',             0,                               0],
    	                                                    ['WSS',      'Global',             0,                               0],
    	                                                    ['Others', 'Global',             0,                               0],
    	                                                    ['E&H',    'IB',            11,                              10],
    	                                                    ['RT',       'IB',            52,                              31],
    	                                                    ['PB',    'IB',            24,                              12],
    	                                                    ['CE',    'IB',            16,                              -23],
    	                                                    ['CMT',    'IB',             42,                              -11]
    	                                                   
    	                                                  ]);

    	  var options = {
    			  	minColor: 'red',
    			    midColor: '#ddd',
    			    maxColor: '#0d0',
    			    headerHeight: 15,
    			    fontColor: 'black',
    			    showScale: true    	        
    	        };
        
        var chart = new google.visualization.TreeMap(document.getElementById('chart_div'));

        chart.draw(data, options);
      }
    </script>

</head>
<body onLoad="toggle()">
	<a href="#show-LOB" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="list" action="list">
					<g:message code="default.list.label" args="[entityName]" />
				</g:link></li>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
		</ul>

	</div>
	<div id="list-businessUnit" class="content scaffold-list" role="main">
		<h1>
			LOB summary
		</h1>
		<div id="chart_div" style="width: 600px; height: 300px; margin-left: 120px;"></div>
	</div>
	

</body>
</html>
