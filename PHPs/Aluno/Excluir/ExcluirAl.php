<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../CSS/ExcStyle.css">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">


    <title>Excluir Aluno</title>
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
        <form action="" name="aluno" method="post">
            <h1>Informe o Código do Aluno</h1>
            <p class="TxtId">Código: <input type="text" class="TxtId" name="ExcluitAl" size="40" placeholder="Código do Aluno" maxlength="3"></p>
            <input type="submit" name="EnvBtn" value="Excluir">
            <input name="limpar" type="reset" value="limpar">
            <div class="opt">

                <h4>Resultado</h4>
                <?php
                if ($_SERVER['REQUEST_METHOD'] == 'POST') {


                    extract($_POST, EXTR_OVERWRITE);
                    if (isset($EnvBtn)) {
                        include_once '../Aluno.php';
                        $inst = new aluno();
                        $inst->setIdAluno($ExcluitAl);
                        echo "<div class = 'result'>" . $inst->excluit() . "</div>";
                    }
                }
                ?>

                </fieldset>
            </div>

            <br><br>
            <button><a href="../listar/ListarAluno.php">Ver Listagem</a></button>
        </form>
    </div>

</body>

</html>