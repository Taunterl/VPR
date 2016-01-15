package model;

import java.util.ArrayList;
import java.util.HashMap;

import db.DatabaseEntitySQLite;

public class StudentClass extends DatabaseEntitySQLite
{	
	public static final String TableName = "Klassen";
	
	private static final String  ClassID = "Klassenbezeichnung";
	private static final String NumberOfStudents = "AnzahlSchüler";
	private static final String ClassProfessor = "Klassendozent";
	
	private ArrayList<Student> studentList;
	private String className;
	private Professor professor;
	
	public StudentClass(String className,Professor professor)
	{
	this.studentList=new ArrayList<>();
	this.className= className;
	this.professor=professor;
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public void addStudent(Student student)
	{
		if(StudentIsUniqueCheck(student))
		{
			this.studentList.add(student);
		}
	}
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
	@Override	
	protected HashMap<String,Object> getValueMap()
	{
	HashMap<String,Object> fields = new HashMap<String,Object>();
	fields.put(ClassID,this.className);
	fields.put(NumberOfStudents, this.studentList.size());
	fields.put(ClassProfessor,this.professor);
	return fields;
	}
	@Override
	protected String getTableName()
	{
		return TableName;
	}
	@Override
	protected HashMap<String,Object> getPrimaryKey()
	{
		HashMap<String,Object> fields = new HashMap<String,Object>();
		fields.put(ClassID, this.className);
		return fields;
	}
}
