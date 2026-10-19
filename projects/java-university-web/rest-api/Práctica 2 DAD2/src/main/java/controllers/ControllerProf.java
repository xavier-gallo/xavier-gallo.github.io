package controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.json.JSONObject;

import bbdd.BaseDatosAsig;
import bbdd.BaseDatosProf;
import beans.Asignatura;
import beans.Profesor;
import exceptions.ApiException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import parsers.ObjectParser;

@Path("/profesor")
public class ControllerProf {
	@GET
	@Path("/datos/{idProf}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProf(@PathParam("idProf") String id) {
		try {
			Profesor p = BaseDatosProf.getProf(id);
			JSONObject respuesta = new JSONObject();
			respuesta.put("profesor", ObjectParser.profesorToJSON(p));
			return Response.status(200).entity(respuesta.toString()).build();
		}
		catch(ApiException e) {
			JSONObject jsonError = new JSONObject();
			jsonError.put("resultado", e.getMessage());
			return Response.status(e.getHttpCode()).entity(jsonError.toString()).build();
		}
	}
	
	@GET
	@Path("/listado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		JSONObject respuesta = new JSONObject();
		List<Profesor> lista = BaseDatosProf.listar();
		for(Profesor p : lista) {
			respuesta.append("profesor", ObjectParser.profesorToJSON(p));
		}
		return Response.status(200).entity(respuesta.toString()).build();
	}
	
	@DELETE
	@Path("/borrar/{idProf}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrarProf(@PathParam("idProf") String id) {
		try {
			List<Asignatura> listaAsignaturas = BaseDatosAsig.listar();
	        for (Asignatura a : listaAsignaturas) {
	            if (a.getProfesorId() != null && a.getProfesorId().equals(id)) {
	                a.setProfesorId(null);
	                BaseDatosAsig.modificarAsig(a);
	            }
	        }
			BaseDatosProf.borrarProf(id);
			return Response.status(200).entity(true).build();
		}
		catch(ApiException e) {
			JSONObject jsonError = new JSONObject();
			jsonError.put("resultado", e.getMessage());
			return Response.status(e.getHttpCode()).entity(jsonError.toString()).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ingresarProf(InputStream inputStream) {
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder sb = new StringBuilder();
		String linea = "";
		try {
			while((linea = br.readLine()) != null) {
				sb.append(linea);
			}
		}
		catch(Exception e) {
			return Response.status(500).entity(true).build();
		}
		
		JSONObject jsonRecibido = new JSONObject(sb.toString());
		Profesor p = ObjectParser.JSONToProfesor(jsonRecibido);
		
		try {
			BaseDatosProf.ingresarProf(p);
		}
		catch(ApiException e) {
			JSONObject jsonError = new JSONObject();
			jsonError.put("resultado", e.getMessage());
			return Response.status(e.getHttpCode()).entity(jsonError.toString()).build();
		}
		
		JSONObject respuesta = new JSONObject();
		respuesta.put("profesor", ObjectParser.profesorToJSON(p));
		return Response.status(200).entity(respuesta.toString()).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificarProf(InputStream inputStream) {
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder sb = new StringBuilder();
		String linea = "";
		try {
			while((linea = br.readLine()) != null) {
				sb.append(linea);
			}
		}
		catch(Exception e) {
			return Response.status(500).entity(true).build();
		}
		
		JSONObject jsonRecibido = new JSONObject(sb.toString());
		Profesor p = ObjectParser.JSONToProfesor(jsonRecibido);
		
		try {
			BaseDatosProf.modificarProf(p);
		}
		catch(ApiException e) {
			JSONObject jsonError = new JSONObject();
			jsonError.put("resultado", e.getMessage());
			return Response.status(e.getHttpCode()).entity(jsonError.toString()).build();
		}
		
		JSONObject respuesta = new JSONObject();
		respuesta.put("profesor", ObjectParser.profesorToJSON(p));
		return Response.status(200).entity(respuesta.toString()).build();
	}
	
	
}
