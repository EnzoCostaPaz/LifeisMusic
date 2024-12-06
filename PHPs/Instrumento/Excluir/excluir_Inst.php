<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../CSS/ExcStyle.css">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">
    <title>Excluir Instrumento</title>
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
        <form action="" name="Instrumento" method="post">
            <h1>Informe o Código do Instrumento</h1>
            <p class="TxtId">Código: <input type="text" class="TxtId" name="txtCod" size="40" placeholder="Código do Instrumento" maxlength="5"></p>
            <input type="submit" name="btnenviar" value="Excluir">
            <input name="limpar" type="reset" value="Limpar">
            
            <div class="opt">
                <h4>Resultado</h4>
                <?php
                if ($_SERVER['REQUEST_METHOD'] == 'POST') {
                    # code...
                
                extract($_POST, EXTR_OVERWRITE);
                if (isset($btnenviar)) {
                    include_once '../instrumento.php';
                    $p = new instrumento();
                    $p->setCod($txtCod);
                    echo "<div class = 'result'>" . $p->exclusao() . "</result>";
                }
            }
                ?>
            </div>
            
            <br><br>
            <button><a href="../Listar/listar_Inst.php">Ver Listagem</a></button>
        </form>
    </div>
</body>
</html>
