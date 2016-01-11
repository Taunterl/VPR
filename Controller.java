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
	
		//String sql = "SELECT Beschreibung FROM Aufgabenpool where AufgabenpoolID = "+ ID + ";";
		
		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
		
		result = DatabaseSQLite.getInstance().get("Aufgabenpool", "AufgabenpoolID = " + PoolID);
		
		String return_str = "";
		for(HashMap<String,Object> line: result){
			return_str = (String) line.get("Beschreibung");
			
		}
	
		return return_str;
	}
	
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
	
	public static String getTask(int ID){
		
		//String sqlBefehl = "select * from Aufgaben where id = " + ID;
		ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>> ();
		
		result = DatabaseSQLite.getInstance().get("Aufgaben", "AufgabenId = " + ID);
		
		String return_str = null;
		for(HashMap<String,Object> line: result){
			return_str = (String) line.get("Bezeichnung");
