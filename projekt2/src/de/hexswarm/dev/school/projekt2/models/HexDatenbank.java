package de.hexswarm.dev.school.projekt2.models;

public class HexDatenbank {
	private String _shema;
	private String _server;
	private String _nutzer;
	private String _passwort;
	private boolean _verbunden;
	
	public HexDatenbank(String server, String nutzer, String passwort, String shema) {
		_server = server;
		_passwort = passwort;
		_nutzer = nutzer;
		_shema = shema;
	}

	public String getServer() {
		return _server;
	}

	public String getShema() {
		return _shema;
	}

	public String getNutzer() {
		return _nutzer;
	}

	public String getPasswort() {
		return _passwort;
	}

	public boolean isVerbunden() {
		return _verbunden;
	}

	public void setVerbunden(boolean verbunden) {
		_verbunden = verbunden;
	}
}
