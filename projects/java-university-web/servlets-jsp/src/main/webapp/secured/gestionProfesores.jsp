<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dominio.*"%>
<%@ page import="java.util.Hashtable"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestionar profesores</title>
</head>
<body>
	<h1>Gestion de profesores</h1>
	<form action="../control" method="GET">
		<label>DNI del profesor</label><br>
		<input type="text" name="dni"><br><br>
		<label>Nombre del profesor</label><br>
		<input type="text" name="nombre"><br><br>
		<input type="hidden" name="id_accion" value="insertar_profesor"><br><br>
		<input type="submit"><br><br>
	</form>
	<%
	Hashtable<String, Profesor> profesores = (Hashtable <String, Profesor>)request.getServletContext().getAttribute("profesores");
	if(profesores != null){
		for(Profesor p : profesores.values()){
	%>
			<%=p.getDni()%> - <%=p.getNombre()%> | 
			<a href="../control?dni=<%=p.getDni()%>&id_accion=borrar_profesor"> Borrar</a> |
			<a href="modificarProfesor.jsp?dni=<%=p.getDni()%>"> Modificar</a><br><br>
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