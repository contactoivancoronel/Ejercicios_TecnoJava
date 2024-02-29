package main;

import java.util.Comparator;
import java.util.function.Function;

import apis.DinosauriosApi;
import models.Dinosaurio;

public class MainRapido {

	public static void main(String[] args) {
		DinosauriosApi dinoApi = new DinosauriosApi();
		
		var listaDinos =  dinoApi.getTodos();
		
		listaDinos.stream()
		.map(Dinosaurio::getName)
		.forEach(System.out::println);
		
		Function<Dinosaurio, String> extName = Dinosaurio::getName;
		
		var cantLetrasNombre = extName.andThen(String::length);

		
		var maximoDino = listaDinos.stream()
				.max(Comparator.comparing(cantLetrasNombre))
				.get();
		
		
		listaDinos.stream()
				.min(Comparator.comparing(
						Dinosaurio::getCantidadLetrasNombre)
					).ifPresent(System.out::println);
		
		listaDinos.stream()
		.filter( d -> d.getCantidadLetrasNombre() == 4  )
		.forEach(System.out::println);

		System.out.println(maximoDino);
	}

}
