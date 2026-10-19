package acciones;

import java.io.IOException;
import java.util.Hashtable;

import dominio.Titulacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarTitulacion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hashtable<String, Titulacion> titulaciones = (Hashtable<String, Titulacion>) request.getServletContext().getAttribute("titulaciones");
		String id = request.getParameter("id");
		String nombre = request.getParameter("name");
		Titulacion t = titulaciones.get(id);
		t.setNombre(nombre);
		response.sendRedirect(request.getContextPath() + "/secured/gestionTitulaciones.jsp");
	}

}
