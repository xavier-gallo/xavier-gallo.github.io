package acciones;

import java.io.IOException;
import java.util.Hashtable;

import dominio.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertarUsuario extends Accion{

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hashtable<String, Usuario> usuarios = (Hashtable<String, Usuario>) request.getServletContext().getAttribute("usuarios");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		if (usuarios.get(name) == null) {
			usuarios.put(name, new Usuario(name, pass));
		}
		response.sendRedirect(request.getContextPath() + "/secured/interfazAdmin.jsp");
	}
	
}
