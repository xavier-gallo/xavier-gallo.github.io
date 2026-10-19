<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar titulacion</title>
</head>
<body>
	<h1>Modificar titulacion</h1>
	<form action="../control" method="GET">
		<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
		<label>Nuevo nombre</label><br>
		<input type="text" name="name"><br><br>
		<input type="hidden" name="id_accion" value="modificar_titulacion">
		<input type="submit"><br><br>
	</form>
</body>
</html>