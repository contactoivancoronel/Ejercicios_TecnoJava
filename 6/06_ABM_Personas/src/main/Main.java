package main;

import java.util.ArrayList;
import java.util.stream.Stream;

import ar.com.gniglio.models.Persona;

public class Main {

	public static void main(String[] args) {
		var lista = Stream.generate( Persona::getRandom)
		.limit(100).toList();

		
		
	}

}
