package ar.com.maquetado.controllers;

import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.gniglio.models.Rectangulo;

@WebServlet("/RectangulosController")
public class RectangulosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RectangulosController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var listaRectangulos = Stream.generate( Rectangulo::getRandom)
			.limit(9999)
			.sorted( Comparator.comparing(Rectangulo::getArea)  )
			.toList();
		
		
		for (Rectangulo rectanguloActual : listaRectangulos) {
			
		}
		
		request.setAttribute("listaRectangulos", listaRectangulos);
		
		var rd =request.getRequestDispatcher("mostrar_rectangulos.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
