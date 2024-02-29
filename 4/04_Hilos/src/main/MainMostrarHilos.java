package main;

import hilos.HiloMostrar;

public class MainMostrarHilos {

	public static void main(String[] args) {
		
		for (int j = 0; j <2; j++) {
			Thread hilo = new HiloMostrar(j);
			hilo.start();
		}
		
		

	}

}
