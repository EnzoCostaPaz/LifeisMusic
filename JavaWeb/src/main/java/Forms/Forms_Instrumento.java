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

public class Forms_Instrumento extends JDialog{
    conexao con_bancosql;
    
    JLabel rtCodInst,rtDif, rtNmInst, rtModel, rtPsq,rtDifT,rtDif1,rtDif2,rtDif3;//dif1,dif2,dif3
    JTextField txCodInst,txDif, txNmInst,txModel, txPsq;
    JButton BtPri,BtAnt,BtPro,BtUlt; //Botões De Posição
    JButton BtNvRg,BtGrv,BtAlt,BtExc,BtPsq, Btsair,BtnVolt; //Botões De Ação

    JTable tblInst; //Datagrid
    JScrollPane scp_tabela;// Container Para o Datagrid
    
    public Forms_Instrumento(Frame owner, String title, boolean modal){
        super(owner, title, modal);
        setLayout(null);
        con_bancosql = new conexao(); //Inicialização Do Objeto
        con_bancosql.conecta(); //Chama o Método Que Conecta
        
        setTitle("Tabela de Instrumentos");
        // Criação Dos Rótulos  
        rtCodInst = new JLabel("Id do Instrumento:");
        rtDif = new JLabel("Dificuldade:");
        rtNmInst = new JLabel("Instrumento:");
        rtModel= new JLabel("Modelo:");
        rtDifT = new JLabel("Dificuldades");
        rtDif1 = new JLabel("1: fácil");
        rtDif2 = new JLabel("2: médio");
        rtDif3 = new JLabel("3: difícil");
        
        
        rtPsq = new JLabel("Pesquisar:");
        
        //Crição Das Caixas De Texto
        txCodInst = new JTextField();
        txDif = new JTextField();
        txNmInst = new JTextField();
        txModel = new JTextField();
       
        txPsq = new JTextField();// tentar colocar como legenda uma mensgaem dixendo q é pra ser sobre o nome do aluno a pesquisa
        
        //IMGS
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

        ImageIcon icon = new ImageIcon("IMGs/Icons/IconInt.png");
        setIconImage(icon.getImage());
        
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
    BtnVolt = new JButton("Voltar",volt);
    
    //Criação Do Botão De Pesquisa
    BtPsq = new JButton("Pesquisar",pesq);
    Btsair = new JButton("sair",exit);

    
    
    // Posicionando Os Rótulos, AS Caixas De Texto, As Máscaras e Os Botões
    //Rótulos e Caixas De Texto
    rtDifT.setBounds(490,30,250,25);
    rtDifT.setFont(new Font("Roboto",Font.BOLD,20));

    rtDif1.setBounds(490,70,120,25);
    rtDif1.setFont(new Font("Roboto",Font.BOLD,20));

    rtDif2.setBounds(490,110,120,25);
    rtDif2.setFont(new Font("Roboto",Font.BOLD,20));

    rtDif3.setBounds(490,150,120,25);
    rtDif3.setFont(new Font("Roboto",Font.BOLD,20));
    
    rtCodInst.setBounds(50, 30, 300, 25);
    rtCodInst.setFont(new Font("Roboto",Font.BOLD,14));

    txCodInst.setBounds(190, 30, 50, 25);
    txCodInst.setBorder(new RoundedBorder(5,Color.BLACK));
    
    rtNmInst.setBounds(50, 70, 100, 25);
    rtNmInst.setFont(new Font("Roboto",Font.BOLD,14));

    txNmInst.setBounds(180, 70, 150, 25);
    txNmInst.setBorder(new RoundedBorder(5,Color.BLACK));
    
    rtModel.setBounds(50,110,100,25);
    rtModel.setFont(new Font("Roboto",Font.BOLD,14));

    txModel.setBounds(180,110,100,25);
    txModel.setBorder(new RoundedBorder(5,Color.BLACK));
    
    rtDif.setBounds(50, 150, 150, 25);
    rtDif.setFont(new Font("Roboto",Font.BOLD,14));

    txDif.setBounds(180, 150, 100, 25);
    txDif.setBorder(new RoundedBorder(5,Color.BLACK));
    
    rtPsq.setBounds(75,260,130,30);
    rtPsq.setFont(new Font("Roboto",Font.BOLD,14));

    txPsq.setBounds(150,260,300,30);
    txPsq.setBorder(new RoundedBorder(5,Color.BLACK));

    //Botões
    BtPsq.setBounds(460,260,120,30);
    BtPsq.setHorizontalTextPosition(SwingConstants.LEFT);
    BtPsq.setVerticalTextPosition(SwingConstants.CENTER);
    BtPsq.setBorder(new RoundedBorder(8, Color.BLACK));

    Btsair.setBounds(590,260,120,30);
    Btsair.setHorizontalTextPosition(SwingConstants.LEFT);
    Btsair.setVerticalTextPosition(SwingConstants.CENTER);
    Btsair.setBorder(new RoundedBorder(8, Color.BLACK));

    
    BtPri.setBounds(700,340,120,30);
    BtPri.setHorizontalTextPosition(SwingConstants.LEFT);
    BtPri.setVerticalTextPosition(SwingConstants.CENTER);
    BtPri.setBorder(new RoundedBorder(8, Color.BLACK));

    BtAnt.setBounds(700,380,120,30);
    BtAnt.setHorizontalTextPosition(SwingConstants.LEFT);
    BtAnt.setVerticalTextPosition(SwingConstants.CENTER);
    BtAnt.setBorder(new RoundedBorder(8, Color.BLACK));

    BtPro.setBounds(700,420,120,30);
    BtPro.setHorizontalTextPosition(SwingConstants.LEFT);
    BtPro.setVerticalTextPosition(SwingConstants.CENTER);
    BtPro.setBorder(new RoundedBorder(8, Color.BLACK));

    BtUlt.setBounds(700,460,120,30);
    BtUlt.setHorizontalTextPosition(SwingConstants.LEFT);
    BtUlt.setVerticalTextPosition(SwingConstants.CENTER);
    BtUlt.setBorder(new RoundedBorder(8, Color.BLACK));
    
    BtNvRg.setBounds(860,340,120,30);
    BtNvRg.setHorizontalTextPosition(SwingConstants.LEFT);
    BtNvRg.setVerticalTextPosition(SwingConstants.CENTER);
    BtNvRg.setBorder(new RoundedBorder(8, Color.BLACK));

    BtGrv.setBounds(860,380,120,30);
    BtGrv.setHorizontalTextPosition(SwingConstants.LEFT);
    BtGrv.setVerticalTextPosition(SwingConstants.CENTER);
    BtGrv.setBorder(new RoundedBorder(8, Color.BLACK));

    BtAlt.setBounds(860,420,120,30);
    BtAlt.setHorizontalTextPosition(SwingConstants.LEFT);
    BtAlt.setVerticalTextPosition(SwingConstants.CENTER);
    BtAlt.setBorder(new RoundedBorder(8, Color.BLACK));

    BtExc.setBounds(860,460,120,30);
    BtExc.setHorizontalTextPosition(SwingConstants.LEFT);
    BtExc.setVerticalTextPosition(SwingConstants.CENTER);
    BtExc.setBorder(new RoundedBorder(8, Color.BLACK));

    BtnVolt.setBounds(720,260,120,30);
    BtnVolt.setHorizontalTextPosition(SwingConstants.LEFT);
    BtnVolt.setVerticalTextPosition(SwingConstants.CENTER);
    BtnVolt.setBorder(new RoundedBorder(8, Color.BLACK));


    // Adiciona os componentes ao Container
    Container Tella = getContentPane();
    Tella.add(rtCodInst);
    Tella.add(txCodInst);
    Tella.add(rtNmInst);
    Tella.add(txNmInst);
    Tella.add(rtDif);
    Tella.add(txDif);
    Tella.add(rtModel);
    Tella.add(txModel);
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
    Tella.add(rtDifT);
    Tella.add(rtDif1);
    Tella.add(rtDif2);
    Tella.add(rtDif3);
    Tella.add(BtnVolt);

    Tella.setBackground(new Color(205, 133, 63));

    BtAlt.setBackground(new Color(65,105,225));
    BtAlt.setForeground(new Color(220,220,220));
    
    txCodInst.setBackground(new Color(244, 164, 96));
    txDif.setBackground(new Color(244, 164, 96));
    txModel.setBackground(new Color(244, 164, 96));
    txNmInst.setBackground(new Color(244, 164, 96));
    txPsq.setBackground(new Color(244, 164, 96));
    

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
    tblInst = new javax.swing.JTable();
    scp_tabela = new javax.swing.JScrollPane();

    tblInst.setBounds(80, 320, 550, 200);
    scp_tabela.setBounds(80, 320, 550, 200);
    
    Tella.add(tblInst);
    Tella.add(scp_tabela);  // Adiciona apenas o JScrollPane ao Container

    tblInst.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Color bkColor = new Color(205,133,63);
    Color bkColor2 = new Color(244,164,96);
    tblInst.setBackground(bkColor2);
    JViewport view = scp_tabela.getViewport();
    view.setBackground(bkColor);
    scp_tabela.setBorder(new RoundedBorder(5, Color.BLACK));
    scp_tabela.setBackground(bkColor);   
    tblInst.setFont(new java.awt.Font("Arial", 1, 12));
    
    tblInst.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
        },
        new String[]{"ID", "Nome do Instrumento", "Dificuldade", "Modelo"}
    ) {
        boolean[] canEdit = new boolean[]{
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    });
    
    scp_tabela.setViewportView(tblInst);
    tblInst.setAutoCreateRowSorter(true); // Ativa A Classificação Ordenada Da Tabela
    
    //Configurações Da Janela
    setSize(1100, 700);
    setVisible(false);
    setLocationRelativeTo(null); 
    setResizable(false);
    
    con_bancosql.executaSQL("select * from instrumento order by cod_Instrumeto");
    preencherTabela();
    posicionarRegistro();
    
    
    //BOTÕES
    BtPsq.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
           try{
               String pesquisa = "select * from instrumento where nome_Instrumento like '" +txPsq.getText() +"%'";
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
            txCodInst.setText("");
            txNmInst.setText("");
            txDif.setText("");
            txModel.setText("");
            txCodInst.requestFocus();
        }});
    
    //Botão Para Gravar Um Novo Registro - Gravar
    BtGrv.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
           String nome_Instrumento = txNmInst.getText();
           String Dif_instrumento = txDif.getText();
           String modelo_Instrumento = txModel.getText();
           
           try{
               String insert_sql="insert into instrumento (nome_Instrumento,Dif_instrumento,modelo_Instrumento) values ('" +nome_Instrumento+ "','" +Dif_instrumento+ "','" +modelo_Instrumento+ "')";
               con_bancosql.statement.executeUpdate(insert_sql);
               JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
               
               con_bancosql.executaSQL("select * from instrumento order by cod_Instrumeto");
               preencherTabela();
               
           }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null,"\n Erro na Gravação :\n"+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
           }
        }});
    
    //Botão Para Alterear Um Registro - Alterar
    BtAlt.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
           String nome_Instrumento = txNmInst.getText();
           String Dif_instrumento = txDif.getText();
           String modelo_Instrumento = txModel.getText();
           String sql;
           String msg="";
           
           try{
               if(txCodInst.getText().equals("")){
                   sql="insert into instrumento (nome_Instrumento,Dif_instrumento,modelo_Instrumento) values ('" +nome_Instrumento+ "','" +Dif_instrumento+ "','" +modelo_Instrumento+ "')";
                   msg="Gravação de um novo registro";
               }else{
                   sql="Update instrumento set nome_Instrumento='" + nome_Instrumento + "', Dif_instrumento='" + Dif_instrumento + "', modelo_Instrumento='" + modelo_Instrumento +  "'where cod_Instrumeto="+txCodInst.getText();
                   msg= "Alteração de registro";
               }
               
               con_bancosql.statement.executeUpdate(sql);
               JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
               
               con_bancosql.executaSQL("select * from instrumento order by cod_Instrumeto");
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
                   sql="delete from instrumento where cod_Instrumeto = "+txCodInst.getText();
                   int excluir = con_bancosql.statement.executeUpdate(sql);
                   if(excluir == 1){
                       JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                       con_bancosql.executaSQL("select * from instrumento order by cod_Instrumeto");
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
        tblInst.getColumnModel() .getColumn(0) .setPreferredWidth(15);//Código Do Instrumento
        tblInst.getColumnModel() .getColumn(1) .setPreferredWidth(150);//nome
        tblInst.getColumnModel() .getColumn(2) .setPreferredWidth(100);//dificuldade
        tblInst.getColumnModel() .getColumn(3) .setPreferredWidth(100);//modelo
        
        DefaultTableModel modelo=(DefaultTableModel) tblInst.getModel();
        modelo.setNumRows(0);
        
        try {
            con_bancosql.resultSet.beforeFirst();
            while(con_bancosql.resultSet.next()){
                modelo.addRow(new Object[]{
                    con_bancosql.resultSet.getString("cod_Instrumeto"),con_bancosql.resultSet.getString("nome_Instrumento"),con_bancosql.resultSet.getString("Dif_Instrumento"),con_bancosql.resultSet.getString("modelo_instrumento")
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
              txCodInst.setText(con_bancosql.resultSet.getString("cod_Instrumeto"));
              txNmInst.setText(con_bancosql.resultSet.getString("nome_Instrumento"));
              txDif.setText(con_bancosql.resultSet.getString("Dif_Instrumento"));
              txModel.setText(con_bancosql.resultSet.getString("modelo_instrumento"));
          }catch(SQLException erro){
              JOptionPane.showMessageDialog(null, "Não localizou os dados : "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);

          }
      }
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