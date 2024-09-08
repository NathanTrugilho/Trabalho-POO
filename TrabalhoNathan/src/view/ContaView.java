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
		setLocationRelativeTo(null); // Centraliza a janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas essa janela

		// Cria o JTabbedPane
		JTabbedPane tabbedPane = new JTabbedPane();

		// Adiciona as abas
		tabbedPane.addTab("Adicionar Despesa", criarAbaAdicionarDespesas());
		tabbedPane.addTab("Adicionar Pagamento", criarAbaAdicionarPagamentos());
		tabbedPane.addTab("Extrato", criarAbaExtrato());

		// Adiciona o JTabbedPane à janela
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		// Exibe a janela
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				// Habilita o botão gerenciarContaButton quando a janela for fechada
				gerenciarContaButton.setEnabled(true);
			}
		});
	}

	private JPanel criarAbaAdicionarDespesas() {
		JPanel abaAdicionarDespesas = new JPanel(new GridBagLayout());
		abaAdicionarDespesas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Definir fontes
		Font labelFont = new Font("Arial", Font.BOLD, 16);
		Font fieldFont = new Font("Arial", Font.PLAIN, 16);
		Font buttonFont = new Font("Arial", Font.BOLD, 16);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10); // Ajuste de espaçamento para maior espaço
		gbc.anchor = GridBagConstraints.LINE_START;

		// Label e campo de texto para a data da despesa
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel dataLabel = new JLabel("Data:");
		dataLabel.setFont(labelFont);
		abaAdicionarDespesas.add(dataLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL; // Expandir o campo para preencher horizontalmente
		JTextField dataField = new JTextField(15); // Aumentado o tamanho do campo
		dataField.setFont(fieldFont);
		abaAdicionarDespesas.add(dataField, gbc);

		dataField.setText("dd/MM/yyyy");

		// Label e campo de texto para a descrição da despesa (Text Area)
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1; // Resetando o gridwidth para uma largura normal
		JLabel descricaoLabel = new JLabel("Descrição:");
		descricaoLabel.setFont(labelFont);
		abaAdicionarDespesas.add(descricaoLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.BOTH; // Permitir que o campo se expanda em ambas as direções
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		JTextArea descricaoField = new JTextArea(5, 20); // TextArea com 5 linhas e 20 colunas
		descricaoField.setFont(fieldFont);
		descricaoField.setLineWrap(true); // Habilitar quebra de linha automática
		descricaoField.setWrapStyleWord(true); // Quebra de linha completa palavras
		JScrollPane scrollDescricao = new JScrollPane(descricaoField); // Adiciona barra de rolagem se o texto for maior
																		// que o campo
		abaAdicionarDespesas.add(scrollDescricao, gbc);

		// Label e campo de texto para o valor da despesa
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.weighty = 0; // Resetando o peso vertical
		JLabel valorLabel = new JLabel("Valor da Despesa:");
		valorLabel.setFont(labelFont);
		abaAdicionarDespesas.add(valorLabel, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL; // Expandir o campo para preencher horizontalmente
		JTextField valorField = new JTextField(15); // Aumentado o tamanho do campo
		valorField.setFont(fieldFont);
		abaAdicionarDespesas.add(valorField, gbc);

		// Botão para adicionar a despesa
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.NONE; // Resetando o preenchimento para o botão
		gbc.anchor = GridBagConstraints.CENTER; // Centralizando o botão
		JButton adicionarDespesaButton = new JButton("Criar Despesa");
		adicionarDespesaButton.setFont(buttonFont);
		abaAdicionarDespesas.add(adicionarDespesaButton, gbc);

		// Tratamento de erros e ação do botão
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

				// Adicionando despesa (ajustar lógica conforme necessário)
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

	// Método para limpar os campos após adicionar a despesa
	private void limparCamposDespesa(JTextField dataField, JTextArea descricaoField, JTextField valorField) {
		dataField.setText("dd/MM/yyyy");
		descricaoField.setText("");
		valorField.setText("");
	}

	// Método para criar a aba de "Adicionar Pagamento"
	private JPanel criarAbaAdicionarPagamentos() {
		JPanel abaAdicionarPagamentos = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.LINE_START;

		// Definir fontes
		Font labelFont = new Font("Arial", Font.BOLD, 16);
		Font fieldFont = new Font("Arial", Font.PLAIN, 16);
		Font buttonFont = new Font("Arial", Font.BOLD, 16);

		// Label e campo de texto para a data do pagamento
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

		// Label e comboBox para a forma de pagamento
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

		// Label e campo de texto para o valor do pagamento
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

		// Botão para adicionar o pagamento
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

	// Método para limpar os campos após adicionar o pagamento
	private void limparCamposPagamento(JTextField dataField, JComboBox<EFormaPagamento> formaPagamentoComboBox,
			JTextField valorField) {
		dataField.setText("dd/MM/yyyy");
		formaPagamentoComboBox.setSelectedIndex(0);
		valorField.setText("");
	}

	// Método para criar a aba de "Extrato"
	private JPanel criarAbaExtrato() {
	    JPanel panel = new JPanel(new BorderLayout());

	    // Criação do botão "Gerar Extrato"
	    JButton gerarExtratoButton = new JButton("Gerar Extrato");
	    gerarExtratoButton.setFont(new Font("Arial", Font.BOLD, 16));
	    panel.add(gerarExtratoButton, BorderLayout.NORTH); // Adiciona o botão no topo (Norte)

	    // Criação da área de texto para mostrar o extrato
	    JTextArea extratoTextArea = new JTextArea(10, 30); // Exemplo de 10 linhas e 30 colunas
	    extratoTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
	    extratoTextArea.setEditable(false); // Torna a área de texto não-editável
	    extratoTextArea.setLineWrap(true); // Habilita quebra de linha
	    extratoTextArea.setWrapStyleWord(true); // Quebra completa palavras
	    JScrollPane scrollPane = new JScrollPane(extratoTextArea); // Adiciona barra de rolagem

	    panel.add(scrollPane, BorderLayout.CENTER); // Adiciona a área de texto com rolagem no centro

	    // Ação do botão "Gerar Extrato"
	    gerarExtratoButton.addActionListener(e -> {
	        extratoTextArea.setText("");

	        // Formatação com duas casas decimais
	        double totalCustas = processo.getTotalCustas();
	        double totalPagamentos = processo.getConta().getTotalPagamentos();
	        double saldoConta = processo.getConta().getSaldoConta();

	        // Exibe os valores com duas casas decimais e o saldo com sinal
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
