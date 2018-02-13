package de.hexswarm.dev.school.projekt2.views;

import java.awt.Color;

import javax.swing.JLabel;

import de.hexswarm.dev.school.projekt2.controlers.HexManager;

public class HexMain extends HexCard {

	public HexMain(HexManager manager) {
		super(manager);
		
		JLabel lbl_titel = new JLabel();
		lbl_titel.setText("Hauptmenü");
		lbl_titel.setHorizontalTextPosition(JLabel.CENTER);
		lbl_titel.setBackground(Color.BLACK);
		lbl_titel.setForeground(Color.WHITE);
		add(lbl_titel);
	}

}
