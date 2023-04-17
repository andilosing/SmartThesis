package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datenbank.Datenbankzugriff;
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
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HauptmenüStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField_AngemeldetAls;
	private JTabbedPane tabbedPane;
	private JPanel panel_Home;
	private JPanel Panel_ThemaEintragen;
	private JPanel panel_Anmeldeformular;
	private JPanel panel_Abgaben;
	private JButton btnLogout;
	private static Student student;
	private JLabel lblThemaEintragen;
	private JButton btnEintragen;
	private JLabel lblUnternehmen;
	private JLabel lblThema;
	private JTextField textField_Unternehmen;
	private JScrollPane scrollPane_Thema;
	private JTextArea textArea_Thema;
	private JLabel lblKontaktdaten;
	private JLabel lblNdaStatus;
	private JLabel label_NDAStautusText;
	private JLabel label_Information;
	private JButton btnAnmelden;
	private JLabel lblAnmeldeformular;
	private JScrollPane scrollPane;
	private JLabel lblName;
	private JLabel lblMatrikelnummer;
	private JLabel lblEmail;
	private JLabel lblInformation;
	private JLabel label_SetName;
	private JLabel label_SetMatNr;
	private JLabel labell_SetEmail;
	private JLabel lblThema_1;
	private JScrollPane scrollPane_1;
	private JLabel label_SetThema;
	private JLabel lblAnmeldeformular_1;
	private JLabel lblNichtAngemeldet;
	private JButton btnAbgeben;
	private JRadioButton rdbtn_Zwischenversion;
	private JRadioButton rdbtnEndversion;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNoten;
	private JLabel label_SetNoten;
	private JLabel lblAbgabenstatus;
	private JLabel label_SetAbgabenStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student = new Student(1001268, "Rafael", "Kassotakis", "01kara1bwi@hft-stuttgart.de", "rafael",
							"Student");
					HauptmenüStudent frame = new HauptmenüStudent(student);
					// frame.setSize(850, 450);
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
	public HauptmenüStudent(Student student) {
		this.student = student;
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

		// Überall sichtbar:
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
		label_AngemeldetAlsName.setText(student.getName() + " " + student.getNachname());
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

		// Startseite:

		panel_Home = new JPanel();
		tabbedPane.addTab("Startseite", null, panel_Home, null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_Home.setLayout(gridBagLayout);

		lblNdaStatus = new JLabel("NDA Status:");
		GridBagConstraints gbc_lblNdaStatus = new GridBagConstraints();
		gbc_lblNdaStatus.gridwidth = 3;
		gbc_lblNdaStatus.anchor = GridBagConstraints.WEST;
		gbc_lblNdaStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblNdaStatus.gridx = 1;
		gbc_lblNdaStatus.gridy = 1;
		panel_Home.add(lblNdaStatus, gbc_lblNdaStatus);

		label_NDAStautusText = new JLabel("k.A.");
		label_NDAStautusText.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_label_NDAStautusText = new GridBagConstraints();
		gbc_label_NDAStautusText.anchor = GridBagConstraints.WEST;
		gbc_label_NDAStautusText.gridwidth = 4;
		gbc_label_NDAStautusText.insets = new Insets(0, 0, 5, 5);
		gbc_label_NDAStautusText.gridx = 4;
		gbc_label_NDAStautusText.gridy = 1;
		panel_Home.add(label_NDAStautusText, gbc_label_NDAStautusText);

		label_NDAStautusText.setText(Datenbankzugriff.ndaStatus(student));

		lblAnmeldeformular_1 = new JLabel("Anmeldeformular:");
		GridBagConstraints gbc_lblAnmeldeformular_1 = new GridBagConstraints();
		gbc_lblAnmeldeformular_1.anchor = GridBagConstraints.WEST;
		gbc_lblAnmeldeformular_1.gridwidth = 3;
		gbc_lblAnmeldeformular_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnmeldeformular_1.gridx = 1;
		gbc_lblAnmeldeformular_1.gridy = 4;
		panel_Home.add(lblAnmeldeformular_1, gbc_lblAnmeldeformular_1);

		lblNichtAngemeldet = new JLabel("nicht Angemeldet");
		lblNichtAngemeldet.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblNichtAngemeldet = new GridBagConstraints();
		gbc_lblNichtAngemeldet.anchor = GridBagConstraints.WEST;
		gbc_lblNichtAngemeldet.gridwidth = 5;
		gbc_lblNichtAngemeldet.insets = new Insets(0, 0, 5, 5);
		gbc_lblNichtAngemeldet.gridx = 4;
		gbc_lblNichtAngemeldet.gridy = 4;
		panel_Home.add(lblNichtAngemeldet, gbc_lblNichtAngemeldet);

		lblNichtAngemeldet.setText(Datenbankzugriff.getAnmeldestatus(student));
		
		lblAbgabenstatus = new JLabel("Abgabenstatus:");
		GridBagConstraints gbc_lblAbgabenstatus = new GridBagConstraints();
		gbc_lblAbgabenstatus.anchor = GridBagConstraints.WEST;
		gbc_lblAbgabenstatus.gridwidth = 3;
		gbc_lblAbgabenstatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblAbgabenstatus.gridx = 1;
		gbc_lblAbgabenstatus.gridy = 6;
		panel_Home.add(lblAbgabenstatus, gbc_lblAbgabenstatus);
		
		label_SetAbgabenStatus = new JLabel("k.A.");
		GridBagConstraints gbc_label_SetAbgabenStatus = new GridBagConstraints();
		gbc_label_SetAbgabenStatus.anchor = GridBagConstraints.WEST;
		gbc_label_SetAbgabenStatus.gridwidth = 13;
		gbc_label_SetAbgabenStatus.insets = new Insets(0, 0, 5, 5);
		gbc_label_SetAbgabenStatus.gridx = 4;
		gbc_label_SetAbgabenStatus.gridy = 6;
		panel_Home.add(label_SetAbgabenStatus, gbc_label_SetAbgabenStatus);
		
		label_SetAbgabenStatus.setText(Datenbankzugriff.setAbgabenStatus(student.getMatrikelnummer()));

		lblNoten = new JLabel("Noten:");
		GridBagConstraints gbc_lblNoten = new GridBagConstraints();
		gbc_lblNoten.anchor = GridBagConstraints.WEST;
		gbc_lblNoten.gridwidth = 3;
		gbc_lblNoten.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoten.gridx = 1;
		gbc_lblNoten.gridy = 7;
		panel_Home.add(lblNoten, gbc_lblNoten);

		label_SetNoten = new JLabel("<Noten>");
		GridBagConstraints gbc_label_SetNoten = new GridBagConstraints();
		gbc_label_SetNoten.anchor = GridBagConstraints.WEST;
		gbc_label_SetNoten.gridwidth = 10;
		gbc_label_SetNoten.insets = new Insets(0, 0, 5, 5);
		gbc_label_SetNoten.gridx = 4;
		gbc_label_SetNoten.gridy = 7;
		panel_Home.add(label_SetNoten, gbc_label_SetNoten);

		label_SetNoten.setText(Datenbankzugriff.getNotenStudent(student.getMatrikelnummer()));

		lblKontaktdaten = new JLabel("");
		lblKontaktdaten.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblKontaktdaten = new GridBagConstraints();
		gbc_lblKontaktdaten.anchor = GridBagConstraints.WEST;
		gbc_lblKontaktdaten.insets = new Insets(0, 0, 0, 5);
		gbc_lblKontaktdaten.gridheight = 3;
		gbc_lblKontaktdaten.gridwidth = 6;
		gbc_lblKontaktdaten.gridx = 1;
		gbc_lblKontaktdaten.gridy = 9;
		panel_Home.add(lblKontaktdaten, gbc_lblKontaktdaten);

		lblKontaktdaten
				.setText("<html><body>" + "Kontaktdaten: " + "<br>" + Datenbankzugriff.kontaktdatenStudent(student));

		// Thema eintragen:

		Panel_ThemaEintragen = new JPanel();
		tabbedPane.addTab("Thema eintragen", null, Panel_ThemaEintragen, null);
		GridBagLayout gbl_Panel_ThemaEintragen = new GridBagLayout();
		gbl_Panel_ThemaEintragen.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_Panel_ThemaEintragen.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_Panel_ThemaEintragen.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_Panel_ThemaEintragen.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		Panel_ThemaEintragen.setLayout(gbl_Panel_ThemaEintragen);

		lblThemaEintragen = new JLabel("Thema eintragen");
		lblThemaEintragen.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblThemaEintragen = new GridBagConstraints();
		gbc_lblThemaEintragen.gridwidth = 7;
		gbc_lblThemaEintragen.insets = new Insets(0, 0, 5, 5);
		gbc_lblThemaEintragen.gridx = 1;
		gbc_lblThemaEintragen.gridy = 1;
		Panel_ThemaEintragen.add(lblThemaEintragen, gbc_lblThemaEintragen);

		lblUnternehmen = new JLabel("Unternehmen");
		GridBagConstraints gbc_lblUnternehmen = new GridBagConstraints();
		gbc_lblUnternehmen.anchor = GridBagConstraints.WEST;
		gbc_lblUnternehmen.gridwidth = 2;
		gbc_lblUnternehmen.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnternehmen.gridx = 1;
		gbc_lblUnternehmen.gridy = 2;
		Panel_ThemaEintragen.add(lblUnternehmen, gbc_lblUnternehmen);

		textField_Unternehmen = new JTextField();
		GridBagConstraints gbc_textField_Unternehmen = new GridBagConstraints();
		gbc_textField_Unternehmen.gridwidth = 12;
		gbc_textField_Unternehmen.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Unternehmen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Unternehmen.gridx = 4;
		gbc_textField_Unternehmen.gridy = 2;
		Panel_ThemaEintragen.add(textField_Unternehmen, gbc_textField_Unternehmen);
		textField_Unternehmen.setColumns(10);

		lblThema = new JLabel("Thema");
		GridBagConstraints gbc_lblThema = new GridBagConstraints();
		gbc_lblThema.anchor = GridBagConstraints.WEST;
		gbc_lblThema.insets = new Insets(0, 0, 5, 5);
		gbc_lblThema.gridx = 1;
		gbc_lblThema.gridy = 3;
		Panel_ThemaEintragen.add(lblThema, gbc_lblThema);

		scrollPane_Thema = new JScrollPane();
		GridBagConstraints gbc_scrollPane_Thema = new GridBagConstraints();
		gbc_scrollPane_Thema.gridheight = 3;
		gbc_scrollPane_Thema.gridwidth = 12;
		gbc_scrollPane_Thema.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_Thema.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_Thema.gridx = 4;
		gbc_scrollPane_Thema.gridy = 3;
		Panel_ThemaEintragen.add(scrollPane_Thema, gbc_scrollPane_Thema);

		textArea_Thema = new JTextArea();
		scrollPane_Thema.setViewportView(textArea_Thema);

		// Thema Eintragen Knopf:
		btnEintragen = new JButton("eintragen");
		btnEintragen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thema thema = new Thema(student.getMatrikelnummer(), student.getNachname(), student.getName(),
						textField_Unternehmen.getText(), textArea_Thema.getText(), 0, "", "", "");
				Datenbankzugriff.themaEintragen(thema);
				label_SetThema.setText(Datenbankzugriff.getThema(student));
			}
		});
		GridBagConstraints gbc_btnEintragen = new GridBagConstraints();
		gbc_btnEintragen.gridx = 19;
		gbc_btnEintragen.gridy = 7;
		Panel_ThemaEintragen.add(btnEintragen, gbc_btnEintragen);

		// Anmeldeformular
		panel_Anmeldeformular = new JPanel();
		tabbedPane.addTab("Anmeldeformular", null, panel_Anmeldeformular, null);
		GridBagLayout gbl_panel_Anmeldeformular = new GridBagLayout();
		gbl_panel_Anmeldeformular.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0 };
		gbl_panel_Anmeldeformular.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_Anmeldeformular.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Anmeldeformular.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel_Anmeldeformular.setLayout(gbl_panel_Anmeldeformular);

		lblAnmeldeformular = new JLabel("Anmeldeformular");
		GridBagConstraints gbc_lblAnmeldeformular = new GridBagConstraints();
		gbc_lblAnmeldeformular.anchor = GridBagConstraints.WEST;
		gbc_lblAnmeldeformular.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnmeldeformular.gridx = 1;
		gbc_lblAnmeldeformular.gridy = 0;
		panel_Anmeldeformular.add(lblAnmeldeformular, gbc_lblAnmeldeformular);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.gridwidth = 21;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		panel_Anmeldeformular.add(scrollPane, gbc_scrollPane);

		lblInformation = new JLabel("");
		scrollPane.setViewportView(lblInformation);
		lblInformation.setVerticalAlignment(SwingConstants.TOP);

		lblInformation.setText("<html><body>"
				+ "Ich melde mich hiermit zur Bachelor-Arbeit an und erkläre mich mit den folgenden Bedingungen"
				+ "<br>" + "einverstanden:" + "<br>"
				+ "1. Der erlaubte Zeitraum für die Bearbeitung beträgt drei Monate." + "<br>"
				+ "  Der Vorsitzende des Prüfungsausschusses legt den Ausgabetermin und den Abgabetermin fest." + "<br>"
				+ "2. Die Bachelor-Arbeit muss mit meinen eigenen Worten ohne die Hilfe Dritter angefertigt werden."
				+ "<br>" + "3. Ich bin verpflichtet, alle verwendeten relevanten Hilfen und Quellen anzugeben." + "<br>"
				+ "4. Ich muss meine Bachelor-Arbeit in einem Abschlussvortrag präsentieren." + "<br>"
				+ "5. Die Bachelor-Arbeit muss zu dem oben genannten Abgabetermin beim Vorsitzenden des" + "<br>"
				+ "6. Prüfungsausschusses eingereicht werden." + "<br>"
				+ "7. Es müssen drei Fassungen der Bachelor-Arbeit in gebundener Papierform (keine Spiralbindung) und eine"
				+ "<br>" + "  Kurzfassung in elektronischer Form und Papierform abgegeben werden." + "<br>"
				+ "8. Ich bin damit einverstanden, dass die HFT Stuttgart die Ergebnisse dieser Bachelor-Arbeit unentgeltlich"
				+ "<br" + "benutzen und in Forschung und Lehre weiterentwickeln darf." + "</body></html>");

		lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 6;
		panel_Anmeldeformular.add(lblName, gbc_lblName);

		label_SetName = new JLabel("<Name>");
		GridBagConstraints gbc_label_SetName = new GridBagConstraints();
		gbc_label_SetName.anchor = GridBagConstraints.WEST;
		gbc_label_SetName.gridwidth = 5;
		gbc_label_SetName.insets = new Insets(0, 0, 5, 5);
		gbc_label_SetName.gridx = 2;
		gbc_label_SetName.gridy = 6;
		panel_Anmeldeformular.add(label_SetName, gbc_label_SetName);
		label_SetName.setText(student.getNachname() + " " + student.getName());

		lblMatrikelnummer = new JLabel("Matrikelnummer");
		GridBagConstraints gbc_lblMatrikelnummer = new GridBagConstraints();
		gbc_lblMatrikelnummer.anchor = GridBagConstraints.WEST;
		gbc_lblMatrikelnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatrikelnummer.gridx = 1;
		gbc_lblMatrikelnummer.gridy = 7;
		panel_Anmeldeformular.add(lblMatrikelnummer, gbc_lblMatrikelnummer);

		label_SetMatNr = new JLabel("<Matrikelnummer>");
		GridBagConstraints gbc_label_SetMatNr = new GridBagConstraints();
		gbc_label_SetMatNr.anchor = GridBagConstraints.WEST;
		gbc_label_SetMatNr.gridwidth = 5;
		gbc_label_SetMatNr.insets = new Insets(0, 0, 5, 5);
		gbc_label_SetMatNr.gridx = 2;
		gbc_label_SetMatNr.gridy = 7;
		panel_Anmeldeformular.add(label_SetMatNr, gbc_label_SetMatNr);
		label_SetMatNr.setText(Integer.toString(student.getMatrikelnummer()));

		lblEmail = new JLabel("E-Mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 8;
		panel_Anmeldeformular.add(lblEmail, gbc_lblEmail);

		labell_SetEmail = new JLabel("<E-Mail>");
		GridBagConstraints gbc_labell_SetEmail = new GridBagConstraints();
		gbc_labell_SetEmail.anchor = GridBagConstraints.WEST;
		gbc_labell_SetEmail.gridwidth = 5;
		gbc_labell_SetEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labell_SetEmail.gridx = 2;
		gbc_labell_SetEmail.gridy = 8;
		panel_Anmeldeformular.add(labell_SetEmail, gbc_labell_SetEmail);
		labell_SetEmail.setText(student.getEmail());

		btnAnmelden = new JButton("Anmelden");
		btnAnmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Datenbankzugriff.prüfeObThemaVorhanden(student.getMatrikelnummer())) {
					Datenbankzugriff.meldeStudentAn(student);
					lblNichtAngemeldet.setText(Datenbankzugriff.getAnmeldestatus(student));
					
				}else {
				JOptionPane.showMessageDialog(null, "Sie haben kein Thema eingetragen!");}
			}
		});

		lblThema_1 = new JLabel("Thema");
		GridBagConstraints gbc_lblThema_1 = new GridBagConstraints();
		gbc_lblThema_1.anchor = GridBagConstraints.WEST;
		gbc_lblThema_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblThema_1.gridx = 1;
		gbc_lblThema_1.gridy = 9;
		panel_Anmeldeformular.add(lblThema_1, gbc_lblThema_1);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 19;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 9;
		panel_Anmeldeformular.add(scrollPane_1, gbc_scrollPane_1);

		label_SetThema = new JLabel("<Thema>");
		label_SetThema.setVerticalAlignment(SwingConstants.TOP);
		scrollPane_1.setViewportView(label_SetThema);
		GridBagConstraints gbc_btnAnmelden = new GridBagConstraints();
		gbc_btnAnmelden.gridx = 22;
		gbc_btnAnmelden.gridy = 9;
		panel_Anmeldeformular.add(btnAnmelden, gbc_btnAnmelden);
		label_SetThema.setText(Datenbankzugriff.getThema(student));

		panel_Abgaben = new JPanel();
		tabbedPane.addTab("Abgaben", null, panel_Abgaben, null);
		GridBagLayout gbl_panel_Abgaben = new GridBagLayout();
		gbl_panel_Abgaben.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_panel_Abgaben.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_Abgaben.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Abgaben.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_Abgaben.setLayout(gbl_panel_Abgaben);

		rdbtn_Zwischenversion = new JRadioButton(
				"Die Zwischenversion der schriftlichen Ausarbeitung wurde per E-Mail versendet");
		buttonGroup.add(rdbtn_Zwischenversion);
		GridBagConstraints gbc_rdbtn_Zwischenversion = new GridBagConstraints();
		gbc_rdbtn_Zwischenversion.anchor = GridBagConstraints.WEST;
		gbc_rdbtn_Zwischenversion.gridwidth = 14;
		gbc_rdbtn_Zwischenversion.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn_Zwischenversion.gridx = 1;
		gbc_rdbtn_Zwischenversion.gridy = 1;
		panel_Abgaben.add(rdbtn_Zwischenversion, gbc_rdbtn_Zwischenversion);

		rdbtnEndversion = new JRadioButton("Die Endversion der schriftlichen Ausarbeitung wurde per E-Mail versendet");
		buttonGroup.add(rdbtnEndversion);
		GridBagConstraints gbc_rdbtnEndversion = new GridBagConstraints();
		gbc_rdbtnEndversion.anchor = GridBagConstraints.WEST;
		gbc_rdbtnEndversion.gridwidth = 19;
		gbc_rdbtnEndversion.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEndversion.gridx = 1;
		gbc_rdbtnEndversion.gridy = 2;
		panel_Abgaben.add(rdbtnEndversion, gbc_rdbtnEndversion);

		btnAbgeben = new JButton("Best\u00E4tigen");
		btnAbgeben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Datenbankzugriff.prüfeObSchonAngemeldet(student.getMatrikelnummer()) == true) {
					if (rdbtn_Zwischenversion.isSelected()) {
						Datenbankzugriff.abgebenZwischenversion(student);
						return;
					}

					if (rdbtnEndversion.isSelected()) {
						Datenbankzugriff.abgebenEndversion(student);

						return;
					}
					JOptionPane.showMessageDialog(null, "Sie müssen eine Version zur Abgabe auswählen!");
				} else {
					JOptionPane.showMessageDialog(null, "Der HfTBetreuer muss die Anmeldung bestätigt haben!");
				}
				
			
			}
		});
		GridBagConstraints gbc_btnAbgeben = new GridBagConstraints();
		gbc_btnAbgeben.gridx = 21;
		gbc_btnAbgeben.gridy = 9;
		panel_Abgaben.add(btnAbgeben, gbc_btnAbgeben);
	}

}
