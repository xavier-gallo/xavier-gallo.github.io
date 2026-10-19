<?php
    session_start();
    $nombre = $_POST['nombre'];
    $usuario = $_POST['usuario'];
    $password = $_POST['password'];
    $conexion = new mysqli('localhost', 'root', '', 'formulauno');
    $consulta = "SELECT email FROM usuarios WHERE email = '$usuario'";
    $resultado = $conexion->query($consulta);
    if($resultado->num_rows > 0){
        header('Location: registro.php?error=1');   
        exit();
    }
    $insert = "INSERT INTO usuarios (nombre, email, password) VALUES ('$nombre', '$usuario', '$password')";
    $resultadoinsert = $conexion->query($insert);
    
    if($resultadoinsert){
        header('Location: login.php?exito=1');
    } else {
        header('Location: registro.php?error=2');
    }
?>