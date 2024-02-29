package apis;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import com.google.gson.Gson;

import models.Dinosaurio;

public class DinosauriosApi {
	private String urlBase;
	private Gson gson;
	
	public DinosauriosApi() {
		 this.gson = new Gson();
		this.urlBase = "https://dinosaur-facts-api.shultzlab.com/dinosaurs";
	}
	
	public String getJsonRandom() {
		var url = this.urlBase + "/random";
		String json_dino = null;
		
		try {
			var respuestaDeLaApiDinosaurios = Request
					.Get(url).execute();
			json_dino = respuestaDeLaApiDinosaurios
					.returnContent().asString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return json_dino;
	}
	
	public String getJsonTodos() {
		var url = this.urlBase;
		String json_dino = null;
		
		try {
			var respuestaDeLaApiDinosaurios = Request
					.Get(url).execute();
			json_dino = respuestaDeLaApiDinosaurios
					.returnContent().asString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return json_dino;
	}

	
	public Dinosaurio getRandom() {
		return gson.fromJson(this.getJsonRandom(), Dinosaurio.class);
	}
	
	public List<Dinosaurio> getTodos() {
		var vectorDinos = gson.fromJson(this.getJsonTodos(), Dinosaurio[].class);
		return Stream.of(vectorDinos).toList();
	}
}
