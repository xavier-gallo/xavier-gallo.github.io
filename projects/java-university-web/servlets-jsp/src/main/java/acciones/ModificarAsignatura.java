package acciones;

import java.io.IOException;
import java.util.Hashtable;

import dominio.Asignatura;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarAsignatura extends Accion{

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hashtable<String, Asignatura> asignaturas = (Hashtable<String, Asignatura>) request.getServletContext().getAttribute("asignaturas");
		String id = request.getParameter("id");
		String nombre = request.getParameter("name");
		Asignatura a = asignaturas.get(id);
		a.setNombre(nombre);
		response.sendRedirect(request.getContextPath() + "/secured/gestionAsignaturas.jsp");
		
	}

}
