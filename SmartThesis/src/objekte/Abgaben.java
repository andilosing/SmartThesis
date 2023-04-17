package objekte;

public class Abgaben {

	private int matrikelnummer;
	private String zwischenversion;
	private String zwischenversionBestätigung;
	private String endversion;
	private String endversionBestätigung;
	
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
	public String getZwischenversionBestätigung() {
		return zwischenversionBestätigung;
	}
	public void setZwischenversionBestätigung(String zwischenversionBestätigung) {
		this.zwischenversionBestätigung = zwischenversionBestätigung;
	}
	public String getEndversion() {
		return endversion;
	}
	public void setEndversion(String endversion) {
		this.endversion = endversion;
	}
	public String getEndversionBestätigung() {
		return endversionBestätigung;
	}
	public void setEndversionBestätigung(String endversionBestätigung) {
		this.endversionBestätigung = endversionBestätigung;
	}
	public Abgaben(int matrikelnummer, String zwischenversion, String zwischenversionBestätigung, String endversion,
			String endversionBestätigung) {
		super();
		this.matrikelnummer = matrikelnummer;
		this.zwischenversion = zwischenversion;
		this.zwischenversionBestätigung = zwischenversionBestätigung;
		this.endversion = endversion;
		this.endversionBestätigung = endversionBestätigung;
	}
	
	

}
