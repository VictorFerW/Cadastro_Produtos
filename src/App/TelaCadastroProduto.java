package App;

import dao.*; 
import modelo.*; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List; 

public class TelaCadastroProduto extends JDialog {

    private JTextField txtNome;
    private JTextArea txtDescricao; 
    private JTextField txtPrecoVenda;
    private JTextField txtQuantidadeEstoque;
    private JComboBox<Categoria> cbCategoria;
    private JComboBox<Marca> cbMarca;
    private JComboBox<Fornecedor> cbFornecedorPadrao;

    private JButton btnSalvar;
    private JButton btnCancelar;

    private Produto produtoAtual; 
    private ProdutoDAO produtoDAO; 
    private CategoriaDAO categoriaDAO;
    private MarcaDAO marcaDAO;
    private FornecedorDAO fornecedorDAO;

    
    public TelaCadastroProduto(Frame owner) {
        this(owner, null);
    }

    
    public TelaCadastroProduto(Frame owner, Produto produtoParaEditar) {
        super(owner, "Cadastro de Produto", true); 
        this.produtoAtual = produtoParaEditar;
       
        this.produtoDAO = new ProdutoDAOImpl(); 
        this.categoriaDAO = new CategoriaDAOImpl(); 
        this.marcaDAO = new MarcaDAOImpl(); 
        this.fornecedorDAO = new FornecedorDAOImpl();

        setSize(500, 450);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10)); 

        initComponents();
        popularComboBoxes();

        if (produtoAtual != null) {
            setTitle("Editar Produto");
            carregarDadosProduto();
        }

        pack(); 
    }

    private void initComponents() {
        JPanel painelCampos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 
        gbc.anchor = GridBagConstraints.WEST;

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

        gbc.gridx = 0; gbc.gridy = 4; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        painelCampos.add(new JLabel("Categoria:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        cbCategoria = new JComboBox<>();
        painelCampos.add(cbCategoria, gbc);

        gbc.gridx = 0; gbc.gridy = 5; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        painelCampos.add(new JLabel("Marca:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        cbMarca = new JComboBox<>();
        painelCampos.add(cbMarca, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        painelCampos.add(new JLabel("Fornecedor Padrão:"), gbc);
        gbc.gridx = 1; gbc.gridy = 6; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        cbFornecedorPadrao = new JComboBox<>();
        cbFornecedorPadrao.addItem(null); 
        painelCampos.add(cbFornecedorPadrao, gbc);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);

        add(painelCampos, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> salvarProduto());
        btnCancelar.addActionListener(e -> dispose()); // Fecha o diálogo
    }

    private void popularComboBoxes() {
        try {
            List<Categoria> categorias = categoriaDAO.listarTodas();
            for (Categoria cat : categorias) {
                cbCategoria.addItem(cat);
            }

            List<Marca> marcas = marcaDAO.listarTodas();
            for (Marca marca : marcas) {
                cbMarca.addItem(marca);
            }

            List<Fornecedor> fornecedores = fornecedorDAO.listarTodos();
            for (Fornecedor forn : fornecedores) {
                cbFornecedorPadrao.addItem(forn);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados para seleção: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
    }

    private void carregarDadosProduto() {
        if (produtoAtual != null) {
            txtNome.setText(produtoAtual.getNome());
            txtDescricao.setText(produtoAtual.getDescricao());
            txtPrecoVenda.setText(String.valueOf(produtoAtual.getPrecoVenda()));
            txtQuantidadeEstoque.setText(String.valueOf(produtoAtual.getQuantidadeEstoque()));
            cbCategoria.setSelectedItem(produtoAtual.getCategoria()); 
            cbMarca.setSelectedItem(produtoAtual.getMarca()); 
            cbFornecedorPadrao.setSelectedItem(produtoAtual.getFornecedorPadrao()); 
        }
    }

    private void salvarProduto() {
        if (txtNome.getText().trim().isEmpty() || cbCategoria.getSelectedItem() == null || cbMarca.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Nome, Categoria e Marca são obrigatórios.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
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
            produto.setCategoria((Categoria) cbCategoria.getSelectedItem());
            produto.setMarca((Marca) cbMarca.getSelectedItem());
            produto.setFornecedorPadrao((Fornecedor) cbFornecedorPadrao.getSelectedItem());

            if (produtoAtual == null) { 
                produtoDAO.salvar(produto);
                JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else { 
                produtoDAO.atualizar(produto);
                JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }

            dispose(); 

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preço e Quantidade devem ser números válidos.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar produto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); 
        }
    }
}

