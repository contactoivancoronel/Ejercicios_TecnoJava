package practica;

import java.util.function.Function;
import java.util.function.Supplier;

import models.Persona;
import utils.Randomizador;

public class MainFunction {

	public static void main(String[] args) {

		Function<Persona, Integer> extractorEdad = (p) -> p.getEdad();
		Function<Persona, Character> primerLetra = (p) -> p.getNombre().charAt(0);
		
		Persona p = new Persona("Pepe","argento",19, 99, 1.80);
		
		int result = extractorEdad.apply(p);
		
		
		System.out.println(result);
		
		char inicial = primerLetra.apply(p);
		
		System.out.println(inicial);
		
		
		Randomizador r = new Randomizador();
		
		Supplier<String>  sup =  ()->{
			return r.getNombre();
		};

	}

}
