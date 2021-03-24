package oblig2;
/**
 * 
 * @author Zarinax
 *
 */
public class Person {
	
	private String fornavn;
	private String etternavn;
	private String adresse;
	private int tlfNr;
	
	
	/**
	 * Constructor
	 * @param fornavn
	 * @param etternavn
	 * @param adresse
	 * @param tlfNr
	 */
	public Person(String fornavn, String etternavn, String adresse, int tlfNr) {
		super();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.tlfNr = tlfNr;
	}
	
	
	/** getters & setters */
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

	@Override
	public String toString() {
		return ("Navn: " + fornavn + " " + etternavn);
	}

	

}
