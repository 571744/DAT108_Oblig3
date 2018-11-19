

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<p>
		<font color="red">${nosession}</font>
	</p>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
		<font color="red">${logginn.feilmelding}</font>
			<div class="pure-control-group">
				<label for="mobil">Mobil:</label> <input type="text" name="mobil" placeholder="telefonnummer" autofocus required/>
			</div>
			<div class="pure-control-group">
				<label for="passord">Passord:</label> <input type="password"
					name="passord"placeholder="&#0149;&#0149;&#0149;&#0149;&#0149;&#0149;" required/>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Logg
					inn</button>
			</div>
		</fieldset>
	</form>
	<div class="bruker" style="margin-left:30px;"><p>Har du ikke bruker? </p><a href="skjema">Opprett en her!</a></div>
	<div class="glemt" style="margin-left:30px;margin-top:20px;font-size:8px;"><p>Har du glemt passordet ditt? </p><a href="mailto:admin@arrangor.no">Kontakt arrangøren for å tilbakestille det.</a></div>
</body>
</html>