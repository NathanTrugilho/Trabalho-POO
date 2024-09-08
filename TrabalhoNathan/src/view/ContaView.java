package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.MainController;
import model.EFormaPagamento;
import model.Processo;
import util.Utils;

public class ContaView extends JFrame {

	private static final long serialVersionUID = -2346269622080022249L;

	private JButton gerenciarContaButton;
	private Processo processo;

	public ContaView(JButton gerenciarContaButton, Processo processoSelecionado) {
		this.gerenciarContaButton = gerenciarContaButton;
		this.processo = processoSelecionado;
		initialize();
	}

	private void initialize() {

		setTitle("Gerenciar Conta");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.addTab("Adicionar Despesa", criarAbaAdicionarDespesas());
		tabbedPane.addTab("Adicionar Pagamento", criarAbaAdicionarPagamentos());
		tabbedPane.addTab("Extrato", criarAbaExtrato());

		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				gerenciarContaButton.setEnabled(true);
			}
		});
	}

	private JPanel criarAbaAdicionarDespesas() {
		JPanel abaAdicionarDespesas = new JPanel(new GridBagLayout());
		abaAdicionarDespesas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		Font labelFont = new Font("Arial", Font.BOLD, 16);
		Font fieldFont = new Font("Arial", Font.PLAIN, 16);
		Font buttonFont = new Font("Arial", Font.BOLD, 16);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10); 
		gbc.anchor = GridBagConstraints.LINE_START;

		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel dataLabel = new JLabel("Data:");
		dataLabel.setFont(labelFont);
		abaAdicionarDespesas.add(dataLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		JTextField dataField = new JTextField(15); 
		dataField.setFont(fieldFont);
		abaAdicionarDespesas.add(dataField, gbc);

		dataField.setText("dd/MM/yyyy");

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1; 
		JLabel descricaoLabel = new JLabel("Descrição:");
		descricaoLabel.setFont(labelFont);
		abaAdicionarDespesas.add(descricaoLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		JTextArea descricaoField = new JTextArea(5, 20);
		descricaoField.setFont(fieldFont);
		descricaoField.setLineWrap(true); 
		descricaoField.setWrapStyleWord(true); 
		JScrollPane scrollDescricao = new JScrollPane(descricaoField);
																		
		abaAdicionarDespesas.add(scrollDescricao, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.weighty = 0; 
		JLabel valorLabel = new JLabel("Valor da Despesa:");
		valorLabel.setFont(labelFont);
		abaAdicionarDespesas.add(valorLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		JTextField valorField = new JTextField(15);
		valorField.setFont(fieldFont);
		abaAdicionarDespesas.add(valorField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER; 
		JButton adicionarDespesaButton = new JButton("Criar Despesa");
		adicionarDespesaButton.setFont(buttonFont);
		abaAdicionarDespesas.add(adicionarDespesaButton, gbc);

		adicionarDespesaButton.addActionListener(e -> {
			String data = dataField.getText();
			String descricao = descricaoField.getText();
			String valor = valorField.getText().replace(",", ".");

			try {
				if (descricao.isBlank()) {
					JOptionPane.showMessageDialog(null, "Insira uma descrição válida!", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (valor.isBlank() || !valor.matches("\\d+(\\.\\d{1,2})?")) {
					JOptionPane.showMessageDialog(null, "Insira um valor válido!", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				MainController.getContaController().addDespesa(processo.getConta(), Utils.stringToDate(data), descricao,
						Double.parseDouble(valor));

				JOptionPane.showMessageDialog(null, "Despesa criada com sucesso!");

				limparCamposDespesa(dataField, descricaoField, valorField);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao criar despesa: " + ex.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		return abaAdicionarDespesas;
	}

	private void limparCamposDespesa(JTextField dataField, JTextArea descricaoField, JTextField valorField) {
		dataField.setText("dd/MM/yyyy");
		descricaoField.setText("");
		valorField.setText("");
	}

	private JPanel criarAbaAdicionarPagamentos() {
		JPanel abaAdicionarPagamentos = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.LINE_START;

		Font labelFont = new Font("Arial", Font.BOLD, 16);
		Font fieldFont = new Font("Arial", Font.PLAIN, 16);
		Font buttonFont = new Font("Arial", Font.BOLD, 16);

		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel dataLabel = new JLabel("Data do Pagamento:");
		dataLabel.setFont(labelFont);
		abaAdicionarPagamentos.add(dataLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField dataField = new JTextField(15);
		dataField.setFont(fieldFont);
		dataField.setText("dd/MM/yyyy");
		abaAdicionarPagamentos.add(dataField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel formaPagamentoLabel = new JLabel("Forma de Pagamento:");
		formaPagamentoLabel.setFont(labelFont);
		abaAdicionarPagamentos.add(formaPagamentoLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JComboBox<EFormaPagamento> formaPagamentoComboBox = new JComboBox<>(EFormaPagamento.values());
		formaPagamentoComboBox.setFont(fieldFont);
		abaAdicionarPagamentos.add(formaPagamentoComboBox, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel valorLabel = new JLabel("Valor do Pagamento:");
		valorLabel.setFont(labelFont);
		abaAdicionarPagamentos.add(valorLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField valorField = new JTextField(15);
		valorField.setFont(fieldFont);
		abaAdicionarPagamentos.add(valorField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		JButton adicionarPagamentoButton = new JButton("Adicionar Pagamento");
		adicionarPagamentoButton.setFont(buttonFont);
		abaAdicionarPagamentos.add(adicionarPagamentoButton, gbc);

		adicionarPagamentoButton.addActionListener(e -> {

			String data = dataField.getText();
			EFormaPagamento formaPagamento = (EFormaPagamento) formaPagamentoComboBox.getSelectedItem();
			String valor = valorField.getText().replace(",", ".");

			try {

				if (valor.isBlank() || !valor.matches("\\d+(\\.\\d{1,2})?")) {
					JOptionPane.showMessageDialog(null, "Insira um valor válido!", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				MainController.getContaController().addPagamento(processo.getConta(), formaPagamento,
						Utils.stringToDate(data), Double.parseDouble(valor));

				JOptionPane.showMessageDialog(null, "Pagamento realizado com sucesso!");

				limparCamposPagamento(dataField, formaPagamentoComboBox, valorField);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao adicionar pagamento: " + ex.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		return abaAdicionarPagamentos;
	}

	private void limparCamposPagamento(JTextField dataField, JComboBox<EFormaPagamento> formaPagamentoComboBox,
			JTextField valorField) {
		dataField.setText("dd/MM/yyyy");
		formaPagamentoComboBox.setSelectedIndex(0);
		valorField.setText("");
	}

	private JPanel criarAbaExtrato() {
	    JPanel panel = new JPanel(new BorderLayout());

	    JButton gerarExtratoButton = new JButton("Gerar Extrato");
	    gerarExtratoButton.setFont(new Font("Arial", Font.BOLD, 16));
	    panel.add(gerarExtratoButton, BorderLayout.NORTH); 

	    JTextArea extratoTextArea = new JTextArea(10, 30); 
	    extratoTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
	    extratoTextArea.setEditable(false); 
	    extratoTextArea.setLineWrap(true); 
	    extratoTextArea.setWrapStyleWord(true); 
	    JScrollPane scrollPane = new JScrollPane(extratoTextArea); 

	    panel.add(scrollPane, BorderLayout.CENTER); 

	    gerarExtratoButton.addActionListener(e -> {
	        extratoTextArea.setText("");

	        double totalCustas = processo.getTotalCustas();
	        double totalPagamentos = processo.getConta().getTotalPagamentos();
	        double saldoConta = processo.getConta().getSaldoConta();

	        StringBuilder sb = processo.getExtratoContas();
	        sb.append("====================\n");
	        sb.append(String.format("Total custas: %.2f reais\n", totalCustas));
	        sb.append(String.format("Total pagamentos: %.2f reais\n", totalPagamentos));
	        sb.append(String.format("Total saldo: %+.2f reais\n", saldoConta)); 

	        extratoTextArea.setText(sb.toString());
	    });

	    return panel;
	}

}
