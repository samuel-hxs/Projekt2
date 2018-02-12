package de.hexswarm.dev.school.projekt2.models;

import java.math.BigDecimal;
import java.util.Currency;

public class Artikel {
	private String _name;
	private String _beschreibung;
	private Currency _currency;
	private BigDecimal _wert;
	private BigDecimal _anzahl;
	
	public Artikel(String name, String beschreibung, Currency currency, BigDecimal wert, BigDecimal anzahl) {
		_currency = currency;
		_anzahl = anzahl;
		_name = name;
		_beschreibung = beschreibung;
		_wert = wert;
	}
	
	public void SetWert(BigDecimal wert) {
		_wert = wert;
	}
	
	public BigDecimal GetWert() {
		return _wert;
	}
	
	public BigDecimal GetGesamt() {
		return _wert.multiply(_anzahl);
	}
	
	public void SetAnzahl(BigDecimal anzahl) {
		_anzahl = anzahl;
	}
	
	public BigDecimal GetAnzahl() {
		return _anzahl;
	}
}
