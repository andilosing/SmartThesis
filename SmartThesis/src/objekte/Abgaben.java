package objekte;

public class Abgaben {

	private int matrikelnummer;
	private String zwischenversion;
	private String zwischenversionBest�tigung;
	private String endversion;
	private String endversionBest�tigung;
	
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	public String getZwischenversion() {
		return zwischenversion;
	}
	public void setZwischenversion(String zwischenversion) {
		this.zwischenversion = zwischenversion;
	}
	public String getZwischenversionBest�tigung() {
		return zwischenversionBest�tigung;
	}
	public void setZwischenversionBest�tigung(String zwischenversionBest�tigung) {
		this.zwischenversionBest�tigung = zwischenversionBest�tigung;
	}
	public String getEndversion() {
		return endversion;
	}
	public void setEndversion(String endversion) {
		this.endversion = endversion;
	}
	public String getEndversionBest�tigung() {
		return endversionBest�tigung;
	}
	public void setEndversionBest�tigung(String endversionBest�tigung) {
		this.endversionBest�tigung = endversionBest�tigung;
	}
	public Abgaben(int matrikelnummer, String zwischenversion, String zwischenversionBest�tigung, String endversion,
			String endversionBest�tigung) {
		super();
		this.matrikelnummer = matrikelnummer;
		this.zwischenversion = zwischenversion;
		this.zwischenversionBest�tigung = zwischenversionBest�tigung;
		this.endversion = endversion;
		this.endversionBest�tigung = endversionBest�tigung;
	}
	
	

}
