<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">
    <link rel="stylesheet" href="../../../CSS/GravStyle.css">
    <script src="../../../Script/script.js"></script>
    <title>Cadastrar Instrumento</title>
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
        <form name="Instrumento" method="post" action="">
            <h1>Cadastrar Instrumento</h1>
            <div class="form-grid">
                <div>
                    <label for="NomeTxt">Nome do Instrumento:</label>
                    <input type="text" id="NomeTxt" name="NomeTxt" placeholder="Nome do Instrumento" maxlength="150" required>
                </div>
                <div>
                    <label for="DificuldadeTxt">Dificuldade:</label>
                    <input type="text" id="DificuldadeTxt" name="DificuldadeTxt" placeholder="Nível de Dificuldade" maxlength="10" required>
                </div>
                <div>
                    <label for="ModeloTxt">Modelo:</label>
                    <input type="text" id="ModeloTxt" name="ModeloTxt" placeholder="Modelo do Instrumento" maxlength="50" required>
                </div>
            </div>
            <br><br>
            <div class="opt">
                <h4>Opções</h4>
                <input type="submit" value="Cadastrar" name="btnenv">
                <input type="reset" value="Limpar">
                <br><br>
                <button><a href="../Listar/listar_Inst.php">Listar Instrumentos</a></button>
                <button class="exc"><a href="../Excluir/excluir_Inst.php">Excluir Instrumento</a></button>
                <button><a href="../../../Login/menu.php">Voltar</a></button>
            </div>
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

            <?php
            if ($_SERVER['REQUEST_METHOD'] == 'POST') {

                // Processa a submissão do formulário
                extract($_POST, EXTR_OVERWRITE);
                if (isset($btnenv)) {
                    include_once '../instrumento.php';
                    $inst = new instrumento();
                    $inst->setNome($NomeTxt);
                    $inst->setDif($DificuldadeTxt);
                    $inst->setModel($ModeloTxt);

                    echo "<div class = 'resultInt'>" . $inst->Salvar() . "</div>";
                }
            }
            ?>
        </form>
    </div>
</body>

</html>