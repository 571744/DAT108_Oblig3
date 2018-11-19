package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

public class Logginn {

	private String mobilnummer;
	private String clearPwd;
	private String tillatpwd = "^[a-zæøåA-ZÆØÅ0-9 -.?!]+$";
	private String tillatmobil = "^[0-9]+$";
	private String feilmelding = "";


	private DeltakerEAO deltakerEAO;

	public Logginn(HttpServletRequest request, DeltakerEAO deltakerEAO) {

		this.mobilnummer = request.getParameter("mobil");
		this.clearPwd = request.getParameter("passord");
		this.feilmelding = "";
		this.deltakerEAO = deltakerEAO;
	}

	public String getMobilnummer() {
		return mobilnummer;
	}

	public void setMobilnummer(String mobilnummer) {
		this.mobilnummer = mobilnummer;
	}

	public String getClearPwd() {
		return clearPwd;
	}

	public void setClearPwd(String clearPwd) {
		this.clearPwd = clearPwd;
	}

	public String getFeilmelding() {
		return feilmelding;
	}

	public void setFeilmelding(String feilmelding) {
		this.feilmelding = feilmelding;
	}

	public boolean sjekkLogginn() {
		if (isInputGyldig()) {

			Deltaker deltaker = deltakerEAO.hentDeltakerPaaPK(Integer.parseInt(mobilnummer));
			return PassordUtil.sjekkPassord(clearPwd, deltaker.getPassordHash());
		} else {
			return false;
		}
	}

	public void genererFeilmelding() {
		if (!isInputGyldig() || !sjekkLogginn()) {
			feilmelding = "Ugyldig brukernavn og/eller passord!";
			mobilnummer = "";
			clearPwd = "";

		} 

	}

	public boolean isInputGyldig() {
		return mobilnummer.matches(tillatmobil) && clearPwd.matches(tillatpwd);
	}

	public Deltaker hentDeltaker() {
		Deltaker deltaker = deltakerEAO.hentDeltakerPaaPK(Integer.parseInt(this.mobilnummer));
		return deltaker;
	}
}
