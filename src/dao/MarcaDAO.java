package dao;

import modelo.Marca;
import java.util.List;

public interface MarcaDAO {
    void salvar(Marca marca) throws Exception;
    void atualizar(Marca marca) throws Exception;
    void excluir(int id) throws Exception;
    Marca buscarPorId(int id) throws Exception;
    List<Marca> listarTodas() throws Exception;
    List<Marca> buscarPorNome(String nome) throws Exception;
}

