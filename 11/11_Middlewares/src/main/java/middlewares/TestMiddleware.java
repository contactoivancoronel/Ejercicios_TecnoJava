package middlewares;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/casa","/test"})
public class TestMiddleware extends HttpFilter implements Filter {
       

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		request.setAttribute("hola", 1);
		response.getWriter().append("el middleware estuvo aqui, ");
		chain.doFilter(request, response);
		
		
//		var hResponse = (HttpServletResponse) response;
//		hResponse.sendRedirect("http://google.com");
		
	}



}
