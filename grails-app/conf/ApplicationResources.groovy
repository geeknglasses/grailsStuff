modules = {
    application {
        resource url:'js/application.js'
	resource url: [plugin: "prototype", dir:"js/prototype", file: "prototype.js"]
	resource url: [plugin: "prototype", dir:"js/prototype", file: "scriptaculous.js"]
	resource url: 'js/markerclusterer.js'
	resource url: 'js/myalert.js'


    }
    home {
	 resource url: [plugin: "prototype", dir: "js/prototype", file: "prototype.js"], disposition: "head"
	resource url: [plugin: "prototype", dir: "js/prototype", file: "scriptaculous.js"], disposition: "head"

 }
}