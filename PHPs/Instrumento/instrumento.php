<?php
include_once '/xampp/htdocs/Web/PHPs/Conectar.php';

//ATRIBUTOS
class instrumento
{
    private $cod_Instrumeto;
    private $nome_Instrumento;
    private $Dif_instrumento;
    private $modelo_Instrumento;
    private $conn;

//GETTES E SETERS
//são nescessario 3 nomes diferentes para um melhor entendimento

    public function getNome(){ //1°começar com Maiúscula
        return $this->nome_Instrumento; //2°nome normal
    }
    public function setNome($Nomeinst){ 
        $this->nome_Instrumento = $Nomeinst;//3°nome normal com algo a mais
    }

    public function getDif(){
        return $this->Dif_instrumento;
    }
    public function setDif($Difinst){
        $this->Dif_instrumento = $Difinst;
    }
    public function getCod(){
        return $this->cod_Instrumeto;
    }
    public function setCod($Codinst){
        $this->cod_Instrumeto = $Codinst; 
    }
    public function getModel(){
        return $this->modelo_Instrumento;
    }
    public function setModel($Modinst){
        $this->modelo_Instrumento = $Modinst;
    }


//MÉTODOS
function Salvar()
{
    try
    {
        $this->conn = new Conectar(); 
        $sql = $this->conn->prepare("insert into instrumento values (?,?,null,?)");// null é o autoincremento e os "?" são os outros campos
        @$sql-> bindParam(1, $this->getNome(), PDO::PARAM_STR);
        @$sql-> bindParam(2, $this->getDif(), PDO::PARAM_STR);
        @$sql-> bindParam(3, $this->getModel(), PDO::PARAM_STR);
        if($sql->execute()==1)
        {
            return "Registro salvo com sucesso!";
        }
        $this->conn = null;
    }
    catch(PDOException $exc)
    {
        echo "Erro ao salvar o registro. " . $exc->getMessage();
    }
}

function alterar()
{
    try
    {
        $this->conn = new Conectar();
        $sql = $this->conn->prepare("select * from instrumento where Cod_Instrumeto = ?");//informei o ?(parametro)
        @$sql-> bindParam(1,$this->getCod(), PDO::PARAM_STR);//inclui esta linha para definir o parametro
        $sql->execute();
        return $sql->fetchAll();
        $this->conn = null;
    }
    catch(PDOException $ex)
    {
        echo "Erro ao alterar. " . $ex->getMessage();
    }
}

function alterar2()
{
    try
    {
        $this->conn = new Conectar();
        $sql = $this->conn->prepare("update instrumento set nome_Instrumento = ?, Dif_instrumento = ?, modelo_Instrumento = ?  where cod_Instrumeto = ?");// no exemplo o nome ta com "n" e com o "e" minúsculo
        @$sql-> bindParam(1,$this->getNome(), PDO::PARAM_STR);
        @$sql-> bindParam(2,$this->getDif(), PDO::PARAM_STR);
        @$sql-> bindParam(3,$this->getModel(), PDO::PARAM_STR);
        @$sql-> bindParam(4,$this->getCod(), PDO::PARAM_STR);
        if($sql->execute() == 1)
        {
            return "Registro Alterado com sucesso!";
        }
        $this->conn = null;
    }
    catch(PDOException $ex)
    {
        echo "Erro ao salvar o registro. " . $ex->getMessage();
    }
}

function consultar()
{
    try
    {
        $this->conn = new Conectar();
        $sql = $this->conn->prepare("select * from instrumento where nome_Instrumento like ?");//informei o ?(parametro)
        @$sql-> bindParam(1,$this->getNome(), PDO::PARAM_STR);//inclui esta linha para definir o parametro
        //@$sql-> bindParam(1,$this->getNome()."%", PDO::PARAM_STR);//inclui esta linha para definir o parametro
        $sql->execute();
        return $sql->fetchAll();
        $this->conn = null;
    }
    catch(PDOException $ex)
    {
        echo "Erro executar a consulta. " . $ex->getMessage();
    }
}

function exclusao()
{
    try
    {
        $this->conn = new Conectar();
        $sql = $this->conn->prepare("delete from instrumento where cod_Instrumeto = ?");//informei o ?(parametro)
        @$sql-> bindParam(1,$this->getCod(), PDO::PARAM_STR);//inclui esta linha para definir o parametro
        if($sql->execute() == 1)
        {
            return "Excluido com sucesso!";
        }
        else
        {
            return "Erro na exclusão !";
        }
        $this->conn = null;
    }
    catch(PDOException $ex)
    {
        echo "Erro ao excluir. " . $ex->getMessage();
    }  
}

function listar()
{
    try
    {
        $this->conn = new Conectar();
        $sql = $this->conn->query("select * from instrumento order by nome_Instrumento");
        $sql->execute();
        return $sql->fetchAll();
        $this->conn = null;
    }
    catch(PDOException $ex)
    {
        echo "Erro executar a consulta. " . $ex->getMessage();
    }
}

}//encerramento da classe Produto
?>