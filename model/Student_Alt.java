package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import database.DatabaseEntity;
import database.DatabaseSQLite;

public class Student_Alt extends DatabaseEntity {
	

	public static final String TABLE_NAME = "Studenten";

	private static final String STUDENTEN_ID = "StudentenID";

	private static final String NAME = "Name";

	private static final String FIRSTNAME = "Vorname";

	private static final String PASSWORD = "Passwort";
		
	private String StudentenId;
	
	private String name;
	
	private String firstName;
	
	private String password;
	
	
	private Connection C;
	private DatabaseSQLite database;
	private String StudentenID;
	private String Vorname;
	private String Name;
	private String Bild;
	private String Klasse;
	private String TableName = "Studenten";
	

	student(String studentenid, String firstName, String sName, String picturePath, String Klasse, String password) {

		super(DatabaseSQLite.getInstance());
		this.StudentenID= studentenid;
		this.Vorname = firstName;
		this.Name = sName;
		this.Bild = picturePath;
		this.Klasse =  Klasse;
		this.password = password;
	}

	student(){
		
	}
	
	
	
	public void getFullName(Connection c,String secondName) {

		Connection c1 = c;
		selectBadUser(c1, secondName);
	}

	public void addStudents(Connection c, String StudentenId, String Vorname, String Nachname, String Bild, String Klasse){
		
		insertStudent(c,StudentenId,Vorname,Nachname,Bild,Klasse);
	}
	
	
	public void addStudent(String StudentenId, String firstname, String secondname, String picturePath, String klasse){
		HashMap<String, Object> fields = new HashMap<String, Object>();
		
		int counter = 0;
		
		if(StudentenId.matches(".+[a-zA-Z]+.+")){
		System.out.println("Format Falsch, bitte neu eingeben");
		}
		else{
		fields.put("StudentenId", StudentenId);
		counter++;
		}
		if(firstname.matches(".+[0-9]+.+")){
			System.out.println("Format Falsch, bitte neu eingeben");
		}
		else{
		fields.put("Vorname", firstname);
		counter++;
		}
		if(secondname.matches(".+[0-9]+.+")){
			System.out.println("Format Falsch, bitte neu eingeben");
		}
		else{
		fields.put("Name", secondname );
		counter++;
		}
		if(picturePath.matches(".+[0-9]+.+")){
			System.out.println("Format Falsch, bitte neu eingeben");
		}
		else{
		fields.put("Bild", picturePath);
		counter++;
		}
		if(klasse.matches(".+[0-9]+.+")){	
			System.out.println("Format Falsch, bitte neu eingeben");
		}
		else{
		fields.put("Klasse", klasse);	
		counter++;
		}
		if(counter==5){
		database.insert("Vorname", fields);			
		}
		
		
		}
	public Image addPicture (String picturePath){
		
		try {
            InputStream inputStream = new FileInputStream (picturePath);
            Image image = new Image(inputStream);
            return image;
        
		} catch (FileNotFoundException ex) {
            System.out.println(ex);
	}}

