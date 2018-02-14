package de.hexswarm.dev.school.projekt2.views;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.hexswarm.dev.school.projekt2.HexKonfiguration;
import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;

public class HexForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -913372250282046673L;
	
	private HexCardManager _manager;
	private HexKonfiguration _konf;
	
	public HexForm(String name, HexKonfiguration konf)
	{
		int width = 400;
		int height = 600;
		this.setTitle(name);
		//this.setBounds(new Rectangle(0, 0, width, height));
		this.setPreferredSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));

		_konf = konf;
		_manager = new HexCardManager(this, _konf);
				
		HexCard splash = new HexSplash(_manager);
		splash.Push();
	}
}
