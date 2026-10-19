<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar profesor</title>
</head>
<body>
	<h1>Modificar profesor</h1>
	<form action="../control" method="GET">
		<input type="hidden" name="dni" value="<%=request.getParameter("dni")%>">
		<label>Nuevo nombre</label><br>
		<input type="text" name="name"><br><br>
		<input type="hidden" name="id_accion" value="modificar_profesor">
		<input type="submit"><br><br>
	</form>
</body>
</html>