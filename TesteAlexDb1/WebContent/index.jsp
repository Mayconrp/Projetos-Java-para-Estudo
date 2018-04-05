<html>
<head>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<style>
input {
	border-radius: 3px;
	opacity: 0.7;
	filter: alpha(opacity = 70);
}

fieldset {
	border-radius: 3px;
	border-width: 1px;
}

label {
	opacity: 0.4;
	filter: alpha(opacity = 70);
	-moz-opacity: 0.70;
}

.password {
	width: 200px;
}

.perc {
	width: 30px;
	border: none;
	background: darkgray;
}

.forca {
	width: 100px;
	border: none;
	background: crimson;
}
</style>
<script>
	function validarSenha(password) {
		$.ajax({
			dataType : "json",
			type : "GET",
			url : "validarSenha",
			data : {
				password : password
			}

		}).always(function(data) {
			document.getElementById("perc").value = data.percentual + "%";
			document.getElementById("forca").value = data.forca;

			if (data.percentual >= 0 && data.percentual <= 20) {
				$("#forca").css("background-color", "#FF0000");
			} else if (data.percentual > 20 && data.percentual <= 40) {
				$("#forca").css("background-color", "#FF8C00");
			} else if (data.percentual > 40 && data.percentual <= 60) {
				$("#forca").css("background-color", "#DAA520");
			} else if (data.percentual > 60 && data.percentual <= 80) {
				$("#forca").css("background-color", "#228B22");
			} else if (data.percentual > 80) {
				$("#forca").css("background-color", "#006400");
			}

		});
	}
</script>
<body>
	<fieldset style="width: 350px;">
		<label>AVALIADOR DE SEGURANÇA DE SENHA</label>
		<fieldset>

			<table>
				<tbody>
					<tr>
						<td colspan="2"><input type="password" id="password"
							name="password" class="password"
							onkeyup="validarSenha(this.value);" /></td>
					</tr>
					<tr>
						<td><input type="text" readonly id="perc" class="perc"
							value="0%" /></td>
						<td><input type="text" readonly id="forca" class="forca"
							value="Muito Curta" /></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</fieldset>
</body>
</html>