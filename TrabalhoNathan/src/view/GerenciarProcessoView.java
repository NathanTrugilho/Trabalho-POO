package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MainController;
import exception.ClienteNaoExisteException;
import model.Processo;
import util.Utils;

public class GerenciarProcessoView extends JFrame {

	private static final long serialVersionUID = 6883104333378305544L;

	// Componentes da parte esquerda
	private JTextField cadastroRFField;
	private JPanel botoesPanel;
	private JLabel cadastroRFLabel;
	private JLabel numeroProcessoLabel;
	private JButton listarProcessosButton;
	private JComboBox<Processo> comboBoxProcessos;

	// Botões da parte direita
	private JButton gerenciarAudienciasButton;
	private JButton gerenciarContaButton;
	private JButton botao3;
	private JButton botao4;

	public GerenciarProcessoView() {
		initialize();
	}

	private void initialize() {

		setTitle("Gerenciar Processo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null); // Centraliza a janela

		// Layout da janela
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[] { 0, 32, 105 };
		JPanel panel = new JPanel(gbl_panel);

		// Fonte para os campos e botões
		Font fieldFont = new Font("Arial", Font.PLAIN, 15);
		Font buttonFont = new Font("Arial", Font.BOLD, 16);
		Font labelFont = new Font("Arial", Font.BOLD, 16);

		// GridBagConstraints para cada componente
		GridBagConstraints gbcCadastroRFLabel = new GridBagConstraints();
		gbcCadastroRFLabel.insets = new Insets(10, 10, 10, 10);
		gbcCadastroRFLabel.gridx = 0;
		gbcCadastroRFLabel.gridy = 0;
		gbcCadastroRFLabel.anchor = GridBagConstraints.LINE_START;
		cadastroRFLabel = new JLabel("CadastroRF:");
		cadastroRFLabel.setFont(labelFont); // Definindo a fonte do label
		panel.add(cadastroRFLabel, gbcCadastroRFLabel);

		GridBagConstraints gbcCadastroRFField = new GridBagConstraints();
		gbcCadastroRFField.insets = new Insets(10, 10, 10, 10);
		gbcCadastroRFField.gridx = 1;
		gbcCadastroRFField.gridy = 0;
		gbcCadastroRFField.gridwidth = 2; // O campo de texto ocupa duas colunas
		gbcCadastroRFField.fill = GridBagConstraints.HORIZONTAL;
		gbcCadastroRFField.weightx = 1.0;
		cadastroRFField = new JTextField(20);
		cadastroRFField.setFont(fieldFont);
		panel.add(cadastroRFField, gbcCadastroRFField);

		GridBagConstraints gbcPesquisarButton = new GridBagConstraints();
		gbcPesquisarButton.insets = new Insets(10, 10, 10, 10);
		gbcPesquisarButton.gridx = 3;
		gbcPesquisarButton.gridy = 0;
		gbcPesquisarButton.fill = GridBagConstraints.BOTH;
		gbcPesquisarButton.weightx = 0; // Não expande horizontalmente
		gbcPesquisarButton.anchor = GridBagConstraints.CENTER;
		listarProcessosButton = new JButton("Listar Processos");
		listarProcessosButton.setFont(buttonFont);
		panel.add(listarProcessosButton, gbcPesquisarButton);

		listarProcessosButton.addActionListener(e -> listarProcessos());

		GridBagConstraints gbcNumeroProcessoLabel = new GridBagConstraints();
		gbcNumeroProcessoLabel.weightx = 1.0;
		gbcNumeroProcessoLabel.insets = new Insets(5, 0, 0, 90); //
		gbcNumeroProcessoLabel.gridx = 1;
		gbcNumeroProcessoLabel.gridy = 1;
		numeroProcessoLabel = new JLabel("Lista de Processos");
		numeroProcessoLabel.setFont(labelFont);
		panel.add(numeroProcessoLabel, gbcNumeroProcessoLabel);

		GridBagConstraints gbcComboBox = new GridBagConstraints();
		gbcComboBox.anchor = GridBagConstraints.NORTH;
		gbcComboBox.insets = new Insets(10, 10, 10, 10); //
		gbcComboBox.gridx = 0;
		gbcComboBox.gridy = 2; // A comboBox foi mantida na linha 2
		gbcComboBox.gridwidth = 3; // O comboBox ocupa três colunas
		gbcComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbcComboBox.weightx = 1.0; // Permite expansão horizontal
		comboBoxProcessos = new JComboBox<>();
		comboBoxProcessos.setFont(fieldFont);
		panel.add(comboBoxProcessos, gbcComboBox);

		// GridBagConstraints para o painel de botões
		GridBagConstraints gbcBotoesPanel = new GridBagConstraints();
		gbcBotoesPanel.insets = new Insets(10, 5, 10, 5);
		gbcBotoesPanel.gridx = 3;
		gbcBotoesPanel.gridy = 1;
		gbcBotoesPanel.gridwidth = 1;
		gbcBotoesPanel.gridheight = 2;
		gbcBotoesPanel.fill = GridBagConstraints.BOTH;
		gbcBotoesPanel.weightx = 0; // Não expande horizontalmente
		gbcBotoesPanel.weighty = 1.0; // Expande verticalmente
		gbcBotoesPanel.anchor = GridBagConstraints.CENTER;
		botoesPanel = new JPanel(new GridBagLayout());

		// GridBagConstraints para cada botão
		GridBagConstraints gbcBotao1 = new GridBagConstraints();
		gbcBotao1.insets = new Insets(10, 5, 15, 5);
		gbcBotao1.gridx = 0;
		gbcBotao1.gridy = 0;
		gbcBotao1.fill = GridBagConstraints.HORIZONTAL;
		gerenciarAudienciasButton = new JButton("Gerenciar audiências");
		gerenciarAudienciasButton.setFont(buttonFont);
		botoesPanel.add(gerenciarAudienciasButton, gbcBotao1);
		gerenciarAudienciasButton.setEnabled(false);

		gerenciarAudienciasButton.addActionListener(e -> gerenciarAudiencias());

		GridBagConstraints gbcBotao2 = new GridBagConstraints();
		gbcBotao2.insets = new Insets(10, 5, 15, 5);
		gbcBotao2.gridx = 0;
		gbcBotao2.gridy = 1;
		gbcBotao2.fill = GridBagConstraints.HORIZONTAL;
		gerenciarContaButton = new JButton("Gerenciar conta");
		gerenciarContaButton.setFont(buttonFont);
		botoesPanel.add(gerenciarContaButton, gbcBotao2);
		gerenciarContaButton.setEnabled(false);
		
		gerenciarContaButton.addActionListener(e -> gerenciarContas());
		
		GridBagConstraints gbcBotao3 = new GridBagConstraints();
		gbcBotao3.insets = new Insets(10, 5, 15, 5);
		gbcBotao3.gridx = 0;
		gbcBotao3.gridy = 2;
		gbcBotao3.fill = GridBagConstraints.HORIZONTAL;
		botao3 = new JButton("Botão 3");
		botao3.setFont(buttonFont);
		botoesPanel.add(botao3, gbcBotao3);

		GridBagConstraints gbcBotao4 = new GridBagConstraints();
		gbcBotao4.insets = new Insets(10, 5, 15, 5);
		gbcBotao4.gridx = 0;
		gbcBotao4.gridy = 3;
		gbcBotao4.fill = GridBagConstraints.HORIZONTAL;
		botao4 = new JButton("Botão 4");
		botao4.setFont(buttonFont);
		botoesPanel.add(botao4, gbcBotao4);

		panel.add(botoesPanel, gbcBotoesPanel);

		// Adiciona o painel ao JFrame
		getContentPane().add(panel);
	}

	 private void gerenciarContas() {
	        Processo processoSelecionado;
	        try {
	            processoSelecionado = (Processo) comboBoxProcessos.getSelectedItem();
	            
	            gerenciarContaButton.setEnabled(false);
	            
	            new ContaView(gerenciarContaButton, processoSelecionado);
	            
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	
	private void gerenciarAudiencias() {
		Processo processoSelecionado;
		try {

			processoSelecionado = (Processo) comboBoxProcessos.getSelectedItem();

			gerenciarAudienciasButton.setEnabled(false);

			new AudienciaView(gerenciarAudienciasButton, processoSelecionado);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

	private List<Processo> buscarProcessos(String cadastroRF) throws ClienteNaoExisteException {

		List<Processo> processos = MainController.getProcessoController().getProcessos(cadastroRF);
		return processos;
	}

	private void listarProcessos() {
		String cadastroRFCliente = cadastroRFField.getText();
		comboBoxProcessos.removeAllItems();
		
		try {

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
				Utils.validarCPF(cadastroRFCliente);
			} else {
				Utils.validarCNPJ(cadastroRFCliente);
			}

			// Busca os processos (não pode acontecer dele não encontrar processos já que o
			// Cliente só é cliente com processos)
			List<Processo> processos = buscarProcessos(cadastroRFCliente);

			// Adiciona os processos à ComboBox
			for (Processo processo : processos) {
				comboBoxProcessos.addItem(processo);
			}

			gerenciarAudienciasButton.setEnabled(true);
			gerenciarContaButton.setEnabled(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
