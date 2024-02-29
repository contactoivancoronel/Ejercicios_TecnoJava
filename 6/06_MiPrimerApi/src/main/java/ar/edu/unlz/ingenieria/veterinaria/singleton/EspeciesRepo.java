package ar.edu.unlz.ingenieria.veterinaria.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import ar.edu.unlz.ingenieria.models.Especie;

public class EspeciesRepo {
	
	
	private static EspeciesRepo singleton;
	
	public static EspeciesRepo getInstance() {
		if(singleton == null) {
			singleton = new EspeciesRepo();
		}
		return singleton;
	}
	//-----------------------------------------------------------
	
	
	private List<Especie> listadoEspecies;	
	
	private int ultimoID = 0; 
	
	private EspeciesRepo() {
		this.listadoEspecies = new ArrayList<Especie>();
	}

	public boolean add(Especie especie) {
		var nuevoNombre = especie.getNombre();
		if(this.get(nuevoNombre) == null) {
			this.ultimoID ++;
			int nuevaId = this.ultimoID ;
			especie.setId(nuevaId);
			this.listadoEspecies.add(especie);		
			return true;
		}
		return false;
		
	}
	/**
	 * Trae un especie en base a su nombre
	 * 
	 * @return Retorna la especie o null (En caso de no encontrarla)
	 * **/
	public Especie get(String nombre) {
		Especie especieBuscada =  this.listadoEspecies.stream()
			.filter(  (e) ->   e.getNombre().equals(nombre)   )
			.findFirst().orElse(null);
		
		return especieBuscada;
	}
	
	public List<Especie> listado(){
		return this.listadoEspecies.stream().toList();
	}
	

	public Stream<Especie> stream(){
		return this.listadoEspecies.stream();
	}
	

}
