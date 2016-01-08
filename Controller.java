
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
	
	public  static int getTask(){
		int id = 0;
		
		String sqlBefehl = "select * from Aufgaben where id = " + id;
		
		return id;
	}
	
	public  static int getTasks(){
		int id = 0;
		
		String sqlBefehl = "select * from Aufgaben where Poolid = " + id;
		
		return id;
	}
	
	public  static boolean deleteTask(int id){
		
		String sqlBefehl = "delete from Aufgaben where ID = " + id;
		
		return true;
	}
	
	
	
}
