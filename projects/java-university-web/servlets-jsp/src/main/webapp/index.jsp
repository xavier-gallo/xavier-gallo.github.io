<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iniciar sesión</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
	<h1>Iniciar sesión</h1>
	<form action="login" method="POST">
		<label>Nombre de usuario</label><br>
		<input type="text" name="user"><br><br>
		<label>Contraseña</label><br>
		<input type="text" name="pass"><br><br>
		<input type="submit" id="enviar"><br><br>
	</form>
	<%
		String error = (String)request.getAttribute("error");
		if(error != null){
	%>
			<p><%=error%></p>
	<%
		}
	%>
</body>
</html>