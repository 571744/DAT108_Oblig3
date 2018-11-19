package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import no.hvl.dat108.Skjema;

public class deltakerTest {
	
	
	@Test
	public void ikkeGyldigTest() {
		Skjema skjema2 = new Skjema("feil!!!", "ikke_gyldig_etternavn", "4545", "lik", "ulik");
		assertFalse(skjema2.isFornavnGyldig(skjema2.getFornavn()));
		assertFalse(skjema2.isEtternavnGyldig(skjema2.getEtternavn()));
		assertFalse(skjema2.isMobilnrGyldig(skjema2.getMobilnr()));
		assertFalse(skjema2.isPassordGyldig(skjema2.getPassord()));
		assertFalse(skjema2.isRepeatGyldig(skjema2.getRepeatpassord()));
	}
	
	@Test
	public void gyldigTest() {
		Skjema skjema = new Skjema("Siv", "Jensen", "41454145", "Are12345", "Are12345");
		assertTrue(skjema.isFornavnGyldig(skjema.getFornavn()));
		assertTrue(skjema.isEtternavnGyldig(skjema.getEtternavn()));
		//Vi kan ikke teste mobilnummer, siden den metoden sjekker om telefonnummeret eksisterer i databasen
		//og testklassen vår klarer ikke nå dit uten å skrive metodene veldig mye om.
		assertTrue(skjema.isPassordGyldig(skjema.getPassord()));
		assertTrue(skjema.isRepeatGyldig(skjema.getRepeatpassord()));
	}
	
	


}
