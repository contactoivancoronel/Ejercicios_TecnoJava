package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/*")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getPathInfo().toString();

		switch (path) {
			case "/index" -> index(request, response);
			case "/create" -> create(request, response);
			case "/edit" -> edit(request, response);
			default -> response.sendError(404, "Not found");
		}

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("Usted selecciono la opcion para editar un usuario");
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("Usted selecciono la opcion para crear un usuario");

	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("Usted selecciono la opcion para ver el index");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
