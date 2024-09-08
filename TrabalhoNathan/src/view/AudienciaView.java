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

public class AudienciaView extends JFrame {

	private static final long serialVersionUID = -720382062866130585L;

	private JLabel registroLabel;
	private JTextField registroField;
	private JLabel dataLabel;
	private JTextField dataField;
	private JLabel descricaoLabel;
	private JTextArea descricaoArea;
	private JButton adicionarAudienciaButton;
	private JButton listarAudienciasButton;
	private JTextArea audienciasArea;
	private JFrame janelaAudiencia;
	private JButton addAudienciaButton;
	private Processo processo;

	public AudienciaView(JButton addAudienciaButton, Processo processoSelecionado) {
		this.addAudienciaButton = addAudienciaButton;
		this.processo = processoSelecionado;
		initialize();
	}

	private void initialize() {
		janelaAudiencia = new JFrame("Adicionar Audiência");
		janelaAudiencia.setSize(572, 530);
		janelaAudiencia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaAudiencia.setLocationRelativeTo(null);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 80, 0, 160 };
		janelaAudiencia.getContentPane().setLayout(gridBagLayout);

		Font fieldFont = new Font("Arial", Font.PLAIN, 15);
		Font buttonFont = new Font("Arial", Font.BOLD, 16);
		Font labelFont = new Font("Arial", Font.BOLD, 15);

		registroLabel = new JLabel("Registro:");
		registroLabel.setFont(labelFont);

		registroField = new JTextField(14);
		registroField.setFont(fieldFont);

		dataLabel = new JLabel("Data:");
		dataLabel.setFont(labelFont);

		dataField = new JTextField(11);
		dataField.setFont(fieldFont);
		dataField.setText("dd/MM/yyyy");

		descricaoLabel = new JLabel("Descrição:");
		descricaoLabel.setFont(labelFont);

		descricaoArea = new JTextArea(3, 15);
		descricaoArea.setWrapStyleWord(true);
		descricaoArea.setFont(fieldFont);
		descricaoArea.setLineWrap(true);

		adicionarAudienciaButton = new JButton("Adicionar audiência");
		adicionarAudienciaButton.setFont(buttonFont);

		listarAudienciasButton = new JButton("Listar audiências");
		listarAudienciasButton.setFont(buttonFont);

		audienciasArea = new JTextArea(10, 40);
		audienciasArea.setWrapStyleWord(true);
		audienciasArea.setFont(fieldFont);
		audienciasArea.setLineWrap(true);
		JScrollPane audienciasScrollPane = new JScrollPane(audienciasArea);

		GridBagConstraints gbcRegistroLabel = new GridBagConstraints();
		gbcRegistroLabel.anchor = GridBagConstraints.LINE_START;
		gbcRegistroLabel.insets = new Insets(15, 15, 15, 0);
		gbcRegistroLabel.gridx = 0;
		gbcRegistroLabel.gridy = 0;
		janelaAudiencia.getContentPane().add(registroLabel, gbcRegistroLabel);

		GridBagConstraints gbcRegistroField = new GridBagConstraints();
		gbcRegistroField.weightx = 1.0;
		gbcRegistroField.insets = new Insets(15, 0, 15, 15);
		gbcRegistroField.gridx = 1;
		gbcRegistroField.gridy = 0;
		gbcRegistroField.fill = GridBagConstraints.HORIZONTAL;
		janelaAudiencia.getContentPane().add(registroField, gbcRegistroField);

		GridBagConstraints gbcDataLabel = new GridBagConstraints();
		gbcDataLabel.anchor = GridBagConstraints.LINE_START;
		gbcDataLabel.insets = new Insets(15, 15, 15, 0);
		gbcDataLabel.gridx = 0;
		gbcDataLabel.gridy = 1;
		janelaAudiencia.getContentPane().add(dataLabel, gbcDataLabel);

		GridBagConstraints gbcDataField = new GridBagConstraints();
		gbcDataField.weightx = 1.0;
		gbcDataField.insets = new Insets(15, 0, 10, 15);
		gbcDataField.gridx = 1;
		gbcDataField.gridy = 1;
		gbcDataField.anchor = GridBagConstraints.LINE_START;
		gbcDataField.fill = GridBagConstraints.HORIZONTAL;
		janelaAudiencia.getContentPane().add(dataField, gbcDataField);

