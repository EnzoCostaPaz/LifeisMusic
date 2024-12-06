
package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

public class SobrePag extends JDialog{
    JLabel Integrante1, Integrante2, Integrante3 ,sala;
    JButton fechar;

    public SobrePag(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        Container TelaS = getContentPane();
        TelaS.setLayout(null);
        //IMGs
        ImageIcon fech = new ImageIcon("IMGs/fechar.png");
        ImageIcon icon = new ImageIcon("IMGs/Icons/sobreIcons.png");
        setIconImage(icon.getImage());//icone da tela

        Integrante1 = new JLabel("Nome: Jhonata Alves do Nascimento");
        Integrante2 = new JLabel("Nome: Gustavo Henrique Ribeiro da Silva");
        Integrante3 = new JLabel("Nome: Enzo Costa Paz");
        sala = new JLabel("Sala: 2°AMS grupo A");
        fechar = new JButton("Fechar",fech);

       
        //setBounds e Fontes
        Integrante1.setBounds(40,40,300,20);
        Integrante1.setFont(new Font("Roboto",Font.BOLD,14));

        Integrante2.setBounds(40,70,300,20);
        Integrante2.setFont(new Font("Roboto",Font.BOLD,14));

        Integrante3.setBounds(40,100,300,20);
        Integrante3.setFont(new Font("Roboto",Font.BOLD,14));

        sala.setBounds(40,140,200,20);
        sala.setFont(new Font("Roboto",Font.BOLD,14));

        fechar.setBounds(40,180,120,30);
        fechar.setHorizontalTextPosition(SwingConstants.LEFT);
        fechar.setVerticalTextPosition(SwingConstants.CENTER);
        
        fechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        TelaS.add(Integrante1);
        TelaS.add(Integrante2);
        TelaS.add(Integrante3);
        TelaS.add(sala);
        TelaS.add(fechar);
        setSize(500, 300);
        setLocationRelativeTo(null);

        TelaS.setBackground(new Color(205, 133, 63));
        fechar.setBackground(new Color(65,105,225));
        fechar.setForeground(new Color(220,220,220));
        fechar.setBorder(new RoundedBorder(8, Color.BLACK));
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
