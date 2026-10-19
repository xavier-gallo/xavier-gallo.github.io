<?php
session_start();

$conexion = new mysqli("localhost", "root", "", "formulauno");

$q = $_GET['q'] ?? '';
$q_segura = $conexion->real_escape_string($q);

$sql = "SELECT * FROM productos 
WHERE nombre LIKE '%$q_segura%' 
OR descripcion LIKE '%$q_segura%'";

$resultado = $conexion->query($sql);
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultados búsqueda</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<header>
    <img src="imagenes/logo.jpeg" id="logo">
    <h1>Resultados para: "<?php echo htmlspecialchars($q); ?>"</h1>
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

    <?php if($resultado->num_rows > 0): ?>
        
        <?php while($p = $resultado->fetch_assoc()): ?>
        <section>
            <img src="<?php echo $p['imagen']; ?>" alt="<?php echo htmlspecialchars($p['nombre']); ?>">
            
            <h2><?php echo $p['nombre']; ?></h2>
            
            <p><?php echo $p['precio']; ?> €</p>
            <p>Stock: <?php echo $p['stock']; ?></p>

            <a href="producto.php?id=<?php echo $p['id']; ?>">
                <button>Ver producto</button>
            </a>

            <?php if(isset($_SESSION['usuario'])): ?>
                <a href="agregar_carrito.php?id=<?php echo $p['id']; ?>" <?php if($p['stock'] <= 0) echo 'onclick="return false;"'; ?>>
                    <button <?php if($p['stock'] <= 0) echo 'disabled'; ?>>
                        <?php echo ($p['stock'] > 0) ? 'Añadir al carrito' : 'Sin stock'; ?>
                    </button>
                </a>
            <?php endif; ?>
        </section>
        <?php endwhile; ?>

    <?php else: ?>
        <p style="text-align: center; width: 100%; font-size: 18px; color: #666;">
            No hemos encontrado productos que coincidan con "<?php echo htmlspecialchars($q); ?>".
        </p>
    <?php endif; ?>

</main>

</body>
</html> 