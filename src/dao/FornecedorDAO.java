package dao;

import modelo.Fornecedor;
import java.util.List;

// Interface para operações CRUD de Fornecedores
public interface FornecedorDAO {
    void salvar(Fornecedor fornecedor) throws Exception;
    void atualizar(Fornecedor fornecedor) throws Exception;
    void excluir(int id) throws Exception;
    Fornecedor buscarPorId(int id) throws Exception;
    List<Fornecedor> listarTodos() throws Exception;
    List<Fornecedor> buscarPorNome(String nome) throws Exception;
    // Adicionar outros métodos de busca se necessário (ex: buscarPorCnpj)
}
