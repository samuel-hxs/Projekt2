package de.hexswarm.dev.school.projekt2.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import de.hexswarm.dev.school.projekt2.controlers.HexManager;

public class HexSplash extends HexCard {

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
		    	manager.Push(new HexLogin(manager));
		    }
		});
		add(button);
	}
}
