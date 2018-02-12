package de.hexswarm.dev.school.projekt2.views;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.hexswarm.dev.school.projekt2.controlers.HexManager;

public class HexForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -913372250282046673L;
	
	private HexManager _manager;
	
	public HexForm(String name)
	{
		this.setTitle(name);
		this.setBounds(new Rectangle(0, 0, 400, 600));
		_manager = new HexManager(this.getContentPane());
				
		HexCard splash = new HexSplash(_manager);
		splash.Push();
	}
}
