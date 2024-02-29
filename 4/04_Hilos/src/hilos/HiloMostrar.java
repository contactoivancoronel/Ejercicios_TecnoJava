package hilos;

public class HiloMostrar extends Thread {
	
	private int numero;
	
	public HiloMostrar(int numero) {
		this.numero = numero;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(numero+": "+i);
		}
		System.out.println("Termino el hilo: "+numero);
	}

}
