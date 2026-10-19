package acciones;

import java.io.IOException;
import java.util.Hashtable;

import dominio.Titulacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BorrarTitulacion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hashtable<String, Titulacion> titulaciones = (Hashtable<String, Titulacion>) request.getServletContext()
				.getAttribute("titulaciones");
		String id = request.getParameter("id");

		titulaciones.remove(id);
		response.sendRedirect(request.getContextPath() + "/secured/gestionTitulaciones.jsp");
	}

}
