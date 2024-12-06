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


public class Forms_Prof extends JDialog{
    conexao con_bancosql;
    
    JLabel rtId, rtNm, rtCPF, rtDt, rtEmail, rtTell,  rtEnd, rtCEP, rtPsq;
    JTextField txId, txNm, txEmail,  txEnd, txPsq;
    JFormattedTextField CPF, Dt, Tell, CEP;
    MaskFormatter MkCPF, MkDt, MkTell, MkCEP;
    JButton BtPri,BtAnt,BtPro,BtUlt; //Botões De Posição
    JButton BtNvRg,BtGrv,BtAlt,BtExc,BtPsq, Btsair,BtnVolt; //Botões De Ação

    JTable tblProf; //Datagrid
    JScrollPane scp_tabela;// Container Para o Datagrid
    
    public Forms_Prof(Frame owner, String title, boolean modal){
        super(owner, title, modal);
        setLayout(null);
        con_bancosql = new conexao(); //Inicialização Do Objeto
        con_bancosql.conecta(); //Chama o Método Que Conecta
        
        setTitle("Tabela de Professores");
        // Criação Dos Rótulos  
        rtId = new JLabel("ID:");
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

        ImageIcon icon = new ImageIcon("IMGs/Icons/profIcon.png");
        setIconImage(icon.getImage());
        
        //Crição Das Caixas De Texto
        txId = new JTextField();
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
    } catch (ParseException e) {}
    
    //Criação Dos Botões De Posicionamento
    BtPri = new JButton("Primeiro",pri);
    BtAnt = new JButton("Anterior",ant);
    BtPro = new JButton("Próximo",pro);
    BtUlt = new JButton("Último",ult);
    
    //Criação Dos Botôes Que Realizarão o CRUD
    BtNvRg = new JButton("Novo",News);
    BtGrv = new JButton("Gravar",save);
    BtAlt = new JButton("Alterar",alt);
    BtExc = new JButton("Excluir",exc);
    
    //Criação Do Botão De Pesquisa
    BtPsq = new JButton("Pesquisar",pesq);
    Btsair = new JButton("sair",exit);
    BtnVolt = new JButton("Voltar",volt);
    
    // Posicionando Os Rótulos, AS Caixas De Texto, As Máscaras e Os Botões
    //Rótulos e Caixas De Texto
    rtId.setBounds(50, 30, 50, 25);
    rtId.setFont(new Font("Roboto",Font.BOLD,14));

    txId.setBounds(110, 30, 50, 25);
    txId.setBorder(new RoundedBorder(5,Color.BLACK));

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
   
    rtPsq.setBounds(60,230,130,30);
    rtPsq.setFont(new Font("Roboto",Font.BOLD,14));
    
    txPsq.setBounds(150,230,300,30);
    txPsq.setBorder(new RoundedBorder(5,Color.BLACK));
    
    //Botões
    Btsair.setBounds(620,230,120,30);
    Btsair.setHorizontalTextPosition(SwingConstants.LEFT);
    Btsair.setVerticalTextPosition(SwingConstants.CENTER);
    Btsair.setBorder(new RoundedBorder(8, Color.BLACK));

    BtPsq.setBounds(460,230,120,30);
    BtPsq.setHorizontalTextPosition(SwingConstants.LEFT);
    BtPsq.setVerticalTextPosition(SwingConstants.CENTER);
    BtPsq.setBorder(new RoundedBorder(8, Color.BLACK));
    
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
    Tella.add(rtId);
    Tella.add(txId);
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

    //Desing-Cores
    Tella.setBackground(new Color(205, 133, 63));

    BtAlt.setBackground(new Color(65,105,225));
    BtAlt.setForeground(new Color(220,220,220));
    
    txId.setBackground(new Color(244, 164, 96));
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
    
    // Configurações Da Tabela Que Virá Do MySql
    tblProf = new javax.swing.JTable();
    scp_tabela = new javax.swing.JScrollPane();

    tblProf.setBounds(50, 290, 1000, 200);
    scp_tabela.setBounds(50, 290, 1000, 200);
    
    Tella.add(tblProf);
    Tella.add(scp_tabela);  // Adiciona apenas o JScrollPane ao Container

    tblProf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    tblProf.setFont(new java.awt.Font("Arial", 1, 12));
    
