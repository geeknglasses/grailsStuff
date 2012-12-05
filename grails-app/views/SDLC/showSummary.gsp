
<%@ page import="pto.grails.SDLC" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'SDLC.label', default: 'SDLC')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		<script type="text/javascript" src="https://www.google.com/jsapi"></script>
		
     <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
          var data = google.visualization.arrayToDataTable([
                                                            ['ID', 'PtS', 'PtB', 'PtT',     'PtO'],
                                                            ['CycleA',    434,              200,     114,  156],
                                                            ['CycleB',    586,              194,      146,         179],
                                                            ['CycleC',    314,               140,      190,         190],
                                                            ['CycleD',    393,              400,      178,    125]
                                                           
                                                          ]);

                                                          var options = {
                                                            title: 'Correlation between SDLC Cycles',
                                                            hAxis: {title: 'Days'},
                                                            vAxis: {title: 'Time to Complete'},
                                                            bubble: {textStyle: {fontSize: 11}}
                                                          };

        
        var chart = new google.visualization.BubbleChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
   
	</head>
	<body >
		<a href="#show-SDLC" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link action="show" id="${SDLCInstance.id}">Details</g:link></li>
				
			</ul>
			
		</div>
		<div id="list-SDLC" class="content scaffold-list" role="main">
			<h1>${SDLCInstance.releaseName} Summary</h1>
		</div>
		<div id="chart_div"  style="width: 800px; height: 300px;"></div>
		
	</body>
</html>
