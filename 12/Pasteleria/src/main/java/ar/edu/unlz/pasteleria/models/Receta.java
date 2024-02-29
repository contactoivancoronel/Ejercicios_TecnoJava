package ar.edu.unlz.pasteleria.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Receta implements Iterable<Ingrediente>{

	private List<Ingrediente> ingredientes;
	private String nombre;
	
	public Receta() {
		ingredientes = new ArrayList<Ingrediente>();
	}
	
	public void addIngrediente(Ingrediente ingrediente) {
		ingredientes.add(ingrediente);
	}
	
	@Override
	public Iterator<Ingrediente> iterator() {
		return ingredientes.iterator();
	}
}
