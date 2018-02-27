package de.hexswarm.dev.school.projekt2.views.kunde;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;
import de.hexswarm.dev.school.projekt2.views.HexCard;

public class HexKundeBearbeiten extends HexCard {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5486500348874311255L;

	public HexKundeBearbeiten(HexCardManager manager) {
		super(manager);

		// Layout
		setLayout(null);
		setBackground(Color.WHITE);
		
		JButton btn_zurück = new JButton();
        btn_zurück.setBounds(10, 310, 100, 40);
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
	}

}
