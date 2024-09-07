package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.MainController;
import model.Processo;
import util.Utils;

public class NovaAudienciaView extends JFrame {

	private static final long serialVersionUID = -720382062866130585L;

	// Componentes declarados fora do initialize
	private JLabel registroLabel;
	private JTextField registroField;
	private JLabel dataLabel;
	private JTextField dataField;
	private JLabel descricaoLabel;
	private JTextArea descricaoArea;
	private JButton adicionarAudienciaButton;
	private JFrame novaJanela;

	public NovaAudienciaView(JButton addAudienciaButton, Processo processoSelecionado) {
		initialize(addAudienciaButton, processoSelecionado);
	}

	private void initialize(JButton addAudienciaButton, Processo processoSelecionado) {
		// Criação da nova janela (JFrame)
		novaJanela = new JFrame("Adicionar Audiência");
		novaJanela.setSize(550, 400); // Tamanho da janela
		novaJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[] { 0, 0, 140, 0 };
		novaJanela.getContentPane().setLayout(gridBagLayout); // Layout GridBagLayout

		// Definindo as fontes
		Font fieldFont = new Font("Arial", Font.PLAIN, 15);
		Font buttonFont = new Font("Arial", Font.BOLD, 16);
		Font labelFont = new Font("Arial", Font.BOLD, 15);

		// Inicializando os componentes
		registroLabel = new JLabel("Registro:");
		registroLabel.setFont(labelFont); // Fonte do rótulo

		registroField = new JTextField(14);
		registroField.setFont(fieldFont); // Fonte do campo de texto

		dataLabel = new JLabel("Data:");
		dataLabel.setFont(labelFont); // Fonte do rótulo

		dataField = new JTextField(11);
		dataField.setFont(fieldFont); // Fonte do campo de texto
		dataField.setText("dd/MM/yyyy");

		descricaoLabel = new JLabel("Descrição:");
		descricaoLabel.setFont(labelFont); // Fonte do rótulo

		descricaoArea = new JTextArea(4, 20);
		descricaoArea.setWrapStyleWord(true);
		descricaoArea.setFont(fieldFont); // Fonte do campo de texto
		descricaoArea.setLineWrap(true);

		adicionarAudienciaButton = new JButton("Adicionar audiência");
		adicionarAudienciaButton.setFont(buttonFont); // Fonte do botão

		// Configurando o GridBagConstraints e adicionando os componentes à janela
		GridBagConstraints gbcRegistroLabel = new GridBagConstraints();
		gbcRegistroLabel.insets = new Insets(15, 15, 15, 15);
		gbcRegistroLabel.gridx = 0;
		gbcRegistroLabel.gridy = 0;
		novaJanela.getContentPane().add(registroLabel, gbcRegistroLabel);

		GridBagConstraints gbcRegistroField = new GridBagConstraints();
		gbcRegistroField.insets = new Insets(15, 15, 15, 15);
		gbcRegistroField.gridx = 1;
		gbcRegistroField.gridy = 0;
		gbcRegistroField.fill = GridBagConstraints.HORIZONTAL;
		novaJanela.getContentPane().add(registroField, gbcRegistroField);

		GridBagConstraints gbcDataLabel = new GridBagConstraints();
		gbcDataLabel.insets = new Insets(15, 15, 15, 15);
		gbcDataLabel.gridx = 0;
		gbcDataLabel.gridy = 1;
		novaJanela.getContentPane().add(dataLabel, gbcDataLabel);

		GridBagConstraints gbcDataField = new GridBagConstraints();
		gbcDataField.insets = new Insets(15, 15, 15, 15);
		gbcDataField.gridx = 1;
		gbcDataField.gridy = 1;
		gbcDataField.anchor = GridBagConstraints.LINE_START;
		gbcDataField.fill = GridBagConstraints.HORIZONTAL;
		novaJanela.getContentPane().add(dataField, gbcDataField);

		GridBagConstraints gbcDescricaoLabel = new GridBagConstraints();
		gbcDescricaoLabel.insets = new Insets(15, 15, 15, 15);
		gbcDescricaoLabel.gridx = 0;
		gbcDescricaoLabel.gridy = 2;
		novaJanela.getContentPane().add(descricaoLabel, gbcDescricaoLabel);

		GridBagConstraints gbcDescricaoArea = new GridBagConstraints();
		gbcDescricaoArea.insets = new Insets(15, 15, 15, 15);
		gbcDescricaoArea.gridx = 1;
		gbcDescricaoArea.gridy = 2;
		gbcDescricaoArea.fill = GridBagConstraints.BOTH;
		gbcDescricaoArea.weightx = 1;
		gbcDescricaoArea.weighty = 1;
		gbcDescricaoArea.anchor = GridBagConstraints.CENTER;
		JScrollPane scrollPane = new JScrollPane(descricaoArea); // Adiciona rolagem
		novaJanela.getContentPane().add(scrollPane, gbcDescricaoArea);

		GridBagConstraints gbcAdicionarAudienciaButton = new GridBagConstraints();
		gbcAdicionarAudienciaButton.insets = new Insets(0, 15, 20, 15);
		gbcAdicionarAudienciaButton.gridx = 1;
		gbcAdicionarAudienciaButton.gridy = 3;
		gbcAdicionarAudienciaButton.fill = GridBagConstraints.NONE;
		gbcAdicionarAudienciaButton.anchor = GridBagConstraints.CENTER;
		novaJanela.getContentPane().add(adicionarAudienciaButton, gbcAdicionarAudienciaButton);

		// Define a ação ao clicar no botão
		adicionarAudienciaButton.addActionListener(e -> adicionaAudiencia(processoSelecionado));

		// Adiciona um WindowListener para habilitar o botão quando a janela for fechada
		novaJanela.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				addAudienciaButton.setEnabled(true);
			}
		});

		novaJanela.setVisible(true);
	}

	private void adicionaAudiencia(Processo processo) {
		String registro = registroField.getText();
		String data = dataField.getText();
		String descricao = descricaoArea.getText();

		try {

			if (registro.isBlank()) {
				JOptionPane.showMessageDialog(null, "Insira um registro!", "Erro de Entrada",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (descricao.isBlank()) {
				JOptionPane.showMessageDialog(null, "Insira uma descrição!", "Erro de Entrada",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			MainController.getProcessoController().addAudiencia(processo,
					MainController.getPessoaController().getAdvogado(registro), Utils.stringToDate(data), descricao);

			novaJanela.dispose();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
