package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.AbstractBorder;


public class Menu extends JFrame {
    // Declaração dos componentes da interface
    JToolBar ferramentas;
    JButton aluno, prof, instrumento, exi;
    JPopupMenu opt;
    JMenuBar bars;
    JMenu sobre, Forms, sair;
    JMenuItem Aluno, Prof, Instrumento, exit, sob, exitPopup, sobPopup;
    JLabel imagemFundo;
    SobrePag SobJanela;
    Forms_Aluno PriJanela;
    Forms_Prof SegJanela;
    Forms_Instrumento TercJanela;

    public Menu() {
        super("Menu");
        setLayout(new BorderLayout());

        // Criação dos botões de navegação sem texto
        aluno = new JButton();
        prof = new JButton();
        instrumento = new JButton();
        exi = new JButton(); // O botão "Sair" inicialmente sem texto

        // Adicionando ícones aos botões (opcional)
        ImageIcon icone = new ImageIcon("IMGs/Icons/Icon.png");//Adicona o icone da tela
        ImageIcon Fundo = new ImageIcon("IMGs/Fundo.jpg");


        setIconImage(icone.getImage());

        imagemFundo = new JLabel(Fundo);
        aluno.setIcon(new ImageIcon("IMGs/Icons/alunoIcon.png")); // Adicionar ícone do aluno
        prof.setIcon(new ImageIcon("IMGs/Icons/profIcon.png"));   // Adicionar ícone do professor
        instrumento.setIcon(new ImageIcon("IMGs/Icons/turmaIcon.png")); // Adicionar ícone do Instrumento
        exi.setIcon(new ImageIcon("IMGs/Icons/sairIcons.png"));    // Adicionar ícone de sair
        // Configurações dos botões
        aluno.setToolTipText("Aluno");
        prof.setToolTipText("Professor");
        instrumento.setToolTipText("Instrumento");
        exi.setToolTipText("Sair");

        // Criação da barra de ferramentas
        ferramentas = new JToolBar("Barra de Ferramentas");
        ferramentas.setRollover(true); // Permite que os botões "deslizem"
        ferramentas.add(aluno);
        ferramentas.add(prof);
        ferramentas.add(instrumento);
        ferramentas.add(exi);

        // Centralizar a barra de ferramentas
        JPanel toolbarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centraliza a barra
        toolbarPanel.add(ferramentas);
        add(toolbarPanel, BorderLayout.NORTH); // Adiciona a barra de ferramentas centralizada

        // Configuração da barra de menus
        bars = new JMenuBar();
        setJMenuBar(bars);

        Forms = new JMenu("Formulários");
        sobre = new JMenu("Sobre");
        sair = new JMenu("Sair");

        bars.add(Forms);
        bars.add(sobre);
        bars.add(sair);

        Aluno = new JMenuItem("Aluno");
        Prof = new JMenuItem("Prof");
        Instrumento = new JMenuItem("Instumento");
        exit = new JMenuItem("Sair");
        sob = new JMenuItem("Sobre");

        sobre.add(sob);
        sair.add(exit);
        Forms.add(Aluno);
        Forms.add(Prof);
        Forms.add(Instrumento);

        // Configuração do menu popup
        opt = new JPopupMenu();
        exitPopup = new JMenuItem(exit.getText());
        sobPopup = new JMenuItem(sob.getText());
        opt.add(exitPopup);
        opt.add(sobPopup);

        // Evento para exibir o menu popup
        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    opt.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        // Ação para abrir o formulário "Aluno"
        aluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PriJanela = new Forms_Aluno(null, "Aluno", true);
                PriJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                PriJanela.setVisible(true);
            }
        });
        Aluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PriJanela = new Forms_Aluno(null, "Aluno", true);
                PriJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                PriJanela.setVisible(true);
            }
        });

        // Ação para abrir o formulário "Professor"
        prof.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SegJanela = new Forms_Prof(null, "Professor", true);
                SegJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                SegJanela.setVisible(true);
            }
        });
        Prof.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SegJanela = new Forms_Prof(null, "Professor", true);
                SegJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                SegJanela.setVisible(true);
            }
        });

        // Ação para abrir o formulário "Turma"
        instrumento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TercJanela = new Forms_Instrumento(null, "Instrumento", true);
                TercJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                TercJanela.setVisible(true);
            }
        });
        Instrumento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TercJanela = new Forms_Instrumento(null, "Instrumento", true);
                TercJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                TercJanela.setVisible(true);
            }
        });

        // Ação para fechar a aplicação ao clicar no botão "Sair"
        exi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pergunta = JOptionPane.showConfirmDialog(null, "Deseja fechar a janela?", "Mensagem saída", JOptionPane.YES_NO_OPTION);
                if (pergunta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Ação para fechar a aplicação ao clicar no menu "Sair"
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pergunta = JOptionPane.showConfirmDialog(null, "Deseja fechar a janela?", "Mensagem saída", JOptionPane.YES_NO_OPTION);
                if (pergunta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Ação para abrir a janela "Sobre" no menu popup
        sobPopup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SobJanela = new SobrePag(null, "Janela Sobre", true);
                SobJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                SobJanela.setVisible(true);
            }
        });

        // Ação para abrir a janela "Sobre" no menu
        sob.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SobJanela = new SobrePag(null, "Janela Sobre", true);
                SobJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                SobJanela.setVisible(true);
            }
        });

        // Configuração da janela principal
        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        Color fundo = new Color(205,133,63); // cor para toda a janela
        getContentPane().setBackground(fundo); // fundo da janela principal
        getContentPane().add(imagemFundo);
        ferramentas.setBackground(new Color(210,105,30));
        aluno.setBackground(new Color(65,105,225));
        instrumento.setBackground(new Color(65,105,225));
        exi.setBackground(new Color(65,105,225));
        prof.setBackground(new Color(65,105,225));

        //Bordas
        aluno.setBorder(new RoundedBorder(8)); // Borda arredondada com raio de 8
        prof.setBorder(new RoundedBorder(8));  // Borda arredondada com raio de 8
        instrumento.setBorder(new RoundedBorder(8)); // Borda arredondada com raio de 8
        exi.setBorder(new RoundedBorder(8));    // Borda arredondada com raio de 8
        bars.setBorder(null);
        ferramentas.setBorder(null);
        


        // Define a cor de fundo do painel que contém a barra de ferramentas
        toolbarPanel.setBackground(fundo);

        // Define a cor de fundo do JMenuBar
        bars.setBackground(new Color(255,222,173));
    }

     //Função para criar bordas
     public class RoundedBorder extends AbstractBorder {
        private int radius;
    
        public RoundedBorder(int radius) {
            this.radius = radius;
        }
    
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(Color.BLACK); // Cor da borda
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius); // Desenha a borda arredondada
        }
    }
}
