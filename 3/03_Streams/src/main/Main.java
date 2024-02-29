package main;

import java.util.ArrayList;
import java.util.List;

import helpers.PersonasHelper;
import models.Persona;

public class Main {

	public static void main(String[] args) {

		List<Persona> lista = new ArrayList<Persona>();

		for (int i = 0; i < 20; i++) {
			lista.add(Persona.getRandom());
		}

		lista.forEach((p) -> System.out.println(p));

		List<Persona> listaFiltrada = lista.stream()
				.filter((p) -> p.getEdad() > 50)
				.toList();

		
		
		
		System.out.println("Luego de filtrar:");

		listaFiltrada.forEach((p) -> System.out.println(p));

		System.out.println("Primer lista");
		lista.forEach((p) -> System.out.println(p));
		
		
		System.out.println("Mostrar >1.70m");		
		lista.stream()
			.filter( PersonasHelper::esMayor )
			//.sorted( (p1,p2)-> Double.compare(p1.getEdad(), p2.getEdad() ))
			//.map( (p)->p.getNombre() + " " + p.getEdad() )
			.forEach( System.out::println );
			
		

	}

}
