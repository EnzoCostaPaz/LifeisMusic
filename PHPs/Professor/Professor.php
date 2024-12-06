<?php
include_once "/xampp/htdocs/Web/PHPs/Conectar.php";

class Professor{
    private $IdProf;
    private $NomeProf;
    private $DataNascProf;
    private $CepProf;
    private $EnderecoProf;
    private $CpfProf;
    private $EmailProf;
    private $TelefoneProf;
    private $conn;
    
    public function getIdProf(){
        return $this->IdProf;
    }
    public function setIdProf($idprofessor){
        $this->IdProf = $idprofessor;
    }

    public function getNomeProf(){
        return $this->NomeProf;
    }
    public function setNomeProf($nomeprofessor){
        $this->NomeProf = $nomeprofessor;
    }

    public function getDataNasctProf(){
        return $this->DataNascProf;
    }
    public function setDataNascProf($datanascprofessor){
        $this->DataNascProf = $datanascprofessor;
    }

    
    public function getCepProf(){
        return $this->CepProf;
    }
    public function setCepProf($cepproferssor){
        $this->CepProf = $cepproferssor;
    }

    public function getEnderecoProf(){
        return $this->EnderecoProf;
    }
    public function setEnderecoProf($enderecoprofessor){
        $this->EnderecoProf = $enderecoprofessor;
    }

    public function getCpfProf(){
        return $this->CpfProf;
    }
    public function setCpfProf($cpfprofessor){
        $this->CpfProf = $cpfprofessor;
    }

    public function getEmailProf(){
        return $this->EmailProf;
    }
    public function setEmailProf($emailprofessor){
        $this->EmailProf = $emailprofessor;
    }

    public function getTelefoneProf(){
        return $this->TelefoneProf;
    }
    public function setTelefoneProf($telefoneprofessor){
        $this->TelefoneProf = $telefoneprofessor;
    }
    

    //cadastrar professor
    public function criar(){
        try {
            $this->conn = new Conectar();
            $sql = $this->conn->prepare("INSERT into professor values (?, ?, ?, ?, null, ?, ?, ?)");
            @$sql->bindParam(1, $this->getNomeProf(), PDO::PARAM_STR);
            @$sql->bindParam(2, $this->getDataNasctProf(), PDO::PARAM_STR);
            @$sql->bindParam(3, $this->getCepProf(), PDO::PARAM_STR);
            @$sql->bindParam(4, $this->getEnderecoProf(), PDO::PARAM_STR);
            @$sql->bindParam(5, $this->getCpfProf(), PDO::PARAM_STR);
            @$sql->bindParam(6, $this->getEmailProf(), PDO::PARAM_STR);
            @$sql->bindParam(7, $this->getTelefoneProf(), PDO::PARAM_STR);
            if ($sql->execute() == 1) {
                return "Registro salvo com sucesso!";
            }
            $this->conn = null;
        } catch (PDOException $exc) {
            echo "Erro ao salvar registro: " . $exc->getMessage();
        }
    }

    //listar professores
    public function listar()
    {
        try {
            $this->conn = Conectar::getInstance();
            $sql = $this->conn->query("SELECT * FROM professor ORDER BY Id_Prof");
            $sql->execute();
            $result = $sql->fetchAll(PDO::FETCH_ASSOC);
            $this->conn = null; // Fechar conexão
            return $result;
        } catch (PDOException $exc) {
            echo "Erro ao executar consulta: " . $exc->getMessage();
        }
    }

    //consultar Professores
    public function consultar()
    {
        try {
            $this->conn = new Conectar();
            $sql = $this->conn->prepare("SELECT * from professor where Nome_Prof like ?");
            @$sql->bindParam(1, $this->getNomeProf(), PDO::PARAM_STR);
            $sql->execute();
            return $sql->fetchAll();
            $this->conn = null;
        } catch (PDOException $exc) {
            echo "Erro ao executar consulta. " . $exc->getMessage();
        }
    }

    //alterar
    public function alterar()
    {
        if (!$this->vericacaoProfessor()) {
            echo "Erro: não existe um Professor com esse codigo";
        }
        try {
            $this->conn = new Conectar();
            $sql = $this->conn->prepare("SELECT * from professor where Id_Prof  = ?");
            @$sql->bindParam(1, $this->getIdProf(), PDO::PARAM_STR);
            $sql->execute();
            return $sql->fetchAll();
            $this->conn = null;
        } catch (PDOException $exc) {
            echo "Erro ao alterar: " . $exc->getMessage();
        }
    }

    //alterar2
    public function alterar2()
    {
        try {
            $this->conn = new Conectar();
            $sql = $this->conn->prepare("UPDATE professor set Nome_Prof = ?, DataNasc_Prof = ?, cep_prof = ?, endereco_prof = ?, cpf_Prof = ?, email_prof = ?, telefone_Prof = ? where Id_Prof  = ?");
            @$sql->bindParam(1, $this->getNomeProf(), PDO::PARAM_STR);
            @$sql->bindParam(2, $this->getDataNasctProf(), PDO::PARAM_STR);
            @$sql->bindParam(3, $this->getCepProf(), PDO::PARAM_STR);
            @$sql->bindParam(4, $this->getEnderecoProf(), PDO::PARAM_STR);
            @$sql->bindParam(5, $this->getCpfProf(), PDO::PARAM_STR);
            @$sql->bindParam(6, $this->getEmailProf(), PDO::PARAM_STR);
            @$sql->bindParam(7, $this->getTelefoneProf(), PDO::PARAM_STR);
            @$sql->bindParam(8, $this->getIdProf(), PDO::PARAM_STR);
            if ($sql->execute()) {
                return "<div class = 'result'>Registro alterado com sucesso!</div>";
            }
            $this->conn = null;
        } catch (PDOException $exc) {
            echo "Erro ao salvar o registro: " . $exc->getMessage();
        }
    }

    //excluir professor
    public function excluir()
    {
        try {
            $this->conn = new Conectar();
            $sql = $this->conn->prepare("DELETE from professor where Id_Prof = ?");
            @$sql->bindParam(1, $this->getIdProf(), PDO::PARAM_STR);
            if ($sql->execute() == 1) {
                return "Excluido com sucesso!";
            } else {
                return "Erro na exclusão!";
            }
        } catch (PDOException $exc) {
            echo "Erro ao excluir. " . $exc->getMessage();
        }
    }

    //verificação professor
    public function vericacaoProfessor()
    {
        try {
            $this->conn = new Conectar();
            $sql = $this->conn->prepare("SELECT * from professor where Id_Prof = ?");
            $sql->bindValue(1, $this->getIdProf(), PDO::PARAM_INT);
            $sql->execute();
            $result = $sql->fetchColumn();
            return $result > 0;
        } catch (PDOException $exc) {
            echo "Erro no código do seu Professor:" . $exc->getMessage();
        }
    }
}


?>