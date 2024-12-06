-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 06/12/2024 às 23:34
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bancosql`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `acesso`
--

CREATE TABLE `acesso` (
  `usuario` varchar(15) NOT NULL,
  `senha` varchar(8) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `acesso`
--

INSERT INTO `acesso` (`usuario`, `senha`) VALUES
('coordenador', 'clayton1'),
('diretor', 'eupi1234'),
('admim', 'Usu1234');

-- --------------------------------------------------------

--
-- Estrutura para tabela `aluno`
--

CREATE TABLE `aluno` (
  `nome_aluno` varchar(150) NOT NULL,
  `dtNasc_Aluno` varchar(10) NOT NULL,
  `Tel_Aluno` varchar(20) NOT NULL,
  `cod_Aluno` int(11) NOT NULL,
  `endereco_Aluno` varchar(50) NOT NULL,
  `cep_Aluno` varchar(10) NOT NULL,
  `cpf_Aluno` varchar(12) NOT NULL,
  `email_Aluno` varchar(150) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `aluno`
--

INSERT INTO `aluno` (`nome_aluno`, `dtNasc_Aluno`, `Tel_Aluno`, `cod_Aluno`, `endereco_Aluno`, `cep_Aluno`, `cpf_Aluno`, `email_Aluno`) VALUES
('Enzo Costa Paz', '2008-04-11', '(11) 98369-2322', 3, 'Avelino Matos Machado, 450', '54543-500', '496895998-28', 'Silva@gmail.com');

-- --------------------------------------------------------

--
-- Estrutura para tabela `aluno_turma`
--

CREATE TABLE `aluno_turma` (
  `cod_Aluno` int(11) NOT NULL,
  `Cod_turma` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `aluno_turma`
--

INSERT INTO `aluno_turma` (`cod_Aluno`, `Cod_turma`) VALUES
(1, 2),
(2, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `dif_instrumento`
--

CREATE TABLE `dif_instrumento` (
  `Descricao` varchar(40) NOT NULL,
  `Dif_instrumento` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `dif_instrumento`
--

INSERT INTO `dif_instrumento` (`Descricao`, `Dif_instrumento`) VALUES
('fácil', 1),
('médio', 2),
('difícil', 3);

-- --------------------------------------------------------

--
-- Estrutura para tabela `instrumento`
--

CREATE TABLE `instrumento` (
  `nome_Instrumento` varchar(40) NOT NULL,
  `Dif_instrumento` int(11) NOT NULL,
  `cod_Instrumeto` int(11) NOT NULL,
  `modelo_Instrumento` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `instrumento`
--

INSERT INTO `instrumento` (`nome_Instrumento`, `Dif_instrumento`, `cod_Instrumeto`, `modelo_Instrumento`) VALUES
('violão', 2, 1, 'corda'),
('tambor', 2, 4, 'percursão-som'),
('flauta', 3, 5, 'sopro'),
('Bateria', 3, 6, 'Som');

-- --------------------------------------------------------

--
-- Estrutura para tabela `professor`
--

CREATE TABLE `professor` (
  `Nome_Prof` varchar(150) NOT NULL,
  `DataNasc_Prof` date NOT NULL,
  `cep_prof` varchar(10) NOT NULL,
  `endereco_prof` varchar(40) NOT NULL,
  `Id_Prof` int(11) NOT NULL,
  `cpf_Prof` varchar(12) NOT NULL,
  `email_prof` varchar(150) NOT NULL,
  `telefone_Prof` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `professor`
--

INSERT INTO `professor` (`Nome_Prof`, `DataNasc_Prof`, `cep_prof`, `endereco_prof`, `Id_Prof`, `cpf_Prof`, `email_prof`, `telefone_Prof`) VALUES
('Edna Pittner Siqueira', '2001-09-11', '43242-2000', 'Rua Professor,90', 3, '354453343-21', 'Edna@etec.sp.gov.br', '(11) 98368-2000');

-- --------------------------------------------------------

--
-- Estrutura para tabela `sala`
--

CREATE TABLE `sala` (
  `id_Sala` int(11) NOT NULL,
  `caps_Sala` int(11) NOT NULL,
  `Desc_Sala` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `sala`
--

INSERT INTO `sala` (`id_Sala`, `caps_Sala`, `Desc_Sala`) VALUES
(1, 30, 'Sala de aula com cortinas'),
(2, 20, 'sala com porta azu');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tipo_instrumento`
--

CREATE TABLE `tipo_instrumento` (
  `Categ_instrumentos` varchar(20) NOT NULL,
  `Id_Prof` int(11) NOT NULL,
  `cod_Instrumeto` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tipo_instrumento`
--

INSERT INTO `tipo_instrumento` (`Categ_instrumentos`, `Id_Prof`, `cod_Instrumeto`) VALUES
('Corda', 2, 1),
('mecânico', 1, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `turma`
--

CREATE TABLE `turma` (
  `cod_Instrumento` varchar(11) NOT NULL,
  `Cod_turma` int(11) NOT NULL,
  `id_Sala` int(11) NOT NULL,
  `Turno` varchar(11) NOT NULL,
  `Serie` char(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `turma`
--

INSERT INTO `turma` (`cod_Instrumento`, `Cod_turma`, `id_Sala`, `Turno`, `Serie`) VALUES
('1', 1, 2, 'manhã', '2°'),
('2', 2, 1, 'tarde', '1°');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `acesso`
--
ALTER TABLE `acesso`
  ADD PRIMARY KEY (`usuario`);

--
-- Índices de tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`cod_Aluno`);

--
-- Índices de tabela `dif_instrumento`
--
ALTER TABLE `dif_instrumento`
  ADD PRIMARY KEY (`Dif_instrumento`);

--
-- Índices de tabela `instrumento`
--
ALTER TABLE `instrumento`
  ADD PRIMARY KEY (`cod_Instrumeto`);

--
-- Índices de tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`Id_Prof`);

--
-- Índices de tabela `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`id_Sala`);

--
-- Índices de tabela `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`Cod_turma`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `cod_Aluno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `dif_instrumento`
--
ALTER TABLE `dif_instrumento`
  MODIFY `Dif_instrumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `instrumento`
--
ALTER TABLE `instrumento`
  MODIFY `cod_Instrumeto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `Id_Prof` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `sala`
--
ALTER TABLE `sala`
  MODIFY `id_Sala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `turma`
--
ALTER TABLE `turma`
  MODIFY `Cod_turma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
