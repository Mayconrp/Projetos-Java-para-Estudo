function addFone() {

	var data = '{"id":"", "numero": "' + document.getElementById("fone").value
			+ '", "pessoa":""}';

	document.getElementById("fones").innerHTML = ""; 

	var telefonePessoasTemp = document.getElementById("telefonePessoasTemp").value
			.replace("[", "").replace("]", "");

	if (telefonePessoasTemp == '' || telefonePessoasTemp == null) {
		telefonePessoasTemp = data;
	} else {
		telefonePessoasTemp += ", " + data;

	}

	data = JSON.parse("[" + telefonePessoasTemp + "]");
	var table = "<table>";
	$.each(data, function(key, contato) {
		table += "<tr>";
		table += "<td>" + contato.numero + "</td>";
		table += "</tr>";
	});

	table += "</table>";
	document.getElementById("fones").innerHTML = table;

	document.getElementById("telefonePessoasTemp").value = telefonePessoasTemp;

}