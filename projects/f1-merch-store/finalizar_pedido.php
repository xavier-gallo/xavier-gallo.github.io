<?php
require 'filtro.php';

$conexion = new mysqli("localhost","root","","formulauno");

$usuario = $_SESSION['usuario'];

$sql = "SELECT productos.precio, carrito.cantidad FROM carrito
        INNER JOIN productos ON carrito.producto_id = productos.id
        WHERE carrito.usuario='$usuario'";

$resultado = $conexion->query($sql);

$total = 0;
while($fila = $resultado->fetch_assoc()){
    $total += $fila['precio'] * $fila['cantidad'];
}

$sqlPedido = "INSERT INTO pedidos (usuario, total) VALUES ('$usuario', $total)";
$conexion->query($sqlPedido);

$idPedido = $conexion->insert_id;

//Insertamos los productos del carrito en la tabla detalle_pedido
$sql = "SELECT producto_id, cantidad FROM carrito WHERE usuario='$usuario'";
$resultado = $conexion->query($sql);
while($fila = $resultado->fetch_assoc()){
    $productoId = $fila['producto_id'];
    $cantidad = $fila['cantidad'];
    $conexion->query("INSERT INTO detalle_pedido (pedido_id, producto_id, cantidad) VALUES ($idPedido, $productoId, $cantidad)");
    // Actualizamos el stock del producto
    $conexion->query("UPDATE productos SET stock = stock - $cantidad WHERE id=$productoId");
}

//Vaciamos carrito
$conexion->query("DELETE FROM carrito WHERE usuario='$usuario'");   

header("Location: factura.php?id=$idPedido");
?>