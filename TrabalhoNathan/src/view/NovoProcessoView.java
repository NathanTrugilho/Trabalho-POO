package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MainController;
import exception.ClienteNaoExisteException;

public class NovoProcessoView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField cadastroRFClienteField;
	private JTextField cadastroRFParteContrariaField;
	private JTextField dataAberturaField;
	private JTextField numeroProcessoField;
	private JTextField tribunalField;

	public NovoProcessoView() {
		initialize();
	}

	private void initialize() {
		setTitle("Cadastro de Processo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 2, 5, 2);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;

		Font labelFont = new Font("Arial", Font.BOLD, 16);
		Font fieldFont = new Font("Arial", Font.PLAIN, 16);
		Font buttonFont = new Font("Arial", Font.BOLD, 16);

		// Número do Processo
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel label1 = new JLabel("Número Processo:");
		label1.setFont(labelFont);
		panel.add(label1, gbc);

		gbc.gridx = 1;
		numeroProcessoField = new JTextField(25);
		numeroProcessoField.setFont(fieldFont);
		panel.add(numeroProcessoField, gbc);

		// Data Abertura
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel label2 = new JLabel("Data Abertura:");
		label2.setFont(labelFont);
		panel.add(label2, gbc);

		gbc.gridx = 1;
		dataAberturaField = new JTextField(25);
		dataAberturaField.setFont(fieldFont);
		panel.add(dataAberturaField, gbc);

		// CPF Cliente
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel label3 = new JLabel("CadastroRF Cliente:");
		label3.setFont(labelFont);
		panel.add(label3, gbc);

		gbc.gridx = 1;
		cadastroRFClienteField = new JTextField(25);
		cadastroRFClienteField.setFont(fieldFont);
		panel.add(cadastroRFClienteField, gbc);

		// CPF Parte Contrária
		gbc.gridx = 0;
		gbc.gridy = 3;
		JLabel label4 = new JLabel("CadastroRF Parte Contrária:");
		label4.setFont(labelFont);
		panel.add(label4, gbc);

		gbc.gridx = 1;
		cadastroRFParteContrariaField = new JTextField(25);
		cadastroRFParteContrariaField.setFont(fieldFont);
		panel.add(cadastroRFParteContrariaField, gbc);

		// Tribunal
		gbc.gridx = 0;
		gbc.gridy = 4;
		JLabel label5 = new JLabel("Sigla Tribunal:");
		label5.setFont(labelFont);
		panel.add(label5, gbc);

		gbc.gridx = 1;
		tribunalField = new JTextField(25);
		tribunalField.setFont(fieldFont);
		panel.add(tribunalField, gbc);

		// Botão Confirmar Cadastro
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setFont(buttonFont);
		panel.add(cadastrarButton, gbc);

		cadastrarButton.addActionListener(e -> realizarCadastro());

		// Adiciona o painel ao JFrame
		getContentPane().add(panel);
	}

	private void realizarCadastro() {
		try {
			String numeroProcesso = numeroProcessoField.getText();
			String dataAbertura = dataAberturaField.getText();
			String cadastroRFCliente = cadastroRFClienteField.getText();
			String cadastroRFParteContraria = cadastroRFParteContrariaField.getText();
			String siglaTribunal = tribunalField.getText();

			if (cadastroRFCliente.isBlank() || !cadastroRFCliente.matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "Insira o CadastroRF do Cliente corretamente!", "Erro de Entrada",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (cadastroRFCliente.length() == 11) {

				try {
					if (cadastroRFParteContraria.length() == 11) {
						System.out.println("chegou1");
						MainController.getProcessoController().addProcesso(Long.parseLong(numeroProcesso), null,
								MainController.getClienteController().getClientePF(Long.parseLong(cadastroRFCliente)),
								MainController.getPessoaController()
										.getPessoaFisica(Long.parseLong(cadastroRFParteContraria)),
								MainController.getTribunalController().getTribunal(siglaTribunal));
						System.out.println("chegou2");
					} else if (cadastroRFParteContraria.length() == 14) {

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (cadastroRFCliente.length() == 14) {

			} else {
				JOptionPane.showMessageDialog(null, "Insira o CNPJ ou CPF do Cliente!", "Erro de entrada",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			JOptionPane.showMessageDialog(null, "Cadastro de processo realizado com sucesso!");
			limparCampos();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar o cadastro: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void limparCampos() {
		cadastroRFClienteField.setText("");
		cadastroRFParteContrariaField.setText("");
		dataAberturaField.setText("");
		numeroProcessoField.setText("");
		tribunalField.setText("");
	}
}
