import java.beans.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

class ClassPool {
	public static DatabaseSQLite myDB;
	private ArrayList<Class> list;
	private String location; // Standort BI/PB

	public ClassPool(String location) {
		//
		this.list = new ArrayList<>();
		this.location = location;
	}

	public void addClass(Class newClass)
	{
		try
		{
			// Die Klasse wird auf ihre Einzigartigkeit geprüft.
			if (classIsUniqueCheck(newClass.name))
			{
				Statement stmt = c.createStatement();
				// Die Klasse wird in die Datenbank eingefügt.
				String sql = "Insert into Klassen (Klassenbezeichnung,AnzahlSchüler,Klassendozent)" + "Values("
						+ newClass.getClassName() 
						+ "," + newClass.getAnzahl() 
						+ "," + newClass.getClassProfessor()
						+ ");";
				stmt.execute(sql);
				stmt.close();
			} 
			else
			{
				System.out.print("Die Klasse ist bereits vorhanden.");
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void deleteClass(String className)
	{
		
		boolean check=false;
		//Es wird durch die gesamte Klassenliste gelaufen
		for(int = 0; this.list.size(),i++)
		{
			//bei einem Treffer wird die Klasse aus der DB gelöscht
			if(className.contains(this.list.get(i.getName())))
			{
				myDB.delete("Klassen",this.list.get(i.getName()));
				check=true;
				break;
			}
		}
		//Wenn die Klasse nicht in der Liste gefunden wird, wird eine Fehlermeldung ausgegeben.
		if(check = false)
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
		//über prüft Klassen auf ihre Einzigartigkeit
		boolean check=true;
		for(int i=0; i < this.list.size; i++)
		{
			if(className.contains(this.list.get(i.getName())))
			{
				check = false;
			}
		}
		return check;
	}

	public ArrayList<String> showAllClasses() {
		//schreibt die Namen der Klassen in eine Arraylist und gibt sie zurück
		ArrayList<String> classNames= new ArrayList<>();
		for(int i = 0; i<this.list.size; i++)
		{
			classNames.add(this.list.get(i.getName()));
		}
		return classNames;
	}

}
