package acciones;

import java.io.IOException;
import java.util.Hashtable;

import dominio.Profesor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertarProfesor extends Accion{

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hashtable<String, Profesor> profesores = (Hashtable<String, Profesor>) request.getServletContext()
				.getAttribute("profesores");
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");

		if (profesores.get(dni) == null) {
			profesores.put(dni, new Profesor(dni, nombre));
		}
		response.sendRedirect(request.getContextPath() + "/secured/gestionProfesores.jsp");
		
	}
	
}
