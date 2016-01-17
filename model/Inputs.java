package model;

import java.util.ArrayList;

public class Inputs {

	private static String loggedInAs;
	private static String location = "";
	private static int groupSize = 1;
	private static int groupCount = 1;
	private static boolean useGroupSize = true;
	private static ArrayList<StudentClass> selectedStudentClasses;
	
	public static String getLoggedInAs()
	{
		return loggedInAs;
	}
	
	public static String getLocation() {
		return location;
	}

	public static void setLocation(String location) {
		Inputs.location = location;
	}

	public static void setLoggedInAs(String loggedInAs) 
	{
		Inputs.loggedInAs = loggedInAs;
		System.out.println("Logged in as: "+Inputs.loggedInAs);
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
	
	public static void setGroupCount(int groupCount) {
		Inputs.groupCount = groupCount;
	}
	
	public static boolean isUseGroupSize() {
		return useGroupSize;
	}
	
	public static void setUseGroupSize(boolean useGroupSize) {
		Inputs.useGroupSize = useGroupSize;
	}
	
	public static ArrayList<StudentClass> getSelectedStudentClasses() {
		return selectedStudentClasses;
	}
	
	public static void addSelectedStudentClass(
			ArrayList<StudentClass> selectedStudentClasses) {
		Inputs.selectedStudentClasses.addAll(selectedStudentClasses);
	}
}
