package de.hexswarm.dev.school.projekt2;

import java.util.prefs.Preferences;

import de.hexswarm.dev.school.projekt2.models.Datenbank;
import de.hexswarm.dev.school.projekt2.models.Nutzer;


public class HexKonfiguration {
	private Datenbank _db;
	private static final String PREF_DB_NAME = "db_name";
	private static final String PREF_DB_PASSWORD = "db_password";
	private static final String PREF_DB_SERVER = "db_server";
	protected static Nutzer _nutzer;
	public static Nutzer Nutzer;
	// Retrieve the user preference node for the package
	private Preferences prefs = Preferences.userNodeForPackage(de.hexswarm.dev.school.projekt2.Main.class);

	
	public boolean Save() {
		// Set the value of the preference
		String newValue = "a string";
		prefs.put(PREF_DB_NAME, newValue);

		return false;
	}

	public boolean Load() {
		Preferences prefs = Preferences.userNodeForPackage(de.hexswarm.dev.school.projekt2.Main.class);
		// Get the value of the preference;
		// default value is returned if the preference does not exist
		String defaultValue = "default string";
		String server = prefs.get(HexKonfiguration.PREF_DB_SERVER, defaultValue); // "a string"
		String nutzer = prefs.get(HexKonfiguration.PREF_DB_NAME, defaultValue); // "a string"
		String password = prefs.get(HexKonfiguration.PREF_DB_PASSWORD, defaultValue); // "a string"
		_db = new Datenbank(server, nutzer, password);
		
		return false;
	}
	
	public boolean SaveDB(String user, String password, String server) {
		prefs.put(PREF_DB_NAME, user);
		prefs.put(PREF_DB_PASSWORD, password);
		prefs.put(PREF_DB_SERVER, server);
		
		_db = new Datenbank(server, user, password);
		return false;
	}

	public Datenbank GetDB() {
		return _db;
	}
}
