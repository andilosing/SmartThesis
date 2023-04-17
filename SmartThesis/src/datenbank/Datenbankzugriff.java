package datenbank;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import gui.Anmeldemaske;
import gui.HauptmenüHfTBetreuer;
import gui.HauptmenüStudent;
import gui.HauptmenüStudiendekan;
import gui.Registriermaske;
import objekte.Bewertung;
import objekte.HfTBetreuer;
import objekte.Student;
import objekte.Studiendekan;
import objekte.Thema;

import java.sql.ResultSet;

public class Datenbankzugriff {

	static Connection conn = null;

	public static Connection getConn() {
		return conn;
	}

	public static void verbindeDatenbank() {

		String url = "jdbc:mysql://3.125.60.55:3306/";
		String dbName = "db4";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "db4";
		String password = "!db4.hfts?";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Verbunden mit Datenbank");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void schliesseDatenbank() {
		try {
			conn.close();
			System.out.println("Disconnected von Datenbank");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void anmelden(String email, String passwort, Anmeldemaske anmeldemaske) {

		if (conn == null) {
			verbindeDatenbank();
		}

		try {
			PreparedStatement statementStudent = (PreparedStatement) conn.prepareStatement(
					"Select email, passwort, name, vorname, benutzertyp, matrikelnummer from studenten where email=? and passwort=?");

			statementStudent.setString(1, email);
			statementStudent.setString(2, passwort);

			ResultSet rsStudent = statementStudent.executeQuery();

			if (rsStudent.next()) {

				Student student = new Student(rsStudent.getInt("matrikelnummer"), rsStudent.getString("vorname"),
						rsStudent.getString("name"), rsStudent.getString("email"), rsStudent.getString("passwort"),
						rsStudent.getString("benutzertyp"));
				HauptmenüStudent hauptmenüStudent = new HauptmenüStudent(student);
				hauptmenüStudent.setVisible(true);
				anmeldemaske.setVisible(false);
				return;
			}

			PreparedStatement statementHfTBetreuer = (PreparedStatement) conn.prepareStatement(
					"Select email, passwort, name, vorname, nummer, benutzertyp from hftbetreuer where email=? and passwort=?");

			statementHfTBetreuer.setString(1, email);
			statementHfTBetreuer.setString(2, passwort);

			ResultSet rsHfTBetreuer = statementHfTBetreuer.executeQuery();

			if (rsHfTBetreuer.next()) {

				HfTBetreuer hftBetreuer = new HfTBetreuer(rsHfTBetreuer.getInt("nummer"),
						rsHfTBetreuer.getString("vorname"), rsHfTBetreuer.getString("name"),
						rsHfTBetreuer.getString("email"), rsHfTBetreuer.getString("passwort"),
						rsHfTBetreuer.getString("benutzertyp"));
				HauptmenüHfTBetreuer hauptmenüHfTBetreuer = new HauptmenüHfTBetreuer(hftBetreuer);
				hauptmenüHfTBetreuer.setVisible(true);
				anmeldemaske.setVisible(false);
				;
				return;
			}
			PreparedStatement statementStudiendekan = (PreparedStatement) conn.prepareStatement(
					"Select email, passwort, name, vorname, nummer, benutzertyp from studiendekan where email=? and passwort=?");

			statementStudiendekan.setString(1, email);
			statementStudiendekan.setString(2, passwort);

			ResultSet rsStudiendekan = statementStudiendekan.executeQuery();

			if (rsStudiendekan.next()) {

				Studiendekan studiendekan = new Studiendekan(rsStudiendekan.getInt("nummer"),
						rsStudiendekan.getString("vorname"), rsStudiendekan.getString("name"),
						rsStudiendekan.getString("email"), rsStudiendekan.getString("passwort"),
						rsStudiendekan.getString("benutzertyp"));
				HauptmenüStudiendekan hauptmenüStudiendekan = new HauptmenüStudiendekan(studiendekan);
				hauptmenüStudiendekan.setVisible(true);
				anmeldemaske.setVisible(false);
				;
				return;
			}
			JOptionPane.showMessageDialog(null, "Anmeldung fehlgeschlagen! \nFalsche Anmeldedaten!");
		} catch (Exception e) {

		}

	}

	public static void registrierenStudiendekan(int nummer, String name, String vorname, String email, String passwort,
			String benutzertyp) {

		if (conn == null) {
			verbindeDatenbank();
		}

		try {

			if ((email.equals("ralf.kramer@hft-stuttgart.de") == false) | (name.equals("Kramer") == false)) {
				JOptionPane.showMessageDialog(null, "Sie sind nicht Herr kramer!");
				return;
			}
			String query = "INSERT INTO studiendekan values('" + nummer + "','" + name + "','" + vorname + "','" + email
					+ "','" + passwort + "','" + benutzertyp + "')";
			Statement sta = conn.createStatement();
			int x = sta.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "Willkommen " + vorname + " " + name);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void registrierenHfTBetreuer(int nummer, String name, String vorname, String email, String passwort,
			String benutzertyp) {

		if (conn == null) {
			verbindeDatenbank();
		}

		try {
			String query = "INSERT INTO hftbetreuer values('" + nummer + "','" + name + "','" + vorname + "','" + email
					+ "','" + passwort + "','" + benutzertyp + "')";
			Statement sta = conn.createStatement();
			int x = sta.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "Willkommen " + vorname + " " + name);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void registrierenStudent(int matrikelnummer, String name, String vorname, String email,
			String passwort, String benutzertyp) {

		if (conn == null) {
			verbindeDatenbank();
		}

		try {
			String query = "INSERT INTO studenten values('" + matrikelnummer + "','" + name + "','" + vorname + "','"
					+ email + "','" + passwort + "','" + benutzertyp + "')";
			Statement sta = conn.createStatement();
			int x = sta.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "Willkommen " + vorname + " " + name);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void themaEintragen(Thema thema) {

		if (conn == null) {
			verbindeDatenbank();
		}
		boolean themaSchonEingetragen = false;
		try {
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(
					"Select * from themaba where matrikelnummer=?");
			statement.setInt(1, thema.getMatrikelnummer());

			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
			themaSchonEingetragen = true;
			}
			
			if (themaSchonEingetragen == false) {		
			
			
			String query = "INSERT INTO themaba values('" + thema.getMatrikelnummer() + "','" + thema.getStudentName()
					+ "','" + thema.getStudentVorname() + "','" + thema.getUnternehmen() + "','" + thema.getThema()
					+ "','" + thema.getBetreuerNummer() + "','" + thema.getBetreuerName() + "','"
					+ thema.getEmailBetreuer() + "','" + "" + "' )";
			Statement sta = conn.createStatement();
			int x = sta.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "Thema wurde erfolgreich eingetragen ");}
			else {
				JOptionPane.showMessageDialog(null, "Sie haben schon ein Thema eingetragen!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String sucheStudentFürBetreuer(HfTBetreuer betreuer, int matrikelnummer) {
		if (conn == null) {
			verbindeDatenbank();
		}

		String student = "";

		try {
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(
					"Select studentname, studentvorname from themaba where matrikelnummer=? and betreuernummer=?");

			statement.setInt(1, matrikelnummer);

			statement.setInt(2, betreuer.getId());

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				student = rs.getString("studentname") + " " + rs.getString("studentvorname");

				return student;

			}
			JOptionPane.showMessageDialog(null, "Sie betreuen keinen Studenten \n mit dieser Matrikelnummer!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public static String studentMitThemaSuchen(String nachname, String vorname) {

		if (conn == null) {
			verbindeDatenbank();
		}

		String studentPlusThema = "";

		try {
			PreparedStatement statementStudentMitThema = (PreparedStatement) conn.prepareStatement(
					"Select studentname, studentvorname, unternehmen, thema  from themaba where studentname=? and studentvorname=?");

			statementStudentMitThema.setString(1, nachname);
			statementStudentMitThema.setString(2, vorname);

			ResultSet rsStudentThema = statementStudentMitThema.executeQuery();

			if (rsStudentThema.next()) {
				studentPlusThema = rsStudentThema.getString("studentname") + " "
						+ rsStudentThema.getString("studentvorname") + ": " + rsStudentThema.getString("unternehmen")
						+ " " + rsStudentThema.getString("thema");
				return studentPlusThema;

			}
			JOptionPane.showMessageDialog(null,
					"Es gibt keinen Studenten mit diesem \n Namen der ein Thema eingetragen hat!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentPlusThema;

	}

	public static void hftBetreuerThemaBestaetigen(int id, String hftBetreuerNachname, String betreuerMail,
			String studentNachname, String studentVorname) {
		if (conn == null) {
			verbindeDatenbank();
		}

		try {

			PreparedStatement statementStudentMitThema = (PreparedStatement) conn.prepareStatement(
					"Select betreuernummer, betreuername, betreuermail from themaba where studentname=? and studentvorname=?");

			statementStudentMitThema.setString(1, studentNachname);
			statementStudentMitThema.setString(2, studentVorname);

			ResultSet rsBetreuer = statementStudentMitThema.executeQuery();

			if (rsBetreuer.next()) {
				if (rsBetreuer.getInt("betreuernummer") != 0) {
					JOptionPane.showMessageDialog(null,
							"Der Student wird schon von \n " + rsBetreuer.getString("betreuername") + "  betreut");
					return;
				}

			}

			String query = "UPDATE themaba set betreuernummer = ?, betreuername = ?, betreuermail =?   where studentname = ? and studentvorname = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.setString(2, hftBetreuerNachname);
			preparedStmt.setString(3, betreuerMail);
			preparedStmt.setString(4, studentNachname);
			preparedStmt.setString(5, studentVorname);
			preparedStmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Sie wurden erfolgreich \n für diesen Studenten eingetragen!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Thema> getListeFürStudiendekan() {
		if (conn == null) {
			verbindeDatenbank();
		}

		try {
			PreparedStatement statementListe = (PreparedStatement) conn.prepareStatement("Select * from themaba ");
			ResultSet rsListe = statementListe.executeQuery();
			ArrayList<Thema> themaListe = new ArrayList();
			while (rsListe.next()) {
				Thema thema = new Thema(rsListe.getInt("matrikelnummer"), rsListe.getString("studentname"),
						rsListe.getString("studentvorname"), rsListe.getString("unternehmen"),
						rsListe.getString("thema"), rsListe.getInt("betreuernummer"), rsListe.getString("betreuername"),
						rsListe.getString("betreuermail"), rsListe.getString("nda"));
				themaListe.add(thema);
			}
			return themaListe;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static ArrayList<Thema> getListeFürBetreuer(HfTBetreuer betreuer) {
		if (conn == null) {
			verbindeDatenbank();
		}

		try {
			PreparedStatement statementListe = (PreparedStatement) conn
					.prepareStatement("Select * from themaba where betreuernummer = ? ");
			statementListe.setInt(1, betreuer.getId());
			ResultSet rsListe = statementListe.executeQuery();
			ArrayList<Thema> themaListe = new ArrayList();
			while (rsListe.next()) {
				Thema thema = new Thema(rsListe.getInt("matrikelnummer"), rsListe.getString("studentname"),
						rsListe.getString("studentvorname"), rsListe.getString("unternehmen"),
						rsListe.getString("thema"), rsListe.getInt("betreuernummer"), rsListe.getString("betreuername"),
						rsListe.getString("betreuermail"), rsListe.getString("nda"));
				themaListe.add(thema);
			}
			return themaListe;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String kontaktdatenStudent(Student student) {
		if (conn == null) {
			verbindeDatenbank();
		}

		try {
			String ergebnis = "";
			// Studiendekan
			PreparedStatement statementStudiendekanDaten = (PreparedStatement) conn
					.prepareStatement("Select name, vorname, email from studiendekan");

			ResultSet rsStudiendekanDaten = statementStudiendekanDaten.executeQuery();

			String studiendekanDaten = "";
			if (rsStudiendekanDaten.next()) {
				studiendekanDaten = rsStudiendekanDaten.getString("name") + ", "
						+ rsStudiendekanDaten.getString("vorname") + ", " + rsStudiendekanDaten.getString("email");
			}

			// Betreuer
			PreparedStatement statementHfTBetreuerDaten = (PreparedStatement) conn
					.prepareStatement("Select betreuername, betreuermail from themaba where matrikelnummer = ?");

			statementHfTBetreuerDaten.setInt(1, student.getMatrikelnummer());

			ResultSet rsHfTBetreuerDaten = statementHfTBetreuerDaten.executeQuery();
			String hftBetreuerDaten = "";
			if (rsHfTBetreuerDaten.next()) {
				hftBetreuerDaten = rsHfTBetreuerDaten.getString("betreuername") + ", "
						+ rsHfTBetreuerDaten.getString("betreuermail");
			}
			ergebnis = studiendekanDaten + "<br>" + hftBetreuerDaten + "</body></html>";
			return ergebnis;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static Student sucheStudent(int matrikelnummer) {
		try {
			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select * from studenten where matrikelnummer=? ");

			statement.setInt(1, matrikelnummer);

			ResultSet rs = statement.executeQuery();
			Student student;
			if (rs.next()) {
				student = new Student(rs.getInt("matrikelnummer"), rs.getString("vorname"), rs.getString("name"),
						rs.getString("email"), "", rs.getString("benutzertyp"));
				return student;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	public static void trageNDAein(Student student, String nda) {

		try {

			String query = "UPDATE themaba set nda = ?  where matrikelnummer = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, nda);
			preparedStmt.setInt(2, student.getMatrikelnummer());
			preparedStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String ndaStatus(Student student) {
		String nda = "k.A.";
		try {
			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select nda from themaba where matrikelnummer = ? ");
			statement.setInt(1, student.getMatrikelnummer());
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				nda = rs.getString("nda");
			}
			return nda;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nda;
	}

	public static String getThema(Student student) {
		String thema = "<Thema>";
		try {

			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select unternehmen, thema  from themaba where matrikelnummer=? ");

			statement.setInt(1, student.getMatrikelnummer());

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				thema = rs.getString("unternehmen") + ": " + rs.getString("thema");
				return thema;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return thema;
	}

	public static void meldeStudentAn(Student student) {
		if (conn == null) {
			verbindeDatenbank();
		}

		try {
			boolean schonAngemeldet = false;

			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select matrikelnummer from anmeldung where matrikelnummer = ?");
			statement.setInt(1, student.getMatrikelnummer());
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				schonAngemeldet = true;
				JOptionPane.showMessageDialog(null, "Sie haben sich schon angemeldet");
			}

			if (schonAngemeldet == false) {

				String query = "INSERT INTO anmeldung values('" + student.getMatrikelnummer() + "','" + "angemeldet"
						+ "','" + "kA" + "')";
				Statement sta = conn.createStatement();
				int x = sta.executeUpdate(query);

				JOptionPane.showMessageDialog(null, "Sie haben sich erfolgreich angemeldet");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void bestätigeAnmeldung(Student studentVerwalten) {
		String anmeldungStatus = "";
		boolean schonAngemeldet = false;
		try {

			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select anmeldungbetreuer from anmeldung where matrikelnummer = ?");
			statement.setInt(1, studentVerwalten.getMatrikelnummer());
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				anmeldungStatus = rs.getString("anmeldungbetreuer");
				schonAngemeldet = true;
			}

			if (schonAngemeldet == true) {

				if (anmeldungStatus.equals("bestätigt")) {
					JOptionPane.showMessageDialog(null, "Sie haben die Anmeldung schon bestätigt!");

				} else {
					String query = "UPDATE anmeldung set anmeldungbetreuer = ? where matrikelnummer = ?";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString(1, "bestätigt");
					preparedStmt.setInt(2, studentVerwalten.getMatrikelnummer());
					preparedStmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Sie haben die Anmeldung bestätigt!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Dieser Student hat sich noch \n nicht angemeldet!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getAnmeldestatus(Student student) {
		String anmeldestatus = "nicht angemeldet";
		try {

			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(
					"Select anmeldungstudent, anmeldungbetreuer  from anmeldung where matrikelnummer=? ");

			statement.setInt(1, student.getMatrikelnummer());

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {

				if (rs.getString("anmeldungbetreuer").equals("kA") == true) {
					anmeldestatus = "angemeldet, Bestätigung(Betreuer) austehend";
					return anmeldestatus;
				}
				anmeldestatus = "angemeldet und bestätigt";
				return anmeldestatus;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return anmeldestatus;

	}

	public static String getAnmeldestatusByMatNr(int matrikelnummer) {
		String anmeldestatus = "nicht angemeldet";
		try {

			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(
					"Select anmeldungstudent, anmeldungbetreuer  from anmeldung where matrikelnummer=? ");

			statement.setInt(1, matrikelnummer);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {

				if (rs.getString("anmeldungbetreuer").equals("kA") == true) {
					anmeldestatus = "angemeldet, Bestätigung(Betreuer) austehend";
					return anmeldestatus;
				}
				anmeldestatus = "angemeldet und bestätigt";
				return anmeldestatus;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return anmeldestatus;

	}

	public static void setNoteBetreuer(Student student, Double note) {
		if (conn == null) {
			verbindeDatenbank();
		}

		try {
			boolean schonBewertet = false;

			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(
					"Select matrikelnummer, noteausarbeitung from bewertung where matrikelnummer = ?");
			statement.setInt(1, student.getMatrikelnummer());
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				schonBewertet = true;
				JOptionPane.showMessageDialog(null,
						"Sie haben dem Student schon \ndie Note " + rs.getDouble("noteausarbeitung") + " gegeben");
			}

			if (schonBewertet == false) {

				String query = "INSERT INTO bewertung values('" + student.getMatrikelnummer() + "','" + note + "','"
						+ 0.0 + "','" + 0.0 + "')";
				Statement sta = conn.createStatement();
				int x = sta.executeUpdate(query);

				JOptionPane.showMessageDialog(null,
						"Sie haben den Student erfolgreich mit \nder Note  " + note + " bewertet!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getAusarbeitungNoteByMatNr(int matrikelnummer) {
		String ausarbeitung = "k.A.";
		try {

			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select noteausarbeitung from bewertung where matrikelnummer=? ");

			statement.setInt(1, matrikelnummer);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				ausarbeitung = Double.toString(rs.getDouble("noteausarbeitung"));

			}
			return ausarbeitung;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ausarbeitung;

	}

	public static void setNoteStudiendekan(int matrikelnummer, Double note) {
		if (conn == null) {
			verbindeDatenbank();
		}

		try {
			boolean schonBewertet = false;

			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select matrikelnummer, noteseminar from bewertung where matrikelnummer = ?");
			statement.setInt(1, matrikelnummer);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				if (rs.getDouble("noteseminar") != 0.0) {
					schonBewertet = true;
					JOptionPane.showMessageDialog(null,
							"Sie haben dem Student schon \ndie Note " + rs.getDouble("noteseminar") + " gegeben");
				}

			}

			if (schonBewertet == false) {

				String query = "UPDATE bewertung set noteseminar = ? where matrikelnummer = ?";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.setDouble(1, note);
				preparedStmt.setInt(2, matrikelnummer);
				preparedStmt.executeUpdate();

				JOptionPane.showMessageDialog(null,
						"Sie haben den Student erfolgreich mit \nder Note  " + note + " bewertet!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Thema sucheStudentFürStudiendekan(int matrikelnummer) {
		if (conn == null) {
			verbindeDatenbank();
		}

		Thema student = null;

		try {
			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select * from themaba where matrikelnummer=? ");

			statement.setInt(1, matrikelnummer);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				student = new Thema(rs.getInt("matrikelnummer"), rs.getString("studentname"),
						rs.getString("studentvorname"), rs.getString("unternehmen"), rs.getString("thema"),
						rs.getInt("betreuernummer"), rs.getString("betreuername"), rs.getString("betreuermail"),
						rs.getString("nda"));
				JOptionPane.showMessageDialog(null, "Sie verwalten jetzt den Studenten: \n"
						+ student.getStudentVorname() + " " + student.getStudentName());
				return student;
			}
			JOptionPane.showMessageDialog(null, "Es gibt keinen Studenten mit der Matrikelnummer \n " + matrikelnummer);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public static void abgebenZwischenversion(Student student) {
		if (conn == null) {
			verbindeDatenbank();
		}
		try {
			boolean schonAbgegeben = false;
			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select * from abgaben where matrikelnummer = ?");
			statement.setInt(1, student.getMatrikelnummer());
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				schonAbgegeben = true;
				JOptionPane.showMessageDialog(null, "Sie haben bereits eine Zwischenversion abgesendet!");
			}

			if (schonAbgegeben == false) {

				String query = "INSERT INTO abgaben values('" + student.getMatrikelnummer() + "','"
						+ "Zwischenversion abgegeben" + "','" + "nicht bestätigt" + "','" + "k.A." + "','" + "k.A."
						+ "')";
				Statement sta = conn.createStatement();
				int x = sta.executeUpdate(query);

				JOptionPane.showMessageDialog(null, "Ihre Abgabe wurde vermerkt!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void abgebenEndversion(Student student) {
		if (conn == null) {
			verbindeDatenbank();
		}
		try {
			boolean zvSchonAbgegeben = false;
			boolean evSchonAbgegeben = false;
			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select * from abgaben where matrikelnummer = ?");
			statement.setInt(1, student.getMatrikelnummer());
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				zvSchonAbgegeben = true;
				if (!rs.getString("endversion").equals("k.A.")) {
					evSchonAbgegeben = true;
					JOptionPane.showMessageDialog(null, "Sie haben bereits eine Endversion abgeschickt!");
				}

			} else {
				JOptionPane.showMessageDialog(null, "Sie müssen zuerst die Zwischenversion abgeben");
			}

			if ((zvSchonAbgegeben == true) && (evSchonAbgegeben == false)) {

				String query = "UPDATE abgaben set endversion = ?, endversionbestätigung = ? where matrikelnummer = ?";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString(1, "Endversion abgegeben");
				preparedStmt.setString(2, "nicht bestätigt");
				preparedStmt.setInt(3, student.getMatrikelnummer());
				preparedStmt.executeUpdate();

				JOptionPane.showMessageDialog(null, "Ihre Abgabe wurde vermerkt!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getStatus(int matrikelnummer) {
		String status = "es wurde nichts abgegeben";
		try {

			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select *  from abgaben where matrikelnummer=? ");

			statement.setInt(1, matrikelnummer);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {

				if (rs.getString("endversionbestätigung").equals("bestätigt")) {

				}

				if (rs.getString("anmeldungbetreuer").equals("kA") == true) {
					status = "angemeldet, Bestätigung(Betreuer) austehend";
					return status;
				}
				status = "angemeldet und bestätigt";
				return status;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	public static void aktualisiereZVAbgaben(Student studentVerwalten) {
		if (conn == null) {
			verbindeDatenbank();
		}
		try {
			boolean zvSchonAbgegeben = false;
			boolean schonBestätigt = false;

			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select * from abgaben where matrikelnummer = ?");
			statement.setInt(1, studentVerwalten.getMatrikelnummer());
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				zvSchonAbgegeben = true;
				if (rs.getString("zwischenversionbestätigung").equals("Zwischenversion bestätigt")) {
					schonBestätigt = true;
					JOptionPane.showMessageDialog(null, "Sie haben die Zwischenversion schon bestätigt");

				}

			} else {
				JOptionPane.showMessageDialog(null, "Der Student hat noch keine Zwischenversion abgegeben!");
			}

			if ((zvSchonAbgegeben == true) && (schonBestätigt == false)) {

				String query = "UPDATE abgaben set zwischenversionbestätigung = ? where matrikelnummer = ?";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString(1, "Zwischenversion bestätigt");
				preparedStmt.setInt(2, studentVerwalten.getMatrikelnummer());
				preparedStmt.executeUpdate();

				JOptionPane.showMessageDialog(null, "Zwischenversion wurde bestätigt!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void aktualisiereEVAbgaben(Student studentVerwalten) {
		if (conn == null) {
			verbindeDatenbank();
		}
		try {
			boolean zvSchonAbgegeben = false;
			boolean schonBestätigt = false;
			boolean evSchonAbgegeben = false;

			PreparedStatement statement = (PreparedStatement) conn
					.prepareStatement("Select * from abgaben where matrikelnummer = ?");
			statement.setInt(1, studentVerwalten.getMatrikelnummer());
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				zvSchonAbgegeben = true;
				if (rs.getString("endversionbestätigung").equals("Endversion bestätigt")) {
					schonBestätigt = true;
					JOptionPane.showMessageDialog(null, "Sie haben die Endversion schon bestätigt");
				}
				if (rs.getString("endversionbestätigung").equals("k.A.")) {
					JOptionPane.showMessageDialog(null, "Der Student hat noch keine Endversion abgegeben!");
				}
				if (rs.getString("endversionbestätigung").equals("nicht bestätigt")) {
					evSchonAbgegeben = true;
				}

			} else {
				JOptionPane.showMessageDialog(null, "Der Student hat noch keine \n eine Zwischenversion abgegeben!");

			}

			if ((zvSchonAbgegeben == true) && (schonBestätigt == false) && (evSchonAbgegeben == true)) {

				String query = "UPDATE abgaben set endversionbestätigung = ? where matrikelnummer = ?";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString(1, "Endversion bestätigt");
				preparedStmt.setInt(2, studentVerwalten.getMatrikelnummer());
				preparedStmt.executeUpdate();

				JOptionPane.showMessageDialog(null, "Endversion wurde bestätigt!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<String> getStatusAbgaben(HfTBetreuer hftBetreuer) {
		if (conn == null) {
			verbindeDatenbank();
		}
		ArrayList<String> themaStatus = new ArrayList();

		try {
			String status = "k.A.";

			PreparedStatement statementListe = (PreparedStatement) conn
					.prepareStatement("Select matrikelnummer from themaba where betreuernummer = ? ");
			statementListe.setInt(1, hftBetreuer.getId());
			ResultSet rsListe = statementListe.executeQuery();
			ArrayList<Integer> themaListe = new ArrayList();
			while (rsListe.next()) {
				int matrikelnummer = rsListe.getInt("matrikelnummer");
				themaListe.add(matrikelnummer);
			}

			for (Integer matNR : themaListe) {
				PreparedStatement rs = (PreparedStatement) conn
						.prepareStatement("Select * from abgaben where matrikelnummer = ? ");
				rs.setInt(1, matNR);
				ResultSet rsStatus = rs.executeQuery();
				boolean inListe = false;

				while (rsStatus.next()) {
					status = rsStatus.getString("zwischenversion") + " || "
							+ rsStatus.getString("zwischenversionbestätigung") + " || "
							+ rsStatus.getString("endversion") + " || " + rsStatus.getString("endversionbestätigung");
					themaStatus.add(status);
					inListe = true;
				}
				if (inListe == false) {
					themaStatus.add("keine Abgaben");
				}

			}
			return themaStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return themaStatus;

	}

	public static ArrayList<String> getBewertung() {
		if (conn == null) {
			verbindeDatenbank();
		}
		ArrayList<Integer> matrikelnummer = new ArrayList<Integer>();
		ArrayList<String> bewertungListe = new ArrayList();
		try {
			PreparedStatement statementListe = (PreparedStatement) conn
					.prepareStatement("Select matrikelnummer from themaba ");
			ResultSet rsListe = statementListe.executeQuery();
			
			while (rsListe.next()) {
				matrikelnummer.add(rsListe.getInt("matrikelnummer"));
			}

			for (Integer integer : matrikelnummer) {
				PreparedStatement rs = (PreparedStatement) conn
						.prepareStatement("Select * from bewertung where matrikelnummer = ? ");
				rs.setInt(1, integer);
				ResultSet rsStatus = rs.executeQuery();
				boolean inListe = false;

				String bewertungen = "";
				while (rsStatus.next()) {
					bewertungen = "Note Ausarbeitung " + Double.toString(rsStatus.getDouble("noteausarbeitung"))
							+ " Note Seminar " + Double.toString(rsStatus.getDouble("noteseminar")) + " Note Gesamt "
							+ Double.toString(rsStatus.getDouble("notegesamt"));
					bewertungListe.add(bewertungen);
					inListe = true;

				}

				if (inListe == false) {
					bewertungListe.add("keine Abgaben");
				}
			}
			return bewertungListe;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void berechnenGesamtnote(int matrikelnummer) {
		
		if (conn == null) {
			verbindeDatenbank();
		}
		
		try {
			PreparedStatement statementListe = (PreparedStatement) conn
					.prepareStatement("Select * from bewertung where matrikelnummer=? ");
			statementListe.setInt(1, matrikelnummer);
			ResultSet rsListe = statementListe.executeQuery();
			
			while (rsListe.next()) {
				double gesamtnote = ((rsListe.getDouble("noteausarbeitung") *12) + (rsListe.getDouble("noteseminar")*3)) / 15;
				String query = "UPDATE bewertung set notegesamt = ? where matrikelnummer = ?";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.setDouble(1, gesamtnote);
				preparedStmt.setDouble(2, matrikelnummer);
				preparedStmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Es hat die Gesamtnote ausgerechnet");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static String getNotenStudent(int matrikelnummer) {
		
		if (conn == null) {
			verbindeDatenbank();
		}
		String noten ="k.A.";
		try {
			PreparedStatement statementListe = (PreparedStatement) conn
					.prepareStatement("Select * from bewertung where matrikelnummer=? ");
			statementListe.setInt(1, matrikelnummer);
			ResultSet rsListe = statementListe.executeQuery();
			
			while (rsListe.next()) {
				noten = "Note Ausarbeitung " + Double.toString(rsListe.getDouble("noteausarbeitung"))
				+ " || Note Seminar " + Double.toString(rsListe.getDouble("noteseminar")) + " || Note Gesamt "
				+ Double.toString(rsListe.getDouble("notegesamt"));
			}

			return noten;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static boolean prüfeObThemaVorhanden(int matrikelnummer) {
		if (conn == null) {
			verbindeDatenbank();
		}
		boolean themaVorhanden = false;
		try {
			PreparedStatement statementListe = (PreparedStatement) conn
					.prepareStatement("Select * from themaba where matrikelnummer=? ");
			statementListe.setInt(1, matrikelnummer);
			ResultSet rsListe = statementListe.executeQuery();
			
			while (rsListe.next()) {
				themaVorhanden = true;
			}
			return themaVorhanden;
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return themaVorhanden;
	}

	public static boolean prüfeObNoteAusarbeitungVorhanden(int matrikelnummer) {
		if (conn == null) {
			verbindeDatenbank();
		}
		boolean noteAusarbeitungVorhanden = false;
		try {
			PreparedStatement statementListe = (PreparedStatement) conn
					.prepareStatement("Select * from bewertung where matrikelnummer=? ");
			statementListe.setInt(1, matrikelnummer);
			ResultSet rsListe = statementListe.executeQuery();
			
			while (rsListe.next()) {
				return noteAusarbeitungVorhanden = true;
			}
			return noteAusarbeitungVorhanden;
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return noteAusarbeitungVorhanden;
	}

	public static boolean prüfeObSchonAngemeldet(int matrikelnummer) {
	
		if (conn == null) {
			verbindeDatenbank();
		}
		boolean angemeldet = false;
		try {
			PreparedStatement statementListe = (PreparedStatement) conn
					.prepareStatement("Select anmeldungbetreuer from anmeldung where matrikelnummer=? ");
			statementListe.setInt(1, matrikelnummer);
			ResultSet rsListe = statementListe.executeQuery();
			
			while (rsListe.next()) {
				if (rsListe.getString("anmeldungbetreuer").equals("bestätigt") == true) {
					return angemeldet = true;
				}
				
			}
			return angemeldet;
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return angemeldet;
	}

	public static boolean istEndversionSchonbestätigt(int matrikelnummer) {
		if (conn == null) {
			verbindeDatenbank();
		}
		boolean evSchonBestätigt = false;
		try {
			PreparedStatement statementListe = (PreparedStatement) conn
					.prepareStatement("Select endversionbestätigung from abgaben where matrikelnummer=? ");
			statementListe.setInt(1, matrikelnummer);
			ResultSet rsListe = statementListe.executeQuery();
			
			while (rsListe.next()) {
				if (rsListe.getString("endversionbestätigung").equals("Endversion bestätigt") == true) {
					return evSchonBestätigt = true;
				}
				
			}
			return evSchonBestätigt;
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return evSchonBestätigt;
	}

	public static String setAbgabenStatus(int matrikelnummer) {
		if (conn == null) {
			verbindeDatenbank();
		}
		String status = "k.A.";
		try {
			


				PreparedStatement rs = (PreparedStatement) conn
						.prepareStatement("Select * from abgaben where matrikelnummer = ? ");
				rs.setInt(1, matrikelnummer);
				ResultSet rsStatus = rs.executeQuery();

				while (rsStatus.next()) {
					status = rsStatus.getString("zwischenversion") + " || "
							+ rsStatus.getString("zwischenversionbestätigung") + " || "
							+ rsStatus.getString("endversion") + " || " + rsStatus.getString("endversionbestätigung");
					
				}
				

			return status;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}
		
	

}
