package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import models.Persona;

public class MainReferenciaObjetoDefinido {

	public static void main(String[] args) {
		

		Persona person = new Persona("Pepe", 18, 75, 1.89);
		
		Consumer<Integer> setearEdad = person::setEdad;
		
		
		setearEdad.accept(1);
		
		System.out.println(person);
		
		
		List<Persona> lp = new ArrayList<Persona>();
		
		Consumer<Persona> agregarPersona = lp::add;	
		
		
		List<Persona> lista = new ArrayList<Persona>();

		for (int i = 0; i < 20; i++) {
			lista.add(Persona.getRandom());
		}
		
		lista.stream().filter(Persona::isMenor )
		//.forEach(  (p)-> lp.add(p) );
		.forEach(  lp::add  );
		
		lp.forEach( System.out::println );
		
	}

}
