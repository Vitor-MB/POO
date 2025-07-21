package br.ufc.tp.vestuario.itens.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import br.ufc.tp.vestuario.itens.ConservacaoEnum;
import br.ufc.tp.vestuario.itens.TamanhoEnum;



public class JanelaCadastroItem extends JFrame{
	public JanelaCadastroItem() {
		super("Cadastre seu Item");
		
		setLayout(null);
        setSize(1200, 700);
        Image icone = new ImageIcon(getClass().getResource("/ufc.png")).getImage(); //icone da ufc
        setIconImage(icone);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#1c2130"));
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            //Se tentar fechar a janela
            public void windowClosing(WindowEvent e) {
                int opcao = JOptionPane.showConfirmDialog(
                    JanelaCadastroItem.this,
                    "Deseja Deesistir de Cadastrar Item",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.DEFAULT_OPTION
                );
                if (opcao == JOptionPane.YES_OPTION) {
                    dispose();
                    JanelaCadastrar Cadastro = new JanelaCadastrar();
                }
            }
        });
        
        JPanel pane = new JPanel();
        pane.setBounds(50, 30, 1100,620);
        pane.setBackground(Color.decode("#20273b"));
        pane.setLayout(null);
        
		String[] opcoes = {"Superior Interno","Intimo", "Superior Externo", "Inferior", "Calçado", "Acessório"};
        JComboBox<String> Classe = new JComboBox<>(opcoes);
        Classe.setBounds(10, 0, 140, 30);
        Classe.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JTextField Id = new JTextField();
        Id.setBounds(10, 70, 190, 30);
        JLabel labelId = new JLabel("ID:");
        labelId.setForeground(Color.WHITE);
        labelId.setBounds(10, 50, 190, 20);
        
        
        JTextField Cor = new JTextField();
        Cor.setBounds(240,140, 60, 30);
        JLabel labelCor= new JLabel("Cor:");
        labelCor.setForeground(Color.WHITE);
        labelCor.setBounds(240, 120, 190, 20);
        
        JTextField Loja = new JTextField();
        Loja.setBounds(10, 140, 190, 30);
        JLabel labelLoja= new JLabel("Loja:");
        labelLoja.setForeground(Color.WHITE);
        labelLoja.setBounds(10, 120, 190, 20);
        
        JComboBox<TamanhoEnum> Tamanho = new JComboBox<>(TamanhoEnum.values());
        Tamanho.setBounds(12, 210, 50, 30);
        Tamanho.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel labelTamanho= new JLabel("Tamanho:");
        labelTamanho.setForeground(Color.WHITE);
        labelTamanho.setBounds(10, 190, 190, 20);
        
        ButtonGroup Conservacao = new ButtonGroup();
        
        JRadioButton radio = new JRadioButton(ConservacaoEnum.RUIM.getString());
        radio.setActionCommand(ConservacaoEnum.RUIM.name());
        radio.setBounds(10, 250, 200, 20);
        radio.setForeground(Color.WHITE);
        radio.setBackground(Color.decode("#20273b")); 

        Conservacao.add(radio);
        pane.add(radio);
            
        
        pane.add(labelTamanho);
        pane.add(labelLoja);
        pane.add(labelCor);
        pane.add(labelId);
        pane.add(Tamanho);
        pane.add(Id);
        pane.add(Cor);
        pane.add(Loja);
        pane.add(Classe);
        add(pane);
        setVisible(true);
	}
}
