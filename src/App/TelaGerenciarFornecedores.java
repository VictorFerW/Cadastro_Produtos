package App; // Ou o pacote onde suas telas estão

import dao.FornecedorDAO;
import dao.FornecedorDAOImpl; // Precisa existir!
import modelo.Fornecedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class TelaGerenciarFornecedores extends JDialog {

    private JTable tabelaFornecedores;
    private DefaultTableModel tableModel;
    private JButton btnNovo;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnAtualizar;
    private JButton btnFechar;

    private FornecedorDAO fornecedorDAO;

    public TelaGerenciarFornecedores(Frame owner) {
        super(owner, "Gerenciar Fornecedores", true); 
        this.fornecedorDAO = new FornecedorDAOImpl(); 

        setSize(800, 500); 
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        initComponents();
        carregarFornecedores();
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
        tableModel.addColumn("CNPJ");
        tableModel.addColumn("Telefone");
        tableModel.addColumn("Email");
        

        tabelaFornecedores = new JTable(tableModel);
        tabelaFornecedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaFornecedores.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabelaFornecedores.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabelaFornecedores.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabelaFornecedores.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabelaFornecedores.getColumnModel().getColumn(4).setPreferredWidth(150);

        JScrollPane scrollPane = new JScrollPane(tabelaFornecedores);

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
            int selectedRow = tabelaFornecedores.getSelectedRow();
            if (selectedRow >= 0) {
                int fornecedorId = (int) tableModel.getValueAt(selectedRow, 0);
                try {
                    Fornecedor fornecedorParaEditar = fornecedorDAO.buscarPorId(fornecedorId);
                    if (fornecedorParaEditar != null) {
                        abrirTelaCadastro(fornecedorParaEditar);
                    } else {
                        JOptionPane.showMessageDialog(this, "Fornecedor não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao buscar fornecedor para edição: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um fornecedor para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnExcluir.addActionListener(e -> excluirFornecedor());

        btnAtualizar.addActionListener(e -> carregarFornecedores());

        btnFechar.addActionListener(e -> dispose());
    }

    private void carregarFornecedores() {
        tableModel.setRowCount(0); 
        try {
            List<Fornecedor> fornecedores = fornecedorDAO.listarTodos();
            for (Fornecedor f : fornecedores) {
                Vector<Object> row = new Vector<>();
                row.add(f.getId());
                row.add(f.getNome());
                row.add(f.getCnpj()); 
                row.add(f.getTelefone());
                row.add(f.getEmail()); 
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar fornecedores: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void abrirTelaCadastro(Fornecedor fornecedor) {
        
        TelaCadastroFornecedor telaCadastro = new TelaCadastroFornecedor((Frame) getOwner(), fornecedor);
        telaCadastro.setVisible(true);

        
        carregarFornecedores();
    }

    private void excluirFornecedor() {
        int selectedRow = tabelaFornecedores.getSelectedRow();
        if (selectedRow >= 0) {
            int fornecedorId = (int) tableModel.getValueAt(selectedRow, 0);
            String fornecedorNome = (String) tableModel.getValueAt(selectedRow, 1);

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja excluir o fornecedor: " + fornecedorNome + "?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    fornecedorDAO.excluir(fornecedorId);
                    JOptionPane.showMessageDialog(this, "Fornecedor excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    carregarFornecedores(); // Atualiza a lista
                } catch (Exception e) {
                    
                    if (e.getMessage() != null && e.getMessage().contains("ConstraintViolationException")) { // Exemplo genérico
                         JOptionPane.showMessageDialog(this, "Erro ao excluir: Fornecedor está em uso.", "Erro de Exclusão", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao excluir fornecedor: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um fornecedor para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static class TelaCadastroFornecedor extends JDialog {
        private JTextField txtNome, txtCnpj, txtTelefone, txtEmail;
        private JButton btnSalvar, btnCancelar;
        private Fornecedor fornecedorAtual;
        private FornecedorDAO fornecedorDAO = new FornecedorDAOImpl(); 

        public TelaCadastroFornecedor(Frame owner, Fornecedor fornecedor) {
            super(owner, (fornecedor == null ? "Novo Fornecedor" : "Editar Fornecedor"), true);
            this.fornecedorAtual = (fornecedor != null) ? fornecedor : new Fornecedor();

            setSize(400, 300); 
            setLocationRelativeTo(owner);
            setLayout(new BorderLayout(10, 10));
            JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5)); 

            txtNome = new JTextField(fornecedorAtual.getNome());
            txtCnpj = new JTextField(fornecedorAtual.getCnpj());
            txtTelefone = new JTextField(fornecedorAtual.getTelefone());
            txtEmail = new JTextField(fornecedorAtual.getEmail());

            formPanel.add(new JLabel("Nome:"));
            formPanel.add(txtNome);
            formPanel.add(new JLabel("CNPJ:"));
            formPanel.add(txtCnpj);
            formPanel.add(new JLabel("Telefone:"));
            formPanel.add(txtTelefone);
            formPanel.add(new JLabel("Email:"));
            formPanel.add(txtEmail);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            btnSalvar = new JButton("Salvar");
            btnCancelar = new JButton("Cancelar");
            buttonPanel.add(btnSalvar);
            buttonPanel.add(btnCancelar);

            add(formPanel, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);

            btnSalvar.addActionListener(e -> salvarFornecedor());
            btnCancelar.addActionListener(e -> dispose());
        }

        private void salvarFornecedor() {
            if (txtNome.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "O nome do fornecedor é obrigatório.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            fornecedorAtual.setNome(txtNome.getText().trim());
            fornecedorAtual.setCnpj(txtCnpj.getText().trim());
            fornecedorAtual.setTelefone(txtTelefone.getText().trim());
            fornecedorAtual.setEmail(txtEmail.getText().trim());

            try {
                if (fornecedorAtual.getId() == 0) { 
                    fornecedorDAO.salvar(fornecedorAtual);
                } else { 
                    fornecedorDAO.atualizar(fornecedorAtual);
                }
                JOptionPane.showMessageDialog(this, "Fornecedor salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose(); 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar fornecedor: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
}
