package oblig2tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oblig2.*;

class Oblig2Tester {
	private Person pers1;
	private Person pers2;
	private UtleieSelskap selsk;
	private UtleieKontor kont;

	/**Biler fra kontoret
	 * 	biler.add(new Bil("Mercedes", "SV36778", "A"));
		biler.add(new Bil("Volvo", "BT63110", "D"));
		biler.add(new Bil("Mazda", "SU1337", "C"));
		biler.add(new Bil("BMW", "EB56899", "A"));
	 */
	/**
	 * "Resetter" alle variabler før test.
	 */
	@BeforeEach
	void prep() {
		pers1 = new Person("Petter", "Solberg", "Heimdal 12, 5134 Flakka", 23145719);
		pers2 = new Person("Erna", "Honk", "Falgaten 12, 7881 Kakotoo", 81917181);
		selsk = new UtleieSelskap("TestSelskap", 58917141, "TestAdresse");
		kont = new UtleieKontor(05, "TestAdresse", 81811212, selsk);
	}
	/**
	 * tester leggtil og finn person metodene.
	 */
	@Test
	void testLeggTilOgFinnPerson() {
		selsk.leggTilPerson(pers1);
		assertEquals(pers1, selsk.finnPerson(23145719));
		assertFalse(pers2 == selsk.finnPerson(81917181));
	}
	/**
	 * Tester finnbil metoden.
	 */
	@Test
	void testFinnBil() {
		Bil tempbil = kont.finnBil("EB56899"); //forventer at vi finner en bil.
		assertTrue(tempbil != null);
		tempbil = kont.finnBil("IK19281"); //forventer at vi ikke finner en bil.
		assertTrue(tempbil == null); 
	}
	/**
	 * Test leieBil og LeverBil metodene.
	 */
	@Test
	void leieOgLevereBil() {
		kont.leieBil("SU1337", pers1);
		Bil bil = kont.finnBil("SU1337");
		assertTrue(bil.getLeidAv() == pers1);
		kont.leverBil("SU1337", pers1);
		assertFalse(bil.getLeidAv() == pers1);
		
		
	}
	
	
}
