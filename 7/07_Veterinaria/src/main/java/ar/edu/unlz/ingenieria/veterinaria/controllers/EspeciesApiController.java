package ar.edu.unlz.ingenieria.veterinaria.controllers;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ar.edu.unlz.ingenieria.models.Especie;
import ar.edu.unlz.ingenieria.models.Respuesta;
import ar.edu.unlz.ingenieria.veterinaria.singleton.EspeciesRepo;

@WebServlet("/EspeciesApiController")
public class EspeciesApiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson gson;
	private EspeciesRepo listadoEspecies;

	public EspeciesApiController() {
		super();
		this.gson = new Gson();
		this.listadoEspecies = EspeciesRepo.getInstance();

	}

	private void doMostrarEspecies(HttpServletRequest request, HttpServletResponse response) throws IOException {

		var json_listado = gson.toJson(listadoEspecies.listado());

		response.getWriter().write(json_listado);

	}

	private void doCrearEspecie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Ingresos
		String nombre = request.getParameter("nombre");
		String sIsVertebrado = request.getParameter("vertebrado");
		String subCategoria = request.getParameter("subcategoria");

		boolean isVertebrado = (sIsVertebrado.equals("S")) ? true : false;

		// Proceso
		Especie especie = new Especie(nombre, isVertebrado, subCategoria);

		boolean seCreo = listadoEspecies.add(especie);
		String mensaje ;
		if(seCreo) {

			mensaje= "Se creo correctamente";
		}else {
			mensaje = "Ya existe, no se pudo crear";
		}
		var respuesta = new Respuesta(200, mensaje);

		var json_respuesta = gson.toJson(respuesta);

		// Selida
		response.getWriter().write(json_respuesta);
	}

	private void doMostrarMamiferos(HttpServletRequest request, HttpServletResponse response) throws IOException {

		var listadoMamiferos = listadoEspecies.stream().filter((e) -> e.getSubCategoria().equals("Mamifero")).toList();

		response.getWriter().write(gson.toJson(listadoMamiferos));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Dependencias

		String accion = request.getParameter("accion");

		switch (accion) {
		case "mostrar" -> doMostrarEspecies(request, response);
		case "mostrarmamiferos" -> doMostrarMamiferos(request, response);
		default -> response.getWriter().write("Opcion invalida");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");
		switch (accion) {
		case "crear" -> doCrearEspecie(request, response);
		default -> response.getWriter().write("Opcion invalida");
		}
	}

}
