package modelo;

// Adicione "implements SimpleModel" aqui
public class Marca implements SimpleModel {
    private int id;
    private String nome;

    // Construtor padrão (necessário para TelaGerenciarSimples)
    public Marca() {
    }

    // Construtor com parâmetros (opcional)
    public Marca(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // --- Métodos da interface SimpleModel --- 
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    // --- Fim dos métodos da interface ---
    
    // toString é útil para ComboBoxes e listas
    @Override
    public String toString() {
        return nome != null ? nome : ""; 
    }
    
    // Implementar equals() e hashCode() é uma boa prática se usar Marcas em Coleções (Set, Map)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return id == marca.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
