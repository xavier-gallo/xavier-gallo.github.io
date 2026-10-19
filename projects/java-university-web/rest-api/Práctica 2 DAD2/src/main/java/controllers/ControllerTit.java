package controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import exceptions.ApiException;
import org.json.JSONObject;

import bbdd.BaseDatosTit;
import beans.Titulacion;
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

@Path("/titulacion")
public class ControllerTit {
	@GET
	@Path("/datos/{idTit}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listado(@PathParam("idTit") String id) {
		JSONObject respuesta = new JSONObject();
		
		try {
			Titulacion tit = BaseDatosTit.getTit(id);
			respuesta.put("titulacion", ObjectParser.titulacionToJSON(tit));
			return Response.status(200).entity(respuesta.toString()).build();
		}
		catch(ApiException e){
			JSONObject jsonError = new JSONObject();
			jsonError.put("resultado", e.getMessage());
			return Response.status(400).entity(jsonError.toString()).build();
		}
	}
	
	@GET
	@Path("/listado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		JSONObject jsonRespuesta = new JSONObject();
		List<Titulacion> lista = BaseDatosTit.listar();
		for(Titulacion t : lista) {
			jsonRespuesta.append("titulacion", ObjectParser.titulacionToJSON(t));
		}
		return Response.status(200).entity(jsonRespuesta.toString()).build();
	}
	
	
	@DELETE
	@Path("/borrar/{idTit}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrarTit(@PathParam("idTit") String id) {
		try {
			BaseDatosTit.borrarTit(id);
			return Response.status(200).entity(true).build();
		}
		catch(ApiException e){
			JSONObject jsonError = new JSONObject();
			jsonError.put("resultado", e.getMessage());
			return Response.status(500).entity(jsonError.toString()).build();
		}
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alta(InputStream inputStream) {
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
		
		Titulacion nueva = ObjectParser.JSONToTitulacion(jsonRecibido);
		
		try {
			BaseDatosTit.ingresarTit(nueva);
		}
		catch(ApiException e) {
			JSONObject jsonError = new JSONObject();
			jsonError.put("resultado", e.getMessage());
			return Response.status(e.getHttpCode()).entity(jsonError.toString()).build();
		}
		
		JSONObject jsonRespuesta = new JSONObject();
		jsonRespuesta.put("titulacion", ObjectParser.titulacionToJSON(nueva));
		return Response.status(200).entity(jsonRespuesta.toString()).build();
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificar(InputStream inputStream) {
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
		
		Titulacion actualizar = ObjectParser.JSONToTitulacion(jsonRecibido);
		
		try {
			BaseDatosTit.modificarTit(actualizar);
		}
		catch(ApiException e) {
			JSONObject jsonError = new JSONObject();
			jsonError.put("resultado", e.getMessage());
			return Response.status(e.getHttpCode()).entity(jsonError.toString()).build();
		}
		
		JSONObject jsonRespuesta = new JSONObject();
		jsonRespuesta.put("titulacion", ObjectParser.titulacionToJSON(actualizar));
		return Response.status(200).entity(jsonRespuesta.toString()).build();
	}
}
