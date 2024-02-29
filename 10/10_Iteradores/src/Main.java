import java.util.Iterator;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		var lista = Stream.of("Lunes", "Mates", "Miecoles", "Jueves", "Viernes", "Sabado", "Domingo").toList();

		var iterador = lista.iterator();

//		while(iterador.hasNext()) {
//			var elemento = iterador.next();
//			System.out.println(elemento);
//		}
		
	
		
		var iteradorInf = new IteradorInfinito(100);
		
		while(iteradorInf.hasNext()) {
			var elemento = iteradorInf.next();
			System.out.println(elemento);
		}
		
		Iterable<Integer> iterable = ()-> iteradorInf;
		
		for (int numero : iterable) {
			System.out.println(numero);
		}
		
	}

}
