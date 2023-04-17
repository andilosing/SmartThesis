package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datenbank.Datenbankzugriff;
import objekte.HfTBetreuer;
import objekte.Student;
import objekte.Thema;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;

import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class HauptmenüHfTBetreuer extends JFrame {

	private JPanel contentPane;
	private JTextField textField_AngemeldetAls;
	private JTabbedPane tabbedPane;
	private JPanel panel_Home;
	private JPanel Panel_ThemaEintragen;
	private JPanel panel_NDA;
	private JPanel panel_Anmeldeformular;
	private JPanel panel_Endversionabgaben;
	private JPanel Bewertung;
	private JButton btnLogout;
	private static HfTBetreuer hftBetreuer;
	private JLabel lblStudentSuchen;
	private JLabel lblName;
	private JLabel label_StudentSuchenNachname;
	private JTextField textField_StudentSuchenName;
	private JTextField textField_StudentSuchenNachname;
	private JButton btnSuchen;
	private JLabel label_StudentSuchenThemaErgebnis;
	private JButton btnFrStudentVerbindlich;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblMatrikelnummer;
	private JTextField textField_MatNr;
	private JLabel lblStudent;
	private JScrollPane scrollPane;
	private JLabel lblNda;
	private JScrollPane scrollPane_1;
	private JLabel label_NDA;
	private JLabel label_Student;
	private JLabel label_StudentErgebnis;
	private JRadioButton button_NDANein;
	private JRadioButton button_NDAJa;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnBesttigen;
	private Student studentVerwalten;
	private JLabel lblSieVerwaltenKeinen;
	private JLabel lblThemaUnternehmen;
	private JScrollPane scrollPane_2;
	private JLabel label_UntThemaListe;
	private JButton btnAnmelden;
	private JLabel label_erstens;
	private JLabel label_zweitens;
	private JLabel lblDasInterdisziplinre;
	private JRadioButton rb_Ja;
	private JRadioButton rb_Nein;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JLabel label_SetUnternehmen;
	private JLabel label_SetThema;
	private JLabel lblAnmeldestatus;
	private JScrollPane scrollPane_3;
	private JLabel label_SetAnmeldeStatus;
	private JButton btnBewerten;
	private JLabel lblBewertung;
	private JLabel lblName_1;
	private JLabel label_SetName;
	private JLabel lblUnternehmen;
	private JLabel label_SetUnternehmenNote;
	private JLabel lblThema;
	private JLabel label_SetThemaNote;
	private JLabel lblNoteAusarbeitung;
	private JComboBox comboBox_Note;
	private JLabel lblNoteAusarebitung;
	private JScrollPane scrollPane_4;
	private JLabel label_SetNoteAusarbeitungListe;
	private JButton btnStudentSuchen;
	private JButton btnVerwalten;
	private JButton btnBesttigen_1;
	private JLabel lblStudent_1;
	private JScrollPane scrollPane_5;
	private JLabel label_SetStudentenAbgabe;
	private JLabel lblStatus;
	private JScrollPane scrollPane_6;
	private JLabel label_SetStatus;
	private JLabel label_StudentName;
	private JRadioButton rdbtnZwischenversionBesttigt;
	private JRadioButton rdbtnEndversionbesttigt;
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hftBetreuer = new HfTBetreuer(10000, "Max", "Mustermann", "MaxMustermann@hft", "max", "Betreuer");
					HauptmenüHfTBetreuer frame = new HauptmenüHfTBetreuer(hftBetreuer);
					frame.setSize(1250, 650);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HauptmenüHfTBetreuer(HfTBetreuer hftBetreuer) {
		this.hftBetreuer = hftBetreuer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		// Überall Sichtbar:
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Datenbankzugriff.getConn() == null) {
					Datenbankzugriff.verbindeDatenbank();
				}
				dispose();
				Anmeldemaske anmeldemaske = new Anmeldemaske();
				anmeldemaske.setVisible(true);
				// Datenbankzugriff.schliesseDatenbank();
			}
		});

		lblSieVerwaltenKeinen = new JLabel("Sie verwalten: ---");
		GridBagConstraints gbc_lblSieVerwaltenKeinen = new GridBagConstraints();
		gbc_lblSieVerwaltenKeinen.anchor = GridBagConstraints.WEST;
		gbc_lblSieVerwaltenKeinen.insets = new Insets(0, 0, 5, 5);
		gbc_lblSieVerwaltenKeinen.gridx = 0;
		gbc_lblSieVerwaltenKeinen.gridy = 0;
		contentPane.add(lblSieVerwaltenKeinen, gbc_lblSieVerwaltenKeinen);

		JLabel lblAngemeldetAls = new JLabel("Angemeldet als");
		GridBagConstraints gbc_lblAngemeldetAls = new GridBagConstraints();
		gbc_lblAngemeldetAls.anchor = GridBagConstraints.EAST;
		gbc_lblAngemeldetAls.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngemeldetAls.gridx = 11;
		gbc_lblAngemeldetAls.gridy = 0;
		contentPane.add(lblAngemeldetAls, gbc_lblAngemeldetAls);

		JLabel label_AngemeldetAlsName = new JLabel("");
		GridBagConstraints gbc_label_AngemeldetAlsName = new GridBagConstraints();
		gbc_label_AngemeldetAlsName.anchor = GridBagConstraints.WEST;
		gbc_label_AngemeldetAlsName.insets = new Insets(0, 0, 5, 5);
		gbc_label_AngemeldetAlsName.gridx = 13;
		gbc_label_AngemeldetAlsName.gridy = 0;
		contentPane.add(label_AngemeldetAlsName, gbc_label_AngemeldetAlsName);
		label_AngemeldetAlsName.setText(hftBetreuer.getName() + " " + hftBetreuer.getNachname());
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogout.gridx = 16;
		gbc_btnLogout.gridy = 0;
		contentPane.add(btnLogout, gbc_btnLogout);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 8;
		gbc_tabbedPane.gridwidth = 17;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		contentPane.add(tabbedPane, gbc_tabbedPane);

		// Student ausgeben
		ArrayList<Thema> themaListe = Datenbankzugriff.getListeFürBetreuer(hftBetreuer);
		String ausgabe = "<html><body>";
		for (Thema thema : themaListe) {
			ausgabe += thema.getStudentName() + " " + thema.getStudentVorname() + " (" + thema.getMatrikelnummer() + ")"
					+ "<br>";
		}
		ausgabe += "</body></html>";

		// NDA Liste
		String nda = "<html><body>";
		for (Thema thema : themaListe) {
			if (thema.getNda().equals("") == true) {
				nda += "k.A." + "<br>";
			} else {
				nda += thema.getNda() + "<br>";
			}
		}
		nda += "</body></html>";

		// THemaUnternehemen liste
		String unternehemenThema = "<html><body>";
		for (Thema thema : themaListe) {
			unternehemenThema += thema.getUnternehmen() + "  " + thema.getThema() + "<br>";
		}
		unternehemenThema += "</body></html>";

		//
		String ndaListe = "<html><body>";
		for (Thema thema : themaListe) {
			if (thema.getNda().equals("") == true) {
				nda += "k.A." + "<br>";
			} else {
				ndaListe += thema.getNda() + "<br>";
			}
		}
		ndaListe += "</body></html>";

		// Anmeldestatus Liste
		ArrayList<Thema> themaListe2 = Datenbankzugriff.getListeFürBetreuer(hftBetreuer);

		String anmeldungListe = "<html><body>";
		for (Thema thema : themaListe2) {
			anmeldungListe += Datenbankzugriff.getAnmeldestatusByMatNr(thema.getMatrikelnummer()) + " <br>";
		}
		anmeldungListe += "</body></html>";

		// Note Ausarbeitung Liste
		String ausarbeitungNote = "<html><body>";
		for (Thema thema : themaListe2) {
			ausarbeitungNote += Datenbankzugriff.getAusarbeitungNoteByMatNr(thema.getMatrikelnummer()) + " <br>";
		}
		ausarbeitungNote += "</body></html>";

		// Startseite:
		panel_Home = new JPanel();
		tabbedPane.addTab("Startseite", null, panel_Home, null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_Home.setLayout(gridBagLayout);

		lblStudent = new JLabel("Student");
		GridBagConstraints gbc_lblStudent = new GridBagConstraints();
		gbc_lblStudent.anchor = GridBagConstraints.WEST;
		gbc_lblStudent.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudent.gridx = 1;
		gbc_lblStudent.gridy = 0;
		panel_Home.add(lblStudent, gbc_lblStudent);

		lblThemaUnternehmen = new JLabel("Unternehmen + Thema");
		GridBagConstraints gbc_lblThemaUnternehmen = new GridBagConstraints();
		gbc_lblThemaUnternehmen.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblThemaUnternehmen.insets = new Insets(0, 0, 5, 5);
		gbc_lblThemaUnternehmen.gridx = 4;
		gbc_lblThemaUnternehmen.gridy = 0;
		panel_Home.add(lblThemaUnternehmen, gbc_lblThemaUnternehmen);

		lblNda = new JLabel("NDA");
		GridBagConstraints gbc_lblNda = new GridBagConstraints();
		gbc_lblNda.insets = new Insets(0, 0, 5, 5);
		gbc_lblNda.gridx = 7;
		gbc_lblNda.gridy = 0;
		panel_Home.add(lblNda, gbc_lblNda);

		lblAnmeldestatus = new JLabel("Anmeldestatus");
		GridBagConstraints gbc_lblAnmeldestatus = new GridBagConstraints();
		gbc_lblAnmeldestatus.anchor = GridBagConstraints.WEST;
		gbc_lblAnmeldestatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnmeldestatus.gridx = 10;
		gbc_lblAnmeldestatus.gridy = 0;
		panel_Home.add(lblAnmeldestatus, gbc_lblAnmeldestatus);

		lblNoteAusarebitung = new JLabel("Note Ausarbeitung");
		GridBagConstraints gbc_lblNoteAusarebitung = new GridBagConstraints();
		gbc_lblNoteAusarebitung.anchor = GridBagConstraints.WEST;
		gbc_lblNoteAusarebitung.insets = new Insets(0, 0, 5, 0);
		gbc_lblNoteAusarebitung.gridx = 12;
		gbc_lblNoteAusarebitung.gridy = 0;
		panel_Home.add(lblNoteAusarebitung, gbc_lblNoteAusarebitung);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		panel_Home.add(scrollPane, gbc_scrollPane);

		label_Student = new JLabel("");
		label_Student.setVerticalAlignment(SwingConstants.TOP);
		scrollPane.setViewportView(label_Student);
		label_Student.setText(ausgabe);

		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridheight = 3;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 4;
		gbc_scrollPane_2.gridy = 1;
		panel_Home.add(scrollPane_2, gbc_scrollPane_2);

		label_UntThemaListe = new JLabel("");
		scrollPane_2.setViewportView(label_UntThemaListe);
		label_UntThemaListe.setVerticalAlignment(SwingConstants.TOP);
		label_UntThemaListe.setText(unternehemenThema);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.insets = new Insets(0, 0, 10, 10);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 5;
		gbc_scrollPane_1.gridy = 1;
		panel_Home.add(scrollPane_1, gbc_scrollPane_1);

		label_NDA = new JLabel("");
		scrollPane_1.setViewportView(label_NDA);
		label_NDA.setVerticalAlignment(SwingConstants.TOP);
		label_NDA.setText(nda);

		scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.gridwidth = 2;
		gbc_scrollPane_3.gridheight = 3;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 10;
		gbc_scrollPane_3.gridy = 1;
		panel_Home.add(scrollPane_3, gbc_scrollPane_3);

		label_SetAnmeldeStatus = new JLabel("<Anmeldestatus>");
		scrollPane_3.setViewportView(label_SetAnmeldeStatus);
		label_SetAnmeldeStatus.setVerticalAlignment(SwingConstants.TOP);
		label_SetAnmeldeStatus.setText(anmeldungListe);

		scrollPane_4 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.gridheight = 3;
		gbc_scrollPane_4.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.gridx = 12;
		gbc_scrollPane_4.gridy = 1;
		panel_Home.add(scrollPane_4, gbc_scrollPane_4);

		label_SetNoteAusarbeitungListe = new JLabel("");
		scrollPane_4.setViewportView(label_SetNoteAusarbeitungListe);
		label_SetNoteAusarbeitungListe.setVerticalAlignment(SwingConstants.TOP);
		label_SetNoteAusarbeitungListe.setText(ausarbeitungNote);

		lblMatrikelnummer = new JLabel("Matrikelnummer");
		GridBagConstraints gbc_lblMatrikelnummer = new GridBagConstraints();
		gbc_lblMatrikelnummer.anchor = GridBagConstraints.WEST;
		gbc_lblMatrikelnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatrikelnummer.gridx = 1;
		gbc_lblMatrikelnummer.gridy = 4;
		panel_Home.add(lblMatrikelnummer, gbc_lblMatrikelnummer);

		textField_MatNr = new JTextField();
		GridBagConstraints gbc_textField_MatNr = new GridBagConstraints();
		gbc_textField_MatNr.insets = new Insets(0, 0, 5, 5);
		gbc_textField_MatNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_MatNr.gridx = 1;
		gbc_textField_MatNr.gridy = 6;
		panel_Home.add(textField_MatNr, gbc_textField_MatNr);
		textField_MatNr.setColumns(10);

		btnStudentSuchen = new JButton("suchen");
		btnStudentSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String student = Datenbankzugriff.sucheStudentFürBetreuer(hftBetreuer,
							Integer.parseInt(textField_MatNr.getText()));
					if (student.equals("") == false) {
						btnVerwalten.setVisible(true);
						label_StudentErgebnis.setText(student);

					}
				} catch (Exception x) {
					JOptionPane.showMessageDialog(null, "Geben sie bitte nur Zahlen bei der \n Matrikelnummer ein");
				}

			}
		});
		GridBagConstraints gbc_btnStudentSuchen = new GridBagConstraints();
		gbc_btnStudentSuchen.insets = new Insets(0, 0, 5, 5);
		gbc_btnStudentSuchen.gridx = 3;
		gbc_btnStudentSuchen.gridy = 6;
		panel_Home.add(btnStudentSuchen, gbc_btnStudentSuchen);

		label_StudentErgebnis = new JLabel("");
		GridBagConstraints gbc_label_StudentErgebnis = new GridBagConstraints();
		gbc_label_StudentErgebnis.insets = new Insets(0, 0, 5, 5);
		gbc_label_StudentErgebnis.gridx = 3;
		gbc_label_StudentErgebnis.gridy = 7;
		panel_Home.add(label_StudentErgebnis, gbc_label_StudentErgebnis);

		btnVerwalten = new JButton("verwalten");
		btnVerwalten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sie verwalten jetzt diesen Student!");
				studentVerwalten = Datenbankzugriff.sucheStudent(Integer.parseInt(textField_MatNr.getText()));
				lblSieVerwaltenKeinen.setText(
						"Sie verwalten : " + studentVerwalten.getName() + " " + studentVerwalten.getNachname());

				String[] setUnternehmenThema = Datenbankzugriff.getThema(studentVerwalten).split(": ");
				// Felder in Anmeldung
				label_SetUnternehmen.setText(setUnternehmenThema[0]);
				label_SetThema.setText(setUnternehmenThema[1]);
				// Felder in Bewertung
				label_SetName.setText(studentVerwalten.getName() + " " + studentVerwalten.getNachname());
				label_SetThemaNote.setText(setUnternehmenThema[1]);
				label_SetUnternehmenNote.setText(setUnternehmenThema[0]);
				label_StudentName.setText(studentVerwalten.getName() + " " + studentVerwalten.getNachname() + " ("
						+ studentVerwalten.getMatrikelnummer() + ")");
			}
		});
		GridBagConstraints gbc_btnVerwalten = new GridBagConstraints();
		gbc_btnVerwalten.insets = new Insets(0, 0, 0, 5);
		gbc_btnVerwalten.gridx = 3;
		gbc_btnVerwalten.gridy = 8;
		panel_Home.add(btnVerwalten, gbc_btnVerwalten);

		btnVerwalten.setVisible(false);

		// Thema eintragen:
		Panel_ThemaEintragen = new JPanel();
		tabbedPane.addTab("Thema suchen", null, Panel_ThemaEintragen, null);
		GridBagLayout gbl_Panel_ThemaEintragen = new GridBagLayout();
		gbl_Panel_ThemaEintragen.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_Panel_ThemaEintragen.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_Panel_ThemaEintragen.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_Panel_ThemaEintragen.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		Panel_ThemaEintragen.setLayout(gbl_Panel_ThemaEintragen);

		lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.gridwidth = 2;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 3;
		gbc_lblName.gridy = 0;
		Panel_ThemaEintragen.add(lblName, gbc_lblName);

		label_StudentSuchenNachname = new JLabel("Nachname:");
		GridBagConstraints gbc_label_StudentSuchenNachname = new GridBagConstraints();
		gbc_label_StudentSuchenNachname.anchor = GridBagConstraints.WEST;
		gbc_label_StudentSuchenNachname.insets = new Insets(0, 0, 5, 5);
		gbc_label_StudentSuchenNachname.gridx = 8;
		gbc_label_StudentSuchenNachname.gridy = 0;
		Panel_ThemaEintragen.add(label_StudentSuchenNachname, gbc_label_StudentSuchenNachname);

		lblStudentSuchen = new JLabel("Student suchen:");
		GridBagConstraints gbc_lblStudentSuchen = new GridBagConstraints();
		gbc_lblStudentSuchen.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudentSuchen.gridx = 1;
		gbc_lblStudentSuchen.gridy = 1;
		Panel_ThemaEintragen.add(lblStudentSuchen, gbc_lblStudentSuchen);

		textField_StudentSuchenName = new JTextField();
		GridBagConstraints gbc_textField_StudentSuchenName = new GridBagConstraints();
		gbc_textField_StudentSuchenName.gridwidth = 4;
		gbc_textField_StudentSuchenName.insets = new Insets(0, 0, 5, 5);
		gbc_textField_StudentSuchenName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_StudentSuchenName.gridx = 3;
		gbc_textField_StudentSuchenName.gridy = 1;
		Panel_ThemaEintragen.add(textField_StudentSuchenName, gbc_textField_StudentSuchenName);
		textField_StudentSuchenName.setColumns(10);

		textField_StudentSuchenNachname = new JTextField();
		GridBagConstraints gbc_textField_StudentSuchenNachname = new GridBagConstraints();
		gbc_textField_StudentSuchenNachname.gridwidth = 3;
		gbc_textField_StudentSuchenNachname.insets = new Insets(0, 0, 5, 5);
		gbc_textField_StudentSuchenNachname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_StudentSuchenNachname.gridx = 8;
		gbc_textField_StudentSuchenNachname.gridy = 1;
		Panel_ThemaEintragen.add(textField_StudentSuchenNachname, gbc_textField_StudentSuchenNachname);
		textField_StudentSuchenNachname.setColumns(10);

		label_StudentSuchenThemaErgebnis = new JLabel("");
		GridBagConstraints gbc_label_StudentSuchenThemaErgebnis = new GridBagConstraints();
		gbc_label_StudentSuchenThemaErgebnis.anchor = GridBagConstraints.WEST;
		gbc_label_StudentSuchenThemaErgebnis.gridwidth = 12;
		gbc_label_StudentSuchenThemaErgebnis.insets = new Insets(0, 0, 5, 5);
		gbc_label_StudentSuchenThemaErgebnis.gridx = 1;
		gbc_label_StudentSuchenThemaErgebnis.gridy = 5;
		Panel_ThemaEintragen.add(label_StudentSuchenThemaErgebnis, gbc_label_StudentSuchenThemaErgebnis);

		btnSuchen = new JButton("suchen");
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Datenbankzugriff.studentMitThemaSuchen(textField_StudentSuchenNachname.getText(),
						textField_StudentSuchenName.getText()).equals("") == false) {
					btnFrStudentVerbindlich.setVisible(true);
				}
				label_StudentSuchenThemaErgebnis.setText(Datenbankzugriff.studentMitThemaSuchen(
						textField_StudentSuchenNachname.getText(), textField_StudentSuchenName.getText()));
			}
		});

		btnFrStudentVerbindlich = new JButton("F\u00FCr Student verbindlich eintragen!");
		btnFrStudentVerbindlich.setVisible(false);
		btnFrStudentVerbindlich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Datenbankzugriff.hftBetreuerThemaBestaetigen(hftBetreuer.getId(), hftBetreuer.getNachname(),
						hftBetreuer.getEmail(), textField_StudentSuchenNachname.getText(),
						textField_StudentSuchenName.getText());

				// Studentenliste aktualisieren
				ArrayList<Thema> themaListe = Datenbankzugriff.getListeFürBetreuer(hftBetreuer);
				String ausgabe = "<html><body>";
				for (Thema thema : themaListe) {
					ausgabe += thema.getStudentName() + " " + thema.getStudentVorname() + " ("
							+ thema.getMatrikelnummer() + ")" + "<br>";
				}
				ausgabe += "</body></html>";
				label_Student.setText(ausgabe);
				label_SetStudentenAbgabe.setText(ausgabe);

				// NDA Liste aktualisieren
				String nda = "<html><body>";
				for (Thema thema : themaListe) {
					if (thema.getNda().equals("") == true) {
						nda += "k.A." + "<br>";
					} else {
						nda += thema.getNda() + "<br>";
					}
				}
				nda += "</body></html>";
				label_NDA.setText(nda);

				// THemaUnternehemen liste aktualisieren
				String unternehemenThema = "<html><body>";
				for (Thema thema : themaListe) {
					unternehemenThema += thema.getUnternehmen() + "  " + thema.getThema() + "<br>";
				}
				unternehemenThema += "</body></html>";
				label_UntThemaListe.setText(unternehemenThema);

				// Anmeldestatus Liste Aktualisieren
				ArrayList<Thema> themaListe2 = Datenbankzugriff.getListeFürBetreuer(hftBetreuer);

				String anmeldungListe = "<html><body>";
				for (Thema thema : themaListe2) {
					anmeldungListe += Datenbankzugriff.getAnmeldestatusByMatNr(thema.getMatrikelnummer()) + " <br>";
				}
				anmeldungListe += "</body></html>";
				label_SetAnmeldeStatus.setText(anmeldungListe);

				// AusarbeitunNote Liste aktualisieren:
				ArrayList<Thema> themaListe3 = Datenbankzugriff.getListeFürBetreuer(hftBetreuer);
				String ausarbeitungNote = "<html><body>";
				for (Thema thema : themaListe3) {
					ausarbeitungNote += Datenbankzugriff.getAusarbeitungNoteByMatNr(thema.getMatrikelnummer())
							+ " <br>";
				}
				ausarbeitungNote += "</body></html>";
				label_SetNoteAusarbeitungListe.setText(ausarbeitungNote);

