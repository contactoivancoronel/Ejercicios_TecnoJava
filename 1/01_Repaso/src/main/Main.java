package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.*;

public class Main {

	public static void main(String[] args) {

		
		List<Animal> listaAnimales;
		listaAnimales = new ArrayList<Animal>();
		
		Animal ani = new Perro();
		Perro  perri = new Perro();

		ani.hacerRuido();
		
		ani = new Gato();
		
		Gato gati = (Gato) ani;
		
		gati.caminarComoGato();
		
		ani.hacerRuido();
		perri.hacerRuido();
		

		perri.setCantOjos(500);
		gati.setCantOjos(88);

		
		
		

		System.out.println("Resultado comparacion:" + perri.compareTo(gati));
		
		
		
		listaAnimales.add(perri);
		listaAnimales.add(gati);
		System.out.println("Lista antes de ordenar");
		for (Animal animal : listaAnimales) {
			System.out.println(animal.getCantOjos());
			
		}
		
		Collections.sort(listaAnimales);
		
		System.out.println("Lista despues de ordenar");
		for (Animal animal : listaAnimales) {
			System.out.println(animal.getCantOjos());
			
		}
		
		System.out.println("Fin del progreama");

	}

}
