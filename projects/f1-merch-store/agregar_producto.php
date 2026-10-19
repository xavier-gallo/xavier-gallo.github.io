<?php
    session_start();
    require 'filtro_admin.php';
    $nombre = $_POST['nombre'];
    $descripcion = $_POST['descripcion'];
    $precio = $_POST['precio'];
    $stock = $_POST['stock'];
    $tipo = $_POST['tipo'];
    $imagen = $_POST['imagen'];
    $conexion = new mysqli('localhost', 'root', '', 'formulauno');
    $consulta = "INSERT INTO productos (nombre, descripcion, precio, stock, tipo, imagen) VALUES ('$nombre', '$descripcion', '$precio', '$stock', '$tipo', '$imagen')";
    $resultado = $conexion->query($consulta);
    if($resultado){
        header('Location: admin.php');
    } else {
        echo "Error al agregar el producto";
    }
?>