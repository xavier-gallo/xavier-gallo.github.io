<?php
    require 'filtro_admin.php';
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">  
    <link rel="stylesheet" href="css/modificar.css">  
    <title>Modificar productos</title>
</head>
<body>
    <header>
        <img src="imagenes/logo.jpeg" alt="Logo de la tienda">
        <section>
            <h1>ZONA ADMIN</h1>
            <h2>Modificar producto</h2>
        </section>
        <a href="admin.php">Volver</a>
    </header>
    <main>
        <form action="actualizar_producto.php" method="POST">
            <input type="hidden" name="id" value="<?php echo $_GET['id']; ?>">  
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
            <button type="submit">Modificar</button>    
        </form>
    </main>

</body>
</html>