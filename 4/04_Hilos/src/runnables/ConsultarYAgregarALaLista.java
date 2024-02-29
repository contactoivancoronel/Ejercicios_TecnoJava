package runnables;

import java.util.List;

import paginas.PegarleAUnaPagina;

public class ConsultarYAgregarALaLista implements Runnable {
	
	private List<Integer> lista;
	
	public ConsultarYAgregarALaLista(List<Integer> lista) {
		this.lista = lista;
	}

	@Override
	public void run() {
		try {
			int numero = PegarleAUnaPagina.consultar();
			lista.add(numero);
			
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
