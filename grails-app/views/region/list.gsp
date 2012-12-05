
<%@ page import="pto.grails.Region"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'region.label', default: 'Region')}" />

<title><g:message code="default.list.label" args="[entityName]" /></title>
<script type='text/javascript' src='https://www.google.com/jsapi'></script>
<script type='text/javascript'>
   google.load('visualization', '1', {'packages': ['geomap']});
   google.setOnLoadCallback(drawMap);

    function drawMap() {
      var data = google.visualization.arrayToDataTable([
        ['Country', 'PTO Compliance'],
        ['United States', 400],
        ['India', 500],
        ['United Kingdom', 500],
        ['Malaysia', 200],
        ['South Africa', 200],
        ['Nigeria', 200]
      ]);

      var options = {};
      options['colors'] = [0xF08741,0xD4E32B , 0x0A822A]; //orange colors
      options['dataMode'] = 'markers';
      options['dataMode'] = 'regions';
      var container = document.getElementById('map_canvas');
      var geomap = new google.visualization.GeoMap(container);
      geomap.draw(data, options);
  };
  </script>
  <script language="javascript"> 
function toggle() {
	var ele = document.getElementById("map_canvas");
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
<body>
	<a href="#list-region" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			
		</ul>
	</div>
	<div class="content-body">
	<div id="list-region" class="content scaffold-list" role="main">
		<h1>
			Regions
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table>
			<thead>
				<tr>

					<g:sortableColumn property="regionId"
						title="${message(code: 'region.regionId.label', default: 'Region Id')}" />

					<g:sortableColumn property="regionName"
						title="${message(code: 'region.regionName.label', default: 'Region Name')}" />

				</tr>
			</thead>
			<tbody>
				<g:each in="${regionInstanceList}" status="i" var="regionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${regionInstance.id}">
								${fieldValue(bean: regionInstance, field: "regionId")}
							</g:link></td>

						<td>
							${fieldValue(bean: regionInstance, field: "regionName")}
						</td>

					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${regionInstanceTotal}" />
			<a href="javascript:toggle();"  class="" style="">Region Summary</a>
			</div>
		<div style="width: 800px; height: 400px; margin-top: 10px; margin-left: 150px; display: none; border: 1px;" id='map_canvas'></div>
	</div>
	</div>
</body>
</html>
