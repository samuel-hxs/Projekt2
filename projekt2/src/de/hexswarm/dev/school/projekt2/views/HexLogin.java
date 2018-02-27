package de.hexswarm.dev.school.projekt2.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.util.concurrent.CancellationException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
	private HexLogin _local;
	private JLabel lbl_info = new JLabel();
	
	public HexLogin(HexCardManager manager) {
		super(manager);
		_name = "Login";
		_local = this;
		
		// Layout
		setLayout(null);
		setBackground(Color.WHITE);

		// Login Wdiget in etwa
		AddLogin();
		
		// Fehler oder Info
		lbl_info.setText("Anmeldung fehlgeschlagen!");
		lbl_info.setBounds(15, 370, 360, 60);
		lbl_info.setBackground(Color.RED);
		lbl_info.setOpaque(true);
		lbl_info.setVisible(false);
		lbl_info.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_info.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_info.setForeground(Color.WHITE);
		add(lbl_info);

		JButton btn_konfig = new JButton();
		btn_konfig.setText("Einstellungen");
		btn_konfig.setBackground(new Color(59, 89, 182));
		btn_konfig.setForeground(Color.WHITE);
		btn_konfig.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn_konfig.setFocusPainted(false);
        btn_konfig.setBounds(160, 515, 220, 40);
		btn_konfig.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new HexKonfig(_manager).Push();
		    }
		});
		add(btn_konfig);
	}
	
	private void AddLogin() {
		JPanel panel = new JPanel();
		panel.setBounds(15, 160, 360, 210);
		panel.setLayout(null);
		panel.setBackground(Color.ORANGE);
		add(panel);

		// Header Label
		JLabel lbl_header = new JLabel();
		lbl_header.setText("Anmeldung");
		lbl_header.setBounds(10, 10, 220, 40);
		lbl_header.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_header.setForeground(Color.WHITE);
		panel.add(lbl_header);
		
		// Nutzer
		JLabel lbl_nutzer = new JLabel();
		lbl_nutzer.setText("Nutzer:");
		lbl_nutzer.setBounds(10, 60, 120, 40);
		panel.add(lbl_nutzer);
		
		JTextField txt_nutzer = new JTextField();
		txt_nutzer.setBounds(120, 60, 220, 40);
		panel.add(txt_nutzer);
		
		// Passwort
		JLabel lbl_passwort = new JLabel();
		lbl_passwort.setBounds(10, 110, 120, 40);
		lbl_passwort.setText("Passwort:");
		panel.add(lbl_passwort);
		
		JPasswordField pwd_passwort = new JPasswordField();
		pwd_passwort.setBounds(120, 110, 220, 40);
		pwd_passwort.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(pwd_passwort);
		
		JButton btn_login = new JButton();
		btn_login.setBounds(120, 160, 220, 40);
		btn_login.setText("Anmelden");
		btn_login.setBackground(Color.GREEN);
		btn_login.setForeground(Color.WHITE);
		btn_login.setFont(new Font("Tahoma", Font.BOLD, 16));
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
					timer = new Timer(speed, _local);
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
				        Boolean result = new Boolean(false);
				        HexNutzerManager ntzrmgr = new HexNutzerManager(_manager.getKonfiguration());
				    	result = ntzrmgr.VerifyNutzer(txt_nutzer.getText(), pwd_passwort.getPassword());
				        return result;
				    }

				    @Override
				    public void done() {
				        //Remove the "Loading images" label.
				        try {
				        	Boolean b = get();
				        	if(b == true)
				        	{
				        		lbl_info.setVisible(false);
				        		new HexMain(_manager).Push();
				        	}
				        	else
				        	{
				        		lbl_info.setVisible(true);
				        	}
				        	worker.cancel(true);
				        } catch (InterruptedException ignore) {}
				        catch (java.util.concurrent.ExecutionException e) {
				            String why = null;
				            Throwable cause = e.getCause();
				            if (cause != null) {
				                why = cause.getMessage();
				            } else {
				                why = e.getMessage();
				            }
				            System.err.println("Error: " + why);
				        }
				        catch(CancellationException e) {
				        	//debug
//				        	{
//				        		new HexMain(_manager).Push();
//				        	}
			        	}

				    	btn_login.setEnabled(true);
				    }
				};
				}
				worker.execute();
		    }
		});
		panel.add(btn_login);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        if (!worker.isDone()) {
        	//Debug
        	{worker.cancel(true);
        	timer.stop();
        	}return;
        }
        timer.stop();
	}

}
