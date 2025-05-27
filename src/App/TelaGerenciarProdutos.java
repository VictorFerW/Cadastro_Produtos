package App;

<<<<<<< HEAD
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
        // Modelo da Tabela
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Não permite editar diretamente na tabela
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

        // Painel de Botões
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

        // Adicionar componentes ao diálogo
        add(scrollPane, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // --- Ações dos Botões ---
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
        // Limpa a tabela
        tableModel.setRowCount(0);

        try {
            List<Produto> produtos = produtoDAO.listarTodos();
            for (Produto p : produtos) {
                Vector<Object> row = new Vector<>();
                row.add(p.getId());
                row.add(p.getNome());
                row.add(p.getMarca() != null ? p.getMarca().getNome() : "N/A"); // Exibe nome da marca
                row.add(p.getPrecoVenda());
                row.add(p.getQuantidadeEstoque());
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Logar o erro
        }
    }

    private void abrirTelaCadastro(Produto produto) {
        // Cria e exibe a tela de cadastro (passando o produto para edição, ou null para novo)
        TelaCadastroProduto telaCadastro = new TelaCadastroProduto((Frame) getOwner(), produto);
        telaCadastro.setVisible(true);

        // Após fechar a tela de cadastro, atualiza a lista
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
                    carregarProdutos(); // Atualiza a lista
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

=======
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;

public class TelaGerenciarProdutos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenciarProdutos window = new TelaGerenciarProdutos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaGerenciarProdutos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 128, 128));
		frame.setBounds(100, 100, 989, 702);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(322, 0, 651, 663);
		frame.getContentPane().add(panel);
		
		// Exemplo com a imagem dentro da pasta 'src/imagens'
		JLabel lblImagem = new JLabel();
		lblImagem.setBounds(50, 50, 200, 200); // posição e tamanho do JLabel

		// Carregando a imagem
		lblImagem.setIcon(new ImageIcon(getClass().getResource("Sistema.png")));

		// Adiciona o JLabel no painel ou frame
		panel.add(lblImagem);

	}
}
>>>>>>> origin/Luan
