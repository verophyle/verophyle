//
// verophyle.js
//

// load main function when page is loaded
document.addEventListener("DOMContentLoaded", setup, false);

var defaultFiles = 
	[
	 	'js/component.js',
	 	'js/topLevelComponent.js'
    ];

// verophyle module

verophyle = { component: {} };

// top level component
var topLevelData = 
    {
    	type: 'TopLevelComponent',
    	content: "Hello, world!"
    };

//
function setup() {
	loadCode(defaultFiles);
}

//
function loadCode(files) {
	var scriptsDiv = document.getElementById('verophyle_scripts');
	
	for (var f in files) {
		var script = document.createElement('script');
		script.setAttribute('src', f);
		scriptsDiv.appendChild(script);
	}
}

// function for test service
function getDummyResponse() {
	var req = new XMLHttpRequest();
	req.open("GET", "/verophyle/dummy");
	req.onreadystatechange = function() {
		if (req.readyState === XMLHttpRequest.DONE && req.status === 200) {
			var span = document.getElementById("dummyResponse");
			span.innerText = req.responseText;
		}
	};
	req.send();
}
