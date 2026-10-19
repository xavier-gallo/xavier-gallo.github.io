<?php
require 'filtro.php';

$conexion = new mysqli("localhost","root","","formulauno");

$usuario = $_SESSION['usuario'];

$sql = "SELECT productos.id, productos.nombre, productos.precio, productos.imagen, carrito.cantidad
FROM carrito
INNER JOIN productos ON carrito.producto_id = productos.id
WHERE carrito.usuario='$usuario'";

$resultado = $conexion->query($sql);
?>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/reset.css"> 
    <link rel="stylesheet" href="css/carrito.css">
</head>

<body>

<header>
    <img src="imagenes/logo.jpeg" id="logo">
    <h1>Carrito</h1>
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

<?php $total = 0; ?>

<?php while($p = $resultado->fetch_assoc()): ?>

<section>

    <img src="<?php echo $p['imagen']; ?>" width="150" alt="<?php echo htmlspecialchars($p['nombre']); ?>">
    <p><?php echo $p['nombre']; ?></p>
    <p><?php echo $p['precio']; ?> €</p>
    <p>Cantidad: <?php echo $p['cantidad']; ?></p>

</section>
<section>

    <p><?php echo $p['nombre']; ?></p>
    <p><?php echo $p['precio']; ?> €</p>
    <p>Cantidad: <?php echo $p['cantidad']; ?></p>

    <a href="eliminar_carrito.php?id=<?php echo $p['id']; ?>">
        <button>Eliminar</button>
    </a>

</section>
<?php 
$total += $p['precio'] * $p['cantidad'];

endwhile; 
?>

<h2>Total: <?php echo $total; ?> €</h2>
<a href="finalizar_pedido.php">
    <button>Finalizar pedido</button>
</a>
</main>

</body>
</html>