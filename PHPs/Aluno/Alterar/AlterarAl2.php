<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="../../../Script/ScriptFun.js"></script>
    <title>Alterar Aluno</title>
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
        <h1>Alterar Dados do Aluno</h1>
        <?php
        if ($_SERVER['REQUEST_METHOD'] == 'POST') {


            $txtid = $_POST['txtid'];
            include_once '../Aluno.php';
            $p = new aluno();
            $p->setIdAluno($txtid);
            $pro_bd = $p->alt();

            if (isset($_POST['btnEnv'])) {
                include_once '../Aluno.php';
                $inst = new aluno();
                $inst->setAlunoNm($_POST['txtnome']);
                $inst->setdtNasc($_POST['txtDate']);
                $inst->setTel($_POST['txtTel']);
                $inst->setEndeAL($_POST['txtEndeco']);
                $inst->setCepAl($_POST['txtCep']);
                $inst->setCpfAl($_POST['txtCpf']);
                $inst->setEmailAl($_POST['txtEmail']);
                $inst->setIdAluno($txtid);
                echo "<div class = 'result'>" . $inst->alt2() . "</div>";
            }

            $p->setIdAluno($txtid);
            $pro_bd = $p->alt();
        }
        ?>
        <form action="" name="aluno2" method="post">
            <?php
            foreach ($pro_bd as $pro_most) {
            ?>
                <div class="opt">
                    <input type="hidden" name="txtid" class="titu" value='<?php echo $pro_most[3] ?>'>
                    <h3 class="result">Id: <?php echo $pro_most[3] ?></h3>

                    <label for="txtnome">Nome:</label>
                    <input type="text" name="txtnome" value='<?php echo $pro_most[0] ?>'>

                    <label for="txtDate">Data de Nascimento:</label>
                    <input type="date" name="txtDate" value='<?php echo $pro_most[1] ?>'>

                    <label for="txtTel">Telefone:</label>
                    <input type="text" name="txtTel" id="Tel" value='<?php echo $pro_most[2] ?>'>

                    <label for="txtEndeco">Endereço:</label>
                    <input type="text" name="txtEndeco" id="Endereco" value='<?php echo $pro_most[4] ?>'>

                    <label for="txtCep">CEP:</label>
                    <input type="text" name="txtCep" id="CEP" value='<?php echo $pro_most[5] ?>'>

                    <label for="txtCpf">CPF:</label>
                    <input type="text" name="txtCpf" id="CPF" value='<?php echo $pro_most[6] ?>'>

                    <label for="txtEmail">Email:</label>
                    <input type="text" name="txtEmail" value='<?php echo $pro_most[7] ?>'>

                    <br><br>
                    <input type="submit" value="Alterar" name="btnEnv">
                    <br><br>
                    <div class="opt-button">
                        <button><a href="../Listar/listarAluno.php">Listar Aluno</a></button>
                        <button class="exc"><a href="../Excluir/excluirAluno.php">Excluir Aluno</a></button>
                        <button><a href="./AlterarAL.php">Voltar</a></button>
                    </div>
                </div>
            <?php
            }
            ?>
        </form>
    </div>
</body>

</html>