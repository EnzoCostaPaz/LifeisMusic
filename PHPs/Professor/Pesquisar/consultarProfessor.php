<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pesquisar Professor</title>
    <link rel="stylesheet" href="../../../CSS/Pesquisar/PesqStryle.css">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">
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
        <form name="Professor" method="post">
            <h2>Informe o Nome do Professor:</h2>
            <label>Nome do Professor: <input type="text" name="txtnome" size="60" maxlength="150" id="boxTxt"></label>
            <br><br>
            <input type="submit" value="Pesquisar" name="btnenviar">
            <div id="resul-box">
                <h2>Resultados:</h2>
                <br><br>
                <div class="opt">
                    <table>
                        <tr>
                            <th class="pontaEsquerda">Id</th>
                            <th>Nome</th>
                            <th>Data de Nascimento</th>
                            <th>Telefone</th>
                            <th>Endereço</th>
                            <th>CEP</th>
                            <th>CPF</th>
                            <th class="pontaDireita">Email</th>
                        </tr>

                        <?php
                        extract($_POST, EXTR_OVERWRITE);
                        if (isset($btnenviar)) {
                            include_once '../Professor.php';
                            $Professor = new Professor();
                            $Professor->setNomeProf($txtnome . '%');
                            $Professores = $Professor->consultar();
                            foreach ($Professores as $Professor) {
                                echo "<tr>";
                                echo "<td>" . $Professor['Id_Prof'] . "</td>";
                                echo "<td class='color'>" . $Professor['Nome_Prof'] . "</td>";
                                echo "<td>" . $Professor['DataNasc_Prof'] . "</td>";
                                echo "<td class='color'>" . $Professor['telefone_Prof'] . "</td>";
                                echo "<td>" . $Professor['endereco_prof'] . "</td>";
                                echo "<td class='color'>" . $Professor['cep_prof'] . "</td>";
                                echo "<td>" . $Professor['cpf_Prof'] . "</td>";
                                echo "<td class='color'>" . $Professor['email_prof'] . "</td>";
                                echo "</tr>";
                            }
                        }
                        ?>
                    </table>
                </div>
            </div>
        </form>
        <br><br>
        <button><a href="../../../Login/menu.php">Voltar</a></button>
    </div>
</body>

</html>