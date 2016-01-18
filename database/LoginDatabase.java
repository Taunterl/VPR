package database;
import java.sql.*;
import java.util.HashMap;
public class LoginDatabase 
{
	
	private static HashMap<String, String> dbConnect()
	{
		//Configure database connection#
		

		final String DB_Driver = "org.sqlite.JDBC";
		final String DB_URL ="jdbc:sqlite:login.db";
		
		
		final String USER = "";
		final String PWD = "";
		
		
		Connection c = null ;
		
		HashMap<String, String> loginData = null;
		
		try
		{
		
			//Register Driver
			Class.forName(DB_Driver);
			// Open Connection
			c = DriverManager.getConnection(DB_URL);
			System.out.println("Opened database successfully...");
		
			//Execute Query / Process results
			dropTBL(c, "DOZENTEN");
			createTBL(c);
			insertDozent(c);
			loginData=getIdPassword(c);
			// Cleanup
			c.close();			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//System.exit(0);
			
		}
			return loginData;
	}
	
	public static boolean loginValidation(String username, String password)
	{
		HashMap<String, String> loginData = null;
		loginData = dbConnect();
		if(loginData.get(username.toUpperCase()).equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	private static void dropTBL(Connection c, String tableName)
	{
		
		try(Statement stmt = c.createStatement())
		{
			
			String sql = "DROP TABLE "+tableName+";";
			stmt.executeUpdate(sql);
			System.out.println("Table dropped");
			
			
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	private static void createTBL(Connection c)
	{
		try(Statement stmt = c.createStatement())
		{
			
			String sql = "CREATE TABLE DOZENTEN" +
						 "(DOZENTENID CHAR(20) PRIMARY KEY	NOT NULL,"+
						 " NAME 					   TEXT	NOT NULL,"+
						 " VORNAME 					   TEXT	NOT NULL,"+
						 " PASSWORT					   TEXT	NOT NULL);";
			
			stmt.executeUpdate(sql);
			System.out.println("Table created");
			
			
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private static void insertDozent(Connection c)
	{
		
		try(Statement stmt = c.createStatement())
		{
			
			//SQL Command
			String[] lecturers = {	"INSERT INTO DOZENTEN (DOZENTENID,NAME,VORNAME,PASSWORT)"+
									"VALUES ('DOZDYC', 'Dyck', 'Eugen', 'test');",
									"INSERT INTO DOZENTEN (DOZENTENID,NAME,VORNAME,PASSWORT)"+
									"VALUES ('DOZBOC', 'Bock', 'Michael', 'test');",
									"INSERT INTO DOZENTEN (DOZENTENID,NAME,VORNAME,PASSWORT)"+
									"VALUES ('DOZMEN', 'Menne', 'Stefan', 'test');",
									"INSERT INTO DOZENTEN (DOZENTENID,NAME,VORNAME,PASSWORT)"+
									"VALUES ('DOZVOM', 'Voss', 'Matthias', 'test');",
			};
			for(String sqlStatement: lecturers){
				stmt.execute(sqlStatement);
			}
			
			
			System.out.println("Entry successfull");
			
			
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	private static HashMap<String, String> getIdPassword(Connection c)
	{
		HashMap<String, String> loginData_sql = new HashMap<String, String>();
		try(Statement stmt = c.createStatement())
		{
			
			String sql = "Select DOZENTENID,PASSWORT FROM DOZENTEN;";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next())
			{
				String dozid = rs.getString("DOZENTENID");
				String pass = rs.getString("PASSWORT");
				
				loginData_sql.put(dozid, pass);
				
			}
			//**für Testzwecke
			//System.out.println(loginData_sql);		
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return loginData_sql;
	}
}
