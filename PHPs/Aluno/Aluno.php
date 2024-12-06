
<?php
include_once "/xampp/htdocs/Web/PHPs/Conectar.php";
    class aluno{
        private $alunoNm;
        private $dtNasc;
        private $TelAl;
        private $IdAluno;
        private $enderecoAl;
        private $cep_Al;
        private $cpf_AL;
        private $email_Al;
        private $conn;

        public function getIdAluno(){
            return $this->IdAluno;
        }
        public function setIdAluno($idAl){
            $this->IdAluno = $idAl;
        }
        public function getAlunoNm(){
            return $this->alunoNm;
        }
        public function setAlunoNm($alNm){
            $this->alunoNm = $alNm;
        }
        public function getdtNasc(){
            return $this->dtNasc;
        }
        public function setdtNasc($dtNascs){
            $this->dtNasc = $dtNascs;
        }
        public function getTel(){
            return $this->TelAl;
        }
        public function setTel($TelAls){
            $this->TelAl = $TelAls;
        }
        public function getEndeAl(){
            return $this->enderecoAl;
        }
        public function setEndeAL($endeAl){
            $this->enderecoAl = $endeAl;
        }
        public function getCepAl(){
            return $this->cep_Al;
        }
        public function setCepAl($cepAl){
            $this->cep_Al = $cepAl;
        }
        public function getCpfAl(){
            return $this->cpf_AL;
        }
        public function setCpfAl($CpfAls){
            $this->cpf_AL = $CpfAls;
        }
        public function getEmailAl(){
            return $this->email_Al;
        }
        public function setEmailAl($emailAls){
            $this->email_Al = $emailAls;
        }
        //Função para verificar se o aluno Existe:
        public function AlunoExiste(){
            try {
                $this->conn = new conectar();
                $sql = $this->conn->prepare("select * from aluno where cod_Aluno = ?");
                $sql->bindValue(1,$this->getIdAluno(),PDO::PARAM_INT);
                $sql->execute();
                $result = $sql->fetchColumn();
                return $result > 0;
            } catch (PDOException $exc) {
                echo "Erro ao verificar existencia: ".$exc->getMessage();
            }
        }
        //Novo Aluno:
        function GravarAl(){
            try {
                $this->conn = new conectar();
                $sql = $this->conn->prepare("insert into aluno values(?,?,?,null,?,?,?,?)");
                @$sql->bindParam(1,$this->getAlunoNm(),PDO::PARAM_STR);
                @$sql->bindParam(2,$this->getdtNasc(),PDO::PARAM_STR);
                @$sql->bindParam(3,$this->getTel(),PDO::PARAM_STR);
                @$sql->bindParam(4,$this->getEndeAl(),PDO::PARAM_STR);
                @$sql->bindParam(5,$this->getCepAl(),PDO::PARAM_STR);
                @$sql->bindParam(6,$this->getCpfAl(),PDO::PARAM_STR);
                @$sql->bindParam(7,$this->getEmailAl(),PDO::PARAM_STR);

                if ($sql->execute() == 1) {
                    return "Registro Salvo com Sucesso";
                }
                $this->conn = null;

            } catch (PDOException $exc){
                echo "Erro ao alterar registro".$exc->getMessage();
            }
        }
        //Listar alunos:
        function list(){
            try {
                $this->conn = new conectar();
                $sql = $this->conn-> query("select * from aluno order by cod_Aluno");
                $sql-> execute();
                return $sql->fetchAll();
                $this->conn = null;
            } catch (PDOException $exc) {

                echo "Erro ao fazer a listagem" .$exc->getMessage();
            }
        }
        //pesquisar por aluno
        function consult(){
                try {
                    $this->conn = new conectar();
                    $sql = $this->conn->prepare("select * from aluno where nome_aluno like ?");
                    @$sql->bindParam(1,$this->getAlunoNm(),PDO::PARAM_STR);
                    $sql->execute();
                    return $sql->fetchAll();
                    $this->conn = null;
                } catch (PDOException $exc) {
                    echo "Erro ao consultar Aluno" .$exc->getMessage();
                }
            
        }
        //excluir aluno
        function excluit(){
            if (!$this->AlunoExiste()) {
                echo "<center>O aluno não está cadastrado</center>";
            } else {
                try {
                    $this->conn = new conectar();
                    $sql = $this->conn->prepare("delete from aluno where cod_Aluno = ?");
                    $sql ->bindValue(1,$this->getIdAluno(),PDO::PARAM_STR);
                    if ($sql->execute() == 1) {
                        return "Excluido com sucesso";
                    }
                } catch (PDOException $exc) {
                    echo"Erro ao excluir: " . $exc->getMessage();
                }
                $this->conn = null;
            }
        }

        //função para alterar aluno:
        //fazer a pesquisa do aluno:
        function alt(){
                try {
                    $this->conn = new conectar();
                    $sql = $this->conn->prepare("Select * from aluno where cod_Aluno = ?");
                    @$sql->bindValue(1,$this->getIdAluno(),PDO::PARAM_INT);
                    $sql->execute();
                    return $sql->fetchAll();
                    
                } catch (PDOException $exc) {
                    echo "Erro ao pesquisar por aluno".$exc->getMessage();
                }
            
        }
        //realizar a alteração:
        function alt2(){
            try {
                $this->conn = new conectar();
                $sql = $this->conn->prepare("update aluno set nome_aluno = ?, dtNasc_Aluno = ?, Tel_Aluno = ?, endereco_Aluno = ?, cep_Aluno = ?, cpf_Aluno = ?, email_Aluno = ? where cod_Aluno = ?");
                $sql->bindValue(1,$this->getAlunoNm(),PDO::PARAM_STR);
                $sql->bindValue(2,$this->getdtNasc(),PDO::PARAM_STR);
                $sql->bindValue(3,$this->getTel(),PDO::PARAM_STR);
                $sql->bindValue(4,$this->getEndeAl(),PDO::PARAM_STR);
                $sql->bindValue(5,$this->getCepAl(),PDO::PARAM_STR);
                $sql->bindValue(6,$this->getCpfAl(),PDO::PARAM_STR);
                $sql->bindValue(7,$this->getEmailAl(),PDO::PARAM_STR);
                $sql->bindValue(8,$this->getIdAluno(),PDO::PARAM_STR);
                

                if ($sql->execute() == 1) {
                    return "Registro alterado com sucesso";
                }
                $this->conn = null;
            } catch (PDOException $exc) {
                echo "Erro ao alterar Aluno". $exc->getMessage();
            }
        }

    }
?>