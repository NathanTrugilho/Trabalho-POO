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

public class CadastroTribunalView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField siglaField;
	private JTextField secaoField;
	private JTextField descricaoField;
	private JTextArea textArea;

	public CadastroTribunalView() {
		initialize();
	}

	private void initialize() {
	    setTitle("Tribunal View");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(500, 400);
	    setLocationRelativeTo(null);

	    JPanel panel = new JPanel(new GridBagLayout());
	    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	    Font labelFont = new Font("Arial", Font.BOLD, 16); 
	    Font fieldFont = new Font("Arial", Font.PLAIN, 16); 
	    Font buttonFont = new Font("Arial", Font.BOLD, 16); 

	    GridBagConstraints gbcSiglaLabel = new GridBagConstraints();
	    gbcSiglaLabel.insets = new Insets(5, 2, 5, 2);
	    gbcSiglaLabel.gridx = 0;
	    gbcSiglaLabel.gridy = 0;
	    gbcSiglaLabel.anchor = GridBagConstraints.LINE_START;
	    JLabel label1 = new JLabel("Sigla:");
	    label1.setFont(labelFont);
	    panel.add(label1, gbcSiglaLabel);

	    GridBagConstraints gbcSiglaField = new GridBagConstraints();
	    gbcSiglaField.insets = new Insets(5, 2, 5, 2);
	    gbcSiglaField.gridx = 1;
	    gbcSiglaField.gridy = 0;
	    gbcSiglaField.fill = GridBagConstraints.HORIZONTAL;
	    gbcSiglaField.weightx = 1.0;
	    siglaField = new JTextField(12);
	    siglaField.setFont(fieldFont);
	    panel.add(siglaField, gbcSiglaField);

	    GridBagConstraints gbcSecaoLabel = new GridBagConstraints();
	    gbcSecaoLabel.insets = new Insets(5, 2, 5, 2);
	    gbcSecaoLabel.gridx = 0;
	    gbcSecaoLabel.gridy = 1;
	    gbcSecaoLabel.anchor = GridBagConstraints.LINE_START;
	    JLabel label2 = new JLabel("Seção:");
	    label2.setFont(labelFont);
	    panel.add(label2, gbcSecaoLabel);

	    GridBagConstraints gbcSecaoField = new GridBagConstraints();
	    gbcSecaoField.insets = new Insets(5, 2, 5, 2);
	    gbcSecaoField.gridx = 1;
	    gbcSecaoField.gridy = 1;
	    gbcSecaoField.fill = GridBagConstraints.HORIZONTAL;
	    gbcSecaoField.weightx = 1.0;
	    secaoField = new JTextField(30);
	    secaoField.setFont(fieldFont);
	    panel.add(secaoField, gbcSecaoField);

	    GridBagConstraints gbcVaraLabel = new GridBagConstraints();
	    gbcVaraLabel.insets = new Insets(5, 2, 5, 2);
	    gbcVaraLabel.gridx = 0;
	    gbcVaraLabel.gridy = 2;
	    gbcVaraLabel.anchor = GridBagConstraints.LINE_START;
	    JLabel label3 = new JLabel("Vara:");
	    label3.setFont(labelFont);
	    panel.add(label3, gbcVaraLabel);

	    GridBagConstraints varaField = new GridBagConstraints();
	    varaField.insets = new Insets(5, 2, 5, 2);
	    varaField.gridx = 1;
	    varaField.gridy = 2;
	    varaField.fill = GridBagConstraints.HORIZONTAL;
	    varaField.weightx = 1.0;
	    descricaoField = new JTextField(50);
	    descricaoField.setFont(fieldFont);
	    panel.add(descricaoField, varaField);

	    GridBagConstraints gbcCadastrarButton = new GridBagConstraints();
	    gbcCadastrarButton.insets = new Insets(10, 5, 10, 5);
	    gbcCadastrarButton.gridx = 1;
	    gbcCadastrarButton.gridy = 3;
	    gbcCadastrarButton.fill = GridBagConstraints.HORIZONTAL;
	    gbcCadastrarButton.anchor = GridBagConstraints.CENTER;
	    JButton cadastrarButton = new JButton("Cadastrar");
	    cadastrarButton.setFont(buttonFont);
	    panel.add(cadastrarButton, gbcCadastrarButton);

	    cadastrarButton.addActionListener(e -> realizarCadastro());

	    GridBagConstraints gbcListarButton = new GridBagConstraints();
	    gbcListarButton.insets = new Insets(10, 5, 10, 5);
	    gbcListarButton.gridx = 0;
	    gbcListarButton.gridy = 3;
	    gbcListarButton.anchor = GridBagConstraints.CENTER;
	    gbcListarButton.fill = GridBagConstraints.HORIZONTAL;
	    JButton listarButton = new JButton("Listar Tribunais");
	    listarButton.setFont(buttonFont);
	    panel.add(listarButton, gbcListarButton);

	    listarButton.addActionListener(e -> listaTribunais());

	    GridBagConstraints gbcScrollPane = new GridBagConstraints();
	    gbcScrollPane.insets = new Insets(10, 5, 10, 5);
	    gbcScrollPane.gridx = 0;
	    gbcScrollPane.gridy = 4;
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

	private void realizarCadastro() {
		try {
			String sigla = siglaField.getText();
			String secao = secaoField.getText();
			String descricao = descricaoField.getText();

			MainController.getTribunalController().addTribunal(sigla, secao, descricao);

			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

			limparCampos();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar o cadastro: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void listaTribunais() {
		try {
			textArea.setText(MainController.getTribunalController().listaTribunais().toString());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao listar os tribunais: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void limparCampos() {
		siglaField.setText("");
		secaoField.setText("");
		descricaoField.setText("");
	}
}
