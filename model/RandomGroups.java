import java.util.ArrayList;
import java.util.Random;

public class RandomGroups 
{
	// Deklaration der Variablen
	private static ArrayList<Group> allGroups;

	// Zufaellige Studenten aus einer Studierenden Klasse
	public static Object getRandomObjectByGroup(Group studentClass) 
	{
		Random rnd = new Random();
		int rndStudent = rnd.nextInt(studentClass.getMembers().size());
		
		Object p = studentClass.getMembers().get(rndStudent);
		
		return p;
	}
	
	/* Erstellen einer zufaelligen Gruppe aus allen Klassen
	 * HAUPTMETHODE FUER AUFRUF
	 *	 Benutzung:
	 *		 mode:		STRING  für Auswahl von Erstellung nach Groeße ("size"), oder Anzahl("count") der Gruppen
	 *		 modifier:	Gibt je nach "mode" die Groeße der zu generierenden Gruppen oder deren Anzahl an
	 */
	public static ArrayList<Group> createRandomGroups(String mode, int modifier, ArrayList<Object> classes) 
	{
		// Zaehler für die Gruppenerstellung
		int i = 0;
		
		// Initialisierung der Gruppenvariabe
		Group[] grp = new Group[classes.size()];
		
		// Klassen in die Gruppenvariable speichern
		for(int x = 0 ; x < classes.size() ; x++)
		{
			grp[x] = new Group((ArrayList<Object>)(classes.get(x)));
		}
		/*
		 * referenz der studentClasses benutzen
		 * setAllStudents()
		 * SQL abfragen nach klassen -> Studenten in klassen schreiben
		 */
		if(mode.equals("count") && modifier > 0)
		{
			
			for(int j = 0 ; j < modifier ; j++)
				allGroups.add(new Group());
			
			for(int  j = 0 ; j < grp.length ; j++)
				while(grp[j].getMembers().size()>0)
				{
					allGroups.get(i).addObject(grp[j].removeObject(getRandomObjectByGroup(grp[j])));
					i++;
					if(i==modifier)
						i=0;
	
				}
		}
		else if(mode.equals("size") && modifier > 0)
		{
			int objectCount = 0;
			for(int j = 0 ; j < grp.length ; j++)
			{
				objectCount += grp[j].getMembers().size();
			}
			
			for(int j = 0 ; j < (objectCount/modifier+1) ; j++)
				allGroups.add(new Group());
			
			for(int  j = 0 ; j < grp.length ; j++)
				while(grp[j].getMembers().size()>0)
				{
					allGroups.get(i).addObject(grp[j].removeObject(getRandomObjectByGroup(grp[j])));
					i++;
					if(i==modifier)
						i=0;
				}
		}
		return allGroups;
	}
	/*
	 *  Waehlt einen Zufaelligen Studenten aus einer gegebenen Klasse aus
	 *  dafuer benutzen wir die selbe Methode, wie fuer die Gruppen erstellung
	 */
	public static Object getRandomStudent(ArrayList<StudentClass> classes)
	{
		Group grp = new Group();

		for(int x = 0 ; x < classes.size() ; x++)
		{
			for(int f = 0 ; f < classes.get(x).getStudentList().size() ; f++)
			{
				grp.getMembers().add(classes.get(x).getStudentList().get(f));
			}
		}
		
		return getRandomObjectByGroup(grp);
	}
	
}
