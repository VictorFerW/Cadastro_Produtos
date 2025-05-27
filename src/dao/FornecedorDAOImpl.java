package dao;

import modelo.Fornecedor;
import Config.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAOImpl implements FornecedorDAO {

    @Override
    public void salvar(Fornecedor fornecedor) throws Exception {
        // TODO: Implementar lógica SQL para INSERT
        System.out.println("Método salvar FornecedorDAOImpl ainda não implementado.");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Fornecedor fornecedor) throws Exception {
        // TODO: Implementar lógica SQL para UPDATE
        System.out.println("Método atualizar FornecedorDAOImpl ainda não implementado.");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int id) throws Exception {
        // TODO: Implementar lógica SQL para DELETE (cuidado com FK em produtos e entradas_estoque)
        System.out.println("Método excluir FornecedorDAOImpl ainda não implementado.");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Fornecedor buscarPorId(int id) throws Exception {
        // TODO: Implementar lógica SQL para SELECT por ID
        System.out.println("Método buscarPorId FornecedorDAOImpl ainda não implementado.");
        // return null;
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Fornecedor> listarTodos() throws Exception {
        // TODO: Implementar lógica SQL para SELECT *
        System.out.println("Método listarTodos FornecedorDAOImpl ainda não implementado.");
        // return new ArrayList<>();
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Fornecedor> buscarPorNome(String nome) throws Exception {
        // TODO: Implementar lógica SQL para SELECT por nome (LIKE)
        System.out.println("Método buscarPorNome FornecedorDAOImpl ainda não implementado.");
        // return new ArrayList<>();
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Fornecedor buscarPorCnpj(String cnpj) throws Exception {
        // TODO: Implementar lógica SQL para SELECT por CNPJ
        System.out.println("Método buscarPorCnpj FornecedorDAOImpl ainda não implementado.");
        // return null;
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

