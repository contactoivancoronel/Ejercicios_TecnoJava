package paginas;

public class PegarleAUnaPagina {

	public static int consultar() throws InterruptedException {
		int milisegundos = 2000 + (int) (Math.random() * 3000);
		Thread.sleep(milisegundos);
		int numero = (int) (Math.random() * 100);
		System.out.println("Respuesta pagina:"+numero);
		return numero;
	}
}
