package models;

public class Dinosaurio {
	private String Name;
	private String Description;
	
	public int getCantidadLetrasNombre() {
		return this.getName().replaceAll(" ", "").length();
	}
	
	
	public Dinosaurio(String name, String description) {
		super();
		this.Name = name;
		this.Description = description;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	@Override
	public String toString() {
		return "Dinosaurio [name=" + Name + ", description=" + Description + "]";
	}
	
	
	

}
