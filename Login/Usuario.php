<?php
include_once "/xampp/htdocs/Web/PHPs/Conectar.php";

class Usuario{
    private $usua;
    private $senha;
    private $conn;
    
    public function getUsuario(){
        return $this->usua;
    }
    public function setUsuario($usuario){
        $this->usua =$usuario;
    }
    public function getSenha(){
        return $this->senha;
    }
    public function setSenha($senha){
        $this->senha =$senha;
    }

    function logar(){
        try {
            $this-> conn = new Conectar();
            $sql = $this->conn->prepare("SELECT * FROM acesso WHERE usuario LIKE ? and senha LIKE ?");
            @$sql->bindParam(1, $this-> getUsuario(), PDO::PARAM_STR);
            @$sql->bindParam(2, $this-> getSenha(), PDO::PARAM_STR);
            $sql->execute();
            return $sql -> fetchAll();
            $this->conn = null;
        } catch (PDOException $exc) {
           Echo "<span class ='text-green-200'>Erroao executar consulta.</span>". $exc->getMessage();
        }
    }

}

?>