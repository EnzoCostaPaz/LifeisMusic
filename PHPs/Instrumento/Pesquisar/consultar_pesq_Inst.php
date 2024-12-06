<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pesquisar Instrumento</title>
    <link rel="stylesheet" href="../../../CSS/Pesquisar/PesqInt.css">
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
        <form name="Instrumento" method="post">
            <h2>Informe o Nome do Instrumento:</h2>
            <label>Nome do Instrumento: <input type="text" name="txtnome" size="60" maxlength="150" id="boxTxt"></label>
            <br><br>
            <input type="submit" value="Pesquisar" name="btnenviar">
            <button class="volt"><a href="../../../Login/menu.php">Voltar</a></button>
            <div id="resul-box">
                <h2>Resultados:</h2>
                <br><br>
                <div class="opt">
                    <table>
                        <tr>
                            <th class="pontaEsquerda">Nome do Instrumento</th>
                            <th>Dificuldade</th>
                            <th>Código</th>
                            <th class="pontaDireita">Modelo</th>
                        </tr>

                        <?php
                        if ($_SERVER['REQUEST_METHOD'] == 'POST') {

                            extract($_POST, EXTR_OVERWRITE);
                            if (isset($btnenviar)) {
                                include_once '../instrumento.php';
                                $p = new instrumento();
                                $p->setNome($txtnome . '%'); // Busca aproximada
                                $pro_bd = $p->consultar();
                                foreach ($pro_bd as $pro_mostrar) {
                                    echo "<tr>";
                                    echo "<td class='color'>" . $pro_mostrar[0] . "</td>"; // Nome do Instrumento
                                    echo "<td>" . $pro_mostrar[1] . "</td>"; // Dificuldade
                                    echo "<td class='color'>" . $pro_mostrar[2] . "</td>"; // Código
                                    echo "<td>" . $pro_mostrar[3] . "</td>"; // Modelo
                                    echo "</tr>";
                                }
                            }
                        }
                        ?>
                    </table>
                </div>
            </div>
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
    </div>
</body>

</html>