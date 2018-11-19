

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Ferdig</title>
<style>
.loggetUt{
float:right;
    margin-left:50px;
	font-size:30px;
    -webkit-animation-name: spin;
    -webkit-animation-duration: 4000ms;
    -webkit-animation-iteration-count: infinite;
    -webkit-animation-timing-function: linear;
    -moz-animation-name: spin;
    -moz-animation-duration: 4000ms;
    -moz-animation-iteration-count: infinite;
    -moz-animation-timing-function: linear;
    -ms-animation-name: spin;
    -ms-animation-duration: 4000ms;
    -ms-animation-iteration-count: infinite;
    -ms-animation-timing-function: linear;
    
    animation-name: spin;
    animation-duration: 4000ms;
    animation-iteration-count: infinite;
    animation-timing-function: linear;
}
@-ms-keyframes spin {
    from { -ms-transform: rotate(0deg); }
    to { -ms-transform: rotate(360deg); }
}
@-moz-keyframes spin {
    from { -moz-transform: rotate(0deg); }
    to { -moz-transform: rotate(360deg); }
}
@-webkit-keyframes spin {
    from { -webkit-transform: rotate(0deg); }
    to { -webkit-transform: rotate(360deg); }
}
@keyframes spin {
    from {
        transform:rotate(0deg);
    }
    to {
        transform:rotate(360deg);
    }

}
</style>
</head>
<body>
	<h1>Ferdig</h1>
	<p>Du er nå logget ut.</p>
	<p>
		Du må logge inn igjen for å se deltakerlisten. <a href="logginn">Logg på her</a>.
	</p>
	<p>Hvis du vil registrere en ny deltaker, <a href="skjema">klikk her</a></p>
	
	<p class="loggetUt">Velkommen tilbake!</p>
</body>
</html>