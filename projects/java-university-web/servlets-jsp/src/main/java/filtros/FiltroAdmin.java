package filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/secured/admin/*")
public class FiltroAdmin extends HttpFilter implements Filter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			if (request.getSession().getAttribute("admin") == null) {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
			else {
				chain.doFilter(request, response);
			}
		}
		else {
			chain.doFilter(request, response);
		}
	}
}
