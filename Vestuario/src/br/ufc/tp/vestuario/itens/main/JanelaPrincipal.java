package br.ufc.tp.vestuario.itens.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JanelaPrincipal extends JFrame{

	public JanelaPrincipal(String titulo) {
        super(titulo);

        JPanel pane = new JPanel();
        JButton botao = new JButton("Texto botao");
        pane.add(botao);

        setLayout(new BorderLayout());
        setContentPane(pane);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JOptionPane.showInputDialog("OPA");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcao = JOptionPane.showConfirmDialog(
                    JanelaPrincipal.this,
                    "Deseja realmente fechar a janela?",
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
