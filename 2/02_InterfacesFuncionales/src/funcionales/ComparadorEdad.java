package funcionales;

import java.util.Comparator;

import models.Persona;

public class ComparadorEdad implements Comparator<Persona> {

	@Override
	public int compare(Persona persona1, Persona persona2) {
		return persona1.getEdad() - persona2.getEdad();
	}

}
