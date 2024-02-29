package models;



public class Municipio {
	private String id;
	private String nombre;
	private Provincia provincia;
	private Centroide centroide;

	
	
	public Municipio(String id, String nombre, Provincia provincia, Centroide centroide) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
		this.centroide = centroide;
	}

	public Municipio(String id, String nombre, Provincia provincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
	}

	public Municipio(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

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

	@Override
	public String toString() {
		return "Municipio [id=" + id + ", nombre=" + nombre + "]";
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Centroide getCentroide() {
		return centroide;
	}

	public void setCentroide(Centroide centroide) {
		this.centroide = centroide;
	}
	
	public String getNombreProvincia() {
		return this.getProvincia().getNombre();
	}
	
	

}

