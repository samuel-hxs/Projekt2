package de.hexswarm.dev.school.projekt2.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import de.hexswarm.dev.school.projekt2.HexKonfiguration;
import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;
import de.hexswarm.dev.school.projekt2.controlers.HexNutzerManager;
import de.hexswarm.dev.school.projekt2.models.Datenbank;

public class HexKonfig extends HexCard {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3526980641237505276L;

	public HexKonfig(HexCardManager manager) {
		super(manager);
		_name = "Konfiguration";
		//HexKonfiguration konf = manager.holeKonfiguration();
		
		// Layout
		setLayout(new GridLayout(0, 2));

		// Nutzer
		add(new JPanel());
		
		JLabel lbl_info = new JLabel();
		lbl_info.setText("Einstellungen");
		add(lbl_info);

		// Nutzer
		JLabel lbl_nutzer = new JLabel();
		lbl_nutzer.setText("Nutzer:");
		add(lbl_nutzer);
		JTextField txt_nutzer = new JTextField();
		//txt_nutzer.setText(konf.GetDB().);
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
		
		// Server
		JLabel lbl_server = new JLabel();
		lbl_server.setText("Server:");
		add(lbl_server);
		JTextField txt_server = new JTextField();
		add(txt_server);
		
		// Shema
		JLabel lbl_shema = new JLabel();
		lbl_shema.setText("Shema:");
		add(lbl_shema);
		JTextField txt_shema = new JTextField();
		add(txt_shema);

		JButton btn_abbrechen = new JButton();
		btn_abbrechen.setText("Abbrechen");
		btn_abbrechen.setBackground(Color.RED);
		btn_abbrechen.setForeground(Color.WHITE);
		btn_abbrechen.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn_abbrechen.setFocusPainted(false);
		btn_abbrechen.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Pop();
		    }
		});
		add(btn_abbrechen);
		
		JButton btn_save = new JButton();
		btn_save.setText("Speichern");
		btn_save.setBackground(Color.GREEN);
		btn_save.setForeground(Color.WHITE);
		btn_save.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_save.setFocusPainted(false);
		btn_save.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(manager.getKonfiguration().speichern(txt_nutzer.getText(), new String(pwd_passwort.getPassword()), txt_server.getText(), txt_shema.getText())) {
		    		Pop();
		    	}
		    	else {
		    		lbl_info.setText("Speichern fehlgeschlagen!");
		    	}
		    }
		});
		add(btn_save);
	}

}
