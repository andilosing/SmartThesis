package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datenbank.Datenbankzugriff;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Anmeldemaske extends JFrame {

	private JPanel contentPane;
	private JTextField textField_EMail;
	private JPasswordField passwordField_Passwort;
	private static Anmeldemaske anmeldemaske;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 anmeldemaske = new Anmeldemaske();
					anmeldemaske.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Anmeldemaske() {
		setTitle("SmartThesis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 52, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEmail = new JLabel("E-Mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.gridwidth = 3;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 1;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		textField_EMail = new JTextField();
		GridBagConstraints gbc_textField_EMail = new GridBagConstraints();
		gbc_textField_EMail.gridwidth = 3;
		gbc_textField_EMail.insets = new Insets(0, 0, 5, 5);
		gbc_textField_EMail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_EMail.gridx = 1;
		gbc_textField_EMail.gridy = 2;
		contentPane.add(textField_EMail, gbc_textField_EMail);
		textField_EMail.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort");
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.anchor = GridBagConstraints.WEST;
		gbc_lblPasswort.gridwidth = 3;
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 1;
		gbc_lblPasswort.gridy = 3;
		contentPane.add(lblPasswort, gbc_lblPasswort);
		
		passwordField_Passwort = new JPasswordField();
		GridBagConstraints gbc_passwordField_Passwort = new GridBagConstraints();
		gbc_passwordField_Passwort.gridwidth = 3;
		gbc_passwordField_Passwort.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_Passwort.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_Passwort.gridx = 1;
		gbc_passwordField_Passwort.gridy = 4;
		contentPane.add(passwordField_Passwort, gbc_passwordField_Passwort);
		
		JButton btnRegistrieren = new JButton("Registrieren");
		btnRegistrieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Registriermaske registriermaske = new Registriermaske();
				registriermaske.setVisible(true);
			}
			
		});
		GridBagConstraints gbc_btnRegistrieren = new GridBagConstraints();
		gbc_btnRegistrieren.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistrieren.gridx = 8;
		gbc_btnRegistrieren.gridy = 7;
		contentPane.add(btnRegistrieren, gbc_btnRegistrieren);
		
		JButton button_Anmelden = new JButton("Anmelden");
		button_Anmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Datenbankzugriff.getConn() == null) {
					Datenbankzugriff.verbindeDatenbank();}
					try {
						
						Datenbankzugriff.anmelden(textField_EMail.getText(), passwordField_Passwort.getText(), anmeldemaske);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				
				
			}
		});
		GridBagConstraints gbc_button_Anmelden = new GridBagConstraints();
		gbc_button_Anmelden.gridx = 10;
		gbc_button_Anmelden.gridy = 7;
		contentPane.add(button_Anmelden, gbc_button_Anmelden);
	}

}
