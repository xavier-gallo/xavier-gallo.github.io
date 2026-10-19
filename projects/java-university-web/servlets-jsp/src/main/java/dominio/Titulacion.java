package dominio;

import java.util.Hashtable;

public class Titulacion {
	private String id;
	private String nombre;
	private Hashtable<String, Asignatura> asignaturas;

	public Titulacion(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.asignaturas = new Hashtable<String, Asignatura>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void introducirAsignatura(Asignatura a) {
		asignaturas.put(a.getId(), a);
	}
}
