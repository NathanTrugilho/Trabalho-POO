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
		dataAberturaField = new JTextField(10);
		dataAberturaField.setFont(fieldFont);
		panel.add(dataAberturaField, gbc);
		dataAberturaField.setText("dd/MM/yyyy");

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
		
		// Botão Listar Processos
        gbc.gridx = 0;
        gbc.gridy = 5;
        JButton listarButton = new JButton("Listar Processos");
        listarButton.setFont(buttonFont);
        panel.add(listarButton, gbc);

        listarButton.addActionListener(e -> listaProcessos());

        // Área de texto para exibir os processos
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2; // Faz com que a área de texto ocupe toda a largura disponível
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;

        textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, gbc);
		
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

			if(cadastroRFCliente.equals(cadastroRFParteContraria)) {
				JOptionPane.showMessageDialog(null, "Uma pessoa não pode se processar!",
						"Erro de Entrada", JOptionPane.ERROR_MESSAGE);
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
