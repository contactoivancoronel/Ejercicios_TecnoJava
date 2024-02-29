package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

import paginas.PegarleAUnaPagina;
import runnables.ConsultarYAgregarALaLista;

public class MainConHilos {
	public static void main(String[] args) {
		System.out.println("Inicio programa");
		List<Integer> numeros = new ArrayList<Integer>();
		
		Runnable r1 = new ConsultarYAgregarALaLista(numeros);
		Thread hilo1 = new Thread(r1);
		hilo1.start();
		Runnable r2 = new ConsultarYAgregarALaLista(numeros);
		Thread hilo2 = new Thread(r2);
		hilo2.start();
		Runnable r3 = new ConsultarYAgregarALaLista(numeros);
		Thread hilo3 = new Thread(r3);
		hilo3.start();
		Runnable r4 = new ConsultarYAgregarALaLista(numeros);
		Thread hilo4 = new Thread(r4);
		hilo4.start();
		Runnable r5 = new ConsultarYAgregarALaLista(numeros);
		Thread hilo5 = new Thread(r5);
		hilo5.start();
		
		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
			hilo5.join();
			numeros.forEach(System.out::println);
			System.out.println("Fin del hilo principal");
		
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
