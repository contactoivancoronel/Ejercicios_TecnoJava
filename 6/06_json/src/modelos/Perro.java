package modelos;

import java.util.ArrayList;
import java.util.List;

public class Perro {
	private String raza;
	private String color;
	private int edad;
	private double peso;
	private List<String> apodos;

	public Perro(String raza, String color, int edad, double peso) {
		super();
		this.raza = raza;
		this.color = color;
		this.edad = edad;
		this.peso = peso;
		this.apodos = new ArrayList<String>();
	}
	
	public void addApodo(String apodo) {
		this.apodos.add(apodo);
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Perro [raza=" + raza + ", color=" + color + ", edad=" + edad + ", peso=" + peso + ", apodos=" + apodos
				+ "]";
	}

	
	
}
