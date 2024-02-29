package main;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

import helpers.PersonasHelper;
import models.Persona;

public class MainReferenciaStatic {
	
	public static void main(String[] args) {
		
		Consumer<Object> mostrarR = System.out::println;
//		Consumer<String> mostrarL = (s)-> System.out.println(s);
//		
//		mostrarR.accept("Hola mundo");
//		
//		Predicate<Persona> personaMayor = PersonasHelper::esMayor;
//		
//		personaMayor.test(null);
		
		Persona p = new Persona("Pepe", 18, 75, 1.89);
		
		boolean res = PersonasHelper.esMayor(p);
		
		System.out.println(res);
		
		mostrarR.accept(res);
		
		Predicate<Persona> personaMayor = PersonasHelper::esMayor;
		
		
		personaMayor.test(p);
		
		
	}

}
