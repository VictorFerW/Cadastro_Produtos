package App; 

import dao.MarcaDAOImpl;
import dao.FornecedorDAOImpl; 
import dao.CategoriaDAOImpl; 
import modelo.Categoria; 
import modelo.Marca;

import javax.swing.*;
import java.awt.*;


public class TelaPrincipal extends JFrame { 


    public TelaPrincipal() {
        setTitle("Sistema de Gerenciamento");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuCadastros = new JMenu("Cadastros");
        JMenu menuEstoque = new JMenu("Estoque");

        JMenuItem itemGerenciarProdutos = new JMenuItem("Gerenciar Produtos");
        JMenuItem itemGerenciarCategorias = new JMenuItem("Gerenciar Categorias");
        JMenuItem itemGerenciarMarcas = new JMenuItem("Gerenciar Marcas");
        JMenuItem itemGerenciarFornecedores = new JMenuItem("Gerenciar Fornecedores");

        JMenuItem itemRegistrarEntrada = new JMenuItem("Registrar Entrada");

        itemGerenciarProdutos.addActionListener(e -> abrirTelaGerenciarProdutos());
        itemGerenciarCategorias.addActionListener(e -> abrirTelaGerenciarCategorias());
        itemGerenciarMarcas.addActionListener(e -> abrirTelaGerenciarMarcas());
        itemGerenciarFornecedores.addActionListener(e -> abrirTelaGerenciarFornecedores());
        itemRegistrarEntrada.addActionListener(e -> abrirTelaRegistrarEntrada());

        menuCadastros.add(itemGerenciarProdutos);
        menuCadastros.add(itemGerenciarCategorias);
        menuCadastros.add(itemGerenciarMarcas);
        menuCadastros.add(itemGerenciarFornecedores);
        menuEstoque.add(itemRegistrarEntrada);

        menuBar.add(menuCadastros);
        menuBar.add(menuEstoque);
        setJMenuBar(menuBar);
    }


    private void abrirTelaGerenciarProdutos() {
        new TelaGerenciarProdutos(this).setVisible(true);
    }

    private void abrirTelaGerenciarCategorias() {
        new TelaGerenciarSimples<>(this, "Gerenciar Categorias", new CategoriaDAOImpl(), Categoria::new).setVisible(true);
    }

    private void abrirTelaGerenciarMarcas() {
        new TelaGerenciarSimples<>(this, "Gerenciar Marcas", new MarcaDAOImpl(), Marca::new).setVisible(true);
    }

    private void abrirTelaGerenciarFornecedores() {
        new TelaGerenciarFornecedores(this).setVisible(true);
    }

    private void abrirTelaRegistrarEntrada() {
        new TelaRegistrarEntradaEstoque(this).setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal frame = new TelaPrincipal();
            frame.setVisible(true);
        });
    }
}
