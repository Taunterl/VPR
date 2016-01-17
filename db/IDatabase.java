package db;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Das Interface <code>IDatabase</code> kann von Datenbanken wie SQLite oder Oracle benutzt werden.
 * Es schreibt einige Methoden zur Ausf�hrung von Basis-Operationen auf der entsprechenden Datenbank vor.
 * 
 * @author Cornelia Stussig
 */
public interface IDatabase {
	
	/**
	 * F�gt einen vollst�ndigen Datensatz auf Basis der �bergebenen
	 * Parameter in die Datenbank ein.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param fields		Mapping der Datenbankfelder als HashMap
	 */
	public void insert(String tableName, HashMap<String, Object> fields);
	
	/**
	 * Liefert alle Datens�tze der angegeben Tabelle.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @return Arrylist in der jeder Datensatz durch eine HashMap repr�sentiert wird sind.
	 */
	public ArrayList<HashMap<String, Object>> get(String tableName);
	
	/**
	 * Liefert Datens�tze der angegeben Tabelle, die f�r das angegebene WHERE-Statement g�ltig sind.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param where			WHERE-Statement, um die Datens�tze einzuschr�nken.
	 * @return Arrylist in der jeder Datensatz durch eine HashMap repr�sentiert wird sind.
	 */
	public ArrayList<HashMap<String, Object>> get(String tableName, String where);
	
	/**
	 * Liefert Datens�tze der angegeben Tabelle. Zus�tzlich wird ein
	 * WHERE-Statement aus den Paramtern key, operator und value ({@link java.lang.String}) generiert.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param key			Name der Spalte
	 * @param operator		Vergleichoperator
	 * @param value			Wert
	 * @return Arrylist in der jeder Datensatz durch eine HashMap repr�sentiert wird sind.
	 */
	public ArrayList<HashMap<String, Object>> get(String tableName, String key, String operator, String value);
	
	/**
	 * Liefert Datens�tze der angegeben Tabelle. Zus�tzlich wird ein
	 * WHERE-Statement aus den Paramtern key, operator und value ({@link int}) generiert.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param key			Name der Spalte
	 * @param operator		Vergleichoperator
	 * @param value			Wert
	 * @return Arrylist in der jeder Datensatz durch eine HashMap repr�sentiert wird sind.
	 */
	public ArrayList<HashMap<String, Object>> get(String tableName, String key, String operator, int value);
	
	/**
	 * Liefert Datens�tze der angegeben Tabelle. Zus�tzlich wird ein
	 * WHERE-Statement aus der �bergebenen HashMap generiert.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param fields 		Vergleichswerte (Atribut1 = Atribut2) 
	 * @return Arrylist in der jeder Datensatz durch eine HashMap repr�sentiert wird sind.
	 */
	public ArrayList<HashMap<String, Object>> get(String tableName, HashMap<String, Object> fields);
	
	/**
	 * F�hrt einen Datenbank befehl aus, der die Anzahl der Datens�tze der Tabelle ermittelt.
	 * 
	 * @param tableName Name der Datenbanktabelle
	 * @return Anzahl der gesamten Datens�tze die in der Tabelle vorhanden sind
	 */
	public int count(String tableName);
	
	/**
	 * F�hrt einen Datenbank befehl aus, der die Anzahl der Datens�tze der Tabelle ermittelt.
	 * Das WHERE-Statement wird als zus�tzliche Einschr�nkung angehangen.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param where			WHERE-Statement, um die Datens�tze einzuschr�nken.
	 * @return Anzahl der Datens�tze
	 */
	public int count(String tableName, String where);
	
	/**
	 * F�hrt einen Datenbank befehl aus, der die Anzahl der Datens�tze der Tabelle ermittelt.
	 * Zus�tzlich wird ein WHERE-Statement generiert, welches an den Datenbank-Befehl angehangen wird.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param key			Name der Spalte
	 * @param operator		Vergleichoperator
	 * @param value			Wert
	 * @return Anzahl der Datens�tze die eine Bestimmte Bedingung erf�llen.
	 */
	public int count(String tableName, String key, String operator, String value);
	
	/**
	 * L�scht alle Datens�tze, welche die Bedingung erf�llen.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param where			WHERE-Statement, um die Datens�tze einzuschr�nken.
	 */
	public void delete(String tableName, String where);
	
	/**
	 * L�scht alle Datens�tze, welche die Bedingung erf�llen.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param key			Name der Spalte
	 * @param operator		Vergleichoperator
	 * @param value			Wert
	 */
	public void delete(String tableName, String key, String operator, String value);
	
	/**
	 * L�scht alle Datens�tze, welche die Bedingung erf�llen.
	 * Mehrere Bedingungen m�glich, die mit = Verglichen werden.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param field			Vergleichswerte (Attribut1 = Attribut2)
	 */
	public void delete(String tableName, HashMap<String, Object> field);
	
	/**
	 * Setzt den Wert der durch das WHERE-Statement erf�llten Datens�tze.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param where			WHERE-Statement
	 * @param key			Name der Spalte
	 * @param value			Wert
	 */
	public void update(String tableName, Object where, String key, String value);
	
	/**
	 * Setzt die Werte der HashMap fields in den Datens�tzen. Es
	 * wird ein zus�tzliches WHERE-Statement generiert, welches aus den Werten der
	 * HashMap whereFields generiert wird.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param whereFields 	Felder, aus denen das WHERE-Statement generiert wird
	 * @param fields		Felder, die f�r die Datens�tze gesetzt werden sollen.
	 */
	public void update(String tableName, HashMap<String, Object> whereFields, HashMap<String, Object> fields);

}
