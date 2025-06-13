package dao;

import modelo.Marca;
import Config.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Implementação concreta do DAO para Marcas
public class MarcaDAOImpl implements MarcaDAO, SimpleDAO<Marca> {

    @Override
    public void salvar(Marca marca) throws Exception {
        String sql = "INSERT INTO marcas (nome) VALUES (?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, marca.getNome());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                marca.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao salvar marca: " + e.getMessage());
            throw new Exception("Erro ao salvar marca", e);
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
    }

    @Override
    public void atualizar(Marca marca) throws Exception {
        String sql = "UPDATE marcas SET nome = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, marca.getNome());
            pstmt.setInt(2, marca.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar marca: " + e.getMessage());
            throw new Exception("Erro ao atualizar marca", e);
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM marcas WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Verificar erro de chave estrangeira (se marcas são usadas em produtos)
            if (e.getErrorCode() == 1451) { // Código de erro específico do MySQL para FK constraint
                 System.err.println("Erro ao excluir marca: Marca está em uso por produtos.");
                 throw new Exception("Erro ao excluir marca: Marca está em uso por produtos.", e);
            }
            System.err.println("Erro ao excluir marca: " + e.getMessage());
            throw new Exception("Erro ao excluir marca", e);
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
    }

    @Override
    public Marca buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM marcas WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Marca marca = null;

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar marca por ID: " + e.getMessage());
            throw new Exception("Erro ao buscar marca por ID", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return marca;
    }

    @Override
    public List<Marca> listarTodas() throws Exception {
        String sql = "SELECT * FROM marcas ORDER BY nome";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<>();

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setNome(rs.getString("nome"));
                marcas.add(marca);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar marcas: " + e.getMessage());
            throw new Exception("Erro ao listar marcas", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return marcas;
    }

    @Override
    public List<Marca> buscarPorNome(String nome) throws Exception {
        String sql = "SELECT * FROM marcas WHERE nome LIKE ? ORDER BY nome";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<>();

        try {
            conn = ConexaoBD.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + nome + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setNome(rs.getString("nome"));
                marcas.add(marca);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar marcas por nome: " + e.getMessage());
            throw new Exception("Erro ao buscar marcas por nome", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Ignorar */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return marcas;
    }
}
