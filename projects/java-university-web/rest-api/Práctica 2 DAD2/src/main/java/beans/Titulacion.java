package beans;

public class Titulacion {
	private String id;
	private String nombre;
	private String facultad;
	
	public Titulacion() {}
	public Titulacion(String id, String nombre, String facultad) {
		this.id = id;
		this.nombre = nombre;
		this.facultad = facultad;
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
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	
}
