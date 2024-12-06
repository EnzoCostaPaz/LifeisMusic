<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../CSS/Alterar.css">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">
    <title>Alterar</title>
</head>
<body>
<?php
    session_start();
    
    // Verifica se o usuário está logado
    if (!isset($_SESSION['usuario'])) {
        header("Location: ../../../Login/index.php");
        exit();
    }
    ?>
<div class="container">
<form name="Instrumento" method="POST" action = "Consul_alt2_Inst.php">
    
        <h2>Informe o Código do Instrumento desejado:</h2>
        <label> Código: <input name="txtCod" type= "number" size="20"placeholder="Código do Produto"></label>
        <input name="btnenviar" type="submit" value="Consultar">
        <input name="limpar" type="reset" value="Limpar">
    
</form>

<button class="volt"><a href="../../../Login/Menu.php">Voltar</a></button>
</div>
</body>
</html>