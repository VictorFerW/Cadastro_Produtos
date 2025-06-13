package App; 

import dao.SimpleDAO;
import modelo.SimpleModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;
import java.util.function.Supplier;

public class TelaGerenciarSimples<T extends SimpleModel> extends JDialog {

    private JTable tabelaItens;
    private DefaultTableModel tableModel;
    private JButton btnNovo;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnAtualizar;
    private JButton btnFechar;

    private SimpleDAO<T> dao;
    private Supplier<T> modelSupplier;
    private String entityName; 

    public TelaGerenciarSimples(Frame owner, String title, SimpleDAO<T> dao, Supplier<T> modelSupplier) {
        super(owner, title, true); // Modal
        this.dao = dao;
        this.modelSupplier = modelSupplier;
        this.entityName = title.replace("Gerenciar ", ""); // Extrai o nome da entidade do título

        setSize(500, 400);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        initComponents();
        carregarItens();
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

        tabelaItens = new JTable(tableModel);
        tabelaItens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaItens.getColumnModel().getColumn(0).setPreferredWidth(50); // Largura ID
        tabelaItens.getColumnModel().getColumn(1).setPreferredWidth(350); // Largura Nome

        JScrollPane scrollPane = new JScrollPane(tabelaItens);

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

        btnNovo.addActionListener(e -> adicionarOuEditarItem(null));
        btnEditar.addActionListener(e -> editarItemSelecionado());
        btnExcluir.addActionListener(e -> excluirItemSelecionado());
        btnAtualizar.addActionListener(e -> carregarItens());
        btnFechar.addActionListener(e -> dispose());
    }

    private void carregarItens() {
        tableModel.setRowCount(0); // Limpa a tabela
        try {
            List<T> itens = dao.listarTodas();
            for (T item : itens) {
                Vector<Object> row = new Vector<>();
                row.add(item.getId());
                row.add(item.getNome());
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar " + entityName + "s: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void adicionarOuEditarItem(T itemParaEditar) {
        String nomeAtual = (itemParaEditar != null) ? itemParaEditar.getNome() : "";
        String novoNome = JOptionPane.showInputDialog(this, "Digite o nome d" + (entityName.endsWith("a") ? "a" : "o") + " " + entityName + ":", nomeAtual);

        if (novoNome != null && !novoNome.trim().isEmpty()) {
            try {
                if (itemParaEditar == null) { 
                    T novoItem = modelSupplier.get(); 
                    novoItem.setNome(novoNome.trim());
                    dao.salvar(novoItem);
                    JOptionPane.showMessageDialog(this, entityName + " salv" + (entityName.endsWith("a") ? "a" : "o") + " com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else { 
                    itemParaEditar.setNome(novoNome.trim());
                    dao.atualizar(itemParaEditar);
                    JOptionPane.showMessageDialog(this, entityName + " atualizad" + (entityName.endsWith("a") ? "a" : "o") + " com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                carregarItens(); 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar/atualizar " + entityName + ": " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    private void editarItemSelecionado() {
        int selectedRow = tabelaItens.getSelectedRow();
        if (selectedRow >= 0) {
            int itemId = (int) tableModel.getValueAt(selectedRow, 0);
            try {
                T item = dao.buscarPorId(itemId);
                if (item != null) {
                    adicionarOuEditarItem(item);
                } else {
                    JOptionPane.showMessageDialog(this, entityName + " não encontrad" + (entityName.endsWith("a") ? "a" : "o") + ".", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao buscar " + entityName + " para edição: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void excluirItemSelecionado() {
        int selectedRow = tabelaItens.getSelectedRow();
        if (selectedRow >= 0) {
            int itemId = (int) tableModel.getValueAt(selectedRow, 0);
            String itemNome = (String) tableModel.getValueAt(selectedRow, 1);

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja excluir " + (entityName.endsWith("a") ? "a" : "o") + " " + entityName + ": " + itemNome + "?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    dao.excluir(itemId);
                    JOptionPane.showMessageDialog(this, entityName + " excluíd" + (entityName.endsWith("a") ? "a" : "o") + " com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    carregarItens(); 
                } catch (Exception e) {
                    if (e.getMessage() != null && e.getMessage().contains("ConstraintViolationException")) { 
                         JOptionPane.showMessageDialog(this, "Erro ao excluir: " + entityName + " está em uso.", "Erro de Exclusão", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao excluir " + entityName + ": " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
