package acciones;

import java.io.IOException;
import java.util.Hashtable;

import dominio.Asignatura;
import dominio.Profesor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BorrarProfesor extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hashtable<String, Profesor> profesores = (Hashtable<String, Profesor>) request.getServletContext().getAttribute("profesores");
		Hashtable<String, Asignatura> asignaturas = (Hashtable<String, Asignatura>) request.getServletContext().getAttribute("asignaturas");
		String dni = request.getParameter("dni");
		
		for(Asignatura a : asignaturas.values()) {
			if(a.getNombreProfe().equals(profesores.get(dni).getNombre())) {
				a.setNombreProfe("Ninguno");
			}
		}
		profesores.remove(dni);
		
		response.sendRedirect(request.getContextPath() + "/secured/gestionProfesores.jsp");
		
	}

}
