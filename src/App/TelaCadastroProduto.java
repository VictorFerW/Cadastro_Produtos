package App;

import dao.*; // Importar DAOs necessários
import modelo.*; // Importar modelos necessários

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List; // Para popular ComboBoxes

// Exemplo básico de Tela de Cadastro de Produto (JDialog)
public class TelaCadastroProduto extends JDialog {

    private JTextField txtNome;
    private JTextArea txtDescricao; // Usar JTextArea para descrição mais longa
    private JTextField txtPrecoVenda;
    private JTextField txtQuantidadeEstoque;
   
    private JComboBox<Marca> cbMarca;
    private JComboBox<Fornecedor> cbFornecedorPadrao;

    private JButton btnSalvar;
    private JButton btnCancelar;

    private Produto produtoAtual; // Para edição
    private ProdutoDAO produtoDAO; // Instância do DAO
    // DAOs para popular ComboBoxes
   
    private MarcaDAO marcaDAO;
    private FornecedorDAO fornecedorDAO;

    // Construtor para Novo Produto
    public TelaCadastroProduto(Frame owner) {
        this(owner, null);
    }

    // Construtor para Editar Produto
    public TelaCadastroProduto(Frame owner, Produto produtoParaEditar) {
        super(owner, "Cadastro de Produto", true); // Modal
        this.produtoAtual = produtoParaEditar;
        // Inicializar DAOs (idealmente injetados ou obtidos de uma fábrica/serviço)
        this.produtoDAO = new ProdutoDAOImpl(); // Exemplo, criar implementação
        
        this.marcaDAO = new MarcaDAOImpl(); // Exemplo, criar implementação
        this.fornecedorDAO = new FornecedorDAOImpl(); // Exemplo, criar implementação

        setSize(500, 450);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10)); // Layout principal com espaçamento

        initComponents();
        popularComboBoxes();

        if (produtoAtual != null) {
            setTitle("Editar Produto");
            carregarDadosProduto();
        }

        pack(); // Ajusta o tamanho da janela aos componentes
    }

    private void initComponents() {
        // Painel para os campos de entrada
        JPanel painelCampos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento
        gbc.anchor = GridBagConstraints.WEST;

        // Labels e Campos
        gbc.gridx = 0; gbc.gridy = 0; painelCampos.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtNome = new JTextField(20);
        painelCampos.add(txtNome, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        painelCampos.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.fill = GridBagConstraints.BOTH; gbc.weightx = 1.0; gbc.weighty = 1.0;
        txtDescricao = new JTextArea(3, 20);
        JScrollPane scrollDescricao = new JScrollPane(txtDescricao);
        painelCampos.add(scrollDescricao, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0; gbc.weighty = 0;
        painelCampos.add(new JLabel("Preço Venda:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtPrecoVenda = new JTextField(10);
        painelCampos.add(txtPrecoVenda, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        painelCampos.add(new JLabel("Qtd. Estoque:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtQuantidadeEstoque = new JTextField(5);
        painelCampos.add(txtQuantidadeEstoque, gbc);


        gbc.gridx = 0; gbc.gridy = 5; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        painelCampos.add(new JLabel("Marca:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        cbMarca = new JComboBox<>();
        painelCampos.add(cbMarca, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        painelCampos.add(new JLabel("Fornecedor Padrão:"), gbc);
        gbc.gridx = 1; gbc.gridy = 6; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        cbFornecedorPadrao = new JComboBox<>();
        cbFornecedorPadrao.addItem(null); // Permitir fornecedor nulo
        painelCampos.add(cbFornecedorPadrao, gbc);

        // Painel para os botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);

        // Adicionar painéis ao diálogo
        add(painelCampos, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // --- Ações dos Botões ---
        btnSalvar.addActionListener(e -> salvarProduto());
        btnCancelar.addActionListener(e -> dispose()); // Fecha o diálogo
    }

    private void popularComboBoxes() {
        try {
            // Popular Categoria
         

            // Popular Marca
            List<Marca> marcas = marcaDAO.listarTodas();
            for (Marca marca : marcas) {
                cbMarca.addItem(marca);
            }

            // Popular Fornecedor
            List<Fornecedor> fornecedores = fornecedorDAO.listarTodos();
            for (Fornecedor forn : fornecedores) {
                cbFornecedorPadrao.addItem(forn);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados para seleção: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Logar o erro
        }
    }

    private void carregarDadosProduto() {
        if (produtoAtual != null) {
            txtNome.setText(produtoAtual.getNome());
            txtDescricao.setText(produtoAtual.getDescricao());
            txtPrecoVenda.setText(String.valueOf(produtoAtual.getPrecoVenda()));
            txtQuantidadeEstoque.setText(String.valueOf(produtoAtual.getQuantidadeEstoque()));
            cbMarca.setSelectedItem(produtoAtual.getMarca()); // Requer equals() implementado em Marca
            cbFornecedorPadrao.setSelectedItem(produtoAtual.getFornecedorPadrao()); // Requer equals() implementado em Fornecedor
        }
    }

    private void salvarProduto() {
        // Validação básica (melhorar conforme necessário)
        if (txtNome.getText().trim().isEmpty() ||  cbMarca.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Nome e Marca são obrigatórios.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double preco = Double.parseDouble(txtPrecoVenda.getText().replace(',', '.'));
            int qtd = Integer.parseInt(txtQuantidadeEstoque.getText());

            Produto produto = (produtoAtual == null) ? new Produto() : produtoAtual;
            produto.setNome(txtNome.getText().trim());
            produto.setDescricao(txtDescricao.getText().trim());
            produto.setPrecoVenda(preco);
            produto.setQuantidadeEstoque(qtd);
           
            produto.setMarca((Marca) cbMarca.getSelectedItem());
            produto.setFornecedorPadrao((Fornecedor) cbFornecedorPadrao.getSelectedItem());

            if (produtoAtual == null) { // Novo produto
                produtoDAO.salvar(produto);
                JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else { // Editar produto
                produtoDAO.atualizar(produto);
                JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }

            dispose(); // Fecha o diálogo após salvar

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preço e Quantidade devem ser números válidos.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar produto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); // Logar o erro
        }
    }
}

