package de.hexswarm.dev.school.projekt2.controlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hexswarm.dev.school.projekt2.HexKonfiguration;
import de.hexswarm.dev.school.projekt2.models.HexDatenbank;
import de.hexswarm.dev.school.projekt2.models.Rückgabe;

public class HexDBManager {
	private HexDatenbank _db;
	private HexKonfiguration _konf;
	private Connection _conn = null;
	private final String _template = "jdbc:mysql://%s/%s?user=%s&password=%s";
	
	public HexDBManager(HexKonfiguration konf) {
		_konf = konf;
		_db = konf.getDatenbank();
	}
	
	public boolean doVerbinden() {
		try {
			String verbindungsdaten = String.format(_template, _db.getServer(), _db.getShema(),  _db.getNutzer(), _db.getPasswort());
			_conn = DriverManager.getConnection(verbindungsdaten);
			return true;
		} catch (SQLException e) {
			//System.out.println("Datenbankverbindung fehlgeschlagen");
			//System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean doVerbinde(String shema) {
		try {
			_conn = DriverManager.getConnection(String.format(_template, _db.getServer(), shema,  _db.getNutzer(), _db.getPasswort()));
			return true;
		} catch (SQLException e) {
			System.out.println("Datenbankverbindung fehlgeschlagen");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Rückgabe doStatement(String statement) {
		Statement stmt = null;
		ResultSet rs = null;
		Rückgabe rgb = new Rückgabe();
		
		if(_conn == null || _db.isVerbunden() == false) {
			_db.setVerbunden(doVerbinden());
		}
		

		if(_conn == null || _db.isVerbunden() == false) {
			return rgb;
		}
		
		try {
		    stmt = _conn.createStatement();

		    if (stmt.execute(statement)) {
		        rs = stmt.getResultSet();
		    }

		    // Now do something with the ResultSet ....
		    while (rs.next()) {
		    	rgb.Add(rs);
		    }
		    
		    rgb.setErfolgreich(true);
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException:\n\t" + ex.getMessage());
		    System.out.println("SQLState:\n\t" + ex.getSQLState());
		    System.out.println("VendorError:\n\t" + ex.getErrorCode());
		}
		finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}
		
		return rgb;
	}
}
