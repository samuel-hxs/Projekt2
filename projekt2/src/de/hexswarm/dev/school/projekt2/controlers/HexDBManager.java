package de.hexswarm.dev.school.projekt2.controlers;

import de.hexswarm.dev.school.projekt2.HexKonfiguration;
import de.hexswarm.dev.school.projekt2.models.Datenbank;
import de.hexswarm.dev.school.projekt2.models.Rückgabe;

public class HexDBManager {
	private Datenbank _db;
	private HexKonfiguration _konf;
	
	public HexDBManager(HexKonfiguration konf) {
		_konf = konf;
		_db = konf.GetDB();
	}

	public boolean Verbinde() {
		return false;
	}
	
	public Rückgabe Abfrage(String string) {
		return _db.Statement(string);
	}
}
