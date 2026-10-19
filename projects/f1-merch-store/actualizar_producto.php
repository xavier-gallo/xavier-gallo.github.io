<?php
    session_start();
    require 'filtro_admin.php';
    $conexion = new mysqli('localhost', 'root', '', 'formulauno');
    $id = $_POST['id'];
    $nombre = $_POST['nombre'];
    $descripcion = $_POST['descripcion'];
    $precio = $_POST['precio'];
    $stock = $_POST['stock'];
    $tipo = $_POST['tipo'];
    $imagen = $_POST['imagen'];
    $consulta = "UPDATE productos SET nombre='$nombre', descripcion='$descripcion', precio='$precio', stock='$stock', tipo='$tipo', imagen='$imagen' WHERE id=$id";
    $resultado = $conexion->query($consulta);
    if($resultado){
        header('Location: admin.php');
    } else {
        echo "Error al modificar el producto.";
    }
?>