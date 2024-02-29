package main;

import com.google.gson.Gson;

import modelos.Perro;

public class Main {

	public static void main(String[] args) {
		
		var perro = new Perro("Golden", "Amarrillo", 7, 32.1);

		perro.addApodo("Pepe");
		perro.addApodo("Jorge");
		
		var gson = new Gson();
		
		String json_perro = gson.toJson(perro);
		
		System.out.println(json_perro);
		
		var json_perro2= "{\"raza\":\"Boxer\"}  ";
		Perro p = gson.fromJson(json_perro2, Perro.class);
		
		System.out.println(p);
		

	}

}