    tblProf.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][]{
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
        },
        new String[]{"ID", "Nome", "CPF", "Data","Email", "Telefone","Endereço", "CEP"}
    ) {
        boolean[] canEdit = new boolean[]{
            false, false, false, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    });
    
    scp_tabela.setViewportView(tblProf);
    tblProf.setAutoCreateRowSorter(true); // Ativa A Classificação Ordenada Da Tabela
    Color bkColor = new Color(205,133,63);
    Color bkColor2 = new Color(244,164,96);
    tblProf.setBackground(bkColor2);
    JViewport view = scp_tabela.getViewport();
    view.setBackground(bkColor);
    scp_tabela.setBorder(new RoundedBorder(5, Color.BLACK));
    scp_tabela.setBackground(bkColor);   
    
    //Configurações Da Janela
    setSize(1100, 700);
    setVisible(false);
    setLocationRelativeTo(null); 
    setResizable(false);
    
    con_bancosql.executaSQL("select * from professor order by Id_Prof");
    preencherTabela();
    posicionarRegistro();
    
    
    //BOTÕES
    BtPsq.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
           try{
               String pesquisa = "select * from professor where Nome_Prof like '" +txPsq.getText() +"%'";
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
            txId.setText("");
            txNm.setText("");
            CPF.setText("");
            Dt.setText("");
            txEmail.setText("");
            Tell.setText("");
            txEnd.setText("");
            CEP.setText("");
            txId.requestFocus();
        }});
    
    //Botão Para Gravar Um Novo Registro - Gravar
    BtGrv.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
           String Nome_Prof = txNm.getText();
           String cpf_Prof = CPF.getText();
           String DataNasc_Prof = Dt.getText();
           String email_prof = txEmail.getText();
           String telefone_Prof = Tell.getText();
           String endereco_Prof = txEnd.getText();
           String cep_prof = CEP.getText();
           
           try{
               String insert_sql="insert into professor (Nome_Prof,cpf_Prof,DataNasc_Prof,email_prof,telefone_Prof,endereco_Prof,cep_prof) values ('" +Nome_Prof+ "','" +cpf_Prof+ "','" +DataNasc_Prof+ "','" +email_prof + "','" +telefone_Prof + "','" +endereco_Prof + "','" +cep_prof + "')";
               con_bancosql.statement.executeUpdate(insert_sql);
               JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
               
               con_bancosql.executaSQL("select * from professor order by Id_Prof");
               preencherTabela();
               
           }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null,"\n Erro na Gravação :\n"+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
           }
        }});
    
    //Botão Para Alterear Um Registro - Alterar
    BtAlt.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
           String Nome_Prof = txNm.getText();
           String cpf_Prof = CPF.getText();
           String DataNasc_Prof = Dt.getText();
           String email_prof = txEmail.getText();
           String telefone_Prof = Tell.getText();
           String endereco_Prof = txEnd.getText();
           String cep_prof = CEP.getText();
           String sql;
           String msg="";
           
           try{
               if(txId.getText().equals("")){
                   sql="insert into professor (Nome_Prof,cpf_Prof,DataNasc_Prof,email_prof,telefone_Prof,endereco_Prof,cep_prof) values ('" +Nome_Prof+ "','" +cpf_Prof+ "','" +DataNasc_Prof+ "','" +email_prof + "','" +telefone_Prof + "','" +endereco_Prof + "','" +cep_prof + "')";
                   msg="Gravação de um novo registro";
               }else{
                   sql="Update professor set Nome_Prof='" + Nome_Prof + "', cpf_Prof='" + cpf_Prof + "', DataNasc_Prof='" + DataNasc_Prof + "', email_prof='" +email_prof + "', telefone_Prof='" +telefone_Prof + "', endereco_Prof='" +endereco_Prof + "', cep_prof='" + cep_prof + "'where Id_Prof="+txId.getText();
                   msg= "Alteração de registro";
               }
               
               con_bancosql.statement.executeUpdate(sql);
               JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
               
               con_bancosql.executaSQL("select * from professor order by Id_Prof");
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
                   sql="delete from professor where Id_Prof = "+txId.getText();
                   int excluir = con_bancosql.statement.executeUpdate(sql);
                   if(excluir == 1){
                       JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                       con_bancosql.executaSQL("select * from professor order by Id_Prof");
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
    //FUNÇÕES......................
     public void preencherTabela(){
        tblProf.getColumnModel() .getColumn(0) .setPreferredWidth(1); //Id
        tblProf.getColumnModel() .getColumn(1) .setPreferredWidth(130);//Nome
        tblProf.getColumnModel() .getColumn(2) .setPreferredWidth(80);//CPF
        tblProf.getColumnModel() .getColumn(3) .setPreferredWidth(60);//Data
        tblProf.getColumnModel() .getColumn(4) .setPreferredWidth(180);//Email
        tblProf.getColumnModel() .getColumn(5) .setPreferredWidth(90);//Telefone
        tblProf.getColumnModel() .getColumn(6) .setPreferredWidth(180);//Endereço
        tblProf.getColumnModel() .getColumn(7) .setPreferredWidth(50);//CEP
        
        DefaultTableModel modelo=(DefaultTableModel) tblProf.getModel();
        modelo.setNumRows(0);
        
        try {
            con_bancosql.resultSet.beforeFirst();
            while(con_bancosql.resultSet.next()){
                modelo.addRow(new Object[]{
                    con_bancosql.resultSet.getString("Id_Prof"),con_bancosql.resultSet.getString("Nome_Prof"),con_bancosql.resultSet.getString("cpf_Prof"),con_bancosql.resultSet.getString("DataNasc_Prof"),con_bancosql.resultSet.getString("email_prof"),con_bancosql.resultSet.getString("telefone_Prof"),con_bancosql.resultSet.getString("endereco_prof"),con_bancosql.resultSet.getString("cep_prof")
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
              txId.setText(con_bancosql.resultSet.getString("Id_Prof"));//Associa a Caixa De Texto Ao Campo Cod
              txNm.setText(con_bancosql.resultSet.getString("Nome_Prof"));//Associa a Caixa De Texto Ao Campo Nome
              CPF.setText(con_bancosql.resultSet.getString("cpf_Prof"));//Associa a Caixa De Texto Ao Campo cpf_Aluno
              Dt.setText(con_bancosql.resultSet.getString("DataNasc_Prof"));//Associa a Caixa De Texto Ao Campo dtNasc_Aluno
              txEmail.setText(con_bancosql.resultSet.getString("email_prof"));//Associa a Caixa De Texto Ao Campo email_Aluno
              Tell.setText(con_bancosql.resultSet.getString("telefone_Prof"));//Associa a Caixa De Texto Ao Campo Tel_Aluno
              txEnd.setText(con_bancosql.resultSet.getString("endereco_prof"));//Associa a Caixa De Texto Ao Campo endereco_Aluno
              CEP.setText(con_bancosql.resultSet.getString("cep_prof"));//Associa a Caixa De Texto Ao Campo cep_Aluno
          }catch(SQLException erro){
              JOptionPane.showMessageDialog(null, "Não localizou os dados : "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);

          }
      }
      //bordas
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