package controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.json.JSONObject;

import bbdd.BaseDatosAsig;
import beans.Asignatura;
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

@Path("/asignatura")
public class ControllerAsig {
	@GET
	@Path("/datos/{idAsig}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAsig(@PathParam("idAsig") String id) {
		try {
			Asignatura a = BaseDatosAsig.getAsig(id);
			JSONObject jsonAsig = new JSONObject();
			jsonAsig.put("asignatura", ObjectParser.asignaturaToJSON(a));
			return Response.status(200).entity(jsonAsig.toString()).build();
			
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
		List<Asignatura> lista = BaseDatosAsig.listar();
		for(Asignatura a : lista) {
			respuesta.append("asignatura", ObjectParser.asignaturaToJSON(a));
		}
		return Response.status(200).entity(respuesta.toString()).build();
	}
	
	@DELETE
	@Path("/borrar/{idAsig}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrarAsig(@PathParam("idAsig") String id) {
		try {
			BaseDatosAsig.borrarAsig(id);
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
	public Response crearAsig(InputStream inputStream) {
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
		
		Asignatura a = ObjectParser.JSONToAsignatura(jsonRecibido);
		
		if (a.getProfesorId() != null && !a.getProfesorId().trim().isEmpty()) {
			try {
				bbdd.BaseDatosProf.getProf(a.getProfesorId());
			} catch (ApiException e) {
				JSONObject jsonError = new JSONObject();
				jsonError.put("resultado", "El profesor asignado no existe.");
				return Response.status(404).entity(jsonError.toString()).build();
			}
		}
		
		try {
			BaseDatosAsig.insertarAsig(a);
		}
		catch(ApiException e) {
			JSONObject jsonError = new JSONObject();
			jsonError.put("resultado", e.getMessage());
			return Response.status(e.getHttpCode()).entity(jsonError.toString()).build();
		}
		
		JSONObject respuesta = new JSONObject();
		respuesta.put("asignatura", ObjectParser.asignaturaToJSON(a));
		return Response.status(200).entity(respuesta.toString()).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificarAsig(InputStream inputStream) {
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
		Asignatura a = ObjectParser.JSONToAsignatura(jsonRecibido);
		
		if (a.getProfesorId() != null && !a.getProfesorId().trim().isEmpty()) {
			try {
				bbdd.BaseDatosProf.getProf(a.getProfesorId());
			} catch (ApiException e) {
				JSONObject jsonError = new JSONObject();
				jsonError.put("resultado", "El profesor asignado no existe.");
				return Response.status(404).entity(jsonError.toString()).build();
			}
		}
		
		try {
			BaseDatosAsig.modificarAsig(a);
		}
		catch(ApiException e){
			JSONObject jsonError = new JSONObject();
			jsonError.put("resultado", e.getMessage());
			return Response.status(e.getHttpCode()).entity(jsonError.toString()).build();
		}
		
		JSONObject respuesta = new JSONObject();
		respuesta.put("asignatura", ObjectParser.asignaturaToJSON(a));
		return Response.status(200).entity(respuesta.toString()).build();
	}
	
}
