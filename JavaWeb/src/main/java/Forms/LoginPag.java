
package Forms;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

import Conexao.conexao;
import java.sql.*;
import java.sql.SQLException;

public class LoginPag extends JFrame {

    conexao con_escolaMusica;
    JLabel rUsuario, rSenha, rTitulo;
    JLabel imagemFundo,JbuttonImg;
    JTextField tUsuario;
    JPasswordField tSenha;
    JButton bLogar;

    public LoginPag() {
        con_escolaMusica = new conexao();
        con_escolaMusica.conecta();

        setTitle("Login de Acesso");
        Container tela = getContentPane();
        setLayout(null);
        
        //imgs
        ImageIcon cont = new ImageIcon("IMGs/Icons/Conta.png");//Icone da tela
        setIconImage(cont.getImage());
        ImageIcon Fundo = new ImageIcon("IMGs/ContaFundo.png");//Imagem de fundo
        ImageIcon buttonIMG = new ImageIcon("IMGs/Log.png");



        imagemFundo = new JLabel(Fundo);
        imagemFundo.setBounds(220,60,100,100);

        rTitulo = new JLabel("Acesso ao Controle de Turmas");
        rTitulo.setBounds(135, 20, 300, 50);

        rUsuario = new JLabel("Usuario: ");
        rUsuario.setBounds(150, 160, 100, 20);
        tUsuario = new JTextField(50);
        tUsuario.setBorder(new RoundedBorder(5));
        tUsuario.setBounds(210, 160, 150, 20);

        rSenha = new JLabel("Senha : ");
        rSenha.setBounds(150, 200, 100, 20);
        tSenha = new JPasswordField(50);
        tSenha.setBorder(new RoundedBorder(5));
        tSenha.setBounds(210, 200, 150, 20);

        bLogar = new JButton("Login",buttonIMG);
        bLogar.setBounds(215, 250, 120, 30);
        bLogar.setBorder(new RoundedBorderButton(5));
        bLogar.setBackground(new Color(65,105,225));

        bLogar.setHorizontalTextPosition(SwingConstants.LEFT);
        bLogar.setVerticalTextPosition(SwingConstants.CENTER);

        bLogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String pesquisa = "select * from acesso where usuario like '" + tUsuario.getText()
                            + "' && senha  like '" + tSenha.getText() + "'";
                    con_escolaMusica.executaSQL(pesquisa);

                    if (con_escolaMusica.resultSet.first()) {
                        Menu app = new Menu();
                        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "\n Usuário não cadastrado!!!!", "Mensagem do Programa",
                                JOptionPane.INFORMATION_MESSAGE);
                        con_escolaMusica.desconecta();
                        System.exit(0);
                    }
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n " + errosql,
                            "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });

        // Cores
        tela.setBackground(new Color(205, 133, 63));
        tUsuario.setBackground(new Color(244, 164, 96));
        tSenha.setBackground(new Color(244, 164, 96));
        bLogar.setForeground(new Color(220,220,220));

        //Fontes
        rSenha.setFont(new Font("Roboto",Font.BOLD,14));
        rTitulo.setFont(new Font("Roboto",Font.BOLD,18));
        rUsuario.setFont(new Font("Roboto",Font.BOLD,14));
        



        tela.add(rTitulo);
        tela.add(rUsuario);
        tela.add(rSenha);
        tela.add(tUsuario);
        tela.add(tSenha);
        tela.add(bLogar);
        getContentPane().add(imagemFundo);
        

        setSize(550, 400);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    // RounderBorder
    class RoundedBorder implements Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius + 1, radius + 1, radius + 1, radius + 1);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
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
    public static void main(String[] args) {
        LoginPag app = new LoginPag();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}