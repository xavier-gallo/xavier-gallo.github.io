package beans;

public class Asignatura {
	private String id;
	private String nombre;
	private int creditos;
	private String profesorId;
	
	public Asignatura() {}
	public Asignatura(String id, String nombre, int creditos, String profesorId) {
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
		this.profesorId = profesorId;
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
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public String getProfesorId() {
		return profesorId;
	}
	public void setProfesorId(String profesorId) {
		this.profesorId = profesorId;
	}
}
