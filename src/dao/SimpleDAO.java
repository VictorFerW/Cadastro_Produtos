package dao;

import modelo.SimpleModel;
import java.util.List;

// Interface DAO genérica para modelos simples (ID, Nome)
public interface SimpleDAO<T extends SimpleModel> {
    void salvar(T model) throws Exception;
    void atualizar(T model) throws Exception;
    void excluir(int id) throws Exception;
    T buscarPorId(int id) throws Exception;
    List<T> listarTodas() throws Exception;
    List<T> buscarPorNome(String nome) throws Exception;
}
