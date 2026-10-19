<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">  
    <link rel="stylesheet" href="css/login.css"> 
    <title>Registrar</title>
</head>
<body>
    <header>
        <h1>Registrar usuario</h1>
    </header>
    <main>
        <form action="validar_registro.php" method="POST">
            <input type="text" name="nombre" id="nombre" placeholder="Nombre completo"><br><br>
            <input type="text" name="usuario" id="usuario" placeholder="Email"><br><br>
            <input type="password" name="password" id="password" placeholder="Contraseña"><br><br>
            <button type="submit">Registrar</button><br><br>
        </form>
        <?php
        session_start();
        if(isset($_GET['error'])){
            if($_GET['error'] == 1){
                echo "<p>El email ya está registrado</p>";
            } else if($_GET['error'] == 2){
                echo "<p>Hubo un error al registrar el usuario</p>";
            }
        }
        ?>
            
    </main>
    <section></section>
    <footer>
        <h3>¿Ya tienes una cuenta? <a href="login.php">Inicia sesión aquí</a></h3>
    </footer>
    <script>
        function validarFormulario(){
            var nombre = document.getElementById('nombre')
            var usuario = document.getElementById('usuario')
            var password = document.getElementById('password')
            if(nombre.value == '' || usuario.value == '' || password.value == ''){
                alert('Por favor, completa todos los campos');
            }
        }
    </script>

</body>
</html>