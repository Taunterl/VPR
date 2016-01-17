package db;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Das Interface <code>IDatabase</code> kann von Datenbanken wie SQLite oder Oracle benutzt werden.
 * Es schreibt einige Methoden zur Ausführung von Basis-Operationen auf der entsprechenden Datenbank vor.
 * 
 * @author Cornelia Stussig
 */
public interface IDatabase {
	
	/**
	 * Fügt einen vollständigen Datensatz auf Basis der übergebenen
	 * Parameter in die Datenbank ein.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param fields		Mapping der Datenbankfelder als HashMap
	 */
	public void insert(String tableName, HashMap<String, Object> fields);
	
	/**
	 * Liefert alle Datensätze der angegeben Tabelle.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @return Arrylist in der jeder Datensatz durch eine HashMap repräsentiert wird sind.
	 */
	public ArrayList<HashMap<String, Object>> get(String tableName);
	
	/**
	 * Liefert Datensätze der angegeben Tabelle, die für das angegebene WHERE-Statement gültig sind.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param where			WHERE-Statement, um die Datensätze einzuschränken.
	 * @return Arrylist in der jeder Datensatz durch eine HashMap repräsentiert wird sind.
	 */
	public ArrayList<HashMap<String, Object>> get(String tableName, String where);
	
	/**
	 * Liefert Datensätze der angegeben Tabelle. Zusätzlich wird ein
	 * WHERE-Statement aus den Paramtern key, operator und value ({@link java.lang.String}) generiert.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param key			Name der Spalte
	 * @param operator		Vergleichoperator
	 * @param value			Wert
	 * @return Arrylist in der jeder Datensatz durch eine HashMap repräsentiert wird sind.
	 */
	public ArrayList<HashMap<String, Object>> get(String tableName, String key, String operator, String value);
	
	/**
	 * Liefert Datensätze der angegeben Tabelle. Zusätzlich wird ein
	 * WHERE-Statement aus den Paramtern key, operator und value ({@link int}) generiert.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param key			Name der Spalte
	 * @param operator		Vergleichoperator
	 * @param value			Wert
	 * @return Arrylist in der jeder Datensatz durch eine HashMap repräsentiert wird sind.
	 */
	public ArrayList<HashMap<String, Object>> get(String tableName, String key, String operator, int value);
	
	/**
	 * Liefert Datensätze der angegeben Tabelle. Zusätzlich wird ein
	 * WHERE-Statement aus der übergebenen HashMap generiert.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param fields 		Vergleichswerte (Atribut1 = Atribut2) 
	 * @return Arrylist in der jeder Datensatz durch eine HashMap repräsentiert wird sind.
	 */
	public ArrayList<HashMap<String, Object>> get(String tableName, HashMap<String, Object> fields);
	
	/**
	 * Führt einen Datenbank befehl aus, der die Anzahl der Datensätze der Tabelle ermittelt.
	 * 
	 * @param tableName Name der Datenbanktabelle
	 * @return Anzahl der gesamten Datensätze die in der Tabelle vorhanden sind
	 */
	public int count(String tableName);
	
	/**
	 * Führt einen Datenbank befehl aus, der die Anzahl der Datensätze der Tabelle ermittelt.
	 * Das WHERE-Statement wird als zusätzliche Einschränkung angehangen.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param where			WHERE-Statement, um die Datensätze einzuschränken.
	 * @return Anzahl der Datensätze
	 */
	public int count(String tableName, String where);
	
	/**
	 * Führt einen Datenbank befehl aus, der die Anzahl der Datensätze der Tabelle ermittelt.
	 * Zusätzlich wird ein WHERE-Statement generiert, welches an den Datenbank-Befehl angehangen wird.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param key			Name der Spalte
	 * @param operator		Vergleichoperator
	 * @param value			Wert
	 * @return Anzahl der Datensätze die eine Bestimmte Bedingung erfüllen.
	 */
	public int count(String tableName, String key, String operator, String value);
	
	/**
	 * Löscht alle Datensätze, welche die Bedingung erfüllen.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param where			WHERE-Statement, um die Datensätze einzuschränken.
	 */
	public void delete(String tableName, String where);
	
	/**
	 * Löscht alle Datensätze, welche die Bedingung erfüllen.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param key			Name der Spalte
	 * @param operator		Vergleichoperator
	 * @param value			Wert
	 */
	public void delete(String tableName, String key, String operator, String value);
	
	/**
	 * Löscht alle Datensätze, welche die Bedingung erfüllen.
	 * Mehrere Bedingungen möglich, die mit = Verglichen werden.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param field			Vergleichswerte (Attribut1 = Attribut2)
	 */
	public void delete(String tableName, HashMap<String, Object> field);
	
	/**
	 * Setzt den Wert der durch das WHERE-Statement erfüllten Datensätze.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param where			WHERE-Statement
	 * @param key			Name der Spalte
	 * @param value			Wert
	 */
	public void update(String tableName, Object where, String key, String value);
	
	/**
	 * Setzt die Werte der HashMap fields in den Datensätzen. Es
	 * wird ein zusätzliches WHERE-Statement generiert, welches aus den Werten der
	 * HashMap whereFields generiert wird.
	 * 
	 * @param tableName		Name der Datenbanktabelle
	 * @param whereFields 	Felder, aus denen das WHERE-Statement generiert wird
	 * @param fields		Felder, die für die Datensätze gesetzt werden sollen.
	 */
	public void update(String tableName, HashMap<String, Object> whereFields, HashMap<String, Object> fields);

}
