import db.DatabaseSQLite;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Controller { //AufgabenPoolManager

	public static void main(String[] args) {
		//TESTER
		final String DB_URL = "jdbc:sqlite:db/testDB.db";
		
		final String USER = "";
		final String PWD = "";
		
		DatabaseSQLite.getInstance().connect(DB_URL, USER, PWD);
		
		// DOZENTE
	/*	HashMap<String,Object> fields_doz = new HashMap<> ();
		fields_doz.put("DozentenID","2");
		fields_doz.put("Name","DYCK");
		fields_doz.put("Vorname","Matti");
		fields_doz.put("Passwort","#Hamster");
		DatabaseSQLite.getInstance().insert("Dozenten", fields_doz);
		*/
		
		
		
		// AUFGABENPOOL
		/*HashMap<String,Object> fields = new HashMap<> ();
		fields.put("AufgabenpoolID","3");
		fields.put("Dozent","2");
		fields.put("Fach","EIA");
		fields.put("Beschreibung","BESTER AUFGABENPOOL!");
		DatabaseSQLite.getInstance().insert("Aufgabenpool", fields);
		*/
		//CreateTaskPool("AUfgabenpool-SEN", 2, "SEN", "Schlechte Aufgaben hier!");
		
		//System.out.println(DatabaseSQLite.getInstance().get("Dozenten"));
		//System.out.println(DatabaseSQLite.getInstance().get("Aufgabenpool"));
		
		//createTask(5, "Coole Aufgabe1","Langweilig", "Unsinn", "5h");
		//System.out.println(Arrays.toString(getPoolTasks(5)));
		//System.out.println(getPoolName(5));
		//System.out.println(getPoolID("Coole Aufgaben hier!"));
		//System.out.println(getPoolSize(5));
		//deletePool(7);
		//System.out.println(getTask(7));
		//changePoolName(6, "Beste Aufgaben!");
		//changeTask(5, "Tafel wischen");
		//System.out.println(checkTaskPool("Schlechte Aufgdaben hier!"));
		//System.out.println(checkTaskPool(6));
		//System.out.println(checkTask("Tafel wischen"));
		//System.out.println(checkTask(6));
	}
	
	public static int CreateTaskPool(String name,int dozId, String Fach, String Beschreibung)
	{
		//SQL MANAGER
		//String sql = "INSERT INTO Aufgabenpool (Dozent,Fach,Beschreibung) "
		//		+ "VALUES ('" + dozId + "','" + Fach + "','" + Beschreibung + "');" ;
		
		
		HashMap<String,Object> fields = new HashMap<> ();
		fields.put("Dozent",dozId);
		fields.put("Fach",Fach);
		fields.put("Beschreibung",Beschreibung);
		DatabaseSQLite.getInstance().insert("Aufgabenpool", fields);
		
		return getPoolID(name);
	}
	
	public static  int[] getPoolTasks(int ID)
	{
		//SQL MANAGER
		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
	
