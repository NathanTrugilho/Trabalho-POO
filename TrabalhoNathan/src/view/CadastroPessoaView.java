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

		Font labelFont = new Font("Arial", Font.BOLD, 16);
		Font fieldFont = new Font("Arial", Font.PLAIN, 14);
		Font buttonFont = new Font("Arial", Font.BOLD, 16);

		GridBagConstraints gbcTipoPessoaLabel = new GridBagConstraints();
		gbcTipoPessoaLabel.insets = new Insets(5, 5, 5, 5);
		gbcTipoPessoaLabel.gridx = 0;
		gbcTipoPessoaLabel.gridy = 0;
		gbcTipoPessoaLabel.anchor = GridBagConstraints.LINE_START;
		JLabel tipoPessoaLabel = new JLabel("Tipo de Pessoa:");
		tipoPessoaLabel.setFont(labelFont);
		panel.add(tipoPessoaLabel, gbcTipoPessoaLabel);

		GridBagConstraints gbcTipoPessoaBox = new GridBagConstraints();
		gbcTipoPessoaBox.insets = new Insets(5, 5, 5, 5);
		gbcTipoPessoaBox.gridx = 1;
		gbcTipoPessoaBox.gridy = 0;
		gbcTipoPessoaBox.fill = GridBagConstraints.HORIZONTAL;
		gbcTipoPessoaBox.weightx = 1.0;
		tipoPessoaBox = new JComboBox<>(new String[] { "Pessoa Física", "Pessoa Jurídica", "Advogado" });
		tipoPessoaBox.setFont(fieldFont);
		panel.add(tipoPessoaBox, gbcTipoPessoaBox);

		GridBagConstraints gbcNomeLabel = new GridBagConstraints();
		gbcNomeLabel.insets = new Insets(5, 5, 5, 5);
		gbcNomeLabel.gridx = 0;
		gbcNomeLabel.gridy = 1;
		gbcNomeLabel.anchor = GridBagConstraints.LINE_START;
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(labelFont);
		panel.add(nomeLabel, gbcNomeLabel);

		GridBagConstraints gbcNomeField = new GridBagConstraints();
		gbcNomeField.insets = new Insets(5, 5, 5, 5);
		gbcNomeField.gridx = 1;
		gbcNomeField.gridy = 1;
		gbcNomeField.fill = GridBagConstraints.HORIZONTAL;
		gbcNomeField.weightx = 1.0;
		nomeField = new JTextField(30);
		nomeField.setFont(fieldFont);
		panel.add(nomeField, gbcNomeField);

		GridBagConstraints gbcCadastroRFLabel = new GridBagConstraints();
		gbcCadastroRFLabel.insets = new Insets(5, 5, 5, 5);
		gbcCadastroRFLabel.gridx = 0;
		gbcCadastroRFLabel.gridy = 2;
		gbcCadastroRFLabel.anchor = GridBagConstraints.LINE_START;
		JLabel cadastroRFLabel = new JLabel("CPF (numero):");
		cadastroRFLabel.setFont(labelFont);
		panel.add(cadastroRFLabel, gbcCadastroRFLabel);

		GridBagConstraints gbcCadastroRFField = new GridBagConstraints();
		gbcCadastroRFField.insets = new Insets(5, 5, 5, 5);
		gbcCadastroRFField.gridx = 1;
		gbcCadastroRFField.gridy = 2;
		gbcCadastroRFField.fill = GridBagConstraints.HORIZONTAL;
		gbcCadastroRFField.weightx = 1.0;
		cadastroRFField = new JTextField(20);
		cadastroRFField.setFont(fieldFont);
		panel.add(cadastroRFField, gbcCadastroRFField);

		GridBagConstraints gbcPrepostoLabel = new GridBagConstraints();
		gbcPrepostoLabel.insets = new Insets(5, 5, 5, 5);
		gbcPrepostoLabel.gridx = 0;
		gbcPrepostoLabel.gridy = 3;
		gbcPrepostoLabel.anchor = GridBagConstraints.LINE_START;
		JLabel prepostoLabel = new JLabel("CPF Preposto:");
		prepostoLabel.setFont(labelFont);
		panel.add(prepostoLabel, gbcPrepostoLabel);

		GridBagConstraints gbcPrepostoField = new GridBagConstraints();
		gbcPrepostoField.insets = new Insets(5, 5, 5, 5);
		gbcPrepostoField.gridx = 1;
		gbcPrepostoField.gridy = 3;
		gbcPrepostoField.fill = GridBagConstraints.HORIZONTAL;
		gbcPrepostoField.weightx = 1.0;
		prepostoField = new JTextField(11);
		prepostoField.setFont(fieldFont);
		panel.add(prepostoField, gbcPrepostoField);

		GridBagConstraints gbcEmailLabel = new GridBagConstraints();
		gbcEmailLabel.insets = new Insets(5, 5, 5, 5);
		gbcEmailLabel.gridx = 0;
		gbcEmailLabel.gridy = 4;
		gbcEmailLabel.anchor = GridBagConstraints.LINE_START;
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(labelFont);
		panel.add(emailLabel, gbcEmailLabel);

		GridBagConstraints gbcEmailField = new GridBagConstraints();
		gbcEmailField.insets = new Insets(5, 5, 5, 5);
		gbcEmailField.gridx = 1;
		gbcEmailField.gridy = 4;
		gbcEmailField.fill = GridBagConstraints.HORIZONTAL;
		gbcEmailField.weightx = 1.0;
		emailField = new JTextField(40);
		emailField.setFont(fieldFont);
		panel.add(emailField, gbcEmailField);

		GridBagConstraints gbcTelefoneLabel = new GridBagConstraints();
		gbcTelefoneLabel.insets = new Insets(5, 5, 5, 5);
		gbcTelefoneLabel.gridx = 0;
		gbcTelefoneLabel.gridy = 5;
		gbcTelefoneLabel.anchor = GridBagConstraints.LINE_START;
		JLabel telefoneLabel = new JLabel("Telefone (DDD + num):");
		telefoneLabel.setFont(labelFont);
		panel.add(telefoneLabel, gbcTelefoneLabel);

		GridBagConstraints gbcTelefoneField = new GridBagConstraints();
		gbcTelefoneField.insets = new Insets(5, 5, 5, 5);
		gbcTelefoneField.gridx = 1;
		gbcTelefoneField.gridy = 5;
		gbcTelefoneField.fill = GridBagConstraints.HORIZONTAL;
		gbcTelefoneField.weightx = 1.0;
		telefoneField = new JTextField(11);
		telefoneField.setFont(fieldFont);
		panel.add(telefoneField, gbcTelefoneField);

		GridBagConstraints gbcRegistroLabel = new GridBagConstraints();
		gbcRegistroLabel.insets = new Insets(5, 5, 5, 5);
		gbcRegistroLabel.gridx = 0;
		gbcRegistroLabel.gridy = 6;
		gbcRegistroLabel.anchor = GridBagConstraints.LINE_START;
		JLabel registroLabel = new JLabel("Registro:");
		registroLabel.setFont(labelFont);
		panel.add(registroLabel, gbcRegistroLabel);

		GridBagConstraints gbcRegistroField = new GridBagConstraints();
		gbcRegistroField.insets = new Insets(5, 5, 5, 5);
		gbcRegistroField.gridx = 1;
		gbcRegistroField.gridy = 6;
		gbcRegistroField.fill = GridBagConstraints.HORIZONTAL;
		gbcRegistroField.weightx = 1.0;
		registroField = new JTextField(20);
		registroField.setFont(fieldFont);
		panel.add(registroField, gbcRegistroField);

		registroLabel.setVisible(false);
		registroField.setVisible(false);
		prepostoLabel.setVisible(false);
		prepostoField.setVisible(false);

		tipoPessoaBox.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				atualizarCamposParaTipoSelecionado(registroLabel, cadastroRFLabel, prepostoLabel);
				limparCampos();
			}
		});

		GridBagConstraints gbcCadastrarButton = new GridBagConstraints();
		gbcCadastrarButton.insets = new Insets(10, 5, 10, 5);
		gbcCadastrarButton.gridx = 1;
		gbcCadastrarButton.gridy = 7;
		gbcCadastrarButton.fill = GridBagConstraints.HORIZONTAL;
		gbcCadastrarButton.anchor = GridBagConstraints.LINE_START;
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setFont(buttonFont);
		panel.add(cadastrarButton, gbcCadastrarButton);

		cadastrarButton.addActionListener(e -> realizarCadastro());

		GridBagConstraints gbcListarButton = new GridBagConstraints();
		gbcListarButton.insets = new Insets(10, 5, 10, 5);
		gbcListarButton.gridx = 0;
		gbcListarButton.gridy = 7;
		gbcListarButton.fill = GridBagConstraints.HORIZONTAL;
		gbcListarButton.anchor = GridBagConstraints.LINE_START;
		JButton listarButton = new JButton("Listar Pessoas");
		listarButton.setFont(buttonFont);
		panel.add(listarButton, gbcListarButton);

		listarButton.addActionListener(e -> listaPessoas());

		GridBagConstraints gbcScrollPane = new GridBagConstraints();
		gbcScrollPane.insets = new Insets(10, 5, 10, 5);
		gbcScrollPane.gridx = 0;
		gbcScrollPane.gridy = 8;
		gbcScrollPane.gridwidth = 2;
		gbcScrollPane.fill = GridBagConstraints.BOTH;
		gbcScrollPane.weightx = 1.0;
		gbcScrollPane.weighty = 1.0;
		textArea = new JTextArea(10, 40);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane, gbcScrollPane);

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

				MainController.getPessoaController().addPessoasFisicas(nome, cadastroRF, email,
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

				MainController.getPessoaController().addPessoaJuridica(nome, cadastroRF, preposto, email,
						Long.parseLong(telefone));
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

				if (registro.isBlank()) {
					JOptionPane.showMessageDialog(null, "Insira um registro!", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				MainController.getPessoaController().addAdvogados(nome, cadastroRF, registro, email,
						Long.parseLong(telefone));
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
