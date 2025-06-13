package App;

import dao.ProdutoDAO;
import dao.ProdutoDAOImpl; // Precisa existir!
import modelo.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class TelaGerenciarProdutos extends JDialog {

    private JTable tabelaProdutos;
    private DefaultTableModel tableModel;
    private JButton btnNovo;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnAtualizar;
    private JButton btnFechar;

    private ProdutoDAO produtoDAO;

    public TelaGerenciarProdutos(Frame owner) {
        super(owner, "Gerenciar Produtos", true); // Modal
        this.produtoDAO = new ProdutoDAOImpl(); // Instancia o DAO

        setSize(700, 500);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        initComponents();
        carregarProdutos();
    }

    private void initComponents() {
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        tableModel.addColumn("ID");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Categoria");
        tableModel.addColumn("Marca");
        tableModel.addColumn("Preço Venda");
        tableModel.addColumn("Qtd. Estoque");

        tabelaProdutos = new JTable(tableModel);
        tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Apenas uma linha selecionada
        tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(50); // Largura ID
        tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(200); // Largura Nome

        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnNovo = new JButton("Novo");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        btnAtualizar = new JButton("Atualizar Lista");
        btnFechar = new JButton("Fechar");

        painelBotoes.add(btnNovo);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnFechar);

        add(scrollPane, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        btnNovo.addActionListener(e -> abrirTelaCadastro(null));

        btnEditar.addActionListener(e -> {
            int selectedRow = tabelaProdutos.getSelectedRow();
            if (selectedRow >= 0) {
                int produtoId = (int) tableModel.getValueAt(selectedRow, 0);
                try {
                    Produto produtoParaEditar = produtoDAO.buscarPorId(produtoId);
                    if (produtoParaEditar != null) {
                        abrirTelaCadastro(produtoParaEditar);
                    } else {
                        JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao buscar produto para edição: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um produto para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnExcluir.addActionListener(e -> excluirProduto());

        btnAtualizar.addActionListener(e -> carregarProdutos());

        btnFechar.addActionListener(e -> dispose());
    }

    private void carregarProdutos() {
        tableModel.setRowCount(0);

        try {
            List<Produto> produtos = produtoDAO.listarTodos();
            for (Produto p : produtos) {
                Vector<Object> row = new Vector<>();
                row.add(p.getId());
                row.add(p.getNome());
                
               
                row.add(p.getCategoria() != null ? p.getCategoria().getNome() : "N/A"); 
                row.add(p.getMarca() != null ? p.getMarca().getNome() : "N/A"); 
                row.add(p.getPrecoVenda());
                row.add(p.getQuantidadeEstoque());
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
    }

    private void abrirTelaCadastro(Produto produto) {
        TelaCadastroProduto telaCadastro = new TelaCadastroProduto((Frame) getOwner(), produto);
        telaCadastro.setVisible(true);

        carregarProdutos();
    }


    private void excluirProduto() {
        int selectedRow = tabelaProdutos.getSelectedRow();
        if (selectedRow >= 0) {
            int produtoId = (int) tableModel.getValueAt(selectedRow, 0);
            String produtoNome = (String) tableModel.getValueAt(selectedRow, 1);

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja excluir o produto: " + produtoNome + "?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    produtoDAO.excluir(produtoId);
                    JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    carregarProdutos(); 
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
