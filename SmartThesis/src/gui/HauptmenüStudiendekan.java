package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datenbank.Datenbankzugriff;
import objekte.Student;
import objekte.Studiendekan;
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
import javax.swing.JComboBox;

public class HauptmenüStudiendekan extends JFrame {

	private JPanel contentPane;
	private JTextField textField_AngemeldetAls;
	private JTabbedPane tabbedPane;
	private JPanel Panel_Hauptmenü;
	private JPanel Bewertung;
	private JButton btnLogout;
	private static Studiendekan studiendekan;
	private JScrollPane scrollPane_ThemaListe;
	private JLabel label_Student;
	private JLabel lblStudent;
	private JLabel lblUnternehmenThema;
	private JScrollPane scrollPane;
	private JLabel label_UundTText;
	private JLabel lblBetreuer;
	private JScrollPane scrollPane_1;
	private JLabel label_BetreuerListe;
	private JLabel lblNda;
	private JScrollPane scrollPane_2;
	private JLabel label_NDAListe;
	private JLabel lblAnmeldestatus;
	private JScrollPane scrollPane_3;
	private JLabel label_SetAnmeldestatus;
	private JLabel lbl_StudentSuchen;
	private JTextField textField_Matrikelnummer;
	private JButton btn_SuchenVerwalten;
	private JLabel lblName;
	private JLabel lblMatrikelnummer;
	private JLabel lblSetName;
	private JLabel lblUnternehmen;
	private JLabel lblseUnternehmen;
	private JLabel lblThema;
	private JLabel lblsetThema;
	private JLabel lblNoteSeminar;
	private JComboBox comboBox;
	private JButton btnBewerten;
	private Student studentVerwalten;
	private Thema studentThema;
	private JLabel lblBewertung;
	private JScrollPane scrollPane_4;
	private JLabel label_SetBewertung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studiendekan = new Studiendekan(10000, "Max", "Mustermann", "MaxMustermann@hft", "max",
							"Studiendekan");
					HauptmenüStudiendekan frame = new HauptmenüStudiendekan(studiendekan);
					frame.setSize(850, 450);
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
	public HauptmenüStudiendekan(Studiendekan studiendekan) {
		this.studiendekan = studiendekan;
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

		// Überall Sichtbar:

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
		label_AngemeldetAlsName.setText(studiendekan.getName() + " " + studiendekan.getNachname());
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

		// Thema
		ArrayList<Thema> themaListe = Datenbankzugriff.getListeFürStudiendekan();
		String student = "<html><body>";
		for (Thema thema : themaListe) {
			student += thema.getStudentName() + " " + thema.getStudentVorname() + " (" + thema.getMatrikelnummer() + ")"
					+ "<br>";
		}
		student += "</body></html>";

		// Anmeldestatus

		ArrayList<Thema> themaListe2 = Datenbankzugriff.getListeFürStudiendekan();

		String anmeldungListe = "<html><body>";
		for (Thema thema : themaListe2) {
			anmeldungListe += Datenbankzugriff.getAnmeldestatusByMatNr(thema.getMatrikelnummer()) + " <br>";
		}
		anmeldungListe += "</body></html>";

		// NDA Liste:

		String nda = "<html><body>";
		for (Thema thema : themaListe) {

			if (thema.getNda().equals("") == true) {
				nda += "k.A" + "<br>";
			} else {
				nda += thema.getNda() + "<br>";
			}

		}
		nda += "</body></html>";
		// Liste Betreuer:

		String betreuer = "<html><body>";
		for (Thema thema : themaListe) {
			int betreuerNummer = thema.getBetreuerNummer();

			if (betreuerNummer == 0) {
				betreuer += " KEIN BETREUER!!! " + "<br>";
			} else {
				betreuer += thema.getBetreuerName() + " (" + thema.getBetreuerNummer() + ")" + "<br>";
			}

		}
		betreuer += "</body></html>";

		// Liste Unternehemen:

		String unternehmenUndThema = "<html><body>";
		for (Thema thema : themaListe) {
			unternehmenUndThema += thema.getUnternehmen() + " " + thema.getThema() + "<br>";
		}
		unternehmenUndThema += "</body></html>";

		// Hauptmenü:
		Panel_Hauptmenü = new JPanel();
		tabbedPane.addTab("Thema Liste", null, Panel_Hauptmenü, null);
		GridBagLayout gbl_Panel_Hauptmenü = new GridBagLayout();
		gbl_Panel_Hauptmenü.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_Panel_Hauptmenü.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_Panel_Hauptmenü.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0,
				1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_Panel_Hauptmenü.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		Panel_Hauptmenü.setLayout(gbl_Panel_Hauptmenü);

		lblStudent = new JLabel("Student");
		GridBagConstraints gbc_lblStudent = new GridBagConstraints();
		gbc_lblStudent.anchor = GridBagConstraints.WEST;
		gbc_lblStudent.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudent.gridx = 1;
		gbc_lblStudent.gridy = 0;
		Panel_Hauptmenü.add(lblStudent, gbc_lblStudent);

		lblUnternehmenThema = new JLabel("Unternehmen + Thema");
		GridBagConstraints gbc_lblUnternehmenThema = new GridBagConstraints();
		gbc_lblUnternehmenThema.anchor = GridBagConstraints.WEST;
		gbc_lblUnternehmenThema.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnternehmenThema.gridx = 6;
		gbc_lblUnternehmenThema.gridy = 0;
		Panel_Hauptmenü.add(lblUnternehmenThema, gbc_lblUnternehmenThema);

		lblBetreuer = new JLabel("Betreuer");
		GridBagConstraints gbc_lblBetreuer = new GridBagConstraints();
		gbc_lblBetreuer.anchor = GridBagConstraints.WEST;
		gbc_lblBetreuer.gridwidth = 2;
		gbc_lblBetreuer.insets = new Insets(0, 0, 5, 5);
		gbc_lblBetreuer.gridx = 8;
		gbc_lblBetreuer.gridy = 0;
		Panel_Hauptmenü.add(lblBetreuer, gbc_lblBetreuer);

		lblNda = new JLabel("NDA");
		GridBagConstraints gbc_lblNda = new GridBagConstraints();
		gbc_lblNda.gridwidth = 2;
		gbc_lblNda.anchor = GridBagConstraints.WEST;
		gbc_lblNda.insets = new Insets(0, 0, 5, 5);
		gbc_lblNda.gridx = 11;
		gbc_lblNda.gridy = 0;
		Panel_Hauptmenü.add(lblNda, gbc_lblNda);

		lblAnmeldestatus = new JLabel("Anmeldestatus");
		GridBagConstraints gbc_lblAnmeldestatus = new GridBagConstraints();
		gbc_lblAnmeldestatus.anchor = GridBagConstraints.WEST;
		gbc_lblAnmeldestatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnmeldestatus.gridx = 13;
		gbc_lblAnmeldestatus.gridy = 0;
		Panel_Hauptmenü.add(lblAnmeldestatus, gbc_lblAnmeldestatus);

		lblBewertung = new JLabel("Bewertung");
		GridBagConstraints gbc_lblBewertung = new GridBagConstraints();
		gbc_lblBewertung.anchor = GridBagConstraints.WEST;
		gbc_lblBewertung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBewertung.gridx = 14;
		gbc_lblBewertung.gridy = 0;
		Panel_Hauptmenü.add(lblBewertung, gbc_lblBewertung);

		scrollPane_ThemaListe = new JScrollPane();
		GridBagConstraints gbc_scrollPane_ThemaListe = new GridBagConstraints();
		gbc_scrollPane_ThemaListe.gridheight = 5;
		gbc_scrollPane_ThemaListe.gridwidth = 5;
		gbc_scrollPane_ThemaListe.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_ThemaListe.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_ThemaListe.gridx = 1;
		gbc_scrollPane_ThemaListe.gridy = 1;
		Panel_Hauptmenü.add(scrollPane_ThemaListe, gbc_scrollPane_ThemaListe);

		label_Student = new JLabel("");
		label_Student.setVerticalAlignment(SwingConstants.TOP);
		scrollPane_ThemaListe.setViewportView(label_Student);
		label_Student.setText(student);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 6;
		gbc_scrollPane.gridy = 1;
		Panel_Hauptmenü.add(scrollPane, gbc_scrollPane);

		label_UundTText = new JLabel("");
		label_UundTText.setVerticalAlignment(SwingConstants.TOP);
		scrollPane.setViewportView(label_UundTText);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 5;
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 8;
		gbc_scrollPane_1.gridy = 1;
		Panel_Hauptmenü.add(scrollPane_1, gbc_scrollPane_1);

		label_BetreuerListe = new JLabel("");
		label_BetreuerListe.setVerticalAlignment(SwingConstants.TOP);
		scrollPane_1.setViewportView(label_BetreuerListe);

		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridheight = 5;
		gbc_scrollPane_2.gridwidth = 2;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 11;
		gbc_scrollPane_2.gridy = 1;
		Panel_Hauptmenü.add(scrollPane_2, gbc_scrollPane_2);

		label_NDAListe = new JLabel("");
		label_NDAListe.setVerticalAlignment(SwingConstants.TOP);
		scrollPane_2.setViewportView(label_NDAListe);

		scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.gridheight = 5;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 13;
		gbc_scrollPane_3.gridy = 1;
		Panel_Hauptmenü.add(scrollPane_3, gbc_scrollPane_3);

		label_SetAnmeldestatus = new JLabel("");
		label_SetAnmeldestatus.setVerticalAlignment(SwingConstants.TOP);
		scrollPane_3.setViewportView(label_SetAnmeldestatus);

		scrollPane_4 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.gridheight = 5;
		gbc_scrollPane_4.gridwidth = 2;
		gbc_scrollPane_4.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.gridx = 14;
		gbc_scrollPane_4.gridy = 1;
		Panel_Hauptmenü.add(scrollPane_4, gbc_scrollPane_4);

		label_SetBewertung = new JLabel("");
		scrollPane_4.setViewportView(label_SetBewertung);
		label_SetBewertung.setVerticalAlignment(SwingConstants.TOP);
		label_SetAnmeldestatus.setText(anmeldungListe);
		label_NDAListe.setText(nda);
		label_BetreuerListe.setText(betreuer);
		label_UundTText.setText(unternehmenUndThema);
		
		//ListeBewertung
		ArrayList<String> bewertungListe = Datenbankzugriff.getBewertung();

		String bewertung = "<html><body>";
		for (String bewertung1 : bewertungListe) {
			bewertung += bewertung1 + " <br>";
		}
		bewertung += "</body></html>";
		label_SetBewertung.setText(bewertung);

		Bewertung = new JPanel();
		tabbedPane.addTab("Bewertung", null, Bewertung, null);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gbl_panel_5.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		Bewertung.setLayout(gbl_panel_5);

		lbl_StudentSuchen = new JLabel("Student suchen:");
		GridBagConstraints gbc_lbl_StudentSuchen = new GridBagConstraints();
		gbc_lbl_StudentSuchen.anchor = GridBagConstraints.WEST;
		gbc_lbl_StudentSuchen.gridwidth = 4;
		gbc_lbl_StudentSuchen.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_StudentSuchen.gridx = 2;
		gbc_lbl_StudentSuchen.gridy = 0;
		Bewertung.add(lbl_StudentSuchen, gbc_lbl_StudentSuchen);

		lblMatrikelnummer = new JLabel("Matrikelnummer");
		GridBagConstraints gbc_lblMatrikelnummer = new GridBagConstraints();
		gbc_lblMatrikelnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatrikelnummer.gridx = 2;
		gbc_lblMatrikelnummer.gridy = 1;
		Bewertung.add(lblMatrikelnummer, gbc_lblMatrikelnummer);

		textField_Matrikelnummer = new JTextField();
		GridBagConstraints gbc_textField_Matrikelnummer = new GridBagConstraints();
		gbc_textField_Matrikelnummer.gridwidth = 5;
		gbc_textField_Matrikelnummer.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Matrikelnummer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Matrikelnummer.gridx = 4;
		gbc_textField_Matrikelnummer.gridy = 1;
		Bewertung.add(textField_Matrikelnummer, gbc_textField_Matrikelnummer);
		textField_Matrikelnummer.setColumns(10);

		btn_SuchenVerwalten = new JButton("Suchen und Verwalten");
		btn_SuchenVerwalten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int matrikelnummer = Integer.parseInt(textField_Matrikelnummer.getText());

					studentThema = Datenbankzugriff.sucheStudentFürStudiendekan(matrikelnummer);
					lblSetName.setText(studentThema.getStudentVorname() + " " + studentThema.getStudentName());
					lblseUnternehmen.setText(studentThema.getUnternehmen());
					lblsetThema.setText(studentThema.getThema());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Sie haben keine gültige Matrikelnummer eingegeben!");
				}

			}
		});
		GridBagConstraints gbc_btn_SuchenVerwalten = new GridBagConstraints();
		gbc_btn_SuchenVerwalten.insets = new Insets(0, 0, 5, 5);
		gbc_btn_SuchenVerwalten.gridx = 10;
		gbc_btn_SuchenVerwalten.gridy = 1;
		Bewertung.add(btn_SuchenVerwalten, gbc_btn_SuchenVerwalten);

		lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridwidth = 2;
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 2;
		gbc_lblName.gridy = 3;
		Bewertung.add(lblName, gbc_lblName);

		lblSetName = new JLabel("<Name>");
		GridBagConstraints gbc_lblSetName = new GridBagConstraints();
		gbc_lblSetName.anchor = GridBagConstraints.WEST;
		gbc_lblSetName.gridwidth = 6;
		gbc_lblSetName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSetName.gridx = 4;
		gbc_lblSetName.gridy = 3;
		Bewertung.add(lblSetName, gbc_lblSetName);

		lblUnternehmen = new JLabel("Unternehmen");
		GridBagConstraints gbc_lblUnternehmen = new GridBagConstraints();
		gbc_lblUnternehmen.anchor = GridBagConstraints.WEST;
		gbc_lblUnternehmen.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnternehmen.gridx = 2;
		gbc_lblUnternehmen.gridy = 4;
		Bewertung.add(lblUnternehmen, gbc_lblUnternehmen);

		lblseUnternehmen = new JLabel("<Unternehmen>");
		GridBagConstraints gbc_lblseUnternehmen = new GridBagConstraints();
		gbc_lblseUnternehmen.anchor = GridBagConstraints.WEST;
		gbc_lblseUnternehmen.gridwidth = 6;
		gbc_lblseUnternehmen.insets = new Insets(0, 0, 5, 5);
		gbc_lblseUnternehmen.gridx = 4;
		gbc_lblseUnternehmen.gridy = 4;
		Bewertung.add(lblseUnternehmen, gbc_lblseUnternehmen);

		lblThema = new JLabel("Thema");
		GridBagConstraints gbc_lblThema = new GridBagConstraints();
		gbc_lblThema.anchor = GridBagConstraints.WEST;
		gbc_lblThema.insets = new Insets(0, 0, 5, 5);
		gbc_lblThema.gridx = 2;
		gbc_lblThema.gridy = 5;
		Bewertung.add(lblThema, gbc_lblThema);

		lblsetThema = new JLabel("<Thema>");
		GridBagConstraints gbc_lblsetThema = new GridBagConstraints();
		gbc_lblsetThema.anchor = GridBagConstraints.WEST;
		gbc_lblsetThema.gridwidth = 6;
		gbc_lblsetThema.insets = new Insets(0, 0, 5, 5);
		gbc_lblsetThema.gridx = 4;
		gbc_lblsetThema.gridy = 5;
		Bewertung.add(lblsetThema, gbc_lblsetThema);

		lblNoteSeminar = new JLabel("Note Bachelorseminar");
		GridBagConstraints gbc_lblNoteSeminar = new GridBagConstraints();
		gbc_lblNoteSeminar.anchor = GridBagConstraints.WEST;
		gbc_lblNoteSeminar.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoteSeminar.gridx = 2;
		gbc_lblNoteSeminar.gridy = 7;
		Bewertung.add(lblNoteSeminar, gbc_lblNoteSeminar);

		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 7;
		Bewertung.add(comboBox, gbc_comboBox);
		comboBox.addItem("1.0");
		comboBox.addItem("1.3");
		comboBox.addItem("1.7");
		comboBox.addItem("2.0");
		comboBox.addItem("2.3");
		comboBox.addItem("2.7");
		comboBox.addItem("3.0");
		comboBox.addItem("3.3");
		comboBox.addItem("3.7");
		comboBox.addItem("4.0");

		btnBewerten = new JButton("Bewerten");
		btnBewerten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (studentThema==null) {
					JOptionPane.showMessageDialog(null, "Sie müssen zuerst einen Student verwalten!");
					return;
				}
				
				if(Datenbankzugriff.prüfeObNoteAusarbeitungVorhanden(studentThema.getMatrikelnummer()) == true) {

				Double note = Double.parseDouble((String) comboBox.getSelectedItem());
				Datenbankzugriff.setNoteStudiendekan(studentThema.getMatrikelnummer(), note);
				Datenbankzugriff.berechnenGesamtnote(studentThema.getMatrikelnummer());
				
				}else {
					JOptionPane.showMessageDialog(null, "Der HfT-Betreuer muss zuerst die Note \n für die Ausarbeitung eintragen!");
				}
				
				//ListeBewertungAktualisieren
				ArrayList<String> bewertungListe = Datenbankzugriff.getBewertung();

				String bewertung = "<html><body>";
				for (String bewertung1 : bewertungListe) {
					bewertung += bewertung1 + " <br>";
				}
				bewertung += "</body></html>";
				label_SetBewertung.setText(bewertung);
			}
		});
		GridBagConstraints gbc_btnBewerten = new GridBagConstraints();
		gbc_btnBewerten.insets = new Insets(0, 0, 0, 5);
		gbc_btnBewerten.gridx = 23;
		gbc_btnBewerten.gridy = 10;
		Bewertung.add(btnBewerten, gbc_btnBewerten);
	}

}
