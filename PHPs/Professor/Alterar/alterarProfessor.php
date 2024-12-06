<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">
    <script src="../../../Script/ScriptFun.js"></script>
    <title>Alterar Professor</title>
    <link rel="stylesheet" href="../../../CSS/Alterar2.css">
</head>

<body>
    <div class="container">
        <?php
        session_start();

        // Verifica se o usuário está logado
        if (!isset($_SESSION['usuario'])) {
            header("Location: ../../../Login/index.php");
            exit();
        }

        include_once '../Professor.php';
        $mensagem = '';
        $professor_bd = [];

        if ($_SERVER['REQUEST_METHOD'] == 'POST') {
            $txtcod = $_POST['txtcod'];
            $p = new Professor();
            $p->setIdProf($txtcod);

            if (isset($_POST['btnAlterar'])) {
                $p->setNomeProf($_POST['txtnome']);
                $p->setDataNascProf($_POST['txtnasci']);
                $p->setCepProf($_POST['txtcep']);
                $p->setEnderecoProf($_POST['txtende']);
                $p->setCpfProf($_POST['txtcpf']);
                $p->setEmailProf($_POST['txtemail']);
                $p->setTelefoneProf($_POST['txttel']);
                $resultado = $p->alterar2();
                $mensagem = $resultado;

                $professor_bd = $p->alterar();
            } else {
                $professor_bd = $p->alterar();
            }
        }
        ?>


        <h1>Alterar Dados do Professor</h1>

        <?php if (!empty($mensagem)) { ?>
            <p class="mensagem"><?php echo $mensagem; ?></p>
        <?php } ?>
        
        <form action="" name="professor" method="post">
            <?php if (!empty($professor_bd)) {

                foreach ($professor_bd as $professor_mostrar) { ?>
                    <div class="opt">
                        <input type="hidden" name="txtcod" value="<?php echo $professor_mostrar[4]; ?>">
                        <h3 class="result">Id: <?php echo $professor_mostrar[4];?></h3>

                        <label for="txtnome">Nome:</label>
                        <input type="text" name="txtnome" value="<?php echo $professor_mostrar[0]; ?>">

                        <label for="txtnasci">Data de Nascimento:</label>
                        <input type="date" name="txtnasci" value="<?php echo $professor_mostrar[1]; ?>">

                        <label for="txttel">Telefone:</label>
                        <input type="text" name="txttel" value="<?php echo $professor_mostrar[7]; ?>">

                        <label for="txtende">Endereço:</label>
                        <input type="text" name="txtende" value="<?php echo $professor_mostrar[3]; ?>">

                        <label for="txtcpf">CPF:</label>
                        <input type="text" name="txtcpf" value="<?php echo $professor_mostrar[5]; ?>">

                        <label for="txtemail">Email:</label>
                        <input type="email" name="txtemail" value="<?php echo $professor_mostrar[6]; ?>">

                        <label for="txtcep">CEP:</label>
                        <input type="text" name="txtcep" value="<?php echo $professor_mostrar[2]; ?>">

                        <br><br>
                        <input type="submit" value="Alterar" name="btnAlterar">
                        <br><br>
                        <div class="opt-button">
                            <button><a href="../Listar/listarProfessor.php">Listar Professor</a></button>
                            <button class="exc"><a href="../Excluir/excluirProfessor.php">Excluir Professor</a></button>
                            <button class="volt"><a  href="./consultarAltProfessor.php">Voltar</a></button>
                        </div>
                    </div>
            <?php }
            } ?>
        </form>
    </div>
</body>

</html>