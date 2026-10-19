<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestionar titulaciones</title>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript">
	 
		function load(id, nombre, facultad){
			var entry = document.createElement('li');
			
			var aEditar = document.createElement('a');
			var linkEditar = document.createTextNode(" [Editar]");
			aEditar.appendChild(linkEditar);
			aEditar.onclick = function () {
				$('#id').val(id);
				$('#nombre').val(nombre);
				$('#facultad').val(facultad);
			}
			
			var aBorrar = document.createElement('a');
			var linkBorrar = document.createTextNode(" [Borrar]");
						
			aBorrar.appendChild(linkBorrar);
				
			aBorrar.onclick = function () {
				$.ajax({
				    url: 'rest/titulacion/borrar/' + id,
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
			
			entry.appendChild(document.createTextNode("(" + id + ") " + nombre + " - " + facultad));
			entry.appendChild(aEditar);	
			entry.appendChild(aBorrar);			
			
			$('#titulaciones').append(entry);
			
		}
		$(document).ready(function(){
			
			$("#crearTitulacion").click(function(){
				
				var titulacionInfo = { id: ($('#id').val()), nombre: $('#nombre').val(), facultad: $('#facultad').val()};
				
			    $.ajax({
					    url: 'rest/titulacion', 
					    headers: { 
				               'Accept': 'application/json',
				               'Content-Type': 'application/json' 
				           },
					    type: 'POST',
					    dataType: "json", 
					    success: function(result) {
					    	load(result.titulacion.id, result.titulacion.nombre, result.titulacion.facultad);
					    	$('#id').val('');
							$('#nombre').val('');
							$('#facultad').val('');
					    },
				    	error: function(jqXhr, textStatus, errorMessage){
					    	alert('Error: ' + jqXhr.responseJSON.resultado);	
					    },
					    data:  JSON.stringify(titulacionInfo)
					    
					});
			    });
		
			$("#actualizarTitulacion").click(function () {
				var titulacionInfo = { id: ($('#id').val()), nombre: $('#nombre').val(), facultad: $('#facultad').val()};

				$.ajax({
					data: JSON.stringify(titulacionInfo),
					url: 'rest/titulacion',
					headers: {
						'Accept': 'application/json',
						'Content-Type': 'application/json'
					},
					type: 'PUT',
					dataType: "json",
					success: function (result) {
						console.log(result);
						$('#' + result.titulacion.id).remove();
						load(result.titulacion.id, result.titulacion.nombre, result.titulacion.facultad);
						$('#id').val('');
						$('#nombre').val('');
						$('#facultad').val('');
					},
					error: function (jqXhr, textStatus, errorMessage) {
						//TODO : mejora en la vixualizaci�n de errores
						/* Poner mensaje de error devuelto por el backend */
						alert('Error al actualizar');
					}
				});
			});
			
			
			$.ajax({
			    url: 'rest/titulacion/listado',
			    type: 'GET',
			    dataType: "json",
			    success: function(result) {
					jQuery.each(result.titulacion, function(i, val) {
			    		  load(val.id, val.nombre, val.facultad);
			    		});
			    }
			});
		});
</script>
	
	
</head>
<body>

	<center><b>Gestionar titulaciones</b></center><br>	
	Listado de titulaciones creadas
	<br>
	<br>
	Id:<input type=text id="id"><br><br>
	Nombre:<input type=text id="nombre"><br><br>
	Facultad:<input type=text id="facultad"><br><br>
	<button id="crearTitulacion">Crear</button>
	<button id="actualizarTitulacion">Actualizar</button>
	<ul id="titulaciones"></ul>
</body>
</html>