package dao;

import modelo.EntradaEstoque;
import java.util.Date;
import java.util.List;

public interface EntradaEstoqueDAO {
    void salvar(EntradaEstoque entrada) throws Exception;
    // Atualizar e Excluir podem não fazer sentido para um registro de entrada, mas depende da regra de negócio.
    // void atualizar(EntradaEstoque entrada) throws Exception;
    // void excluir(int id) throws Exception;
    EntradaEstoque buscarPorId(int id) throws Exception;
    List<EntradaEstoque> listarTodas() throws Exception;
    List<EntradaEstoque> listarPorProduto(int produtoId) throws Exception;
    List<EntradaEstoque> listarPorFornecedor(int fornecedorId) throws Exception;
    List<EntradaEstoque> listarPorPeriodo(Date dataInicio, Date dataFim) throws Exception;
}

