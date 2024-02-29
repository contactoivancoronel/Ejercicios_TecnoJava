package main;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;

import models.Dinosaurio;

public class Main {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		var url = "https://dinosaur-facts-api.shultzlab.com/dinosaurs/random";
		try {
			var respuestaDeLaApiDinosaurios = Request
					.Get(url).execute();
			
			String json_dino = respuestaDeLaApiDinosaurios
					.returnContent().asString();

			System.out.println(json_dino);
			
			var dino = gson.fromJson(json_dino, Dinosaurio.class);
			

			System.out.println(dino.getDescription().toUpperCase());
			
		
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
