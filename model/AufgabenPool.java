package model;


public class AufgabenPool {
	
	private int dozID;
	private String fach;
	private String beschreibung;
	AufgabenPool(String beschreibung, int dozID, String fach){
		
		this.beschreibung = beschreibung;
		this.dozID = dozID;
		this.fach = fach;
	}
	
	public String getBeschreibung(){
		return this.beschreibung;
	}
	
	public String getFach(){
		return this.fach;
	}
	
	public int getDozID(){
		return this.dozID;
	}
	//Die AufgabenID benötigt noch eine methode zur Ermittlung der Aktuell vergebenen ID´s aus der Datenbank (id++)
}
