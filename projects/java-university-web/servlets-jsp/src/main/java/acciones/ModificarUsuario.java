package acciones;

import java.io.IOException;
import java.util.Hashtable;

import dominio.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarUsuario extends Accion{

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hashtable<String, Usuario> usuarios = (Hashtable<String, Usuario>) request.getServletContext().getAttribute("usuarios");
		String nuevoName = request.getParameter("nuevoName");
		String nuevoPass = request.getParameter("nuevoPass");
		String name = request.getParameter("name");
		
		Usuario u = usuarios.get(name);
		if(u != null) {
			usuarios.remove(name);
			u.setNombre(nuevoName);
			u.setPassword(nuevoPass);
			usuarios.put(nuevoName, u);
		}
		response.sendRedirect(request.getContextPath() + "/secured/interfazAdmin.jsp");
	}

}
