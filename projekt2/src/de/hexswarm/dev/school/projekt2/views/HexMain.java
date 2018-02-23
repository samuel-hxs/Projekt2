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

import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;
import de.hexswarm.dev.school.projekt2.views.kunde.HexKunde;
import de.hexswarm.dev.school.projekt2.views.rechnung.HexRechnung;

public class HexMain extends HexCard {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7604674953174704353L;

	public HexMain(HexCardManager manager) {
		super(manager);
		_name = "Menü";
		HexMain local = this;
		
		// Layout
		setLayout(new GridLayout(0, 1));

		// Nutzer
		JLabel lbl_info = new JLabel();
		lbl_info.setText("DB Verbindung fehlgeschlagen!");
		add(lbl_info);

		add(new JPanel());
		
		JButton btn_kunde = new JButton();
		btn_kunde.setText("Kunde");
		btn_kunde.setBackground(new Color(59, 89, 182));
		btn_kunde.setForeground(Color.WHITE);
		btn_kunde.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn_kunde.setFocusPainted(false);
		btn_kunde.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new HexKunde(_manager).Push();
		    }
		});
		add(btn_kunde);

		JButton btn_artikel = new JButton();
		btn_artikel.setText("Artikel");
		btn_artikel.setBackground(new Color(59, 89, 182));
		btn_artikel.setForeground(Color.WHITE);
		btn_artikel.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn_artikel.setFocusPainted(false);
		btn_artikel.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		});
		add(btn_artikel);

		JButton btn_rechnung = new JButton();
		btn_rechnung.setText("Rechnung");
		btn_rechnung.setBackground(new Color(59, 89, 182));
		btn_rechnung.setForeground(Color.WHITE);
		btn_rechnung.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn_rechnung.setFocusPainted(false);
		btn_rechnung.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new HexRechnung(_manager).Push();
		    }
		});
		add(btn_rechnung);
		
		add(new JPanel());

		JButton btn_logout = new JButton();
		btn_logout.setText("Abmelden");
		btn_logout.setBackground(Color.RED);
		btn_logout.setForeground(Color.WHITE);
		btn_logout.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn_logout.setFocusPainted(false);
		btn_logout.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Pop();
		    }
		});
		add(btn_logout);
	}

}
