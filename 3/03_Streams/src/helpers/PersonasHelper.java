package helpers;

import models.Persona;

public class PersonasHelper {

	public static boolean tirarVerdadero(Persona s) {
		return true;
	}
	
	
	//Predicate<Persona>
	public static boolean esMayor(Persona p) {
		return p.getEdad() >= 18;
	}
	
	//Compator<Persona>
	public static int compararEstatura(Persona p1, Persona p2) {
		return Double.compare(p1.getEstatura(), p2.getEstatura());
	}
	
	//Consumer<Persona>
	public static void incrementarUnAnio(Persona p) {
		p.setEdad( p.getEdad()+1 );
	}
	
	//Function<Persona, Double>
	public static double sumarPesoYAltura(Persona p) {
		return p.getEstatura() + p.getPeso();
	}
	
}
