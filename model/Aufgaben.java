package model;


public class Aufgaben {
	
	private int id;
	private String name;
	private String description;
	private String time;
	private String category;
	private String pool;

	
	
	Aufgaben(String name, String description, String time, String category, String pool){
		
		this.name = name;
		this.description = description;
		this.time = time;
		this.category = category;
		this.pool = pool;
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
	
	public void setID(int id){
		this.id = id;
	}
	
	
	
	

}
