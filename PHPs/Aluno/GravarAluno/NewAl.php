<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">
    <link rel="stylesheet" href="../../../CSS/GravStyle.css">
    <script src="../../../Script/ScriptFun.js"></script>
    <title>Cadastrar Aluno</title>
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
        <form name="Aluno" method="post" action="">
            <h1>Cadastrar Aluno</h1>
            <div class="form-grid">
                <div>
                    <label for="NameTxt">Nome do Aluno:</label>
                    <input type="text" id="NameTxt" name="NameTxt" placeholder="Nome do Aluno" maxlength="150" required>
                </div>
                <div>
                    <label for="txtNasc">Data de Nascimento:</label>
                    <input type="date" id="txtNasc" name="txtNasc" required>
                </div>
                <div>
                    <label for="TelTxt">Telefone:</label>
                    <input type="text" id="TelTxt" name="TelTxt" placeholder="Telefone do Aluno" maxlength="15" required>
                </div>
                <div>
                    <label for="EnderecoTxt">Endereço:</label>
                    <input type="text" id="EnderecoTxt" name="EnderecoTxt" placeholder="Endereço do Aluno" maxlength="50" required>
                </div>
                <div>
                    <label for="CEPTxt">CEP:</label>
                    <input type="text" id="CEPTxt" name="CEPTxt" placeholder="CEP do Aluno" maxlength="9" required>
                </div>
                <div>
                    <label for="CPFTxt">CPF:</label>
                    <input type="text" id="CPFTxt" name="CPFTxt" placeholder="CPF do Aluno" maxlength="12" required>
                </div>
                <div>
                    <label for="emailTxt">Email:</label>
                    <input type="email" id="emailTxt" name="emailTxt" placeholder="Email do Aluno" maxlength="150" required>
                </div>
            </div>
            <br><br>
            <div class="opt">
                <h4>Opções</h4>
                <input type="submit" value="Cadastrar" name="btnenv">
                <input type="reset" value="Limpar">
                <br><br>
                <button><a href="../Listar/listarAluno.php">Listar Aluno</a></button>
                <button class="exc"><a href="../Excluir/ExcluirAl.php">Excluir Aluno</a></button>
                <button><a href="../../../Login/menu.php">Voltar</a></button>
            </div>

            <?php
            if ($_SERVER['REQUEST_METHOD'] == 'POST') {

                // Processa a submissão do formulário
                extract($_POST, EXTR_OVERWRITE);
                if (isset($btnenv)) {
                    include_once '../Aluno.php';
                    $inst = new Aluno();
                    $inst->setAlunoNm($NameTxt);
                    $inst->setdtNasc($txtNasc);
                    $inst->setTel($TelTxt);
                    $inst->setEndeAL($EnderecoTxt);
                    $inst->setCepAl($CEPTxt);
                    $inst->setCpfAl($CPFTxt);
                    $inst->setEmailAl($emailTxt);

                    echo "<div class = 'result'>" . $inst->GravarAl() . "</div>";
                }
            }
            ?>
        </form>
    </div>
</body>

</html>