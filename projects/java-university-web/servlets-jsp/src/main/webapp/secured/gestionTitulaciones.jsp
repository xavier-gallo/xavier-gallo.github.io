<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dominio.*"%>
<%@ page import="java.util.Hashtable"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestionar titulaciones</title>
</head>
<body>
	<h1>Gestion de titulaciones</h1>
	<form action="../control" method="GET">
		<label>Id de titulacion</label><br>
		<input type="text" name="id"><br><br>
		<label>Nombre de la titulacion</label><br>
		<input type="text" name="nombre"><br><br>
		<input type="hidden" name="id_accion" value="insertar_titulacion"><br><br>
		<input type="submit"><br><br>
	</form>
	<%
	Hashtable<String, Titulacion> titulaciones = (Hashtable <String, Titulacion>)request.getServletContext().getAttribute("titulaciones");
	if(titulaciones != null){
		for(Titulacion t : titulaciones.values()){
	%>
			<%=t.getId()%> - <%=t.getNombre()%> | 
			<a href="../control?id=<%=t.getId()%>&id_accion=borrar_titulacion"> Borrar</a> |
			<a href="modificarTitulacion.jsp?id=<%=t.getId()%>"> Modificar</a><br><br>
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