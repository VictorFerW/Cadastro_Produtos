package dao;

import modelo.Categoria;
import Config.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public void salvar(Categoria categoria) throws Exception {
        String sql = "INSERT INTO categorias (nome) VALUES (?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, categoria.getNome());
            pstmt.executeUpdate();

            // Recuperar o ID gerado (opcional, mas útil)
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                categoria.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao salvar categoria: " + e.getMessage());
            // Lançar exceção para a camada superior tratar
            throw new Exception("Erro ao salvar categoria", e);
        } finally {
            // Fechar PreparedStatement (ResultSet é fechado automaticamente com PreparedStatement)
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
            // Não fechar a conexão aqui se for gerenciada externamente ou reutilizada
            // ConexaoBD.closeConnection();
        }
    }

    @Override
    public void atualizar(Categoria categoria) throws Exception {
        String sql = "UPDATE categorias SET nome = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, categoria.getNome());
            pstmt.setInt(2, categoria.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar categoria: " + e.getMessage());
            throw new Exception("Erro ao atualizar categoria", e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM categorias WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Verificar erro de chave estrangeira (se categorias são usadas em produtos)
            if (e.getErrorCode() == 1451) { // Código de erro específico do MySQL para FK constraint
                 System.err.println("Erro ao excluir categoria: Categoria está em uso por produtos.");
                 throw new Exception("Erro ao excluir categoria: Categoria está em uso por produtos.", e);
            }
            System.err.println("Erro ao excluir categoria: " + e.getMessage());
            throw new Exception("Erro ao excluir categoria", e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
        }
    }

    @Override
    public Categoria buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM categorias WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Categoria categoria = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar categoria por ID: " + e.getMessage());
            throw new Exception("Erro ao buscar categoria por ID", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return categoria;
    }

    @Override
    public List<Categoria> listarTodas() throws Exception {
        String sql = "SELECT * FROM categorias ORDER BY nome";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Categoria> categorias = new ArrayList<>();

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar categorias: " + e.getMessage());
            throw new Exception("Erro ao listar categorias", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return categorias;
    }

    @Override
    public List<Categoria> buscarPorNome(String nome) throws Exception {
        String sql = "SELECT * FROM categorias WHERE nome LIKE ? ORDER BY nome";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Categoria> categorias = new ArrayList<>();

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + nome + "%"); // Busca por parte do nome
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar categorias por nome: " + e.getMessage());
            throw new Exception("Erro ao buscar categorias por nome", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return categorias;
    }
}

