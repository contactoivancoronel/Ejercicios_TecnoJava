package ar.edu.unlz.pasteleria.models;

public class Ingrediente {

	private int id;
	private String detalle;
	private String unidad;

	public Ingrediente() {
	}
	
	public Ingrediente(String detalle, String unidad) {
		super();
		this.detalle = detalle;
		this.unidad = unidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

}
