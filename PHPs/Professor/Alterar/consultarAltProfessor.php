<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../CSS/Alterar.css">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">
    <title>Alterar Professor</title>
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
        <form action="./alterarProfessor.php" name="professor" method="post">
            <h2>Informe o Código do Professor:</h2>
            <label>Código: <input type="number" name="txtcod" size="20" maxlength="3" placeholder="Código do Professor"></label>
            <input type="submit" value="Pesquisar" name="envBtn">
            <input type="reset" value="Limpar" name="limpar">
        </form>
        <button><a href="../../../Login/menu.php">Voltar</a></button>

    </div>
</body>

</html>
