package acciones;

import java.io.IOException;
import java.util.Hashtable;

import dominio.Asignatura;
import dominio.Profesor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AsignarProfesor extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hashtable<String, Asignatura> asignaturas = (Hashtable<String, Asignatura>) request.getServletContext().getAttribute("asignaturas");
		Hashtable<String, Profesor> profesores = (Hashtable<String, Profesor>) request.getServletContext().getAttribute("profesores");
		
		String idAsignatura = request.getParameter("id");
		String dniProfesor = request.getParameter("dni_profesor");
		
		if (idAsignatura != null && dniProfesor != null) {
			Asignatura a = asignaturas.get(idAsignatura);
			Profesor p = profesores.get(dniProfesor);
			
			if (a != null && p != null) {
				a.setNombreProfe(p.getNombre());
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/secured/gestionAsignaturas.jsp");
	}

}
