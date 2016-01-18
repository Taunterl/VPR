/**
 * @author ibd2h14bel
 * /

package model;

import java.util.ArrayList;
import java.util.HashMap;
import db.DatabaseSQLite;

public class ClassPool
{
	
	public static final String TABLE_NAME = "Klassen";
	
	private static final String  CLASS_ID = "Klassenbezeichnung";
	private static final String CLASS_PROFESSOR = "Klassendozent";
	
		
	private ArrayList<StudentClass> list;
	// Standort BI/PB
	private String location; 
	
	public ClassPool(String location) {
		//
		this.list = this.getByClassID(location);
		this.location = location;
		
	}
	
	// liefert die gesamte Klassenliste zurück
	public ArrayList<StudentClass> getClassList()
	{
		return this.list;
	}
	
	// liefert den Standort des Pools
	public String getLocation()
	{
		return this.location;
	}

	// Methode um eine Klasse in die Datenbank zu schreiben
	public void addClass(StudentClass studentClass)
	{		
			
			if (classIsUniqueCheck(studentClass.getClassName()))
			{				
				// Klasse wird in der ArrayList gespeichert
				list.add(studentClass);
				// Klasse wird in die Datenbank gespeichert
				studentClass.save();
			} 
			else
			{
				System.out.print("Die Klasse ist bereits vorhanden.");
			} 
	}

	// Methode 
	public void deleteClass(String className)
	{
		boolean check=false;
		// Es wird durch die gesamte Klassenliste gelaufen
		for(int i = 0;i<this.list.size();i++)
		{
			// bei einem Treffer wird die Klasse aus der DB gelöscht
			if(className.contains(this.list.get(i).getClassName()))
			{
				list.get(i).delete();
				check=true;
				break;
			}
		}
		// Wenn die Klasse nicht in der Liste gefunden wurde, wird eine Fehlermeldung ausgegeben.
		if(check == false)
		{
			System.out.println("Die Klasse wurde nicht gefunden.");
		}
	}

	public void importFromExcel() {
		//
	}

	public void importFromCSV() {
		//
	}
	
	// Methode zum Überprüfen der Einzigartigkeit einer Klasse
	public boolean classIsUniqueCheck(String className) {
		boolean check=true;
		for(int i=0; i<list.size();i++)
		{
			if(className.contains(list.get(i).getClassName()))
			{
				check = false;
			}
		}
		return check;
	}
	
	/* Methode holt alle Klassen aus der Datenbank,
	 * die der Where-Klausel enstsprechen.
	 * Wenn die Where-Klausel leer ist,
	 * werden alle Klassen aus der Datenbank geladen.
	 * Daten werden in einer ArrayList zurück gegeben.
	 */
	private static ArrayList<StudentClass> getByAttribute(String where)
	{
		ArrayList<HashMap<String,Object>> entries = DatabaseSQLite.getInstance().get(TableName,where);
		ArrayList<StudentClass> studentClasses = new ArrayList<>();
		for(int i=0;i<entries.size();i++)
		{
			StudentClass studentClass = new StudentClass(null,null); 
			studentClass.setClassName((String)entries.get(i).get(CLASS_ID));
			studentClass.setProfessor((Professor)entries.get(i).get(CLASS_PROFESSOR));
			studentClasses.add(studentClass);
		}
		return studentClasses;
	}
	
	// holt alle Klassen aus der Datenbank
	public static ArrayList<StudentClass> get()
	{
		return getByAttribute("");
	}
	
	// holt alle Klassen aus der Datenbank mit der gegebenen id
	public static ArrayList<StudentClass> getByClassID(String id)
	{
		String where = ClassID + " LIKE '" + id + "'";
		return getByAttribute(where);
	}
	
	// holt alle Klassen anhand des Klassendozenten aus der Datenbank
	public static ArrayList<StudentClass> getByClassProfessor(String name)
	{
		String where = ClassProfessor + " LIKE '" + name + "'";
		return getByAttribute(where);
	}
}
