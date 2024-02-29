package funcionales;

import java.util.function.Predicate;

import models.Persona;

public class MayoresDeEdad implements Predicate<Persona> {

	@Override
	public boolean test(Persona persona) {
		return persona.getEdad() >= 18;
	}

}
