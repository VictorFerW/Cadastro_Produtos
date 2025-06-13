package App; // Ou o pacote onde suas telas estão

import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;
import modelo.Produto;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class TelaRegistrarEntradaEstoque extends JDialog {

    private JComboBox<Produto> cmbProdutos;
    private JTextField txtQuantidade;
    private JLabel lblEstoqueAtual;
    private JButton btnRegistrar;
    private JButton btnCancelar;

    private ProdutoDAO produtoDAO;

    public TelaRegistrarEntradaEstoque(Frame owner) {
        super(owner, "Registrar Entrada de Estoque", true);
        this.produtoDAO = new ProdutoDAOImpl();

        setSize(450, 250);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        initComponents();
        carregarProdutosComboBox();
    }

    private void initComponents() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Linha 1: Produto
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(new JLabel("Produto:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        cmbProdutos = new JComboBox<>();
        formPanel.add(cmbProdutos, gbc);

        // Linha 2: Estoque Atual
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        formPanel.add(new JLabel("Estoque Atual:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        lblEstoqueAtual = new JLabel("-");
        formPanel.add(lblEstoqueAtual, gbc);

        // Linha 3: Quantidade a Entrar
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Quantidade a Entrar:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        txtQuantidade = new JTextField();
        formPanel.add(txtQuantidade, gbc);

        // Painel de Botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnRegistrar = new JButton("Registrar Entrada");
        btnCancelar = new JButton("Cancelar");
        buttonPanel.add(btnRegistrar);
        buttonPanel.add(btnCancelar);

        // Adicionar painéis ao diálogo
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // --- Ações ---
        cmbProdutos.addActionListener(e -> atualizarEstoqueAtualLabel());
        btnRegistrar.addActionListener(e -> registrarEntrada());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void carregarProdutosComboBox() {
        try {
            List<Produto> produtos = produtoDAO.listarTodos();
            DefaultComboBoxModel<Produto> model = new DefaultComboBoxModel<>(new Vector<>(produtos));
            cmbProdutos.setModel(model);
            
            if (!produtos.isEmpty()) {
                atualizarEstoqueAtualLabel();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void atualizarEstoqueAtualLabel() {
        Produto produtoSelecionado = (Produto) cmbProdutos.getSelectedItem();
        if (produtoSelecionado != null) {
            lblEstoqueAtual.setText(String.valueOf(produtoSelecionado.getQuantidadeEstoque()));
        } else {
            lblEstoqueAtual.setText("-");
        }
    }

    private void registrarEntrada() {
        Produto produtoSelecionado = (Produto) cmbProdutos.getSelectedItem();
        if (produtoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String qtdTexto = txtQuantidade.getText().trim();
        if (qtdTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite a quantidade a entrar.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int quantidadeEntrada;
        try {
            quantidadeEntrada = Integer.parseInt(qtdTexto);
            if (quantidadeEntrada <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser um número positivo.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida. Digite apenas números.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int estoqueAtual = produtoSelecionado.getQuantidadeEstoque();
            int novoEstoque = estoqueAtual + quantidadeEntrada;
            
            // Atualiza o estoque no banco de dados
            produtoDAO.atualizarEstoque(produtoSelecionado.getId(), novoEstoque);
            
            // Atualiza o objeto local (opcional, mas bom para consistência)
            produtoSelecionado.setQuantidadeEstoque(novoEstoque);
            
            // Atualiza o label na tela
            atualizarEstoqueAtualLabel();
            
            JOptionPane.showMessageDialog(this, "Entrada de estoque registrada com sucesso!\nNovo estoque de '" + produtoSelecionado.getNome() + "': " + novoEstoque, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            // Limpa o campo de quantidade para a próxima entrada
            txtQuantidade.setText(""); 
            
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar entrada de estoque: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
