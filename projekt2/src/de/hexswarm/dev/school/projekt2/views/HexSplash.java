package de.hexswarm.dev.school.projekt2.views;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;

import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;
import de.hexswarm.dev.school.projekt2.controlers.SplashControl;

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
		label.setText("HexSplash");
		add(label);
		
		JButton button = new JButton();
		button.setText("NextCard");
		button.setBackground(new Color(59, 89, 182));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
        button.setFocusPainted(false);
		button.addActionListener(new SplashControl());
		//add(button);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			  @Override
			  public void run() {
			    new HexLogin(_manager).Push();
			  }
			}, 800); // 800 ms
		
		// TODO Laden der Konfiguration
		// TODO Verbinden zur Datenbank
		// TODO Laden der Nutzerinformationen
		// TODO Timeout wenn verbindung zu lange dauert zur Loginform wechseln
		// TODO Errortimeout wenn keine Verbindung, in der Loginform fehler anzeigen als top down drop
		// TODO Auslagern des Listeners in einen Controller
	}
}
