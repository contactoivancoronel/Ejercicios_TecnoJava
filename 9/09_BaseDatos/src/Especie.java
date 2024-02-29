

import java.io.Serializable;

public class Especie implements Serializable{

	private static final long serialVersionUID = -4631736751310259709L;
	
	private int id;
	private String nombre;
	private boolean isVertebrado;
	private String subCategoria;

	public Especie(String nombre, boolean isVertebrado, String subCategoria) {
		super();
		this.nombre = nombre;
		this.isVertebrado = isVertebrado;
		this.subCategoria = subCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isVertebrado() {
		return isVertebrado;
	}

	public void setVertebrado(boolean isVertebrado) {
		this.isVertebrado = isVertebrado;
	}

	public String getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
