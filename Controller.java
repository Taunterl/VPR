
public class AufgabenPoolManager {

	public static void main(String[] args) {
		//TESTER
	}
	
	public int CreateTaskPool(String name,int dozId, String Fach, String Beschreibung)
	{
		//SQL MANAGER
		String sql = "INSERT INTO Aufgabenpool (Dozent,Fach,Beschreibung) "
				+ "VALUES ('" + dozId + "','" + Fach + "','" + Beschreibung + "');" ;
		
		return 0;
	}
	
	public int[] getPoolTasks(int ID)
	{
		//SQL MANAGER
		String sql = "SELECT * FROM Aufgabenpool where AufgabenpoolID = "+ ID + ";";
		return null;
	}
	
	public String getPoolName(int ID)
	
	{
		//SQL MANAGER,
		//TODO 
		String sql = "SELECT Beschreibung FROM Aufgabenpool where AufgabenpoolID = "+ ID + ";";
		
		return null;
	}
	
	public int getPoolSize(int IdPool)
	{
		String sql = "SELECT COUNT(*) FROM AUFGABEN WHERE POOL = " + IdPool + ";";
		return 0;

	}
	
	public boolean deletePool(int ID)
	{
		String sql = "DELETE FROM Aufgabenpol WHERE Aufgabenpool="+ ID + ";";
		return false;
	}
	
		public  static int createTask(int id , String name ){
		
		String sqlBefehl = "INSERT INTO Aufgaben VALUES ( " + id + name + " };";
		
		return id;
		
	}
	
	public  static int getTask(int ID){
		
		String sqlBefehl = "select * from Aufgaben where id = " + ID;
		
		return id;
	}
	
	public  static int getTasks(int ID){
		
		String sqlBefehl = "select * from Aufgaben where Poolid = " + ID;
		
		return id;
	}
	
	public  static boolean deleteTask(int ID){
		
		String sqlBefehl = "delete from Aufgaben where ID = " + ID;
		
		return true;
	}
	package org.sqlite.core;

import java.util.Set;

public class Controller {
	public static boolean changePoolName(int ID, String newName)
	{
		String sql = "UPDATE Aufgabenpool"
				+ "set name = '" + ID + "' ;"
				+ "set name = '" + newName + "' ;";
		return true;
	}
	public static boolean changeTask(int ID, String newTask)
	{
		String sql = "UPDATE Aufgabenpool"
				+ "set name = '" + ID + "' ;"
				+ "set name = '" + newTask + "' ;";
		return true;
	}
	public static boolean checkTaskPool(String name)
	{
		return true;
	}
	public static boolean checkTaskPool(int ID)
	{	
		return true;
	}
	
	public static boolean connectTaskToGroup(int PoolID, int TaskID, int groupID)
	{
		String sql = "SELECT Pool.PoolID, Task.TaskID, Group.groupID"
					+"FROM Aufgaben, Gruppen"
					+"INNER JOIN  "
					+"ON Orders.CustomerID=Customers.CustomerID";
		return true;
	}
}
	
	
}
