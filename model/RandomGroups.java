import java.util.ArrayList;
import java.util.Random;

public class RandomGroups 
{
	// Deklaration der Variablen
	private static ArrayList<Group> allGroups;

	// Zufällige Studenten aus einer Studierenden Klasse
	public static Object getRandomObjectByGroup(Group studentClass) 
	{
		Random rnd = new Random();
		int rndStudent = rnd.nextInt(studentClass.getMembers().size());
		
		Object p = studentClass.getMembers().get(rndStudent);
		
		return p;
	}
	
	/* Erstellen einer zufälligen Gruppe aus allen Klassen
	 * HAUPTMETHODE FÜR AUFRUF
	 *	 Benutzung:
	 *		 mode:		STRING  für Auswahl von Erstellung nach Größe ("size"), oder Anzahl("count") der Gruppen
	 *		 modifier:	Gibt je nach "mode" die Größe der zu generierenden Gruppen oder deren Anzahl an
	 */
	public static ArrayList<Group> createRandomGroups(String mode, int modifier, ArrayList<StudentClass> classes) 
	{
		// Zähler für die Gruppenerstellung
		int i = 0;
		
		// Initialisierung der Gruppenvariabe
		Group[] grp = new Group[classes.size()];
		
		// Klassen in die Gruppenvariable speichern
		for(int x = 0 ; x < classes.size() ; x++)
		{
			grp[x] = classes.get(x);
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
	

}
