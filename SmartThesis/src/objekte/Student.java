package objekte;

public class Student {

	private int matrikelnummer;
	private String name;
	private String nachname;
	private String email;
	private String passwort;
	private String benutzertyp;

	public Student(int matrikelnummer, String name, String nachname, String email, String passwort,
			String benutzertyp) {
		super();
		this.matrikelnummer = matrikelnummer;
		this.name = name;
		this.nachname = nachname;
		this.email = email;
		this.passwort = passwort;
		this.benutzertyp = benutzertyp;
	}

	@Override
	public String toString() {
		return "Student [matrikelnummer=" + matrikelnummer + ", name=" + name + ", nachname=" + nachname + ", email="
				+ email + ", passwort=" + passwort + ", benutzertyp=" + benutzertyp + "]";
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getBenutzertyp() {
		return benutzertyp;
	}

	public void setBenutzertyp(String benutzertyp) {
		this.benutzertyp = benutzertyp;
	}

}
