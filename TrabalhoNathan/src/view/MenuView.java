package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CadastroPessoaController;

@SuppressWarnings("serial")
public class MenuView extends JFrame {

    private CadastroPessoaController controller;
    private JTextField nomeField, cpfCnpjField, emailField, telefoneField, registroField;
    private JComboBox<String> tipoPessoaBox;
    
    private JPanel contentPane;

    private JButton btnCadastroPessoa;
    
	public MenuView() {
		initialize();
	}

    private void initialize() {

        setTitle("App advocacia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel(new GridBagLayout());
        contentPane.setBorder(new EmptyBorder(12, 15, 12, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.CENTER; //Tipo da responsividade
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        
        // Botão para Categorias
        btnCadastroPessoa = createButton("Cadastro de Pessoas");
        gbc.gridy = 0;
        contentPane.add(btnCadastroPessoa, gbc);

        /*
        // Botão para Itens
        btnItemView = createButton("Itens");
        gbc.gridy = 1;
        contentPane.add(btnItemView, gbc);

        // Botão para Clientes
        btnClienteView = createButton("Clientes");
        gbc.gridy = 2;
        contentPane.add(btnClienteView, gbc);

        // Botão para Fornecedores
        btnFornecedorView = createButton("Fornecedores");
        gbc.gridy = 3;
        contentPane.add(btnFornecedorView, gbc);

        // Botão para Produtos
        btnProdutoView = createButton("Produtos");
        gbc.gridy = 4;
        contentPane.add(btnProdutoView, gbc);

        // Botão para Relatórios
        btnRelatorioView = createButton("Relatórios");
        gbc.gridy = 5;
        contentPane.add(btnRelatorioView, gbc);*/

        // Ações para os botões
        btnCadastroPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCadastroPessoaView();
			}
		});

        setContentPane(contentPane);
        pack();  // Ajusta o tamanho da janela para acomodar os componentes
        setLocationRelativeTo(null);  // Centraliza a janela
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 130, 180));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 40));
        return button;
    }

    private void actionCadastroPessoaView() {
        CadastroPessoaView cadastroPessoaView = new CadastroPessoaView();
        cadastroPessoaView.setVisible(true);
    }

}
