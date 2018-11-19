package no.hvl.dat108;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deltaker", schema = "dat108_obl3_gr10")
public class Deltaker implements Comparable<Deltaker> {

	@Id
	private int mobilnummer;

	private String fornavn;
	private String etternavn;
	private String passordHash;
	private char kjoenn;

	public Deltaker() {
	}

	public Deltaker(int mobilnummer, String fornavn, String etternavn, String passordHash, char kjoenn) {

		this.mobilnummer = mobilnummer;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.passordHash = passordHash;
		this.kjoenn = kjoenn;
	}
	
	
	
	public int getMobilnummer() {
		return mobilnummer;
	}
	public String getFormatertnr() {
		String formatertnummer = String.valueOf(mobilnummer);


		return formatertnummer.replaceFirst("(\\d{3})(\\d{2})(\\d{3})", "$1 $2 $3");
	}

	public void setMobilnummer(int mobilnummer) {
		this.mobilnummer = mobilnummer;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getKjoenn() {
		return kjoenn == 'm' ? "Mann" : "Kvinne";
	}
	public String getTegn() {
		return kjoenn == 'm' ? "&#9794;" : "&#9792;";

	}

	public void setKjoenn(char kjonn) {
		this.kjoenn = kjonn;
	}

	public String getPassordHash() {
		return passordHash;
	}

//	public void setPassordHash(String passordHash) {
//		this.passordHash = passordHash;
//	}

	@Override
	public String toString() {
		return "Deltaker [mobilnummer=" + mobilnummer + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", kjonn="
				+ kjoenn + "]";
	}

	@Override
	public int compareTo(Deltaker d) {
		if (this.fornavn.toLowerCase().compareTo(d.getFornavn().toLowerCase()) == 0) {
			return this.etternavn.toLowerCase().compareTo(d.getEtternavn().toLowerCase());
		} else {
			return this.fornavn.toLowerCase().compareTo(d.getFornavn().toLowerCase());
		}
	}

	public static void sorter(List<Deltaker> deltakerliste) {
		Collections.sort(deltakerliste);
		

	}

}
