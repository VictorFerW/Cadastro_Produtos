package dao;

import modelo.Produto;
import java.util.List;

public interface ProdutoDAO {
    void salvar(Produto produto) throws Exception;
    void atualizar(Produto produto) throws Exception;
    void excluir(int id) throws Exception;
    Produto buscarPorId(int id) throws Exception;
    List<Produto> listarTodos() throws Exception;
    List<Produto> buscarPorNome(String nome) throws Exception;
    List<Produto> listarPorCategoria(int categoriaId) throws Exception;
    List<Produto> listarPorMarca(int marcaId) throws Exception;
    // Método para atualizar apenas o estoque pode ser útil
    void atualizarEstoque(int produtoId, int novaQuantidade) throws Exception;
}

