package model;

import java.util.ArrayList;
import java.util.HashMap;

import db.DatabaseEntity;
import db.DatabaseSQLite;

/**
 * Die Klasse Professor bildet einen Lehrenden des b.i.b International College ab.
 * 
 * Sie besitzt Attribute wie <code>name</code> oder <code>firstName</code>. 
 * 
 * @author Cornelia Stussig
 *
 */
public class Professor extends DatabaseEntity {
	
	/**
	 * Name der Datenbanktabelle
	 */
	public static final String TABLE_NAME = "Dozenten";

	/**
	 * Spaltenname der Spalte DozentenID
	 */
	private static final String DOZENTEN_ID = "DozentenID";

	/**
	 * Spaltenname der Spalte Name
	 */
	private static final String NAME = "Name";

	/**
	 * Spaltenname der Spalte Vorname
	 */
	private static final String FIRSTNAME = "Vorname";

	/**
	 * Spaltenname der Spalte Passwort
	 */
	private static final String PASSWORD = "Passwort";
		
	/**
	 * Attribut für die Dozenten-ID
	 */
	private String dozentenID;
	
	/**
	 * Attribut für den Nachnamen
	 */
	private String name;
	
	/**
	 * Attribut für den Vornamen
	 */
	private String firstName;
	
	/**
	 * Attribut für das Passwort
	 */
	private String password;
	
	/**
	 * Konstruktor, der die Parameter zur intialen Belegung entgegen nimmt
	 * 
	 * @param dozentenID
	 * @param name
	 * @param firstName
	 * @param password
	 */
	public Professor(String dozentenID, String name, String firstName, String password) 
	{
		super(DatabaseSQLite.getInstance());
		this.dozentenID = dozentenID;
		this.name = name;
		this.firstName = firstName;
		this.password = password;		
	}	

	/**
	 * Leerer Konstruktor
	 * 
	 * Dient hauptsächlich zur Instanzierung durch die Datenbank-Klassen.
	 * 
	 */
	public Professor() {
		this(null, null, null, null);
	}
	
	public String getDozentenID() {
		return dozentenID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	/**
	 * Liefert Alle Dozenten, die Anhand einer Like-Suche auf den Nachnamen in der Datenbank gesucht werden.
	 * 
	 * @param name Name oder Teilname des Professors
	 * @return ArrayList aus Professor-Objekten
	 */
	public static ArrayList<Professor> getByName(String name){
		String where = NAME + " LIKE '" + name + "'";
		return getByAttribute(where);
	}

	/**
	 * Liefert Alle Dozenten, die Anhand einer Like-Suche auf den Vornamen in der Datenbank gesucht werden.
	 * 
	 * @param firstName Name oder Teilname des Professors
	 * @return ArrayList aus Professor-Objekten
	 */
	public static ArrayList<Professor> getByFirstame(String firstName){
		String where = FIRSTNAME + " LIKE '" + firstName + "'";
		return getByAttribute(where);
	}

	/**
	 * Liefert Alle Dozenten, die Anhand einer Like-Suche auf die Dozenten-ID in der Datenbank gesucht werden.
	 * 
	 * @param dozentenID Dozenten-ID des Professors
	 * @return ArrayList aus Professor-Objekten
	 */
	public static ArrayList<Professor> getByDozentenID(String dozentenID){
		String where = DOZENTEN_ID + " LIKE '" + dozentenID + "'";
		return getByAttribute(where);
	}

	/**
	 * Liefert Alle Dozenten.
	 * 
	 * @return ArrayList aus Professor-Objekten
	 */
	public static ArrayList<Professor> get(){
		return getByAttribute("");
	}

	
	/**
	 * Führt auf der Datenbank-Objekt-Instanz die get-Methode aus und generiert aus dem zurückgegebenen Werten die Professor-Objekte.
	 * 
	 * @param where
	 * @return
	 */
	private static ArrayList<Professor> getByAttribute(String where) {
		ArrayList<HashMap<String, Object>> entries = DatabaseSQLite.getInstance().get(TABLE_NAME, where);
		ArrayList<Professor> professoren = new ArrayList<Professor>();
		for (int i = 0; i < entries.size(); i++) {
			Professor p = new Professor();
			p.dozentenID = (String) entries.get(i).get(DOZENTEN_ID);
			p.name = (String) entries.get(i).get(NAME);
			p.firstName = (String) entries.get(i).get(FIRSTNAME);
			p.password = (String) entries.get(i).get(PASSWORD);
			p.isInDB = true;
			professoren.add(p);
		}
		return professoren;
	}

	/* (non-Javadoc)
	 * @see db.DatabaseEntity#getValueMap()
	 */
	@Override
	protected HashMap<String, Object> getValueMap() {
		HashMap<String, Object> fields = new HashMap<String, Object>();
		fields.put(DOZENTEN_ID, this.dozentenID);
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
		fields.put(DOZENTEN_ID, this.dozentenID);
		return fields;
	}
}
