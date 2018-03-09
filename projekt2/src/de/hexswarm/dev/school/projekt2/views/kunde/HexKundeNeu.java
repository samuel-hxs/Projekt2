package de.hexswarm.dev.school.projekt2.views.kunde;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;
import de.hexswarm.dev.school.projekt2.models.Rückgabe;
import de.hexswarm.dev.school.projekt2.views.HexCard;

public class HexKundeNeu extends HexCard {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5433309590756159298L;

	public HexKundeNeu(HexCardManager manager) {
		super(manager);

		// Layout
		setLayout(null);
		setBackground(Color.WHITE);
		
		int i = 0;
		JTextField anrede = newEntry("Anrede", i++);
		JTextField vorname = newEntry("Vorname", i++);
		JTextField nachname = newEntry("Nachname", i++);
		JTextField straße = newEntry("Straße", i++);
		JTextField hausnummer = newEntry("Hausnummer", i++);
		JTextField postleitzahl = newEntry("Postleitzahl", i++);
		JTextField ort = newEntry("Ort", i++);
		JTextField partner = newEntry("Ansprechpartner", i++);
		JTextField telefon = newEntry("Telefon", i++);
		JTextField email = newEntry("E-Mail Adresse", i++);
        
		JButton btn_zurück = new JButton();
        btn_zurück.setBounds(30, 520, 140, 40);
		btn_zurück.setText("Zurück");
		btn_zurück.setBackground(Color.RED);
		btn_zurück.setForeground(Color.WHITE);
		btn_zurück.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn_zurück.setFocusPainted(false);
		btn_zurück.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Pop();
		    }
		});
		add(btn_zurück);

		JButton btn_erstellen = new JButton();
        btn_erstellen.setBounds(180, 520, 140, 40);
		btn_erstellen.setText("Erstellen");
		btn_erstellen.setBackground(Color.GREEN);
		btn_erstellen.setForeground(Color.WHITE);
		btn_erstellen.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn_erstellen.setFocusPainted(false);
		btn_erstellen.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	String template = "INSERT INTO kunde (nachname, vorname, straße, hausnummer, postleitzahl, ort) VALUES (\"%s\", \"%s\", \"%s\", \"%s\", \"%d\", \"%s\")";
		    	if(postleitzahl.getText().equals("")) {
		    		postleitzahl.setText("0");
		    	}
		    	String statement = String.format(template, nachname.getText(), vorname.getText(), straße.getText(), hausnummer.getText(), Integer.parseInt(postleitzahl.getText()), ort.getText());
		    	manager.getKonfiguration().getDBManager().doStatement(statement);
		    	
		    	Rückgabe rg = new Rückgabe();
		    	
		    	if(rg.isErfolreich()) {
		    		Pop();
		    	}
		    	else {
		    		System.out.println("Speichern des Kunden fehlgeschlagen!");
		    	}
		    }
		});
		add(btn_erstellen);
	}
	
	private JTextField newEntry(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(10, 10 + y * (40 + 10), 120, 40);
        add(label);
        
        JTextField text_ = new JTextField();
        text_.setBounds(140, 10 + y * (40 + 10), 220, 40);
        add(text_);
        
        return text_;
	}

}
