let inputFnavn = document.getElementById("fornavn");
let inputEnavn = document.getElementById("etternavn");
let inputMobil = document.getElementById("mobil");
let inputPassord1 = document.getElementById("password");
let inputPassord2 = document.getElementById("passwordrepeat");
let realtimepwd = document.getElementById("livepassword");

let passordStor = document.getElementById("storbokstav");
let passordLiten = document.getElementById("litenbokstav");
let passordTall = document.getElementById("nummer");
let passordTegn = document.getElementById("attetegn");
let passordMatch = document.getElementById("likepwd");
let passordMatch2 = document.getElementById("likepwd2");
let mobilfeilJS = document.getElementById("mobilfeil2");

function passordVis() {
	realtimepwd.style.display = "block";

}
function passordLiveSjekk() {
	let numbers = /[0-9]/g;
	if (inputPassord1.value.match(numbers)) {
		passordTall.classList.remove("ugyldig");
		passordTall.classList.add("gyldig");
	} else {
		passordTall.classList.remove("gyldig");
		passordTall.classList.add("ugyldig");
	}
	let storbokstav = /[A-ZÆØÅ]/g;
	if (inputPassord1.value.match(storbokstav)) {
		passordStor.classList.remove("ugyldig");
		passordStor.classList.add("gyldig");
	} else {
		passordStor.classList.remove("gyldig");
		passordStor.classList.add("ugyldig");
	}
	let litenbokstav = /[a-zæøå]/g;
	if (inputPassord1.value.match(litenbokstav)) {
		passordLiten.classList.remove("ugyldig");
		passordLiten.classList.add("gyldig");
	} else {
		passordLiten.classList.remove("gyldig");
		passordLiten.classList.add("ugyldig");
	}

	let pwd = inputPassord1.value;
	if (pwd.length > 7) {
		passordTegn.classList.remove("ugyldig");
		passordTegn.classList.add("gyldig");
	} else {
		passordTegn.classList.remove("gyldig");
		passordTegn.classList.add("ugyldig");
	}
}

function likePassord() {
	if ((inputPassord1.value === inputPassord2.value)
			&& (inputPassord1.value.length > 7)
			&& (inputPassord1.value.match(/[a-zæøå]/g))
			&& (inputPassord1.value.match(/[A-ZÆØÅ]/g))
			&& (inputPassord1.value.match(/[0-9]/g))) {
		passordSkjul();
		passordMatch2.style.display = "block";
		document.getElementById("password").style.color = "green";
		document.getElementById("passwordrepeat").style.color = "green";
	} else {
		if (inputPassord1.value === inputPassord2.value) {
			passordMatch.classList.remove("ugyldig");
			passordMatch.classList.add("gyldig");
		} else {
			passordMatch.classList.remove("gyldig");
			passordMatch.classList.add("ugyldig");
		}
		passordVis();

		passordMatch2.style.display = "none";
		document.getElementById("password").style.color = "red";
		document.getElementById("passwordrepeat").style.color = "red";
	}
}

function passordSkjul() {
	realtimepwd.style.display = "none";
}

function mobilsjekk() {
	let numbers = '^[0-9]+$';
	if ((inputMobil.value.length === 8) && (inputMobil.value.match(numbers))) {
		mobilfeilJS.style.display = "none";
		document.getElementById("mobil").style.color = "green";
	} else {
		mobilfeilJS.style.display = "block";

		document.getElementById("mobil").style.color = "red";
	}
}

function fornavnsjekk() {
	let bokstaver = '^[A-ZÆØÅa-zæøå -]+$';
	if ((inputFnavn.value.match(bokstaver)) && (inputFnavn.value.length > 1)) {

		document.getElementById("fornavn").style.color = "green";
		document.getElementById("fornavnfeil").style.display = "none";
	} else {
		if (inputFnavn.value.length > 2) {

			document.getElementById("fornavn").style.color = "red";
			document.getElementById("fornavnfeil").style.display = "block";
		}
	}
}

function fornavnerror() {
	if (inputFnavn.value.length < 3) {
		document.getElementById("fornavn").style.color = "red";
		document.getElementById("fornavnfeil").style.display = "block";
	}

}

function etternavnsjekk() {
	let bokstaver = '^[A-ZÆØÅa-zæøå-]+$';
	if ((inputEnavn.value.match(bokstaver)) && (inputEnavn.value.length > 1)) {
		document.getElementById("etternavn").style.color = "green";
		document.getElementById("etternavnfeil").style.display = "none";
	} else {
		if (inputEnavn.value.length > 2) {
			document.getElementById("etternavn").style.color = "red";
			document.getElementById("etternavnfeil").style.display = "block";
		}
	}

}
function etternavnrror(){
	if(inputEnavn.value.length < 3){
		document.getElementById("etternavn").style.color = "red";
		document.getElementById("etternavnfeil").style.display = "block";
	}
}