	private void selectBadUser(Connection c, String secondName){
		try{
			// 0)
			// Autocommit-default: true
			// c.setAutoCommit(false);
			// c.commit();
			this.C = c;
			// 1) Statement
			Statement stmt = c.createStatement();
			
			// 2) SQL command
			String sql = "SELECT * FROM Studenten WHERE NAME='"+secondName+"'"; 
					   
			// 3) Execution
			// Get results from db / issue a query:
			ResultSet r = stmt.executeQuery(sql);
			
			// 4) Process queryresults
			while( r.next() ){
				// retrieve results according to type
				String  id = r.getString("StudentenId");
				String  Name 	= r.getString("Vorname");
				String  Nachname 	= r.getString("Name");
				String  bild = r.getString("Bild");
				String  Klasse 	= r.getString("Klasse");
				this.StudentenId = id;
				this.Vorname = Name;
				this.Name = Nachname;
				this.Bild = Bild;
				this.Klasse= Klasse;
				
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
	private void insertStudent(Connection c, String StudentenId, String Vorname, String Nachname, String Bild, String Klasse){
		try{
			// 1) Statement
			Statement stmt = c.createStatement();
			
			// 2) SQL command
			String sql1 = "INSERT INTO Studenten (StudentenId ,Name, Nachname, Bild, Klasse) " +
						  "VALUES ('"+StudentenId+"', '"+Vorname+"','"+Nachname+"', '"+Bild+"', '"+Klasse+"');"; 				   
				   
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



	public String getStuentId(){
		
		return this.StudentenID;
		
	}
	
	public void setStudentId(String StudentID){
		
		this.StudentenID = StudentID;
	}

	public String getFirstname(){
		
		return this.Vorname;
		
	}
	
	public void setFirstname(String Firstname){
		
		this.Vorname= Firstname;
	}
	public String getName(){
		
		return this.Name;
		
	}
	public void setName(String Name){
		
		this.Name=Name;
	}
	
	public String getPicture(){
		
		return this.Bild;
		
	}
	
	public void setPicture(String Bild){
		
		this.Bild= Bild;
	}

	public String getStudentClass(){
		
		return this.Klasse;
		
	}

	public void setStudentClass(String Klasse){
		
		this.Klasse = Klasse;
	}
	

	public static ArrayList<student> getByFirstame(String firstName){
		String where = NAME + " LIKE '" + firstName + "'";
		return getByAttribute(where);
	}

	/**
	 * Liefert Alle Dozenten, die Anhand einer Like-Suche auf die Dozenten-ID in der Datenbank gesucht werden.
	 * 
	 * @param dozentenID Dozenten-ID des Professors
	 * @return ArrayList aus Professor-Objekten
	 */
	public static ArrayList<student> getByDozentenID(String dozentenID){
		String where = STUDENTEN_ID + " LIKE '" + dozentenID + "'";
		return getByAttribute(where);
	}

	/**
	 * Liefert Alle Dozenten.
	 * 
	 * @return ArrayList aus Professor-Objekten
	 */
	public static ArrayList<student> get(){
		return getByAttribute("");
	}

	
	/**
	 * Führt auf der Datenbank-Objekt-Instanz die get-Methode aus und generiert aus dem zurückgegebenen Werten die Professor-Objekte.
	 * 
	 * @param where
	 * @return
	 */
	private static ArrayList<student> getByAttribute(String where) {
		ArrayList<HashMap<String, Object>> entries = DatabaseSQLite.getInstance().get(TABLE_NAME, where);
		ArrayList<student> studenten = new ArrayList<student>();
		for (int i = 0; i < entries.size(); i++) {
			student p = new student();
			p.StudentenID = (String) entries.get(i).get(STUDENTEN_ID);
			p.name = (String) entries.get(i).get(NAME);
			p.firstName = (String) entries.get(i).get(FIRSTNAME);
			p.password = (String) entries.get(i).get(PASSWORD);
			p.isInDB = true;
			studenten.add(p);
		}
		return studenten;
	}

	/* (non-Javadoc)
	 * @see db.DatabaseEntity#getValueMap()
	 */
	@Override
	protected HashMap<String, Object> getValueMap() {
		HashMap<String, Object> fields = new HashMap<String, Object>();
		fields.put(STUDENTEN_ID, this.StudentenID);
		fields.put(NAME, this.name);
		fields.put(FIRSTNAME, this.firstName);
		fields.put(PASSWORD, this.password);
		return fields;
	}

	/* (non-Javadoc)
	 * @see db.DatabaseEntity#getTableName()
	 */
	@Override
	protected String getTableName() {
		return TABLE_NAME;
	}

	/* (non-Javadoc)
	 * @see db.DatabaseEntity#getPrimaryKey()
	 */
	@Override
	protected HashMap<String, Object> getPrimaryKey() {
		HashMap<String, Object> fields = new HashMap<String, Object>();
		fields.put(STUDENTEN_ID, this.StudentenID);
		return fields;
	}





}
