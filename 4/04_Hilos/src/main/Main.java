package main;

import runnables.ConsultarPagina;
import runnables.MostrarDelUnoAlDiez;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Inicio");

		Runnable r1 = new ConsultarPagina("Pepe");
		Runnable r2 = new ConsultarPagina("Mariela");
		Runnable r3 = new ConsultarPagina("Jorge");
		Runnable r4 = new ConsultarPagina("Gabriel");
		Runnable r5 = new ConsultarPagina("Proceso");

		Thread hilo1 = new Thread(r1);
		Thread hilo2 = new Thread(r2);
		Thread hilo3 = new Thread(r3);
		Thread hilo4 = new Thread(r4);
		Thread hilo5 = new Thread(r5);

		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		
		System.out.println("Fin");
	}

}
