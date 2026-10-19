<?php
    session_start();
    require 'filtro_admin.php';
    $id = $_GET['id'];
    $conexion = new mysqli('localhost', 'root', '', 'formulauno');
    $consulta = "DELETE FROM productos WHERE id = $id";
    $resultado = $conexion->query($consulta);
    if($resultado){
        header('Location: admin.php');
    } else {
        echo "Error al borrar el producto";

    }
?>