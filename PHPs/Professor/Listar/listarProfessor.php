<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../CSS/listar/listSyleProf.css">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">

    <title>Professores Cadastrados</title>
</head>

<body>
    <?php
    session_start();

    // Verifica se o usuário está logado
    if (!isset($_SESSION['usuario'])) {
        header("Location: ../../../Login/index.php");
        exit();
    }

    include_once '../Professor.php';
    $Professor = new Professor();
    $Professores = $Professor->listar();
    ?>

    <center>
        <div class="container">
            <h1>Professores Cadastrados</h1>
            <table>
                <tr>
                    <th class="pontaEsquerda">Id</th>
                    <th>Nome</th>
                    <th>Data de Nascimento</th>
                    <th>CEP</th>
                    <th>Endereço</th>
                    <th>CPF</th>
                    <th>Email</th>
                    <th class="pontaDireita">Telefone</th>
                </tr>
                <?php
                // Listagem dos professores
                foreach ($Professores as $Professor) {
                    echo "<tr>";
                    echo "<td class='color'><b>" . $Professor['Id_Prof'] . "</b></td>";
                    echo "<td>" . $Professor['Nome_Prof'] . "</td>";
                    echo "<td class='color'>" . $Professor['DataNasc_Prof'] . "</td>";
                    echo "<td>" . $Professor['cep_prof'] . "</td>";
                    echo "<td class='color'>" . $Professor['endereco_prof'] . "</td>";
                    echo "<td>" . $Professor['cpf_Prof'] . "</td>";
                    echo "<td class='color'>" . $Professor['email_prof'] . "</td>";
                    echo "<td>" . $Professor['telefone_Prof'] . "</td>";
                    echo "</tr>";
                }
                ?>
            </table>
            <button><a href="../CadastrarProf/cadastrarProfessor.php">Cadastrar Professor</a></button>
            <button class="exc"><a href="../Excluir/excluirProfessor.php">Excluir Professor</a></button>
            <br><br>
            <button><a href="../../../Login/menu.php">Voltar</a>

        </div>
    </center>
</body>

</html>