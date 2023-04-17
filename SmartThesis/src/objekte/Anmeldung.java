package objekte;

public class Anmeldung {

	private int matrikelnummer;
	private String anmeldungStudent;
	private String anmeldungBetreuer;
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	public String getAnmeldungStudent() {
		return anmeldungStudent;
	}
	public void setAnmeldungStudent(String anmeldungStudent) {
		this.anmeldungStudent = anmeldungStudent;
	}
	public String getAnmeldungBetreuer() {
		return anmeldungBetreuer;
	}
	public void setAnmeldungBetreuer(String anmeldungBetreuer) {
		this.anmeldungBetreuer = anmeldungBetreuer;
	}
	@Override
	public String toString() {
		return "Anmeldung [matrikelnummer=" + matrikelnummer + ", anmeldungStudent=" + anmeldungStudent
				+ ", anmeldungBetreuer=" + anmeldungBetreuer + "]";
	}
	public Anmeldung(int matrikelnummer, String anmeldungStudent, String anmeldungBetreuer) {
		super();
		this.matrikelnummer = matrikelnummer;
		this.anmeldungStudent = anmeldungStudent;
		this.anmeldungBetreuer = anmeldungBetreuer;
	}
	
	
	
}
