package model;

import database.DatabaseSQLite;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller { //AufgabenPoolManager

	public static void main(String[] args) {
		//TESTER
		dbconnect();
		
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
		//System.out.println(getPools());
		//System.out.println("test");
	}
	
	//Methode stellt Verbindung mit DB her
	public static void dbconnect()
	{
		final String DB_URL = "jdbc:sqlite:datenbankSQLite/testDB.db";
		
		final String USER = "";
		final String PWD = "";
		
		DatabaseSQLite.getInstance().connect(DB_URL, USER, PWD);
	}
	
	// Methode erstellt neuen AufgabenPool
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
	
	// Methode gibt alle Aufgaben eines Pools wieder
	public static  int[] getPoolTasks(int ID)
	{
		//SQL MANAGER
		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
	
		result = DatabaseSQLite.getInstance().get("Aufgaben", "Pool = "+ ID);
		
		int[] return_array = new int[result.size()];
		int counter = 0;
		for(HashMap<String,Object> line: result){
			return_array[counter] = (int) line.get("AufgabenId");
			counter++;
			//System.out.println(line.get("AufgabenId") + " - " + line.get("Bezeichnung"));
			
		}
		

		return return_array;
	}
	
	// Methode gibt alle Pools in einem Observable zurück
	public static ObservableList<String> getPools()
	{
		//SQL MANAGER
		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
		result = DatabaseSQLite.getInstance().get("Aufgabenpool");
		//String[] return_array = new String[result.size()];
		ObservableList<String> PoolList = FXCollections.observableArrayList();
		
		int counter = 0;
		for(HashMap<String,Object> line: result){
			//return_array[counter] = (String) line.get("Beschreibung");
			//PoolList.add((int) line.get("AufgabenpoolID"),(String) line.get("Beschreibung"));
			PoolList.add((String) line.get("Beschreibung"));
			counter++;
			//System.out.println(line.get("AufgabenId") + " - " + line.get("Bezeichnung"));
		}
		
		return PoolList;
	}
	
	// Methode gibt PoolID anhand des Namens zurück
	public static int getPoolID(String name)
	
	{
		//SQL MANAGER,
		//TODO 
		//String sql = "SELECT Beschreibung FROM Aufgabenpool where AufgabenpoolID = "+ ID + ";";
		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
		
		result = DatabaseSQLite.getInstance().get("Aufgabenpool", "Beschreibung = '" + name + "'");
		
		int return_int = 0;
		for(HashMap<String,Object> line: result){
			return_int = (int) line.get("AufgabenpoolID");
			
		}
		return return_int;
		
	}

	//Methode holt sich die größe des AufgabenPools ab 
	public static  int getPoolSize(int IdPool)
	{
		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
		
		result = DatabaseSQLite.getInstance().get("Aufgaben", "Pool = " + IdPool);
		
		int counter = 0;
		for(HashMap<String,Object> line: result){
			counter++;
		}
		return counter;
		//String sql = "SELECT COUNT(*) FROM AUFGABEN WHERE POOL = " + IdPool + ";";
		//return 0;

	}
	
	//Löscht einen Aufgabenpool und löscht vorher alle dortdrin sich befindenden Aufgaben
	public static boolean deletePool(int ID)
	{
		if(checkTaskPool(ID))
		{
			 int[] all_tasks = getPoolTasks(ID);
			 for(int task :all_tasks)
			 {
				 deleteTask(task);
			 }
			 DatabaseSQLite.getInstance().delete("Aufgabenpool", "AufgabenpoolID = " + ID);
			 return true;
		}
		
		//String sql = "DELETE FROM Aufgabenpol WHERE Aufgabenpool="+ ID + ";";
		return false;
	}
	
	//Erstellt eine neue Aufgabe in einen Ausgewählten  Aufgabenpool
	public static int createTask(int PoolID , String name ,String Beschreibung, String kat , String zeit ){
		
		HashMap<String,Object> fields = new HashMap<> ();
		fields.put("Bezeichnung",name);
		fields.put("Beschreibung",Beschreibung);
		fields.put("Kategorie",kat);
		fields.put("Bearbeitungszeit",zeit);
		fields.put("Pool",PoolID);
		DatabaseSQLite.getInstance().insert("Aufgaben", fields);
		
		return 0;
		
		
		//String sqlBefehl = "INSERT INTO Aufgaben VALUES ( " + id + name + " };";
		
		//return id;
		
	}
	
	public static Aufgaben getTaskObj(int ID)
	{
		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
		
		result = DatabaseSQLite.getInstance().get("Aufgaben", "AufgabenId = " + ID);
		
		String return_str = null;
		Aufgaben task = null;
		for(HashMap<String,Object> line: result){
			return_str = (String) line.get("Bezeichnung");
			task = new Aufgaben((String) line.get("Bezeichnung"),(String) line.get("Beschreibung"),(String) line.get("Bearbeitungszeit") ,(String) line.get("Kategorie"),(String) line.get("pool"));
			task.setID((int) line.get("AufgabenId"));
		}
		return task;
	}
	
	//Holt sich eine Aufgabe aus der Datenbank ab und nimmt die ID als suchparameter
	public static String getTask(int ID){
		
		//String sqlBefehl = "select * from Aufgaben where id = " + ID;
		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
		
		result = DatabaseSQLite.getInstance().get("Aufgaben", "AufgabenId = " + ID);
		
		String return_str = null;
		for(HashMap<String,Object> line: result){
			return_str = (String) line.get("Bezeichnung");
			
		}
		return return_str;
	}
	

	//Löscht eine einzelne Aufgabe anhand der ID
	public  static boolean deleteTask(int ID){
		
		if(checkTask(ID))
		{
			DatabaseSQLite.getInstance().delete("Aufgaben", "AufgabenId = " + ID);
			return true;
		}
		return false;
	}

	//Umbennen von eine, Aufgabenpool
	public static boolean changePoolName(int ID, String newName)
	{
		DatabaseSQLite.getInstance().update("Aufgabenpool", "AufgabenpoolId = " + ID, "Beschreibung", newName );
	/*	String sql = "UPDATE Aufgabenpool"
				+ "set name = '" + ID + "' ;"
				+ "set name = '" + newName + "' ;";*/
		return true;
	}
	
	//Umbenennen von einer Aufgabe
	public static boolean changeTask(int ID, String newTask)
	{
		DatabaseSQLite.getInstance().update("Aufgaben", "AufgabenId = " + ID, "Bezeichnung", newTask);
		/*String sql = "UPDATE Aufgabenpool"
				+ "set name = '" + ID + "' ;"
				+ "set name = '" + newTask + "' ;";*/
		return true;
	}
	
	//Methode prüft existenz eines AufgabenPools
	public static boolean checkTaskPool(String name)
	{

		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
		result = DatabaseSQLite.getInstance().get("Aufgabenpool","Beschreibung = '" + name + "'");
		
		boolean checked =false;
		if(result.size()>0)
		{
			checked = true;
		}
		
		return checked;
	}

	//Methode prüft existenz eines AufgabenPools
	public static boolean checkTaskPool(int ID)
	{	
		/*String sql = "SELECT"+ ID 
		+"FROM Aufgabenpool"  ;*/
		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
		result = DatabaseSQLite.getInstance().get("Aufgabenpool","AufgabenpoolId = " + ID );
		
		boolean checked =false;
		if(result.size()>0)
		{
			checked = true;
		}
		return checked;
	}
	
	//Methode prüft existenz einer Aufgabe
	public static boolean checkTask(String name)
	{

		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
		result = DatabaseSQLite.getInstance().get("Aufgaben","Bezeichnung = '" + name + "'");
		
		boolean checked =false;
		if(result.size()>0)
		{
			checked = true;
		}
		
		return checked;
	}

	//Methode prüft existenz einer Aufgabe
	public static boolean checkTask(int ID)
	{	
		/*String sql = "SELECT"+ ID 
		+"FROM Aufgabenpool"  ;*/
		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
		result = DatabaseSQLite.getInstance().get("Aufgaben","AufgabenId = " + ID );
		
		boolean checked =false;
		if(result.size()>0)
		{
			checked = true;
		}
		return checked;
	}
	
}
