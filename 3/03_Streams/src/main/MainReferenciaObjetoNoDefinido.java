package main;

import java.util.function.Function;

import models.Persona;

public class MainReferenciaObjetoNoDefinido {

	public static void main(String[] args) {
		

		Persona p = new Persona("Pepe", 18, 75, 1.89);
		
		Function<Persona, Integer> extractorEdad = Persona::getEdad;
		
		int edad = extractorEdad.apply(p);
		
		System.out.println(edad);
		

	}

}
