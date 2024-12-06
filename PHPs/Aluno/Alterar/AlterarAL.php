<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../CSS/Alterar.css">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">
    <title>Alterar Aluno</title>
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
        <form action="./AlterarAl2.php" name="aluno" method="post">
                <h2>Informe o Código do Aluno:</h2>
                <label>Código: <input type="number" name="txtid" size="20" maxlength="3" placeholder="Código do Aluno"></label>
                <input type="submit" value="Pesquisar" name="envBtn">
                <input type="reset" value="Limpar" name="limpar">
        </form>
        <button><a href="../../../Login/menu.php">Voltar</a></button>
    </div>
</body>
</html>