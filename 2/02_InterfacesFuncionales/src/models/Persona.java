package models;

public class Persona implements Comparable<Persona>{

	private int edad;
	private double peso;
	private double altura;
	private String nombre;
	private String apellido;
	
	
	
	public Persona(String nombre, String apellido, int edad, double peso, double altura) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Persona(int edad, double peso, double altura) {
		super();
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
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
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getIMC() {
		return this.getPeso() / Math.pow(this.getAltura(), 2);
	}
	
	@Override
	public int compareTo(Persona otraPersona) {
		double alturaThis = this.getAltura();
		double alturaOtro = otraPersona.getAltura();
		
		
		return Double.compare(alturaThis, alturaOtro);
	}
	@Override
	public String toString() {
		return  " [edad=" + edad + ", peso=" + String.format("%4.2f" ,peso) 
		+ ", altura=" + String.format("%4.2f",altura )
		+ ", getIMC()=" + String.format("%4.2f",getIMC()) 
		+ ", N:" + nombre+", A:" +apellido+ "]";
	}
	
	
}
