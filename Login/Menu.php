<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../IMGs/Icon.ico" type="image/icon type">
    <title>Menu De Produtos</title>
    <link rel="stylesheet" href="../CSS/MenuStyle.css">
</head>

<body>
    <?php
    session_start();

    // Verifica se o usuário está logado
    if (!isset($_SESSION['usuario'])) {
        header("Location: index.php");
        exit();
    }
    ?>
    <div id="Titulo" class="sign">
        <h1>Manutenção das Tabelas</h1>
        <!-- Contêiner para os títulos do menu -->
        <div class="menu-container">
            <!-- Grupo do menu Professor -->
            <div class="menu-group">
                <div class="menu-item" id="professor">Professor</div>
                <div class="submenu" id="submenu-professor">
                    <a href="../PHPs/Professor/CadastrarProf/cadastrarProfessor.php">CADASTRAR</a>
                    <a class="exc" href="../PHPs/Professor/Excluir/excluirProfessor.php">EXCLUIR</a>
                    <a href="../PHPs/Professor/Pesquisar/consultarProfessor.php">PESQUISAR</a>
                    <a href="../PHPs/Professor/Listar/listarProfessor.php">LISTAR</a>
                    <a href="../PHPs/Professor/Alterar/consultarAltProfessor.php">ALTERAR</a>
                </div>
            </div>

            <!-- Grupo do menu Aluno -->
            <div class="menu-group">
                <div class="menu-item" id="aluno">Aluno</div>
                <div class="submenu" id="submenu-aluno">
                    <a href="../PHPs/Aluno/GravarAluno/NewAl.php">CADASTRAR</a>
                    <a class="exc" href="../PHPs/Aluno/Excluir/ExcluirAl.php">EXCLUIR</a>
                    <a href="../PHPs/Aluno/Pesquisar/PesqAl.php">PESQUISAR</a>
                    <a href="../PHPs/Aluno/listar/ListarAluno.php">LISTAR</a>
                    <a href="../PHPs/Aluno/Alterar/AlterarAL.php">ALTERAR</a>
                </div>
            </div>

            <!-- Grupo do menu Instrumento -->
            <div class="menu-group">
                <div class="menu-item" id="instrumento">Instrumento</div>
                <div class="submenu" id="submenu-instrumento">
                    <a href="../PHPs/Instrumento/NovoInstrumento/cadastrar_Inst.php">CADASTRAR</a>
                    <a class="exc" href="../PHPs/Instrumento/Excluir/excluir_Inst.php">EXCLUIR</a>
                    <a href="../PHPs/Instrumento/Pesquisar/consultar_pesq_Inst.php">PESQUISAR</a>
                    <a href="../PHPs/Instrumento/Listar/listar_Inst.php">LISTAR</a>
                    <a href="../PHPs/Instrumento/Alterar/consul_alt_Inst.php">ALTERAR</a>
                </div>
            </div>
        </div>

        <!-- Slogan Container -->
        <div class="Slogan-container">
            <div class="left">
                <div class="descr">
                    <span class="Title">Life is Music</span>
                    <span>o lugar onde você aprende que a vida sem musica</span>
                    <span>não é vida🎺🎻</span>
                </div>
            </div>
            <img src="../IMGs/Slogan2.png" class="Slogan">
        </div>
    </div>

    <script src="../Script/MenuScript.js"></script>
</body>

</html>