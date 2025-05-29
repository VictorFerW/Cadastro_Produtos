package dao;

import modelo.Fornecedor;
import Config.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Implementação concreta do DAO para Fornecedores
public class FornecedorDAOImpl implements FornecedorDAO {

    @Override
    public void salvar(Fornecedor fornecedor) throws Exception {
        // Assumindo que a tabela fornecedores tem colunas: id, nome, cnpj, telefone, email, endereco (opcional)
        String sql = "INSERT INTO fornecedores (nome, cnpj, telefone, email) VALUES (?, ?, ?, ?)"; // Adicione outras colunas se necessário
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, fornecedor.getNome());
            pstmt.setString(2, fornecedor.getCnpj()); // Assumindo getCnpj()
            pstmt.setString(3, fornecedor.getTelefone()); // Assumindo getTelefone()
            pstmt.setString(4, fornecedor.getEmail()); // Assumindo getEmail()
            // pstmt.setString(5, fornecedor.getEndereco()); // Se houver endereço
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                fornecedor.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao salvar fornecedor: " + e.getMessage());
            throw new Exception("Erro ao salvar fornecedor", e);
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
    }

    @Override
    public void atualizar(Fornecedor fornecedor) throws Exception {
        String sql = "UPDATE fornecedores SET nome = ?, cnpj = ?, telefone = ?, email = ? WHERE id = ?"; // Adicione outras colunas
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fornecedor.getNome());
            pstmt.setString(2, fornecedor.getCnpj());
            pstmt.setString(3, fornecedor.getTelefone());
            pstmt.setString(4, fornecedor.getEmail());
            // pstmt.setString(5, fornecedor.getEndereco());
            pstmt.setInt(5, fornecedor.getId()); // WHERE id = ?
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar fornecedor: " + e.getMessage());
            throw new Exception("Erro ao atualizar fornecedor", e);
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM fornecedores WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Verificar erro de chave estrangeira (se fornecedores são usados em produtos)
            if (e.getErrorCode() == 1451) { // Código de erro específico do MySQL para FK constraint
                 System.err.println("Erro ao excluir fornecedor: Fornecedor está em uso por produtos.");
                 throw new Exception("Erro ao excluir fornecedor: Fornecedor está em uso por produtos.", e);
            }
            System.err.println("Erro ao excluir fornecedor: " + e.getMessage());
            throw new Exception("Erro ao excluir fornecedor", e);
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
    }

    @Override
    public Fornecedor buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM fornecedores WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Fornecedor fornecedor = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                fornecedor = mapRowToFornecedor(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar fornecedor por ID: " + e.getMessage());
            throw new Exception("Erro ao buscar fornecedor por ID", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return fornecedor;
    }

    @Override
    public List<Fornecedor> listarTodos() throws Exception {
        String sql = "SELECT * FROM fornecedores ORDER BY nome";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                fornecedores.add(mapRowToFornecedor(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar fornecedores: " + e.getMessage());
            throw new Exception("Erro ao listar fornecedores", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return fornecedores;
    }

    @Override
    public List<Fornecedor> buscarPorNome(String nome) throws Exception {
        String sql = "SELECT * FROM fornecedores WHERE nome LIKE ? ORDER BY nome";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + nome + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                fornecedores.add(mapRowToFornecedor(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar fornecedores por nome: " + e.getMessage());
            throw new Exception("Erro ao buscar fornecedores por nome", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return fornecedores;
    }

    // Método auxiliar para mapear um ResultSet para um objeto Fornecedor
    private Fornecedor mapRowToFornecedor(ResultSet rs) throws SQLException {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(rs.getInt("id"));
        fornecedor.setNome(rs.getString("nome"));
        fornecedor.setCnpj(rs.getString("cnpj"));
        fornecedor.setTelefone(rs.getString("telefone"));
        fornecedor.setEmail(rs.getString("email"));
        // fornecedor.setEndereco(rs.getString("endereco")); // Se houver endereço
        return fornecedor;
    }
}
