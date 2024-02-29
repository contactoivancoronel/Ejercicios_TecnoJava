package practica;

import java.util.function.Predicate;

import funcionales.MayoresDeEdad;
import models.Persona;

public class MainPredicado {

	public static void main(String[] args) {
		
		Persona person = new Persona("Pepe","Argento",45, 60, 1.72);
		
		Predicate<Persona> mayorEdad = new MayoresDeEdad();
		
		boolean result = mayorEdad.test(person);
		
		System.out.println(result);
		
		Predicate<Persona> sePuedeJubilar = p-> p.getEdad() > 65 ;
		
		result = sePuedeJubilar.test(person);
		System.out.println(result);
		

		Predicate<Persona> NoSePuedeJubilar = sePuedeJubilar.negate();
		
		

	}

}
