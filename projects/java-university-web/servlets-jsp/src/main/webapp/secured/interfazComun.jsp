<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="dad2" uri="http://universidad.dad2/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión universidad</title>
<link rel="stylesheet" href="interfaz.css">
</head>
<body>
	<dad2:info />
	<h1>Zona de gestión</h1>
	<section id="contenedor">
		<form action="gestionTitulaciones.jsp" method="GET">
			<button>Gestionar titulaciones</button><br><br>
		</form>
		<form action="gestionAsignaturas.jsp" method="GET">
			<button>Gestionar asignaturas</button><br><br>
		</form>
		<form action="gestionProfesores.jsp" method="GET">
			<button>Gestionar profesores</button><br><br>
		</form>
	</section>
</body>
</html>