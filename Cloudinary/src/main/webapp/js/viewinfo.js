console.log("Abc is name");

function showPage(id, event) {
	// stops the default link behavior
	event.preventDefault();
	console.log(id);

	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(xhttp.responseText)

			let user = JSON.parse(xhttp.responseText)

			document.getElementById("userId").innerText = user.id;
			document.getElementById("userName").innerText = user.name;
			document.getElementById("isHuman").innerText = user.ishuman ? "Yes" : "No";
			document.getElementById("userImage").src = user.publicUserImageId;

			document.getElementById("popup").style.display = "block";
		}
	}

	xhttp.open("get", "/get/" + id, true)
	xhttp.send();
}


function closePopup() {
	document.getElementById("popup").style.display = "none";
}