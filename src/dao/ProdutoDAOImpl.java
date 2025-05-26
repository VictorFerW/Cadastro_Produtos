package dao;

import modelo.Produto;
import Config.ConexaoBD; // Importar conexão
import java.sql.*; // Importar JDBC
import java.util.ArrayList; // Importar List
import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {

    // Aqui você precisa implementar TODOS os métodos definidos na interface ProdutoDAO
    // (salvar, atualizar, excluir, buscarPorId, listarTodos, etc.)
    // usando JDBC e SQL, similar ao que foi feito em CategoriaDAOImpl.

    @Override
    public void salvar(Produto produto) throws Exception {
        // TODO: Implementar lógica SQL para INSERT
        System.out.println("Método salvar ProdutoDAOImpl ainda não implementado.");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Produto produto) throws Exception {
        // TODO: Implementar lógica SQL para UPDATE
         System.out.println("Método atualizar ProdutoDAOImpl ainda não implementado.");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // ... Implementar os outros métodos da interface ProdutoDAO ...

    @Override
    public List<Produto> listarTodos() throws Exception {
         System.out.println("Método listarTodos ProdutoDAOImpl ainda não implementado.");
         throw new UnsupportedOperationException("Not supported yet.");
         // return new ArrayList<>(); // Retornar lista vazia temporariamente
    }

    // ... etc ...

    @Override
    public void atualizarEstoque(int produtoId, int novaQuantidade) throws Exception {
         System.out.println("Método atualizarEstoque ProdutoDAOImpl ainda não implementado.");
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Produto buscarPorId(int id) throws Exception {
         System.out.println("Método buscarPorId ProdutoDAOImpl ainda não implementado.");
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Produto> buscarPorNome(String nome) throws Exception {
         System.out.println("Método buscarPorNome ProdutoDAOImpl ainda não implementado.");
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Produto> listarPorCategoria(int categoriaId) throws Exception {
         System.out.println("Método listarPorCategoria ProdutoDAOImpl ainda não implementado.");
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Produto> listarPorMarca(int marcaId) throws Exception {
         System.out.println("Método listarPorMarca ProdutoDAOImpl ainda não implementado.");
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int id) throws Exception {
         System.out.println("Método excluir ProdutoDAOImpl ainda não implementado.");
         throw new UnsupportedOperationException("Not supported yet.");
    }
}
