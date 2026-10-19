<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dominio.*"%>
<%@ page import="java.util.Hashtable"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asignar Profesor</title>
</head>
<body>
	<%
	String idAsignatura = request.getParameter("id");
	Hashtable<String, Asignatura> asignaturas = (Hashtable<String, Asignatura>) request.getServletContext().getAttribute("asignaturas");
	Hashtable<String, Profesor> profesores = (Hashtable<String, Profesor>) request.getServletContext().getAttribute("profesores");
	
	Asignatura asignatura = null;
	if(asignaturas != null && idAsignatura != null) {
		asignatura = asignaturas.get(idAsignatura);
	}
	%>
	
	<h1>Asignar Profesor a Asignatura</h1>
	<% if (asignatura != null) { %>
		<p>Asignatura seleccionada: <strong><%=asignatura.getNombre()%> (ID: <%=asignatura.getId()%>)</strong></p>
		
		<form action="../control" method="GET">
			<input type="hidden" name="id" value="<%=asignatura.getId()%>">
			<input type="hidden" name="id_accion" value="asignar_profesor">
			
			<label>Selecciona un Profesor:</label><br>
			<select name="dni_profesor">
				<%
				if (profesores != null && !profesores.isEmpty()) {
					for (Profesor p : profesores.values()) {
						String selected = "";
						if (asignatura.getNombreProfe() != null && asignatura.getNombreProfe().equals(p.getNombre())) {
							selected = "selected";
						}
				%>
						<option value="<%=p.getDni()%>" <%=selected%>><%=p.getNombre()%> (DNI: <%=p.getDni()%>)</option>
				<%
					}
				} else {
				%>
					<option value="" disabled>No hay profesores disponibles</option>
				<%
				}
				%>
			</select><br><br>
			<input type="submit" value="Asignar">
		</form>
	<% } else { %>
		<p>Error: No se ha encontrado la asignatura.</p>
	<% } %>
	
	<br><br>
	<a href="gestionAsignaturas.jsp"><button type="button">Volver</button></a>
</body>
</html>
