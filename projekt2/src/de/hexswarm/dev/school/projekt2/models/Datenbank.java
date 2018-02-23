package de.hexswarm.dev.school.projekt2.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import java.sql.ResultSet;

public class Datenbank {
	private String _shema;
	private String _server;
	private String _username;
	private String _password;
	private boolean _verbunden;
	private Connection _conn = null;
	private final String _template = "jdbc:mysql://%s/%s?user=%s&password=%s";
	
	public Datenbank(String server, String nutzer, String password, String shema) {
		_server = server;
		_password = password;
		_username = nutzer;
		_shema = shema;
	}
	
	public boolean Verbinde() {
		try {
			_conn = DriverManager.getConnection(String.format(_template, _server, _shema,  _username, _password));
			return true;
		} catch (SQLException e) {
			System.out.println("Datenbankverbindung fehlgeschlagen");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean Verbinde(String shema) {
		try {
			_conn = DriverManager.getConnection(String.format(_template, _server, shema,  _username, _password));
			return true;
		} catch (SQLException e) {
			System.out.println("Datenbankverbindung fehlgeschlagen");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Rückgabe Statement(String statement) {
		Statement stmt = null;
		ResultSet rs = null;
		Rückgabe rgb = new Rückgabe();
		
		if(_conn == null || _verbunden == false) {
			Verbinde();
		}
		

		if(_conn == null || _verbunden == false) {
			return rgb;
		}
		
		try {
		    stmt = _conn.createStatement();
		    //rs = stmt.executeQuery("SELECT foo FROM bar");

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...

		    if (stmt.execute(statement)) {
		        rs = stmt.getResultSet();
		    }

		    // Now do something with the ResultSet ....
		    while (rs.next()) {
		    	rgb.Add(rs);
		    }
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

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
