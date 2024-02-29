package main;

import java.util.Comparator;

import funcionales.ComparadorEdad;
import models.Persona;

public class MainClasesAnonimas {

	public static void main(String[] args) {
		
		
		Comparator<Persona> compEdad = new ComparadorEdad(); 
		
		Comparator<Persona> compPeso = new Comparator<Persona>() {
			
			@Override
			public int compare(Persona o1, Persona o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		

	}

}
