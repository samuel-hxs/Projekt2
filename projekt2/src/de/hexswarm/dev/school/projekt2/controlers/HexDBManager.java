package de.hexswarm.dev.school.projekt2.controlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CancellationException;

import javax.swing.SwingWorker;

import de.hexswarm.dev.school.projekt2.HexKonfiguration;
import de.hexswarm.dev.school.projekt2.models.HexDatenbank;
import de.hexswarm.dev.school.projekt2.models.Rückgabe;

public class HexDBManager {
	private HexDatenbank _db;
	private HexKonfiguration _konf;
	private Connection _conn = null;
	private final String _template = "jdbc:mysql://%s/%s?user=%s&password=%s";
	private SwingWorker<Rückgabe, Void> _worker;
	private boolean fertig;
	
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
			System.out.println(e.getMessage());
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
	
	public void doStatement(String statement) {
		startWorker(statement);
	}
	
	public Rückgabe doInBackground(String statement) {
		Statement stmt = null;
		ResultSet rs = null;
		Rückgabe rgb = new Rückgabe();
		
		if(_conn == null || _db.isVerbunden() == false) {
			_db.setVerbunden(doVerbinden());
		}

		if(_conn == null || _db.isVerbunden() == false) {
			fertig = true;
			return rgb;
		}
		
		try {
		    stmt = _conn.createStatement();

		    if (stmt.execute(statement)) {
		        rs = stmt.getResultSet();
		    }
		    else
		    {
				fertig = true;
		    	return rgb;
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
		catch(IndexOutOfBoundsException ex)
		{
			System.out.println("Erhaltene Daten haben nicht die erwartete Läge.");
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
		
		fertig = true;
		return rgb;
	}
	
	private void startWorker(String statement) {	    
		// Wahrscheinlich nicht notwendig.
		if(_worker != null) {
			_worker = null;
		}
		
		if(_worker == null) {
		// Ein Test für Hintergrundberechnungen oder zeitlastige Aufgaeben.
		_worker = new SwingWorker<Rückgabe, Void>() {
		    @Override
		    public Rückgabe doInBackground() {
		        return HexDBManager.this.doInBackground(statement);
		    }

		    @Override
		    public void done() {
		        //Remove the "Loading images" label.
		        try {
		        	_worker.cancel(true);
		        } catch(CancellationException e) {
	        	}
		    }
		};
		}
		_worker.execute();
	}
	
	public boolean isFertig() {
		return fertig;
	}
}
