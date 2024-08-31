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
        UIManager.put("TabbedPane.selected", new ColorUIResource(new Color(52, 152, 219)));
        UIManager.put("TabbedPane.font", new Font("SansSerif", Font.BOLD, 13));
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(10, 8, 10, 8));
        UIManager.put("TabbedPane.tabInsets", new Insets(8, 8, 8, 8)); // Adiciona mais espaçamento nas abas

        setTitle("App Advocacia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 600); // Define um tamanho maior para a janela
        setLocationRelativeTo(null); // Centraliza a janela

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(15, 25, 15, 25)); // Bordas com espaçamento ajustado

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(new Color(236, 240, 241)); // Fundo das abas
        tabbedPane.setForeground(Color.BLACK); // Cor do texto das abas
        tabbedPane.setOpaque(true);

        // Aba Cadastro de Pessoas
        JPanel cadastroPessoaPanel = createCadastroPessoaPanel();
        tabbedPane.addTab("Cadastro de Pessoas", null, cadastroPessoaPanel, "Cadastra pessoas");

        // Exemplo de outra aba
        JPanel tribunalPanel = createTribunalPanel();
        tabbedPane.addTab("Cadastrar Tribunal", null, tribunalPanel, "Faz o cadastro de tribunais");

        contentPane.add(tabbedPane, BorderLayout.CENTER);
        setContentPane(contentPane);
    }

    private JPanel createCadastroPessoaPanel() {
        // Cria a instância de CadastroPessoaView para exibir dentro da aba
        CadastroPessoaView cadastroPessoaView = new CadastroPessoaView();

        // Cria um JPanel que conterá o conteúdo da CadastroPessoaView
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 255, 255)); // Fundo branco para o painel
        panel.setBorder(new EmptyBorder(15, 15, 15, 15)); // Bordas internas com espaçamento ajustado
        panel.add(cadastroPessoaView.getContentPane(), BorderLayout.CENTER);

        return panel;
    }
    
    private JPanel createTribunalPanel() {
        // Cria a instância de CadastroPessoaView para exibir dentro da aba
        CadastroTribunalView TribunalView = new CadastroTribunalView();

        // Cria um JPanel que conterá o conteúdo da CadastroPessoaView
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 255, 255)); // Fundo branco para o painel
        panel.setBorder(new EmptyBorder(15, 15, 15, 15)); // Bordas internas com espaçamento ajustado
        panel.add(TribunalView.getContentPane(), BorderLayout.CENTER);

        return panel;
    }
}
