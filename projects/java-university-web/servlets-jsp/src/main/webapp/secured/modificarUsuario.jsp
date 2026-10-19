<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar usuario</title>
</head>
<body>
	<h1>Modificar usuario</h1>
	<form action="../control" method="GET">
		<label>Nuevo nombre</label><br>
		<input type="text" name="nuevoName"><br><br>
		<label>Nueva contraseña</label><br>
		<input type="text" name="nuevoPass"><br><br>
		<input type="hidden" name="id_accion" value="modificar_usuario">
		<input type="hidden" name="name" value="<%=request.getParameter("name")%>">
		<input type="submit"><br><br>
	</form>
	
</body>
</html>