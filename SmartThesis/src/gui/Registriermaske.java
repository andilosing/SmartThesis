package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import datenbank.Datenbankzugriff;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

public class Registriermaske extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_Vorname;
	private JTextField textField_Email;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField_Passwort;
	private JPasswordField passwordField_PasswortWDH;
	private static Registriermaske registriermaske;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registriermaske = new Registriermaske();
					registriermaske.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registriermaske() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblRegistrieren = new JLabel("Registrieren");
		GridBagConstraints gbc_lblRegistrieren = new GridBagConstraints();
		gbc_lblRegistrieren.gridwidth = 2;
		gbc_lblRegistrieren.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistrieren.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRegistrieren.gridx = 1;
		gbc_lblRegistrieren.gridy = 0;
		contentPane.add(lblRegistrieren, gbc_lblRegistrieren);

		JLabel label_Name = new JLabel("Name");
		GridBagConstraints gbc_label_Name = new GridBagConstraints();
		gbc_label_Name.gridwidth = 3;
		gbc_label_Name.anchor = GridBagConstraints.WEST;
		gbc_label_Name.insets = new Insets(0, 0, 5, 5);
		gbc_label_Name.gridx = 0;
		gbc_label_Name.gridy = 1;
		contentPane.add(label_Name, gbc_label_Name);

		textField_Name = new JTextField();
		GridBagConstraints gbc_textField_Name = new GridBagConstraints();
		gbc_textField_Name.gridwidth = 12;
		gbc_textField_Name.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Name.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Name.gridx = 4;
		gbc_textField_Name.gridy = 1;
		contentPane.add(textField_Name, gbc_textField_Name);
		textField_Name.setColumns(10);

		JLabel lblVorname = new JLabel("Vorname");
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.gridwidth = 3;
		gbc_lblVorname.anchor = GridBagConstraints.WEST;
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.gridx = 0;
		gbc_lblVorname.gridy = 2;
		contentPane.add(lblVorname, gbc_lblVorname);

		textField_Vorname = new JTextField();
		textField_Vorname.setColumns(10);
		GridBagConstraints gbc_textField_Vorname = new GridBagConstraints();
		gbc_textField_Vorname.gridwidth = 12;
		gbc_textField_Vorname.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Vorname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Vorname.gridx = 4;
		gbc_textField_Vorname.gridy = 2;
		contentPane.add(textField_Vorname, gbc_textField_Vorname);

		JLabel label_Nummer = new JLabel("(Matrikel)Nummer");
		GridBagConstraints gbc_label_Nummer = new GridBagConstraints();
		gbc_label_Nummer.anchor = GridBagConstraints.WEST;
		gbc_label_Nummer.gridwidth = 3;
		gbc_label_Nummer.insets = new Insets(0, 0, 5, 5);
		gbc_label_Nummer.gridx = 0;
		gbc_label_Nummer.gridy = 3;
		contentPane.add(label_Nummer, gbc_label_Nummer);

		JFormattedTextField formattedTextField_Nummer = new JFormattedTextField();
		GridBagConstraints gbc_formattedTextField_Nummer = new GridBagConstraints();
		gbc_formattedTextField_Nummer.gridwidth = 12;
		gbc_formattedTextField_Nummer.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_Nummer.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_Nummer.gridx = 4;
		gbc_formattedTextField_Nummer.gridy = 3;
		contentPane.add(formattedTextField_Nummer, gbc_formattedTextField_Nummer);

		JLabel lblEmail = new JLabel("E-Mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.gridwidth = 3;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		contentPane.add(lblEmail, gbc_lblEmail);

		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		GridBagConstraints gbc_textField_Email = new GridBagConstraints();
		gbc_textField_Email.gridwidth = 12;
		gbc_textField_Email.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Email.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Email.gridx = 4;
		gbc_textField_Email.gridy = 4;
		contentPane.add(textField_Email, gbc_textField_Email);

		JLabel label_Passwort = new JLabel("Passwort");
		GridBagConstraints gbc_label_Passwort = new GridBagConstraints();
		gbc_label_Passwort.anchor = GridBagConstraints.WEST;
		gbc_label_Passwort.gridwidth = 3;
		gbc_label_Passwort.insets = new Insets(0, 0, 5, 5);
		gbc_label_Passwort.gridx = 0;
		gbc_label_Passwort.gridy = 5;
		contentPane.add(label_Passwort, gbc_label_Passwort);

		passwordField_Passwort = new JPasswordField();
		GridBagConstraints gbc_passwordField_Passwort = new GridBagConstraints();
		gbc_passwordField_Passwort.gridwidth = 12;
		gbc_passwordField_Passwort.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_Passwort.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_Passwort.gridx = 4;
		gbc_passwordField_Passwort.gridy = 5;
		contentPane.add(passwordField_Passwort, gbc_passwordField_Passwort);

		JLabel lblPasswortWiedrholen = new JLabel("Passwort wiederholen");
		GridBagConstraints gbc_lblPasswortWiedrholen = new GridBagConstraints();
		gbc_lblPasswortWiedrholen.anchor = GridBagConstraints.WEST;
		gbc_lblPasswortWiedrholen.gridwidth = 2;
		gbc_lblPasswortWiedrholen.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswortWiedrholen.gridx = 0;
		gbc_lblPasswortWiedrholen.gridy = 6;
		contentPane.add(lblPasswortWiedrholen, gbc_lblPasswortWiedrholen);

		passwordField_PasswortWDH = new JPasswordField();
		GridBagConstraints gbc_passwordField_PasswortWDH = new GridBagConstraints();
		gbc_passwordField_PasswortWDH.gridwidth = 12;
		gbc_passwordField_PasswortWDH.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_PasswortWDH.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_PasswortWDH.gridx = 4;
		gbc_passwordField_PasswortWDH.gridy = 6;
		contentPane.add(passwordField_PasswortWDH, gbc_passwordField_PasswortWDH);

		JRadioButton radioButton_Student = new JRadioButton("Student");
		buttonGroup.add(radioButton_Student);
		GridBagConstraints gbc_radioButton_Student = new GridBagConstraints();
		gbc_radioButton_Student.anchor = GridBagConstraints.WEST;
		gbc_radioButton_Student.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_Student.gridx = 1;
		gbc_radioButton_Student.gridy = 7;
		contentPane.add(radioButton_Student, gbc_radioButton_Student);
		GridBagConstraints gbc_btnRegistrieren = new GridBagConstraints();
		gbc_btnRegistrieren.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegistrieren.gridx = 14;
		gbc_btnRegistrieren.gridy = 7;
		contentPane.add(radioButton_Student, gbc_radioButton_Student);

		JRadioButton radioButton_Hftbetreuer = new JRadioButton("HfT-Betreuer");
		buttonGroup.add(radioButton_Hftbetreuer);
		GridBagConstraints gbc_radioButton_Hftbetreuer = new GridBagConstraints();
		gbc_radioButton_Hftbetreuer.anchor = GridBagConstraints.WEST;
		gbc_radioButton_Hftbetreuer.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_Hftbetreuer.gridx = 1;
		gbc_radioButton_Hftbetreuer.gridy = 8;
		contentPane.add(radioButton_Hftbetreuer, gbc_radioButton_Hftbetreuer);

		JRadioButton radioButton_Studiendekan = new JRadioButton("Studiendekan");
		buttonGroup.add(radioButton_Studiendekan);
		GridBagConstraints gbc_radioButton_Studiendekan = new GridBagConstraints();
		gbc_radioButton_Studiendekan.anchor = GridBagConstraints.WEST;
		gbc_radioButton_Studiendekan.insets = new Insets(0, 0, 0, 5);
		gbc_radioButton_Studiendekan.gridx = 1;
		gbc_radioButton_Studiendekan.gridy = 9;
		contentPane.add(radioButton_Studiendekan, gbc_radioButton_Studiendekan);

		JButton btnRegistrieren_1 = new JButton("registrieren");
		btnRegistrieren_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String fehleranzeige = "";
				boolean allesRichtig = true;
				if (textField_Name.getText().length() == 0) {
					fehleranzeige += "Name muss ausgefüllt werden";
					allesRichtig = false;
				}
				if (textField_Vorname.getText().length() == 0) {
					fehleranzeige += "\nVorname muss ausgefüllt werden!";
					allesRichtig = false;
				}
				if (formattedTextField_Nummer.getText().length() == 0) {
					fehleranzeige += "\nNummer muss ausgefüllt werden";
					allesRichtig = false;
				}
				if (textField_Email.getText().length() == 0) {
					fehleranzeige += "\nEmail muss ausgefüllt werden";
					allesRichtig = false;
				}
				if (passwordField_Passwort.getText().length() == 0) {
					fehleranzeige += "\nPasswort muss ausgefüllt werden";
					allesRichtig = false;
				}
				if (passwordField_PasswortWDH.getText().length() == 0) {
					fehleranzeige += "\nPassswort wiederholen muss ausgefüllt werden";
					allesRichtig = false;
				}
				if ((radioButton_Hftbetreuer.isSelected() == false) && (radioButton_Student.isSelected() == false)
						&& (radioButton_Studiendekan.isSelected() == false)) {
					fehleranzeige += "\nBenutzertyp muss ausgewählt werden";
					allesRichtig = false;
				}
				if (allesRichtig == false) {
					JOptionPane.showMessageDialog(null, fehleranzeige);
					return;
				}

				if (radioButton_Student.isSelected()) {
					try {
						
						int nummer = Integer.parseInt(formattedTextField_Nummer.getText());
						if (passwordField_Passwort.getText().equals(passwordField_PasswortWDH.getText()) == false) {
							JOptionPane.showMessageDialog(null, "Passwort war nicht gleich");
							return;
						}
						Datenbankzugriff.registrierenStudent(nummer,  textField_Name.getText(), textField_Vorname.getText(),
								textField_Email.getText(), passwordField_Passwort.getText(), "Student"
								);
						Anmeldemaske anmeldenStudent = new Anmeldemaske();
						dispose();
						anmeldenStudent.setVisible(true);
					} catch (NumberFormatException w) {
						JOptionPane.showMessageDialog(null, "Keine Zahl bei Matrikelnummer eingegeben!");
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				}
				if (radioButton_Hftbetreuer.isSelected()) {
					try {
						
						int nummer = Integer.parseInt(formattedTextField_Nummer.getText());
						if (passwordField_Passwort.getText().equals(passwordField_PasswortWDH.getText()) == false) {
							JOptionPane.showMessageDialog(null, "Passwort war nicht gleich");
							return;
						}
						Datenbankzugriff.registrierenHfTBetreuer(nummer, textField_Name.getText(),
								textField_Vorname.getText(), textField_Email.getText(),
								passwordField_Passwort.getText(), "HfTBetreuer");
						Anmeldemaske anmeldenHfTBetreuer = new Anmeldemaske();
						dispose();
						anmeldenHfTBetreuer.setVisible(true);

					} catch (NumberFormatException w) {
						JOptionPane.showMessageDialog(null, "Keine Zahl bei Matrikelnummer eingegeben!");
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				}
				if (radioButton_Studiendekan.isSelected()) {
					try {
						int nummer = Integer.parseInt(formattedTextField_Nummer.getText());
						if (passwordField_Passwort.getText().equals(passwordField_PasswortWDH.getText()) == false) {
							JOptionPane.showMessageDialog(null, "Passwort war nicht gleich");
							return;
						}

						Datenbankzugriff.registrierenStudiendekan(nummer, textField_Name.getText(),
								textField_Vorname.getText(), textField_Email.getText(),
								passwordField_Passwort.getText(), "Studiendekan");
						Anmeldemaske anmeldenStudiendekan = new Anmeldemaske();
						dispose();
						anmeldenStudiendekan.setVisible(true);
						
					} catch (NumberFormatException w) {
						JOptionPane.showMessageDialog(null, "Keine Zahl bei Matrikelnummer eingegeben!");
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				}
			}
		});

		JButton button_Zurück = new JButton("Zur\u00FCck");
		button_Zurück.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Anmeldemaske anmeldemaske = new Anmeldemaske();
				anmeldemaske.setVisible(true);
			}
		});
		GridBagConstraints gbc_button_Zurück = new GridBagConstraints();
		gbc_button_Zurück.gridwidth = 9;
		gbc_button_Zurück.insets = new Insets(0, 0, 0, 5);
		gbc_button_Zurück.gridx = 7;
		gbc_button_Zurück.gridy = 9;
		contentPane.add(button_Zurück, gbc_button_Zurück);
		GridBagConstraints gbc_btnRegistrieren_1 = new GridBagConstraints();
		gbc_btnRegistrieren_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistrieren_1.gridx = 16;
		gbc_btnRegistrieren_1.gridy = 9;
		contentPane.add(btnRegistrieren_1, gbc_btnRegistrieren_1);

	}

}
