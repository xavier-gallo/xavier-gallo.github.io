<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestionar profesores</title>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript">
	 
		function load(id, nombre, apellidos){
			var entry = document.createElement('li');
			
			var aEditar = document.createElement('a');
			var linkEditar = document.createTextNode(" [Editar]");
			aEditar.appendChild(linkEditar);
			aEditar.onclick = function () {
				$('#id').val(id);
				$('#nombre').val(nombre);
				$('#apellidos').val(apellidos);
			}
			
			var aBorrar = document.createElement('a');
			var linkBorrar = document.createTextNode(" [Borrar]");
						
			aBorrar.appendChild(linkBorrar);
				
			aBorrar.onclick = function () {
				$.ajax({
				    url: 'rest/profesor/borrar/' + id,
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
			
			entry.appendChild(document.createTextNode("(" + id + ") " + nombre + " " + apellidos));
			entry.appendChild(aEditar);	
			entry.appendChild(aBorrar);			
			
			$('#profesores').append(entry);
			
		}
		$(document).ready(function(){
			
			$("#crearProfesor").click(function(){
				
				var profesorInfo = { id: ($('#id').val()), nombre: $('#nombre').val(), apellidos: $('#apellidos').val()};
				
			    $.ajax({
					    url: 'rest/profesor', 
					    headers: { 
				               'Accept': 'application/json',
				               'Content-Type': 'application/json' 
				           },
					    type: 'POST',
					    dataType: "json", 
					    success: function(result) {
					    	load(result.profesor.id, result.profesor.nombre, result.profesor.apellidos);
					    	$('#id').val('');
							$('#nombre').val('');
							$('#apellidos').val('');
					    },
				    	error: function(jqXhr, textStatus, errorMessage){
					    	alert('Error: ' + jqXhr.responseJSON.resultado);	
					    },
					    data:  JSON.stringify(profesorInfo)
					    
					});
			    });
		
			$("#actualizarProfesor").click(function () {
				var profesorInfo = { id: ($('#id').val()), nombre: $('#nombre').val(), apellidos: $('#apellidos').val()};

				$.ajax({
					data: JSON.stringify(profesorInfo),
					url: 'rest/profesor',
					headers: {
						'Accept': 'application/json',
						'Content-Type': 'application/json'
					},
					type: 'PUT',
					dataType: "json",
					success: function (result) {
						console.log(result);
						$('#' + result.profesor.id).remove();
						load(result.profesor.id, result.profesor.nombre, result.profesor.apellidos);
						$('#id').val('');
						$('#nombre').val('');
						$('#apellidos').val('');
					},
					error: function (jqXhr, textStatus, errorMessage) {
						alert('Error al actualizar');
					}
				});
			});
			
			
			$.ajax({
			    url: 'rest/profesor/listado',
			    type: 'GET',
			    dataType: "json",
			    success: function(result) {
					jQuery.each(result.profesor, function(i, val) {
			    		  load(val.id, val.nombre, val.apellidos);
			    		});
			    }
			});
		});
</script>
	
	
</head>
<body>

	<center><b>Gestionar Profesores</b></center><br>	
	Listado de profesores creados
	<br>
	<br>
	Id:<input type=text id="id"><br><br>
	Nombre:<input type=text id="nombre"><br><br>
	Apellidos:<input type=text id="apellidos"><br><br>
	<button id="crearProfesor">Crear</button>
	<button id="actualizarProfesor">Actualizar</button>
	<ul id="profesores"></ul>
</body>
</html>