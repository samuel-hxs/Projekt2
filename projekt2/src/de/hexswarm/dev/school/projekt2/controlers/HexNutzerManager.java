package de.hexswarm.dev.school.projekt2.controlers;

import java.util.LinkedList;
import java.util.UUID;

import de.hexswarm.dev.school.projekt2.models.Nutzer;

public class HexNutzerManager {

	public static boolean VerifyNutzer(String text, char[] password) {
		LinkedList<Nutzer> nutzers = new LinkedList<Nutzer>();
		nutzers.add(new Nutzer(new UUID(1, 1), "1", "Nachname", "1"));
		
		for(int i = 0; i < nutzers.size(); ++i) {
			Nutzer nutzer = nutzers.get(i);
			
			if(nutzer.GetName().equals(text) && nutzer.GetPasswortHash().equals(new String(password))) {
				return true;
			}
		}
		
		System.out.println("Nutzer oder Passwort falsch.");
		return false;
	}

}
