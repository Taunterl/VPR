package datenbankSQLite;

import java.sql.*;
import java.util.ArrayList;

import database.DatabaseSQLite;
import model.Professor;

public class SQLiteTestrun
{
	public static void main( String args[] ) throws InterruptedException
	{		
		// SQLite
		final String DB_URL = "jdbc:sqlite:datenbankSQLite/testDB.db";
		
		// Oracle
		//final String DB_URL = "jdbc:oracle:driver_type:[username/password]@[//]host_name[:port][:ORCL]";
		
		final String USER = "";
		final String PWD = "";
		
		DatabaseSQLite.getInstance().connect(DB_URL, USER, PWD);
		
		ArrayList<Professor> allProfessors = Professor.get();
		for (int i = 0; i < allProfessors.size(); i++) {
			allProfessors.get(i).delete();
		}
		
		// Professor anlegen und bearbeiten Beispiel
		Professor p = new Professor("DYC", "Dyck", "Zeugen", "abcd");
		p.save();				//neu hinzufügen
		
		DatabaseSQLite.getInstance().count(Professor.TABLE_NAME);
		Professor.get();
		
		p.setFirstName("Eugen");		// änderung
		p.save();					// abspeichern in DB
		p.setPassword("efgh");
		p.save();
		p.delete();					// Entity löschen 

		Thread.sleep(100);
		
		DatabaseSQLite.getInstance().count(Professor.TABLE_NAME);
		Professor.get();
		
		DatabaseSQLite.getInstance().close();
		
		System.exit(0);
		
	}
}