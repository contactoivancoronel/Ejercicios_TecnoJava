package ar.edu.unlz.pasteleria.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.unlz.pasteleria.daos.UsuariosDAO;
import ar.edu.unlz.pasteleria.models.Usuario;

@WebServlet("/usuarios")
public class UsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Dependencia
	private UsuariosDAO udao;

	public UsuariosController() {
		super();
		this.udao = new UsuariosDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getSession().getAttribute("usuario")!= null) {
			response.sendRedirect("home");
			return;
		}
		
		
		var accion = request.getParameter("accion");

		accion = Optional.ofNullable(accion).orElse("login");

		switch (accion) {
		case "register" -> getRegister(request, response);
		case "login" -> getLogin(request, response);

		default -> response.getWriter().append("Not found");
		}

	}

	private void getLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		
		
		var rd = request.getRequestDispatcher("views/usuarios/login.jsp");
		rd.forward(request, response);
	}

	private void getRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var rd = request.getRequestDispatcher("views/usuarios/register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var accion = request.getParameter("accion");

		accion = Optional.ofNullable(accion).orElse("");

		try {

			switch (accion) {
			case "register" -> postRegister(request, response);
			case "login" -> postLogin(request, response);

			default -> response.getWriter().append("Not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().append("Ups! Algo salio mal");
		}
	}

	private void postLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		var session = request.getSession();
		
		var nombre = request.getParameter("usuario");
		var clave = request.getParameter("clave");

		var usuario = udao.getByUsername(nombre);

		if (usuario == null) {
			response.getWriter().append("No existe");
			return;
		} else if (!usuario.validarClave(clave)) {
			response.getWriter().append("Clave invalida");
			return;
		} else {
			session.setAttribute("usuario",usuario);
			response.sendRedirect("home");
		}

	}

	private void postRegister(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		var nombre = request.getParameter("usuario");
		var clave = request.getParameter("clave");

		var usuario = new Usuario(nombre, clave);

		udao.insert(usuario);

	}

}
