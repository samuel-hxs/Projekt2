package de.hexswarm.dev.school.projekt2.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Rückgabe {
	LinkedList<LinkedList<String>> _row = new LinkedList<LinkedList<String>>();
	LinkedList<String> _col = new LinkedList<String>();
	
	public void Add(ResultSet rs) {
		LinkedList<String> list = new LinkedList<String>();
		
		try {
			for(int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				list.add(rs.getString(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		_row.add(list);
	}

}
