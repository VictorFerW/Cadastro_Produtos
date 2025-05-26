package dao;

import modelo.Categoria;
import java.util.List;

public interface CategoriaDAO {
    void salvar(Categoria categoria) throws Exception;
    void atualizar(Categoria categoria) throws Exception;
    void excluir(int id) throws Exception;
    Categoria buscarPorId(int id) throws Exception;
    List<Categoria> listarTodas() throws Exception;
    List<Categoria> buscarPorNome(String nome) throws Exception;
}

