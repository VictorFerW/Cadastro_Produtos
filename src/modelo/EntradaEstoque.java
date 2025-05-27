package modelo;

import java.util.Date;

public class EntradaEstoque {
    private int id;
    private Produto produto;
    private Fornecedor fornecedor;
    private Date dataEntrada;
    private int quantidade;
    private double precoCustoUnitario;
    private String notaFiscal;

    // Construtor padrão
    public EntradaEstoque() {
    }

    // Construtor com parâmetros
    public EntradaEstoque(int id, Produto produto, Fornecedor fornecedor, Date dataEntrada,
                          int quantidade, double precoCustoUnitario, String notaFiscal) {
        this.id = id;
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.dataEntrada = dataEntrada;
        this.quantidade = quantidade;
        this.precoCustoUnitario = precoCustoUnitario;
        this.notaFiscal = notaFiscal;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoCustoUnitario() {
        return precoCustoUnitario;
    }

    public void setPrecoCustoUnitario(double precoCustoUnitario) {
        this.precoCustoUnitario = precoCustoUnitario;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    // toString(), equals(), hashCode() conforme necessário
}

