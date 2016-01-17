package db;

import java.util.HashMap;

/**
 * Abstrakte Klasse von der alle Objekte die in der Datenbak gespeichert werden erben sollten.
 * Sie �bernimmet das Einf�gen, L�schen und Bearbeiten von Datens�tzen.
 * 
 * @author Cornelia Stussig
 */
public abstract class DatabaseEntity {
	
	/**
	 * Enth�lt das Datenbank-Objekt �ber welches die Datenbank-Befehle ausgef�hrt werden.
	 */
	private IDatabase database;

	public DatabaseEntity(IDatabase database) {
		this.database = database;
	}
	
	/**
	 * Enth�lt die Information, ob das Objekt bereits in der Datenbank enthalten ist.
	 */
	protected boolean isInDB = false;
	
	/**
	 * Alle Objekte die von DatabaseEntity erben, k�nnen diese Methode zum Speichern nutzen.
	 * Sie pr�ft anhand des Attributs <code>isInDB</code>, ob das Objekt in der Datenbank bereits vorhanden ist.
	 * Sie verhindert damit, dass ein Objekt mehrfach gespeichert wird und f�hrt stattdessen einen UPDATE-Befehl aus.
	 */
	public void save() {
		if(isInDB) {
			update();
		} else {
			insert();
		}
	}

	/**
	 * Diese Methode wird ausschlie�lich in der Methode <code>save</code> aufgerufen.
	 * Sie setzt die <code>isInDB</code> Variable auf true um eine Mehrfachspeicherung zu verhindern.
	 */
	private void insert() {
		HashMap<String, Object> fields = getValueMap();
		database.insert(getTableName(), fields);
		isInDB = true;
	}

	/**
	 * Diese Methode wird ausschlie�lich in der Methode <code>save</code> aufgerufen.
	 * Sie braucht die PrimaryKeys (mehrere wenn Schl�ssel zusamgesetzt ist),
	 * damit der richtige Datensatz ge�ndert wird.
	 */	
	private void update(){
		HashMap<String, Object> primaryKeyFields = getPrimaryKey();
		HashMap<String, Object> fields = getValueMap();
		database.update(getTableName(), primaryKeyFields, fields);	
	}

	/**
	 * Alle Objekte die von DatabaseEntity erben, benutzen diese Methode zum L�schen des Datensatzes.
	 * Sie setzt die <code>isInDB</code> Variable wieder auf false um zu zeigen, dass das Objekt nicht mehr Teil der Datenbank ist.
	 */
	public void delete(){
		HashMap<String, Object> fields = getPrimaryKey();
		database.delete(getTableName(), fields);	
		isInDB = false;
	}
	
	/**
	 * Abstrakte Methode muss von ihren Unterklassen �bernommen und gef�llt werden.
	 * 
	 * @return HashMap alle Attribute, die von dieser Klasse als Spalten der Datenbanktabelle betrachtet werden sollen.
	 */
	protected abstract HashMap<String, Object> getValueMap();
	
	/**
	 * Abstrakte Methode muss von ihren Unterklassen �bernommen und gef�llt werden.
	 * 
	 * @return HashMap alle Attribute, die von dieser Klasse als Prim�rschl�ssel der Datenbanktabelle betrachtet werden sollen.
	 */
	protected abstract HashMap<String, Object> getPrimaryKey();
	
	/**
	 * Abstrakte Methode muss von ihren Unterklassen �bernommen und gef�llt werden.
	 * 
	 * @return den Namen der Tabelle, auf der operiert wird.
	 */
	protected abstract String getTableName();
		
}
