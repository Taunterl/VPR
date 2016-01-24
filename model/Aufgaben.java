package model;


public class Aufgaben {
	
	private int id;
	private String name;
	private String description;
	private String time;
	private String category;
	private String pool;

	
	
	public Aufgaben(int id, String name, String description, String time, String category, String pool){
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.time = time;
		this.category = category;
		this.pool = pool;
	}
	
	public Aufgaben(String name, String description, String time, String category, String pool){
		this.name = name;
		this.description = description;
		this.time = time;
		this.category = category;
		this.pool = pool;
	}
	
	public Aufgaben(int id, String name, String description, String time){
		this.id = id;
		this.name = name;
		this.description = description;
		this.time = time;
	}
	
	
	
	public String getName(){
		return this.name;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public String getPool(){
		return this.pool;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getTime(){
		return this.time;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setPool(String Poolid)
	{
		this.pool=Poolid;
	}
	
	
	

}
