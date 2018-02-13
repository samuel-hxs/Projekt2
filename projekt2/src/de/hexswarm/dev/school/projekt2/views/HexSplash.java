package de.hexswarm.dev.school.projekt2.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import de.hexswarm.dev.school.projekt2.controlers.HexManager;

public class HexSplash extends HexCard {
	private HexCard _card = new HexLogin(null);
	
	public HexSplash(HexManager manager) {
		super(manager);
		_name = "Splash";
		
		JLabel label = new JLabel();
		label.setText("Hello World!");
		add(label);
		
		JButton button = new JButton();
		button.setText("NextCard");
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	_card.SetManager(_manager);
		    	_manager.Push(_card);
		    }
		});
		add(button);
	}
}
