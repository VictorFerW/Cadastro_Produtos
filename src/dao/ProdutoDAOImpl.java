package dao;

import modelo.Fornecedor;
import modelo.Marca;
import modelo.Produto;
import Config.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {

    private MarcaDAO marcaDAO = new MarcaDAOImpl();
    private FornecedorDAO fornecedorDAO = new FornecedorDAOImpl();

    @Override
    public void salvar(Produto produto) throws Exception {
        String sql = "INSERT INTO produtos (nome, descricao, preco_venda, quantidade_estoque, categoria_id, marca_id, fornecedor_padrao_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPrecoVenda());
            pstmt.setInt(4, produto.getQuantidadeEstoque());
            pstmt.setInt(5, produto.getCategoria().getId());
            pstmt.setInt(6, produto.getMarca().getId());

            if (produto.getFornecedorPadrao() != null) {
                pstmt.setInt(7, produto.getFornecedorPadrao().getId());
            } else {
                pstmt.setNull(7, Types.INTEGER);
            }

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                produto.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao salvar produto: " + e.getMessage());
            throw new Exception("Erro ao salvar produto", e);
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
    }

    @Override
    public void atualizar(Produto produto) throws Exception {
        String sql = "UPDATE produtos SET nome = ?, descricao = ?, preco_venda = ?, quantidade_estoque = ?, categoria_id = ?, marca_id = ?, fornecedor_padrao_id = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPrecoVenda());
            pstmt.setInt(4, produto.getQuantidadeEstoque());
            pstmt.setInt(5, produto.getCategoria().getId());
            pstmt.setInt(6, produto.getMarca().getId());

            if (produto.getFornecedorPadrao() != null) {
                pstmt.setInt(7, produto.getFornecedorPadrao().getId());
            } else {
                pstmt.setNull(7, Types.INTEGER);
            }
            pstmt.setInt(8, produto.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
            throw new Exception("Erro ao atualizar produto", e);
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM produtos WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir produto: " + e.getMessage());
            throw new Exception("Erro ao excluir produto", e);
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
    }

    @Override
    public Produto buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Produto produto = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                produto = mapRowToProduto(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto por ID: " + e.getMessage());
            throw new Exception("Erro ao buscar produto por ID", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return produto;
    }

    @Override
    public List<Produto> listarTodos() throws Exception {
        String sql = "SELECT * FROM produtos ORDER BY nome";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                produtos.add(mapRowToProduto(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
            throw new Exception("Erro ao listar produtos", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return produtos;
    }

    @Override
    public List<Produto> buscarPorNome(String nome) throws Exception {
        String sql = "SELECT * FROM produtos WHERE nome LIKE ? ORDER BY nome";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + nome + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                produtos.add(mapRowToProduto(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produtos por nome: " + e.getMessage());
            throw new Exception("Erro ao buscar produtos por nome", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return produtos;
    }

    @Override
    public List<Produto> listarPorCategoria(int categoriaId) throws Exception {
        String sql = "SELECT * FROM produtos WHERE categoria_id = ? ORDER BY nome";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, categoriaId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                produtos.add(mapRowToProduto(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos por categoria: " + e.getMessage());
            throw new Exception("Erro ao listar produtos por categoria", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return produtos;
    }

    @Override
    public List<Produto> listarPorMarca(int marcaId) throws Exception {
        String sql = "SELECT * FROM produtos WHERE marca_id = ? ORDER BY nome";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, marcaId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                produtos.add(mapRowToProduto(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos por marca: " + e.getMessage());
            throw new Exception("Erro ao listar produtos por marca", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return produtos;
    }

    @Override
    public void atualizarEstoque(int produtoId, int novaQuantidade) throws Exception {
        String sql = "UPDATE produtos SET quantidade_estoque = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, novaQuantidade);
            pstmt.setInt(2, produtoId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar estoque do produto: " + e.getMessage());
            throw new Exception("Erro ao atualizar estoque do produto", e);
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
    }

    private Produto mapRowToProduto(ResultSet rs) throws Exception {
        Produto produto = new Produto();
        produto.setId(rs.getInt("id"));
        produto.setNome(rs.getString("nome"));
        produto.setDescricao(rs.getString("descricao"));
        produto.setPrecoVenda(rs.getDouble("preco_venda"));
        produto.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));

        int marcaId = rs.getInt("marca_id");
        Marca marca = marcaDAO.buscarPorId(marcaId);
        produto.setMarca(marca);

        int fornecedorId = rs.getInt("fornecedor_padrao_id");
        if (!rs.wasNull()) {
            Fornecedor fornecedor = fornecedorDAO.buscarPorId(fornecedorId);
            produto.setFornecedorPadrao(fornecedor);
        } else {
            produto.setFornecedorPadrao(null);
        }

        return produto;
    }
}
