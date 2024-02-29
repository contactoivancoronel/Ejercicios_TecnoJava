package main;

import java.util.stream.Stream;

import com.google.gson.Gson;

import apis.DinosauriosApi;
import models.Dinosaurio;

public class MainTodos {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		DinosauriosApi dinosApi = new DinosauriosApi();
		
		var json_dino = dinosApi.getJsonRandom();
		var dino = gson.fromJson(json_dino, Dinosaurio.class);
		
		System.out.println(dino);
		
		var json_todosLosDinos = dinosApi.getJsonTodos();
		
		var todosLosDinos = gson.fromJson(json_todosLosDinos, Dinosaurio[].class );
		
		Stream.of(todosLosDinos).
		filter(  d -> (d.getName().length() < 5) )
		
		.forEach(System.out::println);
	}

}
