package modelo;

public class Marca {
    private int id;
    private String nome;

    // Construtor padrão
    public Marca() {
    }

    // Construtor com parâmetros
    public Marca(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return nome;
    }

    // Implementar equals() e hashCode() se necessário
}

