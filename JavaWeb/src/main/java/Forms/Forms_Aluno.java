package Forms;

//Imports
import javax.swing.*;
import javax.swing.table.DefaultTableModel;//Para o Reconhecimento Da Jtable

import java.text.*;
import javax.swing.text.MaskFormatter; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Conexao.conexao;
import java.sql.*;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

public class Forms_Aluno extends JDialog{
    
    conexao con_bancosql;
    
    JLabel rtCod, rtNm, rtCPF, rtDt, rtEmail, rtTell,  rtEnd, rtCEP, rtPsq;
    JTextField txCod, txNm, txEmail,  txEnd, txPsq;
    JFormattedTextField CPF, Dt, Tell, CEP;
    MaskFormatter MkCPF, MkDt, MkTell, MkCEP;
    JButton BtPri,BtAnt,BtPro,BtUlt; //Botões De Posição
    JButton BtNvRg,BtGrv,BtAlt,BtExc,BtPsq, Btsair,BtnVolt; //Botões De Ação

    JTable tblAluno; //Datagrid
    JScrollPane scp_tabela;// Container Para o Datagrid
    
    public Forms_Aluno(Frame owner, String title, boolean modal){
        super(owner, title, modal);
        setLayout(null);
        con_bancosql = new conexao(); //Inicialização Do Objeto
        con_bancosql.conecta(); //Chama o Método Que Conecta
        
        setTitle("Tabela de Alunos");
        // Criação Dos Rótulos  
        rtCod = new JLabel("Código:");
        rtNm = new JLabel("Nome:");
        rtCPF = new JLabel("CPF:");
        rtDt = new JLabel("Data:");
        rtEmail = new JLabel("Email:");
        rtTell = new JLabel("Telefone:");
        rtEnd = new JLabel("Endereço:");
        rtCEP = new JLabel("CEP:");
        
        rtPsq = new JLabel("Pesquisar:");
        
        //IMGs
        ImageIcon ult = new ImageIcon("IMGs/Forms/Ult.png");
        ImageIcon alt = new ImageIcon("IMGs/Forms/alt.png");
        ImageIcon ant = new ImageIcon("IMGs/Forms/Ant.png");
        ImageIcon exc = new ImageIcon("IMGs/Forms/exc.png");
        ImageIcon save = new ImageIcon("IMGs/Forms/save.png");
        ImageIcon News = new ImageIcon("IMGs/Forms/New.png");
        ImageIcon pro = new ImageIcon("IMGs/Forms/Pro.png");
        ImageIcon pri = new ImageIcon("IMGs/Forms/pri.png");
        ImageIcon exit = new ImageIcon("IMGs/Forms/sairicon2.png");
        ImageIcon pesq = new ImageIcon("IMGs/Forms/pesq.png");
        ImageIcon volt = new ImageIcon("IMGs/Forms/Volt.png");

        ImageIcon icon = new ImageIcon("IMGs/Icons/alunoIcon.png");
        setIconImage(icon.getImage());


        //Crição Das Caixas De Texto
        txCod = new JTextField();
        txNm = new JTextField();
        txEmail = new JTextField();
        txEnd = new JTextField();
        txPsq = new JTextField();// tentar colocar como legenda uma mensgaem dixendo q é pra ser sobre o nome do aluno a pesquisa
        
        //Criação Das Máscaras
    try {
        MkCPF = new MaskFormatter("#########-##");
        MkDt = new MaskFormatter("##/##/####");
        MkTell = new MaskFormatter("(##)#####-####");
        MkCEP = new MaskFormatter("#####-###");
        
        CPF = new JFormattedTextField(MkCPF);
        Dt = new JFormattedTextField(MkDt);
        Tell = new JFormattedTextField(MkTell);
        CEP = new JFormattedTextField(MkCEP);
    } catch (ParseException e) {
    }
    
    //Criação Dos Botões De Posicionamento
    BtPri = new JButton("Primeiro",pri);
    BtAnt = new JButton("Anterior",ant);
    BtPro = new JButton("Próximo",pro);
    BtUlt = new JButton("Último",ult);
    
    //Criação Dos Botôes Que Realizarão o CRUD
    BtNvRg = new JButton("Novo", News);
    BtGrv = new JButton("Gravar",save);
    BtAlt = new JButton("Alterar",alt);
    BtExc = new JButton("Excluir",exc);
    BtnVolt = new JButton("Voltar",volt);
    
    //Criação Do Botão De Pesquisa
    BtPsq = new JButton("Pesquisar",pesq);
    Btsair = new JButton("Sair",exit);    
    // Posicionando Os Rótulos, AS Caixas De Texto, As Máscaras e Os Botões
    //Rótulos e Caixas De Texto
    rtCod.setBounds(50, 30, 55, 25);
    rtCod.setFont(new Font("Roboto",Font.BOLD,14));
    txCod.setBounds(110, 30, 50, 25);
    txCod.setBorder(new RoundedBorder(5,Color.BLACK));

    rtNm.setBounds(50, 70, 100, 25);
    rtNm.setFont(new Font("Roboto",Font.BOLD,14));
    txNm.setBounds(110, 70, 300, 25);
    txNm.setBorder(new RoundedBorder(5,Color.BLACK));
    
    rtCPF.setBounds(50,110,100,25);
    rtCPF.setFont(new Font("Roboto",Font.BOLD,14));
    CPF.setBounds(110,110,100,25);
    CPF.setBorder(new RoundedBorder(5,Color.BLACK));
    
    rtDt.setBounds(50, 150, 150, 25);
    rtDt.setFont(new Font("Roboto",Font.BOLD,14));
    Dt.setBounds(110, 150, 100, 25);
    Dt.setBorder(new RoundedBorder(5,Color.BLACK));
    
    rtEmail.setBounds(700, 30, 100, 25);
    rtEmail.setFont(new Font("Roboto",Font.BOLD,14));
    txEmail.setBounds(770, 30, 250, 25);
    txEmail.setBorder(new RoundedBorder(5,Color.BLACK));
    
    rtTell.setBounds(700, 70, 100, 25);
    rtTell.setFont(new Font("Roboto",Font.BOLD,14));
    Tell.setBounds(770, 70, 150, 25);
    Tell.setBorder(new RoundedBorder(5,Color.BLACK));
    
    rtEnd.setBounds(700, 110, 100, 25);
    rtEnd.setFont(new Font("Roboto",Font.BOLD,14));
    txEnd.setBounds(775, 110, 250, 25);
    txEnd.setBorder(new RoundedBorder(5,Color.BLACK));
    
    rtCEP.setBounds(700, 150, 100, 25);
    rtCEP.setFont(new Font("Roboto",Font.BOLD,14));
    CEP.setBounds(770, 150, 100, 25);
    CEP.setBorder(new RoundedBorder(5,Color.BLACK));
    
    
    rtPsq.setBounds(80,230,100,25);
    rtPsq.setFont(new Font("Roboto",Font.BOLD,14));
    txPsq.setBounds(155,230,300,25);
    txPsq.setBorder(new RoundedBorder(5,Color.BLACK));


    //Botões
    BtPsq.setBounds(460,230,130,30);
    BtPsq.setHorizontalTextPosition(SwingConstants.LEFT);
    BtPsq.setVerticalTextPosition(SwingConstants.CENTER);
    BtPsq.setBorder(new RoundedBorder(8, Color.BLACK));

    Btsair.setBounds(620,230,120,30);
    Btsair.setHorizontalTextPosition(SwingConstants.LEFT);
    Btsair.setVerticalTextPosition(SwingConstants.CENTER);
    Btsair.setBorder(new RoundedBorder(8, Color.BLACK));
    
    BtPri.setBounds(150,520,120,30);
    BtPri.setHorizontalTextPosition(SwingConstants.LEFT);
    BtPri.setVerticalTextPosition(SwingConstants.CENTER);
    BtPri.setBorder(new RoundedBorder(8, Color.BLACK));

    BtAnt.setBounds(150,560,120,30);
    BtAnt.setHorizontalTextPosition(SwingConstants.LEFT);
    BtAnt.setVerticalTextPosition(SwingConstants.CENTER);
    BtAnt.setBorder(new RoundedBorder(8, Color.BLACK));

    BtPro.setBounds(300,520,120,30);
    BtPro.setHorizontalTextPosition(SwingConstants.LEFT);
    BtPro.setVerticalTextPosition(SwingConstants.CENTER);
    BtPro.setBorder(new RoundedBorder(8, Color.BLACK));

    BtUlt.setBounds(300,560,120,30);
    BtUlt.setHorizontalTextPosition(SwingConstants.LEFT);
    BtUlt.setVerticalTextPosition(SwingConstants.CENTER);
    BtUlt.setBorder(new RoundedBorder(8, Color.BLACK));

    BtNvRg.setBounds(650,520,120,30);
    BtNvRg.setHorizontalTextPosition(SwingConstants.LEFT);
    BtNvRg.setVerticalTextPosition(SwingConstants.CENTER);
    BtNvRg.setBorder(new RoundedBorder(8, Color.BLACK));

    BtGrv.setBounds(650,560,120,30);
    BtGrv.setHorizontalTextPosition(SwingConstants.LEFT);
    BtGrv.setVerticalTextPosition(SwingConstants.CENTER);
    BtGrv.setBorder(new RoundedBorder(8, Color.BLACK));

    BtAlt.setBounds(800,520,120,30);
    BtAlt.setHorizontalTextPosition(SwingConstants.LEFT);
    BtAlt.setVerticalTextPosition(SwingConstants.CENTER);
    BtAlt.setBorder(new RoundedBorder(8, Color.BLACK));

    BtExc.setBounds(800,560,120,30);
    BtExc.setHorizontalTextPosition(SwingConstants.LEFT);
    BtExc.setVerticalTextPosition(SwingConstants.CENTER);
    BtExc.setBorder(new RoundedBorder(8, Color.BLACK));

    BtnVolt.setBounds(750,230,120,30);
    BtnVolt.setHorizontalTextPosition(SwingConstants.LEFT);
    BtnVolt.setVerticalTextPosition(SwingConstants.CENTER);
    BtnVolt.setBorder(new RoundedBorder(8, Color.BLACK));


    // Adiciona os componentes ao Container
    Container Tella = getContentPane();
    Tella.add(rtCod);
    Tella.add(txCod);
    Tella.add(rtNm);
    Tella.add(txNm);
    Tella.add(rtCPF);
    Tella.add(CPF);
    Tella.add(rtDt);
    Tella.add(Dt);
    Tella.add(rtEmail);
    Tella.add(txEmail);
    Tella.add(rtTell);
    Tella.add(Tell);
    Tella.add(rtEnd);
    Tella.add(txEnd);
    Tella.add(rtCEP);
    Tella.add(CEP);
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
    Tella.add(BtnVolt);



    // Configurações Da Tabela Que Virá Do MySql
    tblAluno = new javax.swing.JTable();
    scp_tabela = new javax.swing.JScrollPane();

    tblAluno.setBounds(50, 290, 1000, 200);
    scp_tabela.setBounds(50, 290, 1000, 200);
    
    Tella.add(tblAluno);
    Tella.add(scp_tabela);  // Adiciona apenas o JScrollPane ao Container

    tblAluno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
    tblAluno.setFont(new java.awt.Font("Roboto", 1, 12));
    
    tblAluno.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][]{
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
        },
        new String[]{"Id", "Nome", "CPF", "Data","Email", "Telefone","Endereço", "CEP"}
    ) {
        boolean[] canEdit = new boolean[]{
            false, false, false, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    });
    
    scp_tabela.setViewportView(tblAluno);
    tblAluno.setAutoCreateRowSorter(true); // Ativa A Classificação Ordenada Da Tabela
    Color bkColor = new Color(205,133,63);
    Color bkColor2 = new Color(244,164,96);
    tblAluno.setBackground(bkColor2);
    JViewport view = scp_tabela.getViewport();
    view.setBackground(bkColor);
    scp_tabela.setBorder(new RoundedBorder(5, Color.BLACK));
    scp_tabela.setBackground(bkColor);   
    //Configurações Da Janela
    setSize(1100, 700);
    setVisible(false);
    setLocationRelativeTo(null); 
    setResizable(false);

    //Desing-Cores
    Tella.setBackground(new Color(205, 133, 63));

    BtAlt.setBackground(new Color(65,105,225));
    BtAlt.setForeground(new Color(220,220,220));
    
    txCod.setBackground(new Color(244, 164, 96));
    txEmail.setBackground(new Color(244, 164, 96));
    txEnd.setBackground(new Color(244, 164, 96));
    txNm.setBackground(new Color(244, 164, 96));
    txPsq.setBackground(new Color(244, 164, 96));
    CPF.setBackground(new Color(244, 164, 96));
    Dt.setBackground(new Color(244, 164, 96));
    CEP.setBackground(new Color(244, 164, 96));
    Tell.setBackground(new Color(244, 164, 96));

    BtAnt.setBackground(new Color(65,105,225));
    BtAnt.setForeground(new Color(220,220,220));

    BtExc.setBackground(new Color(65,105,225));
    BtExc.setForeground(new Color(220,220,220));

    BtGrv.setBackground(new Color(65,105,225));
    BtGrv.setForeground(new Color(220,220,220));

    BtNvRg.setBackground(new Color(65,105,225));
    BtNvRg.setForeground(new Color(220,220,220));

    BtPri.setBackground(new Color(65,105,225));
    BtPri.setForeground(new Color(220,220,220));

    BtPro.setBackground(new Color(65,105,225));
    BtPro.setForeground(new Color(220,220,220));

    BtPsq.setBackground(new Color(65,105,225));
    BtPsq.setForeground(new Color(220,220,220));

    BtUlt.setBackground(new Color(65,105,225));
    BtUlt.setForeground(new Color(220,220,220));

    Btsair.setBackground(new Color(65,105,225));
    Btsair.setForeground(new Color(220,220,220));

    BtnVolt.setBackground(new Color(65,105,225));
    BtnVolt.setForeground(new Color(220,220,220));



    con_bancosql.executaSQL("select * from aluno order by cod_Aluno");
    preencherTabela();
    posicionarRegistro();
    
    
    //BOTÕES
    BtPsq.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
           try{
               String pesquisa = "select * from aluno where nome_Aluno like '" +txPsq.getText() +"%'";
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
            txCod.setText("");
            txNm.setText("");
            CPF.setText("");
            Dt.setText("");
            txEmail.setText("");
            Tell.setText("");
            txEnd.setText("");
            CEP.setText("");
            txCod.requestFocus();
        }});
    
    //Botão Para Gravar Um Novo Registro - Gravar
    BtGrv.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
           String nome_Aluno = txNm.getText();
           String cpf_Aluno = CPF.getText();
           String dtNasc_Aluno = Dt.getText();
           String email_Aluno = txEmail.getText();
           String Tel_Aluno = Tell.getText();
           String endereco_Aluno = txEnd.getText();
           String cep_Aluno = CEP.getText();
           
           try{
               String insert_sql="insert into aluno (nome_Aluno,cpf_Aluno,dtNasc_Aluno,email_Aluno,Tel_Aluno,endereco_Aluno,cep_Aluno) values ('" +nome_Aluno+ "','" +cpf_Aluno+ "','" +dtNasc_Aluno+ "','" +email_Aluno + "','" +Tel_Aluno + "','" +endereco_Aluno + "','" +cep_Aluno + "')";
               con_bancosql.statement.executeUpdate(insert_sql);
               JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
               
               con_bancosql.executaSQL("select * from aluno order by cod_Aluno");
               preencherTabela();
               
           }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null,"\n Erro na Gravação :\n"+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
           }
        }});
        
    //Botão Para Alterear Um Registro - Alterar
    BtAlt.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String nome_Aluno = txNm.getText();
           String cpf_Aluno = CPF.getText();
           String dtNasc_Aluno = Dt.getText();
           String email_Aluno = txEmail.getText();
           String Tel_Aluno = Tell.getText();
           String endereco_Aluno = txEnd.getText();
           String cep_Aluno = CEP.getText();
           String sql;
           String msg="";
           
           try{
               if(txCod.getText().equals("")){
                   sql="insert into aluno (nome_Aluno,cpf_Aluno,dtNasc_Aluno,email_Aluno,Tel_Aluno,endereco_Aluno,cep_Aluno) values ('" +nome_Aluno+ "','" +cpf_Aluno+ "','" +dtNasc_Aluno+ "','" +email_Aluno + "','" +Tel_Aluno + "','" +endereco_Aluno + "','" +cep_Aluno + "')";
                   msg="Gravação de um novo registro";
               }else{
                   sql="Update aluno set nome_Aluno='" + nome_Aluno + "', cpf_Aluno='" + cpf_Aluno + "', dtNasc_Aluno='" + dtNasc_Aluno + "', email_Aluno='" +email_Aluno + "', Tel_Aluno='" +Tel_Aluno + "', endereco_Aluno='" +endereco_Aluno + "', cep_Aluno='" + cep_Aluno + "'where cod_Aluno="+txCod.getText();
                   msg= "Alteração de registro";
               }
               
               con_bancosql.statement.executeUpdate(sql);
               JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
               
               con_bancosql.executaSQL("select * from aluno order by cod_Aluno");
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
                   sql="delete from aluno where cod_Aluno = "+txCod.getText();
                   int excluir = con_bancosql.statement.executeUpdate(sql);
                   if(excluir == 1){
                       JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                       con_bancosql.executaSQL("select * from aluno order by cod_Aluno");
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

        BtnVolt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
    }
    Forms_Aluno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //FUNÇÕES......................
     public void preencherTabela(){
        tblAluno.getColumnModel() .getColumn(0) .setPreferredWidth(1); //Código
        tblAluno.getColumnModel() .getColumn(1) .setPreferredWidth(130);//Nome
        tblAluno.getColumnModel() .getColumn(2) .setPreferredWidth(80);//CPF
        tblAluno.getColumnModel() .getColumn(3) .setPreferredWidth(60);//Data
        tblAluno.getColumnModel() .getColumn(4) .setPreferredWidth(180);//Email
        tblAluno.getColumnModel() .getColumn(5) .setPreferredWidth(90);//Telefone
        tblAluno.getColumnModel() .getColumn(6) .setPreferredWidth(180);//Endereço
        tblAluno.getColumnModel() .getColumn(7) .setPreferredWidth(50);//CEP
        
        DefaultTableModel modelo=(DefaultTableModel) tblAluno.getModel();
        modelo.setNumRows(0);
        
        try {
            con_bancosql.resultSet.beforeFirst();
            while(con_bancosql.resultSet.next()){
                modelo.addRow(new Object[]{
                    con_bancosql.resultSet.getString("cod_Aluno"),con_bancosql.resultSet.getString("nome_Aluno"),con_bancosql.resultSet.getString("cpf_Aluno"),con_bancosql.resultSet.getString("dtNasc_Aluno"),con_bancosql.resultSet.getString("email_Aluno"),con_bancosql.resultSet.getString("Tel_Aluno"),con_bancosql.resultSet.getString("endereco_Aluno"),con_bancosql.resultSet.getString("cep_Aluno")
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
              txCod.setText(con_bancosql.resultSet.getString("cod_Aluno"));//Associa a Caixa De Texto Ao Campo Cod
              txNm.setText(con_bancosql.resultSet.getString("nome_aluno"));//Associa a Caixa De Texto Ao Campo Nome
              CPF.setText(con_bancosql.resultSet.getString("cpf_Aluno"));//Associa a Caixa De Texto Ao Campo cpf_Aluno
              Dt.setText(con_bancosql.resultSet.getString("dtNasc_Aluno"));//Associa a Caixa De Texto Ao Campo dtNasc_Aluno
              txEmail.setText(con_bancosql.resultSet.getString("email_Aluno"));//Associa a Caixa De Texto Ao Campo email_Aluno
              Tell.setText(con_bancosql.resultSet.getString("Tel_Aluno"));//Associa a Caixa De Texto Ao Campo Tel_Aluno
              txEnd.setText(con_bancosql.resultSet.getString("endereco_Aluno"));//Associa a Caixa De Texto Ao Campo endereco_Aluno
              CEP.setText(con_bancosql.resultSet.getString("cep_Aluno"));//Associa a Caixa De Texto Ao Campo cep_Aluno
          }catch(SQLException erro){
              JOptionPane.showMessageDialog(null, "Não localizou os dados : "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);

          }
      }
      //configurar bordas
      class RoundedBorder implements Border {
        private int radius;
        private Color borderColor;
    
        RoundedBorder(int radius, Color color) {
            this.radius = radius;
            this.borderColor = color;
        }
    
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }
    
        public boolean isBorderOpaque() {
            return true;
        }
    
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(borderColor); // Define a cor preta para a borda
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
    
    public class RoundedBorderButton extends AbstractBorder {
        private int radius;
    
        public RoundedBorderButton(int radius) {
            this.radius = radius;
        }
    
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(Color.BLACK); // Cor da borda
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius); // Desenha a borda arredondada
        }
    }
}

