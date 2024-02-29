package practica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import interfaces.Mostrable;
import models.Persona;
import utils.Randomizador;

public class MainPractica {

	public static void main(String[] args) {
		
		Randomizador r = new Randomizador();
		List<Persona> personas = new ArrayList<Persona>();
		
		Mostrable mostradorListado = ()->{
			for (Persona persona : personas) {
				System.out.println(persona);
			}
		};
		
		for (int i = 0; i <50 ; i++) {
			
			String nombre  = r.getNombre();
			String apellido = r.getNombre();
			int edad = r.getInt(0, 80);
			double peso =  r.getDouble(30, 120);
			double altura = r.getDouble(1, 2);
			
			Persona p = new Persona(nombre,apellido,edad, peso, altura);
			personas.add(p);
		}

		System.out.println("Listado:");
		mostradorListado.mostrar();

		
		
		
		personas.sort(null);
		System.out.println("\n\n-------------------------------------------------");

		System.out.println("Listado (Ordenado naturalmente):");
		mostradorListado.mostrar();
		
		System.out.println("\n\n-------------------------------------------------");

		personas.sort(   
				(p1,p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre())
		)  ;
		System.out.println("Listado (Ordernar Alfa):");
		mostradorListado.mostrar();
		
		System.out.println("\n\n-------------------------------------------------");
		System.out.println("Mostrar el mayor (Natural): ");
		
		//Trae el mayor por ordenamiento natural
		Persona masAlto = Collections.max(personas);		
		System.out.println(masAlto);
		
		
		Persona pMinIMC = Collections.min(personas, 
				(p1,p2)-> Double.compare(p1.getIMC(), p2.getIMC()) 
			);

		System.out.println("\n\n-------------------------------------------------");
		System.out.println("Mostrar el menor (IMC): ");	
		System.out.println(pMinIMC);
		

		System.out.println("\n\n-------------------------------------------------");
		System.out.println("Remover mayores: ");	

		//personas.removeIf(   p -> p.getEdad() > 18      );
		personas.removeIf(   p -> p.getNombre().toLowerCase().charAt(0) != 'j'     );
		//mostradorListado.mostrar();
		
		Consumer<Persona> mostrarPersona = p -> System.out.println(p);

		personas.forEach(  mostrarPersona  );
		

		personas.forEach(  p-> p.setEdad( p.getEdad() + 1  ) );
		personas.forEach(  p-> p.setApellido("Jorgelin")   );
		
		
		System.out.println("Con edad aumentada");
		personas.forEach(  mostrarPersona  );
		
		
		
	}

}
