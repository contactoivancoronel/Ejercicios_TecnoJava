package models;

import java.io.Serializable;

public final class Gato extends Animal implements Serializable {

	@Override
	public void hacerRuido() {
		System.out.println("Miau");
		

	}
	
	public void caminarComoGato() {
		System.out.println("Esta caminando como un gato");
		
	}

}
