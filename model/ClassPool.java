package model;

import java.util.ArrayList;
import java.util.HashMap;
import db.DatabaseSQLite;

public class ClassPool {
	
	public static final String TableName = "Klassen";
	
	private static final String  ClassID = "Klassenbezeichnung";
	private static final String ClassProfessor = "Klassendozent";
	
		
	private ArrayList<StudentClass> list;
	private String location; // Standort BI/PB

	public ClassPool(String location) {
		//
		this.list = new ArrayList<>();
		this.location = location;
	}
	public String getLocation()
	{
		return this.location;
	}

	public void addClass(StudentClass studentClass)
	{
			if (classIsUniqueCheck(studentClass.getClassName()))
			{				
				list.add(studentClass);
				studentClass.save();
				
			} 
			else
			{
				System.out.print("Die Klasse ist bereits vorhanden.");
			} 
	}

	public void deleteClass(String className)
	{
		boolean check=false;
		//Es wird durch die gesamte Klassenliste gelaufen
		for(int i = 0;i<this.list.size();i++)
		{
			//bei einem Treffer wird die Klasse aus der DB gelöscht
			if(className.contains(this.list.get(i).getClassName()))
			{
				list.get(i).delete();
				check=true;
				break;
			}
		}
		//Wenn die Klasse nicht in der Liste gefunden wird, wird eine Fehlermeldung ausgegeben.
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
	private static ArrayList<StudentClass>getByAttribute(String where)
	{
		ArrayList<HashMap<String,Object>> entries = DatabaseSQLite.getInstance().get(TableName,where);
		ArrayList<StudentClass> studentClasses = new ArrayList<>();
		for(int i=0;i<entries.size();i++)
		{
			StudentClass studentClass = new StudentClass(null,null);
			studentClass.setClassName((String)entries.get(i).get(ClassID));
			studentClass.setProfessor((Professor)entries.get(i).get(ClassProfessor));
			studentClasses.add(studentClass);
		}
		return studentClasses;
	}
	public static ArrayList<StudentClass> get()
	{
		return getByAttribute("");
	}
	public static ArrayList<StudentClass> getByClassID(String id)
	{
		String where = ClassID + " LIKE '" + id + "'";
		return getByAttribute(where);
	}
	public static ArrayList<StudentClass> getByClassProfessor(String name)
	{
		String where = ClassProfessor + " LIKE '" + name + "'";
		return getByAttribute(where);
	}
}
