package ar.edu.unlz.pasteleria.middlewares;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/home"})
public class AuthMiddleware extends HttpFilter implements Filter {    



	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		var httpRequest = (HttpServletRequest) request;
		var httpResponse = (HttpServletResponse) response;

		if(httpRequest.getSession().getAttribute("usuario")== null) {
			httpResponse.sendRedirect("usuarios");
			return;
		}
		
		
		chain.doFilter(request, response);
	}

}
