<html xmlns:concordion="http://www.concordion.org/2007/concordion" xmlns:ext="urn:concordion-extensions:2010">
<head>
    <title>@artifact.capitalizedName@</title>
</head>
<body>

    <h1>@artifact.capitalizedName@</h1>

    <div style="background-color: #aaa; padding: 1em;">
        <p>
            Note that the following is a template example for the "@artifact.name@" specification that has been kindly 
            generated by the <a href="http://grails.org/plugin/concordion">Grails Concordion plugin</a>.
            You should change this example to adapt it conveniently to your application.
	</p>
    </div>

    <hr/>

    <h2>System Greeting</h2>

    <p>The system's greeting for any user will be "Hello [user's name]!", except if the name is Count Tyrone Rugen,
       in this case the system will say: "Hello. My name is Inigo Montoya. You killed my father. Prepare to die."        
    </p>

    <div class="example">

        <h3>Any user example</h3>

        <p>
	    The greeting for user <span concordion:set="#name">John</span> will be: 
            <span concordion:assertEquals="greetingFor(#name)">Hello John!</span>
	</p>

    </div>

    <div class="example">

        <h3>Count Tyrone Rugen example</h3>

        <p>
	    The greeting for user <span concordion:set="#name">Count Tyrone Rugen</span> will be: 
            <span concordion:assertEquals="greetingFor(#name)">Hello. My name is Inigo Montoya. You killed my father. Prepare to die.</span>
	</p>

    </div>

    <h2>Further Details</h2>
    <ul>
        <li><a href="#">Other active specification</a></li>
        <li><a href="#">Another one</a></li>
    </ul>

</body>
</html>