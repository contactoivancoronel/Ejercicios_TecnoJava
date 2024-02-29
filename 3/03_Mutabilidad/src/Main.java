import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	
	public static void mostrarListaOrdenada(List<Integer> lista) {
		lista.sort(null);
		lista.forEach( (i)-> System.out.println(i)  );
	}
	
	public static void mostrarMayoresA10(List<Integer> lista) {
		lista.removeIf(   (i)-> i<=10 );
		lista.forEach( (i)-> System.out.println(i)  );
	}

	public static void main(String[] args) {

		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(40);
		numeros.add(1);
		numeros.add(4);
		numeros.add(12);
		numeros.add(1);
		numeros.add(99);
		numeros.add(32);
		

		System.out.println("Principio");
		numeros.forEach( (i)-> System.out.println(i) );

//		System.out.println("Funcion");
//		mostrarListaOrdenada(numeros);
		

		System.out.println("Funcion mostrar mayores a 10");
		mostrarMayoresA10(numeros);
		

		System.out.println("Final");
		numeros.forEach( (i)-> System.out.println(i) );
		
	}

}
