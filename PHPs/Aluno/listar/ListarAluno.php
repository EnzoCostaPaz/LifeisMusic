<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../CSS/listar/ListStyleAl.css">
    <link rel="icon" href="../../../IMGs/Icon.ico" type="image/icon type">

    <title>Listar Alunos</title>
</head>

<body>
    <?php
    session_start();

    // Verifica se o usuário está logado
    if (!isset($_SESSION['usuario'])) {
        header("Location: ../../../Login/index.php");
        exit();
    }
        include_once '../Aluno.php';
        $p = new aluno();
        $pro_bd = $p->list();
    ?>
    <center>
        <div class="container">
            <h1>Alunos Cadastrados</h1>
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
                    foreach ($pro_bd as $pro_mostrar) {
                ?>
                        <tr>
                            <td class="color"><b><?php echo $pro_mostrar[3]; ?></b></td>
                            <td><?php echo $pro_mostrar[0]; ?></td>
                            <td class="color"><?php echo $pro_mostrar[1]; ?></td>
                            <td><?php echo $pro_mostrar[2]; ?></td>
                            <td class="color"><?php echo $pro_mostrar[4]; ?></td>
                            <td><?php echo $pro_mostrar[5]; ?></td>
                            <td class="color"><?php echo $pro_mostrar[6]; ?></td>
                            <td><?php echo $pro_mostrar[7]; ?></td>
                        </tr>
                <?php
                    }
                
                ?>

            </table>
            <button><a href="../GravarAluno/NewAl.php">Cadastrar Aluno</a></button>
            <button class="exc"><a href="../Excluir/ExcluirAl.php">Excluir Aluno</a></button>
            <br><br>
            <button><a href="../../../Login/menu.php">Voltar</a></button>
        </div>
    </center>

</body>

</html>