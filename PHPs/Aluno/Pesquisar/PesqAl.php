<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pesquisar Aluno</title>
    <link rel="stylesheet" href="../../../CSS/Pesquisar/PesqStryle.css">
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
        <form name="Aluno" method="post">
            <h2>Informe o Nome do Aluno:</h2>
            <label>Nome do Aluno: <input type="text" name="PesqAl" size="60" maxlength="150" id="boxTxt"></label>
            <br><br>
            <input type="submit" value="Pesquisar" name="btnEnv">
            <div id="resul-box">
                <h2>Resultados:</h2>
                <br><br>
                <div class="opt">
                    <table>
                        <tr>
                            <th class="pontaEsquerda">Código do Aluno</th>
                            <th>Nome do Aluno</th>
                            <th>Data de Nascimento</th>
                            <th>Telefone</th>
                            <th>Endereço</th>
                            <th>CEP</th>
                            <th>CPF</th>
                            <th class="pontaDireita">Email</th>
                        </tr>

                        <?php
                        if ($_SERVER['REQUEST_METHOD'] == 'POST') {

                            extract($_POST, EXTR_OVERWRITE);
                            if (isset($btnEnv)) {
                                include_once '../Aluno.php';
                                $inst = new aluno();
                                $inst->setAlunoNm($PesqAl . '%'); // Busca aproximada
                                $pro_bd = $inst->consult();
                                foreach ($pro_bd as $pro_mostrar) {
                                    echo "<tr>";
                                    echo "<td>" . $pro_mostrar[3] . "</td>"; // Código do Aluno
                                    echo "<td class = 'color'>" . $pro_mostrar[0] . "</td>"; // Nome do Aluno
                                    echo "<td>" . $pro_mostrar[1] . "</td>"; // Data de Nascimento
                                    echo "<td class = 'color'>" . $pro_mostrar[2] . "</td>"; // Telefone
                                    echo "<td>" . $pro_mostrar[4] . "</td>"; // Endereço
                                    echo "<td class = 'color'>" . $pro_mostrar[5] . "</td>"; // CEP
                                    echo "<td>" . $pro_mostrar[6] . "</td>"; // CPF
                                    echo "<td class = 'color'>" . $pro_mostrar[7] . "</td>"; // Email
                                    echo "</tr>";
                                }
                            }
                        }
                        ?>
                </div>
                </table>
            </div>
        </form>
        <br><br>
        <button><a href="../../../Login/menu.php">Voltar</a></button>
    </div>
</body>

</html>