package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Hashtable;

import dominio.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		Hashtable<String, Usuario> usuarios = (Hashtable<String, Usuario>)request.getServletContext().getAttribute("usuarios");
		//Usuario admin
		if (user.equals("admin") && pass.equals("admin")) {
			request.getSession().setAttribute("logueado", true);
			request.getSession().setAttribute("admin", true);
			response.sendRedirect(request.getContextPath() + "/secured/admin/interfazAdmin.jsp");
			return;
		}
		//Usuario común
		if (usuarios.get(user) != null && usuarios.get(user).getPassword().equals(pass)) {
			request.getSession().setAttribute("logueado", true);
			response.sendRedirect(request.getContextPath() + "/secured/interfazComun.jsp");
		}
		else {
			request.setAttribute("error", "Credenciales incorrectas.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
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
