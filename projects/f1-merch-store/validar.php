<?php
    session_start();
    $conexion = new mysqli('localhost', 'root', '', 'formulauno');
    $consulta = "SELECT * FROM usuarios";
    $resultado = $conexion->query($consulta);
    if(isset($_POST['usuario']) && isset($_POST['password'])){
        $usuario = $_POST['usuario'];
        $password = $_POST['password'];
        if($usuario == 'admin' && $password == 'admin'){
            $_SESSION['admin'] = $usuario;
            $_SESSION['usuario'] = $usuario;
            header('Location: admin.php');
            exit();
        }
        while($fila = $resultado->fetch_assoc()){
            if($fila['email'] == $usuario && $fila['password'] == $password){
                $_SESSION['usuario'] = $usuario;
                header('Location: index.php');
                exit();
            }
        }
        header('Location: login.php?error=1');
    } else {
        header('Location: login.php?error=1');
    }
?>