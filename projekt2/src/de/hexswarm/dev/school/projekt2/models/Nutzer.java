package de.hexswarm.dev.school.projekt2.models;

import java.util.UUID;

public class Nutzer {
	private UUID _uuid;
	private String _name;
	private String _nachname;
	private String _password;
	
	public Nutzer(UUID uuid, String name, String nachname, String password) {
		_name = name;
		_uuid = uuid;
		_password = password;
		_nachname = nachname;
	}
	
	public UUID GetUUID() {
		return _uuid;
	}
	
	public String GetName() {
		return _name;
	}

	public String GetNachname() {
		return _nachname;
	}

	public String GetPasswortHash() {
		return _password;
	}
}
