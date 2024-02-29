package controllers;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;

import apis.ArgentinaGeoApi;
import models.Centroide;
import models.Municipio;
import models.Provincia;

/**
 * Servlet implementation class MunicipiosController
 */
@WebServlet("/MunicipiosController")
public class MunicipiosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArgentinaGeoApi argApi;

	public MunicipiosController() {
		super();
		argApi = new ArgentinaGeoApi();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");
		accion = Optional.ofNullable(accion).orElse("listar"); 

		switch (accion) {
		case "listar" -> getListar(request, response);
		case "mosrtar" -> getMostrar(request, response);
		case "solog" -> getSoloG(request, response);
		}

	}

	private void getSoloG(HttpServletRequest request, HttpServletResponse response) throws ClientProtocolException, IOException, ServletException {
		
		Function<Municipio, Centroide> extCentroide = Municipio::getCentroide;
		var extLongitud = extCentroide.andThen(Centroide::getLon);
		var extLatitud = extCentroide.andThen(Centroide::getLat);
		
		var listaG = argApi.getMunicipios().stream()
				
			.filter( (muni)-> muni.getNombre().toLowerCase().charAt(0) == 'g' )
			.filter( muni -> muni.getNombreProvincia().equals("La Rioja")  )
			.sorted(  Comparator.comparing(extLongitud) )			
			.toList();
			
		request.setAttribute("municipios", listaG);
		var rd = request.getRequestDispatcher("views/municipios/index.jsp");
		rd.forward(request, response);
		
	}

	private void getMostrar(HttpServletRequest request, HttpServletResponse response)
			throws ClientProtocolException, IOException {
		String id = request.getParameter("id");

		var muni = argApi.getMunicipio(id);
		response.getWriter().print(muni);

	}

	private void getListar(HttpServletRequest request, HttpServletResponse response)
			throws ClientProtocolException, IOException, ServletException {
		
		var munis = argApi.getMunicipios().stream()
				.sorted(Comparator.comparing(Municipio::getNombreProvincia))
				.toList();
		
		request.setAttribute("municipios", munis);
		
		var rd = request.getRequestDispatcher("views/municipios/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
