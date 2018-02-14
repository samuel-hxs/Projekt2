package de.hexswarm.dev.school.projekt2.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import de.hexswarm.dev.school.projekt2.HexKonfiguration;
import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;
import de.hexswarm.dev.school.projekt2.controlers.HexNutzerManager;

public class HexLogin extends HexCard {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1369699227541183517L;

	public HexLogin(HexCardManager manager) {
		super(manager);
		_name = "Login";
		//setBackground(new Color(119, 149, 242));
		
		// Layout
		setLayout(new GridLayout(0, 2));

		// Nutzer
		JLabel lbl_info = new JLabel();
		lbl_info.setText("DB Verbindung fehlgeschlagen!");
		add(lbl_info);

		JButton btn_konfig = new JButton();
		btn_konfig.setText("Einstellungen");
		btn_konfig.setBackground(new Color(59, 89, 182));
		btn_konfig.setForeground(Color.WHITE);
		btn_konfig.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn_konfig.setFocusPainted(false);
		btn_konfig.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new HexKonfig(_manager).Push();
		    }
		});
		add(btn_konfig);

		// Nutzer
		JLabel lbl_nutzer = new JLabel();
		lbl_nutzer.setText("Nutzer:");
		add(lbl_nutzer);
		JTextField txt_nutzer = new JTextField();
		add(txt_nutzer);
		
		// Passwort
		JLabel lbl_passwort = new JLabel();
		lbl_passwort.setText("Passwort:");
		add(lbl_passwort);
		JPasswordField pwd_passwort = new JPasswordField();
		//pwd_passwort.setBackground(new Color(79, 109, 202));
		//pwd_passwort.setForeground(Color.WHITE);
		pwd_passwort.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(pwd_passwort);

		add(new JPanel());
		
		JButton btn_login = new JButton();
		btn_login.setText("Anmelden");
		btn_login.setBackground(Color.GREEN);
		btn_login.setForeground(Color.WHITE);
		btn_login.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_login.setFocusPainted(false);
		btn_login.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
			    	HexNutzerManager ntzrmgr = new HexNutzerManager(_manager.GetKonfig());
			    	if(ntzrmgr.VerifyNutzer(txt_nutzer.getText(), pwd_passwort.getPassword())) {
			    		new HexMain(_manager).Push();
			    	}
			    	else
			    	{
			    		lbl_info.setText("Anmeldung nicht erlaubt!");
			    	}
		    }
		});
		add(btn_login);
		
		// TODO Einen thread zum prüfen der Daten
		// TODO Events in den Controller Auslagern
		// TODO Bessere, zentrierte und alignd Gestaltung des Layouts	
	}

}
