<?php
require 'filtro.php';

$conexion = new mysqli("localhost","root","","formulauno");

$usuario = $_SESSION['usuario'];
$id = $_GET['id'];

// Si cantidad > 1, resta 1
$sql = "SELECT cantidad FROM carrito 
WHERE usuario='$usuario' AND producto_id=$id";

$res = $conexion->query($sql);
$fila = $res->fetch_assoc();

if($fila['cantidad'] > 1){

    $conexion->query("
        UPDATE carrito 
        SET cantidad = cantidad - 1 
        WHERE usuario='$usuario' AND producto_id=$id
    ");

} else {

    // si es 1, elimina producto
    $conexion->query("
        DELETE FROM carrito 
        WHERE usuario='$usuario' AND producto_id=$id
    ");

}

header("Location: carrito.php");
exit();
?>