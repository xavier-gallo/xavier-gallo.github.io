<?php
require 'filtro.php';

$conexion = new mysqli("localhost","root","","formulauno");

$id = $_GET['id'];
$usuario = $_SESSION['usuario'];

// Verificar el stock disponible del producto
$sql_stock = "SELECT stock FROM productos WHERE id=$id";
$res_stock = $conexion->query($sql_stock);
$producto = $res_stock->fetch_assoc();
$stock_disponible = $producto['stock'];

// Verificar si ya existe en el carrito
$sql = "SELECT cantidad FROM carrito 
WHERE usuario='$usuario' AND producto_id=$id";

$res = $conexion->query($sql);

if($res->num_rows > 0){
    $carrito_item = $res->fetch_assoc();
    $cantidad_actual = $carrito_item['cantidad'];
    
    // Solo agregar si la cantidad actual + 1 no excede el stock
    if($cantidad_actual + 1 <= $stock_disponible){
        $conexion->query("UPDATE carrito 
        SET cantidad = cantidad + 1 
        WHERE usuario='$usuario' AND producto_id=$id");
    }
} else {
    // Para nuevo producto, verificar que haya al menos 1 en stock
    if($stock_disponible > 0){
        $conexion->query("INSERT INTO carrito (usuario,producto_id,cantidad)
        VALUES ('$usuario',$id,1)");
    }
}

header("Location: carrito.php");