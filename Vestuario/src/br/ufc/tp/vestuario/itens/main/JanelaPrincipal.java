package br.ufc.tp.vestuario.itens.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JanelaPrincipal extends JFrame{

	public JanelaPrincipal(String titulo) {
        super(titulo);
        
        MeuOuvinte ouvinte = new MeuOuvinte();
        
        //DEFINIÇÕES DA TELA
        setLayout(null);
        setSize(1200, 700);
        Image icone = new ImageIcon(getClass().getResource("/ufc.png")).getImage(); //icone da ufc
        setIconImage(icone);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#1c2130"));
        
        JPanel pane = new JPanel();
        JButton cadastrar = new JButton("CADASTRAR");
        JButton estatisticas = new JButton("ESTATISTICAS");
        JButton procurar = new JButton("PROCURAR");
        JButton emprestados = new JButton("EMPREESTADOS");
        
        ImageIcon camisa = new ImageIcon(getClass().getResource("/camisa.png"));
        JLabel ImagemCamisa = new JLabel(camisa);
        
        Image camisaredimensionada = ImagemCamisa.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImagemCamisa.setBounds(840, 510, 300, 300);
        
        Image adicionar = new ImageIcon(this.getClass().getResource("/b_adicionar.png")).getImage();
        Image redimensionada = adicionar.getScaledInstance(70, 70, Image.SCALE_SMOOTH); // tamanho da imagem
        cadastrar.setIcon(new ImageIcon(redimensionada));
        
        pane.setLayout(null);
        
        cadastrar.setBounds(30, 40, 300, 150);
        cadastrar.setBackground(Color.decode("#071230"));  // Cor de fundo
        cadastrar.setForeground(Color.WHITE);              
        cadastrar.setFocusPainted(false);                  // Remove o contorno de foco
        cadastrar.setBorderPainted(false);                 // Remove a borda
        cadastrar.setContentAreaFilled(true);
        
        estatisticas.setBounds(30, 210, 300, 150);
        estatisticas.setBackground(Color.decode("#071230"));  // Cor de fundo
        estatisticas.setForeground(Color.WHITE);              
        estatisticas.setFocusPainted(false);                  // Remove o contorno de foco
        estatisticas.setBorderPainted(false);                 // Remove a borda
        estatisticas.setContentAreaFilled(true);
        
        procurar.setBounds(370, 40, 300, 150);
        procurar.setBackground(Color.decode("#071230"));  // Cor de fundo
        procurar.setForeground(Color.WHITE);              
        procurar.setFocusPainted(false);                  // Remove o contorno de foco
        procurar.setBorderPainted(false);                 // Remove a borda
        procurar.setContentAreaFilled(true);
        
        emprestados.setBounds(370, 210, 300, 150);
        emprestados.setBackground(Color.decode("#071230"));  // Cor de fundo
        emprestados.setForeground(Color.WHITE);              
        emprestados.setFocusPainted(false);                  // Remove o contorno de foco
        emprestados.setBorderPainted(false);                 // Remove a borda
        emprestados.setContentAreaFilled(true);
        
        pane.add(cadastrar);
        pane.add(estatisticas);
        pane.add(procurar);
        pane.add(emprestados);
        
        pane.setBounds(30, 100, 800, 400);
        pane.setBackground(Color.decode("#20273b"));
        
        add(ImagemCamisa);
        add(pane);
        /*
        Image photo = new ImageIcon(this.getClass().getResource("/adicionar.png")).getImage();
        botao.setIcon(new ImageIcon(photo));
        botao.addActionListener(ouvinte);
        pane.add(botao);
        */

        //Confirmação de fechar a janela principal
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            //Se tentar fechar a janela
            public void windowClosing(WindowEvent e) {
                int opcao = JOptionPane.showConfirmDialog(
                    JanelaPrincipal.this,
                    "Deseja Fechar o Vestuário?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.DEFAULT_OPTION
                );
                if (opcao == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        setVisible(true);
    }

    


}
