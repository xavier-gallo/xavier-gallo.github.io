package parsers;

import org.json.JSONObject;

import beans.Asignatura;
import beans.Profesor;
import beans.Titulacion;

public class ObjectParser {
	
	public static JSONObject titulacionToJSON(Titulacion t) {
		JSONObject titulacionjson = new JSONObject();
		titulacionjson.put("id", t.getId());
		titulacionjson.put("nombre", t.getNombre());
		titulacionjson.put("facultad", t.getFacultad());
		return titulacionjson;
	}
	
	public static Titulacion JSONToTitulacion(JSONObject titulacionjson) {
		Titulacion t = new Titulacion();
		t.setId(titulacionjson.getString("id"));
		t.setNombre(titulacionjson.getString("nombre"));
		t.setFacultad(titulacionjson.getString("facultad"));
		return t;
	}
	
	public static JSONObject asignaturaToJSON(Asignatura a) {
		JSONObject asignaturajson = new JSONObject();
		asignaturajson.put("id", a.getId());
		asignaturajson.put("nombre", a.getNombre());
		asignaturajson.put("creditos", a.getCreditos());
		asignaturajson.put("profesorId", a.getProfesorId() != null ? a.getProfesorId() : "");
		return asignaturajson;
	}
	
	public static Asignatura JSONToAsignatura(JSONObject asignaturajson) {
		Asignatura a = new Asignatura();
		a.setId(asignaturajson.getString("id"));
		a.setNombre(asignaturajson.getString("nombre"));
		a.setCreditos(asignaturajson.getInt("creditos"));
		if (asignaturajson.has("profesorId")) {
			a.setProfesorId(asignaturajson.getString("profesorId"));
		}
		return a;
	}
	
	public static JSONObject profesorToJSON(Profesor p) {
		JSONObject profesorjson = new JSONObject();
		profesorjson.put("id", p.getId());
		profesorjson.put("nombre", p.getNombre());
		profesorjson.put("apellidos", p.getApellidos());
		return profesorjson;
	}
	
	public static Profesor JSONToProfesor(JSONObject profesorjson) {
		Profesor p = new Profesor();
		p.setId(profesorjson.getString("id"));
		p.setNombre(profesorjson.getString("nombre"));
		p.setApellidos(profesorjson.getString("apellidos"));
		return p;
	}
}
