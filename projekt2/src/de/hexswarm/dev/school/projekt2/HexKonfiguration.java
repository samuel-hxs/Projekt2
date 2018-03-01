package de.hexswarm.dev.school.projekt2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import java.util.prefs.Preferences;

import de.hexswarm.dev.school.projekt2.models.HexDatenbank;
import de.hexswarm.dev.school.projekt2.models.Nutzer;


public class HexKonfiguration {
	private HexDatenbank _db;
	private static final String PREF_DB_NUTZER = "db_nutzer";
	private static final String PREF_DB_PASSWORT = "db_passwort";
	private static final String PREF_DB_SERVER = "db_server";
	private static final String PREF_DB_SHEMA = "db_shema";
	
	private Nutzer _nutzer;
	
	// Retrieve the user preference node for the package
	private Preferences _prefs = Preferences.userNodeForPackage(de.hexswarm.dev.school.projekt2.Main.class);

	public HexDatenbank getDatenbank() {
		if(_db == null) {
			doLaden();
		}
		
		return _db;
	}
	
	public boolean doSpeichern(String user, String password, String server, String shema) {
		File configFile = new File("config.properties");
		 
		try {
		    Properties props = new Properties();
		    props.setProperty(PREF_DB_SERVER, server);
		    props.setProperty(PREF_DB_NUTZER, user);
		    props.setProperty(PREF_DB_PASSWORT, password);
		    props.setProperty(PREF_DB_SHEMA, shema);
		    
		    FileWriter writer = new FileWriter(configFile);
		    props.store(writer, "host settings");
		    writer.close();

			_db = new HexDatenbank(server, user, password, shema);
		} catch (FileNotFoundException ex) {
		    // file does not exist
			return false;
		} catch (IOException ex) {
		    // I/O error
			return false;
		}
		
		return true;
	}
	
	public boolean doLaden() {
		File configFile = new File("config.properties");
		 
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    String server = props.getProperty(PREF_DB_SERVER);
		    String nutzer = props.getProperty(PREF_DB_NUTZER);
		    String passwort = props.getProperty(PREF_DB_PASSWORT);
		    String datenbank = props.getProperty(PREF_DB_SHEMA);
		 
		    reader.close();
		    
		    _db = new HexDatenbank(server, nutzer, passwort, datenbank);
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
			_nutzer = new Nutzer(new UUID(-1, -1), "", "", "");
		}
		
		return _nutzer;
	}
}
