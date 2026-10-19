<?php
    require 'filtro_admin.php';
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">  
    <link rel="stylesheet" href="css/admin.css">  
    <title>Gestion de productos</title>
</head>
<body>
    <header>
        <img src="imagenes/logo.jpeg" alt="Logo de la tienda">
        <section>
            <h1>ZONA ADMIN</h1>
            <h2>Gestión de productos</h2>
        </section>
        <a href="logout.php">Cerrar sesión</a>
    </header>
    <main>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>Stock</th>
                    <th>Tipo</th>
                    <th>Imagen</th>
                </tr>
            </thead>
            <?php
                $conexion = new mysqli('localhost', 'root', '', 'formulauno');
                $consulta = "SELECT * FROM productos";
                $resultado = $conexion->query($consulta);
            ?>
            <tbody>
                 <?php while($fila = $resultado->fetch_assoc()) {?>
                    <tr>
                        <td><?php echo $fila['nombre']; ?></td>
                        <td><?php echo $fila['descripcion']; ?></td>
                        <td><?php echo $fila['precio']; ?></td>
                        <td><?php echo $fila['stock']; ?></td>
                        <td><?php echo $fila['tipo']; ?></td>
                        <td><?php echo $fila['imagen']; ?></td>
                        <td><a href="modificar_producto.php?id=<?php echo $fila['id']; ?>">Modificar</a></td>
                        <td><a href="borrar_producto.php?id=<?php echo $fila['id']; ?>">Borrar</a></td>
                    </tr>
                <?php } ?>  
            </tbody>
        </table>
        <section>
            <h2>Agregar nuevo producto</h2>
            <form action="agregar_producto.php" method="POST">
                <input type="text" name="nombre" placeholder="Nombre del producto" required><br><br>
                <input type="text" name="descripcion" placeholder="Descripción del producto" required><br><br>
                <input type="number" name="precio" placeholder="Precio del producto" required><br><br>
                <input type="number" name="stock" placeholder="Stock del producto" required><br><br>
                <select name="tipo" required>
                    <option value="">Selecciona tipo</option>
                    <option value="equipos">Equipos</option>
                    <option value="pilotos">Pilotos</option>
                    <option value="accesorio">Accesorio</option>
                </select><br><br>
                <input type="text" name="imagen" placeholder="Link de la imagen" required><br><br>
                <button type="submit">Agregar</button>
            </form>
        </section>
    </main>
    
</body>
</html>