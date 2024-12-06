package Forms;

//Imports
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;//Para o Reconhecimento Da Jtable

import java.text.*;
import javax.swing.text.MaskFormatter; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Conexao.conexao;
import java.sql.*;

public class Forms_Turma extends JDialog{
    conexao con_bancosql;
    
    JLabel rtCodTurma, rtCodInst,rtIdSala, rtTurno, rtserie, rtPsq;
    JTextField txCodTurma, txCodInst,txIdSala, txTurno, txPsq;
    JFormattedTextField serie;
    MaskFormatter MkSerie;
    JButton BtPri,BtAnt,BtPro,BtUlt; //Botões De Posição
    JButton BtNvRg,BtGrv,BtAlt,BtExc,BtPsq, Btsair; //Botões De Ação

    JTable tblProf; //Datagrid
    JScrollPane scp_tabela;// Container Para o Datagrid
    
    public Forms_Turma(Frame owner, String title, boolean modal){
        super(owner, title, modal);
        setLayout(null);
        con_bancosql = new conexao(); //Inicialização Do Objeto
        con_bancosql.conecta(); //Chama o Método Que Conecta
        
        setTitle("Conexão com a Tabela do MySql");
        // Criação Dos Rótulos  
        rtCodTurma = new JLabel("ID da Turma:");
        rtCodInst = new JLabel("Id do Instrumento:");
        rtIdSala = new JLabel("Código da Sala:");
        rtTurno = new JLabel("Turno:");
        rtserie= new JLabel("série:");
        
        rtPsq = new JLabel("Pesquisar:");
        
        //Crição Das Caixas De Texto
        txCodTurma = new JTextField();
        txCodInst = new JTextField();
        txIdSala = new JTextField();
        txTurno = new JTextField();
       
        txPsq = new JTextField();// tentar colocar como legenda uma mensgaem dixendo q é pra ser sobre o nome do aluno a pesquisa
        //Criação Das Máscaras
    try {
        MkSerie = new MaskFormatter("#°");
        
        serie = new JFormattedTextField(MkSerie);
    } catch (ParseException e) {}
    
    //Criação Dos Botões De Posicionamento
    BtPri = new JButton("Primeiro");
    BtAnt = new JButton("Anterior");
    BtPro = new JButton("Próximo");
    BtUlt = new JButton("Último");
    
    //Criação Dos Botôes Que Realizarão o CRUD
    BtNvRg = new JButton("Novo");
    BtGrv = new JButton("Gravar");
    BtAlt = new JButton("Alterar");
    BtExc = new JButton("Excluir");
    
    //Criação Do Botão De Pesquisa
    BtPsq = new JButton("Pesquisar");
    Btsair = new JButton("sair");
    
    // Posicionando Os Rótulos, AS Caixas De Texto, As Máscaras e Os Botões
    //Rótulos e Caixas De Texto
    rtCodTurma.setBounds(50, 30, 100, 25);
    txCodTurma.setBounds(180, 30, 50, 25);

    rtCodInst.setBounds(50, 70, 120, 25);
    txCodInst.setBounds(180, 70, 50, 25);
    
    rtIdSala.setBounds(50,110,100,25);
    txIdSala.setBounds(180,110,50,25);
    
    rtserie.setBounds(50, 150, 150, 25);
    serie.setBounds(180, 150, 50, 25);
    
    rtTurno.setBounds(50, 190, 150, 25);
    txTurno.setBounds(180, 190, 70, 25);
    
    //Botões
    rtPsq.setBounds(80,260,100,25);
    txPsq.setBounds(150,260,300,25);
    BtPsq.setBounds(460,260,100,25);
    Btsair.setBounds(590,260,70,25);

    
    BtPri.setBounds(700,340,100,20);
    BtAnt.setBounds(700,380,100,20);
    BtPro.setBounds(700,420,100,20);
    BtUlt.setBounds(700,460,100,20);
    
    BtNvRg.setBounds(860,340,100,20);
    BtGrv.setBounds(860,380,100,20);
    BtAlt.setBounds(860,420,100,20);
    BtExc.setBounds(860,460,100,20);

    // Adiciona os componentes ao Container
    Container Tella = getContentPane();
    Tella.add(rtCodTurma);
    Tella.add(txCodTurma);
    Tella.add(rtCodInst);
    Tella.add(txCodInst);
    Tella.add(rtIdSala);
    Tella.add(txIdSala);
    Tella.add(rtTurno);
    Tella.add(txTurno);
    Tella.add(rtserie);
    Tella.add(serie);
    Tella.add(rtPsq);
    Tella.add(txPsq);
    Tella.add(BtPsq);
    Tella.add(Btsair);
    Tella.add(BtPri);
    Tella.add(BtAnt);
    Tella.add(BtPro);
    Tella.add(BtUlt);
    Tella.add(BtNvRg);
    Tella.add(BtGrv);
    Tella.add(BtAlt);
    Tella.add(BtExc);
    
    // Configurações Da Tabela Que Virá Do MySql
    tblProf = new javax.swing.JTable();
    scp_tabela = new javax.swing.JScrollPane();

    tblProf.setBounds(80, 320, 550, 200);
    scp_tabela.setBounds(80, 320, 550, 200);
    
    Tella.add(tblProf);
    Tella.add(scp_tabela);  // Adiciona apenas o JScrollPane ao Container

    tblProf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    tblProf.setFont(new java.awt.Font("Arial", 1, 12));
    
    tblProf.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
        },
        new String[]{"ID da turma", "ID da Sala", "ID do Instrumento", "Série","Turno"}
    ) {
        boolean[] canEdit = new boolean[]{
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    });
    
    scp_tabela.setViewportView(tblProf);
    tblProf.setAutoCreateRowSorter(true); // Ativa A Classificação Ordenada Da Tabela
    
    //Configurações Da Janela
    setSize(1100, 700);
    setVisible(false);
    setLocationRelativeTo(null); 
    setResizable(false);
    
    con_bancosql.executaSQL("select * from turma order by Cod_turma");
    preencherTabela();
    posicionarRegistro();
    
    
    //BOTÕES
    BtPsq.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
           try{
               String pesquisa = "select * from turma where Turno like '" +txPsq.getText() +"%'";
               con_bancosql.executaSQL(pesquisa);
               
               if(con_bancosql.resultSet.first()){
                   preencherTabela();
               }
               else{
                   JOptionPane.showMessageDialog(null,"\n Não existe dados com este pramêtro!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
               }
           }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null,"\n Os dados digitados não  foram localizados!! :\n"+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
           }
        }});
    
    Btsair.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }});
    
    
    //Botão Primerio Registro
    BtPri.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
            try{
                con_bancosql.resultSet.first();
                mostrar_Dados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro"+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            }
        }});
    
    //Botão Registro Anterior
    BtAnt.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
            try{
                con_bancosql.resultSet.previous();
                mostrar_Dados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Não foi possível acessar o registro anterior"+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            }
        }});
    
    //Botão Do Próximo Registro
    BtPro.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
            try{
                con_bancosql.resultSet.next();
                mostrar_Dados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Não foi possível acessar o Próximo registro"+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            }
        }});
    
    //Botão Do Último Registro
    BtUlt.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
            try{
                con_bancosql.resultSet.last();
                mostrar_Dados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Não foi possível acessar o último registro"+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            }
        }});
    
    //Botão Para Um Novo Registro - Limpar
    BtNvRg.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
            txCodTurma.setText("");
            txCodInst.setText("");
            txIdSala.setText("");
            serie.setText("");
            txTurno.setText("");
            txCodTurma.requestFocus();
        }});
    
    //Botão Para Gravar Um Novo Registro - Gravar
    BtGrv.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
           String cod_Instrumento = txCodInst.getText();
           String id_Sala = txIdSala.getText();
           String Serie = serie.getText();
           String Turno = txTurno.getText();
           
           try{
               String insert_sql="insert into turma (cod_Instrumento,id_Sala,Serie,Turno) values ('" +cod_Instrumento+ "','" +id_Sala+ "','" +Serie+ "','" +Turno + "')";
               con_bancosql.statement.executeUpdate(insert_sql);
               JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
               
               con_bancosql.executaSQL("select * from turma order by Cod_turma");
               preencherTabela();
               
           }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null,"\n Erro na Gravação :\n"+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
           }
        }});
    
    //Botão Para Alterear Um Registro - Alterar
    BtAlt.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
           String cod_Instrumento = txCodInst.getText();
           String id_Sala = txIdSala.getText();
           String Serie = serie.getText();
           String Turno = txTurno.getText();
           String sql;
           String msg="";
           
           try{
               if(txCodTurma.getText().equals("")){
                   sql="insert into turma (cod_Instrumento,id_Sala,Serie,Turno) values ('" +cod_Instrumento+ "','" +id_Sala+ "','" +Serie+ "','" +Turno + "')";
                   msg="Gravação de um novo registro";
               }else{
                   sql="Update turma set cod_Instrumento='" + cod_Instrumento + "', id_Sala='" + id_Sala + "', Serie='" + Serie + "', Turno='" +Turno + "'where Cod_turma="+txCodTurma.getText();
                   msg= "Alteração de registro";
               }
               
               con_bancosql.statement.executeUpdate(sql);
               JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
               
               con_bancosql.executaSQL("select * from turma order by Cod_turma");
               preencherTabela();
           }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null,"\n Erro2 na Gravação :\n"+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
           }
        }});
    
    //Botão Para Excluir Um Registro - Excluir
    BtExc.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
           String sql="";
           try{
               int resp = JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir o registro: ","Confrimar Exclusão", JOptionPane.YES_NO_OPTION,3);
               if(resp==0){
                   sql="delete from turma where Cod_turma = "+txCodTurma.getText();
                   int excluir = con_bancosql.statement.executeUpdate(sql);
                   if(excluir == 1){
                       JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                       con_bancosql.executaSQL("select * from turma order by Cod_turma");
                       con_bancosql.resultSet.first();
                       preencherTabela();
                       posicionarRegistro();
                   }
               }else{
                   JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
               }
           }catch(SQLException excecao){
               JOptionPane.showMessageDialog(null,"Erro na Exclusão: "+excecao,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
           }
        }});
    }
    //FUNÇÕES......................
     public void preencherTabela(){
        tblProf.getColumnModel() .getColumn(0) .setPreferredWidth(5); //Código Da Turma
        tblProf.getColumnModel() .getColumn(1) .setPreferredWidth(5);//Código Do Instrumento
        tblProf.getColumnModel() .getColumn(2) .setPreferredWidth(5);//Id Da Sala
        tblProf.getColumnModel() .getColumn(3) .setPreferredWidth(5);//Série
        tblProf.getColumnModel() .getColumn(4) .setPreferredWidth(11);//Turno
        
        DefaultTableModel modelo=(DefaultTableModel) tblProf.getModel();
        modelo.setNumRows(0);
        
        try {
            con_bancosql.resultSet.beforeFirst();
            while(con_bancosql.resultSet.next()){
                modelo.addRow(new Object[]{
                    con_bancosql.resultSet.getString("Cod_turma"),con_bancosql.resultSet.getString("cod_Instrumento"),con_bancosql.resultSet.getString("id_Sala"),con_bancosql.resultSet.getString("Serie"),con_bancosql.resultSet.getString("Turno")
                });   
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!:\n "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
     public void posicionarRegistro(){
          try {
              con_bancosql.resultSet.first();//Posiciona No 1° Registro Da Tabela
              mostrar_Dados();// Chama o Método Que Irá Buscar o Dado Da Tabela
          }catch(SQLException erro){
              JOptionPane.showMessageDialog(null, "Não foi possível posiiconar no primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
          }
      }
     public void mostrar_Dados(){
          try{
              txCodTurma.setText(con_bancosql.resultSet.getString("Cod_turma"));//Associa a Caixa De Texto Ao Campo Cod_turma
              txCodInst.setText(con_bancosql.resultSet.getString("cod_Instrumento"));//Associa a Caixa De Texto Ao Campo cod_Instrumento
              txIdSala.setText(con_bancosql.resultSet.getString("id_Sala"));//Associa a Caixa De Texto Ao Campo id_Sala
              serie.setText(con_bancosql.resultSet.getString("Serie"));//Associa a Caixa De Texto Ao Campo Seie
              txTurno.setText(con_bancosql.resultSet.getString("Turno"));//Associa a Caixa De Texto Ao Campo Turno
          }catch(SQLException erro){
              JOptionPane.showMessageDialog(null, "Não localizou os dados : "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);

          }
      }
}