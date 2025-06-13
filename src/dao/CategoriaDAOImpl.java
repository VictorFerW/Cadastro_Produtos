package dao;

import modelo.Categoria;
import Config.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO, SimpleDAO<Categoria> {

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

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                categoria.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao salvar categoria: " + e.getMessage());
            throw new Exception("Erro ao salvar categoria", e);
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
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
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
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
            if (e.getErrorCode() == 1451) { 
                 System.err.println("Erro ao excluir categoria: Categoria está em uso por produtos.");
                 throw new Exception("Erro ao excluir categoria: Categoria está em uso por produtos.", e);
            }
            System.err.println("Erro ao excluir categoria: " + e.getMessage());
            throw new Exception("Erro ao excluir categoria", e);
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {  }
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
            if (rs != null) try { rs.close(); } catch (SQLException e) {  }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {  }
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
            if (rs != null) try { rs.close(); } catch (SQLException e) {  }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {  }
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
            pstmt.setString(1, "%" + nome + "%");
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
            if (rs != null) try { rs.close(); } catch (SQLException e) {  }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {  }
        }
        return categorias;
    }
}
