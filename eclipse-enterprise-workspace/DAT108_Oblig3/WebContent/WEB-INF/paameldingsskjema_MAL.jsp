<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<style>

</style>
<link rel="stylesheet" href="css/mainstyle.css">
<script type="text/javascript" src="js/validering.js" charset="UTF-8" defer></script>
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<div id="livepassword">
		<h3 style="margin-left:40px;">Passordet må inneholde:</h3>
		<p id="storbokstav" class="ugyldig">Minst en stor bokstav</p>
		<p id="litenbokstav" class="ugyldig">Minst en liten bokstav</p>
		<p id="nummer" class="ugyldig">Minst ett tall</p>
		<p id="attetegn" class="ugyldig">Minst 8 tegn</p>
		<p id="likepwd" class="ugyldig">Passordene må være like</p>

	</div>
	<p id="likepwd2" >Passordene er godkjent!</p>
	<form method="post" class="pure-form pure-form-aligned" style="width:400px;">
		<fieldset >

			<div  class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input onkeyup="fornavnsjekk()" id="fornavn" type="text"
					name="fornavn" value="${skjema.fornavn}" autofocus/> <p
					class="feilmelding">${skjema.fornavnFeilmelding}</p><p id="fornavnfeil" style="display:none;color:red;margin-left:40px;">Fornavn må være minst 2 bokstaver, og kan kun inneholde bokstaver, mellomrom og bindestrek.</p>
			</div>

			<div  class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input id="etternavn" onkeyup="etternavnsjekk(), fornavnerror()" type="text"
					name="etternavn" value="${skjema.etternavn}" /><p class="feilmelding">${skjema.etternavnFeilmelding}</p> <p id="etternavnfeil" style="display:none;color:red;margin-left:40px;">Etternavn må være minst 2 bokstaver, og kan kun inneholde bokstaver og bindestrek.</p>
			</div>

			<div  class="pure-control-group">
				<label for="mobil">Mobil
						(8 siffer):</label> <input id="mobil" type="text" name="mobil"
					value="${skjema.mobilnr}" onkeyup="mobilsjekk(), etternavnerror()"/> <p class="feilmelding">${skjema.mobilnrFeilmelding}</p>
				<p id="mobilfeil" style="color:red;">

				</p>

			</div>
			<p id="mobilfeil2" style="display:none;">
				Mobilnummeret må ha 8 siffer, og må ikke være separert med mellomrom.
			</p>

			<div  class="pure-control-group">
				<!-- onblur="passordSkjul()" -->
				<label for="password">Passord:</label> <input id="password" onfocus="passordVis()" onblur="passordSkjul()" onkeyup="passordLiveSjekk(), likePassord()" type="password"
					name="password" value="${skjema.passord}" /><p class="pass" style="font-color: red;"></p>
					<p class="feilmelding" >${skjema.passordFeilmelding}</p>
				
			</div>

			<div  class="pure-control-group">
				<label for="passwordrepeat">Passord repetert:</label> <input id="passwordrepeat"
					type="password" onfocus="passordVis()"onkeyup="likePassord()" onblur="passordSkjul()"name="passwordrepeat"
					value="${skjema.repeatpassord}" /><p class="passordfeil" style="font-color: red;"></p>
					<p class="feilmelding">${skjema.repeatPassordFeilmelding}</p>
				<p class="passordfeil" style="font-color: red;"></p>
			</div>

			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann" ${skjema.mannchecked} />mann <input type="radio"
					name="kjonn" value="kvinne" ${skjema.kvinnechecked} />kvinne <font
					color="red"></font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
	<div class="bruker" style="margin-left: 30px;">
		<p>Har du allerede bruker?</p>
		<a href="logginn">Logg inn her</a>
	</div>

</body>
</html>
