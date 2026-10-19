<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dominio.*"%>
<%@ page import="java.util.Hashtable"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zona admin</title>
</head>
<body>
	<h1>Zona de administrador - Gestion de usuarios</h1>
	<form action="../control" method="GET">
		<label>Nombre del usuario</label><br>
		<input type="text" name="name"><br><br>
		<label>Contraseña del usuario</label><br>
		<input type="text" name="pass"><br><br>
		<input type="hidden" name="id_accion" value="insertar_usuario"><br><br>
		<input type="submit"><br><br>
	</form>
	<%
	Hashtable<String, Usuario> usuarios = (Hashtable <String, Usuario>)request.getServletContext().getAttribute("usuarios");
	if(usuarios != null){
		for(Usuario u : usuarios.values()){
	%>
			<%=u.getNombre()%> - <%=u.getPassword()%> | 
			<a href="../control?name=<%=u.getNombre()%>&id_accion=borrar_usuario"> Borrar</a> |
			<a href="modificarUsuario.jsp?name=<%=u.getNombre()%>"> Modificar</a><br><br>
	<%
		}
	}
	%>
	<br><br>
			<a href="<%=request.getContextPath()%>/index.jsp">
    		<button type="button">Volver</button>
		</a>
</body>
</html>