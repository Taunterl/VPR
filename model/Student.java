import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class student {
	
	private DatabaseSqlLite database;
	private String studentenId;
	private String firstName;
	private String secondName;
	private String picturePath;
	private String klasse;

	student(String fName, String sName) {

		this.firstName = fName;
		this.secondName = sName;

	}

	student(String fName, String sName, String picturePath, String Klasse) {

		this.studentId++;
		this.firstName = fName;
		this.secondName = sName;
		this.picturePath = picturePath;
		this.klasse =  Klasse;

	}

	public void getFullName(Connection c,String secondName) {

		Connection c1 = c;
		selectBadUser(c1, secondName);
	}


	public void addStudent(String StudentenId, String firstname, String secondname, String picturePath, String klasse){
		HashMap<String, Object> fields = new HashMap<String, Object>();
		fields.put("StudentenId", StudentenId);
		fields.put("Vorname", firstname);
		fields.put("Name", secondname );
		fields.put("", this.firstName);
		database.insert("Vorname", this.secondName);
			
	}
	public void addPicture (String picturePath){
		
		
		ImageView image = new ImageView (new Image(getClass().getResourceAsStream(picturePath)));
		
	}

	private void selectBadUser(Connection c, String secondName){
		try{
			// 0)
			// Autocommit-default: true
			// c.setAutoCommit(false);
			// c.commit();
			
			// 1) Statement
			Statement stmt = c.createStatement();
			
			// 2) SQL command
			String sql = "SELECT * FROM TESTDATENBANK WHERE NAME='"+secondName+"'"; 
					   
			// 3) Execution
			// Get results from db / issue a query:
			ResultSet r = stmt.executeQuery(sql);
			
			// 4) Process queryresults
			while( r.next() ){
				// retrieve results according to type
				String  Vorname = r.getString("vorname");
				String  Name 	= r.getString("name");
				this.firstName= Vorname;
				this.secondName= Name;
				
				System.out.println( "RESULT: "+Name+" "+Vorname+"");
			}
			System.out.println("Entry selection successfully...");
			
			// 5) Cleanup
			r.close();
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}		
	}
	private void insertBadUser(Connection c, String vorname, String name){
		try{
			// 1) Statement
			Statement stmt = c.createStatement();
			
			// 2) SQL command
			String sql1 = "INSERT INTO TESTTABELLE (Name,Vorname) " +
						  "VALUES ('"+name+"', '"+vorname+"');"; 				   
				   
			// 3) Batchexecution
			// build a batch of commands and execute statement only once --> performance
			stmt.addBatch(sql1);
			stmt.executeBatch();
			System.out.println("Entry insertion successfully...");
			
			// 4) Cleanup
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}		
	}	

}
