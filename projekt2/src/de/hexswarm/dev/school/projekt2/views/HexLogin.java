package de.hexswarm.dev.school.projekt2.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import de.hexswarm.dev.school.projekt2.HexKonfiguration;
import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;
import de.hexswarm.dev.school.projekt2.controlers.HexNutzerManager;

public class HexLogin extends HexCard implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1369699227541183517L;
	private SwingWorker<Boolean, Void> worker;
	private Timer timer;
	
	public HexLogin(HexCardManager manager) {
		super(manager);
		_name = "Login";
		HexLogin local = this;
		//setBackground(new Color(119, 149, 242));
		
		// Layout
		setLayout(new GridLayout(0, 2));

		// Nutzer
		JLabel lbl_info = new JLabel();
		lbl_info.setText("DB Verbindung fehlgeschlagen!");
		add(lbl_info);

		JButton btn_konfig = new JButton();
		btn_konfig.setText("Einstellungen");
		btn_konfig.setBackground(new Color(59, 89, 182));
		btn_konfig.setForeground(Color.WHITE);
		btn_konfig.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn_konfig.setFocusPainted(false);
		btn_konfig.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new HexKonfig(_manager).Push();
		    }
		});
		add(btn_konfig);

		// Nutzer
		JLabel lbl_nutzer = new JLabel();
		lbl_nutzer.setText("Nutzer:");
		add(lbl_nutzer);
		JTextField txt_nutzer = new JTextField();
		add(txt_nutzer);
		
		// Passwort
		JLabel lbl_passwort = new JLabel();
		lbl_passwort.setText("Passwort:");
		add(lbl_passwort);
		JPasswordField pwd_passwort = new JPasswordField();
		//pwd_passwort.setBackground(new Color(79, 109, 202));
		//pwd_passwort.setForeground(Color.WHITE);
		pwd_passwort.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(pwd_passwort);

		add(new JPanel());
		
		JButton btn_login = new JButton();
		btn_login.setText("Anmelden");
		btn_login.setBackground(Color.GREEN);
		btn_login.setForeground(Color.WHITE);
		btn_login.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_login.setFocusPainted(false);
		btn_login.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btn_login.setEnabled(false);
		    
				// Wahrscheinlich nicht notwendig.
				if(worker != null) {
					worker = null;
				}

				int pause = 1000;
				int speed = 100;
				if (timer == null) {
					timer = new Timer(speed, local);
		        timer.setInitialDelay(pause);
		        timer.start(); 
				}
				else {
					timer.restart();
				}
				
				if(worker == null) {
				// Ein Test für Hintergrundberechnungen oder zeitlastige Aufgaeben.
				worker = new SwingWorker<Boolean, Void>() {
				    @Override
				    public Boolean doInBackground() {
				        Boolean innerImgs = new Boolean(false);
				        HexNutzerManager ntzrmgr = new HexNutzerManager(_manager.GetKonfig());
				    	innerImgs = ntzrmgr.VerifyNutzer(txt_nutzer.getText(), pwd_passwort.getPassword());
				        return innerImgs;
				    }

				    @Override
				    public void done() {
				        //Remove the "Loading images" label.
				        try {
				        	Boolean b = get();
				        	if(b == true)
				        	{
				        	new HexMain(_manager).Push();
				        	}
				        	worker.cancel(true);
		    	btn_login.setEnabled(true);
				        } catch (InterruptedException ignore) {}
				        catch (java.util.concurrent.ExecutionException e) {
				            String why = null;
				            Throwable cause = e.getCause();
				            if (cause != null) {
				                why = cause.getMessage();
				            } else {
				                why = e.getMessage();
				            }
				            System.err.println("Error retrieving file: " + why);
				        }
				    }
				};
				}
				worker.execute();
		    }
		});
		add(btn_login);
		 
		// TODO Einen thread zum prüfen der Daten
		// TODO Events in den Controller Auslagern
		// TODO Bessere, zentrierte und alignd Gestaltung des Layouts	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        if (!worker.isDone()) {
            return;
        }
        timer.stop();
        
		//new HexMain(_manager).Push();
			    	
			    		
		//this.lbl_info.setText("Anmeldung nicht erlaubt!");
	}

}
