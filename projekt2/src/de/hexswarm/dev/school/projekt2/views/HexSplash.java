package de.hexswarm.dev.school.projekt2.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;

public class HexSplash extends HexCard {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8346404464497507916L;
	private HexCard _card = new HexLogin(null);
	
	public HexSplash(HexCardManager manager) {
		super(manager);
		_name = "Splash";
		setBackground(new Color(119, 149, 242));
		
		JLabel label = new JLabel();
		label.setText("Hello World!");
		add(label);
		
		JButton button = new JButton();
		button.setText("NextCard");
		button.setBackground(new Color(59, 89, 182));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
        button.setFocusPainted(false);
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	_card.SetManager(_manager);
		    	_manager.Push(_card);
		    }
		});
		add(button);
		
		// TODO Laden der Konfiguration
		// TODO Verbinden zur Datenbank
		// TODO Laden der Nutzerinformationen
		// TODO Timeout wenn verbindung zu lange dauert zur Loginform wechseln
		// TODO Errortimeout wenn keine Verbindung, in der Loginform fehler anzeigen als top down drop
		// TODO Auslagern des Listeners in einen Controller
	}
}
