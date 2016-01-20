package model;

import java.util.ArrayList;
import java.util.HashMap;

import database.DatabaseEntity;
import database.DatabaseSQLite;
/**
 * Die Klasse Student bildet einen Studenten des b.i.b International College ab.
 * 
 * Sie besitzt Attribute wie <code>name</code> oder <code>firstName</code>. 
 * 
 * @author Cornelia Stussig
 *
 */
public class Student extends DatabaseEntity {

	/**
	 * Name der Datenbanktabelle
	 */
	public static final String TABLE_NAME = "Studenten";

	/**
	 * Spaltenname der Spalte StudentenID
	 */
	private static final String STUDENTEN_ID = "StudentenID";

	/**
	 * Spaltenname der Spalte Name
	 */
	private static final String NAME = "Name";

	/**
	 * Spaltenname der Spalte Nachname
	 */
	private static final String SECONDTNAME = "Nachname";

	/**
	 * Spaltenname der Spalte Bild Pfad
	 */
	private static final String PICTURE = "Bild";

	/**
	 * Spaltenname der Spalte Klasse
	 */
	private static final String STUDENTCLASS = "Klasse";
		
	/**
	 * Attribut für die Studenten-ID
	 */
	private String studentID;
	
	/**
	 * Attribut für den Namen
	 */
	private String name;
	
	/**
	 * Attribut für den Nachnamen
	 */
	private String secondName;
	
	/**
	 * Attribut für das Bild
	 */
	private String picture;

	/**
	 * Attribut für die Klasse
	 */
	private String studentClass;
	
	/**
	 * Konstruktor, der die Parameter zur intialen Belegung entgegen nimmt
	 * 
	 * @param studentID
	 * @param name
	 * @param secondName
	 * @param picture
	 * @param studentClass
	 */
	public Student(String studentID, String name, String secondName, String picture, String studentClass){
		super(DatabaseSQLite.getInstance());
		this.setStudentID(studentID);
		this.setName(name);
		this.setSecondName(secondName);
		this.setPicture(picture);
		this.setStudentClass(studentClass);
	}

	/**
	 * Leerer Konstruktor
	 * 
	 * Dient hauptsächlich zur Instanzierung durch die Datenbank-Klassen.
	 * 
	 */
	public Student() {
		this(null, null, null, null, null);
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	
	/**
	 * Liefert Alle Studenten, die Anhand einer Like-Suche auf den Nachnamen in der Datenbank gesucht werden.
	 * 
	 * @param name Name oder Teilname des Studenten
	 * @return ArrayList aus Studenten-Objekten
	 */
	public static ArrayList<Student> getByName(String secondName){
		String where = SECONDTNAME + " LIKE '" + secondName + "'";
		return getByAttribute(where);
	}
	/**
	 * Liefert Alle Studenten, die Anhand einer Like-Suche auf den Vornamen in der Datenbank gesucht werden.
	 * 
	 * @param firstName Name oder Teilname des Studenten
	 * @return ArrayList aus Studenten-Objekten
	 */
	public static ArrayList<Student> getByFirstame(String name){
		String where = NAME + " LIKE '" + name + "'";
		return getByAttribute(where);
	}

	/**
	 * Liefert Alle Studenten, die Anhand einer Like-Suche auf die Studenten-ID in der Datenbank gesucht werden.
	 * 
	 * @param studentenID studenten-ID des Studenten
	 * @return ArrayList aus Studenten-Objekten
	 */
	public static ArrayList<Student> getByStudentID(String studentID){
		String where = STUDENTEN_ID + " LIKE '" + studentID + "'";
		return getByAttribute(where);
	}

	/**
	 * Liefert Alle Studenten.
	 * 
	 * @return ArrayList aus Studenten-Objekten
	 */
	public static ArrayList<Student> get(){
		return getByAttribute("");
	}

	
	/**
	 * Führt auf der Datenbank-Objekt-Instanz die get-Methode aus und generiert aus dem zurückgegebenen Werten die Studenten-Objekte.
	 * 
	 * @param where
	 * @return
	 */
	private static ArrayList<Student> getByAttribute(String where) {
		ArrayList<HashMap<String, Object>> entries = DatabaseSQLite.getInstance().get(TABLE_NAME, where);
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < entries.size(); i++) {
			Student s = new Student();
			s.studentID = (String) entries.get(i).get(STUDENTEN_ID);
			s.name = (String) entries.get(i).get(NAME);
			s.secondName = (String) entries.get(i).get(SECONDTNAME);
			s.picture = (String) entries.get(i).get(PICTURE);
			s.studentClass = (String) entries.get(i).get(STUDENTCLASS);
			s.isInDB = true;
			students.add(s);
		}
		return students;
	}

	/* (non-Javadoc)
	 * @see db.DatabaseEntity#getValueMap()
	 */ 
	@Override
	protected HashMap<String, Object> getValueMap() {
		HashMap<String, Object> fields = new HashMap<String, Object>();
		fields.put(STUDENTEN_ID, this.studentID);
		fields.put(NAME, this.name);
		fields.put(SECONDTNAME, this.secondName);
		fields.put(PICTURE, this.picture);
		fields.put(STUDENTCLASS, this.studentClass);
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
		fields.put(STUDENTEN_ID, this.studentID);
		return fields;
	}
}
