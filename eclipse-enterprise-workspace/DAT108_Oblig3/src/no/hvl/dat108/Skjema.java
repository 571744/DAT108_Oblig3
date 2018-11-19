package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.text.WordUtils;

public class Skjema {

	private String fornavn;
	private String fornavnFeilmelding;
	private String etternavn;
	private String etternavnFeilmelding;
	private String mobilnr;
	private String mobilnrFeilmelding;
	private String passord;
	private String passordFeilmelding;
	private String repeatPassord;
	private String repeatPassordFeilmelding;
	private String kjoenn;
	private String kjoennFeilmelding;
	private String tillatnavn = "^[a-zæøåA-ZÆØÅ -]+$";
	private String tillatpassord = "^[a-zæøåA-ZÆØÅ0-9 .-]+$";

	public Skjema(HttpServletRequest request) {

		String fnavn = (String) request.getParameter("fornavn");
		this.fornavn = WordUtils.capitalize(fnavn);
		String enavn = (String) request.getParameter("etternavn");
		this.etternavn = WordUtils.capitalize(enavn);
		this.mobilnr = (String) request.getParameter("mobil");
		this.passord = (String) request.getParameter("password");
		this.repeatPassord = (String) request.getParameter("passwordrepeat");
		this.kjoenn = (String) request.getParameter("kjonn");
		this.fornavnFeilmelding = "";
		this.etternavnFeilmelding = "";
		this.mobilnrFeilmelding = "";
		this.passordFeilmelding = "";
		this.repeatPassordFeilmelding = "";
		this.kjoennFeilmelding = "";
	}

	// Ekstra konstruktør for Test-klassen som ikke har HttPServletRequest å legge
	// som parameter
	public Skjema(String fornavn, String etternavn, String mobilnr, String passord, String repeatPassord) {
		super();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobilnr = mobilnr;
		this.passord = passord;
		this.repeatPassord = repeatPassord;

	}

	public void genererFeilmeldinger() {
		if (!isFornavnGyldig(this.fornavn)) {
			this.fornavn = "";
			this.fornavnFeilmelding = "Ugyldig fornavn!";
		}
		if (!isEtternavnGyldig(this.etternavn)) {
			this.etternavn = "";
			this.etternavnFeilmelding = "Ugyldig etternavn!";
		}
		if (!isMobilnrGyldig(this.mobilnr)) {

			this.mobilnr = "";
			this.mobilnrFeilmelding = "Ugyldig mobilnr!";

		}
		if (!isPassordGyldig(this.passord)) {
			this.passord = "";
			this.passordFeilmelding = "Ugyldig passord!";
		}
		if (!isRepeatGyldig(this.repeatPassord)) {
			this.repeatPassord = "";
			this.repeatPassordFeilmelding = "Passordene må være like!";
		}
		if (!isKjoennGyldig(this.kjoenn)) {
			this.kjoenn = "";
			this.kjoennFeilmelding = "Du må oppgi kjønn!";
		}
	}

	public boolean isAllInputGyldig() {
		return isFornavnGyldig(this.fornavn) && isEtternavnGyldig(this.etternavn) && isMobilnrGyldig(this.mobilnr)
				&& isPassordGyldig(this.passord) && isRepeatGyldig(this.repeatPassord) && isKjoennGyldig(this.kjoenn);
	}

	public boolean isFornavnGyldig(String fnavn) {
		return fnavn.matches(tillatnavn) && fnavn != null;
	}

	public boolean isEtternavnGyldig(String enavn) {
		return enavn.matches(tillatnavn) && enavn != null;
	}

	public boolean isMobilnrGyldig(String mobil) {

		try {
			int mobnr = Integer.parseInt(mobil);
			return (39999999 < mobnr && mobnr < 50000000) || (89999999 < mobnr && mobnr < 100000000);
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isPassordGyldig(String pass) {
		String litenBokstav = ".*[a-zæøå].*";
		String storBokstav = ".*[A-ZÆØÅ].*";
		String tall = ".*[0-9].*";
		return pass.matches(tillatpassord) && pass.matches(litenBokstav) && pass.matches(storBokstav)
				&& pass.matches(tall) && pass.length() >= 8 && pass != null;
	}

	public boolean isRepeatGyldig(String repeat) {

		return isPassordGyldig(this.passord) && (repeat.equals(this.passord));
	}

	public boolean isKjoennGyldig(String kjonn) {

		return "mann".equals(kjonn) || "kvinne".equals(kjonn);

	}

	public String getFornavn() {
		return fornavn;
	}

	public String getFornavnFeilmelding() {
		return fornavnFeilmelding;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getEtternavnFeilmelding() {
		return etternavnFeilmelding;
	}

	public String getMobilnr() {
		return mobilnr;
	}

	public String getMobilnrFeilmelding() {
		return mobilnrFeilmelding;
	}

	public String getPassord() {
		return passord;
	}

	public String getPassordFeilmelding() {
		return passordFeilmelding;
	}

	public String getRepeatpassord() {
		return repeatPassord;
	}

	public String getRepeatPassordFeilmelding() {
		return repeatPassordFeilmelding;
	}

	public String getKjoenn() {

		return kjoenn;
	}

	public String getKjoennFeilmelding() {
		return kjoennFeilmelding;
	}

	private String hashPassord(String passord) {
		return PassordUtil.krypterPassord(passord);

	}

	public String getMannchecked() {
		return "mann".equals(kjoenn) ? "checked" : "";
	}

	public String getKvinnechecked() {
		return "kvinne".equals(kjoenn) ? "checked" : "";
	}

	public Deltaker lagDeltaker() {
		Deltaker deltaker = new Deltaker(Integer.parseInt(this.mobilnr), this.fornavn, this.etternavn,
				hashPassord(this.passord), this.kjoenn.charAt(0));
		return deltaker;
	}

	public void alleredeRegistrert() {
		mobilnrFeilmelding = "Nummeret er allerede registrert. Forsøk å logg inn med knappen nederst på siden.";
	}

}