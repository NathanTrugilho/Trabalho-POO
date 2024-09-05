package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.MainController;

public class CadastroPessoaView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextField nomeField;
	private JTextField cadastroRFField;
	private JTextField prepostoField;
	private JTextField emailField;
	private JTextField telefoneField;
	private JTextField registroField;
	private JComboBox<String> tipoPessoaBox;
	private JTextArea textArea;

	public CadastroPessoaView() {
		initialize();
	}

	private void initialize() {

		setTitle("Cadastro de Pessoa");

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 2, 5, 2);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;

		// Definir fonte maior
		Font labelFont = new Font("Arial", Font.BOLD, 16);
		Font fieldFont = new Font("Arial", Font.PLAIN, 13);
		Font buttonFont = new Font("Arial", Font.BOLD, 16);

		// Campo Tipo de Pessoa
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel tipoPessoaLabel = new JLabel("Tipo de Pessoa:");
		tipoPessoaLabel.setFont(labelFont);
		panel.add(tipoPessoaLabel, gbc);

		gbc.gridx = 1;
		tipoPessoaBox = new JComboBox<>(new String[] { "Pessoa Física", "Pessoa Jurídica", "Advogado" });
		tipoPessoaBox.setFont(fieldFont);
		panel.add(tipoPessoaBox, gbc);

		// Campo Nome
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(labelFont);
		panel.add(nomeLabel, gbc);

		gbc.gridx = 1;
		nomeField = new JTextField(30);
		nomeField.setFont(fieldFont);
		panel.add(nomeField, gbc);

		// Campo CPF/CNPJ
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel cadastroRFLabel = new JLabel("CPF (numero):");
		cadastroRFLabel.setFont(labelFont);
		panel.add(cadastroRFLabel, gbc);

		gbc.gridx = 1;
		cadastroRFField = new JTextField(20);
		cadastroRFField.setFont(fieldFont);
		panel.add(cadastroRFField, gbc);

		// Campo Preposto
		gbc.gridx = 0;
		gbc.gridy = 3;
		JLabel prepostoLabel = new JLabel("CPF Preposto:");
		prepostoLabel.setFont(labelFont);
		panel.add(prepostoLabel, gbc);

		gbc.gridx = 1;
		prepostoField = new JTextField(11);
		prepostoField.setFont(fieldFont);
		panel.add(prepostoField, gbc);

		// Campo Email
		gbc.gridx = 0;
		gbc.gridy = 4;
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(labelFont);
		panel.add(emailLabel, gbc);

		gbc.gridx = 1;
		emailField = new JTextField(40);
		emailField.setFont(fieldFont);
		panel.add(emailField, gbc);

		// Campo Telefone
		gbc.gridx = 0;
		gbc.gridy = 5;
		JLabel telefoneLabel = new JLabel("Telefone (DDD + num):");
		telefoneLabel.setFont(labelFont);
		panel.add(telefoneLabel, gbc);

		gbc.gridx = 1;
		telefoneField = new JTextField(11);
		telefoneField.setFont(fieldFont);
		panel.add(telefoneField, gbc);

		// Campo Registro
		gbc.gridx = 0;
		gbc.gridy = 6;
		JLabel registroLabel = new JLabel("Registro:");
		registroLabel.setFont(labelFont);
		panel.add(registroLabel, gbc);

		gbc.gridx = 1;
		registroField = new JTextField(20);
		registroField.setFont(fieldFont);
		panel.add(registroField, gbc);

		// Ocultar o campo de registro e preposto inicialmente
		registroLabel.setVisible(false);
		registroField.setVisible(false);
		prepostoLabel.setVisible(false);
		prepostoField.setVisible(false);

		// Listener para atualizar campos com base na seleção
		tipoPessoaBox.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				atualizarCamposParaTipoSelecionado(registroLabel, cadastroRFLabel, prepostoLabel);
				limparCampos();
			}
		});

		// Botão de Cadastro
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setFont(buttonFont);
		panel.add(cadastrarButton, gbc);

		cadastrarButton.addActionListener(e -> realizarCadastro());

		// Botão Listar Tribunais
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		JButton listarButton = new JButton("Listar Pessoas");
		listarButton.setFont(buttonFont);
		panel.add(listarButton, gbc);

		listarButton.addActionListener(e -> listaPessoas());

		// Área de texto para exibir os tribunais
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 2; // Faz com que a área de texto ocupe toda a largura disponível
		gbc.fill = GridBagConstraints.BOTH; // Faz com que a área de texto ocupe o espaço disponível
		gbc.weighty = 1.0; // Faz com que a área de texto ocupe o espaço vertical disponível

		textArea = new JTextArea(10, 40);
		textArea.setEditable(false); // A área de texto é somente leitura
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane, gbc);

		getContentPane().add(panel);
	}

	private void atualizarCamposParaTipoSelecionado(JLabel registroLabel, JLabel cadastroRFLabel, JLabel prepostoLabel) {
		String selected = (String) tipoPessoaBox.getSelectedItem();

		boolean isAdvogado = "Advogado".equals(selected);
		registroLabel.setVisible(isAdvogado);
		registroField.setVisible(isAdvogado);

		boolean isPessoaJuridica = "Pessoa Jurídica".equals(selected);
		prepostoLabel.setVisible(isPessoaJuridica);
		prepostoField.setVisible(isPessoaJuridica);

		cadastroRFLabel.setText(isPessoaJuridica ? "CNPJ (numero):" : "CPF (numero):");
	}

	private void realizarCadastro() {
		try {
			String nome = nomeField.getText();
			String cadastroRF = cadastroRFField.getText();
			String preposto = prepostoField.getText();
			String email = emailField.getText();
			String telefone = telefoneField.getText();
			String registro = registroField.getText();
			String tipoPessoa = (String) this.tipoPessoaBox.getSelectedItem();

			switch (tipoPessoa) {
			case "Pessoa Física":

				if (cadastroRF.isBlank() || !cadastroRF.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Insira um CPF numérico!", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (telefone.isBlank() || !telefone.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Insira um telefone numérico", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				MainController.getPessoaController().addPessoasFisicas(nome, Long.parseLong(cadastroRF), email,
						Long.parseLong(telefone));
				break;

			case "Pessoa Jurídica":

				if (cadastroRF.isBlank() || !cadastroRF.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Insira um CNPJ numérico!", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (preposto.isBlank() || !preposto.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Insira um CPF numérico", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (telefone.isBlank() || !telefone.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Insira um telefone numérico", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				MainController.getPessoaController().addPessoaJuridica(nome, Long.parseLong(cadastroRF),
						Long.parseLong(preposto), email, Long.parseLong(telefone));
				break;

			case "Advogado":

				if (cadastroRF.isBlank() || !cadastroRF.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Insira um CPF numérico!", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (telefone.isBlank() || !telefone.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Insira um telefone numérico", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (registro.isBlank() || !registro.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Insira um registro numérico", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				MainController.getPessoaController().addAdvogados(nome, Long.parseLong(cadastroRF),
						Long.parseLong(registro), email, Long.parseLong(telefone));
				break;
			}

			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
			limparCampos();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void listaPessoas() {
		try {
			// Ultra mega power delegação
			textArea.setText(MainController.getPessoaController().listaPessoas().toString());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao listar as pessoas: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void limparCampos() {
		nomeField.setText("");
		cadastroRFField.setText("");
		emailField.setText("");
		telefoneField.setText("");
		registroField.setText("");
		prepostoField.setText("");
	}
}