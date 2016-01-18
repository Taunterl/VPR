package db;

import java.util.HashMap;

/**
 * Abstrakte Klasse von der alle Objekte die in der Datenbak gespeichert werden erben sollten.
 * Sie übernimmet das Einfügen, Löschen und Bearbeiten von Datensätzen.
 * 
 * @author Cornelia Stussig
 */
public abstract class DatabaseEntity {
	
	/**
	 * Enthält das Datenbank-Objekt über welches die Datenbank-Befehle ausgeführt werden.
	 */
	private IDatabase database;

	public DatabaseEntity(IDatabase database) {
		this.database = database;
	}
	
	/**
	 * Enthält die Information, ob das Objekt bereits in der Datenbank enthalten ist.
	 */
	protected boolean isInDB = false;
	
	/**
	 * Alle Objekte die von DatabaseEntity erben, können diese Methode zum Speichern nutzen.
	 * Sie prüft anhand des Attributs <code>isInDB</code>, ob das Objekt in der Datenbank bereits vorhanden ist.
	 * Sie verhindert damit, dass ein Objekt mehrfach gespeichert wird und führt stattdessen einen UPDATE-Befehl aus.
	 */
	public void save() {
		if(isInDB) {
			update();
		} else {
			insert();
		}
	}

	/**
	 * Diese Methode wird ausschließlich in der Methode <code>save</code> aufgerufen.
	 * Sie setzt die <code>isInDB</code> Variable auf true um eine Mehrfachspeicherung zu verhindern.
	 */
	private void insert() {
		HashMap<String, Object> fields = getValueMap();
		database.insert(getTableName(), fields);
		isInDB = true;
	}

	/**
	 * Diese Methode wird ausschließlich in der Methode <code>save</code> aufgerufen.
	 * Sie braucht die PrimaryKeys (mehrere wenn Schlüssel zusamgesetzt ist),
	 * damit der richtige Datensatz geändert wird.
	 */	
	private void update(){
		HashMap<String, Object> primaryKeyFields = getPrimaryKey();
		HashMap<String, Object> fields = getValueMap();
		database.update(getTableName(), primaryKeyFields, fields);	
	}

	/**
	 * Alle Objekte die von DatabaseEntity erben, benutzen diese Methode zum Löschen des Datensatzes.
	 * Sie setzt die <code>isInDB</code> Variable wieder auf false um zu zeigen, dass das Objekt nicht mehr Teil der Datenbank ist.
	 */
	public void delete(){
		HashMap<String, Object> fields = getPrimaryKey();
		database.delete(getTableName(), fields);	
		isInDB = false;
	}
	
	/**
	 * Abstrakte Methode muss von ihren Unterklassen übernommen und gefüllt werden.
	 * 
	 * @return HashMap alle Attribute, die von dieser Klasse als Spalten der Datenbanktabelle betrachtet werden sollen.
	 */
	protected abstract HashMap<String, Object> getValueMap();
	
	/**
	 * Abstrakte Methode muss von ihren Unterklassen übernommen und gefüllt werden.
	 * 
	 * @return HashMap alle Attribute, die von dieser Klasse als Primärschlüssel der Datenbanktabelle betrachtet werden sollen.
	 */
	protected abstract HashMap<String, Object> getPrimaryKey();
	
	/**
	 * Abstrakte Methode muss von ihren Unterklassen übernommen und gefüllt werden.
	 * 
	 * @return den Namen der Tabelle, auf der operiert wird.
	 */
	protected abstract String getTableName();
		
}
