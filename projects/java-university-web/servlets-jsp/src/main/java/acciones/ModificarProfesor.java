package acciones;

import java.io.IOException;
import java.util.Hashtable;

import dominio.Asignatura;
import dominio.Profesor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarProfesor extends Accion{

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hashtable<String, Profesor> profesores = (Hashtable<String, Profesor>) request.getServletContext().getAttribute("profesores");
		Hashtable<String, Asignatura> asignaturas = (Hashtable<String, Asignatura>) request.getServletContext().getAttribute("asignaturas");
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("name");
		Profesor p = profesores.get(dni);
		for(Asignatura a : asignaturas.values()) {
			if(a.getNombreProfe().equals(p.getNombre())) {
				a.setNombreProfe(nombre);
			}
		}
		p.setNombre(nombre);
		
		
		response.sendRedirect(request.getContextPath() + "/secured/gestionProfesores.jsp");
		
	}

}
