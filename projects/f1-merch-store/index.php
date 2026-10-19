<?php
session_start();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>F1 Merch</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<header>

    <img src="imagenes/logo.jpeg" id="logo">

    <!-- BUSCADOR -->
    <form id="buscar" action="buscar.php" method="GET">
        <input type="text" name="q" placeholder="Buscar productos">
        <button type="submit">Buscar</button>
    </form>

    <!-- LOGIN / USUARIO -->
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

<main>

<h2>Compra los productos que usan tus pilotos favoritos</h2>

<section id="pilotos">

    <section>
        <img src="imagenes/verstappen.png">
        <p>Max Verstappen</p>
    </section>

    <section>
        <img src="imagenes/norris.png">
        <p>Lando Norris</p>
    </section>

    <section>
        <img src="imagenes/hamilton.png">
        <p>Lewis Hamilton</p>
    </section>

    <section>
        <img src="imagenes/colapinto.png">
        <p>Fraco Colapinto</p>
    </section>

</section>


<section id="redbull">

    <h1>Compra aquí los productos de tu equipo favorito</h1>

    <a href="equipos.php"><button>Equipos</button></a>

</section>


<section id="calendario">

    <h2>Calendario GP</h2>

    <ul class="calendar">

        <li class="day-name">Lun</li>
        <li class="day-name">Mar</li>
        <li class="day-name">Mié</li>
        <li class="day-name">Jue</li>
        <li class="day-name">Vie</li>
        <li class="day-name">Sáb</li>
        <li class="day-name">Dom</li>

        <li></li><li></li><li></li>
        <li>1</li>
        <li>2</li>
        <li class="gp">GP Bahréin</li>

    </ul>

</section>

</main>

<footer>
    <p>F1 Merch 2026</p>
    <p>Enlaces de interes: <a href="https://www.formula1.com" target="_blank">Sitio oficial de F1</a></p>
</footer>

</body>
</html>