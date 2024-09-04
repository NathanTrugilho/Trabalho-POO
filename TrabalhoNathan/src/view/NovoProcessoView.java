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
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NovoProcessoView extends JFrame {

    private JTextField cpfClienteField;
    private JTextField cpfParteContrariaField;
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
        JLabel label3 = new JLabel("CPF Cliente:");
        label3.setFont(labelFont);
        panel.add(label3, gbc);

        gbc.gridx = 1;
        cpfClienteField = new JTextField(25);
        cpfClienteField.setFont(fieldFont);
        panel.add(cpfClienteField, gbc);

        // CPF Parte Contrária
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel label4 = new JLabel("CPF Parte Contrária:");
        label4.setFont(labelFont);
        panel.add(label4, gbc);

        gbc.gridx = 1;
        cpfParteContrariaField = new JTextField(25);
        cpfParteContrariaField.setFont(fieldFont);
        panel.add(cpfParteContrariaField, gbc);

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
            String cpfCliente = cpfClienteField.getText();
            String cpfParteContraria = cpfParteContrariaField.getText();
            String tribunal = tribunalField.getText();

            // Lógica de validação e cadastro (para implementar)

            JOptionPane.showMessageDialog(this, "Cadastro de processo realizado com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            limparCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao realizar o cadastro: " + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        cpfClienteField.setText("");
        cpfParteContrariaField.setText("");
        dataAberturaField.setText("");
        numeroProcessoField.setText("");
        tribunalField.setText("");
    }
}
