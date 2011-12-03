//
// verophyle.js
//

// load main function when page is loaded
document.addEventListener("DOMContentLoaded", setup, false);

//
function setup() {
	getDummyResponse();
}

// 
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
