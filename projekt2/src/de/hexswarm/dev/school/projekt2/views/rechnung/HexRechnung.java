package de.hexswarm.dev.school.projekt2.views.rechnung;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;
import de.hexswarm.dev.school.projekt2.views.HexCard;

public class HexRechnung extends HexCard {

	/**
	 * 
	 */
	private static final long serialVersionUID = 725334823516096011L;

	public HexRechnung(HexCardManager manager) {
		super(manager);
		_name = "Rechnung";
		
		String[] data = {"Radfahrverein Hannover  100 Artikel  300€", 
				"Haburger Hand  200 Arikel -10€", 
				"Hans Peter    4 Artikel  300€", 
				"Siri  9999 Artikel 99,99€"};
		JList<String> list_rechnung = new JList<String>(data);

        JLabel label = new JLabel("Rechnungen");
        label.setLabelFor(list_rechnung);
        
		JButton btn_zurück = new JButton();
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
		//add(btn_zurück, BorderLayout.PAGE_END);
		
		JButton btn_neu = new JButton();
		btn_neu.setText("Neu");
		btn_neu.setBackground(Color.GREEN);
		btn_neu.setForeground(Color.WHITE);
		btn_neu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_neu.setFocusPainted(false);
		btn_neu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new HexRechnungNeu(_manager).Push();
		    }
		});
		//add(btn_neu, BorderLayout.PAGE_END);
		
		JPanel listPane = new JPanel();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(label);
        add(Box.createRigidArea(new Dimension(0,5)));
        add(list_rechnung);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(btn_zurück, BorderLayout.PAGE_END);
		add(btn_neu, BorderLayout.LINE_END);
		add(btn_neu, BorderLayout.EAST);
		//add(listPane, BorderLayout.SOUTH);
	}

}
