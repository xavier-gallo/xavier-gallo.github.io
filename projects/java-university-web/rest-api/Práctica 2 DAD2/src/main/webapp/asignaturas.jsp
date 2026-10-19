<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestionar asignaturas</title>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript">
	 
		function load(id, nombre, creditos, profesorId){
			var entry = document.createElement('li');
			
			var aEditar = document.createElement('a');
			var linkEditar = document.createTextNode(" [Editar]");
			aEditar.appendChild(linkEditar);
			aEditar.onclick = function () {
				$('#id').val(id);
				$('#nombre').val(nombre);
				$('#creditos').val(creditos);
				$('#profesorId').val(profesorId);
			}
			
			var aBorrar = document.createElement('a');
			var linkBorrar = document.createTextNode(" [Borrar]");
						
			aBorrar.appendChild(linkBorrar);
				
			aBorrar.onclick = function () {
				$.ajax({
				    url: 'rest/asignatura/borrar/' + id,
				    type: 'DELETE',
				    dataType: "json",
				    success: function(result) {
				    	document.getElementById(id).remove();
				    },
			    	error: function(jqXhr, textStatus, errorMessage){
				    	alert('error');	
				    }
				});
			};
	
			
			entry.id = id;		
			
			var profeInfo = profesorId ? " (Prof: " + profesorId + ")" : "";
			entry.appendChild(document.createTextNode("(" + id + ") " + nombre + " - " + creditos + profeInfo));
			entry.appendChild(aEditar);	
			entry.appendChild(aBorrar);			
			
			$('#asignaturas').append(entry);
			
		}
		$(document).ready(function(){
			
			$("#crearAsignatura").click(function(){
				
				var asignaturaInfo = { id: ($('#id').val()), nombre: $('#nombre').val(), creditos: $('#creditos').val(), profesorId: $('#profesorId').val()};
				
			    $.ajax({
					    url: 'rest/asignatura', 
					    headers: { 
				               'Accept': 'application/json',
				               'Content-Type': 'application/json' 
				           },
					    type: 'POST',
					    dataType: "json", 
					    success: function(result) {
					    	load(result.asignatura.id, result.asignatura.nombre, result.asignatura.creditos, result.asignatura.profesorId);
					    	$('#id').val('');
							$('#nombre').val('');
							$('#creditos').val('');
							$('#profesorId').val('');
					    },
				    	error: function(jqXhr, textStatus, errorMessage){
					    	alert('Error: ' + jqXhr.responseJSON.resultado);	
					    },
					    data:  JSON.stringify(asignaturaInfo)
					    
					});
			    });
		
			$("#actualizarAsignatura").click(function () {
				var asignaturaInfo = { id: ($('#id').val()), nombre: $('#nombre').val(), creditos: $('#creditos').val(), profesorId: $('#profesorId').val()};

				$.ajax({
					data: JSON.stringify(asignaturaInfo),
					url: 'rest/asignatura',
					headers: {
						'Accept': 'application/json',
						'Content-Type': 'application/json'
					},
					type: 'PUT',
					dataType: "json",
					success: function (result) {
						console.log(result);
						$('#' + result.asignatura.id).remove();
						load(result.asignatura.id, result.asignatura.nombre, result.asignatura.creditos, result.asignatura.profesorId);
						$('#id').val('');
						$('#nombre').val('');
						$('#creditos').val('');
						$('#profesorId').val('');
					},
					error: function (jqXhr, textStatus, errorMessage) {
						alert('Error al actualizar');
					}
				});
			});
			
			
			$.ajax({
			    url: 'rest/asignatura/listado',
			    type: 'GET',
			    dataType: "json",
			    success: function(result) {
					jQuery.each(result.asignatura, function(i, val) {
			    		  load(val.id, val.nombre, val.creditos, val.profesorId);
			    		});
			    }
			});
		});
</script>
	
	
</head>
<body>

	<center><b>Gestionar asignaturas</b></center><br>	
	Listado de asignaturas creadas
	<br>
	<br>
	Id:<input type=text id="id"><br><br>
	Nombre:<input type=text id="nombre"><br><br>
	Creditos:<input type=text id="creditos"><br><br>
	Id Profesor:<input type=text id="profesorId"><br><br>
	<button id="crearAsignatura">Crear</button>
	<button id="actualizarAsignatura">Actualizar</button>
	<ul id="asignaturas"></ul>
</body>
</html>