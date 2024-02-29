package main;
import funcionales.ComparadorEdad;
import models.Persona;

public class MainPersonas {

	public static void main(String[] args) {
		

		Persona persona1 = new Persona(18, 80, 1.74);
		Persona persona2 = new Persona(80, 70, 1.58);

		System.out.println(persona1);
		System.out.println(persona2);
		int result = persona1.compareTo(persona2);
		
		if(result > 0) {
			System.out.println("La persona 1 es mayor (Altura)");
		}else if(result < 0){
			System.out.println("La persona 2 es mayor (Altura)");
			
		}else {
			System.out.println("Tienen la misma altura");
			
		}
		
		ComparadorEdad ce = new ComparadorEdad();
		
		result = ce.compare(persona1, persona2);
		
		
		if(result > 0) {
			System.out.println("La persona 1 es mayor (Edad)");
		}else if(result < 0){
			System.out.println("La persona 2 es mayor (Edad)");
			
		}else {
			System.out.println("Tienen la misma edad");
			
		}
		

	}

}
