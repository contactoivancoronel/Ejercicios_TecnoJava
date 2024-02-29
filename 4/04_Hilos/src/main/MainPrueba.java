package main;
import java.util.ArrayList;
import java.util.List;

import paginas.PegarleAUnaPagina;

public class MainPrueba {

	public static void main(String[] args) {
		System.out.println("Comienzo...");
		try {
			
			List<Integer> numeros = new ArrayList<Integer>();
			numeros.add(PegarleAUnaPagina.consultar());
			numeros.add(PegarleAUnaPagina.consultar());
			numeros.add(PegarleAUnaPagina.consultar());
			numeros.add(PegarleAUnaPagina.consultar());
			numeros.add(PegarleAUnaPagina.consultar());
			
			numeros.forEach(System.out::println);
			
			
			
			
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

}
