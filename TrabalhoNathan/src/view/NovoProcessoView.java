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
import exception.ClienteNaoExisteException;
import util.Utils;

public class NovoProcessoView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField cadastroRFClienteField;
	private JTextField cadastroRFParteContrariaField;
	private JTextField dataAberturaField;
	private JTextField numeroProcessoField;
	private JTextField tribunalField;
	private JTextArea textArea;

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

		// Definir fontes
		Font labelFont = new Font("Arial", Font.BOLD, 16);
		Font fieldFont = new Font("Arial", Font.PLAIN, 16);
		Font buttonFont = new Font("Arial", Font.BOLD, 16);

		// Número do Processo
		GridBagConstraints gbcLabelNumeroProcesso = new GridBagConstraints();
		gbcLabelNumeroProcesso.insets = new Insets(5, 2, 5, 2);
		gbcLabelNumeroProcesso.gridx = 0;
		gbcLabelNumeroProcesso.gridy = 0;
		gbcLabelNumeroProcesso.anchor = GridBagConstraints.LINE_START;
		JLabel label1 = new JLabel("Número Processo:");
		label1.setFont(labelFont);
		panel.add(label1, gbcLabelNumeroProcesso);

		GridBagConstraints gbcFieldNumeroProcesso = new GridBagConstraints();
		gbcFieldNumeroProcesso.insets = new Insets(5, 2, 5, 2);
		gbcFieldNumeroProcesso.gridx = 1;
		gbcFieldNumeroProcesso.gridy = 0;
		gbcFieldNumeroProcesso.fill = GridBagConstraints.HORIZONTAL;
		numeroProcessoField = new JTextField(25);
		numeroProcessoField.setFont(fieldFont);
		panel.add(numeroProcessoField, gbcFieldNumeroProcesso);

		// Data de Abertura
		GridBagConstraints gbcLabelDataAbertura = new GridBagConstraints();
		gbcLabelDataAbertura.insets = new Insets(5, 2, 5, 2);
		gbcLabelDataAbertura.gridx = 0;
		gbcLabelDataAbertura.gridy = 1;
		gbcLabelDataAbertura.anchor = GridBagConstraints.LINE_START;
		JLabel label2 = new JLabel("Data Abertura:");
		label2.setFont(labelFont);
		panel.add(label2, gbcLabelDataAbertura);

		GridBagConstraints gbcFieldDataAbertura = new GridBagConstraints();
		gbcFieldDataAbertura.insets = new Insets(5, 2, 5, 2);
		gbcFieldDataAbertura.gridx = 1;
		gbcFieldDataAbertura.gridy = 1;
		gbcFieldDataAbertura.fill = GridBagConstraints.HORIZONTAL;
		dataAberturaField = new JTextField(10);
		dataAberturaField.setFont(fieldFont);
		dataAberturaField.setText("dd/MM/yyyy");
		panel.add(dataAberturaField, gbcFieldDataAbertura);

		// CPF Cliente
		GridBagConstraints gbcLabelCadastroRFCliente = new GridBagConstraints();
		gbcLabelCadastroRFCliente.insets = new Insets(5, 2, 5, 2);
		gbcLabelCadastroRFCliente.gridx = 0;
		gbcLabelCadastroRFCliente.gridy = 2;
		gbcLabelCadastroRFCliente.anchor = GridBagConstraints.LINE_START;
		JLabel label3 = new JLabel("CadastroRF Cliente:");
		label3.setFont(labelFont);
		panel.add(label3, gbcLabelCadastroRFCliente);

		GridBagConstraints gbcFieldCadastroRFCliente = new GridBagConstraints();
		gbcFieldCadastroRFCliente.insets = new Insets(5, 2, 5, 2);
		gbcFieldCadastroRFCliente.gridx = 1;
		gbcFieldCadastroRFCliente.gridy = 2;
		gbcFieldCadastroRFCliente.fill = GridBagConstraints.HORIZONTAL;
		cadastroRFClienteField = new JTextField(25);
		cadastroRFClienteField.setFont(fieldFont);
		panel.add(cadastroRFClienteField, gbcFieldCadastroRFCliente);

		// CPF Parte Contrária
		GridBagConstraints gbcLabelCadastroRFParteContraria = new GridBagConstraints();
		gbcLabelCadastroRFParteContraria.insets = new Insets(5, 2, 5, 2);
		gbcLabelCadastroRFParteContraria.gridx = 0;
		gbcLabelCadastroRFParteContraria.gridy = 3;
		gbcLabelCadastroRFParteContraria.anchor = GridBagConstraints.LINE_START;
		JLabel label4 = new JLabel("CadastroRF Parte Contrária:");
		label4.setFont(labelFont);
		panel.add(label4, gbcLabelCadastroRFParteContraria);

		GridBagConstraints gbcFieldCadastroRFParteContraria = new GridBagConstraints();
		gbcFieldCadastroRFParteContraria.insets = new Insets(5, 2, 5, 2);
		gbcFieldCadastroRFParteContraria.gridx = 1;
		gbcFieldCadastroRFParteContraria.gridy = 3;
		gbcFieldCadastroRFParteContraria.fill = GridBagConstraints.HORIZONTAL;
		cadastroRFParteContrariaField = new JTextField(25);
		cadastroRFParteContrariaField.setFont(fieldFont);
		panel.add(cadastroRFParteContrariaField, gbcFieldCadastroRFParteContraria);

		// Tribunal
		GridBagConstraints gbcLabelTribunal = new GridBagConstraints();
		gbcLabelTribunal.insets = new Insets(5, 2, 5, 2);
		gbcLabelTribunal.gridx = 0;
		gbcLabelTribunal.gridy = 4;
		gbcLabelTribunal.anchor = GridBagConstraints.LINE_START;
		JLabel label5 = new JLabel("Sigla Tribunal:");
		label5.setFont(labelFont);
		panel.add(label5, gbcLabelTribunal);

		GridBagConstraints gbcFieldTribunal = new GridBagConstraints();
		gbcFieldTribunal.insets = new Insets(5, 2, 5, 2);
		gbcFieldTribunal.gridx = 1;
		gbcFieldTribunal.gridy = 4;
		gbcFieldTribunal.fill = GridBagConstraints.HORIZONTAL;
		tribunalField = new JTextField(25);
		tribunalField.setFont(fieldFont);
		panel.add(tribunalField, gbcFieldTribunal);

		// Botão Confirmar Cadastro
		GridBagConstraints gbcCadastrarButton = new GridBagConstraints();
		gbcCadastrarButton.insets = new Insets(10, 5, 10, 5);
		gbcCadastrarButton.gridx = 1;
		gbcCadastrarButton.gridy = 5;
		gbcCadastrarButton.anchor = GridBagConstraints.CENTER;
		gbcCadastrarButton.fill = GridBagConstraints.HORIZONTAL;
		
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setFont(buttonFont);
		panel.add(cadastrarButton, gbcCadastrarButton);

		cadastrarButton.addActionListener(e -> realizarCadastro());

		// Botão Listar Processos
		GridBagConstraints gbcListarButton = new GridBagConstraints();
		gbcListarButton.insets = new Insets(10, 5, 10, 5);
		gbcListarButton.gridx = 0;
		gbcListarButton.gridy = 5;
		gbcListarButton.anchor = GridBagConstraints.CENTER;
		gbcListarButton.fill = GridBagConstraints.HORIZONTAL;
		
		JButton listarButton = new JButton("Listar Processos");
		listarButton.setFont(buttonFont);
		panel.add(listarButton, gbcListarButton);

		listarButton.addActionListener(e -> listaProcessos());

		// Área de texto para exibir os processos
		GridBagConstraints gbcScrollPane = new GridBagConstraints();
		gbcScrollPane.insets = new Insets(10, 5, 10, 5);
		gbcScrollPane.gridx = 0;
		gbcScrollPane.gridy = 6;
		gbcScrollPane.gridwidth = 2;
		gbcScrollPane.fill = GridBagConstraints.BOTH;
		gbcScrollPane.weightx = 1.0;
		gbcScrollPane.weighty = 1.0;
		textArea = new JTextArea(10, 40);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane, gbcScrollPane);

		// Adiciona o painel ao JFrame
		getContentPane().add(panel);
	}

	private void realizarCadastro() {

		String numeroProcesso = numeroProcessoField.getText();
		String dataAbertura = dataAberturaField.getText();
		String cadastroRFCliente = cadastroRFClienteField.getText();
		String cadastroRFParteContraria = cadastroRFParteContrariaField.getText();
		String siglaTribunal = tribunalField.getText();

		try {
			if (numeroProcesso.isBlank() || !numeroProcesso.matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "Insira o número do processo corretamente!", "Erro de Entrada",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (cadastroRFCliente.isBlank() || !cadastroRFCliente.matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "Insira o CadastroRF do Cliente corretamente!", "Erro de Entrada",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (cadastroRFCliente.length() != 11 && cadastroRFCliente.length() != 14) {
				JOptionPane.showMessageDialog(null, "Insira o CadastroRF do Cliente corretamente!", "Erro de Entrada",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (cadastroRFCliente.length() == 11) {
				Utils.validarCPF(Long.parseLong(cadastroRFCliente));
			} else {
				Utils.validarCNPJ(Long.parseLong(cadastroRFCliente));
			}

			if (cadastroRFParteContraria.isBlank() || !cadastroRFParteContraria.matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "Insira o CadastroRF da parte contrária corretamente!",
						"Erro de Entrada", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (cadastroRFParteContraria.length() != 11 && cadastroRFParteContraria.length() != 14) {
				JOptionPane.showMessageDialog(null, "Insira o CadastroRF da parte contrária corretamente!",
						"Erro de Entrada", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (cadastroRFCliente.equals(cadastroRFParteContraria)) {
				JOptionPane.showMessageDialog(null, "Uma pessoa não pode se processar!", "Erro de Entrada",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (cadastroRFParteContraria.length() == 11) {
				Utils.validarCPF(Long.parseLong(cadastroRFParteContraria));
			} else {
				Utils.validarCNPJ(Long.parseLong(cadastroRFParteContraria));
			}

			if (siglaTribunal.isBlank()) {
				JOptionPane.showMessageDialog(null, "Insira a sigla do tribunal!", "Erro de Entrada",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			MainController.getTribunalController().verificaTribunalExistente(siglaTribunal);

			MainController.getProcessoController().addProcesso(Long.parseLong(numeroProcesso),
					Utils.stringToDate(dataAbertura),
					MainController.getClienteController().getCliente(Long.parseLong(cadastroRFCliente)),
					MainController.getPessoaController().getPessoa(Long.parseLong(cadastroRFParteContraria)),
					MainController.getTribunalController().getTribunal(siglaTribunal));

			JOptionPane.showMessageDialog(null, "Processo realizado com sucesso!");
			limparCampos();
			return;

			// Entra se não existir um cliente com o cadastroRF passado
		} catch (ClienteNaoExisteException e) {

			int resposta = JOptionPane.showConfirmDialog(null, "Você deseja criar um cliente para este cadastroRF?",
					"Cliente não existente!", JOptionPane.YES_NO_OPTION);

			try {
				if (resposta == JOptionPane.YES_OPTION) {
					MainController.getClienteController().addCliente(Long.parseLong(cadastroRFCliente));

					MainController.getProcessoController().addProcesso(Long.parseLong(numeroProcesso),
							Utils.stringToDate(dataAbertura),
							MainController.getClienteController().getCliente(Long.parseLong(cadastroRFCliente)),
							MainController.getPessoaController().getPessoa(Long.parseLong(cadastroRFParteContraria)),
							MainController.getTribunalController().getTribunal(siglaTribunal));

					JOptionPane.showMessageDialog(null, "Processo realizado com sucesso!");
					limparCampos();
					return;
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void listaProcessos() {
		try {
			textArea.setText(MainController.getProcessoController().listaProcessos().toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao listar os processos: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void limparCampos() {
		cadastroRFClienteField.setText("");
		cadastroRFParteContrariaField.setText("");
		dataAberturaField.setText("dd/MM/yyyy");
		numeroProcessoField.setText("");
		tribunalField.setText("");
	}
}
