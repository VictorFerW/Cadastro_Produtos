package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Exemplo básico da Tela Principal (JFrame)
public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Sistema de Gestão de Estoque");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centralizar na tela

        // --- Barra de Menus ---
        JMenuBar menuBar = new JMenuBar();

        // Menu Cadastros
        JMenu menuCadastros = new JMenu("Cadastros");
        JMenuItem itemProdutos = new JMenuItem("Produtos");
        JMenuItem itemCategorias = new JMenuItem("Categorias");
        JMenuItem itemMarcas = new JMenuItem("Marcas");
        JMenuItem itemFornecedores = new JMenuItem("Fornecedores");
        JMenuItem itemEntradas = new JMenuItem("Registrar Entrada de Estoque");

        menuCadastros.add(itemProdutos);
        menuCadastros.add(itemCategorias);
        menuCadastros.add(itemMarcas);
        menuCadastros.add(itemFornecedores);
        menuCadastros.addSeparator();
        menuCadastros.add(itemEntradas);

        // Menu Relatórios (Exemplo)
        JMenu menuRelatorios = new JMenu("Relatórios");
        JMenuItem itemRelatorioEstoque = new JMenuItem("Estoque Atual");
        JMenuItem itemRelatorioEntradas = new JMenuItem("Histórico de Entradas");
        menuRelatorios.add(itemRelatorioEstoque);
        menuRelatorios.add(itemRelatorioEntradas);

        // Menu Ajuda (Exemplo)
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem itemSobre = new JMenuItem("Sobre");
        menuAjuda.add(itemSobre);

        menuBar.add(menuCadastros);
        menuBar.add(menuRelatorios);
        menuBar.add(menuAjuda);
        setJMenuBar(menuBar);

        // --- Painel Principal (Pode conter uma tabela ou outros componentes) ---
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        // Adicionar aqui JTable, filtros, etc. para gerenciar produtos, por exemplo.
        JLabel labelBemVindo = new JLabel("Bem-vindo ao Sistema!", SwingConstants.CENTER);
        labelBemVindo.setFont(new Font("Arial", Font.BOLD, 16));
        painelPrincipal.add(labelBemVindo, BorderLayout.CENTER);

        add(painelPrincipal);

        // --- Ações dos Menus (Exemplos básicos) ---
        itemProdutos.addActionListener(e -> abrirTelaGerenciarProdutos());
       
        itemMarcas.addActionListener(e -> abrirTelaGerenciarMarcas());
        itemFornecedores.addActionListener(e -> abrirTelaGerenciarFornecedores());
        itemEntradas.addActionListener(e -> abrirTelaRegistrarEntrada());

        itemSobre.addActionListener(e -> mostrarSobre());

        // Tornar a janela visível
        // setVisible(true); // Mover para a classe Main
    }

    // Métodos para abrir as outras telas (precisam ser implementados)
    private void abrirTelaGerenciarProdutos() {
       
         new TelaGerenciarProdutos(this).setVisible(true); // Se for JDialog
    }

   

    private void abrirTelaGerenciarMarcas() {
        JOptionPane.showMessageDialog(this, "Funcionalidade Gerenciar Marcas ainda não implementada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        // new TelaGerenciarSimples(this, "Marcas", new MarcaDAOImpl()).setVisible(true);
    }

    private void abrirTelaGerenciarFornecedores() {
        JOptionPane.showMessageDialog(this, "Funcionalidade Gerenciar Fornecedores ainda não implementada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        // new TelaGerenciarFornecedores(this).setVisible(true);
    }

    private void abrirTelaRegistrarEntrada() {
        JOptionPane.showMessageDialog(this, "Funcionalidade Registrar Entrada ainda não implementada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        // new TelaRegistrarEntradaEstoque(this).setVisible(true);
    }

    private void mostrarSobre() {
        JOptionPane.showMessageDialog(this,
                "Sistema de Gestão de Estoque\nVersão 1.0\nDesenvolvido por [Seu Nome/Equipe]",
                "Sobre",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Classe Main para iniciar a aplicação (pode ficar em um arquivo separado)
    /*
    public static void main(String[] args) {
        // Definir Look and Feel (opcional, mas melhora a aparência)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Iniciar a tela principal na Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
    */
}

