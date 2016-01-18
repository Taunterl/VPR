package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Die Klasse DatabaseOracle implementiert das Interface {@link db.IDatabase IDatabase}.
 * 
 * Die Klasse implementiert das Singleton-Pattern, sodass es jederzeit nur eine einzige
 * Instanz dieser Klasse geben kann.
 * 
 * DatabaseOracle stellt die Verbingung zu einer Oracle-Datenbank her unt kann dadurch
 * in den aus {@link db.IDatabase IDatabase} implementierten Methoden darauf zugreifen.
 * 
 * @author Cornelia Stussig
 * 
 */
public class DatabaseOracle implements IDatabase {
	
	/**
	 * Legt die Konstante der Datenbank Treibers fest.
	 */
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	/**
	 * Enthält das Connection-Objekt, welches zur Kommunikation mit der Datenbank benutzt wird.
	 */
	private Connection connection = null;

	/**
	 * Enthält die einzige Instanz der Klasse
	 */
	private static DatabaseOracle instance;

	/**
	 * Die Methode erstellt bei Bedarf die einzige Instanz der Klasse und liefert diese zurück.
	 * 
	 * @return die einzige Instanz der Klasse.
	 */
	public static DatabaseOracle getInstance() {
		if (instance == null) {
			instance = new DatabaseOracle();
		}
		return instance;
	}

	/**
	 * Nicht öffentlicher Konstruktor. Instanzierung übernimmt die Klasse selbst.
	 */
	private DatabaseOracle() {

	}

