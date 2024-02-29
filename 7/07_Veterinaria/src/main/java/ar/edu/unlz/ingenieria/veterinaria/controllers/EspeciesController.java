package ar.edu.unlz.ingenieria.veterinaria.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.unlz.ingenieria.models.Especie;
import ar.edu.unlz.ingenieria.veterinaria.singleton.EspeciesRepo;

@WebServlet("/EspeciesController")
public class EspeciesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EspeciesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = Optional.ofNullable(request.getParameter("accion")).orElse("index");

		switch (accion) {
		case "index" -> doIndex(request, response);
		case "mostrar" -> doMostrar(request, response);
		case "formularioeditar" -> doFormularioEditar(request, response);
		case "formularioalta" -> doFormularioAlta(request, response);
		default -> response.getWriter().write("Not found");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = Optional.ofNullable(request.getParameter("accion")).orElse("alta");

		switch (accion) {
		case "alta" -> doAlta(request, response);
		case "editar" -> doEditar(request, response);
		case "eliminar" -> doEiminar(request, response);

		}

	}

	// GET

	private void doFormularioAlta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("views/especies/alta.jsp").forward(request, response);

	}

	private void doFormularioEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Levanto los parametros GET
		int id = Integer.parseInt(  request.getParameter("id")   );

		//Levanto el repo
		var repo = EspeciesRepo.getInstance();

		//Obtengo la especie en particular que se quiere editar
		var especie = repo.getById(id);
		
		//Defino la especie como atributo del request
		request.setAttribute("especie", especie);

		//Despacho el request y el response a la vista, para que se arme en base a eso.
		request.getRequestDispatcher("views/especies/editar.jsp").forward(request, response);
	}

	private void doMostrar(HttpServletRequest request, HttpServletResponse response) {

	}

	private void doIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Levanto el repo
		var repo = EspeciesRepo.getInstance();

		//Obtengo el listado de todas las especies
		var lista = repo.listado();

		//Defino el listado como atributo del request (Para usarlo en la vista)
		request.setAttribute("lista", lista);

		//Despacho el request y el response a la vista, para que se arme en base a eso.
		request.getRequestDispatcher("views/especies/index.jsp").forward(request, response);
	}

	// POST

	private void doEiminar(HttpServletRequest request, HttpServletResponse response) {

	}

	private void doEditar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Traer datos POST
		String nombre = request.getParameter("nombre");
		String sIsVertebrado = request.getParameter("vertebrado");
		String subCategoria = request.getParameter("subcategoria");
		int id = Integer.parseInt(  request.getParameter("id")   );

		boolean isVertebrado = (sIsVertebrado.equals("S")) ? true : false;
		
		//Repo
		var repo = EspeciesRepo.getInstance();
		
		//Traigo la especie
		var especie = repo.getById(id);
		
		//Edito
		especie.setNombre(nombre);
		especie.setSubCategoria(subCategoria);
		especie.setVertebrado(isVertebrado);
		
		//Redirecciono
		response.sendRedirect("EspeciesController");
		
		
	}

	private void doAlta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//Traer datos POST
		String nombre = request.getParameter("nombre");
		String sIsVertebrado = request.getParameter("vertebrado");
		String subCategoria = request.getParameter("subcategoria");

		boolean isVertebrado = (sIsVertebrado.equals("S")) ? true : false;

		//Repo
		var repo = EspeciesRepo.getInstance();

		//Creo el objeto 
		var especie = new Especie(nombre, isVertebrado, subCategoria);

		//Agrego el objeto al repo
		repo.add(especie);

		
		//Llamo al doindex
		doIndex(request, response);

	}

}
