package oblig2;

import java.util.HashMap;

public class BilUtleieMain {

	public static void main(String[] args) {
		UtleieSelskap selskap = new UtleieSelskap("Thomas&Andy", 12345678, "123, Fake Street 12B");
		UtleieKontor kontor = new UtleieKontor(01, "5981, NyBy 14", 49821312, selskap);
		kontor.startBilutleie();
		

	}
	
}
