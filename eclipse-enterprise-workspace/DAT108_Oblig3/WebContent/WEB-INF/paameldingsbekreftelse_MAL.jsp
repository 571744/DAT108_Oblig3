

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmeldingsbekreftelse</title>
<style>
.margin{
margin-left:30px;

}</style>
</head>
<body>
	<h2 style="margin-left:20px;">Påmeldingsbekreftelse</h2>
	<p class="margin">Påmeldingen er mottatt for</p>
	<p class="margin">
		&nbsp;&nbsp;&nbsp;${bruker.fornavn}<br />
		&nbsp;&nbsp;&nbsp;${bruker.etternavn}<br />
		&nbsp;&nbsp;&nbsp;${bruker.mobilnummer}<br /> &nbsp;&nbsp;&nbsp;${bruker.kjoenn}
	</p>
	<a class="margin" href="deltakerliste">Gå til deltagerlisten</a>
</body>
</html>