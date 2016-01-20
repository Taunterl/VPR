/**
 * @author ibd2h14bel
*/
package model;

import java.util.ArrayList;
import java.util.HashMap;

import database.DatabaseEntity;
import database.DatabaseSQLite;

public class StudentClass extends DatabaseEntity
{	
	public static final String TABLE_NAME = "Klassen";
	
	private static final String  CLASS_ID = "Klassenbezeichnung";
	private static final String NUMBER_OF_STUDENTS = "AnzahlSchüler";
	private static final String CLASS_PROFESSOR = "Klassendozent";
	
	private ArrayList<Student> studentList;
	private String className;
	private Professor professor;
	
	
	public StudentClass(String className,Professor professor)
	{
		super(DatabaseSQLite.getInstance());
		this.studentList=new ArrayList<>();
		this.className= className;
		this.professor=professor;
	}
	
	// gibt die Studenten liste zurück
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	// setzt die Studentenlist
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	// gibt die Klassenbezeichnung zurück
	public String getClassName() {
		return className;
	}
	
	// ändert den Klassennamen
	public void setClassName(String className) {
		this.className = className;
	}
	
	// gibt den Klassendozenten zurück
	public Professor getProfessor() {
		return professor;
	}
	
	// ändert den Klassendozenten
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	// fügt einen Studenten in die Klassenliste hinzu
	public void addStudent(Student student)
	{
		if(StudentIsUniqueCheck(student))
		{
			this.studentList.add(student);
		}
	}
	
	// prüft den Studenten auf seine Einzigartigkeit
	public boolean StudentIsUniqueCheck(Student student)
	{
		boolean check=true;
		for(int i=0;i<studentList.size();i++)
		{
			if(studentList.get(i).getStudentName().equals(student.getStudentName()))
			{
				check = false;
			}
		}
		if(check = false)
		{
			System.out.println("Der Student ist bereits in der Klasse gespeichert!");
		}
		return check;
	}
	
	// gibt die Daten der Klasse als Hashmap zurück
	@Override	
	protected HashMap<String,Object> getValueMap()
	{
	HashMap<String,Object> fields = new HashMap<String,Object>();
	fields.put(ClassID,this.className);
	fields.put(NumberOfStudents, this.studentList.size());
	fields.put(ClassProfessor,this.professor);
	return fields;
	}
	
	/* gibt den Tabellennamen in den gespeichert werden soll,
	*  zurück
	*/
	@Override
	protected String getTableName()
	{
		return TABLE_NAME;
	}
	
	// gibt den Primärschlüssel der Tabelle zurück
	@Override
	protected HashMap<String,Object> getPrimaryKey()
	{
		HashMap<String,Object> fields = new HashMap<String,Object>();
		fields.put(CLASS_ID, this.className);
		return fields;
	}
}
