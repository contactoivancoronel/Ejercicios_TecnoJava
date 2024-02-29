package ar.edu.unlz.pasteleria.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.unlz.pasteleria.daos.IngredientesDAO;
import ar.edu.unlz.pasteleria.models.Receta;
import ar.edu.unlz.pasteleria.models.Usuario;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		var session = request.getSession();

		var usuariosLogueado = (Usuario) session.getAttribute("usuario");

		
		var rd = request.getRequestDispatcher("views/home/index.jsp");
		rd.forward(request, response);
		
		
		
		
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		var sId = request.getParameter("id");
		var id = Integer.parseInt(sId);
		
		var idao = new IngredientesDAO();
		
		try {
			var ingrediente = idao.getById(id);
			
			
			var receta = (Receta)request.getSession().getAttribute("receta");
			receta = Optional.ofNullable(receta).orElse(new Receta());
			
			receta.addIngrediente(ingrediente);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		
		
		
	}

}
