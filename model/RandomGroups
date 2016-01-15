import java.util.ArrayList;

public class RandomGroups 
{
	// Deklaration der Variablen
	private static ArrayList<Group> allGroups;
	private static ArrayList<Group> studentClasses;	
	
	// Set-Methode für die privaten Methoden
	public static void setAllStudents(String[] classes)
	{
		studentClasses.add(new Group());
		studentClasses.get(0).getMembers.add();
	}
	
	// Zufällige Studenten aus einer Studierenden Klasse
	public static Student getRandomObjectByGroup(Group studentClass) 
	{
		Random rnd = new Random();
		int rndStudent = rnd.nextInt(studentClass.members.size());
		
		Student p = studentClass.members.get(rndStudent)
		
		return p;
	}
	
	// Erstellen einer zufälligen Gruppe aus allen Klassen
	// HAUPTMETHODE FÜR AUFRUF
		// Benutzung:
			// mode:		STRING  für Auswahl von Erstellung nach Größe ("size"), oder Anzahl("count") der Gruppen
			// modifier:	Gibt je nach "mode" die Größe der zu generierenden Gruppen oder deren Anzahl an
	public static ArrayList<Group> createRandomGroups(String mode, int modifier, Group[] grp) 
	{
		// Zähler für die Gruppenerstellung
		int i = 0;
		/*
		 * referenz der studentClasses benutzen
		 * setAllStudents()
		 * SQL abfragen nach klassen -> Studenten in klassen schreiben
		 */
		if(mode.equals("count") && modifier > 0)
		{
			
			for(int j = 0 ; j < modifier ; j++)
				this.allGroups.add(new Group());
			
			for(int  j = 0 ; j < grp.length ; j++)
				while(grp[j].members.size>0)
				{
					this.allGroups.get(i).addObject(grp[j].removeObject(getRandomObjectByGroup(grp[j])));
					i++;
					if(i==modifier)
						i=0;
	
				}
		}
		else if(mode.equals("size") && modifier > 0)
		{
			int objectCount;
			for(int j = 0 ; j < grp.length ; j++)
			{
				objectCount += grp[j].size();
			}
			
			for(int j = 0 ; j < (objectCount/modifier+1) ; j++)
				this.allGroups.add(new Group());
			
			for(int  j = 0 ; j < grp.length ; j++)
				while(grp[j].members.size>0)
				{
					this.allGroups.get(i).addObject(grp[j].removeObject(getRandomObjectByGroup(grp[j])));
					i++;
					if(i==modifier)
						i=0;
				}
		}
		return allGroups;
	}
	

}
