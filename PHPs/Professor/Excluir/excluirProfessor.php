<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../CSS/ExcStyle.css">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">
    <title>Excluir Professor</title>
</head>
<body>
    <div class="container">
        <form action="" name="professor" method="post">
            <h1>Informe o Código do Professor</h1>
            <p class="TxtId">Código: <input type="text" class="TxtId" name="txtid" size="40" placeholder="Código do Professor" maxlength="3"></p>
            <input type="submit" name="btnenviar" value="Excluir">
            <input name="limpar" type="reset" value="Limpar">
            <div class="opt">
                <h4>Resultado</h4>
                <?php
            
                session_start();
          
                // Verifica se o usuário está logado
                if (!isset($_SESSION['usuario'])) {
                    header("Location: ../../../Login/index.php");
                    exit();
                }
                extract($_POST, EXTR_OVERWRITE);
                if (isset($btnenviar)) {
                    include_once '../Professor.php';
                    $Professor = new Professor();
                    $Professor->setIdProf($txtid);  // Usando o código exato do professor
                    echo "<div class = 'result'>" . $Professor->excluir() . "</div>";
                }
                ?>
            </div>
            <br><br>
            <button><a href="../Listar/listarProfessor.php">Ver Listagem</a></button>
        </form>
    </div>
</body>
</html>
