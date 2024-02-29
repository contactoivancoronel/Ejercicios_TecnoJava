package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Los datos persistentes del usuario
		var sessionRequest = request.getSession();

		var out = response.getWriter();

		request.setAttribute("nombre", "Pepe");

		// Los datos enviados por el usuario
		var parametroRequestId = request.getParameter("id");
		
		ArrayList<String> listaDeSession; 

		if (sessionRequest.getAttribute("lista_ids") == null) {
			
			listaDeSession = new ArrayList<String>();
			sessionRequest.setAttribute("lista_ids", listaDeSession);
		}else {
			listaDeSession = (ArrayList<String>) sessionRequest.getAttribute("lista_ids");
		}

		if (parametroRequestId != null) {
			
			sessionRequest.setAttribute("usuario_logueado", parametroRequestId);

			listaDeSession.add(parametroRequestId);
		}

		// Los datos agregados por el servidor
		var atributoRequest = request.getAttribute("nombre");

		var valorSession = sessionRequest.getAttribute("usuario_logueado");

		var salida = "param: " + parametroRequestId + "\n";

		salida += "atributo: " + atributoRequest + "\n";

		salida += "session: " + valorSession + "\n";

		salida += "tiempo: " + sessionRequest.getMaxInactiveInterval() + "\n";

		salida += "lista_ids: " + listaDeSession+ "\n";
		salida += "id_session: " + sessionRequest.getId()+ "\n";

		out.print(salida);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
