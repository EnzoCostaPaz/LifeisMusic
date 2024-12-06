<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../IMGs/Icon.ico" type="image/icon type">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="../CSS/LoginStyle.css">
    <title>Login</title>

</head>

<body>
    <div class="wrapper">
        <div class="left">
            <div class="descr">
            <span>Veja as principais informações sobre o seu cadastro aqui na Escola Life is Music🎺🎻</span>
            </div>
            <img src="../IMGs/Slogan2.png" class="Slogan">
        </div>
        <div class="login-box">
            <div class="login-header">
                <span>Login</span>
            </div>
            <form action="" method="post">
                <div class="input-inbox">
                    <input type="text" name="txtUsuario" id="user" class="input-field" required>
                    <label for="user" class="label">Username:</label>
                    <i class="bx bx-user icon"></i>
                </div>
                <div class="input-inbox">
                    <input type="password" name="txtSenha" id="pass" class="input-field" required onkeypress="return NumOnly(window.event.keyCode)">
                    <label for="pass" class="label">Senha</label>
                    <i class="bx bx-lock-alt icon"></i>
                </div>
                <div class="input-box">
                    <input type="submit" name="btnconsultar" class="submit" value="Entrar">
                </div>
            </form>
        </div>
    </div>
</body>

</html>
<?php
session_start(); // Iniciar a sessão
extract($_POST, EXTR_OVERWRITE);
if (isset($btnconsultar)) {
    include_once './Usuario.php';
    $u = new Usuario();
    $u->setUsuario($txtUsuario);
    $u->setSenha($txtSenha);
    $pro_bd = $u->logar();

    $exist = false;
    foreach ($pro_bd as $pro_mostrar) {
        $exist = true;
        // Cria a sessão para o usuário logado
        $_SESSION['usuario'] = $pro_mostrar[0];
        header("Location: ./Menu.php");
        exit();
    }

    if (!$exist) {
        echo "<h5>Usuario ou senha invalido<h5>";
    }
}
?>