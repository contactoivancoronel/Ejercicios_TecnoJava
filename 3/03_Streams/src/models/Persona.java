package models;

import utils.Randomizador;

public class Persona {

	private String nombre;
	private int edad;
	private double peso;
	private double estatura;
	
	
	public static Persona getRandom() {
		Randomizador r = new Randomizador();
		return new Persona(r.getNombre(), 
				r.getInt(5,80), 
				r.getDouble(30, 120), 
				r.getDouble(1, 100));
		
	}
	
	public Persona(String nombre, int edad, double peso, double estatura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.estatura = estatura;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public double getEstatura() {
		return this.estatura;
	}
	
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	
	//Function<Persona,String>
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", estatura=" + estatura + "]";
	}
	
	//Predicate<Persona>
	public boolean isMenor() {
		return this.getEdad() < 18;
	}
	
	
	
}
