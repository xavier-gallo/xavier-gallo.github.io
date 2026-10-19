<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">  
    <link rel="stylesheet" href="css/login.css"> 
    <title>Iniciar sesión</title>
</head>
<body>
    <header>
        <h1>Iniciar sesión</h1>
    </header>
    <main>
        <form action="validar.php" method="POST">
            <input type="text" name="usuario" id="usuario" placeholder="Email"><br><br>
            <input type="password" name="password" id="password" placeholder="Contraseña"><br><br>
            <button type="submit" onclick="validarFormulario()">Iniciar sesión</button><br><br>
        </form>
        <?php
        session_start();
        if(isset($_GET['error'])){
            echo "<p>Usuario o contraseña incorrectos</p>";
        }
        if(isset($_GET['exito'])){
            echo "<p style='color: green;'>Usuario registrado correctamente</p>";
        }
        ?>
        
    </main>
    <section>
        
    </section>
    <footer>
        <h3>¿No tienes una cuenta? <a href="registro.php">Regístrate aquí</a></h3>
    </footer>
    <script>
            function validarFormulario(){
                var usuario = document.getElementById('usuario')
                var password = document.getElementById('password')
                if(usuario.value == '' || password.value == ''){
                    alert('Por favor, completa todos los campos');
                }
            }
        </script>
</body>
</html>