package de.hexswarm.dev.school.projekt2.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Rückgabe {
	LinkedList<LinkedList<Object>> _row = new LinkedList<LinkedList<Object>>();
	LinkedList<Object> _col = new LinkedList<Object>();
	boolean _erfolgreich;
	
	public void Add(ResultSet rs) {
		LinkedList<Object> list = new LinkedList<Object>();
		
		try {
			// Spalten
			for(int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				_col.add(rs.getMetaData().getColumnName(i + 1));
			}
			
			// Reihen
			for(int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				list.add(rs.getObject(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		_row.add(list);
	}

	public boolean isErfolreich() {
		return _erfolgreich;
	}

	public void setErfolgreich(boolean erfolgreich) {
		_erfolgreich = erfolgreich;
	}

	public LinkedList<LinkedList<Object>> getReihen() {
		return _row;
	}
}
