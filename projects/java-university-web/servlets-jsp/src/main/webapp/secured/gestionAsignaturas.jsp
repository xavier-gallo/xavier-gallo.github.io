<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dominio.*"%>
<%@ page import="java.util.Hashtable"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestionar asignaturas</title>
</head>
<body>
	<h1>Gestion de asignaturas</h1>
	<form action="../control" method="GET">
		<label>Id de la asignatura</label><br>
		<input type="text" name="id"><br><br>
		<label>Nombre de la asignatura</label><br>
		<input type="text" name="nombre"><br><br>
		<input type="hidden" name="id_accion" value="insertar_asignatura"><br><br>
		<input type="submit"><br><br>
	</form>
	<%
	Hashtable<String, Asignatura> asignaturas = (Hashtable <String, Asignatura>)request.getServletContext().getAttribute("asignaturas");
	if(asignaturas != null){
		for(Asignatura a : asignaturas.values()){
			String profeAsignado = (a.getNombreProfe() != null) ? a.getNombreProfe() : "Ninguno";
	%>
			<%=a.getId()%> - <%=a.getNombre()%> <em>(Profesor: <%=profeAsignado%>)</em> | 
			<a href="../control?id=<%=a.getId()%>&id_accion=borrar_asignatura"> Borrar</a> |
			<a href="modificarAsignatura.jsp?id=<%=a.getId()%>"> Modificar</a> |
			<a href="asignarProfesor.jsp?id=<%=a.getId()%>"> Asignar Profesor</a><br><br>
	<%
		}
	}
	%>
	<br><br>
			<a href="<%=request.getContextPath()%>/secured/interfazComun.jsp">
    		<button type="button">Volver</button>
		</a>
</body>
</html>