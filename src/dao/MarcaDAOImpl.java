package dao;

import modelo.Marca;
import Config.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAOImpl implements MarcaDAO {

    @Override
    public void salvar(Marca marca) throws Exception {
        // TODO: Implementar lógica SQL para INSERT
        System.out.println("Método salvar MarcaDAOImpl ainda não implementado.");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Marca marca) throws Exception {
        // TODO: Implementar lógica SQL para UPDATE
        System.out.println("Método atualizar MarcaDAOImpl ainda não implementado.");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int id) throws Exception {
        // TODO: Implementar lógica SQL para DELETE (cuidado com FK em produtos)
        System.out.println("Método excluir MarcaDAOImpl ainda não implementado.");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Marca buscarPorId(int id) throws Exception {
        // TODO: Implementar lógica SQL para SELECT por ID
        System.out.println("Método buscarPorId MarcaDAOImpl ainda não implementado.");
        // Retornar null ou um objeto Marca vazio temporariamente se necessário para compilar
        // return null;
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Marca> listarTodas() throws Exception {
        // TODO: Implementar lógica SQL para SELECT *
        System.out.println("Método listarTodas MarcaDAOImpl ainda não implementado.");
        // Retornar lista vazia temporariamente se necessário para compilar
        // return new ArrayList<>();
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Marca> buscarPorNome(String nome) throws Exception {
        // TODO: Implementar lógica SQL para SELECT por nome (LIKE)
        System.out.println("Método buscarPorNome MarcaDAOImpl ainda não implementado.");
        // return new ArrayList<>();
         throw new UnsupportedOperationException("Not supported yet.");
    }
}

