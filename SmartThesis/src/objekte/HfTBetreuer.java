package objekte;

public class HfTBetreuer {

	private int id;
	private String name;
	private String nachname;
	private String email;
	private String passwort;
	private String benutzertyp;

	public HfTBetreuer(int id, String name, String nachname, String email, String passwort, String benutzertyp) {
		super();
		this.id = id;
		this.name = name;
		this.nachname = nachname;
		this.email = email;
		this.passwort = passwort;
		this.benutzertyp = benutzertyp;
	}

	@Override
	public String toString() {
		return "HfTBetreuer [id=" + id + ", name=" + name + ", nachname=" + nachname + ", email=" + email
				+ ", passwort=" + passwort + ", benutzertyp=" + benutzertyp + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
