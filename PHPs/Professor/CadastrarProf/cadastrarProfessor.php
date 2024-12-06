<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../CSS/GravStyle.css">
    <script src="../../../Script/ScriptFun.js"></script>
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">

    <title>Cadastrar Professor</title>
</head>

<body>
    <?php
    session_start();

    // Redireciona se o usuário não estiver logado
    if (!isset($_SESSION['usuario'])) {
        header("Location: ../../../Login/index.php");
        exit();
    }
    ?>

    <div class="container">
        <form name="Professor" method="post" action="">
            <h1>Cadastrar Professor</h1>
            <div class="form-grid">
                <div>
                    <label for="txtnome">Nome do Professor:</label>
                    <input type="text" id="txtnome" name="txtnome" placeholder="Nome do Professor" maxlength="150" required>
                </div>
                <div>
                    <label for="txtcpf">CPF:</label>
                    <input type="text" id="CPFTxt" name="txtcpf" placeholder="CPF do Professor" maxlength="12" required>
                </div>
                <div>
                    <label for="txtdatanasc">Data de Nascimento:</label>
                    <input type="date" id="txtdatanasc" name="txtdatanasc" required>
                </div>
                <div>
                    <label for="txtendereco">Endereço:</label>
                    <input type="text" id="EnderecoTxt" name="txtendereco" placeholder="Endereço do Professor" maxlength="40" required>
                </div>
                <div>
                    <label for="txtcep">CEP:</label>
                    <input type="text" id="CEPTxt" name="txtcep" placeholder="CEP do Professor" maxlength="10" required>
                </div>
                <div>
                    <label for="txttelefone">Telefone:</label>
                    <input type="text" id="TelTxt" name="txttelefone" placeholder="Telefone do Professor" maxlength="14" required>
                </div>
                <div>
                    <label for="txtemail">Email:</label>
                    <input type="email" id="txtemail" name="txtemail" placeholder="Email do Professor" maxlength="150" required>
                </div>
            </div>
            <br><br>
            <div class="opt">
                <h4>Opções</h4>
                <input type="submit" value="Cadastrar" name="btnenviar">
                <input type="reset" value="Limpar">
                <br><br>
                <button><a href="../Listar/listarProfessor.php">Listar Professor</a></button>
                <button class="exc"><a href="../Excluir/excluirProfessor.php">Excluir Professor</a></button>
                <button><a href="../../../Login/menu.php">Voltar</a></button>
            </div>

            <?php
            // Processa a submissão do formulário
            if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['btnenviar'])) {
                include_once '../Professor.php';
                $p = new Professor();
                $p->setNomeProf($_POST['txtnome']);
                $p->setCpfProf($_POST['txtcpf']);
                $p->setDataNascProf($_POST['txtdatanasc']);
                $p->setEnderecoProf($_POST['txtendereco']);
                $p->setCepProf($_POST['txtcep']);
                $p->setTelefoneProf($_POST['txttelefone']);
                $p->setEmailProf($_POST['txtemail']);
                echo "<div class = 'result'>" . $p->criar() . "</div>";
            }
            ?>
        </form>
    </div>
</body>

</html>
