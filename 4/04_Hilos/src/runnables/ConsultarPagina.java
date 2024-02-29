package runnables;

import paginas.PegarleAUnaPagina;

public class ConsultarPagina implements Runnable {

	private String nombre;
	
	public ConsultarPagina(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void run() {

		
		
		try {
			int resultado = PegarleAUnaPagina.consultar();
			System.out.println("El runnable ("+this.nombre+") muesta: "+resultado);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
