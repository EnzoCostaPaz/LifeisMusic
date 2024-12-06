package Conexao;//Colocar o package como "Conexao"

import javax.swing.JOptionPane;
import java.sql.*;

public class conexao {
    final private String driver = "com.mysql.cj.jdbc.Driver";
    final private String url= "jdbc:mysql://localhost/bancosqljava";
    final private String usuario = "root";
    final private String senha = "";

    private Connection conexao;
    public Statement statement;
    public ResultSet resultSet;

    public boolean conecta(){
        boolean result = true;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
            statement = conexao.createStatement();

        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null,"Driver não localizado: "+Driver,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }
        catch(SQLException Fonte){
            JOptionPane.showMessageDialog(null,"Fonte de dados não localizados"+Fonte, "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }
        return result;
        
    }
    public void desconecta(){
        try {
            conexao.close();
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null,"Erro ao fechar programa", "mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void executaSQL(String sql){
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null,"Erro no comando SQL \n"+ excecao, "Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}