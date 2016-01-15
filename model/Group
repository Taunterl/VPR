import java.util.ArrayList;

public class Group 
{
	// Deklaration der statischen Variablen
	private static int idCounter=0;
	
	//	...Membervariablen
	private int groupID;
	private ArrayList<Object> members;
	
	// Initialisierung der Variablen, mittels Konstruktor
	public Group()
	{
		this.members = new ArrayList<>();
		this.groupID= idCounter;
		idCounter++;
	}
	
	public Group(ArrayList<Object> members)
	{
		this.members = members;
		this.groupID= idCounter;
		idCounter++;
	}
	
	
	// Get-Methoden der Privaten Variablen
	public ArrayList getMembers()
	{
		return this.members;
	}
	
	// Hinzufügen eines Objecten in die Gruppe
	public void addObject(Object p)
	{
		members.add(p);
	}
	
	// Löschen eines Objecten aus der Gruppe mit Überprüfung
	public Object removeObject(Object p)
	{
		this.members.remove(p)
			return p;

	}
	
	// Ausgabe der Gruppe
	public String toString()
	{
		String s = "Gruppe: " + this.groupID;
		
		//foreach person in group s += person.toString()  trennzeichen "\n"
		for(int i = 0 ; i < this.members.size() ; i++)
		{
			s += "\n" + this.members.get(i).toString();
		}
		return s;
	}	
}
