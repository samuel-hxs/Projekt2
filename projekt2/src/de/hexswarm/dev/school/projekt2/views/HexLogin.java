package de.hexswarm.dev.school.projekt2.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import de.hexswarm.dev.school.projekt2.controlers.HexManager;

public class HexLogin extends HexCard {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1369699227541183517L;

	public HexLogin(HexManager manager) {
		super(manager);
		_name = "Login";
		
		// Layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);  // padding
		c.fill = GridBagConstraints.CENTER;

		// Nutzer
		JLabel lbl_nutzer = new JLabel();
		lbl_nutzer.setText("Nutzer:");
		c.gridx = 0;
		c.gridy = 0;
		add(lbl_nutzer, c);
		JTextField txt_nutzer = new JTextField();
		c.gridx = 2;
		c.gridy = 0;
		add(txt_nutzer, c);
		
		// Passwort
		JLabel lbl_passwort = new JLabel();
		lbl_passwort.setText("Passwort:");
		c.gridx = 0;
		c.gridy = 2;
		add(lbl_passwort, c);
		JPasswordField pwd_passwort = new JPasswordField();
		c.gridx = 2;
		c.gridy = 2;
		add(pwd_passwort, c);
		
		JButton button = new JButton();
		button.setText("Anmelden");
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new HexMain(_manager).Push();
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
	}

}
