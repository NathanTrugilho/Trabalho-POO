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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.MainController;
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
			String valor = valorField.getText();

			try {
				if (descricao.isBlank()) {
					JOptionPane.showMessageDialog(null, "Insira uma descrição válida!", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (valor.isBlank() || !valor.matches("\\d+(\\.\\d{2})?")) {
					JOptionPane.showMessageDialog(null, "Insira um valor válido!", "Erro de Entrada",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Adicionando despesa (ajustar lógica conforme necessário)
				MainController.getContaController().addDespesa(processo.getConta(), Utils.stringToDate(data), descricao,
						Long.parseLong(valor));

				limparCampos(dataField, descricaoField, valorField);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao adicionar despesa: " + ex.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		return abaAdicionarDespesas;
	}

	// Método para limpar os campos após adicionar a despesa
	private void limparCampos(JTextField dataField, JTextArea descricaoField, JTextField valorField) {
		dataField.setText("dd/MM/yyyy");
		descricaoField.setText("");
		valorField.setText("");
	}

	// Método para criar a aba de "Adicionar Pagamento"
	private JPanel criarAbaAdicionarPagamentos() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Label e campo de texto para o valor do pagamento
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Valor do Pagamento:"), gbc);

		gbc.gridx = 1;
		JTextField valorPagamentoField = new JTextField(20);
		panel.add(valorPagamentoField, gbc);

		// Botão para adicionar o pagamento
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		JButton adicionarPagamentoButton = new JButton("Adicionar Pagamento");
		panel.add(adicionarPagamentoButton, gbc);

		// Exemplo de ação do botão (apenas uma mensagem, você pode alterar a lógica)
		adicionarPagamentoButton.addActionListener(e -> {
			String valorPagamento = valorPagamentoField.getText();
			System.out.println("Pagamento adicionado: " + valorPagamento);
			valorPagamentoField.setText(""); // Limpa o campo após adicionar
		});

		return panel;
	}

	// Método para criar a aba de "Extrato"
	private JPanel criarAbaExtrato() {
		JPanel panel = new JPanel(new BorderLayout());

		// Exemplo de extrato (você pode alterar para uma lógica real)
		JLabel extratoLabel = new JLabel("Extrato de despesas e pagamentos aparecerá aqui.");
		panel.add(extratoLabel, BorderLayout.CENTER);

		return panel;
	}
}
