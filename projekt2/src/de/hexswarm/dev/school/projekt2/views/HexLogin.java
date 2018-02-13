package de.hexswarm.dev.school.projekt2.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
		setBackground(new Color(119, 149, 242));
		
		// Layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);  // padding

		// Nutzer
		JLabel lbl_nutzer = new JLabel();
		lbl_nutzer.setText("Nutzer:");
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0.0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.EAST;
		add(lbl_nutzer, c);
		JTextField txt_nutzer = new JTextField();
		c.gridx = 2;
		c.gridy = 0;
		c.weighty = 1.0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(txt_nutzer, c);
		
		// Passwort
		JLabel lbl_passwort = new JLabel();
		lbl_passwort.setText("Passwort:");
		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 0.0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.EAST;
		add(lbl_passwort, c);
		JPasswordField pwd_passwort = new JPasswordField();
		pwd_passwort.setBackground(new Color(79, 109, 202));
		pwd_passwort.setForeground(Color.WHITE);
		pwd_passwort.setFont(new Font("Tahoma", Font.BOLD, 12));
		c.gridx = 2;
		c.gridy = 2;
		c.weighty = 1.0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(pwd_passwort, c);
		
		JButton button = new JButton();
		button.setText("Anmelden");
		button.setBackground(new Color(59, 89, 182));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
        button.setFocusPainted(false);
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(HexNutzerManager.VerifyNutzer(txt_nutzer.getText(), pwd_passwort.getPassword())) {
		    		new HexMain(_manager).Push();
		    	}
		    }
		});
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.gridx = 1;       //aligned with button 2
		c.gridy = 2;       //third row
		c.gridwidth = 3;
		c.gridheight = 1;
		c.ipady = 0;
		add(button, c);
		
		// TODO Einen thread zum prüfen der Daten
		// TODO Events in den Controller Auslagern
		// TODO Bessere, zentrierte und alignd Gestaltung des Layouts	
	}

}
