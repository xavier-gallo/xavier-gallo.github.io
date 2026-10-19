<?php
session_start();
$conexion = new mysqli("localhost","root","","formulauno");

$sql = "SELECT * FROM productos WHERE tipo='accesorio'";
$resultado = $conexion->query($sql);
?>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/reset.css"> 
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<header>
    <img src="imagenes/logo.jpeg" id="logo">
    <h1>Accesorios</h1>
    <section>

        <?php if(isset($_SESSION['usuario'])): ?>

            <p>Hola, <?php echo $_SESSION['usuario']; ?></p>

            <a href="logout.php">Cerrar sesión</a>

        <?php else: ?>

            <a href="login.php">
                <button>Login</button>
            </a>

            <a href="registro.php">
                <button>Registro</button>
            </a>

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

<main id="productos">

<?php while($p = $resultado->fetch_assoc()): ?>

<section>

    <h2><?php echo $p['nombre']; ?></h2>
    <p><?php echo $p['precio']; ?> €</p>
    <p>Stock: <?php echo $p['stock']; ?></p>

    <a href="producto.php?id=<?php echo $p['id']; ?>">
        <button>Ver producto</button>
    </a>

    <?php?>
        <a href="agregar_carrito.php?id=<?php echo $p['id']; ?>" <?php if($p['stock'] <= 0) echo 'onclick="return false;"'; ?>>
            <button <?php if($p['stock'] <= 0) echo 'disabled'; ?>>
                <?php echo ($p['stock'] > 0) ? 'Añadir al carrito' : 'Sin stock'; ?>
            </button>
        </a>
    <?php?>
        <img src="<?php echo $p['imagen']; ?>" width="150">
</section>

<?php endwhile; ?>

</main>

</body>
</html>