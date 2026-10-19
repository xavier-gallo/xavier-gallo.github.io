package bbdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.Titulacion;
import exceptions.ApiException;

public class BaseDatosTit {
	
	private static Map <String, Titulacion> titulaciones = new HashMap<String, Titulacion>();
	
	
	public static Titulacion getTit(String id) throws ApiException {
		Titulacion t = titulaciones.get(id);
		if(t == null) {
			throw new ApiException("No existe esa titulacion", 404);
		}
		return t;
	}
	
	public static boolean ingresarTit(Titulacion t) throws ApiException {
		if(!titulaciones.containsKey(t.getId())) {
			titulaciones.put(t.getId(), t);
			return true;
		}
		throw new ApiException("Ya existe esa titulacion", 409);
	}
	public static boolean modificarTit(Titulacion t) throws ApiException {
		if(titulaciones.containsKey(t.getId())) {
			titulaciones.put(t.getId(), t);
			return true;
		}
		throw new ApiException("No existe esa titulacion", 404);
	}
	public static boolean borrarTit(String id) throws ApiException {
		if(titulaciones.containsKey(id)){
			titulaciones.remove(id);
			return true;
		}
		throw new ApiException("No existe esa titulacion", 404);
	}
	public static List<Titulacion> listar(){
		List<Titulacion> lista = new ArrayList<Titulacion>();
		for(Titulacion e : titulaciones.values()) {
			lista.add(e);
		}
		return lista;
	}
}
