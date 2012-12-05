<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>PtO - IB Architecture</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #ccc;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 90%;
				align: right;
				float: none;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.8em;
				-webkit-border-radius: 0.8em;
				border-radius: 0.8em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				margin-bottom: 0.6em;
				margin-left: 2em;
				padding: 0;
			}
            
			#status li {
				line-height: 1.3;
			}

			#status h1 {
				font-size: 1.3em;
				font-weight: bold;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 0 0 0 0em;
				font-size: 1.1em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.8;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
			<h1 align="center">Permit to Operate - IB Architecture</h1>
			<div id="page-body" role="main">
				
				The Permit to Operate tracking tool tracks the completion of all PtOs in-progress.<br> The PtO tool provides best practice compliance enabling globally consistent AD/Operate handover. <br> The PtO process that the tool supports acts as a quality check gateway into production.
				<p><i>Recent Enhancements include:</i>
				
				<ul type="square">
				<li>New globally agreed PtO checklists (contains both Operate & AD checks) </li>
				<li>Updated reference data to allow global tracking of PtOs</li>
				<li>Segregated PtOs by LoB</li>
				</ul>
			</div>
			<div>
				<p>
				<i>Further details</i>
			</div>
			<ul type="square">
				<li> <g:link url="https://confluence.uk.jpmorgan.com/confluence/display/EQOPQA/PtO+Tool">Confluence</g:link></li>
				
			</ul>
			
		</div>
		
	</body>
</html>