//				Aktualisiere Status
				ArrayList<String> statusListe = Datenbankzugriff.getStatusAbgaben(hftBetreuer);

				String status = "<html><body>";
				for (String string : statusListe) {
					status += string + " <br>";
				}
				status += "</body></html>";

				label_SetStatus.setText(status);

			}
		});
		GridBagConstraints gbc_btnFrStudentVerbindlich = new GridBagConstraints();
		gbc_btnFrStudentVerbindlich.insets = new Insets(0, 0, 5, 5);
		gbc_btnFrStudentVerbindlich.gridx = 14;
		gbc_btnFrStudentVerbindlich.gridy = 4;
		Panel_ThemaEintragen.add(btnFrStudentVerbindlich, gbc_btnFrStudentVerbindlich);

		GridBagConstraints gbc_btnSuchen = new GridBagConstraints();
		gbc_btnSuchen.insets = new Insets(0, 0, 5, 5);
		gbc_btnSuchen.gridx = 12;
		gbc_btnSuchen.gridy = 1;
		Panel_ThemaEintragen.add(btnSuchen, gbc_btnSuchen);

		// NDA:

		panel_NDA = new JPanel();
		tabbedPane.addTab("NDA", null, panel_NDA, null);
		GridBagLayout gbl_panel_NDA = new GridBagLayout();
		gbl_panel_NDA.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_NDA.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_NDA.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_NDA.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_NDA.setLayout(gbl_panel_NDA);

		button_NDANein = new JRadioButton("Keine NDA wird ben\u00F6tigt");
		buttonGroup_1.add(button_NDANein);
		GridBagConstraints gbc_button_NDANein = new GridBagConstraints();
		gbc_button_NDANein.anchor = GridBagConstraints.WEST;
		gbc_button_NDANein.insets = new Insets(0, 0, 5, 5);
		gbc_button_NDANein.gridx = 0;
		gbc_button_NDANein.gridy = 0;
		panel_NDA.add(button_NDANein, gbc_button_NDANein);

		button_NDAJa = new JRadioButton("NDA wird ben\u00F6tigt und wurde von allen Parteien best\u00E4tigt");
		buttonGroup_1.add(button_NDAJa);
		GridBagConstraints gbc_button_NDAJa = new GridBagConstraints();
		gbc_button_NDAJa.anchor = GridBagConstraints.WEST;
		gbc_button_NDAJa.insets = new Insets(0, 0, 5, 5);
		gbc_button_NDAJa.gridx = 0;
		gbc_button_NDAJa.gridy = 1;
		panel_NDA.add(button_NDAJa, gbc_button_NDAJa);

		btnBesttigen = new JButton("Best\u00E4tigen");
		btnBesttigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (studentVerwalten == null) {
					JOptionPane.showMessageDialog(null, "Sie müssen zuerst einen Student verwalten!");
					return;
				}

				if (button_NDAJa.isSelected() == true) {
					Datenbankzugriff.trageNDAein(studentVerwalten, "bestätigt");
					JOptionPane.showMessageDialog(null, "NDA wurde bestätigt");
					// NDA Liste aktualisieren
					ArrayList<Thema> themaListe = Datenbankzugriff.getListeFürBetreuer(hftBetreuer);
					String nda = "<html><body>";
					for (Thema thema : themaListe) {
						if (thema.getNda().equals("") == true) {
							nda += "k.A." + "<br>";
						} else {
							nda += thema.getNda() + "<br>";
						}
					}
					nda += "</body></html>";
					label_NDA.setText(nda);
					return;
				}
				if (button_NDANein.isSelected() == true) {
					Datenbankzugriff.trageNDAein(studentVerwalten, "keine benötigt");
					JOptionPane.showMessageDialog(null, "Es wurde eingetragen \n dass keine NDA notwendig ist!");
					// NDA Liste aktualisieren
					ArrayList<Thema> themaListe = Datenbankzugriff.getListeFürBetreuer(hftBetreuer);
					String nda = "<html><body>";
					for (Thema thema : themaListe) {
						if (thema.getNda().equals("") == true) {
							nda += "k.A." + "<br>";
						} else {
							nda += thema.getNda() + "<br>";
						}
					}
					nda += "</body></html>";
					label_NDA.setText(nda);

					return;
				}
				JOptionPane.showMessageDialog(null, "Sie müssen ein Button auswählen!");
			}
		});
		GridBagConstraints gbc_btnBesttigen = new GridBagConstraints();
		gbc_btnBesttigen.insets = new Insets(0, 0, 5, 5);
		gbc_btnBesttigen.gridx = 2;
		gbc_btnBesttigen.gridy = 1;
		panel_NDA.add(btnBesttigen, gbc_btnBesttigen);

		// Anmeldeformular

		panel_Anmeldeformular = new JPanel();
		tabbedPane.addTab("Anmeldeformular", null, panel_Anmeldeformular, null);
		GridBagLayout gbl_panel_Anmeldeformular = new GridBagLayout();
		gbl_panel_Anmeldeformular.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0 };
		gbl_panel_Anmeldeformular.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_Anmeldeformular.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Anmeldeformular.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_Anmeldeformular.setLayout(gbl_panel_Anmeldeformular);

		label_erstens = new JLabel("1. Die Betreuung der Bachelor-Arbeit wird von mir \u00FCbernommen.");
		GridBagConstraints gbc_label_erstens = new GridBagConstraints();
		gbc_label_erstens.anchor = GridBagConstraints.WEST;
		gbc_label_erstens.gridwidth = 22;
		gbc_label_erstens.insets = new Insets(0, 0, 5, 5);
		gbc_label_erstens.gridx = 1;
		gbc_label_erstens.gridy = 2;
		panel_Anmeldeformular.add(label_erstens, gbc_label_erstens);

		label_zweitens = new JLabel("2. Als Thema der Bachelor-Arbeit wird vorgeschlagen:");
		GridBagConstraints gbc_label_zweitens = new GridBagConstraints();
		gbc_label_zweitens.anchor = GridBagConstraints.WEST;
		gbc_label_zweitens.gridwidth = 10;
		gbc_label_zweitens.insets = new Insets(0, 0, 5, 5);
		gbc_label_zweitens.gridx = 1;
		gbc_label_zweitens.gridy = 3;
		panel_Anmeldeformular.add(label_zweitens, gbc_label_zweitens);

		label_SetUnternehmen = new JLabel("<Unternehmen>");
		GridBagConstraints gbc_label_SetUnternehmen = new GridBagConstraints();
		gbc_label_SetUnternehmen.anchor = GridBagConstraints.WEST;
		gbc_label_SetUnternehmen.gridwidth = 15;
		gbc_label_SetUnternehmen.insets = new Insets(0, 0, 5, 5);
		gbc_label_SetUnternehmen.gridx = 1;
		gbc_label_SetUnternehmen.gridy = 4;
		panel_Anmeldeformular.add(label_SetUnternehmen, gbc_label_SetUnternehmen);

		label_SetThema = new JLabel("<Thema>");
		GridBagConstraints gbc_label_SetThema = new GridBagConstraints();
		gbc_label_SetThema.anchor = GridBagConstraints.WEST;
		gbc_label_SetThema.gridwidth = 23;
		gbc_label_SetThema.insets = new Insets(0, 0, 5, 0);
		gbc_label_SetThema.gridx = 1;
		gbc_label_SetThema.gridy = 5;
		panel_Anmeldeformular.add(label_SetThema, gbc_label_SetThema);

		rb_Ja = new JRadioButton("Ja");
		buttonGroup_2.add(rb_Ja);
		GridBagConstraints gbc_rb_Ja = new GridBagConstraints();
		gbc_rb_Ja.insets = new Insets(0, 0, 5, 5);
		gbc_rb_Ja.gridx = 11;
		gbc_rb_Ja.gridy = 5;
		panel_Anmeldeformular.add(rb_Ja, gbc_rb_Ja);

		rb_Nein = new JRadioButton("Nein");
		buttonGroup_2.add(rb_Nein);
		GridBagConstraints gbc_rb_Nein = new GridBagConstraints();
		gbc_rb_Nein.insets = new Insets(0, 0, 5, 5);
		gbc_rb_Nein.gridx = 13;
		gbc_rb_Nein.gridy = 5;
		panel_Anmeldeformular.add(rb_Nein, gbc_rb_Nein);

		lblDasInterdisziplinre = new JLabel("3. Das Interdisziplin\u00E4re Projekt ist bestanden:");
		GridBagConstraints gbc_lblDasInterdisziplinre = new GridBagConstraints();
		gbc_lblDasInterdisziplinre.anchor = GridBagConstraints.WEST;
		gbc_lblDasInterdisziplinre.gridwidth = 10;
		gbc_lblDasInterdisziplinre.insets = new Insets(0, 0, 5, 5);
		gbc_lblDasInterdisziplinre.gridx = 1;
		gbc_lblDasInterdisziplinre.gridy = 6;
		panel_Anmeldeformular.add(lblDasInterdisziplinre, gbc_lblDasInterdisziplinre);

		btnAnmelden = new JButton("Anmelden");
		btnAnmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (studentVerwalten == null) {
					JOptionPane.showMessageDialog(null, "Sie müssen zuerst einen Student verwalten!");
					return;
				}

				if (rb_Ja.isSelected() == true) {
					Datenbankzugriff.bestätigeAnmeldung(studentVerwalten);
					// Anmeldestatus Liste Aktualisieren
					ArrayList<Thema> themaListe2 = Datenbankzugriff.getListeFürBetreuer(hftBetreuer);

					String anmeldungListe = "<html><body>";
					for (Thema thema : themaListe2) {
						anmeldungListe += Datenbankzugriff.getAnmeldestatusByMatNr(thema.getMatrikelnummer()) + " <br>";
					}
					anmeldungListe += "</body></html>";
					label_SetAnmeldeStatus.setText(anmeldungListe);

				} else {
					JOptionPane.showMessageDialog(null, "Das Interdisziplinäre Projekt \n muss bestanden sein!");
				}
			}
		});
		GridBagConstraints gbc_btnAnmelden = new GridBagConstraints();
		gbc_btnAnmelden.gridx = 23;
		gbc_btnAnmelden.gridy = 10;
		panel_Anmeldeformular.add(btnAnmelden, gbc_btnAnmelden);

		// Abgaben:

		panel_Endversionabgaben = new JPanel();
		tabbedPane.addTab("Abgaben", null, panel_Endversionabgaben, null);
		GridBagLayout gbl_panel_Abgaben = new GridBagLayout();
		gbl_panel_Abgaben.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gbl_panel_Abgaben.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_Abgaben.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Abgaben.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_Endversionabgaben.setLayout(gbl_panel_Abgaben);

		lblStudent_1 = new JLabel("Student");
		GridBagConstraints gbc_lblStudent_1 = new GridBagConstraints();
		gbc_lblStudent_1.anchor = GridBagConstraints.WEST;
		gbc_lblStudent_1.gridwidth = 2;
		gbc_lblStudent_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudent_1.gridx = 0;
		gbc_lblStudent_1.gridy = 0;
		panel_Endversionabgaben.add(lblStudent_1, gbc_lblStudent_1);

		lblStatus = new JLabel("Status");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.WEST;
		gbc_lblStatus.gridwidth = 2;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 6;
		gbc_lblStatus.gridy = 0;
		panel_Endversionabgaben.add(lblStatus, gbc_lblStatus);

		scrollPane_5 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_5 = new GridBagConstraints();
		gbc_scrollPane_5.gridheight = 5;
		gbc_scrollPane_5.gridwidth = 6;
		gbc_scrollPane_5.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_5.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_5.gridx = 0;
		gbc_scrollPane_5.gridy = 1;
		panel_Endversionabgaben.add(scrollPane_5, gbc_scrollPane_5);

		label_SetStudentenAbgabe = new JLabel("");
		label_SetStudentenAbgabe.setVerticalAlignment(SwingConstants.TOP);
		scrollPane_5.setViewportView(label_SetStudentenAbgabe);
		label_SetStudentenAbgabe.setText(ausgabe);

		scrollPane_6 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_6 = new GridBagConstraints();
		gbc_scrollPane_6.gridheight = 5;
		gbc_scrollPane_6.gridwidth = 7;
		gbc_scrollPane_6.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_6.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_6.gridx = 6;
		gbc_scrollPane_6.gridy = 1;
		panel_Endversionabgaben.add(scrollPane_6, gbc_scrollPane_6);

		label_SetStatus = new JLabel("");
		label_SetStatus.setVerticalAlignment(SwingConstants.TOP);
		scrollPane_6.setViewportView(label_SetStatus);

		// SetStatus ausfüllen
		ArrayList<String> statusListe = Datenbankzugriff.getStatusAbgaben(hftBetreuer);

		String status = "<html><body>";
		for (String string : statusListe) {
			status += string + " <br>";
		}
		status += "</body></html>";

		label_SetStatus.setText(status);

		label_StudentName = new JLabel("<Student Name>");
		GridBagConstraints gbc_label_StudentName = new GridBagConstraints();
		gbc_label_StudentName.anchor = GridBagConstraints.WEST;
		gbc_label_StudentName.gridwidth = 2;
		gbc_label_StudentName.insets = new Insets(0, 0, 5, 5);
		gbc_label_StudentName.gridx = 0;
		gbc_label_StudentName.gridy = 6;
		panel_Endversionabgaben.add(label_StudentName, gbc_label_StudentName);

		rdbtnZwischenversionBesttigt = new JRadioButton("Zwischenversion best\u00E4tigt");
		buttonGroup_3.add(rdbtnZwischenversionBesttigt);
		GridBagConstraints gbc_rdbtnZwischenversionBesttigt = new GridBagConstraints();
		gbc_rdbtnZwischenversionBesttigt.anchor = GridBagConstraints.WEST;
		gbc_rdbtnZwischenversionBesttigt.gridwidth = 15;
		gbc_rdbtnZwischenversionBesttigt.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnZwischenversionBesttigt.gridx = 0;
		gbc_rdbtnZwischenversionBesttigt.gridy = 7;
		panel_Endversionabgaben.add(rdbtnZwischenversionBesttigt, gbc_rdbtnZwischenversionBesttigt);

		rdbtnEndversionbesttigt = new JRadioButton("Endversion Best\u00E4tigt");
		buttonGroup_3.add(rdbtnEndversionbesttigt);
		GridBagConstraints gbc_rdbtnEndversionbesttigt = new GridBagConstraints();
		gbc_rdbtnEndversionbesttigt.anchor = GridBagConstraints.WEST;
		gbc_rdbtnEndversionbesttigt.gridwidth = 13;
		gbc_rdbtnEndversionbesttigt.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEndversionbesttigt.gridx = 0;
		gbc_rdbtnEndversionbesttigt.gridy = 8;
		panel_Endversionabgaben.add(rdbtnEndversionbesttigt, gbc_rdbtnEndversionbesttigt);

		btnBesttigen_1 = new JButton("Best\u00E4tigen");
		btnBesttigen_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (studentVerwalten == null) {
					JOptionPane.showMessageDialog(null, "Sie müssen zuerst einen Student verwalten!");
					return;
				}

				if (rdbtnZwischenversionBesttigt.isSelected()) {
					Datenbankzugriff.aktualisiereZVAbgaben(studentVerwalten);
					// Aktualisiere Status
					ArrayList<String> statusListe = Datenbankzugriff.getStatusAbgaben(hftBetreuer);

					String status = "<html><body>";
					for (String string : statusListe) {
						status += string + " <br>";
					}
					status += "</body></html>";

					label_SetStatus.setText(status);
					return;
				}
				if (rdbtnEndversionbesttigt.isSelected()) {
					Datenbankzugriff.aktualisiereEVAbgaben(studentVerwalten);
					// Aktualisiere Status
					ArrayList<String> statusListe = Datenbankzugriff.getStatusAbgaben(hftBetreuer);

					String status = "<html><body>";
					for (String string : statusListe) {
						status += string + " <br>";
					}
					status += "</body></html>";

					label_SetStatus.setText(status);
					return;
				}

				// Aktualisiere Status
				ArrayList<String> statusListe = Datenbankzugriff.getStatusAbgaben(hftBetreuer);

				String status = "<html><body>";
				for (String string : statusListe) {
					status += string + " <br>";
				}
				status += "</body></html>";

				label_SetStatus.setText(status);

				JOptionPane.showMessageDialog(null, "Sie müssen ein Button auswählen!");

			}
		});
		GridBagConstraints gbc_btnBesttigen_1 = new GridBagConstraints();
		gbc_btnBesttigen_1.gridx = 23;
		gbc_btnBesttigen_1.gridy = 9;
		panel_Endversionabgaben.add(btnBesttigen_1, gbc_btnBesttigen_1);

		// Bewertung:

		Bewertung = new JPanel();
		tabbedPane.addTab("Bewertung", null, Bewertung, null);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_5.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		Bewertung.setLayout(gbl_panel_5);

		lblBewertung = new JLabel("Bewertung");
		GridBagConstraints gbc_lblBewertung = new GridBagConstraints();
		gbc_lblBewertung.anchor = GridBagConstraints.WEST;
		gbc_lblBewertung.gridwidth = 5;
		gbc_lblBewertung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBewertung.gridx = 1;
		gbc_lblBewertung.gridy = 1;
		Bewertung.add(lblBewertung, gbc_lblBewertung);

		lblName_1 = new JLabel("Name:");
		GridBagConstraints gbc_lblName_1 = new GridBagConstraints();
		gbc_lblName_1.anchor = GridBagConstraints.WEST;
		gbc_lblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblName_1.gridx = 1;
		gbc_lblName_1.gridy = 2;
		Bewertung.add(lblName_1, gbc_lblName_1);

		label_SetName = new JLabel("<Name>");
		GridBagConstraints gbc_label_SetName = new GridBagConstraints();
		gbc_label_SetName.gridwidth = 9;
		gbc_label_SetName.anchor = GridBagConstraints.WEST;
		gbc_label_SetName.insets = new Insets(0, 0, 5, 5);
		gbc_label_SetName.gridx = 2;
		gbc_label_SetName.gridy = 2;
		Bewertung.add(label_SetName, gbc_label_SetName);

		lblUnternehmen = new JLabel("Unternehmen:");
		GridBagConstraints gbc_lblUnternehmen = new GridBagConstraints();
		gbc_lblUnternehmen.anchor = GridBagConstraints.WEST;
		gbc_lblUnternehmen.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnternehmen.gridx = 1;
		gbc_lblUnternehmen.gridy = 3;
		Bewertung.add(lblUnternehmen, gbc_lblUnternehmen);

		label_SetUnternehmenNote = new JLabel("<Unternehmen>");
		GridBagConstraints gbc_label_SetUnternehmenNote = new GridBagConstraints();
		gbc_label_SetUnternehmenNote.anchor = GridBagConstraints.WEST;
		gbc_label_SetUnternehmenNote.insets = new Insets(0, 0, 5, 5);
		gbc_label_SetUnternehmenNote.gridx = 2;
		gbc_label_SetUnternehmenNote.gridy = 3;
		Bewertung.add(label_SetUnternehmenNote, gbc_label_SetUnternehmenNote);

		lblThema = new JLabel("Thema:");
		GridBagConstraints gbc_lblThema = new GridBagConstraints();
		gbc_lblThema.anchor = GridBagConstraints.WEST;
		gbc_lblThema.insets = new Insets(0, 0, 5, 5);
		gbc_lblThema.gridx = 1;
		gbc_lblThema.gridy = 4;
		Bewertung.add(lblThema, gbc_lblThema);

		label_SetThemaNote = new JLabel("<Thema>");
		GridBagConstraints gbc_label_SetThemaNote = new GridBagConstraints();
		gbc_label_SetThemaNote.gridwidth = 9;
		gbc_label_SetThemaNote.anchor = GridBagConstraints.WEST;
		gbc_label_SetThemaNote.insets = new Insets(0, 0, 5, 5);
		gbc_label_SetThemaNote.gridx = 2;
		gbc_label_SetThemaNote.gridy = 4;
		Bewertung.add(label_SetThemaNote, gbc_label_SetThemaNote);

		lblNoteAusarbeitung = new JLabel("Note Ausarbeitung:");
		GridBagConstraints gbc_lblNoteAusarbeitung = new GridBagConstraints();
		gbc_lblNoteAusarbeitung.anchor = GridBagConstraints.WEST;
		gbc_lblNoteAusarbeitung.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoteAusarbeitung.gridx = 1;
		gbc_lblNoteAusarbeitung.gridy = 6;
		Bewertung.add(lblNoteAusarbeitung, gbc_lblNoteAusarbeitung);

		comboBox_Note = new JComboBox();
		GridBagConstraints gbc_comboBox_Note = new GridBagConstraints();
		gbc_comboBox_Note.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Note.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Note.gridx = 2;
		gbc_comboBox_Note.gridy = 6;
		Bewertung.add(comboBox_Note, gbc_comboBox_Note);
		comboBox_Note.addItem("1.0");
		comboBox_Note.addItem("1.3");
		comboBox_Note.addItem("1.7");
		comboBox_Note.addItem("2.0");
		comboBox_Note.addItem("2.3");
		comboBox_Note.addItem("2.7");
		comboBox_Note.addItem("3.0");
		comboBox_Note.addItem("3.3");
		comboBox_Note.addItem("3.7");
		comboBox_Note.addItem("4.0");

		btnBewerten = new JButton("Bewerten");
		btnBewerten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (studentVerwalten == null) {
					JOptionPane.showMessageDialog(null, "Sie müssen zuerst einen Student verwalten!");
					return;
				}

				if (Datenbankzugriff.istEndversionSchonbestätigt(studentVerwalten.getMatrikelnummer()) == true) {
					Double note = Double.parseDouble((String) comboBox_Note.getSelectedItem());
					Datenbankzugriff.setNoteBetreuer(studentVerwalten, note);

					// AusarbeitunNote Liste aktualisieren:
					ArrayList<Thema> themaListe2 = Datenbankzugriff.getListeFürBetreuer(hftBetreuer);
					String ausarbeitungNote = "<html><body>";
					for (Thema thema : themaListe2) {
						ausarbeitungNote += Datenbankzugriff.getAusarbeitungNoteByMatNr(thema.getMatrikelnummer())
								+ " <br>";
					}
					ausarbeitungNote += "</body></html>";
					label_SetNoteAusarbeitungListe.setText(ausarbeitungNote);
				} else {
					JOptionPane.showMessageDialog(null,
							"Sie können die Ausarbeitung erst dann bewerten, \nwenn die Endversion abgegeben und von \nIhnen bestätigt worden ist!");
				}

			}
		});
		GridBagConstraints gbc_btnBewerten = new GridBagConstraints();
		gbc_btnBewerten.gridx = 21;
		gbc_btnBewerten.gridy = 8;
		Bewertung.add(btnBewerten, gbc_btnBewerten);
	}

}
