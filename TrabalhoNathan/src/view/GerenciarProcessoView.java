package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GerenciarProcessoView extends JFrame {

    private static final long serialVersionUID = 6883104333378305544L;

    // Componentes da parte esquerda
    private JTextField cadastroRFField;
    private JButton pesquisarButton;
    private JComboBox<String> comboBox;

    // Botões da parte direita
    private JButton botao1;
    private JButton botao2;
    private JButton botao3;
    private JButton botao4;

    public GerenciarProcessoView() {
        initialize();
    }

    private void initialize() {
        setTitle("Gerenciar Processo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Centraliza a janela

        // Layout da janela
        JPanel panel = new JPanel(new GridBagLayout());
        
        // Fonte para os campos e botões
        Font fieldFont = new Font("Arial", Font.BOLD, 15);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Font labelFont = new Font("Arial", Font.BOLD, 16); // Fonte para o label

        // GridBagConstraints para cada componente
        GridBagConstraints gbcCadastroRFLabel = new GridBagConstraints();
        gbcCadastroRFLabel.insets = new Insets(10, 10, 10, 10);
        gbcCadastroRFLabel.gridx = 0;
        gbcCadastroRFLabel.gridy = 0;
        gbcCadastroRFLabel.anchor = GridBagConstraints.LINE_START;
        JLabel cadastroRFLabel = new JLabel("CadastroRF:");
        cadastroRFLabel.setFont(labelFont); // Definindo a fonte do label
        panel.add(cadastroRFLabel, gbcCadastroRFLabel);

        GridBagConstraints gbcCadastroRFField = new GridBagConstraints();
        gbcCadastroRFField.insets = new Insets(10, 10, 10, 10);
        gbcCadastroRFField.gridx = 1;
        gbcCadastroRFField.gridy = 0;
        gbcCadastroRFField.gridwidth = 2; // O campo de texto ocupa duas colunas
        gbcCadastroRFField.fill = GridBagConstraints.HORIZONTAL;
        gbcCadastroRFField.weightx = 1.0; // Permite expansão horizontal
        JTextField cadastroRFField = new JTextField(20);
        cadastroRFField.setFont(fieldFont);
        panel.add(cadastroRFField, gbcCadastroRFField);

        GridBagConstraints gbcPesquisarButton = new GridBagConstraints();
        gbcPesquisarButton.insets = new Insets(10, 10, 10, 10);
        gbcPesquisarButton.gridx = 3;
        gbcPesquisarButton.gridy = 0;
        gbcPesquisarButton.fill = GridBagConstraints.BOTH;
        gbcPesquisarButton.weightx = 0; // Não expande horizontalmente
        gbcPesquisarButton.anchor = GridBagConstraints.CENTER;
        JButton pesquisarButton = new JButton("Listar Processos");
        pesquisarButton.setFont(buttonFont);
        panel.add(pesquisarButton, gbcPesquisarButton);

        GridBagConstraints gbcNumeroProcessoLabel = new GridBagConstraints();
        gbcNumeroProcessoLabel.insets = new Insets(5, 10, 0, 10); // 
        gbcNumeroProcessoLabel.gridx = 1;
        gbcNumeroProcessoLabel.gridy = 1;
        JLabel numeroProcessoLabel = new JLabel("Número do processo");
        numeroProcessoLabel.setFont(labelFont);
        panel.add(numeroProcessoLabel, gbcNumeroProcessoLabel);

        GridBagConstraints gbcComboBox = new GridBagConstraints();
        gbcComboBox.anchor = GridBagConstraints.NORTH;
        gbcComboBox.insets = new Insets(10, 10, 10, 10); // 
        gbcComboBox.gridx = 0;
        gbcComboBox.gridy = 2;  // A comboBox foi mantida na linha 2
        gbcComboBox.gridwidth = 3; // O comboBox ocupa três colunas
        gbcComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbcComboBox.weightx = 1.0; // Permite expansão horizontal
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setFont(fieldFont);
        panel.add(comboBox, gbcComboBox);
        
        // GridBagConstraints para o painel de botões
        GridBagConstraints gbcBotoesPanel = new GridBagConstraints();
        gbcBotoesPanel.insets = new Insets(10, 5, 10, 5);
        gbcBotoesPanel.gridx = 3;
        gbcBotoesPanel.gridy = 1;
        gbcBotoesPanel.gridwidth = 1;
        gbcBotoesPanel.gridheight = 2;
        gbcBotoesPanel.fill = GridBagConstraints.BOTH;
        gbcBotoesPanel.weightx = 0; // Não expande horizontalmente
        gbcBotoesPanel.weighty = 1.0; // Expande verticalmente
        gbcBotoesPanel.anchor = GridBagConstraints.CENTER;
        JPanel botoesPanel = new JPanel(new GridBagLayout());
        
        // GridBagConstraints para cada botão
        GridBagConstraints gbcBotao1 = new GridBagConstraints();
        gbcBotao1.insets = new Insets(10, 5, 10, 5);
        gbcBotao1.gridx = 0;
        gbcBotao1.gridy = 0;
        gbcBotao1.fill = GridBagConstraints.HORIZONTAL;
        JButton botao1 = new JButton("Botão 1");
        botao1.setFont(buttonFont);
        botoesPanel.add(botao1, gbcBotao1);

        GridBagConstraints gbcBotao2 = new GridBagConstraints();
        gbcBotao2.insets = new Insets(10, 5, 10, 5);
        gbcBotao2.gridx = 0;
        gbcBotao2.gridy = 1;
        gbcBotao2.fill = GridBagConstraints.HORIZONTAL;
        JButton botao2 = new JButton("Botão 2");
        botao2.setFont(buttonFont);
        botoesPanel.add(botao2, gbcBotao2);

        GridBagConstraints gbcBotao3 = new GridBagConstraints();
        gbcBotao3.insets = new Insets(10, 5, 10, 5);
        gbcBotao3.gridx = 0;
        gbcBotao3.gridy = 2;
        gbcBotao3.fill = GridBagConstraints.HORIZONTAL;
        JButton botao3 = new JButton("Botão 3");
        botao3.setFont(buttonFont);
        botoesPanel.add(botao3, gbcBotao3);

        GridBagConstraints gbcBotao4 = new GridBagConstraints();
        gbcBotao4.insets = new Insets(10, 5, 10, 5);
        gbcBotao4.gridx = 0;
        gbcBotao4.gridy = 3;
        gbcBotao4.fill = GridBagConstraints.HORIZONTAL;
        JButton botao4 = new JButton("Botão 4");
        botao4.setFont(buttonFont);
        botoesPanel.add(botao4, gbcBotao4);

        panel.add(botoesPanel, gbcBotoesPanel);

        // Adiciona o painel ao JFrame
        getContentPane().add(panel);
    }
}
