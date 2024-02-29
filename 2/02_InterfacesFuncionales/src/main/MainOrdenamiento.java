package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import funcionales.ComparadorEdad;
import models.Persona;

public class MainOrdenamiento {

	public static void main(String[] args) {
		
		
		
		List<Persona> personas = new ArrayList<Persona>();
		
		for (int i = 0; i <5; i++) {
			int edad = 	(int) (Math.random() *80);
			double peso =  30 + Math.random() *100;
			double altura = 1 + Math.random() *1.1;
			
			Persona p = new Persona(edad, peso, altura);
			
			personas.add(p);
		}
		
		System.out.println("Listado:");
		for (Persona persona : personas) {
			System.out.println(persona);
		}
		
		Collections.sort(personas);

		System.out.println("");
		System.out.println("Listado ordenado (Altura):");
		for (Persona persona : personas) {
			System.out.println(persona);
		}
		
		ComparadorEdad ce = new ComparadorEdad();
		
		Collections.sort(personas,ce);

		System.out.println("");
		System.out.println("Listado ordenado (Edad):");
		for (Persona persona : personas) {
			System.out.println(persona);
		}
		
		
		Comparator<Persona> compPeso = new Comparator<Persona>() {
			@Override
			public int compare(Persona persona1, Persona persona2) {
				return  Double.compare(persona1.getPeso(), persona2.getPeso());
			}			
		};
		
		
		
		Collections.sort(personas,compPeso);
		System.out.println("");
		System.out.println("Listado ordenado (Peso):");
		for (Persona persona : personas) {
			System.out.println(persona);
		}
		
		Comparator<Persona> compIMC = 
				(per1,per2) -> Double.compare(per1.getIMC(), per2.getIMC());

		Collections.sort(personas,compIMC);
		System.out.println("Listado ordenado (IMC):");
		for (Persona persona : personas) {
			System.out.println(persona);
		}
		
		
		Collections.sort(personas,	(p1,p2)-> p2.getEdad()-p1.getEdad()	);		

		personas.sort(   (p1,p2)-> p2.getEdad()-p1.getEdad()	    );
		
		
		System.out.println("");
		System.out.println("Listado ordenado (Edad al inverso):");
		for (Persona persona : personas) {
			System.out.println(persona);
		}
		
		
		
		
	}

}

//personas.sort( Comparator.comparing(Persona::getIMC) );
