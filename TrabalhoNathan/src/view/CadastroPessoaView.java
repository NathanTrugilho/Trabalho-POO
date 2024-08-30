package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CadastroPessoaController;
import model.PessoaFisica;

@SuppressWarnings("serial")
public class CadastroPessoaView extends JFrame {

	private CadastroPessoaController controller;
	private JTextField nomeField;
	private JTextField cpfCnpjField;
	private JTextField prepostoField;
	private JTextField emailField;
	private JTextField telefoneField;
	private JTextField registroField;
	private JComboBox<String> tipoPessoaBox;

	public CadastroPessoaView(MenuView menuView) {
        initialize();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                menuView.setVisible(true); // Mostra o menu principal novamente ao fechar esta janela
            }
        });
    }

	private void initialize() {

	    controller = new CadastroPessoaController();

	    setTitle("Cadastro de Pessoa");
	    setSize(450, 400); // Ajuste o tamanho para acomodar todos os campos
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);

	    JPanel panel = new JPanel();
	    panel.setLayout(new GridBagLayout());
	    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(5, 5, 5, 5);
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    // Campo Tipo de Pessoa
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    JLabel tipoPessoaLabel = new JLabel("Tipo de Pessoa:");
	    panel.add(tipoPessoaLabel, gbc);
	    gbc.gridx = 1;
	    tipoPessoaBox = new JComboBox<>(new String[] { "Pessoa Física", "Pessoa Jurídica", "Advogado" });
	    panel.add(tipoPessoaBox, gbc);

	    // Campo Nome
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    JLabel nomeLabel = new JLabel("Nome:");
	    panel.add(nomeLabel, gbc);
	    gbc.gridx = 1;
	    nomeField = new JTextField(30);
	    panel.add(nomeField, gbc);

	    // Campo CPF/CNPJ
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    JLabel cpfCnpjLabel = new JLabel("CPF (apenas numeros):");
	    panel.add(cpfCnpjLabel, gbc);
	    gbc.gridx = 1;
	    cpfCnpjField = new JTextField(11);
	    panel.add(cpfCnpjField, gbc);

	    // Campo Preposto
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    JLabel prepostoLabel = new JLabel("Preposto:");
	    panel.add(prepostoLabel, gbc);
	    gbc.gridx = 1;
	    prepostoField = new JTextField(30);
	    panel.add(prepostoField, gbc);

	    // Campo Email
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    JLabel emailLabel = new JLabel("Email:");
	    panel.add(emailLabel, gbc);
	    gbc.gridx = 1;
	    emailField = new JTextField(50);
	    panel.add(emailField, gbc);

	    // Campo Telefone
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    JLabel telefoneLabel = new JLabel("Telefone:");
	    panel.add(telefoneLabel, gbc);
	    gbc.gridx = 1;
	    telefoneField = new JTextField(30);
	    panel.add(telefoneField, gbc);

	    // Campo Registro
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    JLabel registroLabel = new JLabel("Registro:");
	    panel.add(registroLabel, gbc);
	    gbc.gridx = 1;
	    registroField = new JTextField(20);
	    panel.add(registroField, gbc);

	    // Ocultar o campo de registro e preposto inicialmente
	    registroLabel.setVisible(false);
	    registroField.setVisible(false);
	    prepostoLabel.setVisible(false);
	    prepostoField.setVisible(false);

	    // Listener para atualizar campos com base na seleção
	    tipoPessoaBox.addItemListener(new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	                atualizarCamposParaTipoSelecionado(registroLabel, cpfCnpjLabel, prepostoLabel);
	            }
	        }
	    });

	    // Botão de Cadastro
	    gbc.gridx = 1;
	    gbc.gridy = 7;
	    gbc.gridwidth = 2;
	    gbc.anchor = GridBagConstraints.CENTER;
	    JButton cadastrarButton = new JButton("Cadastrar");
	    panel.add(cadastrarButton, gbc);
	    
	    
	    cadastrarButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            realizarCadastro();
	        }
	    });
	    
	    getContentPane().add(panel);
	    pack(); // Ajusta o tamanho inicial da janela
	}

	private void atualizarCamposParaTipoSelecionado(JLabel registroLabel, JLabel cpfCnpjLabel, JLabel prepostoLabel) {

		String selected = (String) tipoPessoaBox.getSelectedItem();

		boolean isAdvogado = "Advogado".equals(selected);
		registroLabel.setVisible(isAdvogado);
		registroField.setVisible(isAdvogado);

		boolean isPessoaJuridica = "Pessoa Jurídica".equals(selected);
		prepostoLabel.setVisible(isPessoaJuridica);
		prepostoField.setVisible(isPessoaJuridica);

		cpfCnpjLabel.setText(isPessoaJuridica ? "CNPJ:" : "CPF:");

		pack(); // Ajusta o tamanho da janela para acomodar os componentes visíveis
	}

	private void realizarCadastro() {
	    try {
	        String nome = nomeField.getText();
	        long cpfCnpj = Long.parseLong(cpfCnpjField.getText());
	        String email = emailField.getText();
	        long telefone = telefoneField.getText().isEmpty() ? 0 : Long.parseLong(telefoneField.getText());
	        long registro = registroField.getText().isEmpty() ? 0 : Long.parseLong(registroField.getText());

	        String tipoPessoa = (String) tipoPessoaBox.getSelectedItem();

	        switch (tipoPessoa) {
	            case "Pessoa Física":
	                controller.addPessoasFisicas(nome, cpfCnpj, email, telefone);
	                break;
	            case "Pessoa Jurídica":
	                PessoaFisica preposto = null; // Aqui você pode implementar a lógica para obter um preposto
	                controller.addPessoaJuridica(nome, cpfCnpj, preposto, email, telefone);
	                break;
	            case "Advogado":
	                controller.addAdvogado(nome, cpfCnpj, registro, email, telefone);
	                break;
	        }

	        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
	        limparCampos();
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios corretamente.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void limparCampos() {
		nomeField.setText("");
		cpfCnpjField.setText("");
		emailField.setText("");
		telefoneField.setText("");
		registroField.setText("");
		tipoPessoaBox.setSelectedIndex(0);
	}

}
