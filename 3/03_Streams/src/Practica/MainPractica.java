package Practica;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import helpers.PersonasHelper;
import models.Persona;

public class MainPractica {

	
	public static void main(String[] args) {
		Consumer<Object> mostrar = System.out::println;
		
		mostrar.accept("Crear una lista de 50 personas random");
		List<Persona> lista = Stream.
				generate(Persona::getRandom)
				.limit(50)
				.toList();
		
		mostrar.accept("Mostrar solo las edades de mis elementos ordenadas");
		lista.stream()	
			.map( Persona::getEdad )
			.sorted()
			.forEach(mostrar);
		
		mostrar.accept("Validar si existe alguna persona con el nombre Hector");
		boolean  hayAlgunHector = lista.stream()
			.map(Persona::getNombre )
			.anyMatch( "Hector"::equals );
		
		System.out.println(hayAlgunHector);

		mostrar.accept("Mostrar las personas mayores a 18");
		mostrar.accept("y contengan la letra p (Ordenados por estatura");
		
		lista.stream()
			.filter( PersonasHelper::esMayor )
			.filter(  p -> p.getNombre().toLowerCase().contains("p") )
			.sorted(  Comparator.comparing(Persona::getEstatura)  )
			.forEach(mostrar);
		
		
		Map<Double, Object> mapa = lista.stream()
				.collect(Collectors.toMap(
				Persona::getEstatura, (p)-> p )
				);
	
		
		System.out.println(mapa);
		
	}
}
