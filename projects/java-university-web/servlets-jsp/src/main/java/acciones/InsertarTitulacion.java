package acciones;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dominio.*;
import java.util.Hashtable;

public class InsertarTitulacion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hashtable<String, Titulacion> titulaciones = (Hashtable<String, Titulacion>) request.getServletContext()
				.getAttribute("titulaciones");
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");

		if (titulaciones.get(id) == null) {
			titulaciones.put(id, new Titulacion(id, nombre));
		}
		response.sendRedirect(request.getContextPath() + "/secured/gestionTitulaciones.jsp");
	}

}
