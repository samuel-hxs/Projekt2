package de.hexswarm.dev.school.projekt2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.UUID;
import java.util.prefs.Preferences;

import de.hexswarm.dev.school.projekt2.models.Artikel;
import de.hexswarm.dev.school.projekt2.models.Datenbank;
import de.hexswarm.dev.school.projekt2.models.Nutzer;
import de.hexswarm.dev.school.projekt2.models.Rechnung;


public class HexKonfiguration {
	private Datenbank _db;
	private static final String PREF_DB_NAME = "db_name";
	private static final String PREF_DB_PASSWORD = "db_password";
	private static final String PREF_DB_SERVER = "db_server";
	private static final String PREF_DB_SHEMA = "projekt2";
	
	private Nutzer _nutzer;
	private LinkedList<Artikel> _artikels;
	private Rechnung _rechnung;
	
	// Retrieve the user preference node for the package
	private Preferences _prefs = Preferences.userNodeForPackage(de.hexswarm.dev.school.projekt2.Main.class);

	
	public boolean Save() {
//		// Set the value of the preference
//		String newValue = "a string";
//		prefs.put(PREF_DB_NAME, newValue);

		return false;
	}

	public boolean Load() {
		Preferences prefs = Preferences.userNodeForPackage(de.hexswarm.dev.school.projekt2.Main.class);
		String defaultValue = "";
		String server = prefs.get(HexKonfiguration.PREF_DB_SERVER, defaultValue); // "a string"
		String nutzer = prefs.get(HexKonfiguration.PREF_DB_NAME, defaultValue); // "a string"
		String password = prefs.get(HexKonfiguration.PREF_DB_PASSWORD, defaultValue); // "a string"
		String shema = prefs.get(HexKonfiguration.PREF_DB_SHEMA, defaultValue); // "a string"
		_db = new Datenbank(server, nutzer, password, shema);
		
		return false;
	}
	
	public boolean SaveDB(String user, String password, String server, String shema) {
		_prefs.put(PREF_DB_NAME, user);
		_prefs.put(PREF_DB_PASSWORD, password);
		_prefs.put(PREF_DB_SERVER, server);
		_prefs.put(PREF_DB_SHEMA, shema);
		
		_db = new Datenbank(server, user, password, shema);
		return true;
	}

	public Datenbank GetDB() {
		return _db;
	}
	
	public boolean speichern(String user, String password, String server, String shema) {
		File configFile = new File("config.properties");
		 
		try {
		    Properties props = new Properties();
		    props.setProperty("server", server);
		    props.setProperty("nutzer", user);
		    props.setProperty("passwort", password);
		    props.setProperty("datenbank", shema);
		    
		    FileWriter writer = new FileWriter(configFile);
		    props.store(writer, "host settings");
		    writer.close();

			_db = new Datenbank(server, user, password, shema);
		} catch (FileNotFoundException ex) {
		    // file does not exist
			return false;
		} catch (IOException ex) {
		    // I/O error
			return false;
		}
		
		return true;
	}
	
	public boolean laden() {
		File configFile = new File("config.properties");
		 
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    String server = props.getProperty("server");
		    String nutzer = props.getProperty("nutzer");
		    String passwort = props.getProperty("passwort");
		    String datenbank = props.getProperty("datenbank");
		 
		    reader.close();
		    
		    _db = new Datenbank(server, nutzer, passwort, datenbank);
		} catch (FileNotFoundException ex) {
		    // file does not exist
			return false;
		} catch (IOException ex) {
		    // I/O error
			return false;
		}
		return true;
	}

	public Nutzer getNutzer() {
		if(_nutzer == null) {
			_nutzer = new Nutzer(new UUID(-1, -1), "Unzulässiger Nutzer", "Unzulässiger Nutzer", "");
		}
		
		return _nutzer;
	}
}
