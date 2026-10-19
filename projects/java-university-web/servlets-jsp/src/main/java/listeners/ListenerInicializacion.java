package listeners;

import java.util.Hashtable;

import acciones.*;
import dominio.*;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ListenerInicializacion implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Contexto inicializado");
		if (sce.getServletContext().getAttribute("titulaciones") == null) {
			Hashtable <String, Titulacion> titulaciones = new Hashtable<String, Titulacion>();
			sce.getServletContext().setAttribute("titulaciones", titulaciones);
		}
		if (sce.getServletContext().getAttribute("asignaturas") == null) {
			Hashtable <String, Asignatura> asignaturas = new Hashtable<String, Asignatura>();
			sce.getServletContext().setAttribute("asignaturas", asignaturas);
		}
		if (sce.getServletContext().getAttribute("profesores") == null) {
			Hashtable <String, Profesor> profesores = new Hashtable<String, Profesor>();
			sce.getServletContext().setAttribute("profesores", profesores);
		}
		if (sce.getServletContext().getAttribute("usuarios") == null) {
			Hashtable<String, Usuario> usuarios = new Hashtable<String, Usuario>();
			Usuario nuevoUsuario = new Usuario("javi", "javi");
			Usuario nuevoUsuario2 = new Usuario("xavi", "xavi");
			usuarios.put(nuevoUsuario.getNombre(), nuevoUsuario);
			usuarios.put(nuevoUsuario2.getNombre(), nuevoUsuario2);
			sce.getServletContext().setAttribute("usuarios", usuarios);
		}
		if (sce.getServletContext().getAttribute("acciones") == null) {
			Hashtable <String, Accion> acciones = new Hashtable<String, Accion>();
			sce.getServletContext().setAttribute("acciones", acciones);
			
			acciones.put("insertar_titulacion", new InsertarTitulacion());
			acciones.put("modificar_titulacion", new ModificarTitulacion());
			acciones.put("borrar_titulacion", new BorrarTitulacion());
			
			acciones.put("insertar_usuario", new InsertarUsuario());
			acciones.put("modificar_usuario", new ModificarUsuario());
			acciones.put("borrar_usuario", new BorrarUsuario());
			
			acciones.put("insertar_asignatura", new InsertarAsignatura());
			acciones.put("modificar_asignatura", new ModificarAsignatura());
			acciones.put("borrar_asignatura", new BorrarAsignatura());
			
			acciones.put("insertar_profesor", new InsertarProfesor());
			acciones.put("modificar_profesor", new ModificarProfesor());
			acciones.put("borrar_profesor", new BorrarProfesor());
			
			acciones.put("asignar_profesor", new AsignarProfesor());
		}
	}
	
}
