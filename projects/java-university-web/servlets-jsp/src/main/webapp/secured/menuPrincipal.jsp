<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="m" uri="http://universidad.dad2/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menú Principal - Gestión universidad</title>
<link rel="stylesheet" href="interfaz.css">

</head>
<body>
	<m:info />

	<h1>Menú Principal de Gestión</h1>
	<section id="contenedor" style="text-align: center; margin-top: 30px;">
		<form action="gestionTitulaciones.jsp" method="GET">
			<button class="menu-button">Gestionar titulaciones</button><br><br>
		</form>
		<form action="gestionAsignaturas.jsp" method="GET">
			<button class="menu-button">Gestionar asignaturas</button><br><br>
		</form>
		<form action="gestionProfesores.jsp" method="GET">
			<button class="menu-button">Gestionar profesores</button><br><br>
		</form>
	</section>
</body>
</html>
