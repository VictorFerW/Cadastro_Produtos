package modelo;

public class Categoria {
    private int id;
    private String nome;

    // Construtor padrão
    public Categoria() {
    }

    // Construtor com parâmetros
    public Categoria(int id, String nome) {
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
        // Útil para exibir em ComboBoxes
        return nome;
    }

    // Implementar equals() e hashCode() se for usar coleções como HashSet/HashMap
}

