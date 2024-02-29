package main;

import interfaces.Mostrable;

public class MainAnonimaMostrable {

	public static void main(String[] args) {

		Mostrable most1 = new Mostrable() {

			@Override
			public void mostrar() {
				System.out.println("Soy el primer mostrable anonimo");

			}
		};

		Mostrable most2 = new Mostrable() {

			@Override
			public void mostrar() {
				System.out.println("Soy el segundo mostrable anonimo");

			}
		};

		most1.mostrar();
		most2.mostrar();
	}

}
