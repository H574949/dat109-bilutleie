package oblig2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Zarinax
 *
 */
public class UtleieKontor {

	private int kontorId;
	private String adresse;
	private int tlfNr;
	private List<Bil> biler;
	private UtleieSelskap selskap;

	/**
	 * Construtor.
	 * @param kontorId
	 * @param adresse
	 * @param tlfNr
	 * @param selskap
	 */
	public UtleieKontor(int kontorId, String adresse, int tlfNr, UtleieSelskap selskap) {
		super();
		this.kontorId = kontorId;
		this.adresse = adresse;
		this.tlfNr = tlfNr;
		this.biler = new ArrayList<Bil>();
		/** legger til biler i array */
		biler.add(new Bil("Mercedes", "SV36778", "A"));
		biler.add(new Bil("Volvo", "BT63110", "D"));
		biler.add(new Bil("Mazda", "SU1337", "C"));
		biler.add(new Bil("BMW", "EB56899", "A"));

		this.selskap = selskap;
	}
	/** 
	 * Metoden som setter i gang bilutleien.
	 */
	public void startBilutleie() {
		System.out.println("Velkommen til " + selskap.getNavn() + " Bilutleie");
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("Skriv 1 for å logge inn.");
			System.out.println("Skriv 2 for å oprette ny bruker");

			int out = scn.nextInt();
			if (out == 1 || out == 2) {
				if (out == 1) {
					System.out.println("Vennligst skriv tlfnr");
					out = scn.nextInt();
					Person pers = selskap.finnPerson(out);
					if (pers != null) {
						System.out.println("Velkommen tilbake: " + pers.toString());
						innlogget(pers, scn);
					} else
						System.err.println("Finner ikke person med dette nummeret");
				}
				if (out == 2) {
					Person pers = registrerPerson(scn);
					if (pers != null) {
						System.out.println("Velkommen som ny bruker: " + pers);
						innlogget(pers, scn);
					}
				}
			}
		}

	}
	/** 
	 * Metoden som kjøres etter bruker er innlogget.
	 * @param pers
	 * @param scn
	 */
	private void innlogget(Person pers, Scanner scn) {
		int out = 0;
		while (out != 4) {
			System.out.println("Skriv 1 for å leie bil.");
			System.out.println("Skriv 2 for å se ledige biler");
			System.out.println("Skriv 3 for å levere fra seg en bil");
			System.out.println("Skriv 4 for å logge av");
			out = scn.nextInt();

			switch (out) {
			case 1: {
				System.out.println("Skriv regNr på bilen du ønsker å leie.");
				String regNr = scn.next();
				leieBil(regNr, pers);
				break;
			}

			case 2: {
				printLedigeBiler();
				break;
			}
			
			case 3: {
				System.out.println("Skriv regNr på bilen du ønsker å levere fra deg: ");
				String regNr = scn.next();
				leverBil(regNr, pers);
			
				break;
			}
			
			case 4: {
				out = 4;
				break;
			}
			
			}

		}

	}
	/**
	 * Hjelpe metode, finner og sett bil som leid av gitt regnr og person.
	 * @param regNr
	 * @param pers
	 */
	public void leieBil(String regNr, Person pers) {
		Bil bil = finnBil(regNr);
		if (bil != null && bil.getLeidAv() == null) {
			bil.setLeidAv(pers);
			System.out.println("Gratulerer du leier nå bilen: " + bil.toString());
		} else
			System.err.println("Finner ikke ledig bil med dette registrerings nummeret.");
	}
	
	/**
	 * Hjelpemetode sette bil som uleid for gitt regNr og person.
	 * @param regNr
	 * @param pers
	 */
	public void leverBil(String regNr, Person pers) {
		Bil bil = finnBil(regNr);
		if(bil != null) {
			if(pers == bil.getLeidAv()) {
				bil.setLeidAv(null);
				System.out.println("Bilen: " + bil.toString() + " er nå levert.");
			} else System.err.println("Finner ikke bil registrert til deg med dette registererings nummeret.");
			} else System.err.println("Finner ikke bil med dette registerings nummeret.");
	}
	/** 
	 * Finner bil ved gitt regNr.
	 * @param regNr
	 * @return
	 */
	public Bil finnBil(String regNr) {
		for (Bil bil : biler) {
			if (regNr.equals(bil.getRegNr()))
				return bil;
		}
		return null;
	}
	/**
	 * Printer biler som ikke er leid.
	 */
	public void printLedigeBiler() {

		for (Bil bil : biler) {
			if (bil.getLeidAv() == null)
				System.out.println(bil);
		}
	}
/** 
 * Registrer ny bruker, gir feilmelding ved feil tlfnr. Mulighet til å avslutte ved å skrive tlfnr til 0.
 * @param scanner
 * @return
 */
	public Person registrerPerson(Scanner scanner) {
		Person pers;
		while (true) {

			System.out.println("Skriv fornavn: ");
			String fornavn = scanner.next();

			System.out.println("Skriv etternavn: ");
			String etternavn = scanner.next();

			System.out.println("Skriv Adresse navn: ");
			String adresse = scanner.next();
			System.out.println("Skriv Adresse Nr: ");
			adresse += " "+scanner.next();
			System.out.println("Skriv Post Nr: ");
			adresse += " "+scanner.next();
			System.out.println("Skriv Post Sted: ");
			adresse += " "+scanner.next();

			System.out.println("Skriv tlfnr, om du ønsker å avslutte skriv 0");
			int tlfnr = Integer.parseInt(scanner.next());
			if (tlfnr == 0)
				break;
			if (tlfnr > 9999999 && tlfnr < 99999999) {   
			pers = new Person(fornavn, etternavn, adresse, tlfnr);
			if (selskap.leggTilPerson(pers)) {
				return pers;
			} else
				System.err.println("Bruker er allerede registrert med dette telefon nummeret, prøv igjen.");
			} else System.err.println("Vennligst bruk tlfNr med 8 siffer.");
		}
		return null;
	}

	/** Getters&Setters **/
	public int getKontorId() {
		return kontorId;
	}

	public void setKontorId(int kontorId) {
		this.kontorId = kontorId;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getTlfNr() {
		return tlfNr;
	}

	public void setTlfNr(int tlfNr) {
		this.tlfNr = tlfNr;
	}

	public List<Bil> getBiler() {
		return biler;
	}

	public void setBiler(List<Bil> biler) {
		this.biler = biler;
	}

	public UtleieSelskap getSelskap() {
		return selskap;
	}

	public void setSelskap(UtleieSelskap selskap) {
		this.selskap = selskap;
	}

}
