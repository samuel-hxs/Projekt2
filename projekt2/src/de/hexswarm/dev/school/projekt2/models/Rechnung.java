package de.hexswarm.dev.school.projekt2.models;

import java.util.LinkedList;

import javax.swing.ListModel;

public class Rechnung {
		private Kunde _kunde;
		private Nutzer _nutzer;
		private LinkedList<Artikel> _artikels;
	
		public Rechnung(Kunde kunde, Nutzer nutzer, LinkedList<Artikel> artikels) {
			_kunde = kunde;
			_nutzer = nutzer;
			_artikels = artikels;
		}
		
		public void AddArtikel(Artikel artikel) {
			if(!_artikels.contains(artikel)) {
				_artikels.add(artikel);
			}
		}

		// TODO Ist das Sicher?
		public void AddArtikel(LinkedList<Artikel> artikels) {
			if(!_artikels.containsAll(artikels)) {
				_artikels.addAll(artikels);
			}
		}
		
		public void DelArtikel(Artikel artikel) {
			if(_artikels.contains(artikel)) {
				_artikels.remove(artikel);
			}
		}

		// TODO Ist das Sicher?
		public void DelArtikel(LinkedList<Artikel> artikels) {
			if(_artikels.addAll(artikels)) {
				_artikels.removeAll(artikels);
			}
		}

		public LinkedList<Artikel> getArtikels() {
			return _artikels;
		}
}
