package models;

public class Provincia {
	private String id;
	private String nombre;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

}
