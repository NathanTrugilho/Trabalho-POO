package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

@SuppressWarnings("serial")
public class MenuView extends JFrame {

    private JPanel contentPane;

    public MenuView() {
        initialize();
    }

    private void initialize() {
        // Ajusta o estilo do TabbedPane
        UIManager.put("TabbedPane.selected", new ColorUIResource(new Color(70, 130, 180)));
        UIManager.put("TabbedPane.font", new Font("Arial", Font.BOLD, 14));
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(10, 10, 10, 10));

        setTitle("App Advocacia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450); // Define um tamanho maior para a janela
        setLocationRelativeTo(null); // Centraliza a janela

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(15, 20, 15, 20)); // Bordas com espaçamento ajustado

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(new Color(240, 248, 255)); // Fundo das abas
        tabbedPane.setForeground(Color.BLACK); // Cor do texto das abas

        // Aba Cadastro de Pessoas
        JPanel cadastroPessoaPanel = createCadastroPessoaPanel();
        tabbedPane.addTab("Cadastro de Pessoas", null, cadastroPessoaPanel, "Cadastro de novos clientes");

        // Adicione mais abas aqui se necessário
        // Exemplo: tabbedPane.addTab("Outra Aba", createOutraPanel());

        contentPane.add(tabbedPane, BorderLayout.CENTER);
        setContentPane(contentPane);
    }

    private JPanel createCadastroPessoaPanel() {
        // Cria a instância de CadastroPessoaView para exibir dentro da aba
        CadastroPessoaView cadastroPessoaView = new CadastroPessoaView();

        // Cria um JPanel que conterá o conteúdo da CadastroPessoaView
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 255, 255)); // Fundo branco para o painel
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Bordas internas
        panel.add(cadastroPessoaView.getContentPane(), BorderLayout.CENTER);

        return panel;
    }
}
