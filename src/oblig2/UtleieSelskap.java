package oblig2;

import java.util.HashMap;
/**
 * 
 * @author Zarinax
 *
 */
public class UtleieSelskap {

	private String navn;
	private int telefonNr;
	private String firmaAdr;
	private HashMap<Integer, Person> personer = new HashMap<Integer,Person>();
	
	
	/**
	 * Constructor
	 * @param navn
	 * @param telefonNr
	 * @param firmaAdr
	 */
	public UtleieSelskap(String navn, int telefonNr, String firmaAdr) {
		super();
		this.navn = navn;
		this.telefonNr = telefonNr;
		this.firmaAdr = firmaAdr;
	}
	/**
	 * Legger til en person i personer(hashmap).
	 * @param person
	 * @return
	 */
	public boolean leggTilPerson(Person person) {
		if(finnPerson(person.getTlfNr()) == null) {
		personer.put(person.getTlfNr(), person);
		return true;
		} else return false;
	}
	
	/**
	 * Finner person i hashmap
	 * @param tlfnr
	 * @return
	 */
	public Person finnPerson(int tlfnr) {
		return personer.get(tlfnr);
	}
	
	
	/** getters og setters */
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public int getTelefonNr() {
		return telefonNr;
	}
	public void setTelefonNr(int telefonNr) {
		this.telefonNr = telefonNr;
	}
	public String getFirmaAdr() {
		return firmaAdr;
	}
	public void setFirmaAdr(String firmaAdr) {
		this.firmaAdr = firmaAdr;
	}
	
	
}
