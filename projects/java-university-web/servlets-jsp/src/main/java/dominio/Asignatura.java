package dominio;

import java.util.Hashtable;

public class Asignatura {
	private String id;
	private String nombre;
	private String nombreProfe;
	private String nombreTitulacion;
	
	public Asignatura(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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
	public String getNombreProfe() {
		return nombreProfe;
	}
	public void setNombreProfe(String nombreProfe) {
		this.nombreProfe = nombreProfe;
	}
	public String getNombreTitulacion() {
		return nombreTitulacion;
	}
	public void setNombreTitulacion(String nombreTitulacion) {
		this.nombreTitulacion = nombreTitulacion;
	}
	
}
