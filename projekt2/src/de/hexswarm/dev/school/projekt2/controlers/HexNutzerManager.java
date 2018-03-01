package de.hexswarm.dev.school.projekt2.controlers;

import java.util.UUID;

import de.hexswarm.dev.school.projekt2.HexKonfiguration;
import de.hexswarm.dev.school.projekt2.models.Nutzer;
import de.hexswarm.dev.school.projekt2.models.Rückgabe;

public class HexNutzerManager {
	private HexKonfiguration _konf;
	
	public HexNutzerManager(HexKonfiguration konf) {
		_konf = konf;
	}
	
	public boolean verifyNutzer(String text, char[] password) {
		HexDBManager dbmgr = new HexDBManager(_konf);
		Rückgabe rg = dbmgr.doStatement("SELECT user, password, active FROM User");
		Nutzer nutzer = null;
		
		if(rg.isErfolreich()) {
			nutzer = new Nutzer(new UUID(-1, -1), "", "", "");
		}

		if(nutzer != null && nutzer.GetName().equals(text) && nutzer.GetPasswortHash().equals(new String(password))) {
			return true;
		}
		else
		{
			return false;
		}
	}	

}
