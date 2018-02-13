package de.hexswarm.dev.school.projekt2.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Datenbank {
	private String _shema;
	private String _server;
	private String _username;
	private String _password;
	private boolean _verbunden;
	private Connection _conn = null;
	private final String _template = "jdbc:mysql://%s/%s?user=%s&password=%s";
	
	public Datenbank(String server, String nutzer, String password) {
		_server = server;
		_password = password;
		_username = nutzer;
	}
	
	public boolean Verbinde() {
		try {
			_conn = DriverManager.getConnection(String.format(_template, _server, _shema,  _username, _password));
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}
	
	public boolean Verbinde(String shema) {
		return false;
	}
	
	public boolean Statement() {
		Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = _conn.createStatement();
		    rs = stmt.executeQuery("SELECT foo FROM bar");

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...

		    if (stmt.execute("SELECT foo FROM bar")) {
		        rs = stmt.getResultSet();
		    }

		    // Now do something with the ResultSet ....
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
		
		return false;
	}
}
