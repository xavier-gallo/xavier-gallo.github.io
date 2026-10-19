package bbdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.Profesor;
import exceptions.ApiException;

public class BaseDatosProf {
	private static Map<String, Profesor> profesores = new HashMap<String, Profesor>();
	
	public static Profesor getProf(String id) throws ApiException{
		Profesor p = new Profesor();
		if(profesores.containsKey(id)) {
			p = profesores.get(id);
			return p;
		}
		throw new ApiException("No existe ese profesor", 409);
	}
	
	public static boolean ingresarProf(Profesor p) throws ApiException{
		if(!profesores.containsKey(p.getId())) {
			profesores.put(p.getId(), p);
			return true;
		}
		throw new ApiException("Ya existe ese profesor", 409);
	}
	
	public static boolean modificarProf(Profesor p) throws ApiException{
		if(profesores.containsKey(p.getId())) {
			profesores.put(p.getId(), p);
			return true;
		}
		throw new ApiException("No existe ese profesor", 404);
	}
	
	public static boolean borrarProf(String id) throws ApiException {
		if(profesores.containsKey(id)) {
			profesores.remove(id);
			return true;
		}
		throw new ApiException("No existe ese profesor", 404);
	}
	
	public static List<Profesor> listar(){
		List<Profesor> lista = new ArrayList<Profesor>();
		for(Profesor p : profesores.values()) {
			lista.add(p);
		}
		return lista;
	}
}
