package objekte;

public class Thema {
	
	private int matrikelnummer;
	private String studentName;
	private String studentVorname;
	private String unternehmen;
	private String thema;
	private int betreuerNummer;
	private String betreuerName;
	private String emailBetreuer;
	private String nda;
	
	
	
	
	public String getEmailBetreuer() {
		return emailBetreuer;
	}
	public void setEmailBetreuer(String emailBetreuer) {
		this.emailBetreuer = emailBetreuer;
	}
	public String getNda() {
		return nda;
	}
	public void setNda(String nda) {
		this.nda = nda;
	}
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentVorname() {
		return studentVorname;
	}
	public void setStudentVorname(String studentVorname) {
		this.studentVorname = studentVorname;
	}
	public String getUnternehmen() {
		return unternehmen;
	}
	public void setUnternehmen(String unternehmen) {
		this.unternehmen = unternehmen;
	}
	public String getThema() {
		return thema;
	}
	public void setThema(String thema) {
		this.thema = thema;
	}
	public int getBetreuerNummer() {
		return betreuerNummer;
	}
	public void setBetreuerNummer(int betreuerNummer) {
		this.betreuerNummer = betreuerNummer;
	}
	public String getBetreuerName() {
		return betreuerName;
	}
	public void setBetreuerName(String betreuerName) {
		this.betreuerName = betreuerName;
	}
	@Override
	public String toString() {
		return "Thema [matrikelnummer=" + matrikelnummer + ", studentName=" + studentName + ", studentVorname="
				+ studentVorname + ", unternehmen=" + unternehmen + ", thema=" + thema + ", betreuerNummer="
				+ betreuerNummer + ", betreuerName=" + betreuerName + ", emailBetreuer=" + emailBetreuer + ", nda="
				+ nda + "]";
	}
	public Thema(int matrikelnummer, String studentName, String studentVorname, String unternehmen, String thema,
			int betreuerNummer, String betreuerName, String emailBetreuer, String nda) {
		super();
		this.matrikelnummer = matrikelnummer;
		this.studentName = studentName;
		this.studentVorname = studentVorname;
		this.unternehmen = unternehmen;
		this.thema = thema;
		this.betreuerNummer = betreuerNummer;
		this.betreuerName = betreuerName;
		this.emailBetreuer = emailBetreuer;
		this.nda = nda;
	}
	
	
	
	
	
	

}
