package ar.edu.unlz.pasteleria.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.unlz.pasteleria.daos.IngredientesDAO;
import ar.edu.unlz.pasteleria.models.Ingrediente;



@WebServlet(urlPatterns = {"/ingredientes/*"})
public class IngredientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IngredientesDAO idao;

	public IngredientesController() {
		this.idao = new IngredientesDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			//var path = request.getParameter("accion");

			var path = request.getPathInfo();
			path = Optional.ofNullable(path).orElse("/index");

			System.out.println("Path: "+path);
			switch (path) {
			case "/index" -> getIndex(request, response);
			case "/create" -> getCreate(request, response);
			case "/edit" -> getEdit(request, response);
			default -> response.sendError(401);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(500, "Vuelva a intentar mas tarde");
		}
	}

	private void getEdit(HttpServletRequest request, HttpServletResponse response) {

	}

	private void getCreate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var unidades = Stream.of("unidad", "gramos", "mililitros").toList();

		request.setAttribute("unidades", unidades);

		var rd = request.getRequestDispatcher("/views/ingredientes/create.jsp");

		rd.forward(request, response);

	}

	private void getIndex(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		var ingredientes = idao.all();

		request.setAttribute("ingredientes", ingredientes);

		var rd = request.getRequestDispatcher("/views/ingredientes/index.jsp");

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			var path = request.getParameter("accion");
			path = Optional.ofNullable(path).orElse("insert");

			switch (path) {
			case "insert" -> postInsert(request, response);
			case "update" -> postUpdate(request, response);
			case "delete" -> postDelete(request, response);
			default -> response.sendError(404);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(501, "Vuelva a intentar mas tarde");
		}
	}

	private void postDelete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return;
	}

	private void postUpdate(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return;
	}

	private void postInsert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		var detalle = request.getParameter("detalle");
		var unidad = request.getParameter("unidad");
		
		var ingrediente = new Ingrediente(detalle, unidad);
		
		idao.insert(ingrediente);
		
		response.sendRedirect(request.getContextPath()+"/ingredientes");
		
		return;
	}

}
