package modelo;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double precoVenda;
    private int quantidadeEstoque;
    private Categoria categoria;
    private Marca marca;
    private Fornecedor fornecedorPadrao; // Pode ser nulo

    // Construtor padrão
    public Produto() {
    }

    // Construtor com parâmetros (exemplo)
    public Produto(int id, String nome, String descricao, double precoVenda, int quantidadeEstoque,
                   Categoria categoria, Marca marca, Fornecedor fornecedorPadrao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
        this.marca = marca;
        this.fornecedorPadrao = fornecedorPadrao;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Fornecedor getFornecedorPadrao() {
        return fornecedorPadrao;
    }

    public void setFornecedorPadrao(Fornecedor fornecedorPadrao) {
        this.fornecedorPadrao = fornecedorPadrao;
    }

    @Override
    public String toString() {
        return nome;
    }

    // Implementar equals() e hashCode() se necessário
}

