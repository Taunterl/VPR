package model;

import java.util.ArrayList;
import java.util.HashMap;

import database.DatabaseSQLite;

public class Inputs {

	private static Professor loggedInAs;
	private static String location = "";
	private static ClassPool activeClassPool;
	private static int groupSize = 1;
	private static int groupCount = 1;
	private static boolean useGroupSize = true;
	private static ArrayList<StudentClass> selectedStudentClasses = new ArrayList<StudentClass>();
	private static ArrayList<Student> activeStudents = new ArrayList<Student>();
	private static ArrayList<Group> allGroups = new ArrayList<Group>();
	private static HashMap<String, Object> saveGroups = new HashMap<String, Object>();
	public static DatabaseSQLite database;
	
	public static Professor getLoggedInAs()
	{
		return loggedInAs;
	}
	
	public static String getLocation() {
		return location;
	}

	public static void setLocation(String location) {
		Inputs.location = location;
	}

	public static ClassPool getActiveClassPool() {
		return activeClassPool;
	}

	public static void setActiveClassPool() {
		Inputs.activeClassPool = new ClassPool(getLocation());
	}

	public static void setLoggedInAs(Professor loginAs) 
	{
		Inputs.loggedInAs = loginAs;
		System.out.println("Logged in as: "+Inputs.loggedInAs.getDozentenID());
	}
	
	public static int getGroupSize() 
	{
		return groupSize;
	}
	
	public static void setGroupSize(int groupSize) 
	{
		Inputs.groupSize = groupSize;
	}
	
	public static int getGroupCount() 
	{
		return groupCount;
	}
	
	public static void setGroupCount(int groupCount) 
	{
		Inputs.groupCount = groupCount;
	}
	
	public static boolean isUseGroupSize() 
	{
		return useGroupSize;
	}
	
	public static void setUseGroupSize(boolean useGroupSize) 
	{
		Inputs.useGroupSize = useGroupSize;
	}
	
	public static ArrayList<StudentClass> getSelectedStudentClasses() 
	{
		return selectedStudentClasses;
	}
	
	public static void addSelectedStudentClass(
			ArrayList<StudentClass> selectedStudentClasses)
	{
		Inputs.selectedStudentClasses.addAll(selectedStudentClasses);
	}

	public static ArrayList<Student> getActiveStudents()
	{
		return activeStudents;
	}

	public static void setActiveStudents()
	{
		Inputs.activeStudents.clear();
		Inputs.activeStudents.add(new Student("ibw2h14akl", "Fabio", "Klement", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14aho", "Thomas", "Hooge", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14akl", "Fabio", "Klement", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14aho", "Thomas", "Hooge", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14akl", "Fabio", "Klement", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14aho", "Thomas", "Hooge", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14akl", "Fabio", "Klement", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14aho", "Thomas", "Hooge", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14akl", "Fabio", "Klement", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14aho", "Thomas", "Hooge", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14akl", "Fabio", "Klement", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14aho", "Thomas", "Hooge", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14akl", "Fabio", "Klement", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14aho", "Thomas", "Hooge", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14akl", "Fabio", "Klement", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14aho", "Thomas", "Hooge", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14akl", "Fabio", "Klement", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14aho", "Thomas", "Hooge", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14akl", "Fabio", "Klement", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14aho", "Thomas", "Hooge", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14akl", "Fabio", "Klement", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14aho", "Thomas", "Hooge", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14akl", "Fabio", "Klement", "dummy-user.jpg", "ibw2h14a"));
		Inputs.activeStudents.add(new Student("ibw2h14aho", "Thomas", "Hooge", "dummy-user.jpg", "ibw2h14a"));
		/*for(StudentClass c: Inputs.selectedStudentClasses)
		{
			c.getStudentList().addAll(Inputs.activeStudents);
		}*/
		
	}

	public static ArrayList<Group> getAllGroups() {
		return allGroups;
	}

	public static void setAllGroups(ArrayList<Group> allGroups) {
		Inputs.allGroups = allGroups;
	}

	public static HashMap<String, Object> getSaveGroups() {
		return saveGroups;
	}

	public static void setSaveGroups(HashMap<String, Object> saveGroups) {
		Inputs.saveGroups = saveGroups;
	}
}