	/**
	 * Verbindung mit der Datenbank aufbauen.
	 * 
	 * @param url / Uniform Resource Locator
	 * @param user	/Benutzer
	 * @param pwd	/Password
	 */
	public void connect(String url, String user, String pwd) {
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(url, user, pwd);
			System.out.println("Opened database successfully...");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see db.IDatabase#insert(java.lang.String, java.util.HashMap)
	 */
	@Override
	public void insert(String tableName, HashMap<String, Object> fields) {
		String keys = "";
		String values = "";
		for (String key : fields.keySet()) {
			Object value = fields.get(key);
			if (!keys.equals("")) {
				keys += ",";
			}
			keys += key;
			if (!values.equals("")) {
				values += ",";
			}
			if (value instanceof String) {
				values += "'" + value + "'";
			} else if (value instanceof Integer) {
				values += value;
			}
		}
		String sql = "INSERT INTO " + tableName + " (" + keys + ")" + " VALUES (" + values + ");";
		try {
			executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see db.IDatabase#get(java.lang.String)
	 */
	@Override
	public ArrayList<HashMap<String, Object>> get(String tableName) {
		String sql = "SELECT * FROM " + tableName + ";";
		ArrayList<HashMap<String, Object>> result = internalGet(sql);

		return result;
	}

	/* (non-Javadoc)
	 * @see db.IDatabase#get(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<HashMap<String, Object>> get(String tableName, String where) {
		String sql = null;
		if(where == null || where.equals("")) {
			sql = "SELECT * FROM " + tableName + ";";
		} else {
			sql = "SELECT * FROM " + tableName + " WHERE " + where + ";";
		}
		ArrayList<HashMap<String, Object>> result = internalGet(sql);

		return result;
	}

	/* (non-Javadoc)
	 * @see db.IDatabase#get(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<HashMap<String, Object>> get(String tableName, String key, String operator, String value) {
		String sql = "SELECT * FROM " + tableName + " WHERE " + key + " " + operator + " '" + value + "';";
		ArrayList<HashMap<String, Object>> result = internalGet(sql);

		return result;
	}

	/* (non-Javadoc)
	 * @see db.IDatabase#get(java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public ArrayList<HashMap<String, Object>> get(String tableName, String key, String operator, int value) {
		String sql = "SELECT * FROM " + tableName + " WHERE " + key + " " + operator + " " + value + ";";
		ArrayList<HashMap<String, Object>> result = internalGet(sql);

		return result;
	}

	/* (non-Javadoc)
	 * @see db.IDatabase#get(java.lang.String, java.util.HashMap)
	 */
	@Override
	public ArrayList<HashMap<String, Object>> get(String tableName, HashMap<String, Object> fields) {
		String where = "";
		for (String key : fields.keySet()) {
			if (!where.equals("")) {
				where += " AND ";
			}
			where += key + " = ";
			if (fields.get(key) instanceof String) {
				where += "'" + fields.get(key) + "'";
			} else if (fields.get(key) instanceof Integer) {
				where += fields.get(key);
			}
		}

		String sql = "SELECT * FROM " + tableName + " WHERE " + where + ";";		
		ArrayList<HashMap<String, Object>> result = internalGet(sql);

		return result;
	}

	/**
	 * Führt ein SELECT-Statement auf der Datenbank aus.
	 * 
	 * @param sql SQL-Befehl
	 * @return	Ergebniss aus der Datenbank wird als ArrayLists aus
	 * HashMaps übergeben. 
	 */
	private ArrayList<HashMap<String, Object>> internalGet(String sql) {
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		try {
			Statement stmt = connection.createStatement();
			System.out.println(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				HashMap<String, Object> entry = new HashMap<String, Object>();
				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					String columnLabel = resultSet.getMetaData().getColumnLabel(i);
					Object returnvalue = resultSet.getObject(columnLabel);
					entry.put(columnLabel, returnvalue);
				}
				result.add(entry);
			}
			System.out.println("\tfetched " + result.size() + " rows");
			resultSet.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see db.IDatabase#count(java.lang.String)
	 */
	@Override
	public int count(String tableName) {
		String sql = "SELECT COUNT (*) FROM " + tableName + ";";
		int result = internalCount(sql);

		return result;
	}

	/* (non-Javadoc)
	 * @see db.IDatabase#count(java.lang.String, java.lang.String)
	 */
	@Override
	public int count(String tableName, String where) {
		String sql = "SELECT COUNT (*) FROM " + tableName + " WHERE " + where + ";";
		int result = internalCount(sql);
		return result;
	}

	/* (non-Javadoc)
	 * @see db.IDatabase#count(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int count(String tableName, String key, String operator, String value) {
		String sql = "SELECT COUNT (*) FROM " + tableName + " WHERE " + key + " " + operator + " " + value + ";";
		int result = internalCount(sql);
		return result;
	}

	/**
	 * Führt einen SELECT-Befehl auf der Datenbank aus. Es wird erwartet, dass das Ergebnis des SELECT-Befehls nur
	 * einen Datensatz mit einer Spalte zurückliefert, in dem die Anzahl der gefundenen Datensätze steht.
	 * Bsp.: SELECT COUNT(*) FROM some_table;
	 * 
	 * @param sql SQL Befehl wird der Datenbank übergeben.
	 * @return Ergebniss (Int) aus der Datenbank wird übergeben
	 */
	private int internalCount(String sql) {
		int result = 0;
		try {
			Statement stmt = connection.createStatement();
			System.out.println(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			if(resultSet.next()){
				result = resultSet.getInt(1);
			}
			System.out.println(result);
			resultSet.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see db.IDatabase#delete(java.lang.String, java.lang.String)
	 */
	@Override
	public void delete(String tableName, String where) {
		String sql = "DELETE FROM " + tableName + " WHERE " + where + ";";
		try {
			executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see db.IDatabase#delete(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void delete(String tableName, String key, String operator, String value) {
		String sql = "DELETE FROM " + tableName + " WHERE " + key + " " + operator + " " + value + ";";
		try {
			executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see db.IDatabase#delete(java.lang.String, java.util.HashMap)
	 */
	@Override
	public void delete(String tableName, HashMap<String, Object> fields) {
		String where = "";
		for (String key : fields.keySet()) {
			if (!where.equals("")) {
				where += " AND ";
			}
			where += key + " = ";
			if (fields.get(key) instanceof String) {
				where += "'" + fields.get(key) + "' ";
			} else if (fields.get(key) instanceof Integer) {
				where += fields.get(key) + " ";
			}
		}

		String sql = "DELETE FROM " + tableName + " WHERE " + where + ";";
		try {
			executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see db.IDatabase#update(java.lang.String, java.lang.Object, java.lang.String, java.lang.String)
	 */
	@Override
	public void update(String tableName, Object where, String key, String value) {
		String sql = "UPDATE " + tableName + " SET " + key + " = " + value + " WHERE " + where + ";";
		try {
			executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see db.IDatabase#update(java.lang.String, java.util.HashMap, java.util.HashMap)
	 */
	@Override
	public void update(String tableName, HashMap<String, Object> whereFields, HashMap<String, Object> fields) {
		String set = "";
		for (String key : fields.keySet()) {
			if (!set.equals("")) {
				set += " , ";
			}
			set += key + " = ";
			if (fields.get(key) instanceof String) {
				set += "'" + fields.get(key) + "' ";
			} else if (fields.get(key) instanceof Integer) {
				set += fields.get(key) + " ";
			}
		}
		String where = "";
		for (String key : whereFields.keySet()) {
			if (!where.equals("")) {
				where += " AND ";
			}
			where += key + " = ";
			if (whereFields.get(key) instanceof String) {
				where += "'" + whereFields.get(key) + "' ";
			} else if (whereFields.get(key) instanceof Integer) {
				where += whereFields.get(key) + " ";
			}
		}

		String sql = "UPDATE " + tableName + " SET " + set + " WHERE " + where + ";";
		try {
			executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Führt ein INSERT-, UPDATE- oder DELETE-Statement auf der Datenbank aus.
	 * 
	 * @param sql	Das SQL-Statment
	 * @throws SQLException
	 */
	private void executeUpdate(String sql) throws SQLException {
		Statement stmt = connection.createStatement();

		System.out.println(sql);
		
		int rowCount = stmt.executeUpdate(sql);

		System.out.println("\taffected " + rowCount + " rows");
		
		stmt.close();
	}

	/**
	 * Schliest die Verbindung zur Datenbank.
	 */
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
