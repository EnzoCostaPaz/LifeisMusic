<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../CSS/listar/liststyleInt.css">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">

    <title>Listar Instrumentos</title>
</head>

<body>

    <?php
    session_start();

    // Verifica se o usuário está logado
    if (!isset($_SESSION['usuario'])) {
        header("Location: ../../../Login/index.php");
        exit();
    }
    include_once '../instrumento.php';
    $p = new instrumento();
    $pro_bd = $p->listar();
    ?>

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

    <div class="container">
        <h1>Instrumentos Cadastrados</h1>
        <table>
            <tr>
                <th class="pontaEsquerda">Nome</th>
                <th>Dificuldade</th>
                <th>Código</th>
                <th class="pontaDireita">Modelo</th>
            </tr>
            <?php
            foreach ($pro_bd as $pro_mostrar) {
            ?>
                <tr>
                    <td class="color"><b><?php echo $pro_mostrar[0]; ?></b></td>
                    <td><?php echo $pro_mostrar[1]; ?></td>
                    <td class="color"><?php echo $pro_mostrar[2]; ?></td>
                    <td><?php echo $pro_mostrar[3]; ?></td>
                </tr>
            <?php
            }
            ?>
        </table>
        <button><a href="../NovoInstrumento/cadastrar_Inst.php">Cadastrar Instrumento</a></button>
        <button class="exc"><a href="../Excluir/excluir_Inst.php">Excluir Instrumento</a></button>
        <br><br>
        <button><a href="../../../Login/menu.php">Voltar</a></button>
    </div>
</body>

</html>