		GridBagConstraints gbcDescricaoLabel = new GridBagConstraints();
		gbcDescricaoLabel.anchor = GridBagConstraints.LINE_START;
		gbcDescricaoLabel.insets = new Insets(15, 15, 20, 0);
		gbcDescricaoLabel.gridx = 0;
		gbcDescricaoLabel.gridy = 2;
		janelaAudiencia.getContentPane().add(descricaoLabel, gbcDescricaoLabel);

		GridBagConstraints gbcDescricaoArea = new GridBagConstraints();
		gbcDescricaoArea.insets = new Insets(15, 0, 15, 15);
		gbcDescricaoArea.gridx = 1;
		gbcDescricaoArea.gridy = 2;
		gbcDescricaoArea.fill = GridBagConstraints.BOTH;
		gbcDescricaoArea.weightx = 1;
		gbcDescricaoArea.weighty = 0.3;
		JScrollPane scrollPane = new JScrollPane(descricaoArea);
		janelaAudiencia.getContentPane().add(scrollPane, gbcDescricaoArea);

		GridBagConstraints gbcNovoBotao = new GridBagConstraints();
		gbcNovoBotao.anchor = GridBagConstraints.WEST;
		gbcNovoBotao.insets = new Insets(0, 15, 15, 0);
		gbcNovoBotao.gridx = 0;
		gbcNovoBotao.gridy = 3;
		janelaAudiencia.getContentPane().add(listarAudienciasButton, gbcNovoBotao);

		GridBagConstraints gbcAdicionarAudienciaButton = new GridBagConstraints();
		gbcAdicionarAudienciaButton.insets = new Insets(0, 5, 15, 15);
		gbcAdicionarAudienciaButton.gridx = 1;
		gbcAdicionarAudienciaButton.gridy = 3;
		gbcAdicionarAudienciaButton.anchor = GridBagConstraints.CENTER;
		janelaAudiencia.getContentPane().add(adicionarAudienciaButton, gbcAdicionarAudienciaButton);

		GridBagConstraints gbcAudienciasArea = new GridBagConstraints();
		gbcAudienciasArea.weighty = 0.7;
		gbcAudienciasArea.weightx = 1.0;
		gbcAudienciasArea.insets = new Insets(5, 15, 25, 15);
		gbcAudienciasArea.gridx = 0;
		gbcAudienciasArea.gridy = 4;
		gbcAudienciasArea.gridwidth = 2;
		gbcAudienciasArea.fill = GridBagConstraints.BOTH;
		janelaAudiencia.getContentPane().add(audienciasScrollPane, gbcAudienciasArea);

		adicionarAudienciaButton.addActionListener(e -> adicionaAudiencia());
		listarAudienciasButton.addActionListener(e -> listarAudiencias());

		janelaAudiencia.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				addAudienciaButton.setEnabled(true);
			}
		});

		janelaAudiencia.setVisible(true);
	}

	private void adicionaAudiencia() {
		String registro = registroField.getText();
		String data = dataField.getText();
		String descricao = descricaoArea.getText();

		try {
			if (registro.isBlank()) {
				JOptionPane.showMessageDialog(null, "Insira um registro!", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (descricao.isBlank()) {
				JOptionPane.showMessageDialog(null, "Insira uma descrição!", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
				return;
			}

			MainController.getProcessoController().addAudiencia(processo,
					MainController.getPessoaController().getAdvogado(registro), Utils.stringToDate(data), descricao);

			JOptionPane.showMessageDialog(null, "Audiência adicionada com sucesso!");

			limparCampos();
			listarAudiencias();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void listarAudiencias() {
		audienciasArea.setText("");
		audienciasArea.setText(processo.getAudiencias().toString());

		if (audienciasArea.getText().isBlank()) {
			audienciasArea.setText("Este processo não possui audiências!");
		}
	}

	private void limparCampos() {
		registroField.setText("");
		dataField.setText("dd/MM/yyyy");
		descricaoArea.setText("");
	}
}
