<?php
require 'filtro.php';
$usuario = $_SESSION['usuario'];
$conexion = new mysqli("localhost","root","","formulauno");
$idPedido = $_GET['id'];
$sql = "SELECT pedidos.usuario, pedidos.total, detalle_pedido.producto_id, detalle_pedido.cantidad, productos.nombre, productos.precio
        FROM pedidos
        INNER JOIN detalle_pedido ON pedidos.id = detalle_pedido.pedido_id
        INNER JOIN productos ON detalle_pedido.producto_id = productos.id
        WHERE pedidos.id = $idPedido";
$resultado = $conexion->query($sql);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Factura del pedido</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <img src="imagenes/logo.jpeg" id="logo">
        <h1>Factura del pedido #<?php echo $idPedido; ?></h1>
        <section>

        <?php if(isset($_SESSION['usuario'])): ?>

            <p>Hola, <?php echo $_SESSION['usuario']; ?></p>
            <a href="logout.php">Cerrar sesión</a>

        <?php endif; ?>

        </section>
    </header>
    <nav>
        <ul>
            <li><a href="index.php">Inicio</a></li>
            <li><a href="equipos.php">Equipos</a></li>
            <li><a href="pilotos.php">Pilotos</a></li>
            <li><a href="accesorios.php">Accesorios</a></li>
            <li><a href="carrito.php">Carrito</a></li>
        </ul>
    </nav>
    <main>
        <?php if($resultado->num_rows > 0){ ?>
            <h2 id="cliente">Cliente: <?php echo $usuario; ?></h2>
            <table>
                <tr>
                    <th>Producto</th>
                    <th>Cantidad</th>
                    <th>Precio unitario</th>
                    <th>Subtotal</th>
                </tr>
                <?php 
                $totalPedido = 0;
                while($fila = $resultado->fetch_assoc()){
                    $subtotal = $fila['precio'] * $fila['cantidad'];
                    $totalPedido = $fila['total'];
                ?>
                <tr>
                    <td><?php echo $fila['nombre']; ?></td>
                    <td><?php echo $fila['cantidad']; ?></td>
                    <td><?php echo number_format($fila['precio'], 2); ?> €</td>
                    <td><?php echo number_format($subtotal, 2); ?> €</td>
                </tr>
                <?php } ?>
            </table>
            <h3>Total: <?php echo number_format($totalPedido, 2); ?> €</h3>
        <?php }else{?>
            <p>No se encontró el pedido.</p>
        <?php } ?>
    </main>
</body>
</html>