<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar Instrumento</title>
    <link rel="stylesheet" href="../../../CSS/Alterar2.css">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">
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
        <h1>Alterar Dados do Instrumento</h1>
        <?php
        if ($_SERVER['REQUEST_METHOD'] == 'POST') {

            $txtCod = $_POST['txtCod'] ?? null;
            include_once '../instrumento.php';
            $inst = new instrumento();
            $inst->setCod($txtCod);

            // Processamento do formulário
            if (isset($_POST['btnEnv'])) {
                $inst->setNome($_POST['txtnome']);
                $inst->setDif($_POST['txtDif']);
                $inst->setModel($_POST['txtMod']);
                $inst->setCod($txtCod);
                echo "<div class = 'result'>" . $inst->alterar2() . "</div>";
            }

            // Obtendo os dados para exibição
            $pro_bd = $inst->alterar();
        }
        ?>

        <form action="" name="instrumento2" method="post">
            <?php
            foreach ($pro_bd as $pro_mostrar) {
            ?>
                <div class="opt">
                    <input type="hidden" name="txtCod" value='<?php echo $pro_mostrar[2] ?>'>
                    <h3 class="result">Código: <?php echo $pro_mostrar[2] ?></h3>

                    <label for="txtnome">Nome:</label>
                    <input type="text" name="txtnome" value='<?php echo $pro_mostrar[0] ?>'>

                    <label for="txtDif">Dificuldade:</label>
                    <input type="text" name="txtDif" value='<?php echo $pro_mostrar[1] ?>'>

                    <label for="txtMod">Modelo:</label>
                    <input type="text" name="txtMod" value='<?php echo $pro_mostrar[3] ?>'>
                </div>

                <div class="opt-button">
                    <input type="submit" class="btn-primary" value="Alterar" name="btnEnv">
                    <button><a href="../Listar/listar_Inst.php">Listar Instrumentos</a></button>
                    <button class="exc"><a href="../Excluir/excluir_Inst.php">Excluir Instrumento</a></button>
                    <button><a href="./consul_alt_Inst.php">Voltar</a></button>
                </div>
            <?php
            }
            ?>
        </form>
        <div class="left">
            <div class="descr">
                <span>Veja quais são os níveis de dificuldade 🎺🎻</span>
                <table>
                    <tr>
                        <th class="pontaEsquerda">Nível</th>
                        <th class="pontaDireita">Descrição</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Fácil</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Médio</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Difícil</td>
                    </tr>
                </table>
            </div>
        </div>

</body>

</html>