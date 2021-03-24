package oblig2;

/**
 * 
 * @author Zarinax
 *
 */
public class Bil {

	private String modell;
	private String regNr;
	private String uteleiGruppe;
	private Person leidAv;
	
	/**
	 * Constructor
	 * @param modell
	 * @param regNr
	 * @param uteleiGruppe
	 */
	public Bil(String modell, String regNr, String uteleiGruppe) {
		super();
		this.modell = modell;
		this.regNr = regNr;
		this.uteleiGruppe = uteleiGruppe;
		this.leidAv = null;
	}

	
	/** Getters & setters */
	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}

	public String getUteleiGruppe() {
		return uteleiGruppe;
	}

	public void setUteleiGruppe(String uteleiGruppe) {
		this.uteleiGruppe = uteleiGruppe;
	}

	public Person getLeidAv() {
		return leidAv;
	}

	@Override
	public String toString() {
		return "modell=" + modell + ", regNr=" + regNr + ", uteleiGruppe=" + uteleiGruppe;
	}

	public void setLeidAv(Person leidAv) {
		this.leidAv = leidAv;
	}

}
