package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.MainController;

@SuppressWarnings("serial")
public class CadastroTribunalView extends JFrame {

	private JTextField siglaField;
	private JTextField secaoField;
	private JTextField descricaoField;
	private JTextArea textArea; // Área de texto para exibir os tribunais

	public CadastroTribunalView() {
		initialize();
	}

	private void initialize() {
		setTitle("Tribunal View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400); // Tamanho aumentado para acomodar a área de texto
		setLocationRelativeTo(null); // Centraliza a janela

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adiciona margens internas

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 2, 5, 2); // Ajusta o espaçamento entre os componentes
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0; // Faz com que os campos ocupem o espaço disponível

		// Definir fonte
		Font labelFont = new Font("Arial", Font.BOLD, 16); // Fonte maior para os labels
		Font fieldFont = new Font("Arial", Font.PLAIN, 16); // Fonte maior para os campos de texto
		Font buttonFont = new Font("Arial", Font.BOLD, 16); // Fonte para o botão

		// Campo 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel label1 = new JLabel("Sigla:");
		label1.setFont(labelFont);
		panel.add(label1, gbc);

		gbc.gridx = 1;
		siglaField = new JTextField(25); // Aumenta o tamanho dos campos
		siglaField.setFont(fieldFont);
		panel.add(siglaField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel label2 = new JLabel("Seção:");
		label2.setFont(labelFont);
		panel.add(label2, gbc);

		gbc.gridx = 1;
		secaoField = new JTextField(25); // Aumenta o tamanho dos campos
		secaoField.setFont(fieldFont);
		panel.add(secaoField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel label3 = new JLabel("Descrição:");
		label3.setFont(labelFont);
		panel.add(label3, gbc);

		gbc.gridx = 1;
		descricaoField = new JTextField(25); // Aumenta o tamanho dos campos
		descricaoField.setFont(fieldFont);
		panel.add(descricaoField, gbc);

		// Botão Confirmar Cadastro
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER; // Centraliza o botão
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setFont(buttonFont);
		panel.add(cadastrarButton, gbc);

		cadastrarButton.addActionListener(e -> realizarCadastro());

		// Botão Listar Tribunais
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		JButton listarButton = new JButton("Listar Tribunais");
		listarButton.setFont(buttonFont);
		panel.add(listarButton, gbc);

		listarButton.addActionListener(e -> listaTribunais());

		// Área de texto para exibir os tribunais
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 3; // Faz com que a área de texto ocupe toda a largura disponível
		gbc.fill = GridBagConstraints.BOTH; // Faz com que a área de texto ocupe o espaço disponível
		gbc.weighty = 1.0; // Faz com que a área de texto ocupe o espaço vertical disponível

		textArea = new JTextArea(10, 40);
		textArea.setEditable(false); // A área de texto é somente leitura
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane, gbc);

		// Adiciona o painel ao JFrame
		getContentPane().add(panel);
	}

	private void realizarCadastro() {
		try {
			String sigla = siglaField.getText();
			String secao = secaoField.getText();
			String descricao = descricaoField.getText();

			MainController.getCadastroTribunalController().addTribunal(sigla, secao, descricao);

			JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

			limparCampos();

		} catch (Exception e) {
			// Em caso de erro, mostrar uma mensagem de erro
			JOptionPane.showMessageDialog(this, "Ocorreu um erro ao realizar o cadastro: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void listaTribunais() {
		try {

			// Ultra mega power delegação
			textArea.setText(MainController.getCadastroTribunalController().listaTribunais().toString());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro ao listar os tribunais: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void limparCampos() {
		siglaField.setText("");
		secaoField.setText("");
		descricaoField.setText("");
	}
}
